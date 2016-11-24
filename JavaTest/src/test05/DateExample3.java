package test05;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by NoClay on 2016/11/10.
 */
public class DateExample3 {
    public static void main(String args[]) {
        String str = JOptionPane.showInputDialog("输入贷款开始年份:");
        int yearOne = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("输入该年的月份:");
        int monthOne = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("输入该月份的日期:");
        int dayOne = Integer.parseInt(str);

        str = JOptionPane.showInputDialog("输入预计还款的年份:");
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
        str = JOptionPane.showInputDialog("请输入贷款的金额（单位：元）");
        int money = Integer.parseInt(str);
        float one = 0.0004f;

        Date date1 = new Date(timeOne);
        Date date2 = new Date(timeTwo);

        long days = (date1.getTime() - date2.getTime()) / 1000 / 60 / 60 / 24;
        System.out.println(yearOne + "年" + monthOne + "月" + dayOne + "日和"
                + yearTwo + "年" + monthTwo + "月" + dayTwo + "相隔" + days + "天");

        System.out.println("贷款" + money + "元" + (-days) + "天，需要还款"
                + (money * Math.pow((1 + one), (-days))) + "元。");
    }
}
