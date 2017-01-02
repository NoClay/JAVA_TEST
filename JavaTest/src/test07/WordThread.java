package test07;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by NoClay on 2016/12/15.
 */
public class WordThread extends Thread {
    char word;
    int k = 19968;
    Label com;

    WordThread(Label com) {
        this.com = com;
    }

    public void run() {
        k = 19968;
        while (true) {
            word = (char) k;
            com.setText("" + word);
            try {
                this.sleep(1000);//����sleep����ʹ���߳��ж�6000����
            } catch (InterruptedException e) {
            }
            k++;
            if (k >= 29968) k = 19968;
        }
    }
    public static void main(String []args){
        new ThreadFrame();
    }
}

class ThreadFrame extends Frame implements ActionListener {
    Label wordLabel;
    Button button;
    TextField inputText, scoreText;
    WordThread giveWord;//��WordThread����һ��giveWord����
    int score = 0;
    int time = 6000;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    ThreadFrame() {
        wordLabel = new Label(" ", Label.CENTER);
        wordLabel.setFont(new Font("", Font.BOLD, 72));
        button = new Button("��ʼ");
        inputText = new TextField(3);
        scoreText = new TextField(5);
        scoreText.setEditable(false);
        giveWord = new WordThread(wordLabel);//����giveWord����wordLabel���ݸ�WordThread���췽���Ĳ���
        button.addActionListener(this);
        inputText.addActionListener(this);
        add(button, BorderLayout.NORTH);
        add(wordLabel, BorderLayout.CENTER);
        Panel southP = new Panel();
        southP.add(new Label("�����ǩ����ʾ�ĺ��ֺ�س�:"));
        southP.add(inputText);
        southP.add(scoreText);
        add(southP, BorderLayout.SOUTH);
        setBounds(100, 100, 350, 180);
        setVisible(true);
        validate();
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  System.exit(0);
                              }
                          }
        );
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (!giveWord.isAlive())     //giveWord���÷���isAlive()
            {
                giveWord = new WordThread(wordLabel);
            }
            try {
                giveWord.start();//giveWord���÷���start()
            } catch (Exception exe) {
            }
        } else if (e.getSource() == inputText) {
            if (inputText.getText().equals(wordLabel.getText())) {
                score++;
            }
            scoreText.setText("�÷�:" + score);
            inputText.setText(null);
        }
    }
}

