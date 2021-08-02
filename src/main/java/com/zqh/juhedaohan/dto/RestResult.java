package com.zqh.juhedaohan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangqh
 * @date 2021/7/27 0027 13:49
 */
@Data
public class RestResult implements Serializable {

    private static final int SUCCESS_CODE = 0;
    private static final int ERROR_CODE = -1;
    private static final String SUCCESS_MSG = "成功";
    private static final String ERROR_MSG = "失败";

    private int code;
    private Object data;
    private String msg;

   public RestResult() {

   }

    public RestResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }


    public RestResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /*=================SUCCESS=======================*/

    public static RestResult buildSuccess() {
        return new RestResult(SUCCESS_CODE,SUCCESS_MSG);
    }

    public static RestResult buildSuccess(Object data) {
        return new RestResult(SUCCESS_CODE,data,SUCCESS_MSG);
    }

    public static RestResult buildSuccess(Object data,int code) {
        return new RestResult(code,data,SUCCESS_MSG);
    }

    public static RestResult buildSuccess(Object data,String msg) {
        return new RestResult(SUCCESS_CODE,data,msg);
    }

    public static RestResult buildSuccess(Object data,int code,String msg) {
        return new RestResult(code,data,msg);
    }

    /*================ERROR====================*/

    public static RestResult buildError() {
       return new RestResult(ERROR_CODE,ERROR_MSG);
    }

    public static RestResult buildError(int code) {
        return new RestResult(code,ERROR_MSG);
    }

    public static RestResult buildError(String msg) {
        return new RestResult(ERROR_CODE,msg);
    }

    public static RestResult buildError(int code,String msg) {
        return new RestResult(code,msg);
    }
}
