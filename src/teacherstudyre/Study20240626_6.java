package teacherstudyre;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Study20240626_6 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine(); // 남아있는 개행문자 지우는 용
        String arr[] = new String[n];
        int intarr[] = new int[n];
        int hour = 0;
        int minute = 0;
        int check = 0;
        String stringhour = "";
        String stringminute = "";

        System.out.println("2023-02-22T12:00:00+09:00 이 형식으로 입력해주세요.");
        String input = sc.nextLine();



        // 1 ~ 1440
        // 랜덤 숫자 들어가게 구해야함
        LocalDateTime now = LocalDateTime.now();
        for(int i = 0; i < n; i++) {
            if (check == 0) { // 시간 구하는 거 랜덤으로 첫 번쨰
                if (now.getHour() > 12 && now.getHour() < 15) {
                    hour = now.getHour() + 1;
                } else if (now.getHour() < 12 && now.getHour() > 9) {
                    hour = now.getHour() - 1;
                } else if (now.getHour() > 20 && now.getHour() < 23) {
                    hour = now.getHour() + 1;
                } else if (now.getHour() == 23) {
                    hour = 1;
                } else {
                    hour = now.getHour() + 3;
                }
                if(now.getMinute() > 0 && now.getMinute() < 49) {  // 몇 분 구하는거
                    minute = now.getMinute() + 10;
                } else if(now.getMinute() > 50 && now.getMinute() < 59) {
                    minute = now.getMinute() - 20;
                } else if(now.getMinute() == 59) {
                    minute = 1;
                } else {
                    minute = now.getMinute()+1;
                }
                check++;
            } else {
                if (hour > 12 && hour < 15) {
                    hour += 1;
                } else if (hour < 12 && hour > 9) {
                    hour -= 1;
                } else if (hour > 20 && hour < 23) {
                    hour += 1;
                } else if (hour == 23) {
                    hour = 1;
                }
                else {
                    hour += 3;
                }
                if(minute > 0 && minute < 49) {
                    minute += 10;
                } else if(minute > 50 && minute < 59) {
                    minute -= 20;
                } else if(minute == 59) {
                    minute = 1;
                } else {
                    minute += 1;
                }
            }
            intarr[i] = (60 * hour + minute);
            stringhour = Integer.toString(hour);
            stringminute = Integer.toString(minute);
            String all = stringhour + ":" + stringminute;
            arr[i] = all;
        }
//        System.out.println("now = " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        ZonedDateTime currentTime = ZonedDateTime.parse(input, formatter);
        int zonehour = currentTime.getHour();
        int zoneminute = currentTime.getMinute();

        for(int j = 0; j < n; j++) {
            if(intarr[j] > (zonehour * 60 + zoneminute)) {
                System.out.print(arr[j] + ", ");
            }
        }




    }
}
