import ui.MyButton;
import ui.MyImageLabel;
import ui.MyLabel;
import ui.MyRadioButton;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

class Entrantes extends JFrame {

    public Entrantes(){
        setSize(750,400);
        setVisible(true);
        setTitle("Entrantes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        Font fuentePrincipal= new Font("Arial",Font.ITALIC,19);
        JPanel panel= new JPanel();
        setContentPane(panel);

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


        bravas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioEntrante.setText(s1);
                imaBravas.setVisible(true);
                imaPanTumaca.setVisible(false);
                imaJamon.setVisible(false);
                imaSepia.setVisible(false);
                imaCalamares.setVisible(false);
                precioEntrante.setText(precioEntrante.getText()+" 4.75€");
            }

        });
        calamares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioEntrante.setText(s1);
                imaBravas.setVisible(false);
                imaPanTumaca.setVisible(false);
                imaJamon.setVisible(false);
                imaSepia.setVisible(false);
                imaCalamares.setVisible(true);
                precioEntrante.setText(precioEntrante.getText()+" 6.80€");
            }
        });
        sepia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioEntrante.setText(s1);
                imaBravas.setVisible(false);
                imaPanTumaca.setVisible(false);
                imaJamon.setVisible(false);
                imaSepia.setVisible(true);
                imaCalamares.setVisible(false);
                precioEntrante.setText(precioEntrante.getText()+" 11.50€");
            }
        });
        tablaJamon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioEntrante.setText(s1);
                imaBravas.setVisible(false);
                imaPanTumaca.setVisible(false);
                imaJamon.setVisible(true);
                imaSepia.setVisible(false);
                imaCalamares.setVisible(false);
                precioEntrante.setText(precioEntrante.getText()+" 14.00€");
            }
        });
        panTumaka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioEntrante.setText(s1);
                imaBravas.setVisible(false);
                imaPanTumaca.setVisible(true);
                imaJamon.setVisible(false);
                imaSepia.setVisible(false);
                imaCalamares.setVisible(false);
                precioEntrante.setText(precioEntrante.getText()+" 4.50€");
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
                    if(bravas.isSelected()){
                        escribeFactura.write("1 Bravas......... 4.75€");
                        escribePrecio.write("4.75");
                    }
                    if(calamares.isSelected()){
                        escribeFactura.write("1 Calamares......... 6.80€");
                        escribePrecio.write("6.80");
                    }
                    if(sepia.isSelected()){
                        escribeFactura.write("1 Sepia......... 11.50€");
                        escribePrecio.write("11.50");
                    }
                    if(tablaJamon.isSelected()){
                        escribeFactura.write("1 Tabla de jamón......... 14.00€");
                        escribePrecio.write("14.00");
                    }
                    if(panTumaka.isSelected()){
                        escribeFactura.write("1 Pan Tumaca......... 4.50€");
                        escribePrecio.write("4.50");
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

class platoPrincipal extends JFrame{

    public platoPrincipal(){
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

class SegundoPlato extends JFrame{
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
class Postres extends JFrame{
    public Postres(){
        setSize(750,400);
        setVisible(true);
        setTitle("Postre");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        Font fuentePrincipal= new Font("Arial",Font.ITALIC,19);
        JPanel panel= new JPanel();
        setContentPane(panel);

        MyRadioButton tiramisu= new MyRadioButton("TIRAMISÚ",80,50,190,50);
        tiramisu.setFont(fuentePrincipal);
        MyRadioButton flan= new MyRadioButton("FLAN",80,100,150,50);
        flan.setFont(fuentePrincipal);
        MyRadioButton coulant= new MyRadioButton("COULANT", 80,150,130,50);
        coulant.setFont(fuentePrincipal);
        MyRadioButton natillas= new MyRadioButton("NATILLAS",80,200,200,50);
        natillas.setFont(fuentePrincipal);
        MyRadioButton helado= new MyRadioButton("HELADO",80,250,150,50);
        helado.setFont(fuentePrincipal);
        ButtonGroup group= new ButtonGroup();
        group.add(tiramisu);
        group.add(flan);
        group.add(coulant);
        group.add(natillas);
        group.add(helado);

        MyImageLabel imaTiramisu= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/Tiramisú.jpeg",450,60,200,200);
        imaTiramisu.setVisible(false);
        MyImageLabel imaFlan= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/flan-de-vainilla.jpg",450,60,200,200);
        imaFlan.setVisible(false);
        MyImageLabel imaCoulant = new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/coulant.jpg",450,60,200,200);
        imaCoulant.setVisible(false);
        MyImageLabel imaNatillas= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/naty.jpg",450,60,200,200);
        imaNatillas.setVisible(false);
        MyImageLabel imaHelado= new MyImageLabel("/home/nescanpac/IdeaProjects/DONGIVANNI/Fotos_Dongiovanni/Postres/gelats.jpg",450,60,200,200);
        imaHelado.setVisible(false);

        String s1="Precio:";
        MyLabel precioPostre= new MyLabel(s1,450,260,150,50);
        Font fuentePrecio= new Font("Arial",Font.BOLD,20);
        precioPostre.setFont(fuentePrecio);
        MyLabel escoge= new MyLabel("Escoge una",480,80,120,100);
        MyLabel opcion= new MyLabel("opción",500,130,80,50);
        opcion.setFont(fuentePrecio);
        escoge.setFont(fuentePrecio);
        MyButton añadir= new MyButton("SELECCIONA",290,300,120,50);

        tiramisu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPostre.setText(s1);
                imaTiramisu.setVisible(true);
                imaFlan.setVisible(false);
                imaCoulant.setVisible(false);
                imaNatillas.setVisible(false);
                imaHelado.setVisible(false);
                precioPostre.setText(precioPostre.getText()+" 4.45€");
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
                precioPostre.setText(precioPostre.getText()+" 3.70€");
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
                precioPostre.setText(precioPostre.getText()+" 5.40€");
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
                precioPostre.setText(precioPostre.getText()+" 4.10€");
            }
        });
        helado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                precioPostre.setText(s1);
                imaTiramisu.setVisible(false);
                imaFlan.setVisible(false);
                imaCoulant.setVisible(false);
                imaNatillas.setVisible(false);
                imaHelado.setVisible(true);
                precioPostre.setText(precioPostre.getText()+" 2.00€");
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
                    if(tiramisu.isSelected()){
                        escribeFactura.write("1 Tiramisú......... 4.45€");
                        escribePrecio.write("4.45");
                    }
                    if(flan.isSelected()){
                        escribeFactura.write("1 Flan......... 3.70€");
                        escribePrecio.write("3.70");
                    }
                    if(coulant.isSelected()){
                        escribeFactura.write("1 Coulant......... 5.40€");
                        escribePrecio.write("5.40");
                    }
                    if(natillas.isSelected()){
                        escribeFactura.write("1 Natillas......... 4.10€");
                        escribePrecio.write("4.10");
                    }
                    if(helado.isSelected()){
                        escribeFactura.write("1 Helado......... 2.00€");
                        escribePrecio.write("2.00");
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

class Infusiones extends  JFrame{
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





class VentanaPrinci extends JFrame{

    public VentanaPrinci(){

        setSize(800,800);
        setVisible(true);
        setTitle("DONGIOVANNI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panelCentral = new JPanel();
        setContentPane(panelCentral);

        JTextArea textoRecibo = new JTextArea();
        textoRecibo.setBounds(400,50,350,600);
        String s1="FACTURA:";
        textoRecibo.setText(s1);

        MyButton calculaTicket= new MyButton("Calcula",60,680,80,80);
        MyButton muestraTiquets= new MyButton("AÑADIR",150,680,140,80);
        Font fuentePrincipal= new Font("Arial",Font.ITALIC,19);


        MyImageLabel titulo = new MyImageLabel("Fotos_Dongiovanni/Logo.jpg", 30, 20, 300, 100);
        MyLabel entrantes=new MyLabel("ENTRANTES", 30,150,100,20);
        entrantes.setFont(fuentePrincipal);

        MyLabel platosEntrantes= new MyLabel("Brabas, Calamares, Sepia, Jamón...",30,180,230,20);
        MyButton botEntrantes= new MyButton("Selecciona",235,178,100,30);


        MyLabel platoPrincipal= new MyLabel("PLATO PRINCIPAL", 30,230,150,30);
        platoPrincipal.setFont(fuentePrincipal);
        MyLabel primerosPlatos= new MyLabel("Sopas ,pastas, ensaladas, lasaña ...", 30,270,230,20);
        MyButton botPlatosPrincipales= new MyButton("Selecciona",235,270,100,30);


        MyLabel segundoPlato = new MyLabel("SEGUNDO PLATO",30,320,150,30);
        segundoPlato.setFont(fuentePrincipal);
        MyLabel segundosPlatos = new MyLabel("Carnes, Pescados, Pizzas ...",30,360,230,20);
        MyButton botonSegundos= new MyButton("Selecciona",190,360,100,30);

        MyLabel postresTitulo= new MyLabel("POSTRES",30,410,150,30);
        postresTitulo.setFont(fuentePrincipal);
        MyLabel postresPlatos= new MyLabel("Tiramisú, Flan, Coulant, Helado...",30,450,230,20);
        MyButton botonPostres= new MyButton("Selecciona",230,450,100,30);

        MyLabel cafesTitulo = new MyLabel("INFUSIONES Y CAFÉS", 30,500,190,30);
        cafesTitulo.setFont(fuentePrincipal);
        MyLabel cafesOpciones= new MyLabel("Cortado, Poleo, Manzanilla, Bombon...",30,540,230,20);
        MyButton botonCafes= new MyButton("Selecciona",260,540,100,30);

        MyLabel precioLetras= new MyLabel("Precio: ",400,640,100,50);
        Font fuentePrecio= new Font("Arial",Font.BOLD,25);
        precioLetras.setFont(fuentePrecio);
        MyLabel precioNumero= new MyLabel("0.00",490,640,70,50);
        precioNumero.setFont(fuentePrecio);
        MyLabel precioSimbolo= new MyLabel("€",552,640,50,50);
        precioSimbolo.setFont(fuentePrecio);

        botEntrantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
              abrirEntrantes();
              botonCafes.setEnabled(false);
              botonPostres.setEnabled(false);
              botonSegundos.setEnabled(false);
              botPlatosPrincipales.setEnabled(false);
              botEntrantes.setEnabled(false);
            }
        });

        botPlatosPrincipales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirPlatoPrincipal();
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
            }
        });

        botonSegundos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirPlatoSegundo();
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
            }
        });

        botonPostres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirPostres();
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
            }
        });

        botonCafes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirInfusiones();
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
            }
        });

        muestraTiquets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                botonCafes.setEnabled(true);
                botonPostres.setEnabled(true);
                botonSegundos.setEnabled(true);
                botPlatosPrincipales.setEnabled(true);
                botEntrantes.setEnabled(true);
                double precio=Double.parseDouble(precioNumero.getText());
                DecimalFormat formato = new DecimalFormat("#.00");
                FileReader leeFactura=null;
                FileReader leePrecio= null;
                try{
                    leePrecio= new FileReader("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/precios.txt");
                    BufferedReader lectorPrecio= new BufferedReader(leePrecio);
                    String cadenaPrecio= lectorPrecio.readLine();
                    precio=precio+Double.parseDouble(cadenaPrecio);
                    String resultado = formato.format(precio);
                    precioNumero.setText(precio+"");
                    leeFactura= new FileReader("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/Factura.txt");
                    BufferedReader lectorFacturas= new BufferedReader(leeFactura);
                    String cadena=lectorFacturas.readLine();
                    while (cadena!=null){
                        textoRecibo.setText(textoRecibo.getText()+"\n"+cadena);
                        cadena= lectorFacturas.readLine();
                    }


                    lectorFacturas.close();
                }
                catch(IOException exception){
                    System.out.println(exception.getMessage());
                }
            }
        });

        calculaTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"El precio total es de "+precioNumero.getText()+"€");
            }
        });



        panelCentral.setLayout(null);
        panelCentral.add(textoRecibo);
        panelCentral.add(calculaTicket);
        panelCentral.add(muestraTiquets);
        panelCentral.add(titulo);
        panelCentral.add(entrantes);
        panelCentral.add(platosEntrantes);
        panelCentral.add(botEntrantes);
        panelCentral.add(platoPrincipal);
        panelCentral.add(primerosPlatos);
        panelCentral.add(botPlatosPrincipales);
        panelCentral.add(segundoPlato);
        panelCentral.add(segundosPlatos);
        panelCentral.add(botonSegundos);
        panelCentral.add(postresTitulo);
        panelCentral.add(postresPlatos);
        panelCentral.add(botonPostres);
        panelCentral.add(cafesTitulo);
        panelCentral.add(cafesOpciones);
        panelCentral.add(botonCafes);
        panelCentral.add(precioLetras);
        panelCentral.add(precioNumero);
        panelCentral.add(precioSimbolo);
    }


public void abrirEntrantes(){
        Entrantes entra1= new Entrantes();
        entra1.setVisible(true);
}

public void abrirPlatoPrincipal(){
        platoPrincipal plat= new platoPrincipal();
        plat.setVisible(true);
}

public  void  abrirPlatoSegundo(){
        SegundoPlato seg= new SegundoPlato();
        seg.setVisible(true);
}
public  void  abrirPostres(){
        Postres post= new Postres();
}

public void abrirInfusiones(){
        Infusiones infu=new Infusiones();
}
}








public class Main {
    public static void main(String[] args) {
       VentanaPrinci ads= new VentanaPrinci();
    }
}