package tomcat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GPTomcat {

    private int port = 8081;
    private Map<String, GPServlet> servletMap = new HashMap<>();
    private Properties webXml = new Properties();

    private void init() {
        try {
            String filePath = this.getClass().getClassLoader().getResource("test/web_netty.properties").getFile();
            FileInputStream fileInputStream = new FileInputStream(filePath);

            webXml.load(fileInputStream);
            for (Object k :
                    webXml.keySet()) {
                String key = k.toString();
                if (key.endsWith(".url")) {
                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webXml.getProperty(key);
                    String className = webXml.getProperty(servletName + ".className");
                    GPServlet obj = (GPServlet) Class.forName(className).newInstance();
                    servletMap.put(url, obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        init();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel client) throws Exception {
                            client.pipeline().addLast(new HttpResponseEncoder());
                            client.pipeline().addLast(new HttpRequestDecoder());
                            client.pipeline().addLast(new GPTomcatHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = server.bind(port).sync();
            System.out.println("GPTomcat start...");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class GPTomcatHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof HttpRequest) {
                System.out.println("hello");
                HttpRequest request = (HttpRequest) msg;
                GPRequest gpRequest = new GPRequest(ctx, request);
                GPResponse gpResponse = new GPResponse(ctx, request);
                String url = gpRequest.getUrl();
                if (servletMap.containsKey(url)) {
                    servletMap.get(url).service(gpRequest, gpResponse);
                } else {
                    gpResponse.write("404 - Not Found");
                }
            }
        }
    }

    public static void main(String[] args) {
        new GPTomcat().start();
    }
}
