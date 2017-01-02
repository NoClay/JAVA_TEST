package test08;

import java.awt.*;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by NoClay on 2016/12/21.
 */
public class ReadZipFile {
    public static void main(String args[]) {
        Frame layout = new Frame();

        FileDialog openZipFile = new FileDialog(layout,
                "选择压缩包", FileDialog.LOAD);
        openZipFile.setVisible(true);
        String fileName = openZipFile.getFile();
        String filePath = openZipFile.getDirectory();
        File f = new File(filePath + fileName);
        if (f.exists()) {
            System.out.println("文件存在");
        }
        File dir = new File(filePath);
        byte b[] = new byte[100];
        dir.mkdir();
        try {
            ZipFile zipFile = new ZipFile(f);
            for (Enumeration entries = zipFile.entries(); entries.hasMoreElements();) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zipFile.getInputStream(entry);
                String outPath = zipEntryName;
                //判断路径是否存在,不存在则创建文件路径
                File file = new File(outPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if (new File(outPath).isDirectory()) {
                    continue;
                }
                //输出文件路径信息
                System.out.println(outPath);

                OutputStream out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
            }
        } catch (ZipException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

