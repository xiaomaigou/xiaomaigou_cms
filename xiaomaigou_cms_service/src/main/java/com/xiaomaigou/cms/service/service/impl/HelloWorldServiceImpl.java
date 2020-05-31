package com.xiaomaigou.cms.service.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaomaigou.cms.dao.entity.HelloWorldEntity;
import com.xiaomaigou.cms.dao.mapper.HelloWorldMapper;
import com.xiaomaigou.cms.service.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:24
 */
@Service
public class HelloWorldServiceImpl extends ServiceImpl<HelloWorldMapper, HelloWorldEntity> implements HelloWorldService {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    @Autowired
    private Environment env;

    @Override
    public String getUrl() {
        return "Url:" + env.getProperty("url");
    }

    @Override
    public List<HelloWorldEntity> listAllHelloWorld() {
        return this.list();
    }

    @Override
    public Page<HelloWorldEntity> listAllHelloWorld(Integer pageNo, Integer pageSize) {
        return this.page(new Page<>(pageNo, pageSize));
    }
}
