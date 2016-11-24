package homework;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by NoClay on 2016/11/24.
 */
public class CalCulatorFrame extends JFrame implements ActionListener {
    JTextField num1, num2;//����һ�������ı���
    JButton doBt;//����һ����ť�������
    JLabel result;
    String[] string = {"+", "-", "*", "/"};
    CheckboxGroup cbGroup = new CheckboxGroup();//������ѡ��

    public CalCulatorFrame() throws HeadlessException {
        super("���׼�����");
        Container container = getContentPane();//����м�㵽�Ӵ����
        container.setLayout(new FlowLayout());//���ֹ�����
        num1 = new JTextField("", 10);//10��
        num1.setHorizontalAlignment(JTextField.RIGHT);//�����ı��������Ҷ���
        num2 = new JTextField("", 10);//10��
        num2.setHorizontalAlignment(JTextField.RIGHT);
        result = new JLabel("���");
        result.setBackground(Color.blue);
        result.setSize(30, 40);
        doBt = new JButton("ȷ��");
        JPanel signal = new JPanel(new GridLayout(2, 2));
        Checkbox[] radio = new Checkbox[string.length];
        for (int i = 0; i < string.length; i++) {
            radio[i] = new Checkbox(string[i], cbGroup, false);
            signal.add(radio[i]);
        }
        container.add(num1);
        container.add(signal);
        container.add(num2);
        container.add(new JLabel("="));
        container.add(result);
        container.add(doBt);//��Ӱ�ť���м��
        doBt.addActionListener(this);
        setSize(500, 200);//���ô�С
        setVisible(true);//����Ϊ�ɼ�
    }

    public static void main(String[] args) {
        new CalCulatorFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(num1.getText());
        int a = Integer.parseInt(num1.getText());
        int b = Integer.parseInt(num2.getText());
        switch (cbGroup.getSelectedCheckbox().getLabel()){
            case "+":{
                result.setText((a + b) + "");break;
            }
            case "-":{
                result.setText((a - b) + "");break;
            }
            case "*":{
                result.setText((a * b) + "");break;
            }
            case "/":{
                result.setText((a / b) + "");break;
            }
        }
    }
}
