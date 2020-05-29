package com.xiaomaigou.cms.common.dto;

import java.io.Serializable;

/**
 * 返回实体类
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/29 23:37
 */
public class Result<T> implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 返回代码,example = "200"
     */
    private Integer code;

    /**
     * 返回消息,example = "success"
     */
    private String msg;

    /**
     * 返回数据,example="{name:"xiaomaigou"}"
     */
    private T data;

    /**
     * 初始化一个新创建的 Result 对象
     */
    public Result() {
        this.code = Type.SUCCESS.value();
        this.msg = "success";
    }

    /**
     * 初始化一个新创建的 Result 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     */
    public Result(Type type, String msg) {
        this.code = type.value();
        this.msg = msg;
    }

    /**
     * 初始化一个新创建的 Result 对象
     *
     * @param type 状态类型
     * @param msg  返回内容
     * @param data 数据对象
     */
    public Result(Type type, String msg, T data) {
        this.code = type.value();
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public Result success() {
        return this.success("success");
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public Result<T> success(String msg) {
        return this.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param data 返回内容
     * @return 成功消息
     */
    public Result<T> success(T data) {
        this.code = Type.SUCCESS.value();
        this.msg = "success";
        this.data = data;
        return this;
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public Result<T> success(String msg, T data) {
        this.code = Type.SUCCESS.value();
        this.msg = msg;
        this.data = data;
        return this;
    }

    /**
     * 返回参数错误消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public Result<T> badRequest(String msg) {
        this.code = Type.BAD_REQUEST.value();
        this.msg = msg;
        this.data = null;
        return this;
    }

    /**
     * 返回鉴权失败消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public Result<T> unauthorized(String msg) {
        this.code = Type.UNAUTHORIZED.value();
        this.msg = msg;
        this.data = null;
        return this;
    }

    /**
     * 返回权限错误失败消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public Result<T> forbidden(String msg) {
        this.code = Type.FORBIDDEN.value();
        this.msg = msg;
        this.data = null;
        return this;
    }

    /**
     * 返回未找到失败消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public Result<T> notFound(String msg) {
        this.code = Type.NOT_FOUND.value();
        this.msg = msg;
        this.data = null;
        return this;
    }

    /**
     * 返回资源冲突消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public Result<T> confilct(String msg) {
        this.code = Type.CONFILCT.value();
        this.msg = msg;
        this.data = null;
        return this;
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public Result<T> fail(String msg) {
        this.code = Type.ERROR.value();
        this.msg = msg;
        this.data = null;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
