package java18.utils;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 时间（日期）相关的工具类
 *
 * @param
 * @author shisong
 * @Description
 * @date 15:33 2018/6/25
 * @modifyNote
 * @return
 */
public class DateUtils {

    /**
     * 计算从开始时间到结束时间 一共几个自然周
     * eg:
     * 1. 开始 2018.06.18（周一）
     * 结束 2018.06.24（周日）
     * 实际计算：（2018.06.18--2018.06.24）
     * return 1
     * 2. 开始 2018.06.17（周日  非周一）
     * 结束 2018.06.24 （周日）
     * return 2（2018.06.11--2018.06.24）
     * 3. 开始 2018.06.18 （周一）
     * 结束 2018.06.25（周一 非周日）
     * return 2（2018.06.18--2018.07.01）
     * 4. 开始 2018.06.17（周日 非周一）
     * 结束 2018.06.25（周一  非周日）
     * return 3 （2018.06.11--2018.07.01）
     *
     * @param
     * @return
     * @Description
     * @author shisong
     * @date 15:35 2018/6/25
     * @modifyNote
     */
    public static Integer getWeeksBetweenStartAndEnd(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        LocalDateTime startLocalDate = getMondayOfThisWeek(startDate);
        LocalDateTime endLocalDate = getSundayOfThisWeek(endDate);
        Duration duration = Duration.between(startLocalDate, endLocalDate);
        int betweenDays = (int) duration.toDays();
        return (betweenDays + 1) / 7;
    }

    /**
     * 获取当前周的周一
     *
     * @param
     * @return
     * @Description
     * @author shisong
     * @date 16:18 2018/6/25
     * @modifyNote
     */
    private static LocalDateTime getMondayOfThisWeek(Date startDate) {
        if (startDate == null) {
            return null;
        }
        Instant instant = startDate.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        if (!dayOfWeek.equals(DayOfWeek.MONDAY)) {
            TemporalAdjuster temporalAdjuster = TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY);
            localDateTime = localDateTime.with(temporalAdjuster);
        }
        return localDateTime;
    }

    /**
     * 获取当前周的 周日
     *
     * @param
     * @return
     * @Description
     * @author shisong
     * @date 16:18 2018/6/25
     * @modifyNote
     */
    private static LocalDateTime getSundayOfThisWeek(Date endDate) {
        if (endDate == null) {
            return null;
        }
        Instant instant = endDate.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        if (!dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            TemporalAdjuster temporalAdjuster = TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY);
            localDateTime = localDateTime.with(temporalAdjuster);
        }
        return localDateTime;
    }

}
