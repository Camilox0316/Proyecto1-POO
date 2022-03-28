import java.awt.Point;
public class Recurso extends Objeto{
    int vida;
    Point posicion;
    public Recurso(Point punto){
        vida = 10;
        asignarPos(punto);
    }
    public  void reducirVida(){
        vida -= 10;
    }
    public void asignarPos(Point punto) {
        posicion = punto;
    }
}
