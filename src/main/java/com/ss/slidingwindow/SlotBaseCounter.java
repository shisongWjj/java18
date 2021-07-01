package com.ss.slidingwindow;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SlotBaseCounter
 *
 * @author shisong
 * @date 2021/6/30
 */
public class SlotBaseCounter {

    /**
     * 滑动窗口的长度
     */
    private int slotSize;
    /**
     * 用来存放每个槽点所对应的请求数
     */
    private AtomicInteger[] slotCounter;

    public SlotBaseCounter(int slotSize) {
        slotSize = Math.max(slotSize, 1);
        this.slotSize = slotSize;
        this.slotCounter = new AtomicInteger[slotSize];
        for (int i = 0; i < this.slotSize; i++) {
            slotCounter[i] = new AtomicInteger(0);
        }
    }

    /**
     * 当前槽点 自增+1
     * @param slotSize 当前槽点
     */
    public void increaseSlot(int slotSize) {
        slotCounter[slotSize].incrementAndGet();
    }

    /**
     * 当前槽点的请求 置为0
     * @param slotSize 当前槽点
     */
    public void wipeSlot(int slotSize) {
        slotCounter[slotSize].set(0);
    }

    /**
     * 当前滑动窗口中 所有的请求数
     * @return 所有的请求数
     */
    public int totalCount() {
        return Arrays.stream(slotCounter).mapToInt(AtomicInteger::get).sum();
    }

    @Override
    public String toString() {
        return Arrays.toString(slotCounter);
    }

}
