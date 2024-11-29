package com.todo.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private String code;
    private T data;
    private String msg;
    public R(){}
    public static <T> R<T> success() {
        return result(null, "200", "success");
    }
    public static <T> R<T> success(T data) {
        return result(data, "200", "success");
    }

    public static <T> R<T> fail() {
        return result(null, "500", "未知异常,请联系管理员");
    }

    public static <T> R<T> fail(String msg) {
        return result(null, "500", msg);
    }

    private static <T> R<T> result(T data,String code,  String msg){
        R<T> r = new R<>();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }
}
