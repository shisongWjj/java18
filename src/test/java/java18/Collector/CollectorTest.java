package java18.Collector;

import java18.Stream.test.dto.UserCourseDto;

import java.util.Arrays;
import java.util.List;

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



}
