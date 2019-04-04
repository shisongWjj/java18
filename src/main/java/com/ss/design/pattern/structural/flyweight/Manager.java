package com.ss.design.pattern.structural.flyweight;

/**
 * Manager
 *
 * @author shisong
 * @date 2019/1/16
 */
public class Manager implements Employee{
    @Override
    public void report() {
        System.out.println(reportContent);
    }

    /**
     * 部门
     */
    private String department;

    /**
     * 报告内容
     */
    private String reportContent;

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Manager(String department) {
        this.department = department;
    }
}
