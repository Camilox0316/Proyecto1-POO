import java.awt.Color;
import java.awt.Point;
public class Recurso extends Objeto{

    public Recurso(Point punto, int pborde){
        super.vida = 10;
        asignarPos(punto, pborde);
        super.color = Color.cyan;
    }
    public void asignarPos(Point punto) {
         
    }
}
