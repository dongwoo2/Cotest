package teacherstudyre;

import java.time.LocalDateTime;

public class Study20240626_2 {
    public static void main(String[] args) {
        // LocalDateTime은 LocalDate와 LocalTime을 합쳐 놓은 것으로, 날짜와 시간 정보를 모두 가지고 있습니다.
        LocalDateTime now = LocalDateTime.now();

        System.out.println("now = " + now);

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        System.out.printf("%d년 %d월 %d일 %d시 %d분 %d초%n" ,year, month, day, hour, minute, second);
    }
}
