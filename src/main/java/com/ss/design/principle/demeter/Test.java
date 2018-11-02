package com.ss.design.principle.demeter;

/**
 * 迪米特法则，又叫最少知道原则
 * 场景：boss 让团队领导 查询下有多少课程
 */
public class Test {
    public static void main(String[] args) {
        Boss bosss = new Boss();
        TeamLeader tl = new TeamLeader();
        bosss.commandTeamLeader(tl);
    }
}
