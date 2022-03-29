import java.awt.Point;
public class Obstaculo extends Objeto {
    public Obstaculo(Point punto){
        asignarPos(punto);
    }

    public void asignarPos(Point punto) {
    super.posicion = punto;
    }
    
}
