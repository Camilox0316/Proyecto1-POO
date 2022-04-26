import java.awt.Point;

public class Mapa {
    int filasColumnas=50;
    int cantidadObjetos;
    Objeto listaObjetos[];
    int cantidadAgentes;
    AgenteBase listaAgenteBase[];
    Point listaPuntos[];
    int indiceListaPuntos=0; //Esto es para agregar las posiciones de los Objetos totalmente en orden, sus 4 puntos de manera seguida
    //0 -> 74
    public Mapa(){
        this.cantidadObjetos = 15;
        listaObjetos = new Objeto[cantidadObjetos];
        this.cantidadAgentes = 15;//generarNumRandom(50, 40);
        listaAgenteBase = new AgenteBase[cantidadAgentes];
        listaPuntos = new Point[(cantidadObjetos*4)+cantidadAgentes];
        inicializacion();
        
    }

    public void inicializacion(){
        inicializarListaPuntos();
        inicializarListaObjetos();
        inicializarListaAgentes();
        imprimirPuntos();
    }

    public Point generarPuntoRandom(){
        Point punto = new Point(generarNumRandom(48, 2), generarNumRandom(48, 2));
        return punto;
    }

    public Point generarPtoRandomNoEncontrado(){
        Point punto;
        do {
            punto = generarPuntoRandom();
        } while (encontrarPunto(punto, listaPuntos));
        return punto;
    }

    public Point[] generarPtsAdyNoEncontrado(){
        Point punto;
        Point ptsAdyacentes[] = new Point[4];

        do {
            punto = generarPuntoRandom();
            ptsAdyacentes=crearPuntosAdyacentes(punto);
        } while (encontrarPuntos(ptsAdyacentes));

        return ptsAdyacentes;
    }

    public int generarNumRandom(int plimite, int pminimo){
        return (int) (Math.random()*(plimite-pminimo) + pminimo);
    }

    public void inicializarListaPuntos(){
        for (int i=0;i<listaPuntos.length;i++){
            listaPuntos[i] = new Point(-1,-1);
        }
    }

    //                                  Métodos para inicializar lista Agentes
    public boolean encontrarPunto(Point puntoBuscado, Point plistaPuntos[]){ //Es para los agentes
        for (Point punto : plistaPuntos) {
            if (punto.equals(puntoBuscado))
            return true;
        }
        return false;
    }

    public void agregarPunto(Point ppuntoAgregar, int pindice, boolean pflag){ //Se utiliza para los Agentes
        listaPuntos[pindice] = ppuntoAgregar;
        if (pflag) {indiceListaPuntos++;}
    }
    public Point crearAgregarPt(){
        Point punto = generarPtoRandomNoEncontrado();
        agregarPunto(punto, indiceListaPuntos, true);
        return punto;
    }

    public void inicializarListaAgentes(){
        Point punto;
        int aleatorio;
        for (int i=0;i<listaAgenteBase.length;i++) {
            punto = crearAgregarPt();
            aleatorio = generarNumRandom(2, 0);
            if (aleatorio==1) listaAgenteBase[i] = new Recolector(punto);
            else listaAgenteBase[i] = new Defensor(punto);
        }
    }
    //                                                     Métodos para inicializar la lista de Objetos

    public boolean encontrarPuntos(Point puntosAdyacentes[]){ //Es para los objetos
        for (int i=0;i<listaPuntos.length;i++){
            if (encontrarPunto(listaPuntos[i], puntosAdyacentes)){
                return true;}
        }
        return false;
    }

