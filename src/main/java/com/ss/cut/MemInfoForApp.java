package com.ss.cut;

import java.lang.annotation.*;

/**
 * MemInfoForConsole
 *
 * @author shisong
 * @date 2021/1/21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MemInfoForApp {
}
