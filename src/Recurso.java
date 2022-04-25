import java.awt.Color;
import java.awt.Point;
public class Recurso extends Objeto{

    public Recurso(Point punto){
        asignarVida();
        asignarPos(punto);
        super.color = Color.cyan;
    }
}
