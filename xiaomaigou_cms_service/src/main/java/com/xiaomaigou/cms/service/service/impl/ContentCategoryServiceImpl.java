package com.xiaomaigou.cms.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaomaigou.cms.dao.entity.ContentCategoryEntity;
import com.xiaomaigou.cms.dao.mapper.ContentCategoryMapper;
import com.xiaomaigou.cms.service.dto.ContentCategoryDTO;
import com.xiaomaigou.cms.service.service.ContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 内容（广告）分类接口实现
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:26
 */
@Service
public class ContentCategoryServiceImpl extends ServiceImpl<ContentCategoryMapper, ContentCategoryEntity> implements ContentCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(ContentCategoryServiceImpl.class);

    @Override
    public List<ContentCategoryEntity> listAll() {
        QueryWrapper<ContentCategoryEntity> contentCategoryEntityQueryWrapper = new QueryWrapper<>();
        contentCategoryEntityQueryWrapper.orderByDesc("content_category_id");
        return this.list(contentCategoryEntityQueryWrapper);
    }

    @Override
    public Page<ContentCategoryEntity> listAllPage(Integer pageNo, Integer pageSize) {
        if (null == pageNo || pageNo < 1) {
            pageNo = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        QueryWrapper<ContentCategoryEntity> contentCategoryEntityQueryWrapper = new QueryWrapper<>();
        contentCategoryEntityQueryWrapper.orderByDesc("content_category_id");
        return this.page(new Page<>(pageNo, pageSize), contentCategoryEntityQueryWrapper);
    }

    @Override
    public Page<ContentCategoryEntity> search(Integer pageNo, Integer pageSize, String contentCategoryCode, String contentCategoryName, String createPersonId, Integer status) {
        if (null == pageNo || pageNo < 1) {
            pageNo = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        QueryWrapper<ContentCategoryEntity> contentCategoryEntityQueryWrapper = new QueryWrapper<>();
        contentCategoryEntityQueryWrapper.eq(StringUtils.isNotEmpty(contentCategoryCode), "content_category_code", contentCategoryCode);
        contentCategoryEntityQueryWrapper.like(StringUtils.isNotEmpty(contentCategoryName), "content_category_name", contentCategoryName);
        contentCategoryEntityQueryWrapper.eq(StringUtils.isNotEmpty(createPersonId), "create_person_id", createPersonId);
        contentCategoryEntityQueryWrapper.eq(status != null, "status", status);
        contentCategoryEntityQueryWrapper.orderByDesc("create_time", "update_time");
        return this.page(new Page<>(pageNo, pageSize), contentCategoryEntityQueryWrapper);
    }

    @Override
    public ContentCategoryEntity detail(String contentCategoryId) {
        return this.getById(contentCategoryId);
    }

    @Override
    public Boolean add(ContentCategoryDTO contentCategoryDTO) {
        ContentCategoryEntity contentCategoryEntity = new ContentCategoryEntity();
        BeanUtils.copyProperties(contentCategoryDTO, contentCategoryEntity);
        contentCategoryEntity.setContentCategoryId(IdWorker.getIdStr());
        contentCategoryEntity.setCreatePersonId("xiaomaigou");
        contentCategoryEntity.setUpdatePersonId("xiaomaigou");
        contentCategoryEntity.setCreateTime(new Date());
        contentCategoryEntity.setUpdateTime(new Date());
        contentCategoryEntity.setStatus(1);
        logger.debug(String.format("新增内容（广告）分类:contentCategoryEntity=[%s]", contentCategoryEntity.toString()));
        return this.save(contentCategoryEntity);
    }

    @Override
    public Boolean update(String contentCategoryId, ContentCategoryDTO contentCategoryDTO) {
        ContentCategoryEntity contentCategoryEntity = this.getById(contentCategoryId);
        if (null == contentCategoryEntity) {
            logger.warn(String.format("更新不存在的内容（广告）分类:contentCategoryId=[%s],contentCategoryDTO=[%s]", contentCategoryId, contentCategoryDTO.toString()));
            return false;
        }
        BeanUtils.copyProperties(contentCategoryDTO, contentCategoryEntity);
        contentCategoryEntity.setUpdatePersonId("xiaomaigou");
        contentCategoryEntity.setUpdateTime(new Date());
        logger.debug(String.format("更新内容（广告）分类:contentCategoryEntity=[%s]", contentCategoryEntity.toString()));
        return this.updateById(contentCategoryEntity);
    }

    @Override
    public Boolean delete(String contentCategoryId) {
        ContentCategoryEntity contentCategoryEntity = this.getById(contentCategoryId);
        if (null == contentCategoryEntity) {
            logger.warn(String.format("删除不存在的内容（广告）分类:contentCategoryId=[%s]", contentCategoryId));
            return false;
        }
        return this.removeById(contentCategoryId);
    }

    @Override
    public Boolean delete(List<String> contentCategoryIdList) {
        if (null == contentCategoryIdList || contentCategoryIdList.isEmpty()) {
            logger.warn("删除空集合内容（广告）分类!");
            return false;
        }
        return this.removeByIds(contentCategoryIdList);
    }
}
