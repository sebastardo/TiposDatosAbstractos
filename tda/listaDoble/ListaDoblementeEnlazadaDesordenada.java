package tda.listaDoble;

import tda.nodoDoble.Nodo;

/**
 * Lista doblemente enlazada sin orden.
 * Una lista doblemente enlazada es una lista lineal en la que cada nodo tiene dos enlaces,
 *  uno al nodo siguiente, y otro al anterior.
 * Las listas doblemente enlazadas no necesitan un nodo especial para acceder a ellas, pueden
 *  recorrerse en ambos sentidos a partir de cualquier nodo, esto es porque a partir de cualquier
 *  nodo, siempre es posible alcanzar cualquier nodo de la lista, hasta que se llega a uno de los extremos.
 * Utiliza nodo doble.
 * @author Sebastian Rossi
 * Añadir elementos.
 * Buscar elementos.
 * Borrar elementos.
 * Mostrar la lista desde el principio o desde el final.
 * Informa si la lista esta o no vacia.
 * Esta lista no tiene orden y fue hecha para probar funcionalidades, puede ser util.
 */

public class ListaDoblementeEnlazadaDesordenada {

    private Nodo listaD;

    /**
     * Constructor que inicializa la lista
     */
    public ListaDoblementeEnlazadaDesordenada() {
        listaD=null;
    }

    /**
     * Metodo que comprueba si esta o no vacia
     * @return true si esta vacia
     */
    public boolean vacia(){
        return listaD==null;
    }


    /**
     * Metodo para insertar dato sin importar donde
     * @param dato pasa la informacion a guardar
     */
    public void insertar(Object dato){
        Nodo nuevo = new Nodo(dato);

        if(listaD==null){
            listaD=nuevo;
        }else {
            nuevo.siguiente=listaD.siguiente;
            if(listaD.siguiente!=null)
                listaD.siguiente.anterior=nuevo;
            nuevo.anterior=listaD;
            listaD.siguiente=nuevo;
        }
    }

    /**
     * Recorre la lista y muestra su contenido.
     * Para mostrar los datos, debe ir al principio de la lista y de ahi llegara al final,
     * donde quedara el puntero de la lista y de ahi se trabajar para otras cosas,
     * se puede utilizar dos punteros, uno para comienzo y otro para final,
     * los cuales siempre estaran fijos, pero no es en este caso.
     * @param comienzo si es true, va desde el principio
     */
    public void recorrer(boolean comienzo){
        if(listaD!=null) {
            if(comienzo) {
                while (listaD.anterior != null)
                    listaD = listaD.anterior;

                while (listaD.siguiente != null) {
                    System.out.println(listaD.dato.toString());
                    listaD = listaD.siguiente;
                }

                System.out.println(listaD.dato.toString());
            }else{
                while (listaD.siguiente != null)
                    listaD = listaD.siguiente;

                while (listaD.anterior != null) {
                    System.out.println(listaD.dato.toString());
                    listaD = listaD.anterior;
                }
                System.out.println(listaD.dato.toString());
            }
        }
        else
            System.out.println("Vacia");
    }


    /**
     * Metodo para buscar un dato en un nodo.
     * Para ser mas especifico, se debe modificar el metodo "comparar".
     * El puntero de lista queda en donde se encontro el dato.
     * @param dato informacion que sirve para comparar.
     * @return el dato encontrado o un null si no encuentra lo que se le paso.
     */
    public Object buscar(Object dato){
        if(listaD==null)
            return null;

        Nodo busqueda = listaD;

        while(listaD!=null){
            if(comparar(listaD.dato, dato))
                return listaD.dato;
            listaD=listaD.anterior;
        }

        listaD = busqueda.siguiente;
        while(listaD!=null){
            if(comparar(listaD.dato,dato))
                return listaD.dato;
            listaD=listaD.siguiente;
        }

        return null;
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
}
