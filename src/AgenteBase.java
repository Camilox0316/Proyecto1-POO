import java.awt.Point;
public class AgenteBase {
    protected Point posicionAgente;
    protected Point posicionBase;
    protected Point posicionAux;
    protected String estado;
    public AgenteBase(){
        this.estado="buscando";
    }
    public void movimiento(){
        if (estado=="buscando"){
            //if (casilla frente, atras, izq o der, == validas){
                //mover
            //}
        }
        else if (estado=="entregando"){
            //if (casilla frente, atras, izq o der, == validas){
                //mover
            //}
        }
    }
    public void deteccion(){
        
    }
}

