package teacherstudyre;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Study20240626_4 {
    public static void main(String[] args) {
        Date currentDate = new Date();
        System.out.println("현재 날짜 : " + currentDate);

        Calendar calendar = Calendar.getInstance();
        /*
        // 어제 날짜 설정
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        System.out.println("어제 날짜: " + yesterday);

        // 내일 날짜 설정
        calendar.add(Calendar.DATE, 1);
        Date tomorrow = calendar.getTime();
        System.out.println("내일 날짜: " + tomorrow);

        // 특정 날짜 설정
        calendar.set(2024, Calendar.MAY, 22); // 2024년 5월 22일 설정
        Date date = calendar.getTime();
        System.out.println("특정 날짜: " + date);

        // 현재시간
        System.out.println("현재 시간: " + calendar.getTime());

        //LocalDate
        // 현재 날짜
        LocalDate localcurrentDate = LocalDate.now();
        System.out.println("현재 날짜 :" + localcurrentDate);
        // 어제 날짜
        LocalDate yesterday = LocalDate.now().minusDays(1);
        System.out.println("어제 날짜: " + yesterday);
        // 내일 날짜
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("내일 날짜: " + tomorrow);
        // 특정 날짜
        LocalDate specificDate = LocalDate.of(2024, 5, 22); // 2024년 5월 22일 설정
        System.out.println("특정 날짜: " + specificDate);

        //LocalDateTime
        // 현재 날짜와 시간
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("현재 날짜와 시간: " + currentDateTime);

        // 특정 날짜와 시간
        LocalDateTime specificDateTime = LocalDateTime.of(2024,5,22,14,30); // 2024년 5월 22일 14시 30분
        System.out.println("특정 날짜와 시간: " + specificDateTime);

         */
        Date now = new Date();
        // 날짜 포맷팅
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(now);
        System.out.println("포맷팅된 날짜와 시간: " + formattedDate);
        // 다른 형식으로 포맷팅
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        String formattedDate2 = sdf2.format(now);
        System.out.println("다른 형식으로 포맷팅된 날짜: " + formattedDate2);

    }
}
