import java.awt.Color;
import java.awt.Point;
public class Obstaculo extends Objeto {
    public Obstaculo(Point punto){
        asignarPos(punto);
        super.color = Color.BLACK;
    }
    @Override
    public void reducirVida() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void asignarVida(){

    }
    @Override
    public void cambiarPosicion(Point ppunto){

    }
}
