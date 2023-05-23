package ui;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    public MyLabel(String text, int x, int y, int w, int h) {
        super(text);
        setBounds(x, y, w, h);
        setVisible(true);
    }



}
