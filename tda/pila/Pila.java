package tda.pila;

import tda.nodoSimple.Nodo;

/**
 * Pila.
 * Utiliza nodo simple.
 * @author Sebastian Rossi
 */
public class Pila {
   private Nodo pila;

    public Pila() {
        pila=null;
    }

    public void vaciar(){
            pila=null;
    }

    public boolean vacia(){
        return pila == null;
    }

    public void poner(Object dato){
        Nodo nuevo = new Nodo(dato);
        if(pila==null)
            pila = nuevo;
        else{
            nuevo.siguiente=pila;
            pila=nuevo;
        }
    }

    public Object sacar(){
        if(pila==null)
            return null;

        Nodo aux = pila;
        pila=aux.siguiente;
        Object nuevo = aux.dato;
        aux=null;
        return nuevo;
    }

    public Object verTope(){
        if(pila==null)
            return null;
        Object nuevo = pila.dato;
        return nuevo;
    }

}
