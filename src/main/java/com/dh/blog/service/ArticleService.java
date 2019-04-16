package com.dh.blog.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.blog.config.BlogError;
import com.dh.blog.entity.Article;
import com.dh.blog.entity.Blog;
import com.dh.blog.entity.User;
import com.dh.blog.exception.BlogException;
import com.dh.blog.repository.ArticleRepository;
import com.dh.blog.util.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
public class ArticleService extends BaseService {

    @Autowired
    private ArticleRepository articleRepository;

    public BaseResponse<Integer> add(Article article, User _user) {
        init(article, _user);
        int insertNum = articleRepository.insert(article);
        if (insertNum < 1) {
            log.warn("添加新文章失败，文章信息为：{}", article.toString());
            throw new BlogException(BlogError.ADD_ARTICLE_FAILURE);
        }
        return BaseResponse.builder().success(true).body(insertNum).build();
    }

    private void init(Article article, User _user) {
        LocalDateTime now = LocalDateTime.now();
        article.setAuthor(_user.getId());
        article.setCreator(_user.getId());
        article.setCreateTime(now);
        init(article, _user, now);
    }

    private void init(Article article, User _user, LocalDateTime now) {
        article.setModifier(_user.getId());
        article.setModifyTime(now);
    }

    public BaseResponse<Integer> update(Article article, User _user) {
        init(article, _user, LocalDateTime.now());
        int updateNum = articleRepository.update(article, new UpdateWrapper<Article>()
                .eq("id",article.getId()));
        if (updateNum < 1) {
            log.warn("更新文章失败，文章ID为：{}", article.getId());
            throw new BlogException(BlogError.UPDATE_ARTICLE_FAILURE);
        }
        return BaseResponse.builder().success(true).body(updateNum).build();
    }

    public BaseResponse<Article> getById(String id) {
        Article article = articleRepository.selectById(id);
        if (Objects.isNull(article)) {
            log.warn("查询指定ID的文章失败，文章id为：{}", id);
            throw new BlogException(BlogError.QUERY_ARTICLE_FAILURE);
        }
        return BaseResponse.builder().success(true).body(article).build();
    }

    public BaseResponse<Page<Article>> getByPage(final int pageId, final int pageSize, Blog _blog) {
        Page<Article> page = new Page<>(pageId, pageSize);
        return BaseResponse.builder()
                .success(true)
                .body(articleRepository.selectPage(page,
                        new QueryWrapper<Article>()
                                .eq("blog", _blog.getId())))
                .build();

    }

    public BaseResponse<Page<Article>> getByPageAndUser(int pageId, int pageSize, Blog _blog, User _user) {
        if ("".equals(_user.getRoles())) {// 角色-管理员
            return getByPage(pageId, pageSize, _blog);
        }
        Page<Article> page = new Page<>(pageId, pageSize);
        return BaseResponse.builder()
                .success(true)
                .body(articleRepository.selectPage(page,
                        new QueryWrapper<Article>()
                                .eq("blog", _blog.getId())
                                .eq("author", _user.getId())))
                .build();
    }
}
