import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout; import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon; import javax.swing.JButton; import javax.swing.JFrame;
import javax.swing.JLabel; import javax.swing.JOptionPane; import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.text.AttributeSet.ColorAttribute;

public class Interfaz extends Mapa{
    JFrame ventana;
    JPanel panelLabel;
    JLabel tablero[][];
    public Interfaz(){
        ventana = new JFrame("Mapa del enjambre");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearLabels();
        ventana.pack(); ventana.setVisible(true);
        manejoGui();
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
        for (int i= 0;i<super.listaObjetos.length;i++){
            Objeto objeto = super.listaObjetos[i];
            for (int j=0;j<4;j++){
            tablero[(int) objeto.posicion[j].getX()][(int) objeto.posicion[j].getY()].setBackground(objeto.color);}
        }
    }
    private void manejoGui(){
        pintarObjetos();
    }
}
