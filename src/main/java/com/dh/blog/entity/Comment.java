package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 评论
 *
 * @author donghao
 * @date 2018/12/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String id;// 主键ID
    private String articleId;// 文章ID
    private String prevId;// 上级评论ID
    private String visitorId;// 评论者ID
    private String blog;// 博客ID
    private String content;// 评论内容
    private String isDisplay;// 是否显示
    private String isEssence;// 是否精华
    private Integer favours;// 点赞量
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
