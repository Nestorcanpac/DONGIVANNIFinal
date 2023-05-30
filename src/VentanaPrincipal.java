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
import java.text.DecimalFormat;//Imports necersarios para el programa

public class VentanaPrincipal extends JFrame {//Extensión de JFrame

    public VentanaPrincipal(){//Constructor ventana principal

        setSize(800,800);//Tamaño de ventana
        setVisible(true);//La ventana es visible
        setTitle("DONGIOVANNI");//Titulo de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Comando para cuando cierres la ventana
        setResizable(false);//No se puede redimensionar
        setLocationRelativeTo(null);//Posicion de la ventana al ejecutar

        JPanel panelCentral = new JPanel();
        setContentPane(panelCentral);//Definición del panel de la ventana

        JTextArea textoRecibo = new JTextArea();
        textoRecibo.setBounds(400,50,350,600);
        String s1="FACTURA:";
        textoRecibo.setText(s1);//Creación de una area de texto para escribir el ticket

        MyButton calculaTicket= new MyButton("Ticket",60,680,80,80);//Boton para calcular el precio total del pedido
        MyButton muestraTiquets= new MyButton("AÑADIR",150,680,140,80);//Boton para añadir el plato seleccionado al area de texto
        Font fuentePrincipal= new Font("Arial",Font.ITALIC,19);//Creacion de la fuente de texto principal


        MyImageLabel titulo = new MyImageLabel("Fotos_Dongiovanni/Logo.jpg", 30, 20, 300, 100);//Foto del logo
        MyLabel entrantes=new MyLabel("ENTRANTES", 30,150,100,20);//Creacion del titulo entrentes
        entrantes.setFont(fuentePrincipal);//Pone la fuente al texto
        MyLabel platosEntrantes= new MyLabel("Brabas, Calamares, Sepia, Jamón...",30,180,230,20);
        MyButton botEntrantes= new MyButton("Selecciona",235,178,100,30);//boton seleccionar de Entrantes


        MyLabel platoPrincipal= new MyLabel("PLATO PRINCIPAL", 30,230,150,30);//Creacion del titulo plato principal
        platoPrincipal.setFont(fuentePrincipal);//Pone la fuente al texto
        MyLabel primerosPlatos= new MyLabel("Sopas ,pastas, ensaladas, lasaña ...", 30,270,230,20);
        MyButton botPlatosPrincipales= new MyButton("Selecciona",235,270,100,30);//boton seleccionar de los primeros platos


        MyLabel segundoPlato = new MyLabel("SEGUNDO PLATO",30,320,150,30);//Creacion del titulo segundos platos
        segundoPlato.setFont(fuentePrincipal);//Pone la fuente al texto
        MyLabel segundosPlatos = new MyLabel("Carnes, Pescados, Pizzas ...",30,360,230,20);
        MyButton botonSegundos= new MyButton("Selecciona",190,360,100,30);//boton seleccionar de los segundos platos

        MyLabel postresTitulo= new MyLabel("POSTRES",30,410,150,30);//Creacion del titulo postres
        postresTitulo.setFont(fuentePrincipal);//Pone la fuente al texto
        MyLabel postresPlatos= new MyLabel("Tiramisú, Flan, Coulant, Helado...",30,450,230,20);
        MyButton botonPostres= new MyButton("Selecciona",230,450,100,30);//boton seleccionar de postres

        MyLabel cafesTitulo = new MyLabel("INFUSIONES Y CAFÉS", 30,500,190,30);//Creacion del titulo Infusiones y cafes
        cafesTitulo.setFont(fuentePrincipal);//Pone la fuente al texto
        MyLabel cafesOpciones= new MyLabel("Cortado, Poleo, Manzanilla, Bombon...",30,540,230,20);
        MyButton botonCafes= new MyButton("Selecciona",260,540,100,30);//boton seleccionar de cafes

        MyLabel precioLetras= new MyLabel("Precio: ",400,640,100,50);//Texto precio
        Font fuentePrecio= new Font("Arial",Font.BOLD,25);//Pone la fuente al texto
        precioLetras.setFont(fuentePrecio);//Pone la fuente al texto
        MyLabel precioNumero= new MyLabel("0.00",490,640,70,50);//Texto del precio
        precioNumero.setFont(fuentePrecio);//Pone la fuente al texto
        MyLabel precioSimbolo= new MyLabel("€",552,640,50,50);//Creacion del texto de €
        precioSimbolo.setFont(fuentePrecio);//Pone la fuente al texto

        botEntrantes.addActionListener(new ActionListener() {//Accion del boton seleccionar de Entrantes
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirEntrantes();//Abre la ventana de Entrantes
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
                muestraTiquets.setEnabled(true);
            }
        });

