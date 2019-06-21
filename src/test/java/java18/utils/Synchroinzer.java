package java18.utils;

import java18.constants.UtilsConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用方法 ：
 * 1.继承该类，重写方法
 * 2.需要从前端传入 需要保存的数据
 * 3.从数据库查询 原有的数据
 * <p>
 * 重写方法
 * //提取源数据的ID
 * public abstract ID extractSrcId(SRC_DTO srcDto);
 * 和有参构造方法
 *
 * @param <SRC_DTO> 前端传入的数据，即需要存入数据库的数据的类型
 * @param <ID>      根据哪个参数（类型）进行对比
 */
public abstract class Synchroinzer<SRC_DTO, ID> {

    //从前端页面传入的DTOlist
    private List<SRC_DTO> srcList;

    //从数据库查询到主键IDList
    private List<ID> destList;

    public Synchroinzer(List<SRC_DTO> srcList, List<ID> destList) {
        if (srcList == null) {
            srcList = new ArrayList<SRC_DTO>();
        }
        if (destList == null) {
            destList = new ArrayList<ID>();
        }
        this.srcList = srcList;
        this.destList = destList;
    }

    //提取源数据的ID
    public abstract ID extractSrcId(SRC_DTO srcDto);

    //针对DTO
    public Map<String, Object> sync() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //一个临时map 用于存放前端传入有主键的DTO
        Map<ID, SRC_DTO> temp_map = new HashMap<ID, SRC_DTO>();
        //需要新增的DTO
        List<SRC_DTO> toCreateDtos = new ArrayList<SRC_DTO>();
        //需要修改的DTO
        List<SRC_DTO> toUpdateDtos = new ArrayList<SRC_DTO>();
        //需要删除ID
        List<ID> toDeleteIds = new ArrayList<ID>();

        //循环从前端传入的dto
        //如果主键为空，则说明需要新增
        //其余是需要修改的（这里将其放入一个临时map中）
        for (SRC_DTO src_dto : srcList) {
            ID id = extractSrcId(src_dto);
            if (id == null) {
                toCreateDtos.add(src_dto);
            } else {
                temp_map.put(id, src_dto);
            }
        }

        //循环从数据库查询到的数据
        for (ID id : destList) {
            SRC_DTO src_dto = temp_map.get(id);
            if (src_dto == null) {
                //说明需要删除
                toDeleteIds.add(id);
            } else {
                //需要修改
                toUpdateDtos.add(src_dto);
            }
        }
        resultMap.put(UtilsConstant.TO_CREATE_KEY, toCreateDtos);
        resultMap.put(UtilsConstant.TO_UPDATE_KEY, toUpdateDtos);
        resultMap.put(UtilsConstant.TO_DELETE_KEY, toDeleteIds);
        return resultMap;
    }

    //针对ID
    public Map<String, Object> sync1() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //一个临时map 用于存放前端传入有主键的DTO
        Map<ID, SRC_DTO> temp_map = new HashMap<ID, SRC_DTO>();
        //需要新增的DTO
        List<SRC_DTO> toCreateDtos = new ArrayList<SRC_DTO>();
        //需要修改的DTO
        List<SRC_DTO> toUpdateDtos = new ArrayList<SRC_DTO>();
        //需要删除ID
        List<ID> toDeleteIds = new ArrayList<ID>();

        //循环从前端传入的dto
        //如果主键为空，则说明需要新增
        //其余是需要修改的（这里将其放入一个临时map中）
        for (SRC_DTO src_dto : srcList) {
            ID id = extractSrcId(src_dto);
            if (destList.contains(id)) {
                temp_map.put(id, src_dto);
            } else {
                toCreateDtos.add(src_dto);
            }
        }

        //循环从数据库查询到的数据
        for (ID id : destList) {
            SRC_DTO src_dto = temp_map.get(id);
            if (src_dto == null) {
                //说明需要删除
                toDeleteIds.add(id);
            } else {
                //需要修改
                toUpdateDtos.add(src_dto);
            }
        }
        resultMap.put(UtilsConstant.TO_CREATE_KEY, toCreateDtos);
        resultMap.put(UtilsConstant.TO_UPDATE_KEY, toUpdateDtos);
        resultMap.put(UtilsConstant.TO_DELETE_KEY, toDeleteIds);
        return resultMap;
    }

}
