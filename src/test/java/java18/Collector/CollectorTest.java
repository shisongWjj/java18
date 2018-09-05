package java18.Collector;

import com.google.common.base.Functions;
import java18.Stream.test.dto.UserCourseDto;
import java18.utils.ListHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorTest {

    private List<UserCourseDto> getSource(){
        List<UserCourseDto> source= Arrays.asList(new UserCourseDto(600169l,1005l,35l,26l,100001936l),
                new UserCourseDto(600165l,1006l,35l,27l,100001936l),
                new UserCourseDto(600177l,1007l,35l,28l,100001936l),
                new UserCourseDto(600178l,1008l,35l,29l,100001936l),
                new UserCourseDto(600176l,1009l,35l,30l,100001936l),
                new UserCourseDto(600175l,1010l,35l,31l,100001936l),
                new UserCourseDto(600169l,1005l,36l,41l,100001989l),
                new UserCourseDto(600168l,1011l,36l,47l,100001989l),
                new UserCourseDto(600165l,1006l,36l,42l,100001989l),
                new UserCourseDto(600168l,1011l,36l,47l,100001994l),
                new UserCourseDto(600169l,1005l,36l,41l,100001994l),
                new UserCourseDto(600171l,1012l,36l,48l,100001994l),
                new UserCourseDto(600175l,1010l,36l,46l,100001994l),
                new UserCourseDto(600176l,1009l,36l,45l,100001994l),
                new UserCourseDto(600177l,1007l,36l,43l,100001994l),
                new UserCourseDto(600165l,1006l,36l,42l,100001994l),
                new UserCourseDto(600178l,1008l,36l,44l,100001994l),
                new UserCourseDto(600182l,1013l,37l,64l,100001950l)
        );
        return source;
    }

    /**
     * Functions.identity()  依赖
     * <dependency>
     <groupId>com.google.guava</groupId>
     <artifactId>guava</artifactId>
     <version>23.0</version>
     </dependency>
     */
    @Test
    public void tomapTest(){
        /*List<UserCourseDto> source= Arrays.asList(new UserCourseDto(600169l,1005l,35l,26l,100001936l),
                new UserCourseDto(600169l,1005l,35l,26l,100001936l),
                null,
                //new UserCourseDto(600169l,null,35l,26l,100001936l),
                new UserCourseDto(600182l,1013l,37l,64l,100001950l)
        );*/
        List<UserCourseDto> source= Arrays.asList(new UserCourseDto(600169l,1005l,35l,26l,100001936l),
                new UserCourseDto(600169l,null,35l,26l,100001936l),
                new UserCourseDto(600182l,1013l,37l,64l,100001950l)
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
    public void test(){
        List<Long> longs = ListHelper.extractVariable(this.getSource(), UserCourseDto::getCompanyId, null);
        List<Long> longs1 = ListHelper.extractVariable(this.getSource(), UserCourseDto::getCompanyId, 1);
        System.out.println(longs);
        System.out.println(longs1);
        List<Long> longs2 = ListHelper.extractVariable(new ArrayList<>(), UserCourseDto::getCompanyId, 1);
        /*List<Long> longs3 = ListHelper.extractVariable(new ArrayList<>(), null, 1);*/
        System.out.println(longs2);
    }

    @Test
    public void test1(){
        List<Integer> ids = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> ids1 = Arrays.asList(1,2,3,90);
        List<Integer> iids = new ArrayList<>(ids);
        List<Integer> iids1 = new ArrayList<>(ids1);
        iids.removeAll(iids1);
        System.out.println(ids);
        System.out.println(ids1);
        System.out.println(iids);
        System.out.println(iids1);
    }

}
