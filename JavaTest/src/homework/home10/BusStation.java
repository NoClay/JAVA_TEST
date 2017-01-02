package homework.home10;

import java.util.Random;

/**
 * Created by NoClay on 2016/12/22.
 */
public class BusStation extends Thread{
    Random random;

    public BusStation() {
        random = new Random();
    }

    @Override
    public void run() {
        while(true){
            System.out.println("车辆"
                    + random.nextInt(9)
                    + random.nextInt(9)
                    + random.nextInt(9)
                    + random.nextInt(9)
                    + random.nextInt(9)
                    + "通过收费站");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String []args){
        new BusStation().start();
    }
}
