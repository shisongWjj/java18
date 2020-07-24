package com.ss.template.service;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * AbstractListHasNoUpdateDataBaseService
 *  当需要修改数据的时候，不需要有修改数据
 *  Entity:需要做CRUD的实体类
 *  RelatedId：关联ID（主表中的主键，也就是修改记录时的唯一id）
 *  CODE:通过RelatedId查询出来的数据，进行CODE来计算 哪些需要新增，更新，删除
 *  ID：Entity的主键
 * @author shisong
 * @date 2020/5/19
 */
public abstract class AbstractListHasNoUpdateDataBaseService<Entity,RelatedId,CODE,ID> implements OneToManyBaseService<Entity,RelatedId,CODE,ID> {

    /**
     * 从前端页面传入的DTO List
     */
    private List<Entity> srcList;

    /**
     * 从数据库查询到的一对多关联CODE
     */
    private List<CODE> destList;

    public AbstractListHasNoUpdateDataBaseService() {
    }

    public AbstractListHasNoUpdateDataBaseService(List<Entity> srcList, List<CODE> destList) {
        if (srcList == null) {
            srcList = new ArrayList<>();
        }
        if (destList == null) {
            destList = new ArrayList<>();
        }
        this.srcList = srcList;
        this.destList = destList;
    }

    /**
     * 提取源数据的ID
     * @param srcDto 被提取的数据
     * @return 一对多关联CODE
     */
    public abstract CODE extractSrcCode(Entity srcDto);

    public List<CODE> extractSrcCodeBatch(List<Entity> srcDtos){
        List<CODE> codes = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(srcDtos)){
            for (Entity entity : srcDtos) {
                codes.add(extractSrcCode(entity));
            }
        }
        return codes;
    }

    /**
     * 针对CODE
     * @return 针对CODE
     */
    public Map<String, Object> sync1() {
        Map<String, Object> resultMap = new HashMap<>(8);
        //一个临时map 用于存放前端传入有主键的DTO
        Map<CODE, Entity> tempMap = new HashMap<>(8);
        //需要新增的DTO
        List<Entity> toCreateDtos = new ArrayList<>();
        //需要修改的DTO
        List<Entity> toUpdateDtos = new ArrayList<>();
        //需要删除ID
        List<CODE> toDeleteIds = new ArrayList<>();

        //循环从前端传入的dto
        //如果主键为空，则说明需要新增
        //其余是需要修改的（这里将其放入一个临时map中）
        for (Entity srcDto : srcList) {
            CODE id = extractSrcCode(srcDto);
            if (destList.contains(id)) {
                tempMap.put(id, srcDto);
            } else {
                toCreateDtos.add(srcDto);
            }
        }

        //循环从数据库查询到的数据
        for (CODE id : destList) {
            Entity srcDto = tempMap.get(id);
            if (srcDto == null) {
                //说明需要删除
                toDeleteIds.add(id);
            } else {
                //需要修改
                toUpdateDtos.add(srcDto);
            }
        }
        resultMap.put(UtilsConstant.TO_CREATE_KEY, toCreateDtos);
        resultMap.put(UtilsConstant.TO_UPDATE_KEY, toUpdateDtos);
        resultMap.put(UtilsConstant.TO_DELETE_KEY, toDeleteIds);
        return resultMap;
    }
    /**
     *  调用本方法中的 有参构造，然后执行sync1()
     * @param entities 从前端页面传入的DTO List
     * @param codes 从数据库查询到的一对多关联CODE
     * @return 会获取到 需要修改的数据
     */
    abstract Map<String, Object> calculationEntities(List<Entity> entities,List<CODE> codes);

    public void updateListHasNoUpdateData(List<Entity> entities, RelatedId relatedId, Date updateTime, String operatorName) {
        //从数据库查询到数据
        List<Entity> dataForDbs = this.queryListByRelatedId(relatedId);
        List<CODE> codes = extractSrcCodeBatch(dataForDbs);

        Map<String, Object> map = calculationEntities(entities,codes);

        //需要新增的数据
        List<Entity> toCreate = (List<Entity>)map.get(UtilsConstant.TO_CREATE_KEY);
        if(!CollectionUtils.isEmpty(toCreate)){
            this.saveBatchHasRelatedId(toCreate,relatedId,updateTime,operatorName);
        }

        //需要删除的数据
        List<CODE> toDelete = (List<CODE>) map.get(UtilsConstant.TO_DELETE_KEY);
        if(!CollectionUtils.isEmpty(toDelete)){
            this.deleteBatchByRelatedIdAndCodes(toDelete,relatedId,operatorName,updateTime);
        }
    }

    @Override
    public void deleteOneById(ID id, String operatorName, Date updateTime) {
        throw new UnsupportedOperationException("未提供 deleteOneById 方法");
    }

    @Override
    public Entity queryOneById(ID id) {
        throw new UnsupportedOperationException("未提供 queryOneById 方法");
    }

    @Override
    public void saveOne(Entity listCouponBatchRelationEntity, Date createTime, String operatorName) {
        throw new UnsupportedOperationException("未提供 saveOne 方法");
    }

    @Override
    public void updateOneById(Entity listCouponBatchRelationEntity, ID id, Date updateTime, String operatorName) {
        throw new UnsupportedOperationException("未提供 deleteOne 方法");
    }


}
