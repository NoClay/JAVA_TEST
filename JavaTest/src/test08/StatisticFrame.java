package test08;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Vector;

/**
 * Created by NoClay on 2016/12/21.
 */
class WordStatistic {
    Vector allWorsd, noSameWord;

    WordStatistic() {
        allWorsd = new Vector();
        noSameWord = new Vector();
    }

    public void wordStatistic(File file) {
        try {
            RandomAccessFile inOne = new RandomAccessFile(file, "rw");       //����ָ���ļ�file��inOne �Ķ���
            RandomAccessFile inTwo = new RandomAccessFile(file, "rw");       //����ָ���ļ�file��inTwo �Ķ���
            long wordStarPostion = 0, wordEndPostion = 0;
            long length = inOne.length();
            int flag = 1;
            int c = -1;
            for (int k = 0; k <= length; k++) {
                c = inOne.read();       // inOne����read()����
                boolean boo = (c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a');
                if (boo) {
                    if (flag == 1) {
                        wordStarPostion = inOne.getFilePointer() - 1;
                        flag = 0;
                    }
                } else {
                    if (flag == 0) {
                        if (c == -1)
                            wordEndPostion = inOne.getFilePointer();
                        else
                            wordEndPostion = inOne.getFilePointer() - 1;
                        inTwo.seek(wordStarPostion);// inTwo����seek��������дλ���ƶ���wordStarPostion
                        byte cc[] = new byte[(int) wordEndPostion - (int) wordStarPostion];
                        inTwo.readFully(cc);// inTwo����readFully(byte a)��������a����cc
                        String word = new String(cc);
                        allWorsd.add(word);
                        if (!(noSameWord.contains(word)))
                            noSameWord.add(word);

                    }
                    flag = 1;
                }
            }
            inOne.close();
            inTwo.close();
        } catch (Exception e) {
        }
    }

    public Vector getAllWorsd() {
        return allWorsd;
    }

    public Vector getNoSameWord() {
        return noSameWord;
    }
}
public class StatisticFrame extends Frame implements ActionListener {
    WordStatistic statistic;
    TextArea showMessage;
    Button openFile;
    FileDialog openFileDialog;
    Vector allWord, noSameWord;

    public StatisticFrame() {
        statistic = new WordStatistic();
        showMessage = new TextArea();
        openFile = new Button("Open File");
        openFile.addActionListener(this);
        add(openFile, BorderLayout.NORTH);
        add(showMessage, BorderLayout.CENTER);
        openFileDialog = new FileDialog(this, "���ļ�����", FileDialog.LOAD);
        allWord = new Vector();
        noSameWord = new Vector();
        setSize(350, 300);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        noSameWord.clear();
        allWord.clear();
        showMessage.setText(null);
        openFileDialog.setVisible(true);
        String fileName = openFileDialog.getDirectory() + openFileDialog.getFile();
        if (fileName != null) {
            statistic.wordStatistic(new File(fileName));
            allWord = statistic.getAllWorsd();
            noSameWord = statistic.getNoSameWord();
            showMessage.append("\n" + fileName + "����" + allWord.size() + "��Ӣ�ĵ���");
            showMessage.append("\n������" + noSameWord.size() + "��������ͬӢ�ĵ���");
            showMessage.append("\n��ʹ��Ƶ�����У�\n");
            int count[] = new int[noSameWord.size()];
            for (int i = 0; i < noSameWord.size(); i++) {
                String s1 = (String) noSameWord.elementAt(i);
                for (int j = 0; j < allWord.size(); j++) {
                    String s2 = (String) allWord.elementAt(j);
                    if (s1.equals(s2))
                        count[i]++;
                }
            }
            for (int m = 0; m < noSameWord.size(); m++) {
                for (int n = m + 1; n < noSameWord.size(); n++) {
                    if (count[n] > count[m]) {
                        String temp = (String) noSameWord.elementAt(m);
                        noSameWord.setElementAt((String) noSameWord.elementAt(n), m);
                        noSameWord.setElementAt(temp, n);
                        int t = count[m];
                        count[m] = count[n];
                        count[n] = t;
                    }
                }
            }
            for (int m = 0; m < noSameWord.size(); m++) {
                showMessage.append("\n" + (String) noSameWord.elementAt(m) +
                        ":" + count[m] + "/" + allWord.size() +
                        "=" + (1.0 * count[m]) / allWord.size());
            }
        }
    }
    public static void main(String []args){
        new StatisticFrame();
    }
}

