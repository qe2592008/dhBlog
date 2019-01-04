package com.dh.blog.controller;

import com.dh.blog.service.UserService;
import com.dh.blog.util.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    // 登录，管理员和评论者，前者可登陆，后者不能登录，前者可发布文章，可创建博客，可创建分类和关键字，这个分类和关键字分属于某个博客
    // 首页提供登录入口
    public String login() {

        return "";
    }
    // 退出登录，跳转到博客首页
    // 添加用户，只有超级管理员可以添加新用户，另外就是评论的时候会将评论者自动添加到用户表中。
    // 更新用户，自己可以更新自己，超级管理员可以更新所有
    // 删除用户，自己不能删除自己，超级管理员可删除管理员和评论者
    // 获取单个用户信息，查询自己的用户信息，超级管理员可获取所有用户的个人信息
    
}
