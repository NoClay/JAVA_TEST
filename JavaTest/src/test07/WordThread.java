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
                this.sleep(1000);//调用sleep方法使得线程中断6000豪秒
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
    WordThread giveWord;//用WordThread声明一个giveWord对象
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
        button = new Button("开始");
        inputText = new TextField(3);
        scoreText = new TextField(5);
        scoreText.setEditable(false);
        giveWord = new WordThread(wordLabel);//创建giveWord，将wordLabel传递给WordThread构造方法的参数
        button.addActionListener(this);
        inputText.addActionListener(this);
        add(button, BorderLayout.NORTH);
        add(wordLabel, BorderLayout.CENTER);
        Panel southP = new Panel();
        southP.add(new Label("输入标签所显示的汉字后回车:"));
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
            if (!giveWord.isAlive())     //giveWord调用方法isAlive()
            {
                giveWord = new WordThread(wordLabel);
            }
            try {
                giveWord.start();//giveWord调用方法start()
            } catch (Exception exe) {
            }
        } else if (e.getSource() == inputText) {
            if (inputText.getText().equals(wordLabel.getText())) {
                score++;
            }
            scoreText.setText("得分:" + score);
            inputText.setText(null);
        }
    }
}

