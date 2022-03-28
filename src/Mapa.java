import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout; import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon; import javax.swing.JButton; import javax.swing.JFrame;
import javax.swing.JLabel; import javax.swing.JOptionPane; import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class Mapa {
    int filasColumnas = 50;
    JFrame ventana;
    JPanel panelLabel;
    JLabel tablero[][];

    public Mapa(){
        ventana = new JFrame("Mapa del enjambre");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearLabels();
        ventana.pack(); ventana.setVisible(true);
    }
    private void crearLabels(){
        this.tablero = new JLabel[filasColumnas][filasColumnas];
        panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout(filasColumnas,filasColumnas));
        panelLabel.setBackground(Color.GREEN);
        for (int i=0; i<filasColumnas;i++){
            for (int j=0; j<filasColumnas;j++){
            JLabel etiqueta = new JLabel(i+","+j);
            Border borde;
            borde=BorderFactory.createLineBorder(Color.black);
            etiqueta.setBorder(borde);

            
            tablero[i][j] = etiqueta;
            panelLabel.add(etiqueta);}
        }
        ventana.add(panelLabel, BorderLayout.CENTER);
    }
}
