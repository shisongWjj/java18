package collection;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ArrayListTest
 *
 * @author shisong
 * @date 2019/3/20
 */
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

}
