package com.dh.blog.exception;

import com.dh.blog.config.BlogError;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
    public BlogException (BlogError detail) {
        this(detail.getCode(), detail.getInfo(), null);
    }
    public BlogException (BlogError detail, Throwable t) {
        this(detail.getCode(), detail.getInfo(), t);
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
