package com.dh.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dh.blog.annotation.InitValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 博客
 *
 * @author donghao
 * @date 2018/12/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("博客模型")
@TableName("BLOG")
public class Blog {
    @TableId@TableField
    @ApiModelProperty(value = "博客ID", notes = "主键ID，自增")
    @NotNull(message = "博客ID不能为空")
    private String id;// 主键ID，自增
    @NotNull(message = "博客标题不能为空")
    @ApiModelProperty(value = "博客标题", notes = "博客标题", required = true)
    private String title;// 标题，非空
    @NotNull(message = "博客子标题不能为空")
    @ApiModelProperty(value = "博客子标题", notes = "博客子标题，非空", required = true)
    private String subtitle;// 子标题，非空
    @ApiModelProperty(value = "图片地址", notes = "图片地址，可空")
    private String imgUrl;// 图片地址，可空
    @ApiModelProperty(value = "管理者", notes = "管理者ID，非空", required = true)
    private String managerId;// 管理者ID，非空
    @Range(min = 0, max = 50, message = "每页文章数必须在0-50之内")
    @ApiModelProperty(value = "每页文章数", notes = "每页文章数，非空，默认10", required = true)
    @InitValue(10)
    private Integer articleNumPerPage;// 每页文章数，非空，默认10
    @Range(min = 0, max = 50, message = "每页评论数必须在0-50之内")
    @ApiModelProperty(value = "每页评论数", notes = "每页评论数，非空，默认10", required = true)
    @InitValue(10)
    private Integer commentNumPerPage;// 每页评论数，非空，默认10
    @Range(min = 0, max = 50, message = "最热评论数必须在0-50之内")
    @ApiModelProperty(value = "评论列表数量", notes = "评论列表数量，非空，默认10", required = true)
    @InitValue(10)
    private Integer commentListNum;// 评论列表数量，非空，默认10
    @Range(min = 0, max = 50, message = "评论最多文章列表数必须在0-50之内")
    @ApiModelProperty(value = "评论最多文章列表数量", notes = "评论最多文章列表数量，非空，默认10", required = true)
    @InitValue(10)
    private Integer mostCommentArticleNum;// 评论最多文章列表数量，非空，默认10
    @Range(min = 0, max = 50, message = "评论最多文章列表数必须在0-50之内")
    @ApiModelProperty(value = "最新文章数量", notes = "最新文章数量，非空，默认10", required = true)
    @InitValue(10)
    private Integer lastestArticleNum;// 最新文章数量，非空，默认10
    @Range(min = 0, max = 10, message = "置顶文章数必须在0-10之内")
    @ApiModelProperty(value = "置顶文章数量", notes = "置顶文章数量，非空，默认5", required = true)
    @InitValue(5)
    private Integer stickArticleNum;// 置顶文章数量，非空，默认5
    @Range(min = 0, max = 25, message = "最热关键字数必须在0-25之内")
    @ApiModelProperty(value = "最热关键字数量", notes = "最热关键字数量，非空，默认5", required = true)
    @InitValue(5)
    private Integer hotestKeywordNum;// 最热关键字数量，非空，默认5
    @Range(min = 0, max = 20, message = "最热文章分类数必须在0-20之内")
    @ApiModelProperty(value = "最热文章分类数量", notes = "最热文章分类数量，非空，默认5", required = true)
    @InitValue(5)
    private Integer hotestArticleCategoryNum;// 最热文章分类数量，非空，默认5
    @ApiModelProperty(value = "创建时间", notes = "创建时间")
    private LocalDateTime createTime;// 创建时间
    @ApiModelProperty(value = "修改时间", notes = "修改时间")
    private LocalDateTime modifyTime;// 修改时间
    @ApiModelProperty(value = "创建者", notes = "创建人员ID")
    private String creator;// 创建者
    @ApiModelProperty(value = "修改者", notes = "修改人员ID")
    private String modifier;// 修改者
}
