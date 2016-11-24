package DataResolve;

import java.io.*;

/**
 * Created by NoClay on 2016/10/31.
 */
public class DataResolve {

    private File file;
    private FileOutputStream out;
    public DataResolve() {
        file = new File("D://data1.txt");
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void toToast(String content){
        System.out.println(content);
    }

    public String doData(String data){
        int start = 0;
        int end = 0;
        do {
            start = data.indexOf("DC BA");
            end = data.indexOf("DC BA", start + 1);
            if(out != null && start != -1 && end != -1){
                String string = data.substring(start, end);
                try {
                    out.write((string + "\n").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(end != -1){
                data = data.substring(end);
            }
        }while(end > 0);
        return data;
    }
    public static void main(String[] args) {
        DataResolve dataResolve = new DataResolve();
        File file = new File("D://10分钟原始测量数据.txt");
        if(file.exists() && file.isFile()){
            toToast("文件成功打开！");
            /**
             * 尝试读取文件内部流数据
             */
            try {
                FileInputStream in = new FileInputStream(file);
                if(in != null){
                    byte []bytes = new byte[10];
                    int len = 0;
                    long sum = 0;
                    String data = "";
                    do {
                        try {
                            len = in.read(bytes);
                            data = data + new String(bytes);
                            data = dataResolve.doData(data);
                            if(len > 0){
                                sum += len;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }while(len > 0);
                    toToast(sum + "");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            System.exit(1);
        }
    }
}