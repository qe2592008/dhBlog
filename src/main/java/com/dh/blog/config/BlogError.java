package com.dh.blog.config;

public enum BlogError {
    // 查询类 10000
    QUERY_BLOG_FAILURE("10000", "查询博客信息失败"),

    // 添加类 20000
    ADD_BLOG_EXCEPTION("20000", "添加新博客发生异常"),
    ADD_BLOG_FAILURE("20001", "添加新博客失败"),
    // 更新类 30000
    UPDATE_BLOG_EXCEPTION("30000", "更新博客发生异常"),
    UPDATE_BLOG_FAILURE("30001", "更新博客失败"),
    // 删除类 40000
    ;
    private String code;
    private String info;

    BlogError(String code, String info){
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

}
