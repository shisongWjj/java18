package java18.time;

import org.junit.Test;

import javax.smartcardio.TerminalFactory;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

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
        LocalDateTime of = LocalDateTime.of(2018, 5, 10, 0, 0, 01);
        Duration dur = Duration.between(dateTime, of);
        System.out.println(dur.toMinutes());
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
            LocalDate firstSundayInMonth = now1.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
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
        String browseCarEvent = "3600";
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusSeconds(Long.parseLong(browseCarEvent));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime1.atZone(zone).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);
    }
}
