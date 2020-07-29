package com.mian.spring.security.action.helloword.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class CustomViewResolver implements ViewResolver {

    private ConcurrentHashMap<String, View> viewMap = new ConcurrentHashMap<>();

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return viewMap.computeIfAbsent(s, CustomView::new);
    }
}
