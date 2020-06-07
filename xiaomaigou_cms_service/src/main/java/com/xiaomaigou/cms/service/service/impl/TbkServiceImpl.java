package com.xiaomaigou.cms.service.service.impl;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.xiaomaigou.cms.common.dto.Result;
import com.xiaomaigou.cms.service.config.ApiConfig;
import com.xiaomaigou.cms.service.constant.CacheConstant;
import com.xiaomaigou.cms.service.service.TbkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 淘宝客开放平台API接口实现
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/7 20:37
 */
@Service
public class TbkServiceImpl implements TbkService {

    private static final Logger logger = LoggerFactory.getLogger(TbkServiceImpl.class);

    @Override
    @Cacheable(cacheNames = CacheConstant.CACHE_NAME_TBK_TBKDGOPTIMUSMATERIAL_CACHE, unless = "#result.code!=200 || #result.data.isEmpty()")
    public Result<List<TbkDgOptimusMaterialResponse.MapData>> listTbkDgOptimusMaterial(Long materialId, Long pageSize, Long pageNo) {

        Result<List<TbkDgOptimusMaterialResponse.MapData>> result = new Result<>();

        logger.info(String.format("准备获取物料精选:materialId=%s,pageSize=%s,pageNo=%s", materialId, pageSize, pageNo));

        TaobaoClient client = new DefaultTaobaoClient(ApiConfig.TAOBAO_TBK_API_URL, ApiConfig.TAOBAO_TBK_API_APPKEY, ApiConfig.TAOBAO_TBK_API_APPSECRET);

        TbkDgOptimusMaterialRequest req = new TbkDgOptimusMaterialRequest();
        req.setAdzoneId(Long.parseLong(ApiConfig.TAOBAO_TBK_API_ADZONEID));
        req.setMaterialId(materialId);
        req.setPageNo(pageNo);
        req.setPageSize(pageSize);

        try {
            TbkDgOptimusMaterialResponse response = client.execute(req);
            if (response.isSuccess()) {
                return result.success(response.getResultList());
            }
        } catch (ApiException e) {
            logger.error("获取物料精选失败!", e);
        }

        return result.fail("获取物料精选失败，请稍后重试!");
    }
}
