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
        super.color=Color.green;
    }
    public void huir(int posiciones[]){
        int Arriba1=posiciones[0];
        int Abajo1=posiciones[1];
        int Derecha1=posiciones[3];
        int Izquierda1=posiciones[2];
        int Arriba2=posiciones[4];
        int Abajo2=posiciones[5];
        int Derecha2=posiciones[7];
        int Izquierda2=posiciones[6];
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
            }
            else if (Izquierda1==1){
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
            else if (Arriba2==1){
                if (Abajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
                else if(Izquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                } 
               else if(Derecha1==0){
                   posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                } 

            }
            else if (Abajo2==1){
                if (Arriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if(Izquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                }
               else if(Derecha1==0){
                   posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                } 

            }
            else if (Izquierda2==1){
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
            else{
                if (lleva_recurso==true){
                    estado="entregando";
                }
                else{
                    estado="buscando";
                }
            }
        }    
    }
    public void ejecutar(Mapa mapa){
        int i;
        for (i=0; i<mapa.cantidadObjetos;i++){
            if(coincideObjeto(posicionAuxRecurso, mapa.listaObjetos[i].posicion))
            break;
        }
        if(i>=15)i=14;
        huir(deteccion(mapa, mapa.listaObjetos[i]));
    }
}
