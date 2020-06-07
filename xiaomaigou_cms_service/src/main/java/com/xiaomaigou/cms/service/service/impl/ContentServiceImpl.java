package com.xiaomaigou.cms.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.xiaomaigou.cms.dao.entity.ContentEntity;
import com.xiaomaigou.cms.dao.mapper.ContentMapper;
import com.xiaomaigou.cms.service.dto.ContentDTO;
import com.xiaomaigou.cms.service.service.ContentService;

import java.util.List;
import java.util.Date;

/**
 * 内容（广告）接口实现
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 17:48:01
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, ContentEntity> implements ContentService {

    private static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

    @Override
    public List<ContentEntity> listAll() {
        QueryWrapper<ContentEntity> contentEntityQueryWrapper = new QueryWrapper<>();
        contentEntityQueryWrapper.orderByDesc("content_id");
        return this.list(contentEntityQueryWrapper);
    }

    @Override
    public Page<ContentEntity> listAllPage(Integer pageNo, Integer pageSize) {
        if (null == pageNo || pageNo < 1) {
            pageNo = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        QueryWrapper<ContentEntity> contentEntityQueryWrapper = new QueryWrapper<>();
        contentEntityQueryWrapper.orderByDesc("content_id");
        return this.page(new Page<>(pageNo, pageSize), contentEntityQueryWrapper);
    }

    @Override
    public Page<ContentEntity> search(Integer pageNo, Integer pageSize, String contentCategoryCode, String contentTitle, String contentSubtitle, String contentDescription, String sourceTypeCode, String createPersonId, Integer status) {
        if (null == pageNo || pageNo < 1) {
            pageNo = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        QueryWrapper<ContentEntity> contentEntityQueryWrapper = new QueryWrapper<>();
        contentEntityQueryWrapper.eq(StringUtils.isNotEmpty(contentCategoryCode), "content_category_code", contentCategoryCode);
        contentEntityQueryWrapper.like(StringUtils.isNotEmpty(contentTitle), "content_title", contentTitle);
        contentEntityQueryWrapper.like(StringUtils.isNotEmpty(contentSubtitle), "content_subtitle", contentSubtitle);
        contentEntityQueryWrapper.like(StringUtils.isNotEmpty(contentDescription), "content_description", contentDescription);
        contentEntityQueryWrapper.eq(StringUtils.isNotEmpty(sourceTypeCode), "source_type_code", sourceTypeCode);
        contentEntityQueryWrapper.eq(StringUtils.isNotEmpty(createPersonId), "create_person_id", createPersonId);
        contentEntityQueryWrapper.eq(status != null, "status", status);
        contentEntityQueryWrapper.orderByAsc("sort_order").orderByDesc("create_time", "update_time");
        return this.page(new Page<>(pageNo, pageSize), contentEntityQueryWrapper);
    }

    @Override
    public ContentEntity detail(String contentId) {
        return this.getById(contentId);
    }

    @Override
    public Boolean add(ContentDTO contentDTO) {
        ContentEntity contentEntity = new ContentEntity();
        BeanUtils.copyProperties(contentDTO, contentEntity);
        contentEntity.setContentId(IdWorker.getIdStr());
        contentEntity.setCreatePersonId("xiaomaigou");
        contentEntity.setUpdatePersonId("xiaomaigou");
        contentEntity.setCreateTime(new Date());
        contentEntity.setUpdateTime(new Date());
        contentEntity.setStatus(1);
        logger.debug(String.format("新增内容（广告）:contentEntity=[%s]", contentEntity.toString()));
        return this.save(contentEntity);
    }

    @Override
    public Boolean update(String contentId, ContentDTO contentDTO) {
        ContentEntity contentEntity = this.getById(contentId);
        if (null == contentEntity) {
            logger.warn(String.format("更新不存在的内容（广告）:contentId=[%s],contentDTO=[%s]", contentId, contentDTO.toString()));
            return false;
        }
        BeanUtils.copyProperties(contentDTO, contentEntity);
        contentEntity.setUpdatePersonId("xiaomaigou");
        contentEntity.setUpdateTime(new Date());
        logger.debug(String.format("更新内容（广告）:contentEntity=[%s]", contentEntity.toString()));
        return this.updateById(contentEntity);
    }

    @Override
    public Boolean delete(String contentId) {
        ContentEntity contentEntity = this.getById(contentId);
        if (null == contentEntity) {
            logger.warn(String.format("删除不存在的内容（广告）:contentId=[%s]", contentId));
            return false;
        }
        return this.removeById(contentId);
    }

    @Override
    public Boolean delete(List<String> contentIdList) {
        if (null == contentIdList || contentIdList.isEmpty()) {
            logger.warn("删除空集合内容（广告）!");
            return false;
        }
        return this.removeByIds(contentIdList);
    }
}
