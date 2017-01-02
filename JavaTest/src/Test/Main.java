package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by NoClay on 2016/12/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path;
        boolean isFlag = false;
        do {
            System.out.print("�������ļ�·�����ļ�����");
            path = scanner.next();
            File file = new File(path);
            if (file.exists() && file.isFile()){
                isFlag = true;
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte [] bytes = new byte[1024];
                    StringBuilder stringBuilder = new StringBuilder("");
                    while ((fileInputStream.read(bytes) != -1)){
                        stringBuilder.append(new String(bytes));
                    }
                    System.out.println(stringBuilder.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }while (!isFlag);
    }
}
//        int key = -1;
//        while (true) {
//
//            key = scanner.nextInt();
//
//            switch (key) {
//                case 0:
//                    System.out.println("һ�·�");
//                    break;
//                case 1:
//                    System.out.println("���·�");
//                    break;
//                case 2:
//                    System.out.println("���·�");
//                    break;
//                case 3:
//                    System.out.println("���·�");
//                    break;
//                case 4:
//                    System.out.println("���·�");
//                    break;
//                case 5:
//                    System.out.println("���·�");
//                    break;
//                case 6:
//                    System.out.println("���·�");
//                    break;
//                case 7:
//                    System.out.println("���·�");
//                    break;
//                case 8:
//                    System.out.println("���·�");
//                    break;
//                case 9:
//                    System.out.println("ʮ�·�");
//                    break;
//                case 10:
//                    System.out.println("ʮһ�·�");
//                    break;
//                case 11:
//                    System.out.println("ʮ���·�");
//                    break;
//            }
//
//        }