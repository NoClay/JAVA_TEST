package test07;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by NoClay on 2016/12/15.
 */
public class MoveButton extends Frame implements Runnable, ActionListener {

    Thread first, second;//用Thread类声明first,second两个线程对象
    Button redButton, greenButton, startButton;
    int distance = 10;

    public MoveButton() throws HeadlessException {
        first = new Thread(this);//创建first线程，当前窗口做为该线程的目标对象
        second = new Thread(this); //创建first线程，当前窗口做为该线程的目标对象
        redButton = new Button();
        greenButton = new Button();
        redButton.setBackground(Color.red);
        greenButton.setBackground(Color.green);
        startButton = new Button("start");
        startButton.addActionListener(this);
        setLayout(null);
        add(redButton);
        redButton.setBounds(10, 60, 15, 15);
        add(greenButton);
        greenButton.setBounds(100, 60, 15, 15);
        add(startButton);
        startButton.setBounds(10, 100, 30, 30);
        setBounds(0, 0, 300, 200);
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
        try {
            first.start();
            second.start();
        } catch (Exception exp) {
        }
    }

    public void run() {
        while (true) {
            if (Thread.currentThread() == first) //判断当前占有CPU资源的线程是否是first
            {
                moveComponent(redButton);
                try {
                    Thread.sleep(20);
                } catch (Exception exp) {
                }
            }
            if (Thread.currentThread() == second) //判断当前占有CPU资源的线程是否是second
            {
                moveComponent(greenButton);
                try {
                    Thread.sleep(10);
                } catch (Exception exp) {
                }
            }
        }
    }

    public synchronized void moveComponent(Component b) {
        if (Thread.currentThread() == first) {
            while (distance > 100 && distance <= 200)
                try {
                    wait();
                } catch (Exception exp) {
                }
            distance = distance + 1;
            b.setLocation(distance, 60);
            if (distance >= 100) {
                b.setLocation(10, 60);
                notifyAll();
            }
        }
        if (Thread.currentThread() == second) {
            while (distance >= 10 && distance < 100)
                try {
                    wait();
                } catch (Exception exp) {
                }
            distance = distance + 1;
            b.setLocation(distance, 60);
            if (distance > 200) {
                distance = 10;
                b.setLocation(100, 60);
                notifyAll();
            }
        }
    }

    public static void main(String []args){
        new MoveButton();
    }
}
