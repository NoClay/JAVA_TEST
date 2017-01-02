package test07;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by NoClay on 2016/12/15.
 */
public class HaveThreadFrame extends Frame implements Runnable {
    Thread rotate;//��Thread������һ��rotate����
    Planet earth;
    double pointX[] = new double[360],
            pointY[] = new double[360];
    int width, height;
    int radius = 120;

    HaveThreadFrame() {
        rotate = new Thread(this);
        earth = new Planet();
        setBounds(0, 0, 360, 400);
        width = getBounds().width;
        height = getBounds().height;
        pointX[0] = 0;
        pointY[0] = -radius;
        double angle = 1 * Math.PI / 180;
        for (int i = 0; i < 359; i++) {
            pointX[i + 1] = pointX[i] * Math.cos(angle) - Math.sin(angle) * pointY[i];
            pointY[i + 1] = pointY[i] * Math.cos(angle) + pointX[i] * Math.sin(angle);
        }
        for (int i = 0; i < 360; i++) {
            pointX[i] = pointX[i] + width / 2;
            pointY[i] = pointY[i] + height / 2;
        }
        setLayout(null);
        setVisible(true);
        validate();
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  System.exit(0);
                              }
                          }
        );
        add(earth);
        earth.setLocation((int) pointX[0] - earth.getSize().width / 2,
                (int) pointY[0] - earth.getSize().height / 2);
        earth.start();
        rotate.start();//��rotate����start����
    }

    public void run() {
        int i = 0;
        while (true) {
            i = (i + 1) % 360;
            earth.setLocation((int) pointX[i] - earth.getSize().width / 2,
                    (int) pointY[i] - earth.getSize().height / 2);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(width / 2 - 15, height / 2 - 15, 30, 30);
    }
    public static void main(String []args){
        new HaveThreadFrame();
    }
}


class Mycanvas extends Canvas {
    int r;
    Color c;

    public void setColor(Color c) {
        this.c = c;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void paint(Graphics g) {
        g.setColor(c);
        g.fillOval(0, 0, 2 * r, 2 * r);
    }

    public int getR() {
        return r;
    }
}

class Planet extends Panel implements Runnable {
    Thread moon; //��Thread������һ��moon����
    Mycanvas yellowBall;
    Mycanvas greenBall;
    Thread Satellite;
    double pointX[] = new double[360],
            pointY[] = new double[360]; //������ʾ�������ϽǶ˵����������
    int w = 100, h = 100;
    int radius = 30;

    Planet() {
        setSize(w, h);
        setLayout(null);

        greenBall = new Mycanvas();
        greenBall.setColor(Color.GREEN);
        add(greenBall);
        greenBall.setSize(36, 36);
        greenBall.setR(18);
        Satellite = new Thread(this);


        yellowBall = new Mycanvas();
        yellowBall.setColor(Color.yellow);
        add(yellowBall);
        yellowBall.setSize(12, 12);
        yellowBall.setR(12 / 2);
        pointX[0] = 0;
        pointY[0] = -radius;
        double angle = 1 * Math.PI / 180;   //�̶�Ϊ1��
        for (int i = 0; i < 359; i++)        //����������и���Ԫ�ص�ֵ
        {
            pointX[i + 1] = pointX[i] * Math.cos(angle) - Math.sin(angle) * pointY[i];
            pointY[i + 1] = pointY[i] * Math.cos(angle) + pointX[i] * Math.sin(angle);
        }
        for (int i = 0; i < 360; i++) {
            pointX[i] = pointX[i] + w / 2;    //����ƽ��
            pointY[i] = pointY[i] + h / 2;
        }
        yellowBall.setLocation((int) pointX[0] - yellowBall.getR(),
                (int) pointY[0] - yellowBall.getR());
        moon = new Thread(this);//���� moon�̣߳���ǰ�����Ϊ���̵߳�Ŀ�����
    }

    public void start() {
        try {
            moon.start();
            Satellite.start();
        } catch (Exception exe) {
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(w / 2 - 9, h / 2 - 9, 18, 18);
    }

    public void run() {
        int i = 0;
        while (true) {
            i = (i + 1) % 360;
            yellowBall.setLocation((int) pointX[i] - yellowBall.getR(),
                    (int) pointY[i] - yellowBall.getR());
            try {
                Thread.sleep(10);// Thread������෽��sleepʹ���߳��ж�10����
            } catch (InterruptedException e) {
            }
        }
    }
}

