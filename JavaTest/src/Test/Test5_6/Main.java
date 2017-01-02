package Test.Test5_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by NoClay on 2016/12/22.
 */
public class Main {
    public static void main(String []args) throws IOException {
        File dest = new File("temp.txt");
        if (!dest.exists() || !dest.isFile()){
            dest.createNewFile();
        }
        File src = new File("Main.java");
        if (src.exists() && src.isFile()){
            FileInputStream in = new FileInputStream(src);
            FileOutputStream out = new FileOutputStream(dest);
            byte [] bytes = new byte[1024];
            while ((in.read(bytes) != -1)){
                out.write(bytes);
            }
        }
    }
}
