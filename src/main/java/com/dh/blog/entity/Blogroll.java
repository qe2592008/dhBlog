package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 友情链接
 *
 * @author donghao
 * @date 2019/1/3
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blogroll {
    private String id;// 主键ID
    private String title;// 标题
    private String imgUrl;// 图片位置
    private String url;// 链接地址
    private String isUse;// 是否启用
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
