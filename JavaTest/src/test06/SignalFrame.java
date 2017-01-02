package test06;

import java.awt.*;
import java.awt.event.*;

import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import static com.sun.javafx.fxml.expression.Expression.add;

/**
 * Created by NoClay on 2016/11/22.
 */
public class SignalFrame extends Frame implements ItemListener{
    Choice choice;
    SignalCanvas signal = null;
    String itemRed = "���", itemYellow = "�Ƶ�", itemGreen = "�̵�", itemNull = "Ϩ�����е�";

    public SignalFrame() {
        choice = new Choice();          //����choice
        choice.add(itemRed);               //����choice���itemRed
        choice.add(itemYellow);              //����choice���itemYellow
        choice.add(itemGreen);                //����choice���itemGreen
        choice.add(itemNull);
        choice.addItemListener(this);  //����ǰ����ע��Ϊchoice��ItemEvent�¼�������
        add(choice, BorderLayout.NORTH);
        try {
//            Class cs = Class.forName("SignalCanvas");
//            signal = (SignalCanvas) cs.newInstance();
            signal = new SignalCanvas();
            add(signal, BorderLayout.CENTER);
        } catch (Exception e) {
            add(new Label("����û�б�дSignalCanvas��"), BorderLayout.CENTER);
        }
        this.setBounds(100, 100, 360, 300);
        setVisible(true);
        validate();
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  System.exit(0);
                              }
                          }
        );
    }

    public void itemStateChanged(ItemEvent e) {
        String item = (String) choice.getSelectedItem();  // choice���ر�ѡ�е���Ŀ
        int w = signal.getBounds().width;
        int h = signal.getBounds().height;
        int m = Math.min(w, h);
        signal.setRadius(m / 6);
        if (item.equals(itemRed)) {
            if (signal != null) {
                signal.setRed(1);
                signal.setYellow(0);
                signal.setGreen(0);
                signal.setPosition(w / 3, 0);
                signal.repaint();
            }
        } else if (item.equals(itemYellow)) {
            if (signal != null) {
                signal.setRed(0);
                signal.setYellow(1);
                signal.setGreen(0);
                signal.setPosition(w / 3, h / 3);
                signal.repaint();
            }
        } else if (item.equals(itemGreen)) {
            if (signal != null) {
                signal.setRed(0);
                signal.setYellow(0);
                signal.setGreen(1);
                signal.setPosition(w / 3, 2 * h / 3);
                signal.repaint();
            }
        } else if (item.equals(itemNull)){
            signal.setRed(0);
            signal.setYellow(0);
            signal.setGreen(0);
            signal.setPosition(0, 0);
            signal.repaint();
        }
    }

    public static void main(String[] args) {
        SignalFrame frame;
        frame = new SignalFrame();
        frame.setTitle("�źŵ�");
    }
}