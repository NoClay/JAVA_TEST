package test05;

import java.applet.Applet;
import java.awt.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by NoClay on 2016/11/10.
 */
public class LX5_1 extends Applet{

    public void paint(Graphics g) {
        Date today;
        Calendar now;
        DateFormat f1,f2;
        String s1,s2;
        today = new Date(System.currentTimeMillis());

        g.drawString("字符串格式："+today.toString(),20,20);
        f1 = DateFormat.getDateInstance();
        s1 = f1.format(today);
        g.drawString("系统格式："+s1,20,40); // 生成长格式的中国日期格式化器
        f1=DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        f2=DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);
        s1=f1.format(today); // 将日期转换为日期字符串
        s2=f2.format(today); // 将日期转换为时间字符串
        g.drawString("中国格式："+s1+" "+s2,20,60);
        now = Calendar.getInstance();
        s1=now.get(now.HOUR)+" 时"+now.get(now.MINUTE)+" 分"+now.get(now.SECOND)+"秒";
        g.drawString("调整前时间："+s1,20,80);
        now.set(2016, 12, 31);
        today=now.getTime();
        g.drawString("调整后时间："+today.toString(),20,100);
    }

}