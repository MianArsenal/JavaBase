package tomcat.io;

import java.io.IOException;

public class SecondServlet extends GPServlet{
    @Override
    protected void doGet(GPRequest request, GPResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(GPRequest request, GPResponse response) throws IOException {
        response.write("this is second servlet!");
    }
}
