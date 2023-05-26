import ui.MyButton;
import ui.MyImageLabel;
import ui.MyLabel;
import ui.MyRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlatoPrincipal extends JFrame {
    public PlatoPrincipal(){
        setSize(750,400);
        setVisible(true);
        setTitle("Plato Principal");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        Font fuentePrincipal= new Font("Arial",Font.ITALIC,19);
        JPanel panel= new JPanel();
        setContentPane(panel);

        MyRadioButton sopaCastellana= new MyRadioButton("SOPA CASTELLANA",80,50,190,50);
        sopaCastellana.setFont(fuentePrincipal);
        MyRadioButton macarrones= new MyRadioButton("MACARRONES",80,100,150,50);
        macarrones.setFont(fuentePrincipal);
        MyRadioButton spageti= new MyRadioButton("SPAGETTIS", 80,150,130,50);
        spageti.setFont(fuentePrincipal);
        MyRadioButton lasaña= new MyRadioButton("LASAÑA",80,200,200,50);
        lasaña.setFont(fuentePrincipal);
        MyRadioButton canelones= new MyRadioButton("CANELONES",80,250,150,50);
        canelones.setFont(fuentePrincipal);
        ButtonGroup group= new ButtonGroup();
        group.add(sopaCastellana);
        group.add(macarrones);
        group.add(lasaña);
        group.add(canelones);
        group.add(spageti);

        MyImageLabel imaSopa= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Platos_principales/sopa-castellana.jpg",450,60,200,200);
        imaSopa.setVisible(false);
        MyImageLabel imaLasaña= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Platos_principales/lassaaaaaaa.jpg",450,60,200,200);
        imaLasaña.setVisible(false);
        MyImageLabel imaMacarrones = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Platos_principales/macarrones.jpg",450,60,200,200);
        imaMacarrones.setVisible(false);
        MyImageLabel imaSpagueti= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Platos_principales/spageti.jpeg",450,60,200,200);
        imaSpagueti.setVisible(false);
        MyImageLabel imaCanelones= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Platos_principales/canelones.jpg",450,60,200,200);
        imaCanelones.setVisible(false);

        String s1="Precio:";
        MyLabel precioPlatoPrincipal= new MyLabel(s1,450,260,150,50);
        Font fuentePrecio= new Font("Arial",Font.BOLD,20);
        precioPlatoPrincipal.setFont(fuentePrecio);
        MyLabel escoge= new MyLabel("Escoge una",480,80,120,100);
        MyLabel opcion= new MyLabel("opción",500,130,80,50);
        opcion.setFont(fuentePrecio);
        escoge.setFont(fuentePrecio);

        MyButton añadir= new MyButton("SELECCIONA",290,300,120,50);

        sopaCastellana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPlatoPrincipal.setText(s1);
                imaCanelones.setVisible(false);
                imaMacarrones.setVisible(false);
                imaLasaña.setVisible(false);
                imaSpagueti.setVisible(false);
                imaSopa.setVisible(true);
                precioPlatoPrincipal.setText(precioPlatoPrincipal.getText()+" 11.19€");
            }
        });
        spageti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPlatoPrincipal.setText(s1);
                imaCanelones.setVisible(false);
                imaMacarrones.setVisible(false);
                imaLasaña.setVisible(false);
                imaSpagueti.setVisible(true);
                imaSopa.setVisible(false);
                precioPlatoPrincipal.setText(precioPlatoPrincipal.getText()+" 9.14€");
            }
        });
        canelones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPlatoPrincipal.setText(s1);
                imaCanelones.setVisible(true);
                imaMacarrones.setVisible(false);
                imaLasaña.setVisible(false);
                imaSpagueti.setVisible(false);
                imaSopa.setVisible(false);
                precioPlatoPrincipal.setText(precioPlatoPrincipal.getText()+" 12.00€");
            }
        });

        lasaña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPlatoPrincipal.setText(s1);
                imaCanelones.setVisible(false);
                imaMacarrones.setVisible(false);
                imaLasaña.setVisible(true);
                imaSpagueti.setVisible(false);
                imaSopa.setVisible(false);
                precioPlatoPrincipal.setText(precioPlatoPrincipal.getText()+" 8.33€");
            }
        });

        macarrones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPlatoPrincipal.setText(s1);
                imaCanelones.setVisible(false);
                imaMacarrones.setVisible(true);
                imaLasaña.setVisible(false);
                imaSpagueti.setVisible(false);
                imaSopa.setVisible(false);
                precioPlatoPrincipal.setText(precioPlatoPrincipal.getText()+" 7.45€");
            }
        });

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File fileFactura= new File("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/Factura.txt");
                File filePrecio= new File("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/precios.txt");
                FileWriter escribeFactura=null;
                FileWriter escribePrecio= null;

                try {
                    escribePrecio= new FileWriter(filePrecio);
                    escribeFactura= new FileWriter(fileFactura);
                    if(sopaCastellana.isSelected()){
                        escribeFactura.write("1 Sopa Castellana......... 11.19€");
                        escribePrecio.write("11.19");
                    }
                    if(spageti.isSelected()){
                        escribeFactura.write("1 Spaguettis......... 9.14€");
                        escribePrecio.write("9.14");
                    }
                    if(canelones.isSelected()){
                        escribeFactura.write("1 Canelones......... 12.00€");
                        escribePrecio.write("12.00");
                    }
                    if(lasaña.isSelected()){
                        escribeFactura.write("1 Lasaña......... 8.33€");
                        escribePrecio.write("8.33");
                    }
                    if(macarrones.isSelected()){
                        escribeFactura.write("1 Macarrones......... 7.45€");
                        escribePrecio.write("7.45");
                    }

                    escribeFactura.close();
                    escribePrecio.close();
                }
                catch(IOException exception){
                    System.out.println(exception.getMessage());
                }

                dispose();
            }
        });

        panel.setLayout(null);
        panel.add(sopaCastellana);
        panel.add(macarrones);
        panel.add(spageti);
        panel.add(lasaña);
        panel.add(canelones);
        panel.add(imaCanelones);
        panel.add(imaMacarrones);
        panel.add(imaLasaña);
        panel.add(imaSopa);
        panel.add(imaSpagueti);
        panel.add(añadir);
        panel.add(escoge);
        panel.add(opcion);
        panel.add(precioPlatoPrincipal);
    }

}
