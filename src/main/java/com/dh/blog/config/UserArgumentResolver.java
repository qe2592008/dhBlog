package com.dh.blog.config;

import com.dh.blog.entity.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;

/**
 * 注入登录用户参数
 *
 * @author donghao
 * @date 2019/1/4
 */
public class UserArgumentResolver implements WebArgumentResolver {
    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        if(methodParameter.getParameterType().equals(User.class)){
            return webRequest.getAttribute(Constant.LOGIN_SESSION_KEY, RequestAttributes.SCOPE_SESSION);
        }
        return UNRESOLVED;
    }
}
