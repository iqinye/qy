/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.utils;

import com.qinye.common.domain.qy.QyImage;
import com.qinye.common.domain.qy.QyRedisKey;
import com.qinye.common.utils.file.ImageUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title EmptyUtils
 * @Package com.qinye.common.utils
 * @Description: (这里用一句话描述这个类的作用)
 * @Author qinye
 * @Date 2022年08月13天 18时40分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public class EmptyUtils {

    /**
     * @Title: isEmpty
     * @Description: 判断字符串是否为空，长度为0被认为是空字符串.
     * @param str
     * @return
     * @return Integer
     */
    public static boolean isEmpty(String str) {
        if (null != str) {
            return str.trim().length() == 0;
        } else {
            return true;
        }
    }


    /**
     * @Title: isEmpty
     * @Description: 判断Bigdecimal类型是否为空或者0
     * @return
     * @return Integer
     */
    public static boolean isEmptyBigdecimal(BigDecimal decimal) {
        if(!EmptyUtils.isEmpty(decimal)){
            if(decimal.compareTo(BigDecimal.ZERO)!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * @Title: isEmpty
     * @Description: 判断字符串是否为空，字符串前后空白被截断，截断后长度为0被认为是空字符串
     * @param str
     * @param isTrimed 是否去掉前后空格
     * @return
     * @return Integer
     */
    public static boolean isEmpty(String str, boolean isTrimed) {
        if (isTrimed) {
            return null == str || str.trim().length() == 0;
        } else {
            return  null == str || str.length() == 0;
        }
    }

    /**
     * @Title: isEmpty
     * @Description: 判断列表是否为空，列表没有元素也被认为是空
     * @param collection
     * @return
     * @return Integer
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * @Title: isEmpty
     * @Description: 判断数组是否为空
     * @param array
     * @return
     * @return Integer
     */
    public static boolean isEmpty(Object[] array) {
        return null == array || array.length == 0;
    }

    /**
     * @Title: isEmpty
     * @Description: 判断对象是否为空
     * @param obj
     * @return
     * @return Integer
     */
    public static boolean isEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }

    /**
     * @Title: isEmpty
     * @Description: 判断Long类型是否为空
     * @param obj
     * @return
     * @return Integer
     */
    public static boolean isLongEmpty(Long obj) {
        return null == obj || obj.equals(0L);
    }

    /**
     * 截取字符串中的数字
     * @param str
     * @return
     */
    public static String checkNum(String str) {
        StringBuilder builder=new StringBuilder();
        String regEx="(\\d+(\\.\\d+)?)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while (m.find()) {//当符合正则表达式定义的条件时
            builder.append(m.group());
        }
        return builder.toString();
    }

    /**
     * 截取字符串中除了数字以外的字符串
     * @param str
     * @return
     */
    public static String checkNumOhter(String str) {
        StringBuilder builder=new StringBuilder();
        String regEx="[^0-9.]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while (m.find()) {//当符合正则表达式定义的条件时
            builder.append(m.group());
        }
        return builder.toString();
    }

    /**
     * 图片地址转MultipartFile
     */
    public static MultipartFile downloadImageUrl(String imageUrl, Long id) {
        try {
            HttpURLConnection httpUrl = (HttpURLConnection) new URL(imageUrl).openConnection();
            httpUrl.connect();
            File file = inputStreamToFile(httpUrl.getInputStream(),"product-"+id+".png");
            System.out.println("111====>>>>"+file.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *   工具类
     * inputStream 转 File
     */
    public static File inputStreamToFile(InputStream ins, String name) throws Exception{
        File file = new File("C:\\Users\\EDZ\\Pictures\\其他店铺3\\" + name);
        if (file.exists()) {
            return file;
        }
        OutputStream os = new FileOutputStream(file);
        int bytesRead;
        int len = 8192;
        byte[] buffer = new byte[len];
        while ((bytesRead = ins.read(buffer, 0, len)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
        ImageUtils.readImage(file);
        return file;
    }

    /**
     * 拿到字符串数组以逗号拼接成字符串返回
     * @param images
     * @return
     */
    public static String getImage(List<String> images) {
        String image="";
        if(!EmptyUtils.isEmpty(images)){
            for (int i = 0; i < images.size(); i++) {
                if(i==0||images.size()==1){
                    image=images.get(i);
                }else {
                    image+=","+images.get(i);
                }
            }
        }
        return image;
    }

    /**
     * 拿到字符串数组以逗号拼接成字符串返回
     * @param str
     * @return
     */
    public static String getString(List<Long> str) {
        String image="";
        if(!EmptyUtils.isEmpty(str)){
            for (int i = 0; i < str.size(); i++) {
                if(i==0||str.size()==1){
                    image=String.valueOf(str.get(i));
                }else {
                    image+=","+str.get(i);
                }
            }
        }
        return image;
    }

    /**
     * 拿到字符串数组以分号拼接成字符串返回
     * @param images
     * @return
     */
    public static String getFenString(List<String> images) {
        String image="";
        if(!EmptyUtils.isEmpty(images)){
            for (int i = 0; i < images.size(); i++) {
                if(i==0||images.size()==1){
                    image=images.get(i);
                }else {
                    image+=";"+images.get(i);
                }
            }
        }
        return image;
    }

    /**
     * 拿到对象数组获取地址以逗号拼接成字符串返回
     * @param images
     * @return
     */
    public static String getImageDateList(List<QyImage> images) {
        String image="";
        if(!EmptyUtils.isEmpty(images)){
            for (int i = 0; i < images.size(); i++) {
                String url = images.get(i).getImgPath();
                if(i==0||images.size()==1){
                    image=url;
                }else {
                    image+=","+url;
                }
            }
        }
        return image;
    }

    /**
     * 拿到图片数组封装成数组对象
     */
    public static List<QyImage> getImages(List<String> list){
        if(!EmptyUtils.isEmpty(list)){
            List<QyImage> collect = list.stream()
                    .map(a -> {
                        QyImage image = new QyImage();
                        image.setImgPath(a);
                        return image;
                    }).collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    /**
     * 拿到图片拼接字符串封装成数组对象（以逗号拼接）
     */
    public static List<String> getImages(String image){
        if(!EmptyUtils.isEmpty(image)){
            String[] split = image.split(",");
            return Arrays.asList(split);
        }
        return null;
    }

    /**
     * 拿到图片拼接字符串封装成数组对象（以分号拼接）
     */
    public static List<String> getFenStrings(String image){
        if(!EmptyUtils.isEmpty(image)){
            String[] split = image.split(";");
            return Arrays.asList(split);
        }
        return null;
    }

    /**
     * 计算切分次数
     */
    public static Integer countStep(Integer size, int input) {


        return (size + input - 1) / input;
    }

    /**
     * @param list  需要分隔的 集合
     * @param input 指定分隔size
     * @return
     */
    public static List<List<QyRedisKey>> split(List<QyRedisKey> list, int input) {

        int limit = countStep(list.size(), input);
        List<List<QyRedisKey>> splitList;
        splitList = Stream.iterate(0, n -> n + 1).limit(limit).
                map(a -> list.stream().skip(a * input).limit(input).collect(Collectors.toList())).
                collect(Collectors.toList());
        //当输入数量小于分隔数量需反转
        if (input<limit){

            splitList = Stream.iterate(0, n -> n + 1).limit(input).
                    map(a -> list.stream().skip(a * limit).limit(limit).collect(Collectors.toList())).
                    collect(Collectors.toList());
        }


        return splitList;
    }

    /**
     * 过滤表情包参数
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        if(source != null)
        {
            Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;
            Matcher emojiMatcher = emoji.matcher(source);
            if ( emojiMatcher.find())
            {
                source = emojiMatcher.replaceAll("*");
                return source ;
            }
            return source;
        }
        return source;
    }
}
