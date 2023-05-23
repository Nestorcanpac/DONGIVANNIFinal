package ui;

import javax.swing.*;
import java.awt.*;

public class MyImageLabel extends JLabel {

    public MyImageLabel(String filename, int x, int y, int w, int h) {
        ImageIcon logo = new ImageIcon(filename);
        Image logoImage = logo.getImage();
        Image logoEscalado = logoImage.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon logoFinal = new ImageIcon(logoEscalado);
        setIcon(logoFinal);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
