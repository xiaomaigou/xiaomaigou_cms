package com.xiaomaigou.cms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaomaigou.cms.dao.entity.HelloWorldEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * HelloWorld信息表
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 22:59
 */
@Mapper
public interface HelloWorldMapper extends BaseMapper<HelloWorldEntity> {
}
