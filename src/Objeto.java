import java.awt.Point;
import java.awt.Color;
public  class Objeto {
    int vida;
    Point posicion[];
    Color color;
    public char[] getClass;
    public char[] retornarClaseInt;

    public  void reducirVida(){
        vida--;
    }

    public  void asignarPos(Point punto){
        posicion = new Point[4];
        int coordenadasX[] = {0,1,1}, coordenadasY[] = {1,0,1};
        int x = (int) (punto.getX());
        int y = (int) (punto.getY());
        posicion[0] = punto;
        for (int i = 1; i<4;i++){
            posicion[i] = new Point (coordenadasX[i-1]+x, coordenadasY[i-1]+y);
        }
    }

    public void cambiarPosicion(Point ppunto){
        posicion = new Point[4];
        int coordenadasX[] = {0,1,1}, coordenadasY[] = {1,0,1};
        int x = (int) (ppunto.getX());
        int y = (int) (ppunto.getY());
        posicion[0] = ppunto;
        for (int i = 1; i<4;i++){
            posicion[i] = new Point (coordenadasX[i-1]+x, coordenadasY[i-1]+y);
        }
    }
    public void asignarVida(){
        vida = 10;
    }
    private String retornarClase(){
        return this.getClass().getSimpleName();
    }
    
    public int retornarClaseInt(){
        String nombre = retornarClase();
        if (nombre == "Amenaza") 
            return 1;
        else if (nombre == "Recurso")
            return 2;
        return 6;
    }
}

