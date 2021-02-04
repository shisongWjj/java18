package java18;

import com.ss.test.Person;
import java18.dto.CashierRemoteVo;
import java18.dto.NewOrderFlowVo;
import java18.dto.RenterOrderWzCostDetailEntity;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
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

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int NEW_ORDER_STATUS_CONFIRM = 1;
    private static final int NEW_ORDER_STATUS_PAY = NEW_ORDER_STATUS_CONFIRM << TWO;
    private static final int NEW_ORDER_STATUS_DISPATCH = NEW_ORDER_STATUS_PAY << ONE;
    private static final int NEW_ORDER_STATUS_GET_CAR = NEW_ORDER_STATUS_DISPATCH << ONE;
    private static final int NEW_ORDER_STATUS_RETURN_CAR = NEW_ORDER_STATUS_GET_CAR << ONE;
    private static final int NEW_ORDER_STATUS_SETTLE = NEW_ORDER_STATUS_RETURN_CAR << ONE;
    private static final int NEW_ORDER_STATUS_VIOLATION_SETTLE = NEW_ORDER_STATUS_SETTLE << ONE;
    private static final int NEW_ORDER_STATUS_CLAIMS_PROCESSING = NEW_ORDER_STATUS_VIOLATION_SETTLE << ONE;
    private static final int NEW_ORDER_STATUS_FINISHED = NEW_ORDER_STATUS_CLAIMS_PROCESSING << ONE;

    @org.junit.Test
    public void test0(){
      System.out.println(NEW_ORDER_STATUS_CONFIRM);
      System.out.println(NEW_ORDER_STATUS_PAY);
      System.out.println(NEW_ORDER_STATUS_DISPATCH);
      System.out.println(NEW_ORDER_STATUS_GET_CAR);
      System.out.println(NEW_ORDER_STATUS_RETURN_CAR);
      System.out.println(NEW_ORDER_STATUS_SETTLE);
      System.out.println(NEW_ORDER_STATUS_VIOLATION_SETTLE);
      System.out.println(NEW_ORDER_STATUS_CLAIMS_PROCESSING);
      System.out.println(NEW_ORDER_STATUS_FINISHED);
      int HASH_INCREMENT = 0x61c88647;
      System.out.println(HASH_INCREMENT);
    }

    @org.junit.Test
    public void test_1(){
        /*BigDecimal totalAmount = new BigDecimal(193);
        BigDecimal coefficient = new BigDecimal(1.3D);
        BigDecimal unitPrice = totalAmount.divide(coefficient, RoundingMode.CEILING);
        System.out.println( unitPrice + "元 × " + 1.3D );*/
        /*String baseUrl = "https://test1-web.autozuche.com/";
        if(baseUrl.endsWith("/")){
            baseUrl = baseUrl.substring(0,baseUrl.length()-1);
        }
        System.out.println(baseUrl);*/
        BigDecimal unitPrice = new BigDecimal(193);
        BigDecimal count = new BigDecimal(2.0D);
        BigDecimal coefficient = new BigDecimal(1.3D);
        double value = unitPrice.multiply(count).multiply(coefficient).doubleValue();
        System.out.println(value);
        System.out.println((int)Math.ceil(value));
    }

    @org.junit.Test
    public void test_2(){
        List<Person> list = new ArrayList<>();
        Person person = initPerson("ss");
        list.add(person);
        person = initPerson("ll");
        System.out.println(list);
    }

    private Person initPerson(String userName){
        Person person = new Person();
        person.setUserName(userName);
        return person;
    }

    @org.junit.Test
    public void test_3(){
        /*getNum(1234.09);
        getNum(123120.2343242);*/
        List<NewOrderFlowVo> dtoList = getDtoList();
        int sum = dtoList
                .stream()
                .filter(Objects::nonNull)
                .filter(dto -> dto.getAmt() != null)
                .map(dto -> Math.abs(dto.getAmt()))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }

    private int getNum(double source){
        int temp = (int)Math.floor(source);
        if(temp % 10 > 0){
            temp = (temp / 10 + 1) * 10;
        }
        System.out.println(temp);
        return temp;
    }

    private List<NewOrderFlowVo> getDtoList(){
        return Arrays.asList(
                new NewOrderFlowVo("1111",null,10,null,null),
                new NewOrderFlowVo("1111",null,-10,null,null)
                );
    }

    private List<CashierRemoteVo> getDtoList2(){
        return Arrays.asList(
                new CashierRemoteVo("11",381),
                new CashierRemoteVo("02",2000),
                new CashierRemoteVo("01",26)
                );
    }
    private static final List<String> PAY_KIND_DEPOSITS = Arrays.asList("01","02","03","08");

    @org.junit.Test
    public void test_4(){
        /*getNum(1234.09);
        getNum(123120.2343242);*/
        List<CashierRemoteVo> dtoList = getDtoList2();
        int sum =dtoList
                .stream()
                .filter(Objects::nonNull)
                .filter(dto-> StringUtils.isNotBlank(dto.getPayKind()))
                .filter(dto-> !PAY_KIND_DEPOSITS.contains(dto.getPayKind()))
                .filter(dto -> dto.getPayAmt() != null)
                .map(dto-> Math.abs(dto.getPayAmt()))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }

    @org.junit.Test
    public void test_5(){
        while (true){
            new Thread( ()->{
                System.out.println("111111111111111111111111");
            }).start();
        }
    }

    @org.junit.Test
    public void test_6(){
        //Math.pow();
        /*int a = 1;
        int b = a++;
        System.out.println(a);
        System.out.println(b);*/
       /* List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.size());*/
        //this.tableSizeFor(6);
        /*Map<String,String> map = new HashMap(16);
        map.put("1","1");*/
        Node<Integer,Integer> a1 = new Node<>(11,11,11,null);
        Node<Integer,Integer> a = new Node<>(5,5,5,a1);
        Node<Integer,Integer> b = new Node<>(7,7,7,a);
        Node<Integer,Integer> e = new Node<>(3,3,3,b);

        int oldCap = 2;

        Node<Integer,Integer> loHead = null, loTail = null;
        Node<Integer,Integer> hiHead = null, hiTail = null;
        Node<Integer,Integer> next;
        do {
            next = e.next;
            if ((e.hash & oldCap) == 0) {
                if (loTail == null)
                    loHead = e;
                else
                    loTail.next = e;
                loTail = e;
            }
            else {
                if (hiTail == null)
                    hiHead = e;
                else
                    hiTail.next = e;
                hiTail = e;
            }
        } while ((e = next) != null);
        if (loTail != null) {
            loTail.next = null;
            //newTab[j] = loHead;
        }
        if (hiTail != null) {
            hiTail.next = null;
            //newTab[j + oldCap] = hiHead;
        }
    }

    static class Node<K,V>{
        int hash;
        K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


}
