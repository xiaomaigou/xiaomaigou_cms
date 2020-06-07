package com.xiaomaigou.cms.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaomaigou.cms.dao.entity.ContentEntity;
import com.xiaomaigou.cms.service.dto.ContentDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

/**
 * 内容（广告）接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 17:48:01
 */
public interface ContentService extends IService<ContentEntity> {

    /**
     * 获取所有内容（广告）
     *
     * @return 所有内容（广告）
     */
    List<ContentEntity> listAll();

    /**
     * 获取内容（广告）(分页)
     *
     * @param pageNo   当前页，默认1
     * @param pageSize 每页显示条数，默认10
     * @return 内容（广告）
     */
    Page<ContentEntity> listAllPage(Integer pageNo, Integer pageSize);

    /**
     * 搜索内容（广告）(分页)
     *
     * @param pageNo              当前页，默认1
     * @param pageSize            每页显示条数，默认10
     * @param contentCategoryCode 内容分类code
     * @param contentTitle        内容标题
     * @param contentSubtitle     内容副标题
     * @param contentDescription  内容描述
     * @param sourceTypeCode      来源code
     * @param createPersonId      创建人ID
     * @param status              状态，-1删除，0无效，1有效
     * @return 内容（广告）
     */
    Page<ContentEntity> search(Integer pageNo, Integer pageSize, String contentCategoryCode, String contentTitle, String contentSubtitle, String contentDescription, String sourceTypeCode, String createPersonId, Integer status);

    /**
     * 根据内容（广告）ID获取内容（广告）详情
     *
     * @param contentId 内容（广告）ID
     * @return 内容（广告）详情
     */
    ContentEntity detail(String contentId);

    /**
     * 新增内容（广告）
     *
     * @param contentDTO 内容（广告）信息
     * @return 执行结果
     */
    Boolean add(ContentDTO contentDTO);

    /**
     * 根据内容（广告）ID更新内容（广告）
     *
     * @param contentId  内容（广告）ID
     * @param contentDTO 内容（广告）信息
     * @return 执行结果
     */
    Boolean update(String contentId, ContentDTO contentDTO);

    /**
     * 根据内容（广告）ID删除内容（广告）
     *
     * @param contentId 内容（广告）ID
     * @return 执行结果
     */
    Boolean delete(String contentId);

    /**
     * 根据内容（广告）ID删除内容（广告）(多条记录)
     *
     * @param contentIdList 内容（广告）ID List
     * @return 执行结果
     */
    Boolean delete(List<String> contentIdList);

}
