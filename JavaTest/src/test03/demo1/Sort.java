package test03.demo1;

import java.applet.Applet;
import java.awt.*;

public class Sort extends Applet {

    IntSort s=new IntSort();

    public void paint(Graphics g) {
        int a=30, b=12, c=40;
        int arr[]={34,8,12,67,44,98,52,23,16,16};
        g.drawString("两个数的排序结果是："+s.sort(a,b),30,30);
        g.drawString("三个数的排序结果是："+s.sort(a,b,c),30,60);
        g.drawString("数组的排序结果是："+s.sort(arr),30,90);
    }
}
