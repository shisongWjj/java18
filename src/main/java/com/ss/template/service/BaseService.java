package com.ss.template.service;

import java.util.Date;

/**
 * BaseService
 *
 * @author shisong
 * @date 2020/5/19
 */
public interface BaseService<Entity,ID> {

    /**
     * 根据主键删除数据
     * @param id 主键
     * @param operatorName 操作人
     * @param updateTime 修改时间
     */
    void deleteOneById(ID id, String operatorName, Date updateTime);

    /**
     * 根据主键查询数据
     * @param id 主键
     * @return 查询到的数据
     */
    Entity queryOneById(ID id);

    /**
     * 保存单个数据
     * @param entity 保存的实体
     * @param createTime 创建时间
     * @param operatorName 操作人
     */
    void saveOne(Entity entity, Date createTime, String operatorName);

    /**
     * 根据主键进行修改
     * @param entity 修改的实体
     * @param id 主键
     * @param updateTime 修改时间
     * @param operatorName 操作人
     */
    void updateOneById(Entity entity, ID id, Date updateTime, String operatorName);

}
