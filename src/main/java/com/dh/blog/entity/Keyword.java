package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 关键字
 *
 * @author donghao
 * @date 2018/12/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
    private String id;// 主键ID
    private String keyword;// 关键字
    private String blog;// 博客ID
    private Integer ArticleNum;// 文章数量
    private Integer hits;// 访问量
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
