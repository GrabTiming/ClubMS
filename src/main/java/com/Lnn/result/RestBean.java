package com.Lnn.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestBean<T>  {

    private Integer code;
    private String message;

    private T data;

    public RestBean(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    //请求成功，返回数据
    public static <T> RestBean<T> success(T data){
        return new RestBean<>(200, data, "操作成功");
    }

    //请求成功，不返回数据
    public static <T> RestBean<T> success(){
        return success(null);
    }
    public static <T> RestBean<T> success(T data,String message){
        return new RestBean<>(200,data,message);
    }


    //禁止
    public static <T> RestBean<T> forbidden(String message){
        return failure(403, message);
    }

    //未认证
    public static <T> RestBean<T> unauthorized(String message){
        return failure(401, message);
    }

    //请求失败
    public static <T> RestBean<T> failure(int code, String message){
        return new RestBean<>(code, null, message);
    }

}