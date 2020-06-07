package com.xiaomaigou.cms.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaomaigou.cms.dao.entity.ContentEntity;
import com.xiaomaigou.cms.service.constant.CacheConstant;
import com.xiaomaigou.cms.service.service.CmsHomeService;
import com.xiaomaigou.cms.service.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 小麦购商城首页接口实现
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/7 19:11
 */
@Service
public class CmsHomeServiceImpl implements CmsHomeService {

    private static final Logger logger = LoggerFactory.getLogger(CmsHomeServiceImpl.class);

    @Autowired
    private ContentService contentService;

    @Override
    @Cacheable(cacheNames = CacheConstant.CACHE_NAME_CONTENT_HOMESWIPERSLIDE_CACHE, unless = "#result==null || #result.total==0 || #result.records.isEmpty()")
    public Page<ContentEntity> listHomeSwiperSlide(Integer pageNo, Integer pageSize) {
        Page<ContentEntity> contentEntityPage = contentService.search(pageNo, pageSize, "1", null, null, null, null, null, 1);
        logger.info(String.format("从数据库中查询首页轮播广告放入缓存:size=[%s],contentEntityList=[%s]", contentEntityPage.getRecords().size(), contentEntityPage.getRecords().toString()));
        return contentEntityPage;
    }

    @Override
    @Cacheable(cacheNames = CacheConstant.CACHE_NAME_CONTENT_HOMESWIPERSLIDEDOWN_CACHE, unless = "#result==null || #result.total==0 || #result.records.isEmpty()")
    public Page<ContentEntity> listHomeSwiperSlideDown(Integer pageNo, Integer pageSize) {

        Page<ContentEntity> contentEntityPage = contentService.search(pageNo, pageSize, "2", null, null, null, null, null, 1);
        logger.info(String.format("从数据库中查询首页中下部广告放入缓存:size=[%s],contentEntityList=[%s]", contentEntityPage.getRecords().size(), contentEntityPage.getRecords().toString()));
        return contentEntityPage;
    }

    @Override
    @Cacheable(cacheNames = CacheConstant.CACHE_NAME_CONTENT_HOMESWIPERSLIDERIGHT_CACHE, unless = "#result==null || #result.total==0 || #result.records.isEmpty()")
    public Page<ContentEntity> listHomeSwiperSlideRight(Integer pageNo, Integer pageSize, String contentCategoryCode) {

        Page<ContentEntity> contentEntityPage = contentService.search(pageNo, pageSize, contentCategoryCode, null, null, null, null, null, 1);
        logger.info(String.format("从数据库中查询首页右部广告放入缓存:contentCategoryCode=[%s],size=[%s],contentEntityList=[%s]", contentCategoryCode, contentEntityPage.getRecords().size(), contentEntityPage.getRecords().toString()));
        return contentEntityPage;
    }

}
