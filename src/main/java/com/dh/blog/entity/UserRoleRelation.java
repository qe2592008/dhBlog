package com.dh.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户角色关系模型")
@TableName("USER_ROLE_RELATION")
public class UserRoleRelation {
    private String id;// 主键ID
    private String user;// 用户ID
    private String role;// 角色ID
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
}
