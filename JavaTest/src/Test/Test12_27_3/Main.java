package Test.Test12_27_3;


import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Created by NoClay on 2016/12/27.
 */
public class Main {
    public static void main(String []args){
        String str1, str2;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            str1 = scanner.next();
            str2 = scanner.next();


            if (str1.isEmpty() || str2.isEmpty()){
                System.out.println("No common prefix");
            }else{
                String common = getCommon(str1, str2);
                if (common.isEmpty()){
                    System.out.println("No common prefix");
                }else{
                    System.out.println("The common prefix is " + common);
                }
            }
        }
    }

    private static String getCommon(String str1, String str2) {
        String common = "";
        String src = (str1.length() > str2.length() ? str2 : str1);
        String dest = (str1.length() > str2.length() ? str1 : str2);
        for (int i = 0; i < src.length(); i++) {
            String temp = src.substring(0, i);
            if (dest.startsWith(temp)){
                common = temp;
            }else{
                break;
            }
        }
        return common;
    }
}
