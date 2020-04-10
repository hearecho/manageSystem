package com.echo.exception;

import com.echo.response.ResultCodeEnum;
import lombok.Data;

/**
 * 使用@ExceptionHandler注解捕获指定或自定义的异常；
 *
 * 使用@ControllerAdvice集成@ExceptionHandler的方法到一个类中；
 *
 * 必须定义一个通用的异常捕获方法，便于捕获未定义的异常信息；
 *
 * 自定一个异常类，捕获针对项目或业务的异常;
 *
 * 异常的对象信息补充到统一结果枚举中；
 * @author hearecho
 * @createtime 2020/3/19 15:33
 */
@Data
public class CMSException extends RuntimeException {
    private Integer code;

    public CMSException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    public CMSException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
