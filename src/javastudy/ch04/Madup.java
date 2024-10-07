package javastudy.ch04;

import java.util.*; // 유틸리티 클래스 사용을 위한 패키지 임포트

public class Madup {
    // 생일 목록을 받아서 선물의 총 개수를 반환하는 메서드
    public static int solution(String[] birthdays) {
        int totalGifts = 0; // 선물 총 개수를 저장할 변수 초기화
        int n = birthdays.length; // 팀원의 수를 가져오기
        int[] birthDays = new int[n]; // 생일을 일수로 저장할 배열 생성
        boolean[] isWeekend = new boolean[n]; // 주말 여부를 저장할 배열 생성

        // 모든 팀원의 생일 정보를 처리
        for (int i = 0; i < n; i++) {
            String[] parts = birthdays[i].split(", "); // 생일 문자열을 분리하여 날짜와 요일 저장
            String dateStr = parts[0]; // 생일 날짜
            String dayOfWeek = parts[1]; // 생일 요일

            // 날짜를 2023년 1월 1일부터의 일수로 변환하여 저장
            birthDays[i] = getDaysFromStartOfYear(dateStr);
            // 생일이 주말인지 확인하여 저장
            isWeekend[i] = dayOfWeek.equals("토요일") || dayOfWeek.equals("일요일");
        }

        // 선물 주고받기 조건 확인
        for (int i = 0; i < n; i++) {
            if (isWeekend[i]) continue; // 생일이 주말인 경우, 다음 반복으로 넘어감

            for (int j = 0; j < n; j++) {
                if (i == j || isWeekend[j]) continue; // 본인 또는 생일이 주말인 경우 제외

                // 생일 날짜 차이 계산
                int dayDifference = Math.abs(birthDays[i] - birthDays[j]);
                if (dayDifference >= 5) { // 날짜 차이가 5일 이상인 경우
                    totalGifts++; // 선물 개수 증가
                }
            }
        }

        return totalGifts; // 총 선물 개수 반환
    }

    // 주어진 날짜 문자열을 1월 1일부터의 일수로 변환하는 메서드
    private static int getDaysFromStartOfYear(String dateStr) {
        String[] parts = dateStr.split("/"); // 날짜를 월과 일로 분리
        int month = Integer.parseInt(parts[0]); // 월을 정수로 변환
        int day = Integer.parseInt(parts[1]); // 일을 정수로 변환

        // 각 월의 일수를 저장하는 배열 (2023년 기준)
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0; // 1월 1일부터 주어진 날짜까지의 총 일수 초기화

        // 1월부터 해당 월까지의 일수 계산
        for (int i = 1; i < month; i++) {
            days += daysInMonth[i]; // 각 월의 일수를 더하기
        }
        days += day; // 해당 월의 일수 추가

        return days; // 최종 일수 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("팀원 수를 입력해주세요");
        int n = sc.nextInt();
        String [] birthdays =  new String[n];

        for(int i = 0; i < birthdays.length; i++) {

            birthdays[i] = sc.next();
        }
        // 테스트할 생일 목록 정의


        // 생일 목록에 따라 총 선물 개수 계산
        int result = solution(birthdays);
        // 결과 출력
        System.out.println("총 선물 개수: " + result);
    }
}
