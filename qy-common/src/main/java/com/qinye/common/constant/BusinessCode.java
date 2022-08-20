/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.constant;

import com.qinye.common.utils.EmptyUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title BusinessCode
 * @Package com.qinye.constant
 * @Description: (业务状态码)
 * @Author qinye
 * @Author qinye
 * @Date 2022年07月20天 19时11分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public class BusinessCode {

    public static Map<Integer,String> messageMap = new HashMap<>();


    //===================================================
    /** 成功 */
    public static final int SUCCESS = 200;
    /** 重复请求,请稍后再试*/
    public static final int REPEAT_REQUEST = 00001;
    /** 文件为空,请重新选择文件*/
    public static final int NOT_FILE = 00002;
    /** token为空*/
    public static final int TOKEN_IS_NULL = 20003;
    /** token认证失败*/
    public static final int TOKEN_APPROVE_ERROR = 20004;
    /** 系统错误 */
    public static final int SYS_ERROR = 502;




    //初始化状态码与文字说明,后期可以放入到数据库中，根据返回码，自定义返回信息
    static {

        // 系统业务相关
        put(BusinessCode.SUCCESS, "请求成功");
        put(BusinessCode.TOKEN_IS_NULL, "token不能为空");
        put(BusinessCode.SYS_ERROR, "内部服务错误");


        // 系统服务相关
        put(400, "Bad Request!");
        put(401, "NotAuthorization");
        put(405, "Method Not Allowed");
        put(406, "Not Acceptable");
        put(500, "Internal Server Error");
        put(99999, "系统开小差,请稍后再试!");

    }

    /**
     * 获取业务返回码信息
     *
     * @param code
     * @return
     */
    public static String getMessage(Integer code) {
//    	String message = "业务编码未定义: " + code;
        String message = code.toString();
        String obj = messageMap.get(code);
        return obj==null ? message : obj;
    }

    /**
     * 返回码放入map中
     *
     * @param m
     */
    public static void putAll(Map<Integer,String> m) {
        messageMap.putAll(m);
    }

    /**
     * 放入到map中
     */
    public static void put(Integer key, String value) {
        if(EmptyUtils.isEmpty(key) || EmptyUtils.isEmpty(value)) {
            return;
        }
        messageMap.put(key, value);
    }







}
