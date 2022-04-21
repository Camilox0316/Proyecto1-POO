public class Recolector extends AgenteBase{
    public void huir(){
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
    }
}
