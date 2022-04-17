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
        boolean flag = true;
        posicion[0]=punto;
        posicion[1]=new Point(x, y+1);
        posicion[2]=new Point(x+1,y);
        posicion[3]=new Point(x+1,y+1);

    }
}
