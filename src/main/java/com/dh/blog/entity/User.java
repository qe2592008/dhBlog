package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户
 *
 * @author donghao
 * @date 2019/1/3
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;// 主键ID
    private String username;// 用户名
    private String password;// 登录密码
    private String name;// 姓名
    private String idCardNum;// 身份证号
    private String penName;// 笔名
    private String phone;// 手机
    private String weChat;// 微信
    private String qq;// QQ
    private String email;// 邮箱
    private String roles;// 角色列表
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
