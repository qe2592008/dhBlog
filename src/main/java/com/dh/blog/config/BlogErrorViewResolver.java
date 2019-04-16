package com.dh.blog.config;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

// TODO 需要校验是否能成功，是否影响error.ftl错误页面
//@Component
public class BlogErrorViewResolver implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        String errorViewName = "templates/blog/view/error" + String.valueOf(status.value());
        return new ModelAndView(errorViewName, model);
    }

}
