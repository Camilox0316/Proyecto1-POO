import java.awt.Color;
import java.awt.Point;
public class Obstaculo extends Objeto {
    public Obstaculo(Point punto[], int pborde){
        asignarPos(punto, pborde);
        super.color = Color.BLACK;
    }
    /*@Override
    public void asignarPos(Point puntos[], int pborde){
        return;
    }*/
    @Override
    public void reducirVida() {
        // TODO Auto-generated method stub
        
    }
}
