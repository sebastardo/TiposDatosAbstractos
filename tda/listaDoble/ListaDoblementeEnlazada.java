package tda.listaDoble;

import tda.nodoDoble.Nodo;

/**
 * Lista doblemente enlazada ordenada.
 * Una lista doblemente enlazada es una lista lineal en la que cada nodo tiene dos enlaces,
 *  uno al nodo siguiente, y otro al anterior.
 * Las listas doblemente enlazadas no necesitan un nodo especial para acceder a ellas, pueden
 *  recorrerse en ambos sentidos a partir de cualquier nodo, esto es porque a partir de cualquier
 *  nodo, siempre es posible alcanzar cualquier nodo de la lista, hasta que se llega a uno de los extremos.
 * Los elementos siempre se ingresan en orden y no hace falta ordenarlos.
 * Utiliza nodo doble.
 * @author Sebastian Rossi
 * Añadir elementos.
 * Buscar elementos.
 * Borrar elementos.
 * Mostrar la lista desde el principio o desde el final (dos metodos para simpleza en la usabilidad)
 *
 */

public class ListaDoblementeEnlazada {
    private Nodo listaD;

    public ListaDoblementeEnlazada() {
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
     * Metodo que añade elementos a la lista.
     * Desde donde este el cabezal listaD se mueve por la lista hasta encontrar donde encaja el dato
     *  ya sea por mayor o menor.
     * No añade repetidos, mas que nada porque no quiero. En caso de tener que hacerlo,
     *  se agrega una variable boolean marca se pasa por el primer while, se pone el if(estad0 <=0),
     *  se ingresa el dato, se cambia la marca y se sale del loop.
     * @param dato
     * @return ture si lo inserto, false si es dato repetido
     */
    public boolean insertar(Object dato){
        Nodo nuevo = new Nodo(dato);

        if(listaD==null){
            listaD = nuevo;
            return true;
        }
        else{
            boolean mayor = false;
            boolean menor = false;
            int estado = (mayorMenorIgual(listaD.dato,dato));

            while(estado != 0){

                if(estado<0){

                    if(menor || listaD.siguiente==null){

                        nuevo.siguiente = listaD.siguiente;
                        if(listaD.siguiente!=null)
                            listaD.siguiente.anterior=nuevo;
                        nuevo.anterior=listaD;
                        listaD.siguiente=nuevo;

                        return true;
                    }else{
                        listaD=listaD.siguiente;
                        mayor=true;
                    }

                }else{

                    if(mayor || listaD.anterior==null){

                        nuevo.anterior = listaD.anterior;
                        if(listaD.anterior!=null)
                            listaD.anterior.siguiente=nuevo;
                        nuevo.siguiente=listaD;
                        listaD.anterior=nuevo;

                        return true;
                    }else{

                        listaD=listaD.anterior;
                        menor=true;
                    }

                }
                estado = (mayorMenorIgual(listaD.dato,dato));
            }
            return false;
        }
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

        Nodo aux = listaD;

        while(aux!=null){
            if(comparar(aux.dato, dato))
                return aux.dato;
            aux=aux.anterior;
        }

        aux = listaD.siguiente;
        while(aux!=null){
            if(comparar(aux.dato,dato))
                return aux.dato;
            aux=aux.siguiente;
        }
        return null;
    }


    /**
     * Metodo para borrar nodos.
     *
     * @param dato que tiene en nodo a ser borrado
     * @return true si borro el nodo deonde esta el dato, false si el dato no esta en la lista
     */
    public boolean borrar(Object dato) {
        if(listaD==null)
            return false;

        Nodo aux = null; //auxiliar para posicionar la lista despues de borrado el nodo
        int movimientos=mayorMenorIgual(listaD.dato, dato); // se usa para donde se movera la lista para buscar
        boolean comparacion; //compara si es el mismo dato que tiene el nodo



        if(movimientos>0) {
            //se mueve a la izquierda de la lista
            comparacion = comparar(listaD.dato, dato);
            while (!comparacion && listaD.anterior != null) {
                listaD = listaD.anterior;
                comparacion = comparar(listaD.dato, dato);
            }
        }else{
            if(movimientos<0) {
                // se mueve a la derecha de la lista
                comparacion = comparar(listaD.dato, dato);
                while (!comparacion && listaD.siguiente != null) {
                    listaD = listaD.siguiente;
                    comparacion = comparar(listaD.dato, dato);
                }
            }
            else
                // la lista esta sobre el dato que se busca pero por las dudas se compara
                comparacion=comparar(listaD.dato, dato);
        }

        // aca es donde borra el nodo
        if(comparacion){
            if(listaD.anterior==null && listaD.siguiente==null)
                listaD=null;
            else{
                if(listaD.anterior!=null){
                    listaD.anterior.siguiente= listaD.siguiente;
                    aux=listaD.anterior;
                }
                if(listaD.siguiente!=null){
                    listaD.siguiente.anterior=listaD.anterior;
                    aux=listaD.siguiente;
                }
                listaD=aux;
            }
            return true;
        }

        return false;
    }





    /**
     * Metodo para mostrar los datos de los nodos desde el final.
     * Seria mejor que haya un metodo Mostrar(Object dato) para asi trabajaba con cualquier objeto en
     *  vez de utilizar System.out.println(), pero no tengo ganas de hacerlo ya que es un tanto irrelevante ahora.
     * Se mueve el puntero desde la posicion que se encuentra hasta el primer nodo y de ahi,  se va imprimiendo
     *  el valor del nodo siguiente hasta que se llega al ultimo, donde imprime valor y se detiene.
     * Si la lista esta vacia, muestra mensaje de eso.
     */
    public void mostrarDesdeInicio(){
        if(listaD==null) {
            System.out.println("Lista vacia");
        }
        else{
            while (listaD.anterior != null)
                listaD = listaD.anterior;
            while(listaD.siguiente!=null){
                System.out.println(listaD.dato.toString());
                listaD = listaD.siguiente;
            }
            System.out.println(listaD.dato.toString());
        }
    }


    /**
     * Metodo para mostrar los datos de los nodos desde el final.
     * Seria mejor que haya un metodo Mostrar(Object dato) para asi trabajaba con cualquier objeto en
     *  vez de utilizar System.out.println(), pero no tengo ganas de hacerlo ya que es un tanto irrelevante ahora.
     * Se mueve el puntero desde la posicion que se encuentra hasta el ultimo nodo y de ahi,  se va imprimiendo
     *  el valor del nodo anterior hasta que se llega al primero, donde imprime valor y se detiene.
     * Si la lista esta vacia, muestra mensaje de eso.
     */
    public void mostrarDesdeFinal(){
        if(listaD==null) {
            System.out.println("Lista vacia");
        }
        else{
            while (listaD.siguiente != null)
                listaD = listaD.siguiente;
            while(listaD.anterior!=null){
                System.out.println(listaD.dato.toString());
                listaD = listaD.anterior;
            }
            System.out.println(listaD.dato.toString());
        }
    }



    /**
     * Metodo que informa que dato es mayor, menor o igual.
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


    /**
     * Metodo para comparar si dos objetos son iguales.
     * Se usa para no tener que tocar las funciones de la lista y editar esto.
     * Se puede modificar para usar en vez de metodo "mayorMenorIgual", pero lo dejo asi para mejor comprensión.
     * @param uno primero objeto
     * @param dos segundo obejto
     * @return true si son iguales
     */
    private boolean comparar(Object uno, Object dos) {
        return uno.equals(dos);
    }
}
