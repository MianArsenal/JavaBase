package com.mian.SpringBootDemo.fiddler;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main4 {

    public static final String HOST = "http://qa1acz.cargosmart.com";
    public static final String HOST_WITHOUT_PROTOCOL = "qa1acz.cargosmart.com";
    //    public static final String HOST = "http://mihe-w10.corp.oocl.com:7001";
    public static final String LOGIN_URL = "/admin/coscon/shippinginstruction/si_creation.jsf?ENTRY_TYPE=COSCON&ENTRY=MCC&COSCON_USERID=cosconcus2&COSCON_TOKEN=e77e51ce-35a3-4541-a7a9-35a645bb1556&PREFER_LANGUAGE=en-US&domainName=SHIPPING_INSTRUCTION_DOMAIN";
    public static final String CREATE_URL = "/shippinginstruction/shippinginstruction/si_submit_confirm.jsf?&USER_TOKEN=QUcjuzZENJYPjvLuECgUMCCCOSCON&ENTRY=MCC&ENTRY_TYPE=COSCON&PREFER_LANGUAGE=en-US&OPERATOR_USER_ID=cosconcus2";
    public static final String CREATE_URL1 = "/shippinginstruction/shippinginstruction/si_submit_confirm.jsf?&USER_TOKEN=QUcjuzZENJYPjvLuECgUMCCCOSCON&ENTRY=MCC&ENTRY_TYPE=COSCON&PREFER_LANGUAGE=en-US&OPERATOR_USER_ID=cosconcus2&form:uncheck_duplication_submission=true";
    public static final String VALIDATE = "/shippinginstruction/shippinginstruction/si_creation.jsf?&USER_TOKEN=HCHFHMCyTQsysNhhCpVYMCCCOSCON&ENTRY=MCC&ENTRY_TYPE=COSCON&PREFER_LANGUAGE=en-US&OPERATOR_USER_ID=cosconcus2&form:uncheck_duplication_submission=true";
    public static final String VALIDATE1 = "/shippinginstruction/shippinginstruction/si_creation.jsf?";
    public static final String VALIDATE2 = "/shippinginstruction/shippinginstruction/si_creation.jsf?ENTRY=MCC&ENTRY_TYPE=COSCON&PREFER_LANGUAGE=en-US&OPERATOR_USER_ID=cosconcus2&USER_TOKEN=";
    public static final String SUBMIT = "/shippinginstruction/shippinginstruction/si_submit_confirm.jsf?";

    public static void main(String[] args) throws Exception {
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyPort", "8888");

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

        HttpPost httpPost = new HttpPost(HOST + VALIDATE1 +
                "&USER_TOKEN=" + userToken + "&ENTRY=MCC&ENTRY_TYPE=COSCON&PREFER_LANGUAGE=en-US&OPERATOR_USER_ID=cosconcus2");
        setValidatePostHeader(httpPost, realRequest, loginResponse);
        setValidatePostEntity(httpPost, userToken, null);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpContext httpContext1 = new BasicHttpContext();
        CloseableHttpResponse response = httpClient.execute(httpPost, httpContext1);
        String resultString1 = EntityUtils.toString(response.getEntity(), "utf-8");
        HttpHost targetHost1 = (HttpHost)httpContext1.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
        HttpUriRequest realRequest1 = (HttpUriRequest)httpContext1.getAttribute(ExecutionContext.HTTP_REQUEST);

    }

    private static void setValidatePostEntity(HttpPost httpPost, String userToken, String submissionToken) {
        StringEntity entity = new StringEntity(
                getFileString(new File("C:\\Users\\mihe\\Desktop\\BLT\\fiddler\\nofile.htm"),
                        userToken,
                        submissionToken),
                ContentType.MULTIPART_FORM_DATA);
        httpPost.setEntity(entity);
    }

    private static void setValidatePostHeader(HttpPost httpPost, HttpUriRequest realRequest, HttpResponse loginResponse) {
        httpPost.setHeader("Host", HOST_WITHOUT_PROTOCOL);
        httpPost.setHeader("Connection", "keep-alive");
//        httpPost.setHeader("Content-Length", "52895");
        httpPost.setHeader("Cache-Control", "max-age=0");
        httpPost.setHeader("Upgrade-Insecure-Requests", "1");
        httpPost.setHeader("Origin", HOST);
        httpPost.setHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryjuKBATq2TTFBSxkW");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
        httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPost.setHeader("Referer", HOST + realRequest.getURI().getPath()+ "?" + realRequest.getURI().getQuery());
//        httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.setHeader("Accept-Language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7,en-GB;q=0.6");
        StringBuilder sb = new StringBuilder();
        Header[] allSetCookies = loginResponse.getHeaders("Set-Cookie");
        for (int i = 0; i < allSetCookies.length; i++) {
            sb.append(allSetCookies[i].getValue().split(";")[0]);
            if (i != allSetCookies.length -1) {
                sb.append("; ");
            }
        }
        httpPost.setHeader("Cookie", sb.toString());
    }

    private static String getFileString(File file, String userToken, String submissionToken) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                if (s.contains("USER_TOKEN_XXXXXXXX")) {
                    s = s.replace("USER_TOKEN_XXXXXXXX", userToken);
                }
                if (s.contains("submissionToken_XXXX")) {
                    s = s.replace("submissionToken_XXXX", submissionToken);
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
