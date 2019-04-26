package tda.listaCircular;

import tda.nodoSimple.Nodo;

/**
 * Lista Circular usando Pila.
 * Utiliza el Nodo Simple.
 * @author Sebastian Rossi
 */
public class ListaCircularPila {
    private static Nodo lista;

    public ListaCircularPila() {
        lista=null;
    }

    /**
     * Insertar en lista.
     * Si la lista esta vacia, el dato nuevo se apunta a si mismo.
     * Si tiene elementos, el dato nuevo apunta al siguiente de la lista y a su vez,
     *  el siguiente de la lista pasa a apuntar al nuevo.
     * @param dato
     */
    public void insertar(Object dato){
        Nodo nuevo = new Nodo(dato);

        if(lista==null){
            nuevo.siguiente=nuevo;
            lista = nuevo;
        } else {
            nuevo.siguiente= lista.siguiente;
            lista.siguiente=nuevo;
        }

    }

    /**
     * Scar de la lista.
     * @return el dato del nodo
     */
    public Object sacar(){
        if(lista==null)
            return null;

        Nodo aux = lista.siguiente;
        if(lista==aux)
            lista=null;
        else
            lista.siguiente=aux.siguiente;

        return aux.dato;
    }

    /**
     * Metodo para recorrer la lista y mostrar sus valores.
     */
    public void recorrer(){
            if (lista==null){
                System.out.println("Lista Vacia");
            }else {

                System.out.println(lista.dato.toString());
                Nodo inicio= lista;
                lista = lista.siguiente;

                while (lista != inicio) {
                    System.out.println(lista.dato.toString());
                    lista = lista.siguiente;
                }
            }
    }

    /**
     * Metodo para buscar.
     * @param dato informacion a buscar
     * @return Object que coincide con el dato pasado por parametro
     */
    public Object buscar(Object dato){
        if (lista==null){
            return null;
        }

        if(comparar(lista.dato,dato))
            return lista.dato;


        Nodo inicio = lista;
        lista=lista.siguiente;

        while(lista!=inicio){
            if(comparar(lista.dato,dato))
                return lista.dato;
            lista=lista.siguiente;
        }
        return null;
    }

    /**
     * Borrar nodos de la lista circular.
     * @param dato objeto a borrar.
     * @return true si lo borro.
     * Funciona correctamente, pero podria optimizarse.
     */
    public boolean borrar(Object dato){
        if(lista==null)
            return false;

        Nodo inicio=lista;
        Nodo aux = lista;

        lista=lista.siguiente;

        while(lista!=inicio){
            if(comparar(lista.dato,dato)){
                aux.siguiente=lista.siguiente;
                lista=lista.siguiente;
                return true;
            }
            aux=lista;
            lista=lista.siguiente;
        }

        // si hay un solo elemento en la lista
        if(comparar(lista.dato,dato)){
            if(lista==lista.siguiente){
                lista=null;
                return true;
            }
            aux.siguiente=lista.siguiente;
            lista=lista.siguiente;
            return true;
        }
        return false;
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
