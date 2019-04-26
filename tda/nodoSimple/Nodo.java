package tda.nodoSimple;

public class Nodo {
    public Object dato;
    public Nodo siguiente;

    public Nodo() {
        this.siguiente=null;
    }

    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente=null;
    }
}
