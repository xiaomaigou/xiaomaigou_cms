package com.xiaomaigou.cms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.xiaomaigou.cms.dao.entity.ContentEntity;

import java.util.List;

/**
 * 内容（广告）
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 17:48:01
 */
@Mapper
public interface ContentMapper extends BaseMapper<ContentEntity> {

    /**
     * 根据内容（广告）ID查询内容（广告）
     *
     * @param contentId 内容（广告）ID
     * @return 内容（广告）列表
     */
    List<ContentEntity> listContentBycontentId(String contentId);

}