    public void agregarPuntosAdyacentes(Point puntosAdyacentes[], int pindice, boolean pflag){ // Se utiliza para los Objetos
        for (int i=0;i<4;i++){
            listaPuntos[pindice++]=puntosAdyacentes[i];
            if (pflag){this.indiceListaPuntos++;}
            
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
    
    public Point[] crearAgregrarPtsAdyacentes(){
        Point puntosAdyacentes[] = new Point[4]; 
        do {
            puntosAdyacentes = crearPuntosAdyacentes(generarPuntoRandom());
        } while (encontrarPuntos(puntosAdyacentes));
        agregarPuntosAdyacentes(puntosAdyacentes, indiceListaPuntos, true);
        return puntosAdyacentes;
    }

    public void inicializarListaObjetos(){
        Point puntosAdyacentes[]; 
        for (int i=0;i<cantidadObjetos;i++){         
            puntosAdyacentes = crearAgregrarPtsAdyacentes();
            if (i<5) {
                listaObjetos[i] = new Recurso(puntosAdyacentes[0]);
            }
            else if (i>=5 && i<10) {    
                listaObjetos[i]= new Amenaza(puntosAdyacentes[0]);
            }
            else {
                listaObjetos[i] = new Obstaculo(puntosAdyacentes[0]);
            }
        }
    }
    
    public int reemplazarPunto(Point ppuntoBusc, Point ppuntoreemplazo){
        for (int i = 0; i < listaPuntos.length; i++) {
            if (listaPuntos[i].equals(ppuntoBusc)){
                agregarPunto(ppuntoreemplazo, i, false);
                return i;
            }
        }
        return -1;
    }

    public int reemplazarPuntos(Point puntosAdyacentesBus[], Point ppuntosAdyReemplazo[]){
        for (int i = 0; i < listaPuntos.length; i++) {
            if (listaPuntos[i].equals(puntosAdyacentesBus[0])){
                for (int j=0;j<4;j++){
                    agregarPunto(ppuntosAdyReemplazo[j], i+j, false);
                }
                return i;
            }
        }
        return -1;
    }

    public int getIDObjetos(int fila, int columna){
        //0= esapcio disponible - 1=amenaza - 2=Recurso - 3=agenteALterado - 4=agenteRecolectando - 5=agenteEntregando - 6=obstaculo 8 fuera de rango
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
           if (listaAgenteBase[i].posicionAgente.equals(punto)){
               return listaAgenteBase[i].retornarEstadoInt();
           }
       }
       return 0;
    }

    public void juegoAgentes(){
        System.out.println("Se recorren los agentes");
    }

    public void juegoObjetos(){
        for (int i=0;i<cantidadObjetos;i++){
            if (listaObjetos[i].vida <=0){
                Point puntosAdyacentes[] = generarPtsAdyNoEncontrado();
                reemplazarPuntos(listaObjetos[i].posicion, puntosAdyacentes);
                listaObjetos[i].asignarVida();
                listaObjetos[i].cambiarPosicion(puntosAdyacentes[0]);}
                if (listaObjetos[i].retornarClaseInt() == 1){
                    listaObjetos[i].reducirVida();
                    System.out.println("La vida del objeto: "+i+"  ="+listaObjetos[i].vida);}
        }
    }
        
    public int getID(double fila, double columna){
        int agente=getIDAgentes((int) fila,(int) columna);
        int objeto=getIDObjetos((int)fila, (int)columna);
        if (agente!=0) return agente;
        else if (objeto!=0) return objeto;
        return 0;
    }

    public Point getPosAuxiliar(double fila, double columna){
        Point punto = new Point((int)fila, (int) columna);
        int i;
        for (i=0; i<listaAgenteBase.length;i++){
            if (listaAgenteBase[i].posicionAgente.equals(punto)){
                if (listaAgenteBase[i].retornarEstadoInt()==3){
                    return listaAgenteBase[i].posicionAuxAmenaza;
                }
                break;
            }
        }
        return listaAgenteBase[i].posicionAuxRecurso;
    }

    public void imprimirPuntos(){
        System.out.println("Impriemiendo puntos: ");
        for (int i=0;i<listaPuntos.length;i++){
            System.out.println("Iteracion: "+i);
            System.out.println(listaPuntos[i].getX()+", "+listaPuntos[i].getY());
        }
    }
}
