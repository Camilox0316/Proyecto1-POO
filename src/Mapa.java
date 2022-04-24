import java.awt.Point;

public class Mapa {
    int filasColumnas=50;
    int cantidadObjetos;
    Objeto listaObjetos[];
    int cantidadAgentes;
    AgenteBase listaAgenteBase[];
    Point listaPuntos[];
    int indiceListaPuntos=0;

    public Mapa(){
        this.cantidadObjetos = 15;
        listaObjetos = new Objeto[cantidadObjetos];
        this.cantidadAgentes = 5;//generarNumRandom(50, 40);
        listaAgenteBase = new AgenteBase[cantidadAgentes];
        listaPuntos = new Point[(cantidadObjetos+cantidadAgentes)*4];
        juego();
        
    }

    public void juego(){
        inicializarListaPuntos();
        inicializarListaObjetos();
        inicializarListaAgentes();
        //imprimirPuntos();
    }
    public void inicializarListaPuntos(){
        for (int i=0;i<listaPuntos.length;i++){
            listaPuntos[i] = new Point(-1,-1);
        }
    }

    public void inicializarListaObjetos(){
        Point puntosAdyacentes[]; 
        for (int i=0;i<cantidadObjetos;i++){ 
            do {
                
                puntosAdyacentes = crearPuntosAdyacentes(generarPuntoRandom());

            } while (encontrarPuntos(puntosAdyacentes)); //Se mantiene el ciclo mientras los puntos recien hechos sean diferentes a los demás
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

    public void inicializarListaAgentes(){
        Point punto;
        int aleatorio;
        for (int i=0;i<listaAgenteBase.length;i++) {
            do {
                punto = generarPuntoRandom();
            } while (encontrarPunto(punto));
            agregarPunto(punto);
            aleatorio = generarNumRandom(2, 0);
            if (aleatorio==1) listaAgenteBase[i] = new Recolector(punto);
            else listaAgenteBase[i] = new Defensor(punto);
        }
    }

    public Point generarPuntoRandom(){
        Point punto = new Point(generarNumRandom(48, 1), generarNumRandom(48, 1));
        return punto;
    }
    public boolean encontrarPunto(Point puntoBuscado){
        for (Point punto : listaPuntos) {
            if (punto.equals(puntoBuscado))
            return true;
        }
        return false;
    }
    public boolean encontrarPuntos(Point puntosAdyacentes[]){
        for (int i=0;i<listaPuntos.length;i++){
            for (int j=0;j<4;j++){
                if (listaPuntos[i].equals(puntosAdyacentes[j])) {
                    System.out.println(true);
                    return true;
                }
            }
        }
        return false;
    }

    public void agregarPunto(Point ppuntoAgregar){ //Se utiliza para los Agentes
        listaPuntos[indiceListaPuntos] = ppuntoAgregar;
    }

    public void agregarPuntosAdyacentes(int index, Point puntosAdyacentes[]){ // Se utiliza para los Objetos
        for (int i=0;i<4;i++){
            listaPuntos[this.indiceListaPuntos]=puntosAdyacentes[i];
            this.indiceListaPuntos++;
        }
    }
    
    public Point[] crearPuntosAdyacentes(Point punto){
        int coordenadasX[] = {0,0,1,1}, coordenadasY[] = {0,1,0,1};
        int x = (int) (punto.getX()),  y = (int) (punto.getY());
        Point puntosAdyacentes[] = new Point[4];
        for (int i = 0; i<4;i++){
            puntosAdyacentes[i] = new Point (coordenadasX[i]+x, coordenadasY[i]+y);
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
            if (listaAgenteBase[i].equals(punto)){
                return listaAgenteBase[i].retornarEstadoInt();
            }
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
