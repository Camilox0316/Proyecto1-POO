import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout; import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton; import javax.swing.JFrame;
import javax.swing.JLabel;  import javax.swing.JPanel;
import javax.swing.border.Border;

public class Interfaz extends Mapa{
    private JFrame ventana;
    private JPanel panelLabel;
    private JLabel tablero[][];
    public Interfaz(){
        ventana = new JFrame("Mapa del enjambre"); ventana.setExtendedState(ventana.MAXIMIZED_BOTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventana.pack();  crearLabels(); ventana.setVisible(true);       

        manejoGui();
    }

    private void manejoGui(){
        pintarObjetos();
        pintarAgentes();
    }

    private void crearLabels(){
        this.tablero = new JLabel[filasColumnas][filasColumnas];
        panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout(filasColumnas,filasColumnas));
        Border borde;
        borde=BorderFactory.createLineBorder(Color.black);
        for (int i=0; i<filasColumnas;i++){
            for (int j=0; j<filasColumnas;j++){
            JLabel etiqueta = new JLabel(i+","+j); etiqueta.setOpaque(true);
            etiqueta.setBorder(borde);
            tablero[i][j] = etiqueta;
            panelLabel.add(etiqueta);}
        }
        ventana.add(panelLabel, BorderLayout.CENTER);
    }
    
    private void pintarObjetos(){
        for (int i= 0;i<listaObjetos.length;i++){
            Objeto objeto = listaObjetos[i];
            for (int j=0;j<4;j++){
            tablero[(int) objeto.posicion[j].getX()][(int) objeto.posicion[j].getY()].setBackground(objeto.color);
            }
        }
    }
     private void pintarAgentes(){
         for (AgenteBase agenteBase : listaAgenteBase) {
             tablero[(int) agenteBase.posicionAgente.getX()][(int) agenteBase.posicionAgente.getY()].setBackground(agenteBase.color);
         }
     }

}
