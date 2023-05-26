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

public class SegundoPlato extends JFrame {
    public SegundoPlato(){
        setSize(750,400);
        setVisible(true);
        setTitle("Segundo Plato");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        Font fuentePrincipal= new Font("Arial",Font.ITALIC,19);
        JPanel panel= new JPanel();
        setContentPane(panel);

        MyRadioButton pizza= new MyRadioButton("PIZZA DE LA CASA",80,50,190,50);
        pizza.setFont(fuentePrincipal);
        MyRadioButton entrecot= new MyRadioButton("ENTRECOT",80,100,150,50);
        entrecot.setFont(fuentePrincipal);
        MyRadioButton bacalao= new MyRadioButton("BACALAO", 80,150,130,50);
        bacalao.setFont(fuentePrincipal);
        MyRadioButton rape= new MyRadioButton("RAPE",80,200,200,50);
        rape.setFont(fuentePrincipal);
        MyRadioButton costillas= new MyRadioButton("COSTILLAS",80,250,150,50);
        costillas.setFont(fuentePrincipal);
        ButtonGroup group= new ButtonGroup();
        group.add(pizza);
        group.add(entrecot);
        group.add(bacalao);
        group.add(rape);
        group.add(costillas);

        MyImageLabel imaPizza= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Segundos_Platos/pizza.jpg",450,60,200,200);
        imaPizza.setVisible(false);
        MyImageLabel imaEntrecot= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Segundos_Platos/entrecot.jpg",450,60,200,200);
        imaEntrecot.setVisible(false);
        MyImageLabel imaBacalao = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Segundos_Platos/Bacalao.jpeg",450,60,200,200);
        imaBacalao.setVisible(false);
        MyImageLabel imaRape= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Segundos_Platos/rape.jpg",450,60,200,200);
        imaRape.setVisible(false);
        MyImageLabel imaCostillas= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Segundos_Platos/costillas.jpg",450,60,200,200);
        imaCostillas.setVisible(false);

        String s1="Precio:";
        MyLabel precioSegundoPlato= new MyLabel(s1,450,260,150,50);
        Font fuentePrecio= new Font("Arial",Font.BOLD,20);
        precioSegundoPlato.setFont(fuentePrecio);
        MyLabel escoge= new MyLabel("Escoge una",480,80,120,100);
        MyLabel opcion= new MyLabel("opción",500,130,80,50);
        opcion.setFont(fuentePrecio);
        escoge.setFont(fuentePrecio);
        MyButton añadir= new MyButton("SELECCIONA",290,300,120,50);

        pizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioSegundoPlato.setText(s1);
                imaPizza.setVisible(true);
                imaEntrecot.setVisible(false);
                imaBacalao.setVisible(false);
                imaRape.setVisible(false);
                imaCostillas.setVisible(false);
                precioSegundoPlato.setText(precioSegundoPlato.getText()+" 9.50€");
            }
        });
        entrecot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioSegundoPlato.setText(s1);
                imaPizza.setVisible(false);
                imaEntrecot.setVisible(true);
                imaBacalao.setVisible(false);
                imaRape.setVisible(false);
                imaCostillas.setVisible(false);
                precioSegundoPlato.setText(precioSegundoPlato.getText()+" 13.40€");
            }
        });
        bacalao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioSegundoPlato.setText(s1);
                imaPizza.setVisible(false);
                imaEntrecot.setVisible(false);
                imaBacalao.setVisible(true);
                imaRape.setVisible(false);
                imaCostillas.setVisible(false);
                precioSegundoPlato.setText(precioSegundoPlato.getText()+" 11.50€");
            }
        });
        rape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioSegundoPlato.setText(s1);
                imaPizza.setVisible(false);
                imaEntrecot.setVisible(false);
                imaBacalao.setVisible(false);
                imaRape.setVisible(true);
                imaCostillas.setVisible(false);
                precioSegundoPlato.setText(precioSegundoPlato.getText()+" 14.95€");
            }
        });
        costillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioSegundoPlato.setText(s1);
                imaPizza.setVisible(false);
                imaEntrecot.setVisible(false);
                imaBacalao.setVisible(false);
                imaRape.setVisible(false);
                imaCostillas.setVisible(true);
                precioSegundoPlato.setText(precioSegundoPlato.getText()+" 10.00€");
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
                    if(pizza.isSelected()){
                        escribeFactura.write("1 Pizza de la Casa......... 9.50€");
                        escribePrecio.write("9.50");
                    }
                    if(entrecot.isSelected()){
                        escribeFactura.write("1 Entrecot......... 13.40€");
                        escribePrecio.write("13.40");
                    }
                    if(bacalao.isSelected()){
                        escribeFactura.write("1 Bacalao......... 11.50€");
                        escribePrecio.write("11.50");
                    }
                    if(rape.isSelected()){
                        escribeFactura.write("1 Rape......... 14.95€");
                        escribePrecio.write("14.95");
                    }
                    if(costillas.isSelected()){
                        escribeFactura.write("1 Costillas......... 10.00€");
                        escribePrecio.write("10.00");
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
        panel.add(pizza);
        panel.add(entrecot);
        panel.add(bacalao);
        panel.add(rape);
        panel.add(costillas);
        panel.add(imaPizza);
        panel.add(imaEntrecot);
        panel.add(imaBacalao);
        panel.add(imaRape);
        panel.add(imaCostillas);
        panel.add(escoge);
        panel.add(opcion);
        panel.add(precioSegundoPlato);
        panel.add(añadir);
    }

}
