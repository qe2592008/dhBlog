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
@ApiModel("角色功能关系模型")
@TableName("ROLE_FUNCTION_RELATION")
public class RoleFunctionRelation {
    private String id;// 主键ID
    private String role;// 角色ID
    private String function;// 功能ID
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
}
