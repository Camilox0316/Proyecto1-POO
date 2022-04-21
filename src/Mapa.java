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
        listaPuntos = new Point[(cantidadObjetos+cantidadAgentes)*4];
        juego();
    }

    public void juego(){
        inicializarListaPuntos();
        inicializarListaObjetos();
        //imprimirPuntos();
    }
    public void inicializarListaPuntos(){
        for (int i=0;i<listaPuntos.length;i++){
            listaPuntos[i] = new Point(-1,-1);
        }
    }

    public void inicializarListaObjetos(){
        Point puntosAdyacentes[] = new Point[4];
        Point punto;
        for (int i=0;i<cantidadObjetos;i++){ 
            do {
                
                punto = new Point(generarNumRandom(48, 1), generarNumRandom(48, 1)); 
                puntosAdyacentes = crearPuntosAdyacentes(punto, puntosAdyacentes);

            } while (encontrarPunto(puntosAdyacentes)); //Se mantiene el ciclo mientras el punto recien hecho sea diferente a los demás
            agregarPuntosAdyacentes(i, puntosAdyacentes);
            
            if (i<5) {
                listaObjetos[i] = new Recurso(puntosAdyacentes, filasColumnas-1);
            }
            else if (i>=5 && i<10) {    
                listaObjetos[i]= new Amenaza(puntosAdyacentes, filasColumnas-1);
            }
            else {
                listaObjetos[i] = new Obstaculo(puntosAdyacentes, filasColumnas-1);
            }
        }
    }

    public boolean encontrarPunto(Point puntosAdyacentes[]){
        for (int i=0;i<listaPuntos.length;i++){
            for (int j=0;j<4;j++){
                if (listaPuntos[i].equals(puntosAdyacentes[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void agregarPuntosAdyacentes(int index, Point puntosAdyacentes[]){
        int multiplo = 0;
        for (int i=0;i<4;i++){
            listaPuntos[index+multiplo] = puntosAdyacentes[i];
            multiplo += 4;
        }
    }
    public Point[] crearPuntosAdyacentes(Point punto, Point puntosAdyacentes[]){
        int coordenadasX[] = {0,1,1}, coordenadasY[] = {1,0,1};
        int x = (int) (punto.getX());
        int y = (int) (punto.getY());
        puntosAdyacentes[0] = punto;
        for (int i = 1; i<4;i++){
            puntosAdyacentes[i] = new Point (coordenadasX[i-1]+x, coordenadasY[i-1]+y);
        }
        return puntosAdyacentes;
    }


    public int generarNumRandom(int plimite, int pminimo){
        return (int) (Math.random()*(plimite-pminimo) + pminimo);
    }
    
    public int getIDObjetos(int fila, int columna){
        //1=amenaza - 2=Recurso - 3=agenteALterado - 4=agenteRecolectando - 5=agenteEntregando - 6=obstaculo
        Point punto = new Point(fila, columna);
        for (int i=0; i<listaObjetos.length;i++){
            Objeto objetoActu = listaObjetos[i];
            for (int j=0;j<4;j++){
                if (objetoActu.posicion[j].equals(punto)) 
                return objetoActu.retornarClaseInt();
            }
        }
        return 0;
    }
     public int getIDAgentes(int fila, int columna){
        Point punto = new Point(fila, columna);
        for (int i=0; i<listaAgenteBase.length;i++){
            
        }
        return 0;
     }

    public void imprimirPuntos(){
        System.out.println("Impriemiendo puntos: ");
        for (int i=0;i<listaPuntos.length;i++){
            System.out.println("Iteracion: "+i);
            System.out.println(listaPuntos[i].getX()+", "+listaPuntos[i].getY());
        }
    }
}
