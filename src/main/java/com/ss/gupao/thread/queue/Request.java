package com.ss.gupao.thread.queue;

/**
 * Request
 * 责任链的参数
 * @author shisong
 * @date 2020/6/8
 */
public class Request {

    private String name;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
