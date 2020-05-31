package com.xiaomaigou.cms.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaomaigou.cms.dao.entity.HelloWorldEntity;

import java.util.List;

/**
 * HelloWorld接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:23
 */
public interface HelloWorldService extends IService<HelloWorldEntity> {
    /**
     * 获取URL
     *
     * @return URL
     */
    String getUrl();

    /**
     * 获取所有tb_helloworld表数据
     *
     * @return tb_helloworld表数据
     */
    List<HelloWorldEntity> listAllHelloWorld();

    /**
     * 获取tb_helloworld表分页数据
     *
     * @param pageNo   当前页
     * @param pageSize 页大小
     * @return
     */
    Page<HelloWorldEntity> listAllHelloWorld(Integer pageNo, Integer pageSize);
}
