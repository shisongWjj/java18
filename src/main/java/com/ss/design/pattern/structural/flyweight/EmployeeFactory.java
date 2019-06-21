package com.ss.design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * EmployeeFactory
 *
 * @author shisong
 * @date 2019/1/16
 */
public class EmployeeFactory {

    public static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    /**
     * 传入部门号  返回员工
     *
     * @param department
     * @return
     */
    public static Employee getEmployee(String department) {
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null) {
            manager = new Manager(department);
            System.out.println("创建部门经理：" + department);
            String reportContent = department + "部门汇报：此次报告的主要内容......";
            manager.setReportContent(reportContent);
            System.out.println("创建报告：" + reportContent);
            EMPLOYEE_MAP.put(department, manager);
        }
        return manager;
    }

}
