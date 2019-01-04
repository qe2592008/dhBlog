package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 文章类别
 *
 * @author donghao
 * @date 2018/12/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCategory {
    private String id;// 主键ID
    private String prevId;// 上级分类ID
    private String blog;// 博客ID
    private String name;// 分类名称
    private String description;// 描述
    private Integer articleNum;// 文章数量
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
