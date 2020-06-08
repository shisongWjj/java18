package com.ss.juc.gupao.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * PrintProcessor
 * 打印处理器 -> 保存处理起 -> 最终处理起
 * 所以这里需要一个变量 nextProcessor（也就是 保存处理器）
 * 还需要一个阻塞队列 来存储 request
 * @author shisong
 * @date 2020/6/8
 */
public class PrintProcessor extends Thread implements RequestProcessor{

    private RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    private BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    private boolean finished = false;

    @Override
    public void run() {
        //那我们这里也不能用while(true)来循环，不然会一直阻塞
        //定义一个变量，判断当前处理器，是否执行完
        while (!finished || Thread.currentThread().isInterrupted()){
            try {
                //阻塞式，获取request
                Request request = queue.take();
                System.out.println("printProcessor request:" + request);
                nextProcessor.add(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Request request) {
        //添加到队列中（生产者）
        //所以 我们这里需要一个消费者 ，用多线程来消费
        queue.add(request);
    }

    @Override
    public void shutdown() {
        System.out.println("PrintProcessor begin shutdown ...");
        queue.clear();
        finished = true;
        Thread.currentThread().interrupt();
        nextProcessor.shutdown();
    }
}
