import java.awt.Color;
import java.awt.Point;

public class Recolector extends AgenteBase{
    
    public Recolector(Point punto){
        posicionAgente = new Point(punto);
        posicionBase = new Point(0,0);
        posicionAuxAmenaza = new Point(0,0);
        posicionAuxRecurso = new Point(0,0);
        lleva_recurso = false;
        estado = "buscando";
        super.color=Color.yellow;
    }
    
    /*public void huir(){
        if (estado=="alterado"){
            if ("getID(posicionAgente.getX()-2, posicionAgente.getY());"==1){
                posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
            }
            else if ("getID(posicionAgente.getX()+2, posicionAgente.getY());"==1){
                posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
            }
            else if ("getID(posicionAgente.getX(), posicionAgente.getY()+2);"==1){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            }
            else if ("getID(posicionAgente.getX(), posicionAgente.getY()-2);"==1){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
            }
            else if ("getID(posicionAgente.getX()-2, posicionAgente.getY());"==1){
                posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
            }
            else if ("getID(posicionAgente.getX()+2, posicionAgente.getY());"==1){
                posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
            }
            else if ("getID(posicionAgente.getX(), posicionAgente.getY()+2);"==1){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            }
            else if ("getID(posicionAgente.getX(), posicionAgente.getY()-2);"==1){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
            }
            else{
                estado="buscando";
            }
        }
    }
    public void ejecutarR(){
        deteccion();
        huir();
    }*/
}
