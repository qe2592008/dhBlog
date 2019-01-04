package com.dh.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页接口，用于获取首页展示的所有数据信息
 * 博客结构，博客是最顶层结构，只有一个，系统初建，需要有一个预定义的博客，可修改。
 *  首页展示博客热门文章，
 *
 * @author donghao
 * @date 2019/1/4
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

}
