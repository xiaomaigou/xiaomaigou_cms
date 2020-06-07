package com.xiaomaigou.cms.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xiaomaigou.cms.common.dto.Result;
import com.xiaomaigou.cms.dao.entity.SourceTypeEntity;
import com.xiaomaigou.cms.service.dto.SourceTypeDTO;
import com.xiaomaigou.cms.service.service.SourceTypeService;

import java.util.Arrays;
import java.util.List;
import java.util.Date;

/**
 * 来源类型
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 18:02:13
 */
@Api(tags = "来源类型", description = "来源类型相关接口")
@RestController
@RequestMapping("service/sourceType")
public class SourceTypeController {

    private static final Logger logger = LoggerFactory.getLogger(SourceTypeController.class);

    @Autowired
    private SourceTypeService sourceTypeService;

    @ApiOperation(value = "所有来源类型", notes = "获取所有来源类型")
    @GetMapping("listAll")
    public Result<List<SourceTypeEntity>> listAll() {
        Result<List<SourceTypeEntity>> result = new Result<>();
        try {
            List<SourceTypeEntity> sourceTypeEntityList = sourceTypeService.listAll();
            return result.success(sourceTypeEntityList);
        } catch (Exception e) {
            logger.error("获取来源类型失败!", e);
            return result.fail("获取来源类型失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "来源类型(分页)", notes = "获取来源类型(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10")
    })
    @GetMapping("listAllPage")
    public Result<Page<SourceTypeEntity>> listAllPage(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Result<Page<SourceTypeEntity>> result = new Result<>();
        try {
            Page<SourceTypeEntity> sourceTypeEntityPage = sourceTypeService.listAllPage(pageNo, pageSize);
            return result.success(sourceTypeEntityPage);
        } catch (Exception e) {
            logger.error(String.format("获取来源类型失败!pageNo=[%s],pageSize=[%s]", pageNo, pageSize), e);
            return result.fail("获取来源类型失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "搜索来源类型(分页)", notes = "搜索来源类型(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页，默认1", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数，默认10", paramType = "query", required = false, dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(name = "sourceTypeCode", value = "来源code", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sourceTypeName", value = "来源名称", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "createPersonId", value = "创建人ID", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "状态，-1删除，0无效，1有效", paramType = "query", required = false, dataType = "Integer")})
    @GetMapping("search")
    public Result<Page<SourceTypeEntity>> search(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                 @RequestParam(value = "sourceTypeCode", required = false) String sourceTypeCode,
                                                 @RequestParam(value = "sourceTypeName", required = false) String sourceTypeName,
                                                 @RequestParam(value = "createPersonId", required = false) String createPersonId,
                                                 @RequestParam(value = "status", required = false) Integer status) {

        Result<Page<SourceTypeEntity>> result = new Result<>();
        try {
            Page<SourceTypeEntity> sourceTypeEntityPage = sourceTypeService.search(pageNo, pageSize, sourceTypeCode, sourceTypeName, createPersonId, status);
            return result.success(sourceTypeEntityPage);
        } catch (Exception e) {
            logger.error(String.format("搜索来源类型失败!sourceTypeCode=[%s],sourceTypeName=[%s],createPersonId=[%s],status=[%s]", sourceTypeCode, sourceTypeName, createPersonId, status), e);
            return result.fail("搜索来源类型失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "来源类型详情", notes = "根据来源类型ID获取来源类型详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sourceTypeId", value = "来源类型ID", paramType = "path", required = true, dataType = "String")
    })
    @GetMapping("detail/{sourceTypeId}")
    public Result<SourceTypeEntity> detail(@PathVariable(value = "sourceTypeId", required = true) String sourceTypeId) {
        Result<SourceTypeEntity> result = new Result<>();
        try {
            SourceTypeEntity sourceTypeEntity = sourceTypeService.detail(sourceTypeId);
            if (sourceTypeEntity == null) {
                return result.notFound("查询的来源类型不存在!");
            } else {
                return result.success(sourceTypeEntity);
            }
        } catch (Exception e) {
            logger.error(String.format("获取来源类型详情失败!sourceTypeId=[%s]", sourceTypeId), e);
            return result.fail("获取来源类型详情失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "新增来源类型", notes = "新增来源类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sourceTypeDTO", value = "来源类型信息", paramType = "body", required = true, dataType = "SourceTypeDTO")
    })
    @PostMapping("add")
    public Result add(@RequestBody SourceTypeDTO sourceTypeDTO) {
        Result result = new Result<>();
        try {
            Boolean success = sourceTypeService.add(sourceTypeDTO);
            if (success) {
                return result.success("新增来源类型成功!");
            } else {
                logger.warn(String.format("新增来源类型失败!sourceTypeDTO=[%s]", sourceTypeDTO.toString()));
                return result.fail("新增来源类型失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("新增来源类型失败!sourceTypeDTO=[%s]", sourceTypeDTO.toString()), e);
            return result.fail("新增来源类型失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "更新来源类型", notes = "根据来源类型ID更新来源类型详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sourceTypeId", value = "来源类型ID", paramType = "path", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sourceTypeDTO", value = "来源类型信息", paramType = "body", required = true, dataType = "SourceTypeDTO")
    })
    @PutMapping("update/{sourceTypeId}")
    public Result update(@PathVariable(value = "sourceTypeId", required = true) String sourceTypeId, @RequestBody SourceTypeDTO sourceTypeDTO) {
        Result result = new Result<>();
        try {
            Boolean success = sourceTypeService.update(sourceTypeId, sourceTypeDTO);
            if (success) {
                return result.success("更新来源类型成功!");
            } else {
                logger.warn(String.format("更新来源类型失败!sourceTypeId=[%s],sourceTypeDTO=[%s]", sourceTypeId, sourceTypeDTO.toString()));
                return result.fail("更新来源类型失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("更新来源类型失败!sourceTypeId=[%s],sourceTypeDTO=[%s]", sourceTypeId, sourceTypeDTO.toString()), e);
            return result.fail("更新来源类型失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "删除来源类型", notes = "根据来源类型ID删除来源类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sourceTypeId", value = "来源类型ID", paramType = "path", required = true, dataType = "String")
    })
    @DeleteMapping("delete/{sourceTypeId}")
    public Result delete(@PathVariable(value = "sourceTypeId", required = true) String sourceTypeId) {
        Result result = new Result<>();
        try {
            Boolean success = sourceTypeService.delete(sourceTypeId);
            if (success) {
                return result.success("删除来源类型成功!");
            } else {
                logger.warn(String.format("删除来源类型失败!sourceTypeId=[%s]", sourceTypeId));
                return result.fail("删除来源类型失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("删除来源类型失败!sourceTypeId=[%s]", sourceTypeId), e);
            return result.fail("删除来源类型失败，请稍后重试!");
        }
    }

    @ApiOperation(value = "删除来源类型(多条记录)", notes = "根据来源类型ID删除来源类型(多条记录)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sourceTypeIds", value = "来源类型ID(多个ID之间使用逗号\",\"分隔)", paramType = "query", required = true, dataType = "String")
    })
    @DeleteMapping("delete")
    public Result deletes(@RequestParam(value = "sourceTypeIds", required = true) String sourceTypeIds) {
        Result result = new Result<>();

        List<String> sourceTypeIdList = Arrays.asList(sourceTypeIds.split(","));
        if (sourceTypeIdList.isEmpty()) {
            return result.badRequest("请至少选择一条记录!");
        }
        try {
            Boolean success = sourceTypeService.delete(sourceTypeIdList);
            if (success) {
                return result.success("删除来源类型成功!");
            } else {
                logger.warn(String.format("删除来源类型失败!sourceTypeIdList=[%s]", sourceTypeIdList.toString()));
                return result.fail("删除来源类型失败，请稍后重试!");
            }
        } catch (Exception e) {
            logger.error(String.format("删除来源类型失败!sourceTypeIdList=[%s]", sourceTypeIdList.toString()), e);
            return result.fail("删除来源类型失败，请稍后重试!");
        }
    }
}
