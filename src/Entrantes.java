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
//Imports Necesarios

public class Entrantes extends JFrame {
    public Entrantes(){//Constructor
        setSize(750,400);//Tamaño de ventana
        setVisible(true);//La ventana es visible
        setTitle("Entrantes");//Titulo de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Comando para cuando cierres la ventana
        setResizable(false);//No se puede redimensionar
        setLocationRelativeTo(null);//Posicion de la ventana al ejecutar
        Font fuentePrincipal= new Font("Arial",Font.ITALIC,19);//Fuente Principal
        JPanel panel= new JPanel();//Asignacion del panel principal
        setContentPane(panel);
        setIconImage(new ImageIcon("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Logo.jpg").getImage());//Imagen de icono de la ventana

        //Creacion de los radio Button de los platos y el Button Group
        MyRadioButton bravas= new MyRadioButton("BRAVAS",80,50,100,50);
        bravas.setFont(fuentePrincipal);
        MyRadioButton calamares= new MyRadioButton("CALAMARES",80,100,150,50);
        calamares.setFont(fuentePrincipal);
        MyRadioButton sepia= new MyRadioButton("SEPIA", 80,150,100,50);
        sepia.setFont(fuentePrincipal);
        MyRadioButton tablaJamon= new MyRadioButton("TABLA DE JAMÓN",80,200,200,50);
        tablaJamon.setFont(fuentePrincipal);
        MyRadioButton panTumaka= new MyRadioButton("PAN TUMACA",80,250,150,50);
        panTumaka.setFont(fuentePrincipal);
        ButtonGroup group= new ButtonGroup();
        group.add(bravas);
        group.add(calamares);
        group.add(tablaJamon);
        group.add(panTumaka);
        group.add(sepia);

        //Creación de las imagenes
        MyImageLabel imaBravas= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/ENTRANTES/Bravas.jpg",450,60,200,200);
        imaBravas.setVisible(false);
        MyImageLabel imaCalamares= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/ENTRANTES/calamares.jpg",450,60,200,200);
        imaCalamares.setVisible(false);
        MyImageLabel imaSepia = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/ENTRANTES/sepia-a-la-plancha.jpg",450,60,200,200);
        imaSepia.setVisible(false);
        MyImageLabel imaJamon= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/ENTRANTES/Tabla_de_Jamon.png",450,60,200,200);
        imaJamon.setVisible(false);
        MyImageLabel imaPanTumaca= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/ENTRANTES/pan-tumaca.jpg",450,60,200,200);
        imaPanTumaca.setVisible(false);

        String s1="Precio:";
        MyLabel precioEntrante= new MyLabel(s1,450,260,150,50);
        Font fuentePrecio= new Font("Arial",Font.BOLD,20);
        precioEntrante.setFont(fuentePrecio);
        MyLabel escoge= new MyLabel("Escoge una",480,80,120,100);
        MyLabel opcion= new MyLabel("opción",500,130,80,50);
        opcion.setFont(fuentePrecio);
        escoge.setFont(fuentePrecio);

        MyButton añadir= new MyButton("SELECCIONA",290,300,120,50);


        bravas.addActionListener(new ActionListener() {//Accion de boton comida
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Se hace visible la foto de la comida seleccionada y las otras se hacen invisibles
                precioEntrante.setText(s1);
                imaBravas.setVisible(true);
                imaPanTumaca.setVisible(false);
                imaJamon.setVisible(false);
                imaSepia.setVisible(false);
                imaCalamares.setVisible(false);
                precioEntrante.setText(precioEntrante.getText()+" 4.75€");
            }

        });
        calamares.addActionListener(new ActionListener() {//Accion de boton comida
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Se hace visible la foto de la comida seleccionada y las otras se hacen invisibles
                precioEntrante.setText(s1);
                imaBravas.setVisible(false);
                imaPanTumaca.setVisible(false);
                imaJamon.setVisible(false);
                imaSepia.setVisible(false);
                imaCalamares.setVisible(true);
                precioEntrante.setText(precioEntrante.getText()+" 6.80€");
            }
        });
        sepia.addActionListener(new ActionListener() {//Accion de boton comida
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Se hace visible la foto de la comida seleccionada y las otras se hacen invisibles
                precioEntrante.setText(s1);
                imaBravas.setVisible(false);
                imaPanTumaca.setVisible(false);
                imaJamon.setVisible(false);
                imaSepia.setVisible(true);
                imaCalamares.setVisible(false);
                precioEntrante.setText(precioEntrante.getText()+" 11.50€");
            }
        });
        tablaJamon.addActionListener(new ActionListener() {//Accion de boton comida
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Se hace visible la foto de la comida seleccionada y las otras se hacen invisibles
                precioEntrante.setText(s1);
                imaBravas.setVisible(false);
                imaPanTumaca.setVisible(false);
                imaJamon.setVisible(true);
                imaSepia.setVisible(false);
                imaCalamares.setVisible(false);
                precioEntrante.setText(precioEntrante.getText()+" 14.00€");
            }
        });
        panTumaka.addActionListener(new ActionListener() {//Accion de boton comida
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Se hace visible la foto de la comida seleccionada y las otras se hacen invisibles
                precioEntrante.setText(s1);
                imaBravas.setVisible(false);
                imaPanTumaca.setVisible(true);
                imaJamon.setVisible(false);
                imaSepia.setVisible(false);
                imaCalamares.setVisible(false);
                precioEntrante.setText(precioEntrante.getText()+" 4.50€");
            }
        });

        añadir.addActionListener(new ActionListener() {//Accion de boton Seleccionar
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Creacion de Files
                File fileFactura= new File("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/Factura.txt");
                File filePrecio= new File("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/precios.txt");
                FileWriter escribeFactura=null;
                FileWriter escribePrecio= null;

                try {
                    escribePrecio= new FileWriter(filePrecio);
                    escribeFactura= new FileWriter(fileFactura);
                    if(bravas.isSelected()){//Escritura del texto y el precio en los ficheros
                        escribeFactura.write("1 Bravas......... 4.75€");
                        escribePrecio.write("4.75");
                    }
                    if(calamares.isSelected()){//Escritura del texto y el precio en los ficheros
                        escribeFactura.write("1 Calamares......... 6.80€");
                        escribePrecio.write("6.80");
                    }
                    if(sepia.isSelected()){//Escritura del texto y el precio en los ficheros
                        escribeFactura.write("1 Sepia......... 11.50€");
                        escribePrecio.write("11.50");
                    }
                    if(tablaJamon.isSelected()){//Escritura del texto y el precio en los ficheros
                        escribeFactura.write("1 Tabla de jamón......... 14.00€");
                        escribePrecio.write("14.00");
                    }
                    if(panTumaka.isSelected()){//Escritura del texto y el precio en los ficheros
                        escribeFactura.write("1 Pan Tumaca......... 4.50€");
                        escribePrecio.write("4.50");
                    }

                    escribeFactura.close();
                    escribePrecio.close();
                }
                catch(IOException exception){//Excepcion Ficheros
                    System.out.println(exception.getMessage());
                }

                dispose();
            }
        });
        //Adds de los paneles
        panel.setLayout(null);
        panel.add(bravas);
        panel.add(calamares);
        panel.add(sepia);
        panel.add(tablaJamon);
        panel.add(panTumaka);
        panel.add(imaBravas);
        panel.add(imaCalamares);
        panel.add(imaSepia);
        panel.add(imaJamon);
        panel.add(imaPanTumaca);
        panel.add(precioEntrante);
        panel.add(añadir);
        panel.add(escoge);
        panel.add(opcion);

    }
}

