package com.xiaomaigou.cms.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * API配置
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/1 0:20
 */
@Configuration
public class ApiConfig implements Serializable {

    private static final Long serialVersionUID = 1L;

    // 大淘客开放平台API
    /**
     * dtk.api.appSecret
     */
    public static String DTK_API_APPSECRET;

    /**
     * dtk.api.appKey
     */
    public static String DTK_API_APPKEY;

    /**
     * dtk.api.host
     */
    public static String DTK_API_HOST;

    /**
     * dtk.api.version
     */
    public static String DTK_API_VERSION;

    // 淘宝客开放平台API
    /**
     * taobao.tbk.api.url
     */
    public static String TAOBAO_TBK_API_URL;

    /**
     * taobao.tbk.api.appKey
     */
    public static String TAOBAO_TBK_API_APPKEY;

    /**
     * taobao.tbk.api.appSecret
     */
    public static String TAOBAO_TBK_API_APPSECRET;

    /**
     * taobao.tbk.api.adzoneId
     */
    public static String TAOBAO_TBK_API_ADZONEID;

    /**
     * taobao.tbk.api.pid
     */
    public static String TAOBAO_TBK_API_PID;

    // 京东开发平台CPS API
    /**
     * jd.cps.api.url
     */
    public static String JD_CPS_API_URL;

    /**
     * jd.cps.api.appKey
     */
    public static String JD_CPS_API_APPKEY;

    /**
     * jd.cps.api.appSecret
     */
    public static String JD_CPS_API_APPSECRET;

    /**
     * jd.cps.api.pid
     */
    public static String JD_CPS_API_PID;

    @Value("${dtk.api.appSecret}")
    public void setDtkApiAppsecret(String dtkApiAppsecret) {
        DTK_API_APPSECRET = dtkApiAppsecret;
    }

    @Value("${dtk.api.appKey}")
    public void setDtkApiAppkey(String dtkApiAppkey) {
        DTK_API_APPKEY = dtkApiAppkey;
    }

    @Value("${dtk.api.host}")
    public void setDtkApiHost(String dtkApiHost) {
        DTK_API_HOST = dtkApiHost;
    }

    @Value("${dtk.api.version}")
    public void setDtkApiVersion(String dtkApiVersion) {
        DTK_API_VERSION = dtkApiVersion;
    }

    @Value("${taobao.tbk.api.url}")
    public void setTaobaoTbkApiUrl(String taobaoTbkApiUrl) {
        TAOBAO_TBK_API_URL = taobaoTbkApiUrl;
    }

    @Value("${taobao.tbk.api.appKey}")
    public void setTaobaoTbkApiAppkey(String taobaoTbkApiAppkey) {
        TAOBAO_TBK_API_APPKEY = taobaoTbkApiAppkey;
    }

    @Value("${taobao.tbk.api.appSecret}")
    public void setTaobaoTbkApiAppsecret(String taobaoTbkApiAppsecret) {
        TAOBAO_TBK_API_APPSECRET = taobaoTbkApiAppsecret;
    }

    @Value("${taobao.tbk.api.adzoneId}")
    public void setTaobaoTbkApiAdzoneid(String taobaoTbkApiAdzoneid) {
        TAOBAO_TBK_API_ADZONEID = taobaoTbkApiAdzoneid;
    }

    @Value("${taobao.tbk.api.pid}")
    public void setTaobaoTbkApiPid(String taobaoTbkApiPid) {
        TAOBAO_TBK_API_PID = taobaoTbkApiPid;
    }

    @Value("${jd.cps.api.url}")
    public void setJdCpsApiUrl(String jdCpsApiUrl) {
        JD_CPS_API_URL = jdCpsApiUrl;
    }

    @Value("${jd.cps.api.appKey}")
    public void setJdCpsApiAppkey(String jdCpsApiAppkey) {
        JD_CPS_API_APPKEY = jdCpsApiAppkey;
    }

    @Value("${jd.cps.api.appSecret}")
    public void setJdCpsApiAppsecret(String jdCpsApiAppsecret) {
        JD_CPS_API_APPSECRET = jdCpsApiAppsecret;
    }

    @Value("${jd.cps.api.pid}")
    public void setJdCpsApiPid(String jdCpsApiPid) {
        JD_CPS_API_PID = jdCpsApiPid;
    }
}
