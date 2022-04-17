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
        inicializarListaObjetos();
    }
    public void inicializarListaObjetos(){
        for (int i=0;i<cantidadObjetos;i++){
            Point punto;
            do {
                punto = new Point(generarNumRandom(49, 0), generarNumRandom(49, 0)); listaPuntos[i] = punto; 
            } while (encontrarPunto(punto) == false); //Se mantiene el ciclo mientras el punto recien hecho sea diferente de los demás

            if (i<5) listaObjetos[i] = new Recurso(punto, filasColumnas-1);
            else{
                if (i>=5 && i<10) listaObjetos[i]= new Amenaza(punto, filasColumnas-1);
                else listaObjetos[i] = new Obstaculo(punto, filasColumnas-1);
            }
        }
    }

    public boolean encontrarPunto(Point punto){
        for (int i=0;i<listaPuntos.length;i++){
            if (listaPuntos[i].equals(punto)) {
            return true;}
        }
        return false;
    }
    public int generarNumRandom(int pmaximo, int pminimo){
        return (int) (Math.random()*(pmaximo-pminimo) + pminimo);
    }

}
