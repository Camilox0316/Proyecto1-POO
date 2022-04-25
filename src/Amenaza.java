import java.awt.Color;
import java.awt.Point;
public class Amenaza extends Objeto{
    public Amenaza (Point punto){
        asignarVida();
        asignarPos(punto);
        super.color = Color.red;
    }
}
