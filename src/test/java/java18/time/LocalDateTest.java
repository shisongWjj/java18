package java18.time;

import java18.aaaa;
import org.junit.Test;

import javax.smartcardio.TerminalFactory;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class LocalDateTest {

    @Test
    public void localDateTimeTest() {
        //LocalDate  日期
        //LocalTime  时间
        //LocalDateTime 日期+时间
        // 人读的时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        LocalDateTime of = LocalDateTime.of(2018, 5, 10, 0, 0, 01);
        System.out.println(of);

        LocalDateTime localDateTime = dateTime.minusDays(20);
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = dateTime.plusDays(20);
        System.out.println(localDateTime1);
        boolean before = localDateTime.isBefore(localDateTime1);
        System.out.println(before);
    }

    @Test
    public void localDateTimeTest1() {
        LocalDateTime of = LocalDateTime.of(2018, 7, 21, 0, 0, 01);
        LocalDateTime localDateTime = of.plusDays(112l);
        System.out.println(localDateTime);
    }

    @Test
    public void instantTest() {
        //机器读的时间 有时差
        Instant isn = Instant.now();
        System.out.println(isn);
        OffsetDateTime offsetDateTime = isn.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }

    @Test
    public void DurationTest() {
        //Duration 2个时间之间的间隔
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(2021, 4, 20, 10, 15, 00);
        LocalDateTime of2 = LocalDateTime.of(2021, 4, 21, 10, 00, 00);
        Duration dur = Duration.between(of, of2);
        System.out.println(dur.toHours());

        Duration dur1 = Duration.between(of, dateTime);
        System.out.println(dur1.toMinutes());
    }

    @Test
    public void periodTest() {
        //Period 2个日期之间的间隔
        LocalDate dateTime = LocalDate.now();
        LocalDate of = LocalDate.of(2018, 5, 1);
        Period p = Period.between(dateTime, of);
        System.out.println(p.getDays());

        Period p1 = Period.between(of, dateTime);
        System.out.println(p1.getDays());
        System.out.println(p1.getMonths());
    }

    @Test
    public void Test() {
        //TemporalAdjuster 时间矫正器
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime with = ldt.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);
        LocalDateTime with1 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with1);
        LocalDateTime with2 = ldt.with(TemporalAdjusters.firstDayOfNextMonth()).with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with2);

        System.out.println("--------------------------------");

        //梦幻西游  每月第一周的周日的活动奖励很好
        //计算最近一次的这个活动
        LocalDate now = LocalDate.now();
        //LocalDate now = LocalDate.of(2018,05,06);
        LocalDate with3 = now.with(l -> {
            LocalDate now1 = (LocalDate) l;
            LocalDate firstSundayInMonth = now1.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));//firstDayOfMonth
            if (now1.isBefore(firstSundayInMonth)) {
                return firstSundayInMonth;
            } else {
                return now1.with(TemporalAdjusters.firstDayOfNextMonth()).with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
            }
        });
        System.out.println(with3);
    }

    @Test
    public void dateTimeFormatterTest() {
        //DateTimeFormatter 不带时区的格式化时间
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String format = ldt.format(dtf);
        System.out.println(format);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");//12小时
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");//24小时

        String format1 = dtf1.format(ldt);
        String format2 = ldt.format(dtf2);
        System.out.println(format1);
        System.out.println(format2);
    }

    @Test
    public void test() {
        //ZonedDateTime
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.stream().forEach(str -> {
            if (str.toLowerCase().contains("shanghai")) {
                System.out.println("-------------------------------------------------");
            }
            System.out.println(str);
        });
    }

    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(2014, 5, 10, 0, 0, 01);
        LocalDateTime localDateTime = of.plusDays(2000l);
        System.out.println(localDateTime);
        Duration between = Duration.between(of, now);
        System.out.println("结婚" + between.toDays() + "天");
    }

    // 01. java.util.Date --> java.time.LocalDateTime
    public void UDateToLocalDateTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    public void UDateToLocalDate() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public void UDateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public void LocalDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

    @Test
    public void LocalTimeToUdate1() {
//        ZoneId zone = ZoneId.systemDefault();
//        Instant instant = localDateTime.atZone(zone).toInstant();
        /*Instant now = Instant.now();
        Date date = Date.from(now);
        System.out.println(date);*/
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(1);
        System.out.println(localDate);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);
    }

    @Test
    public void test11(){
       /* String browseCarEvent = "3600";
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusSeconds(Long.parseLong(browseCarEvent));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime1.atZone(zone).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);*/
        LocalDateTime now = LocalDateTime.of(2019,7,24,10,45,59);
        LocalDateTime localDateTime1 = now.plusDays(1L);
        localDateTime1.getMinute();
        LocalDateTime localDateTime15 = LocalDateTime.of(localDateTime1.getYear(),localDateTime1.getMonth(),localDateTime1.getDayOfMonth(),localDateTime1.getHour(),15,0);
        LocalDateTime localDateTime30 = LocalDateTime.of(localDateTime1.getYear(),localDateTime1.getMonth(),localDateTime1.getDayOfMonth(),localDateTime1.getHour(),30,0);
        LocalDateTime localDateTime45 = LocalDateTime.of(localDateTime1.getYear(),localDateTime1.getMonth(),localDateTime1.getDayOfMonth(),localDateTime1.getHour(),45,0);
        System.out.println(Duration.between(localDateTime1,localDateTime15).toMinutes());
        System.out.println(Duration.between(localDateTime1,localDateTime30).toMinutes());
        System.out.println(Duration.between(localDateTime1,localDateTime45).toMinutes());
        LocalDateTime localDateTime2 = localDateTime1.plusHours(1);
        LocalDateTime localDateTime0= LocalDateTime.of(localDateTime2.getYear(),localDateTime2.getMonth(),localDateTime2.getDayOfMonth(),localDateTime2.getHour(),0,0);
        System.out.println(Duration.between(localDateTime1,localDateTime0).toMinutes());
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String format = localDateTime1.format(formatter);*/

    }
    @Test
    public void test12(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        /*  Calendar calendar = new GregorianCalendar();//当前时间
        System.out.println(Long.valueOf(DATETIME_SEC_STR.format(calendar.getTime())));
        calendar.add(Calendar.MINUTE, (2 * 60 - 5));//
        long minTime = Long.valueOf(Long.valueOf(DATETIME_SEC_STR.format(calendar.getTime())));
        calendar.add(Calendar.MINUTE, 15);//
        long maxTime = Long.valueOf(Long.valueOf(DATETIME_SEC_STR.format(calendar.getTime())));
        Map<String,Long> map = new HashMap<>();
        map.put("minTime", minTime);
        map.put("maxTime", maxTime);
        System.out.println(map);*/
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusMonths(6L);
        System.out.println(localDateTime1.format(formatter));
    }

    @Test
    public void test13(){
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDateTime localDateTime1 = localDateTime.plusMonths(3);
        Instant instant1 = localDateTime1.atZone(zone).toInstant();
        Date date1 = Date.from(instant1);
        System.out.println(date);
        System.out.println(date1);
    }

    @Test
    public void test14(){
        /*ZoneId zone = ZoneId.systemDefault();

        LocalDate ldt = LocalDate.now();
        Instant instant = ldt.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);

        LocalDate with = ldt.with(TemporalAdjusters.firstDayOfMonth());
        Instant instant1 = with.atStartOfDay().atZone(zone).toInstant();
        Date date1 = Date.from(instant1);
        System.out.println(date1);

        LocalDate with1 = ldt.with(TemporalAdjusters.firstDayOfNextMonth());
        Instant instant2 = with1.atStartOfDay().atZone(zone).toInstant();
        Date date2 = Date.from(instant2);
        System.out.println(date2);
*/
       /* int num = 50 ;
        num = num ++ * 2 ;
        System.out.println(num) ;*/
       /* boolean flag = 10%2 == 1 && 10 / 3 == 0 && 1 / 0 == 0 ;
        System.out.println(flag ? "mldn" : "yootk") ;*/

        StringBuilder temp = new StringBuilder("冀R035J8");
        System.out.println(("适用车辆：" + temp.replace(2, 5, "***")));
    }

    @Test
    public void test15(){
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDateTime localDateTime1 = localDateTime.plusMonths(3);
        //Duration 2个时间之间的间隔
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(2018, 5, 10, 0, 0, 01);
        Duration dur = Duration.between(dateTime, of);
        System.out.println(dur.toDays());
        Duration dur1 = Duration.between(of, dateTime);
        System.out.println(dur1.toDays());
    }

    @Test
    public void test16(){
        int i = 12 / 10;
        System.out.println(i);
        //System.out.println(Integer.toHexString(7));
        System.out.println(0b10111011000010110100&0b1111);
    }

    @Test
    public void test17(){
        Integer a = 15;
        List<Integer> integers = aaaa.reverseOrOperation(a);
        System.out.println(integers);
    }

    @Test
    public void test18(){
        LocalDate ld = LocalDate.now();
        LocalDate localDate = ld.plusDays(58);
        System.out.println(localDate);
    }

    @Test
    public void test19(){
        LocalDate now = LocalDate.now();
        LocalDate firstYear = now.with(TemporalAdjusters.firstDayOfYear());
        System.out.println(firstYear);
    }

    @Test
    public void test20(){
        System.out.println((int)(Math.random()*30+20));
    }

    @Test
    public void test21(){
        LocalDateTime now = LocalDateTime.now();
        for(int i = 1; i <=30 ;i++){
            LocalDateTime localDateTime = now.plusDays(i);
            int value = localDateTime.getDayOfWeek().getValue();
            System.out.println(value);
        }
    }
}
