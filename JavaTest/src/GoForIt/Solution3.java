package GoForIt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by NoClay on 2016/11/11.
 */
public class Solution3 {
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count ++;
        }
        return count;
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     */
    public double Power(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }else if (exponent  > 0){
            double result = base;
            for (int i = 1; i < exponent; i++) {
                if (result > Double.MAX_VALUE){
                    return -1;
                }
                result *= base;
            }
            return result;
        }else{
            double result = 1 / base;
            for (int i = 1; i < -exponent; i++) {
                if (result < Double.MIN_VALUE){
                    return -1;
                }
                result /= base;
            }
            return result;
        }
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 
     */
    public void reOrderArray(int [] array) {
        int len = array.length;
        if (len == 0){
            return;
        }
        int pos1 = 0;
        int pos2 = 0;
        int [] a = new int[array.length];
        int [] b = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                b[pos2] = array[i];
                pos2 ++;
            }else{
                a[pos1] = array[i];
                pos1 ++;
            }
        }
        for (int i = 0; i < pos2; i++) {
            a[pos1] = b[i];
            pos1 ++;
        }
        array = a;
    }
    public static void main(String []args){
        int [] a = {1, 2, 3, 4, 5, 6, 7};
        new Solution3().reOrderArray(a);
    }
}
