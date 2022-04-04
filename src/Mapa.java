import java.awt.Point;
public class Mapa {
    int filasColumnas = 50;
    int cantidadObjetos;
    Objeto listaObjetos[];
    int cantidadAgentes;
    AgenteBase listaAgenteBase[];
    Point listaPuntos[];

    public Mapa(){
        this.cantidadObjetos = generarNumRandom(50,40);
        listaObjetos = new Objeto[cantidadObjetos];
        this.cantidadAgentes = generarNumRandom(50,40);
        listaAgenteBase = new AgenteBase[cantidadAgentes];
        listaPuntos = new Point[cantidadObjetos+cantidadAgentes];
    }

    public void inicializarListaObjetos(){
        for (int i=0;i<cantidadAgentes;i++){
            Point punto = new Point();

        }
        

    }
    public int generarNumRandom(int pmaximo, int pminimo){
        return (int) Math.random()*pmaximo+pminimo;
    }
}
