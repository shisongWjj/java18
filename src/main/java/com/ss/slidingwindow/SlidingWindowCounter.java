package com.ss.slidingwindow;

/**
 * SlidingWindowCounter
 *
 * @author shisong
 * @date 2021/6/30
 */
public class SlidingWindowCounter {

    /**
     *  当前槽点对应的计数器
     */
    private volatile SlotBaseCounter slotBaseCounter;
    /**
     * 滑动窗口的长度
     */
    private volatile int windowSize;
    /**
     * 当前哪个槽点
     */
    private volatile int head;

    /**
     * 构造方法
     * @param windowSize 滑动窗口的长度
     */
    public SlidingWindowCounter(int windowSize) {
        resizeWindow(windowSize);
    }

    /**
     * 重置滑动窗口
     * 默认从0槽点开始
     * @param windowSize 滑动窗口的长度
     */
    public synchronized void resizeWindow(int windowSize) {
        this.windowSize = windowSize;
        this.slotBaseCounter = new SlotBaseCounter(windowSize);
        this.head = 0;
    }

    /**
     * 当前槽点的请求数自增+1
     */
    public void increase() {
        slotBaseCounter.increaseSlot(head);
    }

    /**
     * 获取总请求数 ，并且槽点向前进一位
     * @return 总请求数
     */
    public int totalAndAdvance() {
        int total = totalCount();
        advance();
        return total;
    }

    /**
     * 槽点向前进一位，进一位后的那个位置的请求置为0
     */
    public void advance() {
        int tail = (head + 1) % windowSize;
        slotBaseCounter.wipeSlot(tail);
        head = tail;
    }

    /**
     * 获取总的请求数
     * @return 总请求数
     */
    public int totalCount() {
        return slotBaseCounter.totalCount();
    }

    @Override
    public String toString() {
        return "total = " + totalCount() + " head = " + head + " >> " + slotBaseCounter;
    }
}
