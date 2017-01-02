package Test.Test12_27_2;

import java.util.Scanner;

/**
 * Created by NoClay on 2016/12/27.
 */
public class Main {
    public static void main(String []args){
        float a, b, c;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            a = scanner.nextFloat();
            b = scanner.nextFloat();
            c = scanner.nextFloat();
            float flag = b * b - 4 * a * c;
            if (Math.abs(flag) < 10e-6){
                //b ^ 2 - 4ac = 0
                float x = (-b /(2 * a));
                System.out.println("The root is:" + String.format("%.2f", x) + ".");
            }else if (flag < 0){
                //b ^ 2 - 4ac < 0
                System.out.println("The equation has no real roots.");
            }else{
                //b ^ 2 - 4ac > 0
                float x1, x2;
                x1 = (float) ((-b + Math.sqrt(flag)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(flag)) / (2 * a));
                System.out.println("The roots are " +
                        String.format("%.2f", x1)
                        + " and "+
                        String.format("%.2f", x2)
                        + ".");
            }
        }
    }
}
