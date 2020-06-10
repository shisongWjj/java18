package com.ss.gupao.thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * SaveProcessor
 *
 * @author shisong
 * @date 2020/6/8
 */
public class SaveProcessor extends Thread implements RequestProcessor{

    private RequestProcessor nextProcessor;

    public SaveProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    private BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    private boolean finished = false;

    @Override
    public void run() {
        //那我们这里也不能用while(true)来循环，不然会一直阻塞
        //定义一个变量，判断当前处理器，是否执行完
        while (!finished){
            try {
                //阻塞式，获取request
                Request request = queue.take();
                System.out.println("saveProcessor request:" + request);
                nextProcessor.add(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Request request) {
        queue.add(request);
    }

    @Override
    public void shutdown() {
        System.out.println("SaveProcessor begin shutdown ...");
        queue.clear();
        finished = true;
        nextProcessor.shutdown();
    }
}
