import java.awt.Point;
public class Amenaza extends Objeto{
    int vida;
    Point posicion;
    public Amenaza (Point punto){
        vida = 10;
        asignarPos(punto);
    }
    public void reducirVida() {
        vida -=10;
    }
    public void asignarPos(Point punto) {
        posicion = punto;
    }
    
}
