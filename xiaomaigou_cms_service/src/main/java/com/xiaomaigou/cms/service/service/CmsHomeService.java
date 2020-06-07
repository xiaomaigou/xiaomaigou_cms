package com.xiaomaigou.cms.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaomaigou.cms.dao.entity.ContentEntity;

/**
 * 小麦购商城首页接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/7 19:04
 */
public interface CmsHomeService {
    /**
     * 获取首页轮播广告
     *
     * @param pageNo   当前页，默认1
     * @param pageSize 每页显示条数，默认10
     * @return 首页轮播广告
     */
    Page<ContentEntity> listHomeSwiperSlide(Integer pageNo, Integer pageSize);

    /**
     * 获取首页中下部广告
     *
     * @param pageNo   当前页，默认1
     * @param pageSize 每页显示条数，默认10
     * @return 首页中下部广告
     */
    Page<ContentEntity> listHomeSwiperSlideDown(Integer pageNo, Integer pageSize);

    /**
     * 获取首页右部广告
     *
     * @param pageNo              当前页，默认1
     * @param pageSize            每页显示条数，默认10
     * @param contentCategoryCode 分类编号，3右上，4右中，5右下
     * @return 首页右部广告
     */
    Page<ContentEntity> listHomeSwiperSlideRight(Integer pageNo, Integer pageSize, String contentCategoryCode);
}
