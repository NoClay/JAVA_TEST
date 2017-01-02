package homework;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by NoClay on 2016/12/1.
 */
public class DateTest {
    public static Date resolveBmobDate(String bmobDate){
        if (bmobDate == null){
            return null;
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = format.parse(bmobDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        int []flag = new int[5];
//        String[] key = {"-", "-", " ", ":", ":"};
//        for (int i = 0; i < key.length; i++) {
//            if (i == 0){
//                flag[i] = bmobDate.indexOf(key[i]);
//            }else{
//                flag[i] = bmobDate.indexOf(key[i], flag[i - 1] + 1);
//            }
//            if (flag[i] == -1){
//                return null;
//            }
//        }
//        int[] times = new int[6];
//        for (int i = 0; i < flag.length; i++) {
//            if (i == 0){
//                times[i] = Integer.parseInt(bmobDate.substring(0, flag[i]));
//            }else{
//                times[i] = Integer.parseInt(bmobDate.substring(flag[i -1] + 1, flag[i]));
//            }
//        }
//        times[5] = Integer.parseInt(bmobDate.substring(flag[4] + 1));
//        for (int i = 0; i < times.length; i++) {
//            System.out.println("" + times[i]);
//        }
//        date = new Date(times[0], times[1], times[2], times[3], times[4], times[5]);
        return date;
    }

    public static String valueOfDate(Date date, String timeFormat){
        if (date == null){
            return null;
        }
        if (timeFormat == null){
            timeFormat = "yyyy-MM-dd HH:mm:00";
        }
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        return format.format(date);
    }
    public static void main(String[] args) {
//        Date date = resolveBmobDate("2016-12-01 20:40:55");
//        System.out.println(date.getYear() + "-" + date.getMonth() + "-" + date.getDay());
//        Calendar calendar;
//        for (int i = 0; i < 100; i++) {
//            calendar = Calendar.getInstance();
//            System.out.println(calendar.getTimeInMillis() + "");
//        }
        Date date = new Date();
        date.setMinutes(60);
        System.out.println(date.toString());
        System.out.println(valueOfDate(date, null) + "\n" +
        date.getMinutes());

    }
}