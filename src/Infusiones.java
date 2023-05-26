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

public class Infusiones extends JFrame {
    public Infusiones(){
        setSize(750,400);
        setVisible(true);
        setTitle("Infusiones y cafés");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        Font fuentePrincipal= new Font("Arial",Font.ITALIC,19);
        JPanel panel= new JPanel();
        setContentPane(panel);

        String s1="Precio:";
        MyLabel precioInfusión= new MyLabel(s1,450,260,150,50);
        Font fuentePrecio= new Font("Arial",Font.BOLD,20);
        precioInfusión.setFont(fuentePrecio);
        MyLabel escoge= new MyLabel("Escoge una",480,80,120,100);
        MyLabel opcion= new MyLabel("opción",500,130,80,50);
        opcion.setFont(fuentePrecio);
        escoge.setFont(fuentePrecio);
        MyButton añadir= new MyButton("SELECCIONA",290,300,120,50);

        MyRadioButton cortado= new MyRadioButton("CORTADO",80,50,190,50);
        cortado.setFont(fuentePrincipal);
        MyRadioButton poleo= new MyRadioButton("POLEO",80,100,150,50);
        poleo.setFont(fuentePrincipal);
        MyRadioButton bombon= new MyRadioButton("BOMBON", 80,150,130,50);
        bombon.setFont(fuentePrincipal);
        MyRadioButton manzanilla= new MyRadioButton("MANZANILLA",80,200,200,50);
        manzanilla.setFont(fuentePrincipal);
        MyRadioButton americano= new MyRadioButton("AMERICANO",80,250,150,50);
        americano.setFont(fuentePrincipal);
        ButtonGroup group= new ButtonGroup();
        group.add(cortado);
        group.add(poleo);
        group.add(bombon);
        group.add(manzanilla);
        group.add(americano);

        MyImageLabel imaCortado= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Infusiones/cortado.jpeg",450,60,200,200);
        imaCortado.setVisible(false);
        MyImageLabel imaPoleo= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Infusiones/poleo.jpg",450,60,200,200);
        imaPoleo.setVisible(false);
        MyImageLabel imaBombon = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Infusiones/cafe-bombon-2.jpg",450,60,200,200);
        imaBombon.setVisible(false);
        MyImageLabel imaManzanilla= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Infusiones/Manzana2.png",450,60,200,200);
        imaManzanilla.setVisible(false);
        MyImageLabel imaAmericano= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Infusiones/Americano.jpg",450,60,200,200);
        imaAmericano.setVisible(false);

        cortado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioInfusión.setText(s1);
                imaCortado.setVisible(true);
                imaPoleo.setVisible(false);
                imaBombon.setVisible(false);
                imaManzanilla.setVisible(false);
                imaAmericano.setVisible(false);
                precioInfusión.setText(precioInfusión.getText()+" 1.20€");
            }
        });

        poleo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioInfusión.setText(s1);
                imaCortado.setVisible(false);
                imaPoleo.setVisible(true);
                imaBombon.setVisible(false);
                imaManzanilla.setVisible(false);
                imaAmericano.setVisible(false);
                precioInfusión.setText(precioInfusión.getText()+" 3.00€");
            }
        });
        bombon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioInfusión.setText(s1);
                imaCortado.setVisible(false);
                imaPoleo.setVisible(false);
                imaBombon.setVisible(true);
                imaManzanilla.setVisible(false);
                imaAmericano.setVisible(false);
                precioInfusión.setText(precioInfusión.getText()+" 2.10€");
            }
        });
        manzanilla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioInfusión.setText(s1);
                imaCortado.setVisible(false);
                imaPoleo.setVisible(false);
                imaBombon.setVisible(false);
                imaManzanilla.setVisible(true);
                imaAmericano.setVisible(false);
                precioInfusión.setText(precioInfusión.getText()+" 2.50€");
            }
        });
        americano.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioInfusión.setText(s1);
                imaCortado.setVisible(false);
                imaPoleo.setVisible(false);
                imaBombon.setVisible(false);
                imaManzanilla.setVisible(false);
                imaAmericano.setVisible(true);
                precioInfusión.setText(precioInfusión.getText()+" 2.60€");
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
                    if(cortado.isSelected()){
                        escribeFactura.write("1 Cortado......... 1.20€");
                        escribePrecio.write("1.20");
                    }
                    if(poleo.isSelected()){
                        escribeFactura.write("1 Poleo......... 3.00€");
                        escribePrecio.write("3.00");
                    }
                    if(bombon.isSelected()){
                        escribeFactura.write("1 Bombon......... 2.10€");
                        escribePrecio.write("2.10");
                    }
                    if(manzanilla.isSelected()){
                        escribeFactura.write("1 Manzanilla......... 2.50€");
                        escribePrecio.write("2.50");
                    }
                    if(americano.isSelected()){
                        escribeFactura.write("1 Americano......... 2.60€");
                        escribePrecio.write("2.60");
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
        panel.add(cortado);
        panel.add(poleo);
        panel.add(manzanilla);
        panel.add(bombon);
        panel.add(americano);
        panel.add(precioInfusión);

        panel.add(imaAmericano);
        panel.add(imaBombon);
        panel.add(imaCortado);
        panel.add(imaPoleo);
        panel.add(imaManzanilla);
        panel.add(opcion);
        panel.add(añadir);
        panel.add(escoge);
    }

}
