import java.awt.Point;

public class Mapa {
    int filasColumnas=50;
    int cantidadObjetos;
    Objeto listaObjetos[];
    int cantidadAgentes;
    AgenteBase listaAgenteBase[];
    Point listaPuntos[];
    public Mapa(){
        this.cantidadObjetos = 15;
        listaObjetos = new Objeto[cantidadObjetos];
        this.cantidadAgentes = generarNumRandom(50, 40);
        listaAgenteBase = new AgenteBase[cantidadAgentes];
        listaPuntos = new Point[cantidadObjetos+cantidadAgentes];
        juego();
    }
    public void juego(){
        inicializarListaPuntos();
        inicializarListaObjetos();
    }
    public void inicializarListaPuntos(){
        for (int i=0;i<listaPuntos.length;i++){
            listaPuntos[i] = new Point(-1,-1);
        }
    }
    public void inicializarListaObjetos(){
        for (int i=0;i<cantidadObjetos;i++){
            Point punto;
            do {
                punto = new Point(generarNumRandom(49, 1), generarNumRandom(49, 1)); 
            } while (encontrarPunto(punto)); //Se mantiene el ciclo mientras el punto recien hecho sea diferente a los demás
            listaPuntos[i] = punto; 
            if (i<5) listaObjetos[i] = new Recurso(punto, filasColumnas-1);
            else{
                if (i>=5 && i<10) listaObjetos[i]= new Amenaza(punto, filasColumnas-1);
                else listaObjetos[i] = new Obstaculo(punto, filasColumnas-1);
            }
        }
    }

    public boolean encontrarPunto(Point punto){
        int x, y, coordenadasX[] = {0,1,1}, coordenadasY[] = {1,0,1};
        Point posiblesPuntos[] = new Point[3];
        for (int i=0;i<listaPuntos.length;i++){
            System.out.println("Elemento lista: "+listaPuntos[i].getX() +", "+listaPuntos[i].getY()+ " = Punto a buscar: "+punto.getX()+", "+punto.getY());
            if (listaPuntos[i].equals(punto)) {
                System.out.println(listaPuntos[i].equals(punto));
                return true;}
            x = (int) (punto.getX());  
            y = (int) (punto.getY());

            for (int j=0;j<3;j++){
                posiblesPuntos[j] = new Point(x+coordenadasX[j], y+coordenadasY[j]);
                if (posiblesPuntos[j].equals(punto)) return true;
            } 

        }
        System.out.println("false");
        return false;
    }
    public int generarNumRandom(int pmaximo, int pminimo){
        return (int) (Math.random()*(pmaximo-pminimo) + pminimo);
    }
    
}
