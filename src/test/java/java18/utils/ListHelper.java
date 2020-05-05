package java18.utils;

import com.google.common.base.Functions;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 针对list的一些转换  dependency:java1.8
 *
 * @param
 * @author shisong
 * @Description
 * @date 15:58 2018/5/7
 * @modifyNote
 * @return
 */
public class ListHelper {

    //是否删除重复数据  0:不删除 1:删除 默认删除
    private static final Integer IS_DISTINCT = 0;

    /**
     * list 转 map  key与value的关系 ：1对多
     * 本方法会对源数据，key,value 过滤null
     * isDistinct 为1的时候  说明需要删除重复数据  如果value是对象的话  需要重写hashcode和equals
     *
     * @param
     * @return
     * @Description
     * @author shisong
     * @date 15:58 2018/5/7
     * @modifyNote
     */
    public static <K, V, DTO> Map<K, List<V>> listToMap(List<DTO> source, Function<? super DTO, ? extends K> key, Function<? super DTO, ? extends V> value, Integer isDistinct) {
        if (isDistinct == null) isDistinct = IS_DISTINCT;
        Objects.requireNonNull(source, "source not null");
        Objects.requireNonNull(key, "key not null");
        Objects.requireNonNull(value, "value not null");
        Map<K, List<V>> rsMap = new HashMap<>();
        Map<K, List<V>> map = source
                .stream()
                .filter(dto -> dto != null)
                .filter(dto -> key.apply(dto) != null)
                .filter(dto -> value.apply(dto) != null)
                .collect(Collectors.groupingBy(key, Collectors.mapping(value, Collectors.toList())));
        if (isDistinct.equals(1)) {
            if (MapUtils.isNotEmpty(map)) {
                map.forEach((k, v) -> {
                    v = v.stream().distinct().collect(Collectors.toList());
                    rsMap.put(k, v);
                });
            }
        } else {
            rsMap.putAll(map);
        }
        return rsMap;
    }

    /**
     * * list 转 map  key与value的关系 ：1对1  如果数据源存在相同的key  则会报错
     * 本方法会对源数据，key,value 过滤null
     *
     * @param
     * @return
     * @Description
     * @author shisong
     * @date 16:48 2018/5/7
     * @modifyNote
     */
    public static <K, V, DTO> Map<K, V> listToMap(List<DTO> source, Function<? super DTO, ? extends K> key, Function<? super DTO, ? extends V> value) {
        Objects.requireNonNull(source, "source not null");
        Objects.requireNonNull(key, "key not null");
        Objects.requireNonNull(value, "value not null");
        Map<K, V> map = source
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
     *
     * @param
     * @return
     * @Description
     * @author shisong
     * @date 17:44 2018/5/7
     * @modifyNote
     */
    public static <T, DTO> List<T> extractVariable(List<DTO> source, Function<? super DTO, ? extends T> t, Integer isDistinct) {
        if (isDistinct == null) isDistinct = IS_DISTINCT;
        Objects.requireNonNull(source, "source not null");
        Objects.requireNonNull(t, "t not null");
        Stream<? extends T> stream = source
                .stream()
                .filter(dto -> dto != null)
                .filter(dto -> t.apply(dto) != null)
                .map(t);
        if (isDistinct.equals(1)) {
            stream = stream.distinct();
        }
        List<T> rsList = stream.collect(Collectors.toList());
        return rsList;
    }

    /**
     * 对结果集做排序  按照数据源的顺序排序
     * 会将结果集中的为空的数据过滤
     *
     * @param source 排序好的数据源
     * @param result 接口返回的结果集
     * @param fun    函数式接口
     */
    public static <T extends Number, DTO> List<DTO> orderBySource(List<T> source, List<DTO> result, Function<? super DTO, ? extends T> fun) {
        Objects.requireNonNull(source, "source not null");
        Objects.requireNonNull(result, "result not null");
        Objects.requireNonNull(fun, "fun not null");
        List<DTO> r = new ArrayList<>();
        Map<T, DTO> resultToMap = listToMap(result, fun, Functions.identity());
        source.stream().forEach(t -> {
            DTO dto = resultToMap.get(t);
            if (dto != null) {
                r.add(dto);
            }
        });
        return r;
    }

    /**
     * 将源数据中 同一个字段的值累加（数字类型） 只实现了 integer long double的累加
     *
     * @param source：源数据 classz：返回的值的类型 ignoreProperties：不需要进行累加的属性名字
     * @return
     * @Description
     * @author shisong
     * @date 13:43 2018/6/25
     * @modifyNote
     */
    public static <T, R> T listCount(List<R> source, Class<T> classz, String... ignoreProperties) throws BeansException {
        if (CollectionUtils.isEmpty(source)) return null;
        Assert.notNull(classz);
        T target = BeanUtils.instantiate(classz);
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(target.getClass());
        List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            Method writeMethod = propertyDescriptor.getWriteMethod();//setXxx
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(propertyDescriptor.getName()))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.get(0).getClass(), propertyDescriptor.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();//getXxx
                    if (readMethod != null && ClassUtils.isAssignable(Number.class, readMethod.getReturnType())) {
                        Object sum = 0;
                        for (R dto : source) {
                            try {
                                Object value = readMethod.invoke(dto);
                                if (ClassUtils.isAssignable(Integer.class, readMethod.getReturnType())) {
                                    if (value != null) {
                                        sum = Integer.parseInt(sum.toString()) + Integer.parseInt(value.toString());
                                    } else {
                                        sum = Integer.parseInt(sum.toString());
                                    }
                                } else if (ClassUtils.isAssignable(Long.class, readMethod.getReturnType())) {
                                    if (value != null) {
                                        sum = Long.parseLong(sum.toString()) + Long.parseLong(value.toString());
                                    } else {
                                        sum = Long.parseLong(sum.toString());
                                    }
                                } else if (value != null && ClassUtils.isAssignable(Double.class, readMethod.getReturnType())) {
                                    if (value != null) {
                                        sum = Double.parseDouble(sum.toString()) + Double.parseDouble(value.toString());
                                    } else {
                                        sum = Double.parseDouble(sum.toString());
                                    }
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            writeMethod.invoke(target, sum);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return target;
    }

    /**
     * 分页
     * @param list 集合
     * @param pageSize 页长
     * @param pageNum 页码 从1开始
     * @return 分页后的数据
     */
    public static <T> List<T> subList(List<T> list, Integer pageSize ,Integer pageNum){
        if(CollectionUtils.isEmpty(list) || pageSize == null || pageSize <= 0 || pageNum == null || pageNum <= 0){
            return new ArrayList<>();
        }
        Integer pageStart = pageSize * (pageNum - 1);
        int count = list.size();
        if(count < pageStart){
            return new ArrayList<>();
        }
        if(count < pageStart + pageSize){
            return list.subList(pageStart,count);
        }
        return list.subList(pageStart,pageStart + pageSize);
    }

}
