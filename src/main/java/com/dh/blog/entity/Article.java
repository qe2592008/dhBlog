package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 文章
 *
 * @author donghao
 * @date 2018/12/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private String id;//主键ID
    private String author;// 作者ID
    private String blog;// 博客ID
    private String title;// 标题
    private String keywords;// 关键字，多个
    private String description;// 描述
    private String articleCategoryId;// 文章类别ID
    private String content;// 文章内容
    private String isStick;// 是否置顶
    private String isDisplay;// 是否显示
    private String isEssence;// 是否精华
    private String isCommect;// 是否可以评论
    private Integer hits;// 点击量
    private Integer favours;// 点赞量
    private Integer comments;// 评论量
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
