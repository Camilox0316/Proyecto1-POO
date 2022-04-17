import java.awt.Point;
import java.lang.Math;
public class AgenteBase {
    protected Point posicionAgente;
    protected Point posicionBase;
    protected String estado;
    public AgenteBase(){
        posicionBase.setLocation(0,0);
        this.estado="buscando";
    }
    public void movimiento(int Arriba, int Abajo, int Derecha, int Izquierda){
        if (estado=="buscando"){
            while(true){
                int rand = (int)(Math.random() * 4) + 1;
                if (rand==1 && Arriba==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    break;
                }
                else if(rand==2 && Abajo==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    break;
                }
                else if(rand==3 && Derecha==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    break;
                }
                else if(rand==4 && Izquierda==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    break;
                }
                if (Arriba!=0 && Abajo!=0 && Derecha!=0 && Izquierda!=0){
                    break;
                }
            }
        }
        else if (estado=="entregando"){
            //if (casilla frente, atras, izq o der, == validas){
                //mover
            //}
        }
    }
    public void deteccion(){
        if (posicionAgente.getY()-1>=0){
            //int IDarriba1=getID(posicionAgente.getX(), posicionAgente.getY()-1);
        }
        else{
            //int IDArriba1=8;
        }

        if (posicionAgente.getY()+1<=49){
            //int IDabajo1=getID(posicionAgente.getX(), posicionAgente.getY()+1);
        }
        else{
            //int IDabajo1=8;
        }

        if (posicionAgente.getX()+1<=49){
            //int IDderecha1=getID(posicionAgente.getX()+1, posicionAgente.getY());
        }
        else{
            //int IDderecha1=8;
        }

        if (posicionAgente.getX()-1>=0){
            //int IDizquierda1=getID(posicionAgente.getX()-1, posicionAgente.getY());
        }
        else{
            //int IDizquierda1=8;
        }
        
        if (posicionAgente.getY()-2>=0){
            //int IDarriba2=getID(posicionAgente.getX(), posicionAgente.getY()-2);
        }
        else{
            //int IDArriba2=8;
        }

        if (posicionAgente.getY()+2<=49){
            //int IDabajo2=getID(posicionAgente.getX(), posicionAgente.getY()+2);
        }
        else{
            //int IDabajo2=8;
        }

        if (posicionAgente.getX()+2<=49){
            //int IDderecha2=getID(posicionAgente.getX()+2, posicionAgente.getY());
        }
        else{
            //int IDderecha2=8;
        }

        if (posicionAgente.getX()-2>=0){
            //int IDizquierda2=getID(posicionAgente.getX()-2, posicionAgente.getY());
        }
        else{
            //int IDizquierda2=8;
        }
    }
    public void Analisis(int Arriba1, int Abajo1, int Izquierda1, int Derecha1, int Arriba2, int Abajo2, int Izquierda2, int Derecha2){
        //Determinar Estado 
        if (Arriba1==1 || Abajo1==1 || Derecha1==1 || Izquierda1==1 ||Arriba2==1 || Abajo2==1 || Derecha2==1 || Izquierda2==1){
            //se detecta amenaza
            estado="alterado";
        }
        else if(Arriba1==2 || Abajo1==2 || Derecha1==2 || Izquierda1==2 ||Arriba2==2 || Abajo2==2 || Derecha2==2 || Izquierda2==2){
            //se detecta recurso
            estado="recolectando";
        }
        else if(Arriba1==3 || Abajo1==3 || Derecha1==3 || Izquierda1==3 ||Arriba2==3 || Abajo2==3 || Derecha2==3 || Izquierda2==3){
            //se detecta agente buscando
        }
        else if(Arriba1==4 || Abajo1==4 || Derecha1==4 || Izquierda1==4 ||Arriba2==4 || Abajo2==4 || Derecha2==4 || Izquierda2==4){
            //se detecta agente alterado.
        }
        else if(Arriba1==5 || Abajo1==5 || Derecha1==5 || Izquierda1==5 ||Arriba2==5 || Abajo2==5 || Derecha2==5 || Izquierda2==5){
            //se detecta agente recolectando.
        }
        else if(Arriba1==6 || Abajo1==6 || Derecha1==6 || Izquierda1==6 ||Arriba2==6 || Abajo2==6 || Derecha2==6 || Izquierda2==6){
            //se detecta agente entregando.
        }
        movimiento(Arriba1,Abajo1,Derecha1,Izquierda1);
    }
}

