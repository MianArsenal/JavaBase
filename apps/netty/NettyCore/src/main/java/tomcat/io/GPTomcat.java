package tomcat.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GPTomcat {

    private int port = 8081;
    private ServerSocket server;

    private Map<String, GPServlet> servletMap = new HashMap<>();
    private Properties webXml = new Properties();

    private void init() {
        try {
            String filePath = this.getClass().getClassLoader().getResource("test/web_io.properties").getFile();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            webXml.load(fileInputStream);
            for (Object k :
                    webXml.keySet()) {
                String key = k.toString();
                if (key.endsWith(".url")) {
                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webXml.getProperty(key);
                    String className = webXml.getProperty(servletName + ".className");

                    //单实例，多线程
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

        try {
            server = new ServerSocket(this.port);
            System.out.println("GPTomcat start...");

            while (true) {
                Socket client = server.accept();
                process(client);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(Socket client) throws Exception {
        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();

        GPRequest request = new GPRequest(inputStream);
        GPResponse response = new GPResponse(outputStream);

        String url = request.getUrl();

        if (servletMap.containsKey(url)) {
            servletMap.get(url).service(request, response);
        } else {
            response.write("404 - Not Found");
        }

        outputStream.flush();
        outputStream.close();

        inputStream.close();
        client.close();
    }


    public static void main(String[] args) {
        new GPTomcat().start();
    }

}
