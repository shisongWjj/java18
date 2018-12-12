package com.ss.design.pattern.creational.singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private static Map<String,Object> singletonMap = new ConcurrentHashMap<>();

    private ContainerSingleton(){

    }

    public static void putInstance(String key,Object value){
         if(StringUtils.isNotBlank(key) && value !=null){
             if(!singletonMap.containsKey(key)){
                 singletonMap.put(key,value);
             }
         }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }
}
