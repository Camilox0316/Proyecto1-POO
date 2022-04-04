import java.awt.Point;
import java.awt.Color;
public abstract class Objeto {
    int vida;
    Point posicion;
    Color color;
    public  void reducirVida(){
        vida -=1;
    }
    public abstract void asignarPos(Point punto);
}
