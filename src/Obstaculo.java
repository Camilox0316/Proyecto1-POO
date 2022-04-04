import java.awt.Color;
import java.awt.Point;
public class Obstaculo extends Objeto {
    public Obstaculo(Point punto){
        asignarPos(punto);
        super.color = Color.BLACK;
    }

    public void asignarPos(Point punto) {
    super.posicion = punto;
    }
    
}
