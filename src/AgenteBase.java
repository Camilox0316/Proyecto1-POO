import java.awt.Point;
import java.lang.Math;
public class AgenteBase {
    public Point posicionAgente;
    protected Point posicionBase;
    public Point posicionAuxAmenaza;
    public Point posicionAuxRecurso;
    protected boolean lleva_recurso;
    public String estado;
    public AgenteBase(){// cambiar a defe y recolt
        posicionAgente = new Point();
        posicionBase = new Point();
        posicionAuxAmenaza = new Point();
        posicionAuxRecurso = new Point();
        lleva_recurso = false;
        estado = new String();
        this.estado="buscando";
    }
    public void acciones(int Arriba1, int Abajo1, int Derecha1, int Izquierda1,int Arriba2, int Abajo2, int Derecha2, int Izquierda2){
        if (estado=="buscando"){
            if (posicionAuxRecurso.getX()!=0 && posicionAuxRecurso.getY()!=0){
                //Abajo
                if (posicionAgente.getX() < posicionAuxRecurso.getX()){
                    if (Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    }
                    else if(posicionAgente.getY() < posicionAuxRecurso.getY() && Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getY() > posicionAuxRecurso.getY() && Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    }
                }
                //Arriba
                else if (posicionAgente.getX() > posicionAuxRecurso.getX()){
                    if (Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                    }
                    else if(posicionAgente.getY() < posicionAuxRecurso.getY() && Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getY() > posicionAuxRecurso.getY() && Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                    }
                }
                //Derecha
                else if (posicionAgente.getY() < posicionAuxRecurso.getY()){
                    if (Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getX() < posicionAuxRecurso.getX() && Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getX() > posicionAuxRecurso.getX() && Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                }
                //Izquierda
                else if (posicionAgente.getY() > posicionAuxRecurso.getY()){
                    if (Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                    }
                    else if(posicionAgente.getX() < posicionAuxRecurso.getX() && Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                    }
                    else if(posicionAgente.getX() > posicionAuxRecurso.getX() && Arriba1==0){
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
                while(true){
                    if (Arriba1!=0 && Abajo1!=0 && Derecha1!=0 && Izquierda1!=0){
                        break;
                    }
                    int rand = (int)(Math.random() * 4) + 1;
                    if (rand==1 && Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
                        break;
                    }
                    else if(rand==2 && Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
                        break;
                    }
                    else if(rand==3 && Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
                        break;
                    }
                    else if(rand==4 && Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
                        break;
                    }
                }
            }
        }
        else if (estado=="recolectando"){
            if (Arriba1==2 || Abajo1==2 || Derecha1==2 || Izquierda1==2){
                //reducir vida recurso
                estado="entregando";
                lleva_recurso=true;
            }
            else if (Arriba2==2 && Arriba1==0){
                posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
            }
            else if (Abajo2==2 && Abajo1==0){
                posicionAgente.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
            }
            else if (Derecha2==2 && Derecha1==0){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
            }
            else if (Izquierda2==2 && Izquierda1==0){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            }
        }
        else if (estado=="entregando" || lleva_recurso==true){
            if (posicionAgente.getX()==0 && posicionAgente.getY()==0){
                estado="buscando";
                lleva_recurso=false;
            }
            if (Arriba1==0){
                posicionAgente.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
            }
            else if(Izquierda1==0){
                posicionAgente.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            }
        }
    }
    public void deteccion(){
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
        //cambio_estado(IDarriba1, IDabajo1, IDizquierda1, IDderecha1, IDarriba2, IDabajo2, IDizquierda2, IDderecha2);
    }
    public void cambio_estado(int Arriba1, int Abajo1, int Izquierda1, int Derecha1, int Arriba2, int Abajo2, int Izquierda2, int Derecha2){
        //Determinar Estado 
        if (Arriba1==1 || Abajo1==1 || Derecha1==1 || Izquierda1==1 ||Arriba2==1 || Abajo2==1 || Derecha2==1 || Izquierda2==1){
            //se detecta amenaza
            estado="alterado";
            if (Arriba1==1){
                posicionAuxAmenaza.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
            }
            else if (Arriba2==1){
                posicionAuxAmenaza.setLocation(posicionAgente.getX()-2, posicionAgente.getY());
            }
            else if (Abajo1==1){
                posicionAuxAmenaza.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
            }
            else if (Abajo2==1){
                posicionAuxAmenaza.setLocation(posicionAgente.getX()+2, posicionAgente.getY());
            }
            else if (Derecha1==1){
                posicionAuxAmenaza.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
            }
            else if (Derecha2==1){
                posicionAuxAmenaza.setLocation(posicionAgente.getX(), posicionAgente.getY()+2);
            }
            else if (Izquierda1==1){
                posicionAuxAmenaza.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            }
            else if (Izquierda2==1){
                posicionAuxAmenaza.setLocation(posicionAgente.getX(), posicionAgente.getY()-2);
            }
            acciones(Arriba1,Abajo1,Derecha1,Izquierda1,Arriba2,Abajo2,Derecha2,Izquierda2);
        }
        else if(Arriba1==2 || Abajo1==2 || Derecha1==2 || Izquierda1==2 ||Arriba2==2 || Abajo2==2 || Derecha2==2 || Izquierda2==2){
            //se detecta recurso
            estado="recolectando";
            if (Arriba1==2){
                posicionAuxRecurso.setLocation(posicionAgente.getX()-1, posicionAgente.getY());
            }
            else if (Arriba2==2){
                posicionAuxRecurso.setLocation(posicionAgente.getX()-2, posicionAgente.getY());
            }
            else if (Abajo1==2){
                posicionAuxRecurso.setLocation(posicionAgente.getX()+1, posicionAgente.getY());
            }
            else if (Abajo2==2){
                posicionAuxRecurso.setLocation(posicionAgente.getX()+2, posicionAgente.getY());
            }
            else if (Derecha1==2){
                posicionAuxRecurso.setLocation(posicionAgente.getX(), posicionAgente.getY()+1);
            }
            else if (Derecha2==2){
                posicionAuxRecurso.setLocation(posicionAgente.getX(), posicionAgente.getY()+2);
            }
            else if (Izquierda1==2){
                posicionAuxRecurso.setLocation(posicionAgente.getX(), posicionAgente.getY()-1);
            }
            else if (Izquierda2==2){
                posicionAuxRecurso.setLocation(posicionAgente.getX(), posicionAgente.getY()-2);
            }
            acciones(Arriba1,Abajo1,Derecha1,Izquierda1,Arriba2,Abajo2,Derecha2,Izquierda2);
        }
        else if(Arriba1==3 || Abajo1==3 || Derecha1==3 || Izquierda1==3 ||Arriba2==3 || Abajo2==3 || Derecha2==3 || Izquierda2==3){
            //se detecta agente alterado
        }
        else if(Arriba1==4 || Abajo1==4 || Derecha1==4 || Izquierda1==4 ||Arriba2==4 || Abajo2==4 || Derecha2==4 || Izquierda2==4){
            //se detecta agente recolectando
            if (lleva_recurso==false){
                if (Arriba1==4){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (Arriba2==4){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX()-2, posicionAgente.getY());
                }
                else if (Abajo1==4){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX()+1, posicionAgente.getY());
                }
                else if (Abajo2==4){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX()+2, posicionAgente.getY());
                }
                else if (Derecha1==4){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (Derecha2==4){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX(), posicionAgente.getY()+2);
                }
                else if (Izquierda1==4){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX(), posicionAgente.getY()-1);
                }
                else if (Izquierda2==4){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX(), posicionAgente.getY()-2);
                }
                acciones(Arriba1,Abajo1,Derecha1,Izquierda1,Arriba2,Abajo2,Derecha2,Izquierda2);
            }
        }
        else if(Arriba1==5 || Abajo1==5 || Derecha1==5 || Izquierda1==5 ||Arriba2==5 ||Arriba2==5 || Abajo2==5 || Derecha2==5 || Izquierda2==5){
            //se detecta agente entregando
            if (lleva_recurso==false){
                if (Arriba1==5){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX()-1, posicionAgente.getY());
                }
                else if (Arriba2==5){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX()-2, posicionAgente.getY());
                }
                else if (Abajo1==5){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX()+1, posicionAgente.getY());
                }
                else if (Abajo2==5){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX()+2, posicionAgente.getY());
                }
                else if (Derecha1==5){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX(), posicionAgente.getY()+1);
                }
                else if (Derecha2==5){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX(), posicionAgente.getY()+2);
                }
                else if (Izquierda1==5){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX(), posicionAgente.getY()-1);
                }
                else if (Izquierda2==5){
                    //posicionAuxRecurso=getposrecurso(posicionAgente.getX(), posicionAgente.getY()-2);
                }
                acciones(Arriba1,Abajo1,Derecha1,Izquierda1,Arriba2,Abajo2,Derecha2,Izquierda2);
            }
            else{
                if (Arriba2==5){
                    if (Arriba1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1,posicionAgente.getY());
                    }
                }
                else if (Abajo2==5){
                    if (Abajo1==0){
                        posicionAgente.setLocation(posicionAgente.getX()+1,posicionAgente.getY());
                    }
                }
                else if (Derecha2==5){
                    if (Derecha1==0){
                        posicionAgente.setLocation(posicionAgente.getX()-1,posicionAgente.getY()+1);
                    }
                }
                else if (Izquierda2==5){
                    if (Izquierda1==0){
                        posicionAgente.setLocation(posicionAgente.getX(),posicionAgente.getY()-1);
                    } 
                }
            }
        }
        
    }
}