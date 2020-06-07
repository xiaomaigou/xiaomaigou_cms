package com.xiaomaigou.cms.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 内容（广告）实体类
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 17:48:01
 */
@TableName("tb_content")
@ApiModel(description = "内容（广告）实体类")
public class ContentEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 内容ID
     */
    @TableId(value = "content_id", type = IdType.INPUT)
    @ApiModelProperty(value = "内容ID", name = "contentId", required = true)
    private String contentId;
    /**
     * 内容分类code
     */
    @TableField(value = "content_category_code")
    @ApiModelProperty(value = "内容分类code", name = "contentCategoryCode", required = true)
    private String contentCategoryCode;
    /**
     * 内容标题
     */
    @TableField(value = "content_title")
    @ApiModelProperty(value = "内容标题", name = "contentTitle")
    private String contentTitle;
    /**
     * 内容副标题
     */
    @TableField(value = "content_subtitle")
    @ApiModelProperty(value = "内容副标题", name = "contentSubtitle")
    private String contentSubtitle;
    /**
     * 内容描述
     */
    @TableField(value = "content_description")
    @ApiModelProperty(value = "内容描述", name = "contentDescription")
    private String contentDescription;
    /**
     * 内容链接
     */
    @TableField(value = "content_url")
    @ApiModelProperty(value = "内容链接", name = "contentUrl")
    private String contentUrl;
    /**
     * 图片绝对路径
     */
    @TableField(value = "content_pic")
    @ApiModelProperty(value = "图片绝对路径", name = "contentPic")
    private String contentPic;
    /**
     * 商品原始价格,单位:元
     */
    @TableField(value = "original_price")
    @ApiModelProperty(value = "商品原始价格,单位:元", name = "originalPrice")
    private BigDecimal originalPrice;
    /**
     * 优惠券金额,单位:元
     */
    @TableField(value = "coupon_amount")
    @ApiModelProperty(value = "优惠券金额,单位:元", name = "couponAmount")
    private BigDecimal couponAmount;
    /**
     * 排序
     */
    @TableField(value = "sort_order")
    @ApiModelProperty(value = "排序", name = "sortOrder")
    private Integer sortOrder;
    /**
     * 来源code
     */
    @TableField(value = "source_type_code")
    @ApiModelProperty(value = "来源code", name = "sourceTypeCode", required = true)
    private String sourceTypeCode;
    /**
     * 标签
     */
    @TableField(value = "label")
    @ApiModelProperty(value = "标签", name = "label")
    private String label;
    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;
    /**
     * 创建人ID
     */
    @TableField(value = "create_person_id")
    @ApiModelProperty(value = "创建人ID", name = "createPersonId")
    private String createPersonId;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;
    /**
     * 最后修改人ID
     */
    @TableField(value = "update_person_id")
    @ApiModelProperty(value = "最后修改人ID", name = "updatePersonId")
    private String updatePersonId;
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

    public ContentEntity() {
    }

    public ContentEntity(String contentId, String contentCategoryCode, String contentTitle, String contentSubtitle, String contentDescription, String contentUrl, String contentPic, BigDecimal originalPrice, BigDecimal couponAmount, Integer sortOrder, String sourceTypeCode, String label, String remark, String createPersonId, Date createTime, String updatePersonId, Date updateTime, Integer status) {
        this.contentId = contentId;
        this.contentCategoryCode = contentCategoryCode;
        this.contentTitle = contentTitle;
        this.contentSubtitle = contentSubtitle;
        this.contentDescription = contentDescription;
        this.contentUrl = contentUrl;
        this.contentPic = contentPic;
        this.originalPrice = originalPrice;
        this.couponAmount = couponAmount;
        this.sortOrder = sortOrder;
        this.sourceTypeCode = sourceTypeCode;
        this.label = label;
        this.remark = remark;
        this.createPersonId = createPersonId;
        this.createTime = createTime;
        this.updatePersonId = updatePersonId;
        this.updateTime = updateTime;
        this.status = status;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentCategoryCode() {
        return contentCategoryCode;
    }

    public void setContentCategoryCode(String contentCategoryCode) {
        this.contentCategoryCode = contentCategoryCode;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentSubtitle() {
        return contentSubtitle;
    }

    public void setContentSubtitle(String contentSubtitle) {
        this.contentSubtitle = contentSubtitle;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentPic() {
        return contentPic;
    }

    public void setContentPic(String contentPic) {
        this.contentPic = contentPic;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatePersonId() {
        return updatePersonId;
    }

    public void setUpdatePersonId(String updatePersonId) {
        this.updatePersonId = updatePersonId;
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
        return "ContentEntity{" +
                "contentId='" + contentId + '\'' +
                ", contentCategoryCode='" + contentCategoryCode + '\'' +
                ", contentTitle='" + contentTitle + '\'' +
                ", contentSubtitle='" + contentSubtitle + '\'' +
                ", contentDescription='" + contentDescription + '\'' +
                ", contentUrl='" + contentUrl + '\'' +
                ", contentPic='" + contentPic + '\'' +
                ", originalPrice=" + originalPrice +
                ", couponAmount=" + couponAmount +
                ", sortOrder=" + sortOrder +
                ", sourceTypeCode='" + sourceTypeCode + '\'' +
                ", label='" + label + '\'' +
                ", remark='" + remark + '\'' +
                ", createPersonId='" + createPersonId + '\'' +
                ", createTime=" + createTime +
                ", updatePersonId='" + updatePersonId + '\'' +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
