package java18.Collector;

import java18.Stream.test.dto.UserCourseDto;
import java18.utils.ListHelper;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorTest {

    private List<UserCourseDto> getSource() {
        List<UserCourseDto> source = Arrays.asList(new UserCourseDto(600169l, 1005l, 35l, 26l, 100001936l),
                new UserCourseDto(600165l, 1006l, 35l, 27l, 100001936l),
                new UserCourseDto(600177l, 1007l, 35l, 28l, 100001936l),
                new UserCourseDto(600178l, 1008l, 35l, 29l, 100001936l),
                new UserCourseDto(600176l, 1009l, 35l, 30l, 100001936l),
                new UserCourseDto(600175l, 1010l, 35l, 31l, 100001936l),
                new UserCourseDto(600169l, 1005l, 36l, 41l, 100001989l),
                new UserCourseDto(600168l, 1011l, 36l, 47l, 100001989l),
                new UserCourseDto(600165l, 1006l, 36l, 42l, 100001989l),
                new UserCourseDto(600168l, 1011l, 36l, 47l, 100001994l),
                new UserCourseDto(600169l, 1005l, 36l, 41l, 100001994l),
                new UserCourseDto(600171l, 1012l, 36l, 48l, 100001994l),
                new UserCourseDto(600175l, 1010l, 36l, 46l, 100001994l),
                new UserCourseDto(600176l, 1009l, 36l, 45l, 100001994l),
                new UserCourseDto(600177l, 1007l, 36l, 43l, 100001994l),
                new UserCourseDto(600165l, 1006l, 36l, 42l, 100001994l),
                new UserCourseDto(600178l, 1008l, 36l, 44l, 100001994l),
                new UserCourseDto(600182l, 1013l, 37l, 64l, 100001950l)
        );
        return source;
    }

    /**
     * Functions.identity()  依赖
     * <dependency>
     * <groupId>com.google.guava</groupId>
     * <artifactId>guava</artifactId>
     * <version>23.0</version>
     * </dependency>
     */
    @Test
    public void tomapTest() {
        /*List<UserCourseDto> source= Arrays.asList(new UserCourseDto(600169l,1005l,35l,26l,100001936l),
                new UserCourseDto(600169l,1005l,35l,26l,100001936l),
                null,
                //new UserCourseDto(600169l,null,35l,26l,100001936l),
                new UserCourseDto(600182l,1013l,37l,64l,100001950l)
        );*/
        List<UserCourseDto> source = Arrays.asList(new UserCourseDto(600169l, 1005l, 35l, 26l, 100001936l),
                new UserCourseDto(600169l, null, 35l, 26l, 100001936l),
                new UserCourseDto(600182l, 1013l, 37l, 64l, 100001950l)
        );
        Map<Long, Long> longLongMap = ListHelper.listToMap(source, UserCourseDto::getUserId, UserCourseDto::getRecruitId);
        System.out.println(longLongMap);
        Map<Long, Long> collect = source.stream().collect(Collectors.toMap(UserCourseDto::getUserId, UserCourseDto::getRecruitId));
        System.out.println(collect);
        /*Map<Long, List<Long>> longListMap = ListHelper.listToMap(source, UserCourseDto::getUserId, UserCourseDto::getRecruitId,1);
        System.out.println(longListMap);
        Map<Long, List<UserCourseDto>> longListMap1 = ListHelper.listToMap(source, UserCourseDto::getUserId, Functions.identity(),null);
        System.out.println(longListMap1);
        Map<Long, List<Long>> collect = source.stream().collect(Collectors.groupingBy(UserCourseDto::getUserId, Collectors.mapping(UserCourseDto::getRecruitId, Collectors.toList())));
        System.out.println(collect);*/
        /*Map<Long, Map<Long, List<Long>>> collect1 = source.stream().collect(Collectors.groupingBy(UserCourseDto::getUserId, Collectors.groupingBy(UserCourseDto::getRecruitId, Collectors.mapping(UserCourseDto::getCompanyId, Collectors.toList()))));
        System.out.println(collect1);*/
        /*Map<Long, Map<Long, Long>> collect2 = source.stream().collect(Collectors.groupingBy(UserCourseDto::getUserId, Collectors.groupingBy(UserCourseDto::getRecruitId, Collectors.mapping(UserCourseDto::getCompanyId, Collectors.counting()))));
        System.out.println(collect2);*/
        /*Map<Long, Map<Long, Long>> collect3 = source.stream().collect(Collectors.groupingBy(UserCourseDto::getUserId, Collectors.toMap(UserCourseDto::getRecruitId, UserCourseDto::getCompanyId)));
        System.out.println(collect3);*/
        /*Map<Long, Map<Long, UserCourseDto>> collect4 = source.stream().collect(Collectors.groupingBy(UserCourseDto::getUserId, Collectors.toMap(UserCourseDto::getRecruitId, Functions.identity())));
        System.out.println(collect4);*/
    }

    @Test
    public void test() {
        List<Long> longs = ListHelper.extractVariable(this.getSource(), UserCourseDto::getCompanyId, null);
        List<Long> longs1 = ListHelper.extractVariable(this.getSource(), UserCourseDto::getCompanyId, 1);
        System.out.println(longs);
        System.out.println(longs1);
        List<Long> longs2 = ListHelper.extractVariable(new ArrayList<>(), UserCourseDto::getCompanyId, 1);
        /*List<Long> longs3 = ListHelper.extractVariable(new ArrayList<>(), null, 1);*/
        System.out.println(longs2);
    }

    @Test
    public void test99(){
        List<UserCourseDto> collect = this.getSource().stream().sorted(Comparator.comparingLong(UserCourseDto::getCourseId)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test1() {
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> ids1 = Arrays.asList(1, 2, 3, 90);
        List<Integer> iids = new ArrayList<>(ids);
        List<Integer> iids1 = new ArrayList<>(ids1);
        iids.removeAll(iids1);
        System.out.println(ids);
        System.out.println(ids1);
        System.out.println(iids);
        System.out.println(iids1);
    }

    @Test
    public void test2(){
        BigDecimal num1 = new BigDecimal(0.005).setScale(3, RoundingMode.HALF_UP);
        BigDecimal num2 = new BigDecimal(1000000);
        BigDecimal num3 = new BigDecimal(-1000000);
        //尽量用字符串的形式初始化
        BigDecimal num12 = new BigDecimal("0.005").setScale(3, RoundingMode.HALF_UP);
        BigDecimal num22 = new BigDecimal("1000000");
        BigDecimal num32 = new BigDecimal("-1000000");

        System.out.println(num1.subtract(num12).intValue() > 0);

        /*//加法
        BigDecimal result1 = num1.add(num2);
        BigDecimal result12 = num12.add(num22);
        //减法
        BigDecimal result2 = num1.subtract(num2);
        BigDecimal result22 = num12.subtract(num22);
        //乘法
        BigDecimal result3 = num1.multiply(num2);
        BigDecimal result32 = num12.multiply(num22);
        //绝对值
        BigDecimal result4 = num3.abs();
        BigDecimal result42 = num32.abs();
        //除法
        BigDecimal result5 = num2.divide(num1,20,BigDecimal.ROUND_HALF_UP);
        BigDecimal result52 = num22.divide(num12,20,BigDecimal.ROUND_HALF_UP);

        System.out.println("加法用value结果："+result1);
        System.out.println("加法用string结果："+result12);

        System.out.println("减法value结果："+result2);
        System.out.println("减法用string结果："+result22);

        System.out.println("乘法用value结果："+result3);
        System.out.println("乘法用string结果："+result32);

        System.out.println("绝对值用value结果："+result4);
        System.out.println("绝对值用string结果："+result42);

        System.out.println("除法用value结果："+result5);
        System.out.println("除法用string结果："+result52);*/

    }

    @Test
    public  void test14(){
        int a = 150;
        int b = 50;
        for(int i = 0 ; i < 10 ;i++){
            a = a - b;
            if(a >= 0){
                System.out.println(b);
            }else if(a+b>=0){
                System.out.println(a+b);
            }else{
                System.out.println(0);
            }
        }

    }

    @Test
    public void test15(){
        List<Integer> list2 = getInt(300, 2, 1);
        System.out.println(list2);
        List<Integer> list3 = getInt(300, 3, 2);
        List<Integer> list5 = getInt(300, 5, 4);
        List<Integer> list7 = getInt(300, 7, 0);
        list2.retainAll(list3);
        System.out.println(list2);
        list2.retainAll(list5);
        System.out.println(list2);
        list2.retainAll(list7);
        System.out.println(list2);


    }

    private List<Integer> getInt(Integer max,Integer times,Integer remainder){
        List<Integer> result = new ArrayList<>();
        Integer count = 0;
        while (true){
            count ++;
            int temp = times * count + remainder;
            if(temp > max){
                return result;
            }
            result.add(temp);
        }
    }

    public void test16(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
       /* Map<String, Map<String, List<Person>>> peopleByStateAndCity
                = personStream.collect(Collectors.groupingBy(Person::getState,
                Collectors.groupingBy(Person::getCity)));*/
    }

    @Test
    public void test17(){
        BigDecimal bigDecimal = new BigDecimal("0.00");
        System.out.println(bigDecimal.intValue());
        if(bigDecimal.intValue() == 0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
