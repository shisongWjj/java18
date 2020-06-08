package com.ss.juc.gupao.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * FinalProcessor
 *
 * @author shisong
 * @date 2020/6/8
 */
public class FinalProcessor extends Thread implements RequestProcessor{

    private BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    private boolean finished = false;

    @Override
    public void run() {
        while (!finished){
            try {
                Request request = queue.take();
                System.out.println("finalProcessor request:" + request);
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
        System.out.println("FinalProcessor begin shutdown ...");
        queue.clear();
        finished = true;
    }
}
