public class Defensor extends AgenteBase{
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

            }
            else{
                estado="buscando";
            }
        }
    }
    public void ejecutar(){
        deteccion();
        atacar();
    }
}
