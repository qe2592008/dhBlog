package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 功能
 *      编辑文章-作者-管理员-作者只能编辑自己发布的文章，管理员可以修改博客中所有文章
 *      发布文章-作者-管理员
 *      删除文章-作者-管理员
 *      添加评论-评论者-作者-管理员-所有人，添加评论后变成评论者
 *      删除评论-评论者-管理员
 *      修改评论-评论者-管理员
 *      点赞-所有用户、非用户
 *      设置博客-管理员
 *
 *
 *
 * @author donghao
 * @date 2019/1/3
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Function {
    private String id;// 功能ID
    private String name;// 功能名称
    private String prevFunctionId;// 所属功能ID
    private String desc;// 功能描述
    private String priority;// 功能优先级，越小优先级越大
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
