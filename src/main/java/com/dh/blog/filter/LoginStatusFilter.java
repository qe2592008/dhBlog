package com.dh.blog.filter;

import com.dh.blog.config.Constant;
import com.dh.blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Objects;

@Slf4j
public class LoginStatusFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        log.info("登录状态拦截，请求路径为：uri={}", request.getRequestURI());
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(Constant.LOGIN_SESSION_KEY);
        if(Objects.nonNull(obj)) {
            User user = (User)obj;
            log.info("用户已登录，userId={}", user.getId());
            return true;
        }
        response.setCharacterEncoding("GBK");
        response.getWriter().write("你被拒绝了");
        return false;
    }

}
