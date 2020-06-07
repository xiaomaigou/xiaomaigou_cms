package com.xiaomaigou.cms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.xiaomaigou.cms.dao.entity.SourceTypeEntity;

import java.util.List;

/**
 * 来源类型
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 18:02:13
 */
@Mapper
public interface SourceTypeMapper extends BaseMapper<SourceTypeEntity> {

    /**
     * 根据来源类型ID查询来源类型
     *
     * @param sourceTypeId 来源类型ID
     * @return 来源类型列表
     */
    List<SourceTypeEntity> listSourceTypeBysourceTypeId(String sourceTypeId);

}
