package test08;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by NoClay on 2016/12/20.
 */
class ChineseCharacters {
    public StringBuffer getChinesecharacters(File file) {
        StringBuffer hanzi = new StringBuffer();
        try {
            FileReader inOne = new FileReader(file); //创建指向文件f的inOne 的对象
            BufferedReader inTwo = new BufferedReader(inOne);//创建指向文件inOne的inTwo的对象
            String s = null;
            int i = 0;
            while ((s = inTwo.readLine()) != null)                 //inTwo读取一行
            {
                StringTokenizer tokenizer = new StringTokenizer(s, " ,'\n' ");
                while (tokenizer.hasMoreTokens()) {
                    hanzi.append(tokenizer.nextToken());
                }
            }
        } catch (Exception e) {
        }
        return hanzi;
    }
}

public class StudyFrame extends Frame implements ItemListener, ActionListener, Runnable {
    ChineseCharacters chinese;
    Choice choice;
    Button getCharacters, voiceCharacters;
    Label showCharacters;
    StringBuffer trainedChinese = null;
    Clip clip = null;
    Thread voiceThread;
    int k = 0;
    Panel pCenter;
    CardLayout mycard;
    TextArea textHelp;
    MenuBar menubar;
    Menu menu;
    MenuItem help;

    public StudyFrame() {
        chinese = new ChineseCharacters();
        choice = new Choice();
        choice.add("training1.txt");
        choice.add("training2.txt");
        choice.add("training3.txt");
        showCharacters = new Label("", Label.CENTER);
        showCharacters.setFont(new Font("宋体", Font.BOLD, 72));
        showCharacters.setBackground(Color.green);
        getCharacters = new Button("下一个汉字");
        voiceCharacters = new Button("发音");
        voiceThread = new Thread(this);
        choice.addItemListener(this);
        voiceCharacters.addActionListener(this);
        getCharacters.addActionListener(this);
        Panel pNorth = new Panel();
        pNorth.add(new Label("选择一个汉字字符组成的文件"));
        pNorth.add(choice);
        add(pNorth, BorderLayout.NORTH);
        Panel pSouth = new Panel();
        pSouth.add(getCharacters);
        pSouth.add(voiceCharacters);
        add(pSouth, BorderLayout.SOUTH);
        pCenter = new Panel();
        mycard = new CardLayout();
        pCenter.setLayout(mycard);
        textHelp = new TextArea();
        pCenter.add("hanzi", showCharacters);
        pCenter.add("help", textHelp);
        add(pCenter, BorderLayout.CENTER);
        menubar = new MenuBar();
        menu = new Menu("帮助");
        help = new MenuItem("关于学汉字");
        help.addActionListener(this);
        menu.add(help);
        menubar.add(menu);
        setMenuBar(menubar);
        setSize(350, 220);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        validate();
    }

    public void itemStateChanged(ItemEvent e) {
        String fileName = choice.getSelectedItem();
        File file = new File(fileName);
        trainedChinese = chinese.getChinesecharacters(file);
        k = 0;
        mycard.show(pCenter, "hanzi");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getCharacters) {
            if (trainedChinese != null) {
                char c = trainedChinese.charAt(k);
                k++;
                if (k >= trainedChinese.length())
                    k = 0;
                showCharacters.setText("" + c);
            } else {
                showCharacters.setText("请选择一个汉字字符文件");
            }
        }
        if (e.getSource() == voiceCharacters) {
            if (!(voiceThread.isAlive())) {
                voiceThread = new Thread(this);
            }
            try {
                voiceThread.start();
            } catch (Exception exp) {
            }
        }
        if (e.getSource() == help) {
            mycard.show(pCenter, "help");
            try {
                File helpFile = new File("help.txt");
                FileReader inOne = new FileReader(helpFile);  //创建指向文件helpFile的inOne 的对象
                BufferedReader inTwo = new BufferedReader(inOne); //创建指向文件inOne的inTwo 的对象
                String s = null;
                while ((s = inTwo.readLine()) != null) {
                    textHelp.append(s + "\n");
                }
                inOne.close();
                inTwo.close();
            } catch (IOException exp) {
            }
        }
    }

    public void run() {
        voiceCharacters.setEnabled(false);
        try {
            if (clip != null) {
                clip.close();
            }
            clip = AudioSystem.getClip();
            File voiceFile = new File(showCharacters.getText().trim() + ".wav");
            clip.open(AudioSystem.getAudioInputStream(voiceFile));
        } catch (Exception exp) {
        }
        clip.start();
        voiceCharacters.setEnabled(true);
    }

    public static void main(String[] args) {
        new StudyFrame();
    }
}

