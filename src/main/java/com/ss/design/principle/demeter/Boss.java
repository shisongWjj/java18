package com.ss.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class Boss {

    /**
     * 在这里我们可以看出，boss直接和course产生了关系，按照迪米特原则,course应该是这teamleader产生关系，所以应该是在teamleader这个类中才创建
     * @param teamLeader
     */
    public void commandTeamLeader(TeamLeader teamLeader){

        Integer courseCount = teamLeader.courseCount();
        System.out.println("共有多少门课 ：" + courseCount);
    }

}
