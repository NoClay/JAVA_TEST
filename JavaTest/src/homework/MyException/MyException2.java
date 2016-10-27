package homework.MyException;

/**
 * Created by NoClay on 2016/10/27.
 * 自定义非检查异常
 */
public class MyException2 extends RuntimeException{
    public MyException2() {
    }

    public MyException2(String message) {
        super(message);
    }
}
