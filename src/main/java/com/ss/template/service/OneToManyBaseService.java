package com.ss.template.service;

import java.util.Date;
import java.util.List;

/**
 * AbstractOneToManyBaseService
 *
 * @author shisong
 * @date 2020/5/19
 */
public interface OneToManyBaseService<Entity,RelatedId,CODE,ID> extends BaseService<Entity,ID>{

    /**
     * 根据关联id和code批量删除数据
     * @param codes codes
     * @param relatedId 关联id
     * @param operatorName 操作人
     * @param updateTime 修改时间
     */
    void deleteBatchByRelatedIdAndCodes(List<CODE> codes, RelatedId relatedId, String operatorName, Date updateTime);

    /**
     * 根据关联 id 查询数据
     * @param relatedId 关联id
     * @return 实体列表
     */
    List<Entity> queryListByRelatedId(RelatedId relatedId);

    /**
     * 批量保存数据，关联id
     * @param entities 保存实体
     * @param relatedId 关联id
     * @param createTime 创建时间
     * @param operatorName 操作人
     */
    void saveBatchHasRelatedId(List<Entity> entities, RelatedId relatedId, Date createTime, String operatorName);

    /**
     * 根据关联id批量删除数据
     * @param relatedId 关联id
     * @param operatorName 操作人
     * @param updateTime 修改时间
     */
    void deleteBatchByRelatedId(RelatedId relatedId, String operatorName, Date updateTime);


}
