package com.dh.blog.config;

import com.dh.blog.util.BaseResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 参数校验结果处理通知
 *
 * @author donghao
 * @date 2019/1/4
 */
@RestControllerAdvice
@Log4j2
public class ControllerValidateAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<String> handlerValidateErrors(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> errorList = bindingResult.getAllErrors();
        StringBuilder stringBuilder = new StringBuilder();
        errorList.forEach(ee -> stringBuilder.append(ee.getDefaultMessage() + ";"));
        log.error("校验结果信息为：{}", stringBuilder.toString());
        BaseResponse response = BaseResponse.builder().success(false).info("参数校验失败").code("paramValidFailure").build();
        return response;
    }

}