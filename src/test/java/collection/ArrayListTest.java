package collection;

import com.zhihuishu.teacher.commons.jtest.core.RepeatFixedDuration;
import com.zhihuishu.teacher.commons.jtest.core.RepeatFixedTimes;
import com.zhihuishu.teacher.commons.jtest.core.StatisticsSpringJunitRunner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.FrameworkMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ArrayListTest
 *
 * @author shisong
 * @date 2019/3/20
 */
@RunWith(StatisticsSpringJunitRunner.class)
public class ArrayListTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("a" + i);
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
            list.add(i + "a");
        }
        System.out.println(list);
    }

    @Test
    public void test1() {

        Student s1 = new Student();
        s1.setAge(20);
        s1.setName("123123");

        setAge(s1);
        System.out.println(s1);

    }

    private void setAge(Student s1) {
        Student s2 = s1;
        s2.setAge(30);
    }

    @Test
    public void test3() {
        try {
            String enrollmentYear = "2017-01-01 00:00:00";
            Date enrollmentYearDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if (StringUtils.isNotBlank(enrollmentYear)) {
                enrollmentYearDate = sdf.parse(enrollmentYear);
            }
            System.out.println(enrollmentYearDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){
        Method[] methods = ArrayListTest.class.getMethods();
        for (Method method : methods) {
            FrameworkMethod frameworkMethod = new FrameworkMethod(method);
            Annotation[] annotations = frameworkMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
            }
        }
    }

    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

    @Test
    @RepeatFixedDuration(value = 5000)
    public void test123(){
        Collections.shuffle(integers);
        List<Integer> integers = this.integers.subList(0, 7);
        System.out.println(integers);
        System.out.println(this.integers);
    }

}
