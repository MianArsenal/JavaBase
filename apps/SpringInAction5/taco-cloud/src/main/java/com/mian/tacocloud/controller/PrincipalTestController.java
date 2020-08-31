package com.mian.tacocloud.controller;

import com.mian.tacocloud.domain.CustomUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/principal")
public class PrincipalTestController {

    @RequestMapping("/0")
    public String getPrincipal(Principal principal) {
        PrincipalTestController.log.info(principal.toString());
        return principal.getName();
    }

    @RequestMapping("/1")
    public String getPrincipal(Authentication authentication) {
        CustomUser customUser = (CustomUser)authentication.getPrincipal();
        PrincipalTestController.log.info(customUser.getUsername());
        return customUser.getUsername();
    }

    @RequestMapping("/2")
    public String getPrincipal(@AuthenticationPrincipal CustomUser user) {
        PrincipalTestController.log.info(user.getUsername());
        return user.getUsername();
    }

    @RequestMapping("/3")
    public String getPrincipal() {
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PrincipalTestController.log.info(customUser.toString());
        return customUser.getUsername();
    }
}
