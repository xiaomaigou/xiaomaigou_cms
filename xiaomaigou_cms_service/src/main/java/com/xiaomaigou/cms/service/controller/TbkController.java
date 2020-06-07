package com.xiaomaigou.cms.service.controller;

import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.xiaomaigou.cms.common.dto.Result;
import com.xiaomaigou.cms.service.service.TbkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 淘宝客开放平台API接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/7 20:27
 */
@Api(tags = "淘宝客开放平台API", description = "淘宝客开放平台API接口")
@RestController
@RequestMapping("service/tbk")
public class TbkController {

    private static final Logger logger = LoggerFactory.getLogger(CmsHomeController.class);

    @Autowired
    private TbkService tbkService;

    /**
     * 物料精选，通用物料推荐，传入官方公布的物料id，可获取指定物料
     *
     * @param materialId 物料id
     * @param pageSize   页大小
     * @param pageNo     当前页
     * @return
     */
    @ApiOperation(value = "物料精选", notes = "通用物料推荐，传入官方公布的物料id，可获取指定物料，接口文档：https://open.taobao.com/api.htm?docId=33947&docType=2&scopeId=16518 详细物料id：https://tbk.bbs.taobao.com/detail.html?appId=45301&postId=8576096")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "materialId", value = "物料id", paramType = "query", required = false, dataType = "long", defaultValue = "3756"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = false, dataType = "long", defaultValue = "30"),
            @ApiImplicitParam(name = "pageNo", value = "当前页", paramType = "query", required = false, dataType = "long", defaultValue = "1")

    })
    @GetMapping("listTbkDgOptimusMaterial")
    public Result<List<TbkDgOptimusMaterialResponse.MapData>> listTbkDgOptimusMaterial(@RequestParam(name = "materialId", required = false, defaultValue = "3756") Long materialId,
                                                                                       @RequestParam(name = "pageSize", required = false, defaultValue = "30") Long pageSize,
                                                                                       @RequestParam(name = "pageNo", required = false, defaultValue = "1") Long pageNo) {

        try {
            return tbkService.listTbkDgOptimusMaterial(materialId, pageSize, pageNo);
        } catch (Exception e) {
            logger.error("获取物料精选失败!", e);
            return new Result<List<TbkDgOptimusMaterialResponse.MapData>>().fail("获取物料精选失败，请稍后重试!");
        }

    }
}
