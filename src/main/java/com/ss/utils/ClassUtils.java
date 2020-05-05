package com.ss.utils;

import com.ss.design.watchBook.creational.factorymethod.Human;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

/**
 * ClassUtils
 *
 * @author shisong
 * @date 2020/4/21
 */
public class ClassUtils {

    private ClassUtils(){}

    public static List<Class> getAllClassByInterface(Class<Human> c){
        //返回的实现/子类的类
        List<Class> returnClass = new ArrayList<>();
        //判断当前类是否是接口，如果不是 则不做处理
        if(c.isInterface()){
            //获取当前的包名 com.ss.design.watchBook.creational.factorymethod
            String packageName = c.getPackage().getName();
            //获取当前包下的所有类
            try {
                List<Class> allClass = getClasses(packageName);
                //获取当前类的所有子类或实现类
                for(int i = 0; i< allClass.size() ; i++){
                    //判断当前类是否是该类（c）的子类
                    if(c.isAssignableFrom(allClass.get(i))){
                        if(!c.equals(allClass.get(i))){
                            returnClass.add(allClass.get(i));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("找不到指定的人类！");
            }
        }
        return returnClass;
    }

    private static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()){
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class> classes = new ArrayList<>();
        for (File dir : dirs) {
            classes.addAll(findClass(dir,packageName));
        }
        return classes;
    }

    private static List<Class> findClass(File dir, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if(!dir.exists()){
            return classes;
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(findClass(file,packageName + "." +file.getName()));
            }else if (file.getName().endsWith(".class")){
                classes.add(Class.forName(packageName + "." + file.getName().substring(0,file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
