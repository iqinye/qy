/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.core.response;

import com.qinye.common.constant.BusinessCode;
import com.qinye.common.exception.BusinessException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title Response
 * @Package com.qinye.common.response
 * @Description: (通用请求返回数据)
 * @Author qinye
 * @Date 2022年08月13天 20时30分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Data
@ApiModel(value = "Result", description = "通用请求返回数据")
public class Response<T> {

    /**
     * 返回编码code
     */
    @ApiModelProperty(value = "返回编码code")
    private int code;

    /**
     * 返回数据data
     */
    @ApiModelProperty(value = "返回数据data")
    private T data;

    /**
     * 错误数据
     */
    @ApiModelProperty(value = "错误数据")
    private Object errorData;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息")
    private String msg;

    /**
     * 请求用户名
     */
    private String name;

    /**
     * 请求描述
     */
    private String describe;

    /**
     * 请求参数json
     */
    private String json;

    public Response() {
        this.code = BusinessCode.SUCCESS;
        this.msg = "";
    }

    public Response(T data) {
        this.code = BusinessCode.SUCCESS;
        this.data = data;
    }

    public Response(T data, int code, String message) {
        this.code = BusinessCode.SUCCESS;
        this.data = data;
        this.msg = message;
    }

    public Response(int code, String message) {
        this.code = BusinessCode.SUCCESS;
        this.msg = message;
    }

    public Response(T data, String name, String describe, String json) {
        this.code = BusinessCode.SUCCESS;
        this.data = data;
        this.name = name;
        this.describe = describe;
        this.json = json;
    }

    public Response(String name, String describe, String json){
        this.code = BusinessCode.SUCCESS;
        this.msg = "";
        this.name = name;
        this.describe = describe;
        this.json = json;
    }

    public Response(T data, int code){
        this.code = code;
        this.msg = BusinessCode.getMessage(code);
        this.data = data;
    }

    public Response(T data, int code, String name, String describe, String json){
        this.code = code;
        this.msg = BusinessCode.getMessage(code);
        this.data = data;
        this.name = name;
        this.describe = describe;
        this.json = json;
    }

    public Response(int code, BusinessException e){
        this.code = code;
        this.msg = e.getMessage();
        this.errorData = e.getErrorData();
    }

    public Response(int code, Object data){
        this.code = code;
        this.msg = BusinessCode.getMessage(code);
        this.errorData = data;
    }

    public Response(int code){
        this.code = code;
        this.msg = BusinessCode.getMessage(code);
    }

    public Response(int code, String name, String describe, String json){
        this.code = code;
        this.msg = BusinessCode.getMessage(code);
        this.name = name;
        this.describe = describe;
        this.json = json;
    }

    public static <T> Response<T> ok() {
        return restResult(null, BusinessCode.SUCCESS, "操作成功");
    }

    public static <T> Response<T> ok(T data) {
        return restResult(data, BusinessCode.SUCCESS, "操作成功");
    }

    public static <T> Response<T> ok(String msg) {
        return restResult(null, BusinessCode.SUCCESS, msg);
    }

    public static <T> Response<T> ok(String msg, T data) {
        return restResult(data, BusinessCode.SUCCESS, msg);
    }


    public static <T> Response<T> error() {
        return error(BusinessCode.SYS_ERROR);
    }

    public static <T> Response<T> error(String msg) {
        return error(BusinessCode.SYS_ERROR, msg);
    }

    public static <T> Response<T> error(int errorCode) {
        return error(errorCode, BusinessCode.getMessage(errorCode));
    }

    public static <T> Response<T> error(int code, String msg) {
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    private static <T> Response<T> restResult(T data, int code, String msg) {
        Response<T> r = new Response<>();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

}
