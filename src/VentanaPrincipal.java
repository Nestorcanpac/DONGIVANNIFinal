import ui.MyButton;
import ui.MyImageLabel;
import ui.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal(){

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
        PlatoPrincipal plat= new PlatoPrincipal();
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
