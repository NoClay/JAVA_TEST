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
                "ѡ��ѹ����", FileDialog.LOAD);
        openZipFile.setVisible(true);
        String fileName = openZipFile.getFile();
        String filePath = openZipFile.getDirectory();
        File f = new File(filePath + fileName);
        if (f.exists()) {
            System.out.println("�ļ�����");
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
                //�ж�·���Ƿ����,�������򴴽��ļ�·��
                File file = new File(outPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                //�ж��ļ�ȫ·���Ƿ�Ϊ�ļ���,����������Ѿ��ϴ�,����Ҫ��ѹ
                if (new File(outPath).isDirectory()) {
                    continue;
                }
                //����ļ�·����Ϣ
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

