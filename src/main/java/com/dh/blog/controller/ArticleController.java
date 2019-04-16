package com.dh.blog.controller;

import com.dh.blog.entity.Article;
import com.dh.blog.entity.Blog;
import com.dh.blog.entity.User;
import com.dh.blog.service.ArticleService;
import com.dh.blog.util.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章控制器
 *      1、添加文章
 *      2、更新文章
 *      3、删除文章
 *      4、查询文章列表
 *      5、
 *
 * @author donghao
 * @date 2019/1/25
 */
@Slf4j
@Controller
@Validated
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 后台--添加文章
    @PostMapping("/add")
    public BaseResponse<Integer> add(@Validated final Article article, User _user) {
        return articleService.add(article, _user);
    }

    // 后台--更新文章
    @PutMapping("/update")
    public BaseResponse<Integer> update(@Validated final Article article, User _user) {
        return articleService.update(article, _user);
    }

    // 前台--获取文章详情
    @GetMapping("/getById")
    public String getById(final String id, ModelMap model) {
        model.put("result", articleService.getById(id));
        return "";
    }

    // 前台--分页获取文章列表
    @GetMapping("/getByPage")
    public String getByPage(final int pageId, final int pageSize, Blog _blog, ModelMap model) {
        model.put("result", articleService.getByPage(pageId, pageSize, _blog));
        return "";
    }

    // 后台--分页获取文章列表，指定用户
    @GetMapping("/getByPageAndUser")
    public String getByPageAndUser(final int pageId, final int pageSize, Blog _blog, User _user, ModelMap model) {
        model.put("result", articleService.getByPageAndUser(pageId, pageSize, _blog, _user));
        return "";
    }



}
