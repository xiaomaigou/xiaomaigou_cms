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
 * 来源类型实体类
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 18:02:13
 */
@TableName("tb_source_type")
@ApiModel(description = "来源类型实体类")
public class SourceTypeEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 来源ID
     */
    @TableId(value = "source_type_id", type = IdType.INPUT)
    @ApiModelProperty(value = "来源ID", name = "sourceTypeId", required = true)
    private String sourceTypeId;
    /**
     * 来源code
     */
    @TableField(value = "source_type_code")
    @ApiModelProperty(value = "来源code", name = "sourceTypeCode", required = true)
    private String sourceTypeCode;
    /**
     * 来源名称
     */
    @TableField(value = "source_type_name")
    @ApiModelProperty(value = "来源名称", name = "sourceTypeName")
    private String sourceTypeName;
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
     * 状态，-1删除，0无效，1有效
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态，-1删除，0无效，1有效", name = "status", required = true)
    private Integer status;

    public SourceTypeEntity() {
    }

    public SourceTypeEntity(String sourceTypeId, String sourceTypeCode, String sourceTypeName, String createPersonId, String updatePersonId, Date createTime, Date updateTime, Integer status) {
        this.sourceTypeId = sourceTypeId;
        this.sourceTypeCode = sourceTypeCode;
        this.sourceTypeName = sourceTypeName;
        this.createPersonId = createPersonId;
        this.updatePersonId = updatePersonId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public String getSourceTypeId() {
        return sourceTypeId;
    }

    public void setSourceTypeId(String sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }

    public String getSourceTypeName() {
        return sourceTypeName;
    }

    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
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
        return "SourceTypeEntity{" +
                "sourceTypeId='" + sourceTypeId + '\'' +
                ", sourceTypeCode='" + sourceTypeCode + '\'' +
                ", sourceTypeName='" + sourceTypeName + '\'' +
                ", createPersonId='" + createPersonId + '\'' +
                ", updatePersonId='" + updatePersonId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
