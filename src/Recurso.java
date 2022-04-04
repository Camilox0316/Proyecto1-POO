import java.awt.Color;
import java.awt.Point;
public class Recurso extends Objeto{

    public Recurso(Point punto){
        super.vida = 10;
        asignarPos(punto);
        super.color = Color.pink;
    }
    public void asignarPos(Point punto) {
        super.posicion = punto;
    }
}
