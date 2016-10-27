package test04;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by NoClay on 2016/10/27.
 */
public class LX5_2 extends Applet {
    public void paint(Graphics g) {
        String str="这是一个字符串This is a test string";
        g.drawString("正常字符串："+str, 30, 30);
        g.drawString("翻转字符串："+reverse(str), 30, 60);
    }
    public String reverse(String s) {
        int len=s.length();
        StringBuffer buffer= new StringBuffer(len);
        buffer.append(s);
        buffer.reverse();
        //创建一个大小为len的StringBuffer对象，并赋给buffer变量
        // 将字符串s的反转字符串存入buffer.
        return buffer.toString();
    }
}

