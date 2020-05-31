package com.xiaomaigou.cms.service.constant;

import java.io.Serializable;

/**
 * 缓存名称常量
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/1 0:22
 */
public class CacheConstant implements Serializable {

    private static final Long serialVersionUID = 1L;

    // 淘宝联盟缓存名称
    /**
     * 物料精选缓存
     */
    public static final String CACHE_NAME_TBK_TBKDGOPTIMUSMATERIAL_CACHE = "tbk_tbkDgOptimusMaterial_cache";
    /**
     * 通用物料搜索缓存
     */
    public static final String CACHE_NAME_TBK_TBKDGMATERIALOPTIONAL_CACHE = "tbk_tbkDgMaterialOptional_cache";
    /**
     * 聚划算商品搜索缓存
     */
    public static final String CACHE_NAME_TBK_TBKJUITEMSSEARCH_CACHE = "tbk_tbkJuItemsSearch_cache";
    /**
     * 商品关联推荐缓存
     */
    public static final String CACHE_NAME_TBK_TBKITEMRECOMMEND_CACHE = "tbk_tbkItemRecommend_cache";
    /**
     * 店铺关联推荐缓存
     */
    public static final String CACHE_NAME_TBK_TBKSHOPRECOMMEND_CACHE = "tbk_tbkShopRecommend_cache";

    /**
     * 内容(广告)缓存
     */
    public static final String CACHE_NAME_CONTENT_HOMESWIPERSLIDE_CACHE = "content_homeswiperslide_cache";
}
