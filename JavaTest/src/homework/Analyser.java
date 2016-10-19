package homework;

import java.util.Scanner;

/**
 * Created by 82661 on 2016/10/18.
 */
public class Analyser {
    private String src;
    private int letterNumber;
    private int spaceNumber;
    private int numNumber;
    private int otherNumber;

    public Analyser(String src) {
        this.src = src;
    }

    public void doSomething(){
        for (char a : src.toCharArray()) {
            if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')){
                letterNumber++;
            }else if(a == ' '){
                spaceNumber++;
            }else if(a >= '0' && a <= '9'){
                numNumber++;
            }else{
                otherNumber++;
            }
        }
    }

    public void show(){
        System.out.println("字母的个数:" + letterNumber
                + "\n空格的个数:" + spaceNumber
                + "\n数字的个数:" + numNumber
                + "\n其他字符的个数:" + otherNumber
        );
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Analyser analyser = new Analyser(scanner.nextLine());
        analyser.doSomething();
        analyser.show();
    }
}