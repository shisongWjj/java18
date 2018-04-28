package com.zhihuishu.test.other;

import java.util.List;

@FunctionalInterface
public interface MyPredicate<T> {

    Boolean myPredicate(T source);

}
