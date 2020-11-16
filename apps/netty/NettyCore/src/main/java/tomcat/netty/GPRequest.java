package tomcat.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class GPRequest {

    private ChannelHandlerContext context;
    private HttpRequest request;

    public GPRequest(ChannelHandlerContext context, HttpRequest request) {
        this.context = context;
        this.request = request;
    }

    public String getUrl() {
        return this.request.getUri();
    }

    public String getMethod() {
        return this.request.method().name();
    }

    public Map<String, List<String>> getParameters() {
        QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
        return decoder.parameters();
    }

    public String getParameter(String name) {
        Map<String, List<String>> params = getParameters();
        List<String> param = params.get(name);
        return null == param ? null : param.get(0);
    }
}
