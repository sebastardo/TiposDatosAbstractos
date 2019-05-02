package tda.lista;
import tda.nodoSimple.Nodo;

/**
 * Lista.
 * Utiliza el nodo simple.
 * @author Sebastian Rossi
 */

public class Lista {

    private boolean orden;
    private int tamanio;
    //puntero de la lista
    private Nodo lista;


    /**
     * Constructor para crear lista.
     */
    public Lista() {
        lista = null;
        orden = true;
        tamanio=0;
    }

    /**
     * Comprobador de lista si esta vacia.
     * @return true si esta vacia.
     */
    public boolean vacia(){
        return lista == null;
    }


    /**
     * Metodo para insertar nodo al inicio de la lista.
     * @param dato objeto que se guardara en el nodo.
     */
    public void insertarAlInicio(Object dato){
        Nodo nuevo = new Nodo(dato);
        if(lista==null) {
            lista = nuevo;
            orden=true;
        }
        else {
            nuevo.siguiente = lista;
            lista = nuevo;
            orden=false;
        }
        tamanio++;

    }


    /**
     * Metodo para insertar nodo al final de la lista.
     * @param dato objeto que se guardara en el nodo.
     */
    public void insertarAlFinal(Object dato){
        Nodo nuevo = new Nodo(dato);
        if(lista==null) {
            lista = nuevo;
            orden=true;
        }
        else {
            Nodo aux = lista;
            while (aux.siguiente != null) {
                aux=aux.siguiente;
            }
            aux.siguiente=nuevo;
            orden=false;
        }
        tamanio++;
    }


    /**
     * Recorre la lista y muestra su contenido.
     */
    public void recorrer(){
        Nodo aux = lista;
        while(aux!=null){
            System.out.println(aux.dato.toString());
            aux=aux.siguiente;
        }
    }

    /**
     * Metodo para buscar un dato en un nodo.
     * Para ser mas especifico, se debe modificar el metodo "comparar".
     * @param dato informacion que sirve para comparar.
     * @return el dato encontrado o un null si no encuentra lo que se le paso.
     */
    public Object buscar(Object dato){
        Nodo aux= lista;
        while(aux!=null){
            if(comparar(aux.dato, dato))
                return aux.dato;
            aux=aux.siguiente;
        }
        return null;
    }

    /**
     * Metodo ordenador de menor a mayor.
     */
    public void ordenar(){
       boolean marca = true;
       if(lista!=null){
           while(marca){
               Nodo a=lista;
               marca = false;
               while(a.siguiente!=null) {
                   if (mayorMenorIgual(a.dato, a.siguiente.dato) > 0) {
                       Object aux = a.dato;
                       a.dato = a.siguiente.dato;
                       a.siguiente.dato = aux;
                       marca = true;
                   }
                   a = a.siguiente;
               }
           }
       }
       orden=true;
    }


    /**
     * Elimina nodo de la lista.
     * @param dato objeto a comparar.
     * @return true si lo elimino.
     */
    public boolean eliminar(Object dato){
        Nodo aux;

        //Borra el primero
        if(comparar(lista.dato,dato)){
            aux=lista;
            lista=lista.siguiente;
            aux=null;
            tamanio--;
            return true;
        }

        Nodo listaAux=lista;

        //Borra los demas
        while(listaAux.siguiente!=null){
            if(comparar(listaAux.siguiente.dato,dato)){
                aux=listaAux.siguiente;
                listaAux.siguiente=aux.siguiente;
                aux=null;
                tamanio--;
                return true;
            }
            listaAux=listaAux.siguiente;
        }
        return false;
    }

    /**
     * Metodo para ingresar un dato y que la lista quede ordenada.
     * @param dato informacion a ingresar a la lista
     * @return true si la ingreso, false si no esta ordenada de ante mano. Acepta repetidos.
     */
    public boolean insertarEnOrden(Object dato){
        if(!orden)
            return false;

        Nodo nuevo;

        //si la lista esta vacia, entra aca
        if(lista==null){
            nuevo= new Nodo(dato);
            lista=nuevo;
            tamanio++;
            orden=true;
            return true;
        }

        //si es mas chico que el primero, entra aca
        if(mayorMenorIgual(lista.dato,dato)>0){
            nuevo= new Nodo(dato);
            nuevo.siguiente=lista;
            lista=nuevo;
            tamanio++;
            orden=true;
            return true;
        }


        Nodo listaAux = lista; //para no cambiar el puntero de la lista se usa una auxiliar

        Nodo aux = null;

        nuevo= new Nodo(dato);

        while(mayorMenorIgual(listaAux.dato,dato)<0){
            if(listaAux.siguiente!=null) {
                aux = listaAux; //guarda el actual para usarlo como anterior y no cortar la cadena
                listaAux = listaAux.siguiente;
            }
            else{
                //si es mas grande que todos los elementos, entra aca
                listaAux.siguiente=nuevo;
                tamanio++;
                orden=true;
                return true;
            }
        }

        //si hay elementos mas chicos y tambien mas grandes, entra aca
        aux.siguiente=nuevo;
        nuevo.siguiente=listaAux;
        tamanio++;
        orden=true;
        return true;

    }


