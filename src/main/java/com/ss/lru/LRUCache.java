package com.ss.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCache
 *
 * @author shisong
 * @date 2020/3/3
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

   private final int CACHE_SIZE;

    public LRUCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f , true);
        this.CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
