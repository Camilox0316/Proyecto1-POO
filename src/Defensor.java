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
        super.color=Color.green;
    }
    /*
    public void atacar(){
        if (posicionAgente.getX()-1>=0){
            //int IDarriba1=getID(posicionAgente.getX()-1, posicionAgente.getY());
        }
        else{
            //int IDArriba1=8;
        }

        if (posicionAgente.getX()+1<=49){
            //int IDabajo1=getID(posicionAgente.getX()+1, posicionAgente.getY());
        }
        else{
            //int IDabajo1=8;
        }

        if (posicionAgente.getY()+1<=49){
            //int IDderecha1=getID(posicionAgente.getX(), posicionAgente.getY()+1);
        }
        else{
            //int IDderecha1=8;
        }

        if (posicionAgente.getY()-1>=0){
            //int IDizquierda1=getID(posicionAgente.getX(), posicionAgente.getY()-1);
        }
        else{
            //int IDizquierda1=8;
        }
        
        if (posicionAgente.getX()-2>=0){
            //int IDarriba2=getID(posicionAgente.getX()-2, posicionAgente.getY());
        }
        else{
            //int IDArriba2=8;
        }

        if (posicionAgente.getX()+2<=49){
            //int IDabajo2=getID(posicionAgente.getX()+2, posicionAgente.getY());
        }
        else{
            //int IDabajo2=8;
        }

        if (posicionAgente.getY()+2<=49){
            //int IDderecha2=getID(posicionAgente.getX(), posicionAgente.getY()+2);
        }
        else{
            //int IDderecha2=8;
        }

        if (posicionAgente.getY()-2>=0){
            //int IDizquierda2=getID(posicionAgente.getX(), posicionAgente.getY()-2);
        }
        else{
            //int IDizquierda2=8;
        }
        //Arriba es deteccion ver como arreglar ...
        if (estado=="alterado"){
            if (IDarriba1==1 || IDabajo1==1 || IDderecha1==1 || IDizquierda1==1){
                //reducir vida amenaza;
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
            }
            else if (IDderecha2==1){
                if (IDerecha1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (IDarriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (IDabajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
                else if (IDizquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                }
            }
            else if (IDizquierda2==1){
                if (IDizquierda1==0){
                    posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (IDarriba1==0){
                    posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (IDabajo1==0){
                    posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                }
            }
            else if (posicionAuxAmenaza.getX()!=0 && posicionAuxAmenaza.getY()!=0){
                //Abajo
                if (posicionAgente.getX() < posicionAuxAmenaza.getX()){
                    if (Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    }
                    else if(posicionAgente.getY() < posicionAuxAmenaza.getY() && Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getY() > posicionAuxAmenaza.getY() && Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    }
                }
                //Arriba
                else if (posicionAgente.getX() > posicionAuxAmenaza.getX()){
                    if (Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    }
                    else if(posicionAgente.getY() < posicionAuxAmenaza.getY() && Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getY() > posicionAuxAmenaza.getY() && Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    }
                }
                //Derecha
                else if (posicionAgente.getY() < posicionAuxAmenaza.getY()){
                    if (Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getX() < posicionAuxAmenaza.getX() && Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getX() > posicionAuxAmenaza.getX() && Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                }
                //Izquierda
                else if (posicionAgente.getY() > posicionAuxAmenaza.getY()){
                    if (Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(posicionAgente.getX() < posicionAuxAmenaza.getX() && Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getX() > posicionAuxAmenaza.getX() && Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                }
                else{
                    posicionAuxRecurso.setLocation(0,0);
                }
            }
            else{
                estado="buscando";
            }
        }
    }
    public void ejecutar(Mapa mapa){//funcion que se ejecita en mapa (ciclo) 
        deteccion(mapa);
        atacar();
    }*/

}
