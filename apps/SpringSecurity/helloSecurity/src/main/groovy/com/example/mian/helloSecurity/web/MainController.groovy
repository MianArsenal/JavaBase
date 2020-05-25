package com.example.mian.helloSecurity.web

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@Controller
class MainController {

    @RequestMapping("/")
    String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    String index() {
        return "index";
    }

    @RequestMapping("/user/index")
    String userIndex() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.isUserInRole("")
        request.getRemoteUser()
        HttpSession session = request.getSession();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
        } else {
            String username = principal.toString();
        }

        return "user/index";
    }

    @RequestMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }


}
