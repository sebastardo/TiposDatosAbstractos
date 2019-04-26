package tda.cola;
import tda.nodoSimple.Nodo;

/**
 * Cola.
 * Utiliza el nodo simple.
 * @author Sebastian Rossi
 */
public class Cola {
    private static Nodo primero;
    private static Nodo ultimo;

    public Cola() {
        primero=null;
        ultimo=null;
    }

    public void vaciar(){
        Nodo aux=null;
        while(primero!=null){
            aux=primero;
            primero=primero.siguiente;
            aux=null;
        }
        ultimo=null;
    }

    public boolean vacia(){
        return primero==null;
    }

    public void poner(Object dato){
        Nodo nuevo =new Nodo(dato);
        if(primero==null)
            primero=nuevo;
        else
            ultimo.siguiente=nuevo;
        ultimo=nuevo;
    }

    public Object sacar(){
        if (primero==null)
            return null;
        Nodo aux=primero;
        primero=primero.siguiente;
        return aux.dato;
    }

    public Object verPrimero(){
        if (primero==null)
            return null;
        return primero.dato;
    }
}