    /**
     * Metodo para ingresar un dato y que la lista quede ordenada, pero no permite ingresar datos que ya estan
     * @param dato informacion a ingresar a la lista
     * @return true si la ingreso, false si no esta ordenada de ante mano, o el dato esta ya en la lista (no acepta repetidos)
     */
    public boolean insertarEnOrdenSinRepetidos(Object dato){
        if(!orden)
            return false;

        Nodo nuevo;

        //si la lista esta vacia, entra aca
        if(lista==null){
            nuevo= new Nodo(dato);
            lista=nuevo;
            tamanio++;
            orden=true;
            return true;
        }

        //si es mas chico que el primero, entra aca
        if(mayorMenorIgual(lista.dato,dato)>0){
            nuevo= new Nodo(dato);
            nuevo.siguiente=lista;
            lista=nuevo;
            tamanio++;
            orden=true;
            return true;
        }


        Nodo listaAux = lista; //para no cambiar el puntero de la lista se usa una auxiliar

        Nodo aux = null;

        nuevo= new Nodo(dato);

        while(mayorMenorIgual(listaAux.dato,dato)<0){

            if(listaAux.siguiente!=null) {
                aux = listaAux; //guarda el actual para usarlo como anterior y no cortar la cadena
                listaAux = listaAux.siguiente;
            }
            else{
                //si es mas grande que todos los elementos, entra aca
                listaAux.siguiente=nuevo;
                tamanio++;
                orden=true;
                return true;
            }
        }

        //si ya esta en la lista, entra aca, no inserta y sale
        if(mayorMenorIgual(listaAux.dato,dato)==0)
            return false;


        //si hay elementos mas chicos y tambien mas grandes, entra aca
        aux.siguiente=nuevo;
        nuevo.siguiente=listaAux;
        tamanio++;
        orden=true;
        return true;

    }

    /**
     * Metodo para llamar al metodo privado para recorrer la lista desde atras hacia adelante sin
     *  acceder al nodo.
     */
    public void recorrerAlReves(){

        desdeAtras(lista);
    }

    /**
     * Imprimir de atras hacia adelante.
     * Va hacia el final e imprime de atras adelante. Privado para que no tener acceso al nodo desde afuera.
     * @param l nodo de la lista.
     */
    private void desdeAtras(Nodo l){
        if(l.siguiente==null){
            System.out.println(l.dato.toString());
        } else {
            desdeAtras(l.siguiente);
            System.out.println(l.dato.toString());
        }
    }
    
    /**
     * Metodo para sacar datos de la lista.
     * Deveuelve el primer dato de la lista y lo elimina. A diferencia del metodo eliminar, este no busca dato.
     * @return
     */
    public Object sacar(){
        if(lista==null)
            return null;
        Nodo aux = lista;
        lista = lista.siguiente;
        return aux.dato;
    }


    /**
     * Metodo para comparar si dos objetos son iguales.
     * Se usa para no tener que tocar las funciones de la lista y editar esto.
     * @param uno primero objeto
     * @param dos segundo obejto
     * @return true si son iguales
     */
    private boolean comparar(Object uno, Object dos) {
        return uno.equals(dos);
    }


    /**
     * Metodo que informa que dato es mayor, menor o igual
     * @param uno dato 1
     * @param dos dato 2
     * @return 1 => uno>dos
     *         -1 => dos>uno
     *         0 => iguales
     */
    private int mayorMenorIgual(Object uno, Object dos){
        //esto se edita segun el objeto, en esta caso es INTEGER, asi que esto alcanza
        return (Integer)uno  - (Integer)dos;
    }

    /*
    TODO:
      public boolean insertarEnUbicacion(Object dato, int ubicacion)
      para esto esta el atributo "tamanio"
     */

    /*
    Sin implementar:
    public void vaciar(); // vacia la lista
    public boolean llena(); // si no hay memoria, no ingresa mas
    public grabar(String nombreArchivo); // graba la lista en un archivo
     */

    public boolean isOrden() {
        return orden;
    }

    /**
     * Conocer el tamaño de la lista.
     * @return la cantidad de nodos insertados.
     */
    public int getTamanio() {
        return tamanio;
    }

}
