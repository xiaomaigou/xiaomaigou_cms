package com.dtk.main;

import com.dtk.util.HttpUtils;
import com.dtk.util.SignMD5Util;

import java.util.TreeMap;

/**
 * dtk-items-openapi Demo
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:45
 */
public class Demo {
    private static final String appSecret = "xxxxxxxxxxxxxxxxxxxxxxx";//应用sercret
    private static final String appKey = "xxxxxxxx"; //应用key
    private static final String host = "https://xxxxxxxxxxxxxx/api/category/get-top100";//应用服务接口

    public static void main(String[] args) {
        TreeMap<String, String> paraMap = new TreeMap<>();
        paraMap.put("version", "v1.0.0");
        paraMap.put("appKey", appKey);
        paraMap.put("sign", SignMD5Util.getSignStr(paraMap, appSecret));
        System.out.println(HttpUtils.sendGet(host, paraMap));
    }
}
