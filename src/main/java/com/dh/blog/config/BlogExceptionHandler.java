package com.dh.blog.config;

import com.dh.blog.entity.Blog;
import com.dh.blog.entity.User;
import com.dh.blog.exception.BlogException;
import com.dh.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${blog.default.id}")
    private String blogDefaultId;

    @Autowired
    private BlogService blogService;

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
        Object user = session.getAttribute(Constant.LOGIN_SESSION_KEY);
        Object blog = session.getAttribute(Constant.BLOG_SESSION_KEY);
        if (Objects.nonNull(user)) {
            model.put(Constant.LOGIN_SESSION_KEY, (User)user);
        }
        if (Objects.isNull(blog)) {
            Blog _blog = blogService.getById(blogDefaultId).getBody();
            session.setAttribute(Constant.BLOG_SESSION_KEY, _blog);
            model.put(Constant.BLOG_SESSION_KEY, _blog);
            return;
        }
        model.put(Constant.BLOG_SESSION_KEY, (Blog)blog);
    }
}
