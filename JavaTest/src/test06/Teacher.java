package test06;

import java.util.Random;

/**
 * Created by NoClay on 2016/11/22.
 */
public class Teacher {
    int numberOne, numberTwo;
    String operator = "";
    boolean right;

    public int giveNumberOne(int n) {
        numberOne = (int) (Math.random() * n) + 1;
        return numberOne;
    }

    public int giveNumberTwo(int n) {
        numberTwo = (int) (Math.random() * n) + 1;
        return numberTwo;
    }

    public String giveOperator() {
        int d = new Random().nextInt(100);
        switch (d / 25) {
            case 0:
                operator = "+";
                break;
            case 1:
                operator = "-";
                break;
            case 2:
                operator = "*";
                break;
            case 3:
                operator = "/";
                break;
        }
        return operator;
    }

    public boolean getRight(int answer) {
        switch (operator){
            case "+":{
                if (answer == numberOne + numberTwo){
                    return true;
                }
                break;
            }
            case "-":{
                if (answer == numberOne - numberTwo){
                    return true;
                }
                break;
            }
            case "*":{
                if (answer == numberOne * numberTwo){
                    return true;
                }
                break;
            }
            case "/":{
                if (answer == numberOne / numberTwo){
                    return true;
                }
                break;
            }
        }
        return false;
    }
}

