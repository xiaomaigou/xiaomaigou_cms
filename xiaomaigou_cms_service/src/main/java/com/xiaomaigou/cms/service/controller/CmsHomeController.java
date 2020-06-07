package com.xiaomaigou.cms.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaomaigou.cms.common.dto.Result;
import com.xiaomaigou.cms.dao.entity.ContentEntity;
import com.xiaomaigou.cms.service.service.CmsHomeService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小麦购商城首页接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/6/7 18:59
 */
@Api(tags = "首页-小麦购商城", description = "小麦购商城首页接口")
@RestController
@RequestMapping("service/cmsHome")
public class CmsHomeController {

    private static final Logger logger = LoggerFactory.getLogger(CmsHomeController.class);

    @Autowired
    private CmsHomeService cmsHomeService;

    @ApiOperation(value = "首页轮播广告", notes = "获取首页轮播广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10")
    })
    @GetMapping("listHomeSwiperSlide")
    public Result<Page<ContentEntity>> listHomeSwiperSlide(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Result<Page<ContentEntity>> result = new Result<>();
        try {
            Page<ContentEntity> contentEntityPage = cmsHomeService.listHomeSwiperSlide(pageNo, pageSize);
            return result.success(contentEntityPage);
        } catch (Exception e) {
            logger.error(String.format("获取首页轮播广告失败!pageNo=[%s],pageSize=[%s]", pageNo, pageSize), e);
            return result.fail("获取轮播广告失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "首页中下部广告", notes = "获取首页中下部广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10")
    })
    @GetMapping("listHomeSwiperSlideDown")
    public Result<Page<ContentEntity>> listHomeSwiperSlideDown(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Result<Page<ContentEntity>> result = new Result<>();
        try {
            Page<ContentEntity> contentEntityPage = cmsHomeService.listHomeSwiperSlideDown(pageNo, pageSize);
            return result.success(contentEntityPage);
        } catch (Exception e) {
            logger.error(String.format("获取首页中下部广告失败!pageNo=[%s],pageSize=[%s]", pageNo, pageSize), e);
            return result.fail("获取中下部广告失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "首页右部广告", notes = "获取首页右部广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10")
    })
    @GetMapping("listHomeSwiperSlideRight")
    public Result<Map<String, List<ContentEntity>>> listHomeSwiperSlideRight(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Result<Map<String, List<ContentEntity>>> result = new Result<>();
        Map<String, List<ContentEntity>> listMap = new HashMap<>(16);
        try {
            Page<ContentEntity> rightUp = cmsHomeService.listHomeSwiperSlideRight(pageNo, pageSize, "3");
            Page<ContentEntity> rightMiddle = cmsHomeService.listHomeSwiperSlideRight(pageNo, pageSize, "4");
            Page<ContentEntity> rightDowm = cmsHomeService.listHomeSwiperSlideRight(pageNo, pageSize, "5");
            listMap.put("rightUp", rightUp.getRecords());
            listMap.put("rightMiddle", rightMiddle.getRecords());
            listMap.put("rightDowm", rightDowm.getRecords());
            return result.success(listMap);
        } catch (Exception e) {
            logger.error(String.format("获取首页中下部广告失败!pageNo=[%s],pageSize=[%s]", pageNo, pageSize), e);
            return result.fail("获取中下部广告失败，请稍后重试!");
        }
    }
}
