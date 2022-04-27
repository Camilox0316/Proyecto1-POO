import java.awt.Point;
import java.awt.Color;

public class Defensor extends AgenteBase{

    public Defensor(Point punto){
        posicionAgente = new Point(punto);
        posicionBase = new Point(0,0);
        posicionAuxAmenaza = new Point(0,0);
        posicionAuxRecurso = new Point(0,0);
        lleva_recurso = false;
        estado = "buscando";
        super.color=Color.yellow;
    }
    public void atacar(int posiciones[], Objeto objeto){
        int IDarriba1=posiciones[0];
        int IDabajo1=posiciones[1];
        int IDderecha1=posiciones[3];
        int IDizquierda1=posiciones[2];
        int IDarriba2=posiciones[4];
        int IDabajo2=posiciones[5];
        int IDderecha2=posiciones[7];
        int IDizquierda2=posiciones[6];

        if (estado=="alterado"){
            if (IDarriba1==1 || IDabajo1==1 || IDderecha1==1 || IDizquierda1==1){
                if (coincideObjeto(posicionAuxAmenaza, objeto.posicion))
                objeto.reducirVida();
            }
            else if (IDarriba2==1){
                if (IDarriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (IDderecha1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (IDizquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                }
                else if(IDabajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
            }
            else if (IDabajo2==1){
                if (IDabajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
                else if (IDderecha1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (IDizquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                }
                else if(IDarriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
            }
            else if (IDderecha2==1){
                if (IDderecha1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (IDarriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (IDabajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
                else if (IDizquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                }
            }
            else if (IDizquierda2==1){
                if (IDizquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                }
                else if (IDarriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (IDabajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
                else if (IDizquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                }
            }
            else if (posicionAuxAmenaza.getX()!=0 && posicionAuxAmenaza.getY()!=0){
                //Abajo
                if (posicionAgente.getX() < posicionAuxAmenaza.getX()){
                    if (IDabajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    }
                    else if(posicionAgente.getY() < posicionAuxAmenaza.getY() && IDderecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getY() > posicionAuxAmenaza.getY() && IDizquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(IDarriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    }
                }
                //Arriba
                else if (posicionAgente.getX() > posicionAuxAmenaza.getX()){
                    if (IDarriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    }
                    else if(posicionAgente.getY() < posicionAuxAmenaza.getY() && IDderecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getY() > posicionAuxAmenaza.getY() && IDizquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(IDabajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    }
                }
                //Derecha
                else if (posicionAgente.getY() < posicionAuxAmenaza.getY()){
                    if (IDderecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getX() < posicionAuxAmenaza.getX() && IDabajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    }
                    else if(posicionAgente.getX() > posicionAuxAmenaza.getX() && IDarriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    }
                    else if(IDizquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                }
                //Izquierda
                else if (posicionAgente.getY() > posicionAuxAmenaza.getY()){
                    if (IDizquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(posicionAgente.getX() < posicionAuxAmenaza.getX() && IDabajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    }
                    else if(posicionAgente.getX() > posicionAuxAmenaza.getX() && IDarriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    }
                    else if(IDderecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                }
                else{
                    posicionAuxAmenaza.setLocation(0,0);
                    if (lleva_recurso==true){
                        estado="entregando";
                    }
                    else{
                        estado="buscando";
                    }
                }
            }
            else{
                posicionAuxAmenaza.setLocation(0,0);
                if (lleva_recurso==true){
                    estado="entregando";
                }
                else{
                    estado="buscando";
                }
            }
        }
    }
    public void ejecutar(Mapa mapa){//funcion que se ejecita en mapa (ciclo) 
        int i;
        for (i=0; i<mapa.cantidadObjetos;i++){
            if(coincideObjeto(posicionAuxAmenaza, mapa.listaObjetos[i].posicion)){
                break;
            }
            else if (coincideObjeto(posicionAuxRecurso, mapa.listaObjetos[i].posicion) && estado=="recolectando"){
                break;
            }
        
        }
        if(i>=15)i=14;
        atacar(deteccion(mapa, mapa.listaObjetos[i]), mapa.listaObjetos[i]);
    }

}
