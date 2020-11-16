package tomcat.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

public class GPResponse {

    private ChannelHandlerContext context;
    private HttpRequest request;

    public GPResponse(ChannelHandlerContext context, HttpRequest request) {
        this.context = context;
        this.request = request;
    }

    public void write(String out) throws Exception {
        try {
            if (out == null || out.length() == 0) {
                return;
            }
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(out.getBytes("UTF-8")));
            response.headers().set("Content-Type", "text/html");
            context.write(response);
        } finally {
            context.flush();
            context.close();
        }
    }
}
