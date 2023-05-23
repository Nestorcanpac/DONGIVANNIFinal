package ui;

import javax.swing.*;

public class MyButton extends JButton {

    public MyButton(String texto,int x,int y,int w,int h){
        setText(texto);
        setBounds(x,y,w,h);

    }
}
