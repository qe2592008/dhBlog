package com.dh.blog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dh.blog.annotation.InitValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
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
@ApiModel("文章模型")
@TableName("ARTICLE")
public class Article {
    @TableId
    @ApiModelProperty(value = "主键ID", notes = "主键ID，自增")
    private String id;//主键ID
    @ApiModelProperty(value = "作者ID", notes = "作者ID，非空")
    private String author;// 作者ID
    @ApiModelProperty(value = "博客ID", notes = "博客ID，非空")
    private String blog;// 博客ID
    @NotNull(message = "博客标题不能为null")
    @ApiModelProperty(value = "博客标题", notes = "博客标题，非空")
    private String title;// 标题
    @NotNull(message = "关键字不能为null")
    private String keywords;// 关键字，多个
    @NotNull(message = "描述不能为null")
    private String description;// 描述
    @NotNull(message = "文章类别不能为null")
    private String articleCategoryId;// 文章类别ID
    @NotNull(message = "文章内容不能为null")
    private String content;// 文章内容
    @InitValue(0)
    private Integer stick;// 是否置顶
    @InitValue(1)
    private Integer display;// 是否显示
    @InitValue(0)
    private Integer essence;// 是否精华
    @InitValue(1)
    private Integer commect;// 是否可以评论
    @InitValue(0)
    private Integer hits;// 点击量
    @InitValue(0)
    private Integer favours;// 点赞量
    @InitValue(0)
    private Integer comments;// 评论量
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
