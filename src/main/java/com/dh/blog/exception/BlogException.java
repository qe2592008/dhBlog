package com.dh.blog.exception;

import lombok.Data;

@Data
public class BlogException extends RuntimeException {
    private static final long serialVersionUID = -7339434361243215676L;

    private String code;
    private String info;

    public BlogException () {}
    public BlogException (String info) {
        this(null, info, null);
    }
    public BlogException (String code, String info) {
        this(code, info, null);
    }
    public BlogException (String info, Throwable t) {
        this(null, info, t);
    }
    public BlogException (String code, String info, Throwable t) {
        super(t);
        this.code = code;
        this.info = info;
    }
}
