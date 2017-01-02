package Test;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by NoClay on 2016/12/16.
 */
public class Test01 {


    public double distance(double x,double y){
        if (x == 0){
            return Math.abs(y);
        }else if (y == 0){
            return Math.abs(x);
        }else{
            return Math.pow((x * x + y * y), 1.0 / 2);
        }
    }
    public double distance(double x,double y, double z){
        return Math.pow((x * x + y * y + z * z), 1.0 / 2);
    }

    public static void main(String args[]) {
        float score = 0;
        get_rank(score);
    }

    private static void get_rank(float score) {
        Scanner in = new Scanner(System.in);
        score = in.nextFloat();
        switch ((int)(score) / 10){
            case 10:System.out.println("excelent");break;
            case 9:System.out.println("excelent");break;
            case 8:System.out.println("fine");break;
            case 7:System.out.println("medium");break;
            case 6:System.out.println("pass");break;
            default:System.out.println("no pass");break;
        }
    }
}
