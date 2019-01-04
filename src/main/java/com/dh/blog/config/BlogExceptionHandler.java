package com.dh.blog.config;

import com.dh.blog.exception.BlogException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 博客异常处理器
 *
 * @author donghao
 * @date 2019/1/4
 */
@Slf4j
@Component
public class BlogExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long start = System.currentTimeMillis();
        ModelAndView mav = null;
        if(ex != null){
            log.info(ex.getMessage(), ex);
            if (handler instanceof HandlerMethod) {
                mav = new ModelAndView();
                HandlerMethod hm = (HandlerMethod) handler;
                ResponseBody rb = hm.getMethodAnnotation(ResponseBody.class);
//                String currPage = request.getHeader("Referer");
                if (!(rb instanceof ResponseBody)) {
                    String view = hm.getMethod().getName();
                    mav.setViewName(view);
                    if (ex instanceof BlogException) {
                        BlogException be = (BlogException)ex;
                        mav.addObject("ex", be);
                        mav.setViewName(Constant.APP_ERROR_PAGE);
                    } else {
                        mav.addObject("ex", ex);
                        mav.setViewName(Constant.SYSTEM_ERROR_PAGE);
                    }
                } else {
                    ToJson(response, ex);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("处理错误异常信息耗时：" + (end - start) + "毫秒。");
        return mav;
    }

    private void ToJson(HttpServletResponse response, Exception ex) {
        // 将实体对象转换为JSON
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = null;
        String jsonString = null;
        try {
            out = response.getWriter();
            if (!(ex instanceof BlogException)) {
                BlogException exception = new BlogException("", "系统出现异常!!!");
                jsonString = mapper.writeValueAsString(exception);
            } else {
                jsonString = mapper.writeValueAsString(ex);
            }
            out.append(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
