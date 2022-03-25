public class AgenteBase {
    public int[] posicion;
    public String estado;
    public AgenteBase(){
        this.posicion[0]=0;
        this.posicion[1]=0;
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

