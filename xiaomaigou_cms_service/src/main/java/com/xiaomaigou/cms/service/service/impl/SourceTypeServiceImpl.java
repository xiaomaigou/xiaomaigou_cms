package com.xiaomaigou.cms.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.xiaomaigou.cms.dao.entity.SourceTypeEntity;
import com.xiaomaigou.cms.dao.mapper.SourceTypeMapper;
import com.xiaomaigou.cms.service.dto.SourceTypeDTO;
import com.xiaomaigou.cms.service.service.SourceTypeService;

import java.util.List;
import java.util.Date;

/**
 * 来源类型接口实现
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 18:02:13
 */
@Service
public class SourceTypeServiceImpl extends ServiceImpl<SourceTypeMapper, SourceTypeEntity> implements SourceTypeService {

    private static final Logger logger = LoggerFactory.getLogger(SourceTypeServiceImpl.class);

    @Override
    public List<SourceTypeEntity> listAll() {
        QueryWrapper<SourceTypeEntity> sourceTypeEntityQueryWrapper = new QueryWrapper<>();
        sourceTypeEntityQueryWrapper.orderByDesc("source_type_id");
        return this.list(sourceTypeEntityQueryWrapper);
    }

    @Override
    public Page<SourceTypeEntity> listAllPage(Integer pageNo, Integer pageSize) {
        if (null == pageNo || pageNo < 1) {
            pageNo = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        QueryWrapper<SourceTypeEntity> sourceTypeEntityQueryWrapper = new QueryWrapper<>();
        sourceTypeEntityQueryWrapper.orderByDesc("source_type_id");
        return this.page(new Page<>(pageNo, pageSize), sourceTypeEntityQueryWrapper);
    }

    @Override
    public Page<SourceTypeEntity> search(Integer pageNo, Integer pageSize, String sourceTypeCode, String sourceTypeName, String createPersonId, Integer status) {
        if (null == pageNo || pageNo < 1) {
            pageNo = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        QueryWrapper<SourceTypeEntity> sourceTypeEntityQueryWrapper = new QueryWrapper<>();
        sourceTypeEntityQueryWrapper.eq(StringUtils.isNotEmpty(sourceTypeCode), "source_type_code", sourceTypeCode);
        sourceTypeEntityQueryWrapper.like(StringUtils.isNotEmpty(sourceTypeName), "source_type_name", sourceTypeName);
        sourceTypeEntityQueryWrapper.eq(StringUtils.isNotEmpty(createPersonId), "create_person_id", createPersonId);
        sourceTypeEntityQueryWrapper.eq(status != null, "status", status);
        sourceTypeEntityQueryWrapper.orderByDesc("create_time", "update_time");
        return this.page(new Page<>(pageNo, pageSize), sourceTypeEntityQueryWrapper);
    }

    @Override
    public SourceTypeEntity detail(String sourceTypeId) {
        return this.getById(sourceTypeId);
    }

    @Override
    public Boolean add(SourceTypeDTO sourceTypeDTO) {
        SourceTypeEntity sourceTypeEntity = new SourceTypeEntity();
        BeanUtils.copyProperties(sourceTypeDTO, sourceTypeEntity);
        sourceTypeEntity.setSourceTypeId(IdWorker.getIdStr());
        sourceTypeEntity.setCreatePersonId("xiaomaigou");
        sourceTypeEntity.setUpdatePersonId("xiaomaigou");
        sourceTypeEntity.setCreateTime(new Date());
        sourceTypeEntity.setUpdateTime(new Date());
        sourceTypeEntity.setStatus(1);
        logger.debug(String.format("新增来源类型:sourceTypeEntity=[%s]", sourceTypeEntity.toString()));
        return this.save(sourceTypeEntity);
    }

    @Override
    public Boolean update(String sourceTypeId, SourceTypeDTO sourceTypeDTO) {
        SourceTypeEntity sourceTypeEntity = this.getById(sourceTypeId);
        if (null == sourceTypeEntity) {
            logger.warn(String.format("更新不存在的来源类型:sourceTypeId=[%s],sourceTypeDTO=[%s]", sourceTypeId, sourceTypeDTO.toString()));
            return false;
        }
        BeanUtils.copyProperties(sourceTypeDTO, sourceTypeEntity);
        sourceTypeEntity.setUpdatePersonId("xiaomaigou");
        sourceTypeEntity.setUpdateTime(new Date());
        logger.debug(String.format("更新来源类型:sourceTypeEntity=[%s]", sourceTypeEntity.toString()));
        return this.updateById(sourceTypeEntity);
    }

    @Override
    public Boolean delete(String sourceTypeId) {
        SourceTypeEntity sourceTypeEntity = this.getById(sourceTypeId);
        if (null == sourceTypeEntity) {
            logger.warn(String.format("删除不存在的来源类型:sourceTypeId=[%s]", sourceTypeId));
            return false;
        }
        return this.removeById(sourceTypeId);
    }

    @Override
    public Boolean delete(List<String> sourceTypeIdList) {
        if (null == sourceTypeIdList || sourceTypeIdList.isEmpty()) {
            logger.warn("删除空集合来源类型!");
            return false;
        }
        return this.removeByIds(sourceTypeIdList);
    }
}
