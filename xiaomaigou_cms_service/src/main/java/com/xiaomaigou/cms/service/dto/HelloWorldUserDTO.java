package com.xiaomaigou.cms.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户信息传输对象
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/1 0:23
 */
@ApiModel(description = "用户信息传输对象")
public class HelloWorldUserDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    @ApiModelProperty(name = "username", value = "用户名,用户的用户名", required = true, dataType = "String")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(name = "address", value = "地址,用户的地址", required = true, dataType = "String")
    private String address;

    @ApiModelProperty(name = "count", value = "参数,最大值40，最小值1，默认20", required = false, dataType = "long")
    @NotNull(message = "参数不能为空")
    @Max(value = 40, message = "参数错误，最大值40，最小值1，默认20")
    @Min(value = 1, message = "参数错误，最大值40，最小值1，默认20")
    private Long count;

    public HelloWorldUserDTO() {
    }

    public HelloWorldUserDTO(@NotBlank(message = "用户名不能为空") String username, String address, @NotNull(message = "参数不能为空") @Max(value = 40, message = "参数错误，最大值40，最小值1，默认20") @Min(value = 1, message = "参数错误，最大值40，最小值1，默认20") Long count) {
        this.username = username;
        this.address = address;
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "HelloWorldUserDTO{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", count=" + count +
                '}';
    }
}
