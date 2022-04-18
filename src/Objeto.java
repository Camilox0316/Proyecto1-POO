import java.awt.Point;
import java.awt.Color;
public  class Objeto {
    int vida;
    Point posicion[];
    Color color;
    public  void reducirVida(){
        vida--;
    }
    public  void asignarPos(Point punto, int pborde){
        posicion = new Point[4];
        int x = (int) punto.getX();
        int y = (int) punto.getY();
        posicion[0]=punto;
        posicion[1]=new Point(x, y+1); // se crea uno a la derecha del origen
        posicion[2]=new Point(x+1,y); // se crea uno abajo del origen
        posicion[3]=new Point(x+1,y+1); // se crea uno a la derecha y abajo del origen (digonal)

    }
}
