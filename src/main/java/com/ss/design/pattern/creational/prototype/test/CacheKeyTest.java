package com.ss.design.pattern.creational.prototype.test;

import org.apache.ibatis.reflection.ArrayUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CacheKeyTest
 *
 * @author shisong
 * @date 2019/1/9
 */
public class CacheKeyTest implements Cloneable {
    private static final long serialVersionUID = 1146682552656046210L;

    private static final int DEFAULT_MULTIPLYER = 37;
    private static final int DEFAULT_HASHCODE = 17;

    private final int multiplier;
    private int hashcode;
    private long checksum;
    private int count;
    private transient List<Object> updateList;

    public CacheKeyTest() {
        this.hashcode = DEFAULT_HASHCODE;
        this.multiplier = DEFAULT_MULTIPLYER;
        this.count = 0;
        this.updateList = new ArrayList<>();
    }

    public CacheKeyTest(Object[] objects) {
        this();
        updateAll(objects);
    }

    public int getUpdateCount() {
        return updateList.size();
    }

    public void update(Object object) {
        int baseHashCode = object == null ? 1 : ArrayUtil.hashCode(object);

        count++;
        checksum += baseHashCode;
        baseHashCode *= count;

        hashcode = multiplier * hashcode + baseHashCode;

        updateList.add(object);
    }

    public void updateAll(Object[] objects) {
        for (Object o : objects) {
            update(o);
        }
    }

    /*@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CacheKeyTest)) {
            return false;
        }

        final CacheKeyTest cacheKey = (CacheKeyTest) object;

        if (hashcode != cacheKey.hashcode) {
            return false;
        }
        if (checksum != cacheKey.checksum) {
            return false;
        }
        if (count != cacheKey.count) {
            return false;
        }

        for (int i = 0; i < updateList.size(); i++) {
            Object thisObject = updateList.get(i);
            Object thatObject = cacheKey.updateList.get(i);
            if (!ArrayUtil.equals(thisObject, thatObject)) {
                return false;
            }
        }
        return true;
    }*/

    @Override
    public int hashCode() {
        return hashcode;
    }

    @Override
    public String toString() {
        StringBuilder returnValue = new StringBuilder().append(hashcode).append(':').append(checksum);
        for (Object object : updateList) {
            returnValue.append(':').append(ArrayUtil.toString(object));
        }
        return returnValue.toString() + super.toString();
    }

    @Override
    public CacheKeyTest clone() throws CloneNotSupportedException {
        CacheKeyTest clonedCacheKey = (CacheKeyTest) super.clone();
        clonedCacheKey.updateList = new ArrayList<>(updateList);//深拷贝，list是不同的对象
        return clonedCacheKey;
    }
}
