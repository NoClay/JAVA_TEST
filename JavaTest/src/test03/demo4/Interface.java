package test03.demo4;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Interface extends Applet implements MouseListener, MouseMotionListener{

    int x1, x2, y1, y2;



    @Override
    public void init() {
        super.init();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }


    @Override
    public void mouseMoved(MouseEvent e) {
    }
}