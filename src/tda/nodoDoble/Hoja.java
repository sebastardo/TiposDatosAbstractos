package tda.nodoDoble;


/**
 * Podria usarse Nodo de este mismo paquete, pero es mas simple entender un arbol con derecha e izquierda.
 */
public class Hoja  {
    public Object dato;
    public Hoja izquierda;
    public Hoja derecha;

    public Hoja() {
        this.izquierda = null;
        this.derecha=null;
    }

    public Hoja(Object dato) {
        this.dato = dato;
        this.izquierda=null;
        this.derecha=null;
    }
}
