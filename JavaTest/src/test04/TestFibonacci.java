package test04;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by NoClay on 2016/10/27.
 */
public class TestFibonacci {
    private int[] array ;

    public TestFibonacci(int length) {
        array = new int[length];

        if(length >= 2) {
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i < length; i++) {
                array[i] = array[i - 2] + array[i - 1];
            }
        }else if(length == 1){
            array[0] = 0;
        }

    }

    public void show() {
        for (int i :
                array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        TestFibonacci testFibonacci = new TestFibonacci(10);
        testFibonacci.show();
    }
}
