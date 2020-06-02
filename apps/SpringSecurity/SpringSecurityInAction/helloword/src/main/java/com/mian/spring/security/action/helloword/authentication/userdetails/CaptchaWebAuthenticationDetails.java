package com.mian.spring.security.action.helloword.authentication.userdetails;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CaptchaWebAuthenticationDetails extends WebAuthenticationDetails {

    private boolean imageCodeIsRight;

    public CaptchaWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        String imageCode = request.getParameter("captcha");
        HttpSession httpSession = request.getSession();
        String imageCodeInSession = (String) httpSession.getAttribute("captcha");
        if (!StringUtils.isEmpty(imageCodeInSession)) {
            httpSession.removeAttribute("captcha");
            if (imageCodeInSession.equals(imageCode)) {
                this.imageCodeIsRight = true;
            }
        }
    }

    public boolean isImageCodeIsRight() {
        return imageCodeIsRight;
    }
}
