package com.mian.messagepush.server;

import com.mian.messagepush.handler.HttpServerHandler;
import com.mian.messagepush.handler.TerminalServerHandler;
import com.mian.messagepush.handler.WebSocketServerHandler;
import com.mian.messagepush.protocol.IMDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatServer {

    private int port = 8081;

    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();

                            pipeline.addLast(new IMDecoder());
                            pipeline.addLast(new IMDecoder());
                            pipeline.addLast(new TerminalServerHandler());

                            pipeline.addLast(new HttpServerCodec());

                            pipeline.addLast(new HttpObjectAggregator(64 * 1024));

                            pipeline.addLast(new ChunkedWriteHandler());
                            pipeline.addLast(new HttpServerHandler());

                            pipeline.addLast(new WebSocketServerProtocolHandler("/im"));

                            pipeline.addLast(new WebSocketServerHandler());
                        }
                    });
            ChannelFuture future = bootstrap.bind(this.port).sync();
            log.info("server start at port : " + this.port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChatServer().start();
    }

}