        botPlatosPrincipales.addActionListener(new ActionListener() {//Accion del boton seleccionar de Platos Principales
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirPlatoPrincipal();//Abre la ventana de Platos Principales
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
                muestraTiquets.setEnabled(true);//Hace que todos los botones no se puedan pulsar excepto el de añadir
            }
        });

        botonSegundos.addActionListener(new ActionListener() {//Accion del boton seleccionar de los Segundos platos
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirPlatoSegundo();//Abre la ventana de Segundos Platos
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
                muestraTiquets.setEnabled(true);//Hace que todos los botones no se puedan pulsar excepto el de añadir
            }
        });

        botonPostres.addActionListener(new ActionListener() {//Accion del boton seleccionar de Postres
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirPostres();//Abre la ventana de Postres
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
                muestraTiquets.setEnabled(true);//Hace que todos los botones no se puedan pulsar excepto el de añadir
            }
        });

        botonCafes.addActionListener(new ActionListener() {//Accion del boton seleccionar de cafes
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abrirInfusiones();//Abre la ventana de infusiones
                botonCafes.setEnabled(false);
                botonPostres.setEnabled(false);
                botonSegundos.setEnabled(false);
                botPlatosPrincipales.setEnabled(false);
                botEntrantes.setEnabled(false);
                muestraTiquets.setEnabled(true);//Hace que todos los botones no se puedan pulsar excepto el de añadir
            }
        });

        muestraTiquets.addActionListener(new ActionListener() {//Accion del boton Añadir
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                muestraTiquets.setEnabled(false);
                botonCafes.setEnabled(true);
                botonPostres.setEnabled(true);
                botonSegundos.setEnabled(true);
                botPlatosPrincipales.setEnabled(true);
                botEntrantes.setEnabled(true);//Hace que todos los botones se puedan pulsar excepto el de añadir
                double precio=Double.parseDouble(precioNumero.getText());//Parsea el precio de la comida seleccionada
                DecimalFormat formato = new DecimalFormat("#.00");//Formato de decimal de 2 números
                FileReader leeFactura=null;
                FileReader leePrecio= null;
                try{
                    leePrecio= new FileReader("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/precios.txt");//Definicion de FileReader del precio
                    BufferedReader lectorPrecio= new BufferedReader(leePrecio);//Definicion de BufferedReader
                    String cadenaPrecio= lectorPrecio.readLine();//Asignacion a un String el fichero
                    precio=precio+Double.parseDouble(cadenaPrecio);
                    precioNumero.setText(precio+"");//Sumamos el precio al total
                    leeFactura= new FileReader("/home/nescanpac/IdeaProjects/DONGIVANNI/Ficheros/Factura.txt");//Definicion de FileReader del Ticket
                    BufferedReader lectorFacturas= new BufferedReader(leeFactura);//Definicion de BufferedReader
                    String cadena=lectorFacturas.readLine();//Asignacion a un String el fichero
                    while (cadena!=null){
                        textoRecibo.setText(textoRecibo.getText()+"\n"+cadena);//Añadimos al text Area lo que hay en el fichero
                        cadena= lectorFacturas.readLine();
                    }

                    lectorPrecio.close();
                    lectorFacturas.close();//Cerramos los ficheros
                }
                catch(IOException exception){//Excepción de ficheros
                    System.out.println(exception.getMessage());
                }
            }
        });

        calculaTicket.addActionListener(new ActionListener() {//Accion del boton Ticket
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"El precio total es de "+precioNumero.getText()+"€");//Muestra el precio final
            }
        });

        //Adds al panel principal
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


    public void abrirEntrantes(){//Metodo para abrir la ventana de Entrantes
        Entrantes entra1= new Entrantes();
        entra1.setVisible(true);
    }

    public void abrirPlatoPrincipal(){//Metodo para abrir la ventana de Platos principales
        PlatoPrincipal plat= new PlatoPrincipal();
        plat.setVisible(true);
    }

    public  void  abrirPlatoSegundo(){//Metodo para abrir la ventana de segundos platos
        SegundoPlato seg= new SegundoPlato();
        seg.setVisible(true);
    }
    public  void  abrirPostres(){//Metodo para abrir la ventana de Postres
        Postres post= new Postres();
    }

    public void abrirInfusiones(){//Metodo para abrir la ventana de Infusiones
        Infusiones infu=new Infusiones();
    }
}
