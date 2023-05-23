package ui;

import javax.swing.*;
import java.awt.*;

public class MyRadioButton extends JRadioButton {
    public MyRadioButton(String text, int x, int i, int w, int h){
        setText(text);
        setBounds(x,i,w,h);
        setVisible(true);
    }
}
