package com.ss.juc.gupao.queue;

/**
 * ReuqestProcessor
 * 责任链  接口
 * 用阻塞队列来实现 异步化责任链模式
 * @author shisong
 * @date 2020/6/8
 */
public interface RequestProcessor {

    /**
     * 将request添加到责任链中（阻塞队列）
     * @param request request
     */
    void add(Request request);

    /**
     * 将责任链清空,并需要修改终止循环的变量
     */
    void shutdown();

}
