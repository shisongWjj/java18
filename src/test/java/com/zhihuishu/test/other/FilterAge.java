package com.zhihuishu.test.other;

public class FilterAge implements MyPredicate<Employee>{
    @Override
    public Boolean myPredicate(Employee source) {
        return source.getAge()>35;
    }
}
