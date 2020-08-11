package com.mian.SpringBootDemo.fiddler;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class Main2 {

    public static void main(String[] args) throws Exception {
        HttpPost httpPost = new HttpPost("http://localhost:8181/JSF_HelloWorld_war_exploded/faces/hello.xhtml");
        httpPost.addHeader("Host", "localhost:8181");
        httpPost.addHeader("Connection", "keep-alive");
//        httpPost.addHeader("Content-Length", "126");
        httpPost.addHeader("Cache-Control", "max-age=0");
        httpPost.addHeader("Origin", "http://localhost:8181");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
        httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPost.addHeader("Sec-Fetch-Site", "same-origin");
        httpPost.addHeader("Sec-Fetch-Mode", "navigate");
        httpPost.addHeader("Sec-Fetch-User", "?1");
        httpPost.addHeader("Sec-Fetch-Dest", "document");
        httpPost.addHeader("Referer", "http://localhost:8181/JSF_HelloWorld_war_exploded/");
        httpPost.addHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.addHeader("Accept-Language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7,en-GB;q=0.6");
        httpPost.addHeader("Cookie", "JSESSIONID=6C7CD8F71B5F320A120E1D27603966EB");

        StringEntity entity = new StringEntity("j_idt8=j_idt8&j_idt8%3Aj_idt9=mian&j_idt8%3Aj_idt10=Welcome+Me&javax.faces.ViewState=6957001616734245819%3A5266066876095065538", ContentType.MULTIPART_FORM_DATA);
        httpPost.setEntity(entity);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();
        CloseableHttpResponse response = httpClient.execute(httpPost, httpContext);
        String resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        HttpHost targetHost = (HttpHost)httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
        HttpUriRequest realRequest = (HttpUriRequest)httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
    }
}
