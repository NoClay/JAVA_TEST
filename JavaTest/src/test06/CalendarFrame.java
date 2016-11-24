package test06;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NoClay on 2016/11/24.
 */
public class CalendarFrame extends Frame implements ActionListener {
    Label labelDay[] = new Label[42];
    Button titleName[] = new Button[7];
    String name[] = {"日", "一", "二", "三", "四", "五", "六"};
    Button nextMonth, previousMonth;
    int year = 2016, month = 11;
    CalendarBean calendar;
    Label showMessage = new Label("", Label.CENTER);

    public CalendarFrame() {
        Panel pCenter = new Panel();
        pCenter.setLayout(new GridLayout(7, 7)); //将pCenter的布局设置为7行7列的GridLayout 布局。
        for (int i = 0; i < 7; i++) {
            titleName[i] = new Button(name[i]);
            pCenter.add(titleName[i]);
        }
        for (int i = 0; i < 42; i++) {
            labelDay[i] = new Label("", Label.CENTER);
            pCenter.add(labelDay[i]);
        }
        calendar = new CalendarBean();
        calendar.setYear(year);
        calendar.setMonth(month);
        String day[] = calendar.getCalendar();
        for (int i = 0; i < 42; i++) {
            labelDay[i].setText(day[i]);
        }
        nextMonth = new Button("下月");
        previousMonth = new Button("上月");
        nextMonth.addActionListener(this);
        previousMonth.addActionListener(this);
        Panel pNorth = new Panel(),
                pSouth = new Panel();
        pNorth.add(previousMonth);
        pNorth.add(nextMonth);
        pSouth.add(showMessage);
        showMessage.setText("日历：" + calendar.getYear() + "年" + calendar.getMonth() + "月");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(pCenter);
        //This is the window
        add(scrollPane, BorderLayout.CENTER);
        add(pNorth, BorderLayout.NORTH);
        add(pSouth, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextMonth) {
            month = month + 1;
            if (month > 12)
                month = 1;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for (int i = 0; i < 42; i++) {
                labelDay[i].setText(day[i]);
            }
        } else if (e.getSource() == previousMonth) {
            month = month - 1;
            if (month < 1)
                month = 12;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for (int i = 0; i < 42; i++) {
                labelDay[i].setText(day[i]);
            }
        }
        showMessage.setText("日历：" + calendar.getYear() + "年" + calendar.getMonth() + "月");
    }

    public static void main(String[] args) {
        CalendarFrame frame = new CalendarFrame();
        frame.setBounds(100, 100, 360, 300);
        frame.setVisible(true);
        frame.validate();
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
                                    public void windowClosing(java.awt.event.WindowEvent e) {
                                        System.exit(0);
                                    }
                                }
        );

    }
}