package tda;

public class Dato {
    private int dato;

    public Dato(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "Dato{" +
                "dato=" + dato +
                '}';
    }
}

