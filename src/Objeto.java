import java.awt.Point;
public abstract class Objeto {
    int vida;
    Point posicion;
    public  void reducirVida(){
        vida -=1;
    }
    public abstract void asignarPos(Point punto);
}
