package teacherstudyre;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Study20240626_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        System.out.println("년도를 입력해주세요.");
        int year = sc.nextInt();
        System.out.println("년 월을 입력해주세요.");
        int month = sc.nextInt();
        System.out.println("몇 일 인지 입력해주세요.");
        int day = sc.nextInt();
        
        
        ZonedDateTime dd = ZonedDateTime.of(year,month,day,0,0,0,0, ZoneId.of("Asia/Seoul"));
        ZonedDateTime dd2 = dd.plusDays(1);
        ZonedDateTime dd3 = dd.minusDays(1);

        System.out.println("dd = " + dd);
        if(dd.getDayOfMonth() == 31 && dd.getMonthValue() == 12) {
            ZonedDateTime dd4 = dd.plusYears(1);
            ZonedDateTime dd5 = dd.withMonth(1);
            ZonedDateTime dd6 = dd.withDayOfMonth(1);
            System.out.printf("다음 날 : %d년 %d월 %d일" ,dd4.getYear(),dd5.getMonthValue(), dd6.getDayOfMonth());
            System.out.printf("현재 시간 : %d년 %d월 %d일%d시%d분", dd.getYear(), dd.getMonthValue(), dd2.getDayOfMonth(),dd.getHour(),dd.getMinute());
            System.out.printf("전 날 : %d년 %d월 %d일", dd.getYear(), dd.getMonthValue(), dd3.getDayOfMonth());
        } else {
            System.out.printf("다음 날 : %d년 %d월 %d일", dd.getYear(), dd.getMonthValue(), dd2.getDayOfMonth());
            System.out.printf("현재 시간 : %d년 %d월 %d일%d시%d분", dd.getYear(), dd.getMonthValue(), dd.getDayOfMonth(),dd.getHour(),dd.getMinute());
            System.out.printf("전 날 : %d년 %d월 %d일", dd.getYear(), dd.getMonthValue(), dd3.getDayOfMonth());
        }
    }
}
