import java.awt.Color;
import java.awt.Point;
public class Amenaza extends Objeto{
    public Amenaza (Point punto, int pborde){
        super.vida = 10;
        asignarPos(punto, pborde);
        super.color = Color.red;
    }
    public void asignarPos(Point punto) {
    }
    
}
