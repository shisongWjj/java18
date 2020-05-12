package com.ss.design.watchBook.creational.factorymethod;

import com.ss.utils.ClassUtils;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Random;

/**
 * HumanFactory
 *
 * @author shisong
 * @date 2020/4/20
 */
public class HumanFactory {

    /**
     * first 指定创建
     * @param c 要创建的类
     * @return human
     */
    public static Human createHuman(Class c){
        Human human = null;
        try {
            human = (Human)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            System.out.println("必须指定人类的颜色");
        } catch (IllegalAccessException e) {
            System.out.println("人类定义错误！");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定的人类！");
        }
        return human;
    }

    /**
     * second 随机创建
     */
    public static Human createHuman(){
        Human human = null;
        List<Class> allClasses = ClassUtils.getAllClassByInterface(Human.class);
        if(CollectionUtils.isNotEmpty(allClasses)){
            int i = new Random().nextInt(allClasses.size());
            human = createHuman(allClasses.get(i));
        }
        return human;
    }
}
