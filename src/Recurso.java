import java.awt.Point;
public class Recurso extends Objeto{

    public Recurso(Point punto){
        super.vida = 10;
        asignarPos(punto);
    }
    public void asignarPos(Point punto) {
        super.posicion = punto;
    }
}
