import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout; import java.awt.event.*;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JButton; import javax.swing.JFrame;
import javax.swing.JLabel;  import javax.swing.JPanel;
import javax.swing.border.Border;

public class Interfaz extends Mapa implements ActionListener{
    private JFrame ventana;
    private JPanel panelLabel;
    private JLabel tablero[][];
    private JButton botonSig;
    private JPanel panelBoton;

    public Interfaz(){
        ventana = new JFrame("Mapa del enjambre"); ventana.setExtendedState(ventana.MAXIMIZED_BOTH);
        manejoVentana(); 
        pintarTodosElementos();
    }
    
    private void manejoVentana(){
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventana.pack();  
        crearLabels();
        crearBoton();
        ventana.setVisible(true);
    }

    private void manejoGui(){
        pintarTableroBlanco();
        juegoAgentes();
        juegoObjetos();
        pintarTodosElementos();

    }
    private void crearBoton(){
        panelBoton = new JPanel();
        botonSig = new JButton("Tick");
        botonSig.addActionListener(this);
        panelBoton.add(botonSig, BorderLayout.NORTH);
        ventana.add(botonSig, BorderLayout.NORTH);
    }
    private void crearLabels(){
        this.tablero = new JLabel[filasColumnas][filasColumnas];
        panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout(filasColumnas,filasColumnas));
        Border borde;
        borde=BorderFactory.createLineBorder(Color.black);
        for (int i=0; i<filasColumnas;i++){
            for (int j=0; j<filasColumnas;j++){
            JLabel etiqueta = new JLabel(); etiqueta.setOpaque(true);
            etiqueta.setBorder(borde);
            tablero[i][j] = etiqueta;
            panelLabel.add(etiqueta);}
        }
        ventana.add(panelLabel, BorderLayout.CENTER);
    }
    
    private void pintarObjetos(){
        int y=0;
        for (int i= 0;i<listaObjetos.length;i++){
            Objeto objeto = listaObjetos[i];
            for (int j=0;j<4;j++){
            tablero[(int) objeto.posicion[j].getX()][(int) objeto.posicion[j].getY()].setBackground(objeto.color);
            if (j==0)
            tablero[(int) objeto.posicion[j].getX()][(int) objeto.posicion[j].getY()].setText((y++)+"");

            }
        }
    }
     private void pintarAgentes(){
         for (AgenteBase agenteBase : listaAgenteBase) {
            tablero[(int) agenteBase.posicionAgente.getX()][(int) agenteBase.posicionAgente.getY()].setBackground(agenteBase.color);
         }
     }

    private void pintarTableroBlanco(){
        for (Point punto : listaPuntos) {
            if (punto.getX()!=-1)
            tablero[(int) punto.getX()][(int) punto.getY()].setBackground(Color.white);
        }
    }
    private void pintarTodosElementos(){
        pintarBase();
        pintarObjetos();
        pintarAgentes();
    }

    private void pintarBase(){
        Color color=Color.blue;
        tablero[0][0].setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(botonSig)){
            manejoGui();
        } 
    }

}
