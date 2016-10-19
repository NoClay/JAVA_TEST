package test02;

import java.util.Scanner;

/**
 * Created by 82661 on 2016/10/10.
 */
public class Analyser {
    private int length = 0;
    private int [] everyLetter = new int[26];

    /**
     * 输入字符串流，遇到空行结束
     */
    public void inputString(){
        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            line = scanner.nextLine();
            if(!line.isEmpty()){
                length += line.length();
                analyserLetter(line);
            }
        }while(!line.isEmpty());
    }

    /**
     * 分析每个字符串
     * @param line
     */
    private void analyserLetter(String line) {
        for (char one : line.toCharArray()) {
            int i = one - 'a';
            if(i >= 0 && i < 26){
                everyLetter[i]++;
            }
            i = one - 'A';
            if(i >= 0 && i < 26){
                everyLetter[i]++;
            }
        }
    }

    /**
     * 显示分析后的结果
     */
    public void showMessage(){
        System.out.println("\n\n\n已输入" + length + "个字符：");
        for (int i = 0; i < 26; i++) {
            System.out.println((char) (i + 'a') + "或" +
                    (char) (i + 'A') + "出现：" + everyLetter[i] + "次");
        }
    }

    public static void main(String []args){
//        System.out.println("可用执行器个数" + Runtime.getRuntime().availableProcessors());
//        Analyser analyser = new Analyser();
//        analyser.inputString();
//        analyser.showMessage();
        /**
         * 计算两个日期之间相隔的天数
         */

//        Date dateStart = new Date(1900, 6, 5);
//        Date dateEnd = new Date(2016, 6, 6);
//        System.out.println(dateStart.getTime());
//        System.out.println(dateEnd.getTime());
//
//        System.out.println((dateEnd.getTime() - dateStart.getTime()) / 1000 /60 /60 /24);
        final int MODE_SHIFT = 30;
        final int MODE_MASK  = 0x3 << MODE_SHIFT;

        System.out.println(Integer.toBinaryString(MODE_SHIFT) + "\n"
                + Integer.toBinaryString(MODE_MASK) + "\n" + MODE_MASK
                + "\n" + Integer.toBinaryString((int)(0x3 * Math.pow(2, 30)))
                + "\n" + Integer.toOctalString(0x3));
    }
}
