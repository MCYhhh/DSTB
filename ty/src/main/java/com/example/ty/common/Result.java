package com.example.ty.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result {
    private int code; //编码 200 /400 /500 /401/ 600
    private String msg; //成功/参数错误/系统错误/权限不足/其他业务异常
    private Long total;  //总记录数
    private Object data;  //数据

    private static int getTotal(Object data){
        int total=0;
        if (data.getClass().isArray()){
            total = Array.getLength(data);
        }if (data instanceof List) {
            total= ((List) data).size();
        }if (data instanceof Set) {
            total= ((Set) data).size();
        }if (data instanceof Map) {
            total =((Map) data).size();
        }
        return total;
    }

    public static Result success(String msg) {

        return new Result(200,msg,1L,null);
    }

    public static Result success() {

        return new Result(200,"",1L,null);
    }

    public static Result success(Object data,Long total) {

        return new Result(200, "",total, data);
    }
    public static Result success(Object data,String msg) {

        return new Result(200, msg, (long) getTotal(data), data);
    }

    public static Result error(int code, String msg) {

        return new Result(code, msg, 0L,null);
    }
    public static Result error() {

        return new Result(400, "密码或者账号错误",0L,null);
    }

//    public static Result error() {
//        return new Result(500, "系统错误", 0L,null);
//    }

}
