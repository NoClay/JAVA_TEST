package homework.MyException;

/**
 * Created by NoClay on 2016/10/27.
 * 自定义受检查异常
 */
public class MyException1 extends Exception{
    public MyException1() {
    }

    public MyException1(String message) {
        super(message);
    }
}
