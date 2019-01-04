package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 角色
 *
 * @author donghao
 * @date 2019/1/3
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private String id;// 主键ID
    private String name;// 角色名称
    private String functions;// 功能列表
    private String desc;// 角色描述
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
