package homework;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NoClay on 2016/10/27.
 */
public class Test {

    /*从键盘输入若干人名、地名或者国家名，要求按照升序排序之后输出。

输入格式:

7（表示将输入7个人名或者地名）

Zhang3

Li4

Wang5

Ma6

Chen7

Shu8

Ren9

输出格式:

Chen7

Li4

Ma6

Ren9

Shu8

Wang5

Zhang3

输入样例:

5
Xi'an
HanZhong
BaoJi
Yan'an
WeiNan
输出样例:

BaoJi
HanZhong
WeiNan
Xi'an
Yan'an*/


    public static void toToast(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        String []list;
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        list = new String[c];
        for (int i = 0; i < c; i++) {
            Scanner s = new Scanner(System.in);
            String str = s.next();
            list[i] = str;
        }

        Arrays.sort(list);
        for (int i = 0; i < c; i++)
            System.out.println(list[i] + " ");
    }

    private static void ma(int n) {
        try {
            toToast("ma1");
            mb(n);
            toToast("ma2");
        } catch (EOFException e) {
            toToast("e1");
        } catch (IOException e) {
            toToast("e2");
        } catch (SQLException e) {
            toToast("e3");
        } catch (Exception e) {
            toToast("e4");
        } finally {
            toToast("In Finally");
        }
    }

    private static void mb(int n) throws Exception {
        toToast("mb1");
        if (n == 1) throw new EOFException();
        if (n == 2) throw new FileNotFoundException();
        if (n == 3) {
            throw new SQLException();
        }
        if (n == 4) {
            throw new NullPointerException();
        }
        toToast("mb2");
    }

//    private int get() {
//        try{
//            return 1;
//        }finally {
//            return 2;
//        }
//    }
}