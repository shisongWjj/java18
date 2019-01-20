package com.ss.design.pattern.behavioral;

/**
 * ACourse
 *
 * @author shisong
 * @date 2019/1/20
 */
public abstract class ACourse {

    protected final void makeCourse(){
        makePPT();
        makeVideo();
        if(needWriteArticle()){
            writeArticle();
        }
        packageCourse();
    }

    final void makePPT(){
        System.out.println("制作PPT");
    }

    final void makeVideo(){
        System.out.println("制作视频");
    }

    final void writeArticle(){
        System.out.println("写手记");
    }

    //钩子方法
    public Boolean needWriteArticle(){
        return  false;
    }

    abstract void packageCourse();
}
