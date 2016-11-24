package homework;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by NoClay on 2016/11/16.
 */
public class Compute{
    public static void First(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char [] key = {'+', '-', '*', '/'};
        int len = -1;
        int flag = 0;
        for (int i = 0; i < key.length; i++) {
            len = s.indexOf(key[i]);
            if (len != -1){
                flag = i;
                break;
            }
        }
        BigDecimal m = new BigDecimal(s.substring(0, len));
        BigDecimal n = new BigDecimal(s.substring(len + 1));
        switch (flag){
            case 0:{
                System.out.println(m.add(n));
                break;
            }
            case 1:{
                System.out.println(m.subtract(n));
                break;
            }
            case 2:{
                System.out.println(m.multiply(n));
                break;
            }
            case 3:{
                System.out.println(m.divide(n));
                break;
            }
        }
    }

    public static void Second(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(Long.parseLong(s));
        System.out.println(ca.get(Calendar.YEAR ) + "-"
                + ca.get(Calendar.MONTH) + "-" + ca.get(Calendar.DAY_OF_MONTH));
    }

    public static Object max(Comparable[] a){
        Object tempObj = new Object();
        for (int i = 0; i < a.length - 1; i++){
            if ((a[i]).compareTo(a[i+1]) > 0 )
                tempObj = a[i];
            else
                tempObj = a[i+1];
        }
        return tempObj;
    }

    public static void Third(){
        Scanner scanner = new Scanner(System.in);
        String m = scanner.next();
        String n = scanner.next();
        boolean flag = false;
        int i = n.length();
        while (!flag){
            i --;
            String temp = n.substring(0, i);
            flag = m.startsWith(n);
        }
        System.out.println();
    }
    public static void main(String []args){
        String []a = {"a", "ab", "c"};
        Integer [] b= {1212,123123, 23423};
        System.out.println(Compute.max(a));
        System.out.println(Compute.max(b));
    }
}
