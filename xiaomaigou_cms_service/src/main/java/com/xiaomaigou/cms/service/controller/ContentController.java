package com.xiaomaigou.cms.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaomaigou.cms.service.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xiaomaigou.cms.common.dto.Result;
import com.xiaomaigou.cms.dao.entity.ContentEntity;
import com.xiaomaigou.cms.service.dto.ContentDTO;

import java.util.Arrays;
import java.util.List;

/**
 * 内容（广告）
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 17:48:01
 */
@Api(tags = "内容（广告）", description = "内容（广告）相关接口")
@RestController
@RequestMapping("service/content")
public class ContentController {

    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @ApiOperation(value = "所有内容（广告）", notes = "获取所有内容（广告）")
    @GetMapping("listAll")
    public Result<List<ContentEntity>> listAll() {
        Result<List<ContentEntity>> result = new Result<>();
        try {
            List<ContentEntity> contentEntityList = contentService.listAll();
            return result.success(contentEntityList);
        } catch (Exception e) {
            logger.error("获取内容（广告）失败!", e);
            return result.fail("获取内容（广告）失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "内容（广告）(分页)", notes = "获取内容（广告）(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10")
    })
    @GetMapping("listAllPage")
    public Result<Page<ContentEntity>> listAllPage(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Result<Page<ContentEntity>> result = new Result<>();
        try {
            Page<ContentEntity> contentEntityPage = contentService.listAllPage(pageNo, pageSize);
            return result.success(contentEntityPage);
        } catch (Exception e) {
            logger.error(String.format("获取内容（广告）失败!pageNo=[%s],pageSize=[%s]", pageNo, pageSize), e);
            return result.fail("获取内容（广告）失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "搜索内容（广告）(分页)", notes = "搜索内容（广告）(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(name = "contentCategoryCode", value = "内容分类code", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "contentTitle", value = "内容标题", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "contentSubtitle", value = "内容副标题", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "contentDescription", value = "内容描述", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sourceTypeCode", value = "来源code", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "createPersonId", value = "创建人ID", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "状态，-1删除，0无效，1有效", paramType = "query", required = false, dataType = "int")})
    @GetMapping("search")
    public Result<Page<ContentEntity>> search(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "contentCategoryCode", required = false) String contentCategoryCode,
                                              @RequestParam(value = "contentTitle", required = false) String contentTitle,
                                              @RequestParam(value = "contentSubtitle", required = false) String contentSubtitle,
                                              @RequestParam(value = "contentDescription", required = false) String contentDescription,
                                              @RequestParam(value = "sourceTypeCode", required = false) String sourceTypeCode,
                                              @RequestParam(value = "createPersonId", required = false) String createPersonId,
                                              @RequestParam(value = "status", required = false) Integer status) {

        Result<Page<ContentEntity>> result = new Result<>();
        try {
            Page<ContentEntity> contentEntityPage = contentService.search(pageNo, pageSize, contentCategoryCode, contentTitle, contentSubtitle, contentDescription, sourceTypeCode, createPersonId, status);
            return result.success(contentEntityPage);
        } catch (Exception e) {
            logger.error(String.format("搜索内容（广告）失败!contentCategoryCode=[%s],contentTitle=[%s],contentSubtitle=[%s],contentDescription=[%s],sourceTypeCode=[%s],createPersonId=[%s],status=[%s]", contentCategoryCode, contentTitle, contentSubtitle, contentDescription, sourceTypeCode, createPersonId, status), e);
            return result.fail("搜索内容（广告）失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "内容（广告）详情", notes = "根据内容（广告）ID获取内容（广告）详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "内容（广告）ID", paramType = "path", required = true, dataType = "String")
    })
    @GetMapping("detail/{contentId}")
    public Result<ContentEntity> detail(@PathVariable(value = "contentId", required = true) String contentId) {
        Result<ContentEntity> result = new Result<>();
        try {
            ContentEntity contentEntity = contentService.detail(contentId);
            if (contentEntity == null) {
                return result.notFound("查询的内容（广告）不存在!");
            } else {
                return result.success(contentEntity);
            }
        } catch (Exception e) {
            logger.error(String.format("获取内容（广告）详情失败!contentId=[%s]", contentId), e);
            return result.fail("获取内容（广告）详情失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "新增内容（广告）", notes = "新增内容（广告）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentDTO", value = "内容（广告）信息", paramType = "body", required = true, dataType = "ContentDTO")
    })
    @PostMapping("add")
    public Result add(@RequestBody ContentDTO contentDTO) {
        Result result = new Result<>();
        try {
            Boolean success = contentService.add(contentDTO);
            if (success) {
                return result.success("新增内容（广告）成功!");
            } else {
                logger.warn(String.format("新增内容（广告）失败!contentDTO=[%s]", contentDTO.toString()));
                return result.fail("新增内容（广告）失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("新增内容（广告）失败!contentDTO=[%s]", contentDTO.toString()), e);
            return result.fail("新增内容（广告）失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "更新内容（广告）", notes = "根据内容（广告）ID更新内容（广告）详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "内容（广告）ID", paramType = "path", required = true, dataType = "String"),
            @ApiImplicitParam(name = "contentDTO", value = "内容（广告）信息", paramType = "body", required = true, dataType = "ContentDTO")
    })
    @PutMapping("update/{contentId}")
    public Result update(@PathVariable(value = "contentId", required = true) String contentId, @RequestBody ContentDTO contentDTO) {
        Result result = new Result<>();
        try {
            Boolean success = contentService.update(contentId, contentDTO);
            if (success) {
                return result.success("更新内容（广告）成功!");
            } else {
                logger.warn(String.format("更新内容（广告）失败!contentId=[%s],contentDTO=[%s]", contentId, contentDTO.toString()));
                return result.fail("更新内容（广告）失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("更新内容（广告）失败!contentId=[%s],contentDTO=[%s]", contentId, contentDTO.toString()), e);
            return result.fail("更新内容（广告）失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "删除内容（广告）", notes = "根据内容（广告）ID删除内容（广告）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "内容（广告）ID", paramType = "path", required = true, dataType = "String")
    })
    @DeleteMapping("delete/{contentId}")
    public Result delete(@PathVariable(value = "contentId", required = true) String contentId) {
        Result result = new Result<>();
        try {
            Boolean success = contentService.delete(contentId);
            if (success) {
                return result.success("删除内容（广告）成功!");
            } else {
                logger.warn(String.format("删除内容（广告）失败!contentId=[%s]", contentId));
                return result.fail("删除内容（广告）失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("删除内容（广告）失败!contentId=[%s]", contentId), e);
            return result.fail("删除内容（广告）失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "删除内容（广告）(多条记录)", notes = "根据内容（广告）ID删除内容（广告）(多条记录)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentIds", value = "内容（广告）ID(多个ID之间使用逗号\",\"分隔)", paramType = "query", required = true, dataType = "String")
    })
    @DeleteMapping("delete")
    public Result deletes(@RequestParam(value = "contentIds", required = true) String contentIds) {
        Result result = new Result<>();

        List<String> contentIdList = Arrays.asList(contentIds.split(","));
        if (contentIdList.isEmpty()) {
            return result.badRequest("请至少选择一条记录!");
        }
        try {
            Boolean success = contentService.delete(contentIdList);
            if (success) {
                return result.success("删除内容（广告）成功!");
            } else {
                logger.warn(String.format("删除内容（广告）失败!contentIdList=[%s]", contentIdList.toString()));
                return result.fail("删除内容（广告）失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("删除内容（广告）失败!contentIdList=[%s]", contentIdList.toString()), e);
            return result.fail("删除内容（广告）失败，请稍后重试!");
        }
    }
}
