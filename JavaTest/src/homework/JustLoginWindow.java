package homework;

import sun.swing.ImageIconUIResource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NoClay on 2016/11/24.
 */
public class JustLoginWindow extends JFrame implements ActionListener{
    private JTextField user;
    private JPasswordField password;
    private JButton login, quit;
    private int width, height;
    private boolean isLogin;


    public JustLoginWindow(String title) throws HeadlessException {
        super(title);
        GraphicsConfiguration configuration = getGraphicsConfiguration();
        width = configuration.getBounds().width;
        height = configuration.getBounds().height;
        this.setSize(width, height);
        this.setVisible(true);
        ImageIcon back = new ImageIcon(this.getClass().getResource("/back.jpg"));
        JLabel backLabel = new JLabel(back);
        backLabel.setBounds(0, 0, width, height);

        JLayeredPane jLayeredPane = getLayeredPane();
        jLayeredPane.add(backLabel);

        password = new JPasswordField();
        login = new JButton("登录");
        quit = new JButton("退出");
        //设置布局1
        int x = 300;
        int y = 40;
        Font font = new Font("微软", 1, 23);
        JPanel p1 = new JPanel(null);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/user.png"));
        Image image = icon.getImage().getScaledInstance(y, y, Image.SCALE_DEFAULT);
        icon.setImage(image);
        JLabel userIcon = new JLabel(icon, JLabel.CENTER);
        user = new JTextField();
        userIcon.setBounds(0, 0, y, y);
        user.setBounds(y, 0, x - y, y);
        user.setFont(font);
        p1.add(userIcon);
        p1.add(user);
        p1.setAlignmentX(Container.CENTER_ALIGNMENT);
        p1.setBounds(900, 300, x, y);
        jLayeredPane.add(p1);

        JPanel p2 = new JPanel(null);
        ImageIcon iconUIResource = new ImageIcon(this.getClass().getResource("/pass.png"));
        iconUIResource.setImage(iconUIResource.getImage().getScaledInstance(
                y, y, Image.SCALE_DEFAULT
        ));
        JLabel passIcon = new JLabel(iconUIResource);
        passIcon.setBounds(0, 0, y, y);
        password = new JPasswordField();
        password.setBounds(y, 0, x - y, y);
        password.setFont(new Font("english", 1, 23));
        p2.add(passIcon);
        p2.add(password);
        p2.setBounds(900, 370, x, y);
        jLayeredPane.add(p2);


        JPanel p3 = new JPanel(new GridLayout(1, 1));
        login = new JButton("登录");
        quit = new JButton("退出");
        login.setFont(font);
        quit.setFont(font);
        p3.add(login);
        p3.add(quit);
        p3.setBounds(900, 430, x, y);
        jLayeredPane.add(p3);

        login.addActionListener(this);
        quit.addActionListener(this);
    }


    public static void main(String[] args) {
        JustLoginWindow justLoginWindow = new JustLoginWindow("登录窗口");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            String string1 = user.getText();
            String string2 = password.getText();
            System.out.println(string2);
            if (string1.equals("NoClay") && string2.equals("abcdef")){
                System.out.println("登录成功");
                isLogin = true;
            }
        }
        if (e.getSource() == quit){
            if (!isLogin){
                System.out.println("你还没有登录");
            }else{
                System.out.println("成功退出");
            }
            isLogin = false;
        }
    }
}
