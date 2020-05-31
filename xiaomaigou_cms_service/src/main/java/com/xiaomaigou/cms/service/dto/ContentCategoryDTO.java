package com.xiaomaigou.cms.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 新增/修改内容（广告）分类传输对象
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:18
 */
@ApiModel(description = "新增/修改内容（广告）分类传输对象")
public class ContentCategoryDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 内容分类ID
     */
    @ApiModelProperty(value = "内容分类ID", name = "contentCategoryId", required = true)
    private String contentCategoryId;

    /**
     * 内容分类code
     */
    @ApiModelProperty(value = "内容分类code", name = "contentCategoryCode")
    private String contentCategoryCode;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称", name = "contentCategoryName")
    private String contentCategoryName;

    /**
     * 创建人ID
     */
    @ApiModelProperty(value = "创建人ID", name = "createPersonId")
    private String createPersonId;

    /**
     * 最后修改人ID
     */
    @ApiModelProperty(value = "最后修改人ID", name = "updatePersonId")
    private String updatePersonId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间", name = "updateTime")
    private Date updateTime;

    /**
     * 状态，0无效，1有效
     */
    @ApiModelProperty(value = "状态，0无效，1有效", name = "status")
    private Integer status;

    public ContentCategoryDTO() {
    }

    public ContentCategoryDTO(String contentCategoryId, String contentCategoryCode, String contentCategoryName, String createPersonId, String updatePersonId, Date createTime, Date updateTime, Integer status) {
        this.contentCategoryId = contentCategoryId;
        this.contentCategoryCode = contentCategoryCode;
        this.contentCategoryName = contentCategoryName;
        this.createPersonId = createPersonId;
        this.updatePersonId = updatePersonId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public String getContentCategoryId() {
        return contentCategoryId;
    }

    public void setContentCategoryId(String contentCategoryId) {
        this.contentCategoryId = contentCategoryId;
    }

    public String getContentCategoryCode() {
        return contentCategoryCode;
    }

    public void setContentCategoryCode(String contentCategoryCode) {
        this.contentCategoryCode = contentCategoryCode;
    }

    public String getContentCategoryName() {
        return contentCategoryName;
    }

    public void setContentCategoryName(String contentCategoryName) {
        this.contentCategoryName = contentCategoryName;
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
        return "ContentCategoryDTO{" +
                "contentCategoryId='" + contentCategoryId + '\'' +
                ", contentCategoryCode='" + contentCategoryCode + '\'' +
                ", contentCategoryName='" + contentCategoryName + '\'' +
                ", createPersonId='" + createPersonId + '\'' +
                ", updatePersonId='" + updatePersonId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
