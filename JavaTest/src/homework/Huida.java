package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NoClay on 2016/11/24.
 */
class Huida//自定义组件
{  JFrame f;//声明一个视窗组件对象
    Container c;//声明一个中间层组件面板
    JTextField jtf1,jtf2,jtf3;//声明一个单行文本框
    JButton b,b1;//声明一个按钮组件对象
    JLabel text;
    public void creatInterface()
    {  // int m=0;
        f=new JFrame("计算器");//实例化顶层

        c=f.getContentPane();//添加中间层到视窗组件
        c.setLayout(new FlowLayout());//布局管理器

        jtf1=new JTextField("",10);//10列
        jtf1.setEditable(true);//设置文本框属性为可以编辑
        jtf1.setHorizontalAlignment(JTextField.RIGHT );//设置文本框内容右对齐
        jtf2=new JTextField("",10);//10列
        jtf2.setEditable(true);//设置文本框属性为可以编辑
        jtf2.setHorizontalAlignment(JTextField.RIGHT );

        text=new JLabel("");

        jtf1.addActionListener(
                new ActionListener()//匿名内部类
                {public void actionPerformed(ActionEvent e)
                {  for(int i=0;i<jtf1.getText().length();i++)
                {
                    char ch=jtf1.getText().charAt(i);//返回组成jtf1的每个字符
                    if(Character.isDigit(ch))
                    { jtf2.requestFocus(true);
                        text.setText("输入正确");
                    }

                    else
                    { jtf1.requestFocus(true);
                        text.setText("请输入数字");
                    }}
                }});
        jtf2.addActionListener(
                new ActionListener()//匿名内部类
                {public void actionPerformed(ActionEvent e)
                { for(int i=0;i<jtf2.getText().length();i++)
                {
                    char ch=jtf2.getText().charAt(i);//返回组成jtf2的每个字符
                    if(Character.isDigit(ch))
                    {  b.requestFocus(true);
                        text.setText("输入正确");}
                    else
                    { jtf2.requestFocus(true);
                        text.setText("请输入数字");
                    }}
                }});

        b=new JButton("确定");
        b1=new JButton("重置");
        b.addActionListener(
                new ActionListener()//匿名内部类
                {public void actionPerformed(ActionEvent e)
                {
                }
                });

        b1.addActionListener(
                new ActionListener()//匿名内部类
                {public void actionPerformed(ActionEvent e)
                { jtf1.setText("");
                    jtf2.setText("");
                    text.setText("");}
                });

        c.add(jtf1);//添加文本框到中间层

        c.add(jtf2);//添加文本框到中间层
        c.add(text);
        c.add(b);//添加按钮到中间层
        c.add(b1);//添加按钮到中间层

        c.setBackground(Color.blue);//设置背景颜色
        f.setSize(400,200);//设置大小
        f.setResizable(false);
        f.setVisible(true);//设置为可见
    }

    public static void main(String args[])
    {
        Huida m=new Huida();
        m.creatInterface();
    }
}
