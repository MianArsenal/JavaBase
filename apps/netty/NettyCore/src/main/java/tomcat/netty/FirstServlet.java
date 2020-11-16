package tomcat.netty;

public class FirstServlet extends GPServlet {
    @Override
    protected void doGet(GPRequest request, GPResponse response) throws Exception {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(GPRequest request, GPResponse response) throws Exception {
        response.write("this is first servlet!");
    }
}
