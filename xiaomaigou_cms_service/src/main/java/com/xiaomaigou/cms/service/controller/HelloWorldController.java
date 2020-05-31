package com.xiaomaigou.cms.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaomaigou.cms.common.dto.Result;
import com.xiaomaigou.cms.dao.entity.HelloWorldEntity;
import com.xiaomaigou.cms.service.service.HelloWorldService;
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
 * HelloWorld接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:13
 */
@Api(tags = "HelloWorld", description = "HelloWorld接口")
@RestController
@RequestMapping("")
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private HelloWorldService helloWorldService;

    @ApiOperation(value = "健康检查", notes = "健康检查")
    @GetMapping("healthCheck")
    public Boolean healthCheck() {
        return true;
    }

    @ApiOperation(value = "helloworld", notes = "获取helloworld")
    @GetMapping("helloworld")
    public String helloworld() {
        return "HelloWorld!";
    }

    @ApiOperation(value = "URL", notes = "获取URL")
    @GetMapping("getUrl")
    public String getUrl() {
        return helloWorldService.getUrl();
    }

    @ApiOperation(value = "获取所有tb_helloworld表数据", notes = "获取所有tb_helloworld表数据")
    @GetMapping("listAllHelloWorld")
    public Result<List<HelloWorldEntity>> listAllHelloWorld() {
        List<HelloWorldEntity> helloWorldEntities = helloWorldService.listAllHelloWorld();
        return new Result<List<HelloWorldEntity>>().success(helloWorldEntities);
    }

    @ApiOperation(value = "获取所有tb_helloworld表数据(分页)", notes = "获取所有tb_helloworld表数据(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", paramType = "query", required = false, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = false, dataType = "int", defaultValue = "10")
    })
    @GetMapping("listPageHelloWorld")
    public Result<Page<HelloWorldEntity>> listPageHelloWorld(@RequestParam(required = false, defaultValue = "1") Integer pageNo, @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        Page<HelloWorldEntity> helloWorldEntityPage = helloWorldService.listAllHelloWorld(pageNo, pageSize);
        return new Result<Page<HelloWorldEntity>>().success(helloWorldEntityPage);
    }
}