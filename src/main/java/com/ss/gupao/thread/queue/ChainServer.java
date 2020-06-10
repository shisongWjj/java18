package com.ss.gupao.thread.queue;

/**
 * Chain
 *
 * @author shisong
 * @date 2020/6/8
 */
public class ChainServer {

    static PrintProcessor firstProcessor;

    private static void setupProcessor(){
        FinalProcessor finalProcessor = new FinalProcessor();
        SaveProcessor saveProcessor = new SaveProcessor(finalProcessor);
        firstProcessor = new PrintProcessor(saveProcessor);
        Request request = new Request("ss");

        /*firstProcessor.add(request);
        saveProcessor.add(request);
        finalProcessor.add(request);*/

        firstProcessor.start();
        saveProcessor.start();
        finalProcessor.start();
    }

    private static void startUp(){
        setupProcessor();
    }


    public static void main(String[] args) throws InterruptedException {
        ChainServer chainServer = new ChainServer();
        ChainServer.startUp();
        Request request=new Request("ss");
        ChainServer.firstProcessor.add(request);
        Thread.sleep(5000L);
        shutdown();
    }

    private static void shutdown(){
        firstProcessor.shutdown();
    }

}
