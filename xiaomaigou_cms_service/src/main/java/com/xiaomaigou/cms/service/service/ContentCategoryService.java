package com.xiaomaigou.cms.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaomaigou.cms.dao.entity.ContentCategoryEntity;
import com.xiaomaigou.cms.service.dto.ContentCategoryDTO;

import java.util.List;

/**
 * 内容（广告）分类接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:23
 */
public interface ContentCategoryService extends IService<ContentCategoryEntity> {

    /**
     * 获取所有内容（广告）分类
     *
     * @return 所有内容（广告）分类
     */
    List<ContentCategoryEntity> listAll();

    /**
     * 获取内容（广告）分类(分页)
     *
     * @param pageNo   当前页，默认1
     * @param pageSize 每页显示条数，默认10
     * @return 内容（广告）分类
     */
    Page<ContentCategoryEntity> listAllPage(Integer pageNo, Integer pageSize);

    /**
     * 根据内容（广告）分类ID获取内容（广告）分类详情
     *
     * @param contentCategoryId 内容（广告）分类ID
     * @return 内容（广告）分类详情
     */
    ContentCategoryEntity detail(String contentCategoryId);

    /**
     * 新增内容（广告）分类
     *
     * @param contentCategoryDTO 内容（广告）分类信息
     * @return 执行结果
     */
    Boolean add(ContentCategoryDTO contentCategoryDTO);

    /**
     * 根据内容（广告）分类ID更新内容（广告）分类
     *
     * @param contentCategoryId  内容（广告）分类ID
     * @param contentCategoryDTO 内容（广告）分类信息
     * @return 执行结果
     */
    Boolean update(String contentCategoryId, ContentCategoryDTO contentCategoryDTO);

    /**
     * 根据内容（广告）分类ID删除内容（广告）分类
     *
     * @param contentCategoryId 内容（广告）分类ID
     * @return 执行结果
     */
    Boolean delete(String contentCategoryId);

    /**
     * 根据内容（广告）分类ID删除内容（广告）分类(多条记录)
     *
     * @param contentCategoryIdList 内容（广告）分类ID List
     * @return 执行结果
     */
    Boolean delete(List<String> contentCategoryIdList);

}
