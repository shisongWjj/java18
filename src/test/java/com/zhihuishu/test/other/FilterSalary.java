package com.zhihuishu.test.other;

public class FilterSalary implements MyPredicate<Employee> {
    @Override
    public Boolean myPredicate(Employee source) {
        return source.getSalary()>5000;
    }
}
