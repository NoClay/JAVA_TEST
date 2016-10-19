package homework;

import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

import java.util.Arrays;

/**
 * Created by 82661 on 2016/10/18.
 */
public class CombineArrays {

    public int[] combine1(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        Arrays.sort(result);
        print(result);
        return result;
    }

    public int[] combine2(int[] a, int[] b){
        int[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        Arrays.sort(result);
        print(result);
        return result;
    }

    public void print(int[] c){
        for (int i: c) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] a = {1, 7, 9, 11, 13, 15, 17, 19};
        int [] b = {2, 4, 6, 8, 10};
        CombineArrays combine = new CombineArrays();
        combine.combine2(a, b);

    }
}