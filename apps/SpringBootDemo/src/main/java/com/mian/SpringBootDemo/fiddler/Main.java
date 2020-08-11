package com.mian.SpringBootDemo.fiddler;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
//    public static final String HOST = "http://qa1acz.cargosmart.com";
    public static final String HOST = "http://mihe-w10.corp.oocl.com:7001";
    public static final String LOGIN_URL = "/admin/coscon/shippinginstruction/si_creation.jsf?ENTRY_TYPE=COSCON&ENTRY=MCC&COSCON_USERID=cosconcus2&COSCON_TOKEN=e77e51ce-35a3-4541-a7a9-35a645bb1556&PREFER_LANGUAGE=en-US&domainName=SHIPPING_INSTRUCTION_DOMAIN";
    public static final String CREATE_URL = "/shippinginstruction/shippinginstruction/si_submit_confirm.jsf?&USER_TOKEN=QUcjuzZENJYPjvLuECgUMCCCOSCON&ENTRY=MCC&ENTRY_TYPE=COSCON&PREFER_LANGUAGE=en-US&OPERATOR_USER_ID=cosconcus2";
    public static final String CREATE_URL1 = "/shippinginstruction/shippinginstruction/si_submit_confirm.jsf?&USER_TOKEN=QUcjuzZENJYPjvLuECgUMCCCOSCON&ENTRY=MCC&ENTRY_TYPE=COSCON&PREFER_LANGUAGE=en-US&OPERATOR_USER_ID=cosconcus2&form:uncheck_duplication_submission=true";
    public static final String VALIDATE = "/shippinginstruction/shippinginstruction/si_creation.jsf?&USER_TOKEN=HCHFHMCyTQsysNhhCpVYMCCCOSCON&ENTRY=MCC&ENTRY_TYPE=COSCON&PREFER_LANGUAGE=en-US&OPERATOR_USER_ID=cosconcus2&form:uncheck_duplication_submission=true";
    public static final String VALIDATE1 = "/shippinginstruction/shippinginstruction/si_creation.jsf?";
    public static final String SUBMIT = "/shippinginstruction/shippinginstruction/si_submit_confirm.jsf?";

    public static void main(String[] args) throws Exception {

    //        CloseableHttpClient client = HttpClients.createDefault();
        DefaultHttpClient client = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();
        HttpGet httpGet0 = new HttpGet(HOST + LOGIN_URL);
        HttpResponse loginResponse = client.execute(httpGet0, httpContext);

        HttpHost targetHost = (HttpHost)httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
        HttpUriRequest realRequest = (HttpUriRequest)httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
        HttpEntity entity = loginResponse.getEntity();
        String siCreatePage = EntityUtils.toString(loginResponse.getEntity());
        String userToken = siCreatePage.substring(siCreatePage.indexOf("USER_TOKEN=") + 11, siCreatePage.indexOf("USER_TOKEN=") + 40);
        String jsessionid = siCreatePage.substring(siCreatePage.indexOf("jsessionid=") + 11, siCreatePage.indexOf("jsessionid=") + 73);


        //请求地址
        Map<String, String> headMap = getHeaderMap(loginResponse, client);


        doMultipartFormDataPost(client,
                HOST + VALIDATE1 + realRequest.getURI().getQuery(),
                getFileString(new File("C:\\Users\\mihe\\Desktop\\BLT\\fiddler\\nofile.htm"), userToken, null),
                headMap,
                true,
                userToken);
    }

    private static Map<String, String> getHeaderMap(HttpResponse loginResponse, CloseableHttpClient client) {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryjuKBATq2TTFBSxkW");
        headMap.put("Connection", "keep-alive");
        headMap.put("Cache-Control", "max-age=0");
        headMap.put("Upgrade-Insecure-Requests", "1");
        headMap.put("Origin", "http://qa1acz.cargosmart.com");
        headMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
        headMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        Header[] allSetCookies = loginResponse.getHeaders("Set-Cookie");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < allSetCookies.length; i++) {
            sb.append(allSetCookies[i].getValue().split(";")[0]);
            if (i != allSetCookies.length -1) {
                sb.append("; ");
            }
        }
        headMap.put("Cookie", sb.toString());
        return headMap;
    }

    private static Map<String, String> getHeaderMap1(HttpResponse loginResponse, CloseableHttpClient client) {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryrHy2BpqZBZ7n3qkA");
        headMap.put("Connection", "keep-alive");
        headMap.put("Cache-Control", "max-age=0");
        headMap.put("Upgrade-Insecure-Requests", "1");
        headMap.put("Origin", "http://qa1acz.cargosmart.com");
        headMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
        headMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        Header[] allSetCookies = loginResponse.getHeaders("Set-Cookie");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < allSetCookies.length; i++) {
            sb.append(allSetCookies[i].getValue().split(";")[0]);
            if (i != allSetCookies.length -1) {
                sb.append("; ");
            }
        }
        headMap.put("Cookie", sb.toString());
        return headMap;
    }

    public static void doMultipartFormDataPost(DefaultHttpClient client, String url, String param, Map<String, String> headParam, boolean isValidate, String userToken) {
        // TODO Auto-generated method stub

        // 创建Httpclient对象
        Map<String, Object> resultMap = new HashMap<>();
        String resultString;
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.setCookieStore(client.getCookieStore());
       HttpResponse response;
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(param, ContentType.MULTIPART_FORM_DATA);
            httpPost.setEntity(entity);
            for (String key : headParam.keySet()) {
                httpPost.addHeader(key, headParam.get(key));
            }
            HttpContext httpContext = new BasicHttpContext();
            response = httpClient.execute(httpPost, httpContext);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            HttpHost targetHost = (HttpHost)httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
            HttpUriRequest realRequest = (HttpUriRequest)httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
            Map<String, String> headMap = getHeaderMap(response, client);
            String submissionToken = resultString.substring(resultString.indexOf("id=\"submissionToken\" value=\"") + 28, resultString.indexOf("id=\"submissionToken\" value=\"") + 41);
            if (isValidate) {
                doMultipartFormDataPost(client,
                        HOST + SUBMIT + realRequest.getURI().getQuery() + "&form:uncheck_duplication_submission=true",
                        getFileString(new File("C:\\Users\\mihe\\Desktop\\BLT\\fiddler\\submit.htm"), userToken, submissionToken),
                        headMap,
                        false,
                        userToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

    public static String getFileString(File file, String userToken, String submissionToken) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                if (s.contains("USER_TOKEN_XXXXXXXX")) {
                    s = s.replace("USER_TOKEN_XXXXXXXX", userToken);
                }
                if (s.contains("submissionToken_XXXX")) {
                    s = s.replace("", submissionToken);
                }
                result.append(System.lineSeparator()).append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
