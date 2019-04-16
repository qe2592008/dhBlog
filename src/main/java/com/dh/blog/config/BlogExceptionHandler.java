package com.dh.blog.config;

import com.dh.blog.entity.User;
import com.dh.blog.exception.BlogException;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 博客异常处理器
 *
 * @author donghao
 * @date 2019/1/4
 */
@ControllerAdvice
public class BlogExceptionHandler {

    // 目的是为了统一处理指定异常
    @ExceptionHandler(BlogException.class)
    public ModelAndView BlogExceptionHandler(BlogException be) {
        ModelAndView modelAndView = new ModelAndView("404");///templates/blog/view/error
        modelAndView.addObject("code",be.getCode());
        modelAndView.addObject("info", be.getInfo());
        return modelAndView;
    }

    @InitBinder
    public void intiBinder(WebDataBinder binder) {
        binder.getValidators();
    }
    // 目的是提前将用户的登录session放到Model中，这种方式不好之处在于
    // 无论页面是否需要用户数据，都会携带，当然也可以在返回之前将其清除。
    @ModelAttribute
    public void initModel (ModelMap model, HttpSession session) {
        Object obj = session.getAttribute(Constant.LOGIN_SESSION_KEY);
        User user = Objects.nonNull(obj) ? (User)obj : null;
        model.put("_user", user);
        model.put("test","testString");
    }
}
