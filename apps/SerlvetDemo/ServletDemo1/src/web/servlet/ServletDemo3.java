package web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo3")
//@WebServlet(value = "/demo3") //单个值时value表示urlPatterns
//@WebServlet(urlPatterns = "/demo3")
public class ServletDemo3 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet annotation!");
        String name = servletRequest.getParameter("name");
        servletResponse.setContentType("text/html; charset=UTF-8");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        outputStream.write((name + " connect to servlet annotation!").getBytes());
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
