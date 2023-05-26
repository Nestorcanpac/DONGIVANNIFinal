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

public class Postres extends JFrame {

    public Postres() {
        setSize(750, 400);
        setVisible(true);
        setTitle("Postre");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        Font fuentePrincipal = new Font("Arial", Font.ITALIC, 19);
        JPanel panel = new JPanel();
        setContentPane(panel);

        MyRadioButton tiramisu = new MyRadioButton("TIRAMISÚ", 80, 50, 190, 50);
        tiramisu.setFont(fuentePrincipal);
        MyRadioButton flan = new MyRadioButton("FLAN", 80, 100, 150, 50);
        flan.setFont(fuentePrincipal);
        MyRadioButton coulant = new MyRadioButton("COULANT", 80, 150, 130, 50);
        coulant.setFont(fuentePrincipal);
        MyRadioButton natillas = new MyRadioButton("NATILLAS", 80, 200, 200, 50);
        natillas.setFont(fuentePrincipal);
        MyRadioButton helado = new MyRadioButton("HELADO", 80, 250, 150, 50);
        helado.setFont(fuentePrincipal);
        ButtonGroup group = new ButtonGroup();
        group.add(tiramisu);
        group.add(flan);
        group.add(coulant);
        group.add(natillas);
        group.add(helado);

        MyImageLabel imaTiramisu = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/Tiramisú.jpeg", 450, 60, 200, 200);
        imaTiramisu.setVisible(false);
        MyImageLabel imaFlan = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/flan-de-vainilla.jpg", 450, 60, 200, 200);
        imaFlan.setVisible(false);
        MyImageLabel imaCoulant = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/coulant.jpg", 450, 60, 200, 200);
        imaCoulant.setVisible(false);
        MyImageLabel imaNatillas = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/naty.jpg", 450, 60, 200, 200);
        imaNatillas.setVisible(false);
        MyImageLabel imaHelado = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/gelats.jpg", 450, 60, 200, 200);
        imaHelado.setVisible(false);

        String s1 = "Precio:";
        MyLabel precioPostre = new MyLabel(s1, 450, 260, 150, 50);
        Font fuentePrecio = new Font("Arial", Font.BOLD, 20);
        precioPostre.setFont(fuentePrecio);
        MyLabel escoge = new MyLabel("Escoge una", 480, 80, 120, 100);
        MyLabel opcion = new MyLabel("opción", 500, 130, 80, 50);
        opcion.setFont(fuentePrecio);
        escoge.setFont(fuentePrecio);
        MyButton añadir = new MyButton("SELECCIONA", 290, 300, 120, 50);

        tiramisu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPostre.setText(s1);
                imaTiramisu.setVisible(true);
                imaFlan.setVisible(false);
                imaCoulant.setVisible(false);
                imaNatillas.setVisible(false);
                imaHelado.setVisible(false);
                precioPostre.setText(precioPostre.getText() + " 4.45€");
            }
        });
        flan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPostre.setText(s1);
                imaTiramisu.setVisible(false);
                imaFlan.setVisible(true);
                imaCoulant.setVisible(false);
                imaNatillas.setVisible(false);
                imaHelado.setVisible(false);
                precioPostre.setText(precioPostre.getText() + " 3.70€");
            }
        });
        coulant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPostre.setText(s1);
                imaTiramisu.setVisible(false);
                imaFlan.setVisible(false);
                imaCoulant.setVisible(true);
                imaNatillas.setVisible(false);
                imaHelado.setVisible(false);
                precioPostre.setText(precioPostre.getText() + " 5.40€");
            }
        });
        natillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPostre.setText(s1);
                imaTiramisu.setVisible(false);
                imaFlan.setVisible(false);
                imaCoulant.setVisible(false);
                imaNatillas.setVisible(true);
                imaHelado.setVisible(false);
                precioPostre.setText(precioPostre.getText() + " 4.10€");
            }
        });
        helado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPostre.setText(s1);
                imaTiramisu.setVisible(false);
                imaFlan.setVisible(false);
                imaCoulant.setVisible(false);
                imaNatillas.setVisible(true);
                imaHelado.setVisible(false);
                precioPostre.setText(precioPostre.getText() + " 2.00€");
            }
        });

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File fileFactura = new File("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/Factura.txt");
                File filePrecio = new File("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/precios.txt");
                FileWriter escribeFactura = null;
                FileWriter escribePrecio = null;

                try {
                    escribePrecio = new FileWriter(filePrecio);
                    escribeFactura = new FileWriter(fileFactura);
                    if (tiramisu.isSelected()) {
                        escribeFactura.write("1 Tiramisú......... 4.45€");
                        escribePrecio.write("4.45");
                    }
                    if (flan.isSelected()) {
                        escribeFactura.write("1 Flan......... 3.70€");
                        escribePrecio.write("3.70");
                    }
                    if (coulant.isSelected()) {
                        escribeFactura.write("1 Coulant......... 5.40€");
                        escribePrecio.write("5.40");
                    }
                    if (natillas.isSelected()) {
                        escribeFactura.write("1 Natillas......... 4.10€");
                        escribePrecio.write("4.10");
                    }
                    if (helado.isSelected()) {
                        escribeFactura.write("1 Helado......... 2.00€");
                        escribePrecio.write("2.00");
                    }

                    escribeFactura.close();
                    escribePrecio.close();
                } catch (IOException exception) {
                    System.out.println(exception.getMessage());
                }

                dispose();
            }
        });
        panel.setLayout(null);
        panel.add(tiramisu);
        panel.add(flan);
        panel.add(coulant);
        panel.add(natillas);
        panel.add(helado);
        panel.add(imaTiramisu);
        panel.add(imaFlan);
        panel.add(imaCoulant);
        panel.add(imaNatillas);
        panel.add(imaHelado);
        panel.add(escoge);
        panel.add(opcion);
        panel.add(precioPostre);
        panel.add(añadir);

    }

}

