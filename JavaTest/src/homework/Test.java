package homework;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by NoClay on 2016/10/27.
 */
public class Test {

    public static void toToast(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
//        Test test = new Test();
//        int i = test.get();
//        System.out.println("" + i);
        toToast("main 1");
        int n = 5;
        ma(n);
        toToast("main2");
    }

    private static void ma(int n) {
        try{
            toToast("ma1");
            mb(n);
            toToast("ma2");
        }catch (EOFException e){
            toToast("e1");
        }catch (IOException e){
            toToast("e2");
        }catch (SQLException e){
            toToast("e3");
        }catch (Exception e){
            toToast("e4");
        }finally {
            toToast("In Finally");
        }
    }

    private static void mb(int n) throws Exception{
        toToast("mb1");
        if(n == 1) throw new EOFException();
        if(n == 2) throw new FileNotFoundException();
        if (n == 3) {
            throw new SQLException();
        }
        if (n == 4) {
            throw new NullPointerException();
        }
        toToast("mb2");
    }

//    private int get() {
//        try{
//            return 1;
//        }finally {
//            return 2;
//        }
//    }
}