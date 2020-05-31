package com.xiaomaigou.cms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaomaigou.cms.dao.entity.ContentCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 内容（广告）分类表
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:00
 */
@Mapper
public interface ContentCategoryMapper extends BaseMapper<ContentCategoryEntity> {
    /**
     * 根据内容分类ID查询内容（广告）分类
     *
     * @param contentCategoryId 内容分类ID
     * @return 内容（广告）分类列表
     */
    List<ContentCategoryEntity> listContentCategoryByContentCategoryId(String contentCategoryId);
}
