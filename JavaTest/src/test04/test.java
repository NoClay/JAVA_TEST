package test04;

/**
 * Created by NoClay on 2016/10/31.
 */
public class test {

    public static void toToast(String content){
        System.out.println(content);
    }
    public static void main(String[] args) {
//        double m = 3.92;
//        toToast((int)(m) + "");
//        toToast((m - (int)(m)) + "");
        for (int i = 0; i < 16; i++) {
            toToast("       #1000 Seg" + i + " <= 8'b;");
        }
    }
}