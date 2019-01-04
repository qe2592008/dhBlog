package com.dh.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private Boolean success;
    private String code;
    private String info;
    private T body;
    private BaseResponse(BaseResponse<T> response){
        this.success = response.success;
        this.code = response.code;
        this.info = response.info;
        this.body = response.body;
    }
    public static BaseResponseBuilder builder(){
        return new BaseResponseBuilder();
    }
    public static class BaseResponseBuilder<T> {
        private BaseResponse<T> response;
        public BaseResponseBuilder(){
            response = new BaseResponse<T>();
        }
        public BaseResponseBuilder<T> success(Boolean success){
            response.success = success;
            return this;
        }
        public BaseResponseBuilder<T> code(String code) {
            response.code = code;
            return this;
        }
        public BaseResponseBuilder<T> info(String info){
            response.info = info;
            return this;
        }
        public BaseResponseBuilder<T> body(T t){
            response.body = t;
            return this;
        }
        public BaseResponse<T> build(){
            return new BaseResponse<>(response);
        }
    }
}
