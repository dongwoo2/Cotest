package teacherstudyre;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Study20240626_3 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("now = " + now);

        int year = now.getYear();
        System.out.println("현재년도 : " + year);

        int month = now.getMonthValue();
        System.out.println("현재 월: " + month);

        int day = now.getDayOfMonth();
        System.out.println("현재 일: " + day);

        int hour = now.getHour();
        System.out.println("현재 시간: " + hour);

        int minute = now.getMinute();
        System.out.println("현재 분: " + minute);

        int second = now.getSecond();
        System.out.println("현재 초: " + second);
    }
}
