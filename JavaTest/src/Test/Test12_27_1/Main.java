package Test.Test12_27_1;

import java.util.Scanner;

/**
 * Created by NoClay on 2016/12/27.
 */
public class Main {
    public static void main(String []args){
        float a, b, c;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextFloat();
        b = scanner.nextFloat();
        c = scanner.nextFloat();
        if (Math.abs(a) < 10e-6 || Math.abs(b) < 10e-6 || Math.abs(c) < 10e-6){
            System.out.println("It can not be created a triangle.");
        }
        if (a < 0 || b < 0 || c < 0){
            System.out.println("It can not be created a triangle.");
        }else if (a + b <= c || a + c <= b || b + c <= a){
            System.out.println("It can not be created a triangle.");
        }else{
            float p = (a + b + c) / 2;
            System.out.println("The area is: "
                    + String.format("%.3f", Math.sqrt(p * (p - a) * (p - b) * (p - c)))
                    + ".");
            System.out.println("The perimeter is "
                    + String.format("%.3f", (a + b + c)) + ".");
        }
    }
}
