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
            if (Arriba1==1){
                if (Abajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
               else if(Derecha1==0){
                   posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
               } 
               else if(Izquierda1==0){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            } 
            }
            else if (Abajo1==1){
                if (Arriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
               else if(Derecha1==0){
                   posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
               } 
               else if(Izquierda1==0){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            }
            else if (=Izquierda1=1){
                if(Derecha1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (Arriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (Abajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
            }
            else if (Derecha1==1){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                if(Izquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                }
                else if (Arriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (Abajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
            }
            if (Arriba2==1){
                if (Abajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
               else if(Derecha1==0){
                   posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
               } 
               else if(Izquierda1==0){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            } 
            }
            else if (Abajo2==1){
                if (Arriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
               else if(Derecha1==0){
                   posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
               } 
               else if(Izquierda1==0){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            }
            else if (=Izquierda2=1){
                if(Derecha1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (Arriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (Abajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
            }
            else if (Derecha2==1){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                if(Izquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                }
                else if (Arriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (Abajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
            else{
                estado="buscando";
            }
        }
    }
    public void ejecutar(){
        deteccion();
        huir();
    }*/
}
