package com.dh.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.blog.entity.Blog;
import com.dh.blog.entity.User;
import com.dh.blog.service.BlogService;
import com.dh.blog.util.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@Validated
@RequestMapping("/blog")
public class BlogController extends BaseController {

    @Autowired
    private BlogService blogService;

    /**
     * 不需要添加博客功能，因为只有一个博客
     *
     * @author donghao
     * @date 2019/1/4
     */
    @Deprecated
    @PostMapping()
    public BaseResponse<Integer> add(@Validated final Blog blog, User _user) {
        log.info("开始执行添加博客操作，博客基本信息为：{}", blog.toString());
        return blogService.add(blog, _user);
    }

    @PutMapping()
    public BaseResponse<Integer> update(@Validated final Blog blog, User _user) {
        log.info("开始执行更新博客操作，博客最新信息为：{}", blog.toString());
        return blogService.update(blog, _user);
//        model.put("","");
//        return "";
    }

    @GetMapping("/{blogId}")
    public BaseResponse<Blog> getBlog(
            @NotNull(message = "博客ID不能为null") @PathVariable final String blogId, User _user) {
        log.info("开始执行查找指定博客操作，博客ID：{}", blogId);
        BaseResponse<Blog> response = blogService.getById(blogId);
        if(_user != null
                && response.getSuccess()
                && _user.getId().equals(response.getBody().getManagerId())) {
            return response;
        }
        log.warn("执行查找博客操作失败，博客ID：{}", blogId);
        return BaseResponse.builder().success(false).build();
    }

    /**
     * 不需要分页获取博客列表，只有一个博客
     *
     * @author donghao
     * @date 2019/1/4
     */
    @Deprecated
    @GetMapping("/blogs")
    public BaseResponse<Page<Blog>> blogs(@RequestParam final int pageId, @RequestParam final int pageSize) {
        log.info("开始执行分页查找所有博客操作，分页参数为：pageId={}，pageSize={}", pageId, pageSize);
        return blogService.getPageList(pageId, pageSize);
    }

    /**
     * 不需要分页获取博客列表，只有一个博客
     *
     * @author donghao
     * @date 2019/1/4
     */
    @Deprecated
    @GetMapping("/blogs")
    public BaseResponse<Page<Blog>> blogs(
            @RequestParam final int pageId, @RequestParam final int pageSize, User _user) {
        log.info("开始执行分页查找指定管理员博客操作，分页参数为：pageId={}，pageSize={}", pageId, pageSize);
        return blogService.getPageList(_user, pageId, pageSize);
    }

    /**
     * 不需要删除博客功能，因为只有一个博客
     *
     * @author donghao
     * @date 2019/1/4
     */
    @Deprecated
    @DeleteMapping("/{blogId}")
    public BaseResponse<Integer> delete(@PathVariable final String blogId, User _user) {
        log.info("开始执行删除指定博客操作，博客ID：{}", blogId);
        BaseResponse<Blog> response = blogService.getById(blogId);
        if(_user != null
                && response.getSuccess()
                && _user.getId().equals(response.getBody().getManagerId())) {
            return blogService.delete(blogId);
        }
        log.warn("执行删除博客操作失败，博客ID：{}", blogId);
        return BaseResponse.builder().success(false).build();
    }

}
