package com.ss.design.pattern.behavioral.templatemethod;

import com.ss.design.pattern.behavioral.templatemethod.ACourse;

/**
 * FECourse
 *
 * @author shisong
 * @date 2019/1/20
 */
public class FECourse extends ACourse {

    private Boolean needWriteArticle;

    public FECourse(Boolean needWriteArticle) {
        this.needWriteArticle = needWriteArticle;
    }

    @Override
    void packageCourse() {
        System.out.println("提供课程的前端代码");
        System.out.println("提供课程的图片等多媒体");
    }


    //课程存在下一层的继承，所以不能写死
   /* @Override
    public Boolean needWriteArticle() {
        return true;
    }*/

    @Override
    public Boolean needWriteArticle() {
        return this.needWriteArticle;
    }
}
