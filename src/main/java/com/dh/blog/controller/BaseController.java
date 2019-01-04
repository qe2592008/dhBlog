package com.dh.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/base")
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;

    @Autowired
    protected HttpServletResponse response;
}
