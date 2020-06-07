package com.xiaomaigou.cms.service.service;

import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.xiaomaigou.cms.common.dto.Result;

import java.util.List;

/**
 * 淘宝客开放平台API接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/7 20:31
 */
public interface TbkService {

    /**
     * 物料精选，通用物料推荐，传入官方公布的物料id，可获取指定物料
     * <p>
     * 接口文档：https://open.taobao.com/api.htm?docId=33947&docType=2&scopeId=16518 详细物料id：https://tbk.bbs.taobao.com/detail.html?appId=45301&postId=8576096
     *
     * @param materialId 物料ID
     * @param pageSize   页大小
     * @param pageNo     当前页
     * @return 物料精选
     */
    Result<List<TbkDgOptimusMaterialResponse.MapData>> listTbkDgOptimusMaterial(Long materialId, Long pageSize, Long pageNo);
}
