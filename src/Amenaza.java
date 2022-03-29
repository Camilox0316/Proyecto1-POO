import java.awt.Point;
public class Amenaza extends Objeto{
    public Amenaza (Point punto){
        super.vida = 10;
        asignarPos(punto);
    }
    public void asignarPos(Point punto) {
        super.posicion = punto;
    }
    
}
