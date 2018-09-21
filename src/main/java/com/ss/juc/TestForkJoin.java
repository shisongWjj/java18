package com.ss.juc;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 分支合并框架，分别可以继承一下2个
 * RecursiveAction ==》无返回值
 * RecursiveTask<T> ==》有返回值
 */
public class TestForkJoin {

    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L,10000000000L);

        Long sum = pool.invoke(task);

        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("共耗费："+ Duration.between(start,end).toMillis());//36497
    }


    @Test
    public void test1(){
        Instant start = Instant.now();
        //long reduce = LongStream.rangeClosed(0L, 10000000000L).reduce(0l, Long::sum);//264-17361 5340232216128654848
        long reduce = LongStream.rangeClosed(0L, 10000000000L).parallel().reduce(0l, Long::sum);//273-2397  5340232216128654848
        System.out.println(reduce);

        Instant end = Instant.now();
        System.out.println("共耗费："+ Duration.between(start,end).toMillis());
    }

    @Test
    public void test2(){ //55329
        Instant start = Instant.now();
        Long sum= 0L;
        for(Long i =0L;i<=10000000000L;i++){
            sum+=i;
        }
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("共耗费："+ Duration.between(start,end).toMillis());
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long>{

    private Long start;//起始位置
    private Long end;//结束位置

    private static Long CRITICAL_VALUE=10000L;

    public ForkJoinSumCalculate(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if((end-start)<=CRITICAL_VALUE){
            //当结束值-起始值 小于 临界值时
            //不在分割
            Long sum=0L;
            for (Long i = start; i<=end ;i++){
                sum+=i;
            }
            return sum;
        }else{
            //拆分
            Long middle = (start+end)/2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle+1,end);

            left.fork();
            right.fork();

            return left.join()+right.join();
        }
    }
}