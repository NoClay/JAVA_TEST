package DoSomething;


import java.io.*;
import java.util.Scanner;


/**
 * Created by NoClay on 2016/12/24.
 */
public class ReplaceSpaceWithNewLine {

    public static void toToast(String content){
        System.out.println(content);
    }
    public static void main(String []args) throws IOException {
        toToast("请输入要进行替换的文件（将空格替换为换行）：");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        File srcFile = new File(path);
        if (srcFile.exists() && srcFile.isFile()){
            File destFile = new File(srcFile.getParentFile().getAbsolutePath()
            + srcFile.getName().replace(".", "_替换空格."));
            if (destFile.exists() && destFile.isFile()){
                destFile.delete();
            }
            destFile.createNewFile();
            toToast("文件打开，开始替换");
            try {
                FileInputStream inputStream = new FileInputStream(srcFile);
                FileOutputStream outputStream = new FileOutputStream(destFile);
                byte[] bytes = new byte[1024];
                while (inputStream.read(bytes) != -1){
                    //读取文件
                    String data = new String(bytes);
                    outputStream.write(replaceSpaceWithNewLine(data).getBytes());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            toToast("打开失败");
        }
    }

    private static String replaceSpaceWithNewLine(String data) {
        if (data == null){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch != ' '){
                if (flag == 1){
                    builder.append(" ");
                }else if (flag > 1){
                    builder.append("\n");
                }
                flag = 0;
                builder.append(ch);
            }else{
                flag ++;
            }
        }
       return builder.toString();
    }
}
