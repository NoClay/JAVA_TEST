package test05;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by NoClay on 2016/11/10.
 */
public class DateExample {
    public static void main(String args[]) {
        String str = JOptionPane.showInputDialog("输入第一个日期的年份:");
        int yearOne = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("输入该年的月份:");
        int monthOne = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("输入该月份的日期:");
        int dayOne = Integer.parseInt(str);

        str = JOptionPane.showInputDialog("输入第二个日期的年份:");
        int yearTwo = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("输入该年的月份:");
        int monthTwo = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("输入该月份的日期:");
        int dayTwo = Integer.parseInt(str);
        Calendar calendar = Calendar.getInstance();
        calendar.set(yearOne, monthOne, dayOne);
        long timeOne = calendar.getTimeInMillis();
        calendar.set(yearTwo, monthTwo, dayTwo);
        long timeTwo = calendar.getTimeInMillis();

        Date date1 = new Date(timeOne);
        Date date2 = new Date(timeTwo);
        if (date2.equals(date1)) {
            System.out.println("两个日期的年、月、日完全相同");
        } else if (date2.after(date1)) {
            System.out.println("您输入的第二个日期大于第一个日期");
        } else if (date2.before(date1)) {
            System.out.println("您输入的第二个日期小于第一个日期");
        }
        long days = (date1.getTime() - date2.getTime()) / 1000 / 60 / 60 / 24;
        System.out.println(yearOne + "年" + monthOne + "月" + dayOne + "日和"
                + yearTwo + "年" + monthTwo + "月" + dayTwo + "相隔" + days + "天");
    }

}
