package homework.home10;

/**
 * Created by NoClay on 2016/12/22.
 */
public class TestThread {
    static class ThreadDemo extends Thread{
        int count = 0;
        int max = 0;

        public ThreadDemo(String name, int por, int max) {
            super(name);
            this.max = max;
            setPriority(por);
        }

        @Override
        public void run() {
            while (count < max){
                count ++;
                System.out.println(this.getName() + "正在运行");
            }
        }
    }
    public static void main(String []args){
        ThreadDemo thread1 = new ThreadDemo("线程1", 10, 50);
        ThreadDemo thread2 = new ThreadDemo("线程2", 5, 100);
        thread1.start();
        thread2.start();
    }
}
