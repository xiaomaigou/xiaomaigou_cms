package com.xiaomaigou.cms.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * HelloWorld信息表实体类
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 22:55
 */
@TableName("tb_helloworld")
@ApiModel(description = "HelloWorld信息表")
public class HelloWorldEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * Helloworld ID
     */
    @TableId(value = "hw_id", type = IdType.INPUT)
    @ApiModelProperty(value = "Helloworld ID", name = "helloWorldId")
    private String helloWorldId;

    /**
     * 标题
     */
    @TableField(value = "hw_title")
    @ApiModelProperty(value = "标题", name = "title")
    private String title;

    /**
     * 内容
     */
    @TableField(value = "hw_content")
    @ApiModelProperty(value = "内容", name = "content")
    private String content;

    /**
     * 链接
     */
    @TableField(value = "hw_url")
    @ApiModelProperty(value = "链接", name = "url")
    private String url;

    /**
     * 图片绝对路径
     */
    @TableField(value = "hw_pic")
    @ApiModelProperty(value = "图片绝对路径", name = "pic")
    private String pic;

    /**
     * 价格,单位:元
     */
    @TableField(value = "hw_price")
    @ApiModelProperty(value = "价格,单位:元", name = "price")
    private BigDecimal price;

    /**
     * 排序
     */
    @TableField(value = "hw_sort_order")
    @ApiModelProperty(value = "排序", name = "sortOrder")
    private Integer sortOrder;


    /**
     * 创建人ID
     */
    @TableField(value = "create_person_id")
    @ApiModelProperty(value = "创建人ID", name = "createPersonId")
    private String createPersonId;


    /**
     * 最后修改人ID
     */
    @TableField(value = "update_person_id")
    @ApiModelProperty(value = "最后修改人ID", name = "updatePersonId")
    private String updatePersonId;


    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "最后修改时间", name = "updateTime")
    private Date updateTime;

    /**
     * 状态，0无效，1有效
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态，0无效，1有效", name = "status")
    private Integer status;

    public HelloWorldEntity() {
    }

    public HelloWorldEntity(String helloWorldId, String title, String content, String url, String pic, BigDecimal price, Integer sortOrder, String createPersonId, String updatePersonId, Date createTime, Date updateTime, Integer status) {
        this.helloWorldId = helloWorldId;
        this.title = title;
        this.content = content;
        this.url = url;
        this.pic = pic;
        this.price = price;
        this.sortOrder = sortOrder;
        this.createPersonId = createPersonId;
        this.updatePersonId = updatePersonId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public String getHelloWorldId() {
        return helloWorldId;
    }

    public void setHelloWorldId(String helloWorldId) {
        this.helloWorldId = helloWorldId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getUpdatePersonId() {
        return updatePersonId;
    }

    public void setUpdatePersonId(String updatePersonId) {
        this.updatePersonId = updatePersonId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HelloWorldEntity{" +
                "helloWorldId='" + helloWorldId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", sortOrder=" + sortOrder +
                ", createPersonId='" + createPersonId + '\'' +
                ", updatePersonId='" + updatePersonId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
