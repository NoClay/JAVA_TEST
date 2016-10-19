package test03.demo1;

/**
 * Created by 82661 on 2016/10/18.
 */
public class IntSort {
    public String sort(int a, int b) {
        if (a > b)
            return a + "," + b;
        else
            return b + "," + a;
    }

    public String sort(int a, int b, int c) {
        int swap;
        if (a < b) {
            swap = a;
            a = b;
            b = swap;
        }
        if (a < c) {
            swap = a;
            a = c;
            c = swap;
        }
        if (b < c) {
            swap = b;
            b = c;
            c = swap;
        }
        return a + "," + b + "," + c;
    }

    public String sort(int arr[]) {
        String s = "";
        int swap;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
        for (int i = 0; i < arr.length; i++)
            s = s + arr[i] + ",";
        return s;
    }
}

