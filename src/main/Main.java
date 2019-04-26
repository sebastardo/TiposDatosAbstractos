package main;

import tda.Dato;
import tda.arbol.Arbol;


/**
 * Main para probar TDAs.
 * Aunque usar los TESTs seria mejor, me dio vagancia.
 * @author Sebastian Rossi
 */


public class Main {
    public static void main(String args[]){
        /*
        Lista listoide = new Lista();
        System.out.println("Tamaño: "+listoide.getTamanio());
        listoide.insertarAlInicio(1);
        System.out.println("Tamaño: "+listoide.getTamanio());
        listoide.insertarAlFinal(2);
        listoide.insertarAlFinal(3);
        listoide.insertarAlFinal(4);
        listoide.recorrer();
        System.out.println("Tamaño: "+listoide.getTamanio());
        System.out.println(listoide.eliminar(4));
        System.out.println("Tamaño: "+listoide.getTamanio());
        listoide.recorrer();
        listoide.insertarAlInicio(4);
        System.out.println("oh no!");
        listoide.recorrer();

        Dato d = new Dato((int) listoide.buscar(4));

        System.out.println(d.toString());
        System.out.println("Tamaño: "+listoide.getTamanio());

        listoide.insertarAlFinal(0);
        listoide.insertarAlFinal(9);
        listoide.insertarAlFinal(6);
        listoide.insertarAlInicio(8);
        listoide.insertarAlInicio(7);

        System.out.println("Tamaño: "+listoide.getTamanio());
        listoide.recorrer();
        listoide.ordenar();
        System.out.println("Ordenando:");
        listoide.recorrer();
        System.out.println("nuevo en orden:");

        listoide.insertarEnOrdenSinRepetidos(4);
        listoide.recorrer();
        System.out.println("Tamaño: "+listoide.getTamanio());





        ListaDoblementeEnlazada listaDE = new ListaDoblementeEnlazada();
        listaDE.insertar(1);
        listaDE.insertar(7);
        listaDE.insertar(5);
        listaDE.insertar(2);
        listaDE.insertar(0);
        listaDE.insertar(9);

        System.out.println("Desde el principio");
        listaDE.mostrarDesdeInicio();
        System.out.println("Desde el final");
        listaDE.mostrarDesdeFinal();


        System.out.println("Buscado 9");
        try {
            Dato encontrado = new Dato((int)listaDE.buscar(9));
            System.out.println("Encontrado: " + encontrado.getDato());
        }catch(java.lang.NullPointerException e){
            System.out.println("Dato no encontrado");
        }
        System.out.println("Buscado 0");
        try {
            Dato encontrado = new Dato((int)listaDE.buscar(0));
            System.out.println("Encontrado: " + encontrado.getDato());
        }catch(java.lang.NullPointerException e){
            System.out.println("Dato no encontrado");
        }
        System.out.println("Buscado 5");
        try {
            Dato encontrado = new Dato((int)listaDE.buscar(5));
            System.out.println("Encontrado: " + encontrado.getDato());
        }catch(java.lang.NullPointerException e){
            System.out.println("Dato no encontrado");
        }
        System.out.println("Buscado 3");
        try {
            Dato encontrado = new Dato((int)listaDE.buscar(3));
            System.out.println("Encontrado: " + encontrado.getDato());
        }catch(java.lang.NullPointerException e){
            System.out.println("Dato no encontrado");
        }




        System.out.println("Desde el principio");
        listaDE.mostrarDesdeInicio();



        listaDE.borrar(0);
        listaDE.borrar(1);
        listaDE.borrar(9);
        listaDE.borrar(2);
        listaDE.borrar(5);
        listaDE.borrar(7);

        //listaDE.insertar(-1);

        System.out.println("Desde el principio");
        listaDE.mostrarDesdeInicio();
        System.out.println("Desde el final");
        listaDE.mostrarDesdeFinal();


        ListaCircularPila listaCP = new ListaCircularPila();

        listaCP.insertar(1);
        listaCP.insertar(9);
        listaCP.insertar(5);
        listaCP.insertar(3);
        listaCP.insertar(7);
        System.out.println("Antes de buscar");
        listaCP.recorrer();

        try {
            Dato encontrado = new Dato((int)listaCP.buscar(5));
            System.out.println("Encontrado: " + encontrado.getDato());
        }catch(java.lang.NullPointerException e){
            System.out.println("Dato no encontrado");
        }
        System.out.println("Durante");
        listaCP.recorrer();

        try {
            Dato encontrado = new Dato((int)listaCP.buscar(6));
            System.out.println("Encontrado: " + encontrado.getDato());
        }catch(java.lang.NullPointerException e){
            System.out.println("Dato no encontrado");
        }
        System.out.println("Despues");
        listaCP.recorrer();

        if(listaCP.borrar(3))
            System.out.println("borrado el 3");

        listaCP.recorrer();
        listaCP.borrar(5);
        listaCP.borrar(9);
        listaCP.borrar(7);
        listaCP.borrar(1);
        System.out.println("borrados varios");
        listaCP.recorrer();

        */


        Arbol arbolito = new Arbol();

        arbolito.ingresar(6);
        arbolito.ingresar(2);
        arbolito.ingresar(4);
        arbolito.ingresar(1);
        arbolito.ingresar(13);
        arbolito.ingresar(8);
        arbolito.ingresar(3);
        arbolito.ingresar(7);
        arbolito.ingresar(9);
        arbolito.ingresar(10);
        arbolito.ingresar(15);
        arbolito.ingresar(14);


        arbolito.mostrar('b');

        System.out.println("altura: "+arbolito.altura());
        System.out.println("Cantidad de nodos: "+ arbolito.cantidadDeNodos());

        System.out.println("Buscado 3");
        try {
            Dato encontrado = new Dato((int)arbolito.buscar(10));
            System.out.println("Encontrado: " + encontrado.getDato());
        }catch(java.lang.NullPointerException e){
            System.out.println("Dato no encontrado");
        }


        System.out.println("Cantidad nodos internos: "+ arbolito.cantidadNodosInternos());

    }
}
