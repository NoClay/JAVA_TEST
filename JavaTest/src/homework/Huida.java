package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NoClay on 2016/11/24.
 */
class Huida//�Զ������
{  JFrame f;//����һ���Ӵ��������
    Container c;//����һ���м��������
    JTextField jtf1,jtf2,jtf3;//����һ�������ı���
    JButton b,b1;//����һ����ť�������
    JLabel text;
    public void creatInterface()
    {  // int m=0;
        f=new JFrame("������");//ʵ��������

        c=f.getContentPane();//����м�㵽�Ӵ����
        c.setLayout(new FlowLayout());//���ֹ�����

        jtf1=new JTextField("",10);//10��
        jtf1.setEditable(true);//�����ı�������Ϊ���Ա༭
        jtf1.setHorizontalAlignment(JTextField.RIGHT );//�����ı��������Ҷ���
        jtf2=new JTextField("",10);//10��
        jtf2.setEditable(true);//�����ı�������Ϊ���Ա༭
        jtf2.setHorizontalAlignment(JTextField.RIGHT );

        text=new JLabel("");

        jtf1.addActionListener(
                new ActionListener()//�����ڲ���
                {public void actionPerformed(ActionEvent e)
                {  for(int i=0;i<jtf1.getText().length();i++)
                {
                    char ch=jtf1.getText().charAt(i);//�������jtf1��ÿ���ַ�
                    if(Character.isDigit(ch))
                    { jtf2.requestFocus(true);
                        text.setText("������ȷ");
                    }

                    else
                    { jtf1.requestFocus(true);
                        text.setText("����������");
                    }}
                }});
        jtf2.addActionListener(
                new ActionListener()//�����ڲ���
                {public void actionPerformed(ActionEvent e)
                { for(int i=0;i<jtf2.getText().length();i++)
                {
                    char ch=jtf2.getText().charAt(i);//�������jtf2��ÿ���ַ�
                    if(Character.isDigit(ch))
                    {  b.requestFocus(true);
                        text.setText("������ȷ");}
                    else
                    { jtf2.requestFocus(true);
                        text.setText("����������");
                    }}
                }});

        b=new JButton("ȷ��");
        b1=new JButton("����");
        b.addActionListener(
                new ActionListener()//�����ڲ���
                {public void actionPerformed(ActionEvent e)
                {
                }
                });

        b1.addActionListener(
                new ActionListener()//�����ڲ���
                {public void actionPerformed(ActionEvent e)
                { jtf1.setText("");
                    jtf2.setText("");
                    text.setText("");}
                });

        c.add(jtf1);//����ı����м��

        c.add(jtf2);//����ı����м��
        c.add(text);
        c.add(b);//��Ӱ�ť���м��
        c.add(b1);//��Ӱ�ť���м��

        c.setBackground(Color.blue);//���ñ�����ɫ
        f.setSize(400,200);//���ô�С
        f.setResizable(false);
        f.setVisible(true);//����Ϊ�ɼ�
    }

    public static void main(String args[])
    {
        Huida m=new Huida();
        m.creatInterface();
    }
}
