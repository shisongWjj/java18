package java18;

import java18.dto.RenterOrderWzCostDetailEntity;
import java18.utils.CompareHelper;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Test
 *
 * @author shisong
 * @date 2020/1/7
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception{
        List<RenterOrderWzCostDetailEntity> list = new ArrayList<>();
        RenterOrderWzCostDetailEntity target = new RenterOrderWzCostDetailEntity();
        target.setAmount("300");
        target.setRemark("11111");
        list.add(target);
        RenterOrderWzCostDetailEntity source = new RenterOrderWzCostDetailEntity();
        source.setAmount("300");
        source.setRemark("2222");
        list.add(source);

        int sum = list.stream().map(RenterOrderWzCostDetailEntity::getAmount).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

        /*Map<String,String> paramNames = new LinkedHashMap<>();
        paramNames.put("amount","其他扣款");
        paramNames.put("remark","其他扣款备注");*/

        /*CompareHelper<RenterOrderWzCostDetailEntity> comparable = new CompareHelper<>(target,source,paramNames);
        String compare = comparable.compare();
        System.out.println(compare);*/

    }

    @org.junit.Test
    public void test2(){
       /* List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        List<Integer> integers1 = integers.subList(0, 8);
        System.out.println(integers1);*/
       String a = "1234567890123456789";
       a = a.substring(0,a.length()-5);
       System.out.println(a);
    }

    @org.junit.Test
    public void test3() throws Exception{
      /*  String endDateStr = "2020-04-11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = sdf.parse(endDateStr);
        Date startDate = new Date();
        Long diffDay = null;

        // 得到相差的天数 betweenDate
        diffDay = (endDate.getTime() - startDate.getTime()) / (60 * 60 * 24 * 1000);
        System.out.println(diffDay);*/
     /* String s = "11111";
      Object o = (Object)s;
      int i = (int)o;
      System.out.println(i);*/
       /* int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a, 10);
        System.out.println("b.length:"+b.length);
        for(int i = 0 ; i < b.length; i++){
            System.out.println(b[i]);
        }*/
       System.out.println(this.tableSizeFor(3));
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static boolean stop = false;
    private static volatile int i = 0;

            @org.junit.Test
    public void test1(){
        Thread thread = new Thread(()->{
            while (!stop){
                i++;
            }
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
        System.out.println(i);
    }

}
