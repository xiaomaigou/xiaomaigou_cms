package com.xiaomaigou.cms.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaomaigou.cms.dao.entity.SourceTypeEntity;
import com.xiaomaigou.cms.service.dto.SourceTypeDTO;

import java.util.List;
import java.util.Date;

/**
 * 来源类型接口
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/06/07 18:02:13
 */
public interface SourceTypeService extends IService<SourceTypeEntity> {

    /**
     * 获取所有来源类型
     *
     * @return 所有来源类型
     */
    List<SourceTypeEntity> listAll();

    /**
     * 获取来源类型(分页)
     *
     * @param pageNo   当前页，默认1
     * @param pageSize 每页显示条数，默认10
     * @return 来源类型
     */
    Page<SourceTypeEntity> listAllPage(Integer pageNo, Integer pageSize);

    /**
     * 搜索来源类型(分页)
     *
     * @param pageNo         当前页，默认1
     * @param pageSize       每页显示条数，默认10
     * @param sourceTypeCode 来源code
     * @param sourceTypeName 来源名称
     * @param createPersonId 创建人ID
     * @param status         状态，-1删除，0无效，1有效
     * @return 来源类型
     */
    Page<SourceTypeEntity> search(Integer pageNo, Integer pageSize, String sourceTypeCode, String sourceTypeName, String createPersonId, Integer status);

    /**
     * 根据来源类型ID获取来源类型详情
     *
     * @param sourceTypeId 来源类型ID
     * @return 来源类型详情
     */
    SourceTypeEntity detail(String sourceTypeId);

    /**
     * 新增来源类型
     *
     * @param sourceTypeDTO 来源类型信息
     * @return 执行结果
     */
    Boolean add(SourceTypeDTO sourceTypeDTO);

    /**
     * 根据来源类型ID更新来源类型
     *
     * @param sourceTypeId  来源类型ID
     * @param sourceTypeDTO 来源类型信息
     * @return 执行结果
     */
    Boolean update(String sourceTypeId, SourceTypeDTO sourceTypeDTO);

    /**
     * 根据来源类型ID删除来源类型
     *
     * @param sourceTypeId 来源类型ID
     * @return 执行结果
     */
    Boolean delete(String sourceTypeId);

    /**
     * 根据来源类型ID删除来源类型(多条记录)
     *
     * @param sourceTypeIdList 来源类型ID List
     * @return 执行结果
     */
    Boolean delete(List<String> sourceTypeIdList);

}
