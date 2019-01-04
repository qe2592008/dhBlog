package com.dh.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.blog.entity.Blog;
import com.dh.blog.entity.User;
import com.dh.blog.exception.BlogException;
import com.dh.blog.repository.BlogRepository;
import com.dh.blog.util.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
public class BlogService extends BaseService {

    @Autowired
    private BlogRepository blogRepository;

    @Deprecated
    @Caching(
        evict = {
            @CacheEvict(value = "blogPageByUser", beforeInvocation = true, allEntries = true),
            @CacheEvict(value = "blogPage", beforeInvocation = true, allEntries = true)// 清除blogPage中的所有缓存
        }
    )
    public BaseResponse<Integer> addBlog(final Blog blog, final User user) {
        initBlog(blog, user);
        int insertNum = 0;
        try {
            insertNum = blogRepository.insert(blog);
        } catch(Exception e) {
            log.warn("添加新博客发生异常，博客信息为：{}", blog.toString(), e);
            throw new BlogException("addBlogException", "添加新博客发生异常", e);
        }
        if(insertNum < 1) {
            log.warn("添加新博客失败，博客信息为：{}", blog.toString());
            throw new BlogException("addBlogFailure", "添加新博客失败");
        }
        return BaseResponse.builder()
                .body(insertNum)
                .success(true).build();
    }

    @Caching(
        put = @CachePut(value = "blog", key = "#blog.id"),
        evict = {
            @CacheEvict(value = "blogPageByUser", beforeInvocation = true, allEntries = true),
            @CacheEvict(value = "blogPage", beforeInvocation = true, allEntries = true)
        }
    )
    public BaseResponse<Integer> updateBlog(final Blog blog, final User user) {
        initBlog(blog, user, LocalDateTime.now());
        int updateNum = 0;
        try {
            updateNum = blogRepository.update(blog, new UpdateWrapper<Blog>()
                    .eq("id", blog.getId()));
        } catch (Exception e) {
            log.warn("更新博客发生异常，博客最新信息为：{}", blog.toString(), e);
            throw new BlogException("updateBlogException", "更新博客发生异常", e);
        }
        if(updateNum < 1) {
            log.warn("更新博客失败，博客最新信息为：{}", blog.toString());
            throw new BlogException("addBlogFailure", "更新博客失败");
        }
        return BaseResponse.builder()
                .body(updateNum)
                .success(true)
                .build();
    }

    @Deprecated
    private void initBlog(final Blog blog, final User user) {
        LocalDateTime now = LocalDateTime.now();
        blog.setManagerId(user.getId());
        blog.setCreator(user.getId());
        blog.setCreateTime(now);
        initBlog(blog, user, now);
    }

    private void initBlog(final Blog blog, final User user, LocalDateTime now) {
        blog.setModifier(user.getId());
        blog.setModifyTime(now);
    }

    @Deprecated
    @Cacheable(value = "blogPageByUser")
    public BaseResponse<Page<Blog>> getBlogPageList(final User user, final int pageId, final int pageSize) {
        Page<Blog> page = new Page<>(pageId, pageSize);
        return BaseResponse.builder()
                .body((Page<Blog>) blogRepository.selectPage(page, new QueryWrapper<Blog>()
                        .eq("manager_id", user.getId())))
                .success(true)
                .build();
    }

    @Deprecated
    @Cacheable(value = "blogPage")
    public BaseResponse<Page<Blog>> getBlogPageList(final int pageId, final int pageSize) {
        Page<Blog> page = new Page<>(pageId, pageSize);
        return BaseResponse.builder()
                .body((Page<Blog>) blogRepository.selectPage(page, null))
                .success(true)
                .build();
    }

    @Cacheable(value = "blog", key = "#blogId")
    public BaseResponse<Blog> getBlogById(String blogId) {
        Blog blog = blogRepository.selectById(blogId);
        if(Objects.isNull(blog)){
            log.warn("查询博客信息失败,博客ID：{}", blogId);
            throw new BlogException("queryBlogFailure", "查询博客信息失败");
        }
        return BaseResponse.builder()
                .body(blog)
                .success(true)
                .build();
    }

    @Deprecated
    @Caching(evict = {
        @CacheEvict(value = "blog", key = "#blogId", beforeInvocation = true),
        @CacheEvict(value = "blogPage", beforeInvocation = true, allEntries = true),// 清除blogPage中的所有缓存
        @CacheEvict(value = "blogPageByUser", beforeInvocation = true, allEntries = true)
    })
    public BaseResponse<Integer> deleteBlog(String blogId) {
        return BaseResponse.builder()
                .body(blogRepository.deleteById(blogId))
                .success(true)
                .build();
    }
}
