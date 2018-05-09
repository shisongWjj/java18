package java18.utils;

import com.google.common.base.Functions;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 针对list的一些转换  dependency:java1.8
* @Description
* @author shisong
* @date 15:58 2018/5/7
* @modifyNote
* @param
* @return
*/
public class ListHelper {

    //是否删除重复数据  0:不删除 1:删除 默认删除
    private static final Integer IS_DISTINCT = 0;

    /**
     * list 转 map  key与value的关系 ：1对多
     * 本方法会对源数据，key,value 过滤null
     * isDistinct 为1的时候  说明需要删除重复数据  如果value是对象的话  需要重写hashcode和equals
    * @Description
    * @author shisong
    * @date 15:58 2018/5/7
    * @modifyNote
    * @param
    * @return
    */
    public static <K,V,DTO>Map<K,List<V>> listToMap(List<DTO> source, Function<? super DTO,? extends K> key,Function<? super DTO,? extends V> value,Integer isDistinct){
        if(isDistinct == null) isDistinct = IS_DISTINCT;
        Objects.requireNonNull(source,"source not null");
        Objects.requireNonNull(key,"key not null");
        Objects.requireNonNull(value,"value not null");
        Map<K,List<V>> rsMap = new HashMap<>();
        Map<K, List<V>> map = source
                .stream()
                .filter(dto -> dto != null)
                .filter(dto -> key.apply(dto) != null)
                .filter(dto -> value.apply(dto) != null)
                .collect(Collectors.groupingBy(key, Collectors.mapping(value, Collectors.toList())));
        if (isDistinct.equals(1)){
            if(MapUtils.isNotEmpty(map)){
                map.forEach((k,v)->{
                    v = v.stream().distinct().collect(Collectors.toList());
                    rsMap.put(k,v);
                });
            }
        }else{
            rsMap.putAll(map);
        }
        return rsMap;
    }

    /**
     * * list 转 map  key与value的关系 ：1对1  如果数据源存在相同的key  则会报错
     * 本方法会对源数据，key,value 过滤null
    * @Description
    * @author shisong
    * @date 16:48 2018/5/7
    * @modifyNote 
    * @param 
    * @return
    */
    public static <K,V,DTO>Map<K,V> listToMap(List<DTO> source, Function<? super DTO,? extends K> key,Function<? super DTO,? extends V> value){
        Objects.requireNonNull(source,"source not null");
        Objects.requireNonNull(key,"key not null");
        Objects.requireNonNull(value,"value not null");
        Map<K,V> map = source
                .stream()
                .filter(dto -> dto != null)
                .filter(dto -> key.apply(dto) != null)
                .filter(dto -> value.apply(dto) != null)
                .collect(Collectors.toMap(key, value));
        return map;
    }

    /**
     * 针对源数据 提取某个元素
     * 本方法会对源数据，t 过滤null
     * isDistinct 为1的时候  说明需要删除重复数据
    * @Description
    * @author shisong
    * @date 17:44 2018/5/7
    * @modifyNote
    * @param
    * @return
    */
    public static <T,DTO>List<T> extractVariable(List<DTO> source,Function<? super DTO,? extends T> t,Integer isDistinct){
        if(isDistinct == null) isDistinct = IS_DISTINCT;
        Objects.requireNonNull(source,"source not null");
        Objects.requireNonNull(t,"t not null");
        Stream<? extends T> stream = source
                .stream()
                .filter(dto -> dto != null)
                .filter(dto -> t.apply(dto) != null)
                .map(t);
        if(isDistinct.equals(1)){
            stream = stream.distinct();
        }
        List<T> rsList = stream.collect(Collectors.toList());
        return rsList;
    }

    /**
     * 对结果集做排序  按照数据源的顺序排序
     * 会将结果集中的为空的数据过滤
     * @param source 排序好的数据源
     * @param result 接口返回的结果集
     * @param fun 函数式接口
     */
    public static <T extends Number,DTO>List<DTO> orderBySource(List<T> source,List<DTO> result,Function<? super DTO,? extends T> fun){
        Objects.requireNonNull(source,"source not null");
        Objects.requireNonNull(result,"result not null");
        Objects.requireNonNull(fun,"fun not null");
        List<DTO> r = new ArrayList<>();
        Map<T, DTO> resultToMap = listToMap(result, fun, Functions.identity());
        source.stream().forEach(t->{
            DTO dto = resultToMap.get(t);
            if(dto != null){
                r.add(dto);
            }
        });
        return r;
    }

}
