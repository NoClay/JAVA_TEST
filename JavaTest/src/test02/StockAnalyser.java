package test02;

import java.util.Scanner;

/**
 * Created by 82661 on 2016/10/10.
 */
public class StockAnalyser {
    /**
     * 定义的变量
     */
    public static final int DEFAULT_DAYS = 10;
    private float [] dayArrays = new float[31];
    private int days = DEFAULT_DAYS;
    private float average;

    /**
     * 设置需要计算的天数
     * @param days
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * 输入收盘价
     */
    public void setDayArrays() {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < days; i ++){
            System.out.print("请输入第" + (i + 1) + "天的收盘价： " );
            dayArrays[i] = scanner.nextFloat();
        }
        getAverage();
    }

    /**
     * 计算平均值
     */
    public void getAverage(){
        float sum = 0;
        for (float every : dayArrays) {
            sum += every;
        }
        average = sum / days;
    }

    public void whoIsMore(){
        System.out.println("\n\n\n" + days + "天的收盘价均值为:" + average);
        for (int i = 0; i < days; i ++) {
            if(dayArrays[i] >= average){
                System.out.println("第" + (i + 1) + "天的收盘价： " + dayArrays[i]);
            }
        }
    }


    public static void main(String []args){
        StockAnalyser stock = new StockAnalyser();
        stock.setDayArrays();
        stock.whoIsMore();
    }
}
