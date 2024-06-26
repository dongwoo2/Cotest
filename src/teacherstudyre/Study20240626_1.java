package teacherstudyre;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Study20240626_1 {
    public static void main(String[] args) {
        Date now = new Date(); // 현재 시간을 가져옵니다
        System.out.println("now = " + now); // 현재 시간을 출력합니다.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(now);
        System.out.println("dateString = " + dateString);
    }
}
