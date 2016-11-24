package GoForIt;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by NoClay on 2016/11/11.
 */
public class Solution2 {
    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */

    public int minNumberInRotateArray(int [] array) {
        //规定左边序列长度大于右边序列为左旋转
        if (array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int half = 0;
        while (left < right){
            half = (left + right) / 2;
            if (array[half] > array[left]){
                //左旋转
                left = half;
            }else if (array[half] < array[right]){
                right = half;
            }else{
                left ++;
            }
        }
        return array[left];
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int []data = new int[50];
        data[0] = 0;
        data[1] = 1;
        data[2] = 1;
        if (n < 3){
            return data[n];
        }
        for (int i = 3; i <= n; i++) {
            data[i] = data[i - 1] + data[i - 2];
        }
        return data[n];
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * f(n) = f(n-1) + f(n-2)
     * @param target
     */

    public int JumpFloor(int target) {
        int n = 3;
        int n_1 = 3;
        int n_2 = 2;
        if (target <= 0){
            return 0;
        }else if (target <= 3){
            return target;
        }else {
            for (int i = 4; i <= target; i++) {
                n = n_1 + n_2;
                n_2 = n_1;
                n_1 = n;
            }
            return n;
        }
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 对斐波那契数列求和
     * @param target
     */
    public int JumpFloorII(int target) {
        int n = 4;
        int n_1 = 2;
        int sum = 1;
        if (target <= 0){
            return 0;
        }else if (target <= 2){
            return target;
        }else {
            for (int i = 3; i <= target; i++) {
                n = n_1 + sum + 1;
                sum += n_1;
                n_1 = n;
            }
            return n;
        }
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 斐波那契数列的又一种抽象
     * @param target
     * @return
     */
    public int RectCover(int target) {
        int n = 3;
        int n_1 = 3;
        int n_2 = 2;
        if (target <= 0){
            return 0;
        }else if (target <= 3){
            return target;
        }else {
            for (int i = 4; i <= target; i++) {
                n = n_1 + n_2;
                n_2 = n_1;
                n_1 = n;
            }
            return n;
        }
    }
    public static void main(String []args){
        int [] a = {3, 4, 5, 1, 2};
        System.out.println(new Solution2().minNumberInRotateArray(a) + "");
        ;
    }
}
