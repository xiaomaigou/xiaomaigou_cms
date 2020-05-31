package com.xiaomaigou.cms.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 内容（广告）分类表实体类
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 22:57
 */
@TableName("tb_content_category")
@ApiModel(description = "内容（广告）分类表实体类")
public class ContentCategoryEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 内容分类ID
     */
    @TableId(value = "content_category_id", type = IdType.INPUT)
    @ApiModelProperty(value = "内容分类ID", name = "contentCategoryId", required = true)
    private String contentCategoryId;

    /**
     * 内容分类code
     */
    @TableField(value = "content_category_code")
    @ApiModelProperty(value = "内容分类code", name = "contentCategoryCode")
    private String contentCategoryCode;

    /**
     * 分类名称
     */
    @TableField(value = "content_category_name")
    @ApiModelProperty(value = "分类名称", name = "contentCategoryName")
    private String contentCategoryName;

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

    public ContentCategoryEntity() {
    }

    public ContentCategoryEntity(String contentCategoryId, String contentCategoryCode, String contentCategoryName, String createPersonId, String updatePersonId, Date createTime, Date updateTime, Integer status) {
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
        return "ContentCategoryEntity{" +
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
