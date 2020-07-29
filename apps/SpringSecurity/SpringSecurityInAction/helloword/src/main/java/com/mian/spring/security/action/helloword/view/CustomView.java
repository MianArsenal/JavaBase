package com.mian.spring.security.action.helloword.view;

import org.apache.commons.io.IOUtils;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CustomView implements View {

    private final String viewName;

    public CustomView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/html");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(htmlWithToken(httpServletRequest));
        writer.flush();
    }

    private String htmlWithToken(HttpServletRequest httpServletRequest) throws IOException {
        System.out.println(viewName);
        String html = IOUtils.toString(
                getClass().getResourceAsStream("/static/" + viewName + ".html"),
                StandardCharsets.UTF_8);
        CsrfToken csrfToken = (CsrfToken) httpServletRequest.getAttribute(CsrfToken.class.getName());
        return html.replace(
                "current_csrf_code",
                csrfToken.getToken());
    }
}
