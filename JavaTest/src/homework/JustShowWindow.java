package homework;

import javafx.scene.control.TextFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by NoClay on 2016/11/24.
 */
public class JustShowWindow extends JFrame implements ActionListener{
    private JPanel mainLayout;
    private JTextField textField;
    private JButton button;
    public JustShowWindow() throws HeadlessException {
        Container container = getContentPane();
        mainLayout = new JPanel(null);
        mainLayout.setSize(500, 500);
        textField = new JTextField();
        button = new JButton("产生随机数");
        textField.setText("这是一个文本框");
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("隶书",1,45));
        button.setForeground(Color.CYAN);
        textField.setBounds(0, 0, 500, 300);
        button.setBounds(0, 300, 500, 200);
        mainLayout.add(textField);
        mainLayout.add(button);
        button.addActionListener(this);
        container.add(mainLayout, BorderLayout.CENTER);
        this.setSize(500, 500);
        this.setVisible(true);
    }
    public static void main(String []args){
        JustShowWindow justShowWindow = new JustShowWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            textField.setText(new Random().nextInt(99999) + "");
        }
    }
}
