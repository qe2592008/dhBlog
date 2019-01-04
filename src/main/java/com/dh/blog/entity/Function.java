package com.dh.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 功能
 *
 * @author donghao
 * @date 2019/1/3
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Function {
    private String id;
    private String name;
    private String prevFunctionId;
    private String desc;
    private LocalDateTime createTime;// 创建时间
    private String creator;// 创建者
    private LocalDateTime modifyTime;// 修改时间
    private String modifier;// 修改者
}
