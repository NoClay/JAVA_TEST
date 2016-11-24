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
    JTextField num1, num2;//声明一个单行文本框
    JButton doBt;//声明一个按钮组件对象
    JLabel result;
    String[] string = {"+", "-", "*", "/"};
    CheckboxGroup cbGroup = new CheckboxGroup();//创建单选框

    public CalCulatorFrame() throws HeadlessException {
        super("简易计算器");
        Container container = getContentPane();//添加中间层到视窗组件
        container.setLayout(new FlowLayout());//布局管理器
        num1 = new JTextField("", 10);//10列
        num1.setHorizontalAlignment(JTextField.RIGHT);//设置文本框内容右对齐
        num2 = new JTextField("", 10);//10列
        num2.setHorizontalAlignment(JTextField.RIGHT);
        result = new JLabel("结果");
        result.setBackground(Color.blue);
        result.setSize(30, 40);
        doBt = new JButton("确定");
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
        container.add(doBt);//添加按钮到中间层
        doBt.addActionListener(this);
        setSize(500, 200);//设置大小
        setVisible(true);//设置为可见
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
