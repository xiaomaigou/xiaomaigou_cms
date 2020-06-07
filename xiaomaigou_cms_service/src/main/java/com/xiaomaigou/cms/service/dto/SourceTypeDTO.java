package com.xiaomaigou.cms.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 新增/修改来源类型传输对象
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 18:02:13
 */
@ApiModel(description = "新增/修改来源类型传输对象")
public class SourceTypeDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 来源ID
     */
//    @ApiModelProperty(value = "来源ID", name = "sourceTypeId",required = true)
//    private String sourceTypeId;
    /**
     * 来源code
     */
    @ApiModelProperty(value = "来源code", name = "sourceTypeCode", required = true)
    private String sourceTypeCode;
    /**
     * 来源名称
     */
    @ApiModelProperty(value = "来源名称", name = "sourceTypeName")
    private String sourceTypeName;
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
     * 状态，-1删除，0无效，1有效
     */
    @ApiModelProperty(value = "状态，-1删除，0无效，1有效", name = "status", required = true)
    private Integer status;

    public SourceTypeDTO() {
    }

    public SourceTypeDTO(String sourceTypeCode, String sourceTypeName, String createPersonId, String updatePersonId, Date createTime, Date updateTime, Integer status) {
        this.sourceTypeCode = sourceTypeCode;
        this.sourceTypeName = sourceTypeName;
        this.createPersonId = createPersonId;
        this.updatePersonId = updatePersonId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
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
        return "SourceTypeDTO{" +
                "sourceTypeCode='" + sourceTypeCode + '\'' +
                ", sourceTypeName='" + sourceTypeName + '\'' +
                ", createPersonId='" + createPersonId + '\'' +
                ", updatePersonId='" + updatePersonId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
