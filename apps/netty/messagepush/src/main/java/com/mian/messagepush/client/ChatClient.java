package com.mian.messagepush.client;

import com.mian.messagepush.handler.ChatClientHandler;
import com.mian.messagepush.protocol.IMDecoder;
import com.mian.messagepush.protocol.IMEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {

    private ChatClientHandler clientHandler;
    private String host;
    private int port;

    public ChatClient(String nickname) {
        this.clientHandler = new ChatClientHandler(nickname);
    }

    public void connect(String host, int port) {
        this.host = host;
        this.port = port;

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new IMDecoder());
                    socketChannel.pipeline().addLast(new IMEncoder());
                    socketChannel.pipeline().addLast(clientHandler);
                }
            });
            ChannelFuture future = bootstrap.connect(this.host, this.port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChatClient("Cover").connect("127.0.0.1", 8082);
        String url = "http://localhost:8081/images/a.png";
        System.out.println(url.toLowerCase().matches(".*\\.(gif|png|jpg)$"));
    }
}
