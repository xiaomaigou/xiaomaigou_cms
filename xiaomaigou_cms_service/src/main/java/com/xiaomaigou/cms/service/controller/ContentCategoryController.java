package com.xiaomaigou.cms.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaomaigou.cms.common.dto.Result;
import com.xiaomaigou.cms.dao.entity.ContentCategoryEntity;
import com.xiaomaigou.cms.service.dto.ContentCategoryDTO;
import com.xiaomaigou.cms.service.service.ContentCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 内容（广告）分类
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:14
 */
@Api(tags = "内容（广告）分类", description = "内容（广告）分类相关接口")
@RestController
@RequestMapping("service/contentCategory")
public class ContentCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(ContentCategoryController.class);

    @Autowired
    private ContentCategoryService contentCategoryService;

    @ApiOperation(value = "所有内容（广告）分类", notes = "获取所有内容（广告）分类")
    @GetMapping("listAll")
    public Result<List<ContentCategoryEntity>> listAll() {
        Result<List<ContentCategoryEntity>> result = new Result<>();
        try {
            List<ContentCategoryEntity> contentCategoryEntityList = contentCategoryService.listAll();
            return result.success(contentCategoryEntityList);
        } catch (Exception e) {
            logger.error("获取内容（广告）分类失败!", e);
            return result.fail("获取内容（广告）分类失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "所有内容（广告）分类(分页)", notes = "获取所有内容（广告）分类(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10")
    })
    @GetMapping("listAllPage")
    public Result<Page<ContentCategoryEntity>> listAllPage(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Result<Page<ContentCategoryEntity>> result = new Result<>();
        try {
            Page<ContentCategoryEntity> contentCategoryEntityPage = contentCategoryService.listAllPage(pageNo, pageSize);
            return result.success(contentCategoryEntityPage);
        } catch (Exception e) {
            logger.error(String.format("获取内容（广告）分类失败!pageNo=[%s],pageSize=[%s]", pageNo, pageSize), e);
            return result.fail("获取内容（广告）分类失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "搜索内容（广告）分类(分页)", notes = "搜索内容（广告）分类(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(name = "contentCategoryCode", value = "内容分类code", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "contentCategoryName", value = "分类名称", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "createPersonId", value = "创建人ID", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "状态，-1删除，0无效，1有效", paramType = "query", required = false, dataType = "int")})
    @GetMapping("search")
    public Result<Page<ContentCategoryEntity>> search(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                      @RequestParam(value = "contentCategoryCode", required = false) String contentCategoryCode,
                                                      @RequestParam(value = "contentCategoryName", required = false) String contentCategoryName,
                                                      @RequestParam(value = "createPersonId", required = false) String createPersonId,
                                                      @RequestParam(value = "status", required = false) Integer status) {

        Result<Page<ContentCategoryEntity>> result = new Result<>();
        try {
            Page<ContentCategoryEntity> contentCategoryEntityPage = contentCategoryService.search(pageNo, pageSize, contentCategoryCode, contentCategoryName, createPersonId, status);
            return result.success(contentCategoryEntityPage);
        } catch (Exception e) {
            logger.error(String.format("搜索内容（广告）分类失败!pageNo=[%s],pageSize=[%s],contentCategoryCode=[%s],contentCategoryName=[%s],createPersonId=[%s],status=[%s]", pageNo, pageSize, contentCategoryCode, contentCategoryName, createPersonId, status), e);
            return result.fail("搜索内容（广告）分类失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "内容（广告）分类详情", notes = "根据内容（广告）分类ID获取内容（广告）分类详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentCategoryId", value = "内容（广告）分类ID", paramType = "path", required = true, dataType = "String")
    })
    @GetMapping("detail/{contentCategoryId}")
    public Result<ContentCategoryEntity> detail(@PathVariable(value = "contentCategoryId", required = true) String contentCategoryId) {
        Result<ContentCategoryEntity> result = new Result<>();
        try {
            ContentCategoryEntity contentCategoryEntity = contentCategoryService.detail(contentCategoryId);
            if (contentCategoryEntity == null) {
                return result.notFound("查询的内容（广告）分类不存在!");
            } else {
                return result.success(contentCategoryEntity);
            }
        } catch (Exception e) {
            logger.error(String.format("获取内容（广告）分类详情失败!contentCategoryId=[%s]", contentCategoryId), e);
            return result.fail("获取内容（广告）分类详情失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "新增内容（广告）分类", notes = "新增内容（广告）分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentCategoryDTO", value = "内容（广告）分类信息", paramType = "body", required = true, dataType = "ContentCategoryDTO")
    })
    @PostMapping("add")
    public Result add(@RequestBody ContentCategoryDTO contentCategoryDTO) {
        Result result = new Result<>();
        try {
            Boolean success = contentCategoryService.add(contentCategoryDTO);
            if (success) {
                return result.success("新增内容（广告）分类成功!");
            } else {
                logger.warn(String.format("新增内容（广告）分类失败!contentCategoryDTO=[%s]", contentCategoryDTO.toString()));
                return result.fail("新增内容（广告）分类失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("新增内容（广告）分类失败!contentCategoryDTO=[%s]", contentCategoryDTO.toString()), e);
            return result.fail("新增内容（广告）分类失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "更新内容（广告）分类", notes = "根据内容（广告）分类ID更新内容（广告）分类详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentCategoryId", value = "内容（广告）分类ID", paramType = "path", required = true, dataType = "String"),
            @ApiImplicitParam(name = "contentCategoryDTO", value = "内容（广告）分类信息", paramType = "body", required = true, dataType = "ContentCategoryDTO")
    })
    @PutMapping("update/{contentCategoryId}")
    public Result update(@PathVariable(value = "contentCategoryId", required = true) String contentCategoryId, @RequestBody ContentCategoryDTO contentCategoryDTO) {
        Result result = new Result<>();
        try {
            Boolean success = contentCategoryService.update(contentCategoryId, contentCategoryDTO);
            if (success) {
                return result.success("更新内容（广告）分类成功!");
            } else {
                logger.warn(String.format("更新内容（广告）分类失败!contentCategoryId=[%s],contentCategoryDTO=[%s]", contentCategoryId, contentCategoryDTO.toString()));
                return result.fail("更新内容（广告）分类失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("更新内容（广告）分类失败!contentCategoryId=[%s],contentCategoryDTO=[%s]", contentCategoryId, contentCategoryDTO.toString()), e);
            return result.fail("更新内容（广告）分类失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "删除内容（广告）分类", notes = "根据内容（广告）分类ID删除内容（广告）分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentCategoryId", value = "内容（广告）分类ID", paramType = "path", required = true, dataType = "String")
    })
    @DeleteMapping("delete/{contentCategoryId}")
    public Result delete(@PathVariable(value = "contentCategoryId", required = true) String contentCategoryId) {
        Result result = new Result<>();
        try {
            Boolean success = contentCategoryService.delete(contentCategoryId);
            if (success) {
                return result.success("删除内容（广告）分类成功!");
            } else {
                logger.warn(String.format("删除内容（广告）分类失败!contentCategoryId=[%s]", contentCategoryId));
                return result.fail("删除内容（广告）分类失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("删除内容（广告）分类失败!contentCategoryId=[%s]", contentCategoryId), e);
            return result.fail("删除内容（广告）分类失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "删除内容（广告）分类(多条记录)", notes = "根据内容（广告）分类ID删除内容（广告）分类(多条记录)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentCategoryIds", value = "内容（广告）分类ID(多个ID之间使用逗号\",\"分隔)", paramType = "query", required = true, dataType = "String")
    })
    @DeleteMapping("delete")
    public Result deletes(@RequestParam(value = "contentCategoryIds", required = true) String contentCategoryIds) {
        Result result = new Result<>();

        List<String> contentCategoryIdList = Arrays.asList(contentCategoryIds.split(","));
        if (contentCategoryIdList.isEmpty()) {
            return result.badRequest("请至少选择一条记录!");
        }
        try {
            Boolean success = contentCategoryService.delete(contentCategoryIdList);
            if (success) {
                return result.success("删除内容（广告）分类成功!");
            } else {
                logger.warn(String.format("删除内容（广告）分类失败!contentCategoryIdList=[%s]", contentCategoryIdList.toString()));
                return result.fail("删除内容（广告）分类失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("删除内容（广告）分类失败!contentCategoryIdList=[%s]", contentCategoryIdList.toString()), e);
            return result.fail("删除内容（广告）分类失败，请稍后重试!");
        }
    }
}