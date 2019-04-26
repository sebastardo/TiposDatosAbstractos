package tda.arbol;

import tda.nodoDoble.Hoja;

public class Arbol {

    private Hoja raiz;

    public Arbol() {
        this.raiz = null;
    }


    /* Ingreso datos - Comienzo */
    /**
     * Metodo publico que comienza la recursion desde la raiz para agregar nodos.
     * @param dato informacion a agregar.
     */
    public void ingresar(Object dato){
        raiz = agregarRecursivo(raiz, dato);
    }


    /**
     * Metodo para el ingreso de datos al arbol.
     * A la izquierda, los menores a la raiz, a la derecha los mayores.
     * @param actual raiz del arbol (subarbol).
     * @param dato informacion a ser agradada a la hoja.
     * @return en recursividad devuelve hoja, en fin del metodo, devuelve el arbol.
     */
    private Hoja agregarRecursivo(Hoja actual, Object dato) {

        // para agregar la hoja, es esta parte
        if (actual == null) {
            return new Hoja(dato);
        }

        int comparacion = mayorMenorIgual(actual.dato, dato);

        // si dato pasado por parametro es menor que que el dato en raiz, va por izquierda
        if (comparacion > 0)
            actual.izquierda = agregarRecursivo(actual.izquierda, dato);

        // si dato pasado por parametro es mayor que que el dato en raiz, va por derecha
        if (comparacion < 0)
            actual.derecha = agregarRecursivo(actual.derecha, dato);


        // si dato pasado por parametro es igual a dato en raiz, no hace nada
        return actual;
    }
    /* Ingreso datos - Fin */





    /**************************************************************************************************************
     * Agregar datos de modo NO recursivo y horrible.
     * No usar. Nunca.
     * @param dato
     * @return true si lo agregó, false si esta repetido y no lo agrega.
     */
    public boolean agregarFeo(Object dato){

        Hoja nueva = new Hoja(dato);


        if(raiz == null){
            raiz = nueva; //el arbol estaba vacio y ahora la hoja nueva es la raiz
            return true;
        }else{
            Hoja auxiliar = raiz;
            Hoja rama;

            while(true){ // solo saldra del loop si inseta el dato o si esta insertado para no meter un repetido

                //dato repetido
                if(comparar(auxiliar.dato, dato)){
                    return false;
                }


                // agragar
                rama = auxiliar;

                if(mayorMenorIgual(dato,auxiliar.dato)==-1){
                    //izquierda
                    auxiliar=auxiliar.izquierda;
                    if(auxiliar==null){
                        //inserta
                        rama.izquierda = nueva;
                        return true;
                    }
                }else{
                    //derecha
                    auxiliar = auxiliar.derecha;
                    if (auxiliar == null){
                        //inserta
                        rama.derecha = nueva;
                        return true;
                    }
                }
            }
        }
    }
    /************************************************************************************************************/


    /**
     * Metodo para mostrar el contenido del arbol.
     * Para no tener que usar en el main los metodos de recorrida, ya que se necesitaria
     *  que la raiz sea publica, se los llama desde este metodo.
     * Supongo que debe haber una manera mejor, pero fue la mas practica que se me ocurrio.
     * @param opcion para indicar que metodo de recorrida usar:
     *               * a - preOrden
     *               * b - inOrden
     *               * c - posOrden
     */
    public void mostrar(char opcion){
        switch (opcion){
            case 'a':
                preOrden(this.raiz);
                break;
            case 'b':
                inOrden(this.raiz);
                break;
            case 'c':
                posOrden(this.raiz);
                break;
        }
    }

    /**
     * Metodo recursivo para recorrida preorden.
     * Muestra el contenido del arbol, pero no se puede ingresar desde afuera de la clase.
     * @param r raiz de arbol o subarbol
     */
    private void preOrden(Hoja r){
        if(r!=null){
            System.out.println(r.dato); // reemplazar por funcion
            preOrden(r.izquierda);
            preOrden(r.derecha);
        }
    }


    /**
     * Metodo recursivo para recorrida en inOrden.
     * @param r raiz de arbol o subarbol
     */
    private void inOrden(Hoja r){
        if(r!=null){
            inOrden(r.izquierda);
            System.out.println(r.dato); // reemplazar por funcion
            inOrden(r.derecha);
        }
    }

    /**
     * Metodo recursivo para recorrida posorden.
     * @param r raiz de arbol o subarbol
     */
    private void posOrden(Hoja r){
        if(r!=null){
            posOrden(r.izquierda);
            posOrden(r.derecha);
            System.out.println(r.dato); // reemplazar por funcion
        }
    }


    /* Altura - Comienzo */
    /**
     * Metodo publico para saber la altura del arbol.
     * Utiliza el metodo contadorAltura que es recursivo.
     * @return altura del arbol.
     */
    public int altura(){
        return contadorAltura(raiz);
    }


    /**
     * Metodo que calcula la atura del arbol.
     * Es privado para que no se pueda acceder a raiz.
     * @param r nodo raiz
     * @return altura del arbol-subarbol.
     */
    private int contadorAltura(Hoja r)
    {
        int hi, hd;

        if(r!=null)
        {
            hi=contadorAltura(r.izquierda);
            hd=contadorAltura(r.derecha);
            return hi>hd?hi+1:hd+1;
        }
        return 0;
    }
    /* Altura - Fin */


    /* Conteo Nodos - Comienzo */
    /**
     * Metodo publico para saber la cantidad de nodos
     * Utiliza el metodo contaNodos que es recursivo.
     * @return los nodos del arbol
     */
    public int cantidadDeNodos(){
        return contarNodos(raiz);
    }

    /**
     * Metodo que calcula los nodos del arbol
     * @param r nodo raiz
     * @return la suma del nodos del arbol-subarbol
     */
    private int contarNodos(Hoja r){
        if(r!=null){
            return contarNodos(r.izquierda) +
                    contarNodos(r.derecha) +
                    1;
        }
        return 0;
    }
    /* Conteo Nodos - Fin */


    /* Conteo Hojas - Comienzo */
    /**
     * Metodo publico para saber la cantidad de hojas
     * Utiliza el metodo contaHojas que es recursivo.
     * @return las hojas del arbol
     */
    public int cantidadHojas(){
        return contarHojas(raiz);
    }

    /**
     * Metodo que calcula la cantidad de hojas del arbol.
     * @param r nodo raiz
     * @return 1 si es hoja y lo suma a las otras hojas
     */
    private int contarHojas(Hoja r){
        if(r!=null){
            if(r.izquierda==null && r.derecha==null){
                return 1;
            }
            return contarHojas(r.izquierda) + contarHojas(r.derecha);
        }
        return 0;
    }
    /* Conteo Hojas - Fin */



    /* Arbol Completo - Inicio */

    /**
     * Metodo para determinar si el arbol es completo.
     * calculando la altura, verifica si es completo usando el metodo privado determinarCompleto
     * @return true si es completo
     */
    public boolean esArbolCompleto()
    {
        int h = contadorAltura(raiz);
        return determinarCompleto(raiz,h);
    }

    /**
     *
     * @param r
     * @param h
     * @return
     */
    private boolean determinarCompleto(Hoja r, int h)
    {
        if(r!=null)
        {
            return determinarCompleto(r.izquierda,h-1) && determinarCompleto(r.derecha,h-1);
        }
        return false;
    }
    /* Arbol Completo - Fin */




    /* Arbol Balanceado - Inicio */

    /**
     *
     * @return
     */
    public boolean esArbolBalanceado()
    {
        int h = contadorAltura(raiz);
        return determinarEsBalanceado(raiz,h);
    }

    /// Determina la balaceadez
    private boolean determinarEsBalanceado(Hoja r, int h)
    {
        if(r!=null)
        {
            return determinarEsBalanceado(r.izquierda,h-1) && determinarEsBalanceado(r.derecha,h-1);
        }
        return h<=1;
    }
    /* Arbol Balanceado - Fin */




    /* AVL - Comienzo*/
    //esArbolAVL
    /* - Fin */

    /* Podar - Comienzo*/
    //podar
    /* - Fin */

    /* Contar Internos - Comienzo*/
    /**
     * Metodo para saber cuantos nodos internos tienee el arbol.
     * Los nodos internos tienen hijos a izquierda y derecha.
     * Usa el metodo privado contarInternos.
     * @return numero de nodos internos
     */
    public int cantidadNodosInternos(){
        return contarInternos(raiz);
    }

    int contarInternos(Hoja r)
    {
        if(r!=null)
        {
            return contarInternos(r.izquierda) +
                contarInternos(r.derecha) +
                ((r.izquierda!=null && r.derecha!=null)?1:0);
        }
        return 0;
    }
    /* Contar Internos - Fin */

    /* Contar Externos - Comienzo*/
    //contarExternos
    /* - Fin */

    /* Buscar - Comienzo*/

    /**
     * Metodo que devuelve el objeto dentro de un nodo en que coincide con el dato pasado.
     * Usa el metodo privado buscarDato para encapsular el arbol.
     * @param dato (parte de la) informacion a buscar
     * @return informacion o dato especifico acerca de la informacion que se requiere encontrar.
     */
    public Object buscar(Object dato){
        return buscarDato(raiz, dato);
    }

    private Object buscarDato(Hoja r, Object dato)
    {
        int comparacion;
        if(r==null)
            return null;
        comparacion=mayorMenorIgual(r.dato,dato);
        if(comparacion==0)
            return r.dato;
        if(comparacion>0)
            return buscarDato(r.izquierda,dato);
        return buscarDato(r.derecha,dato);
    }
    /* Buscar - Fin */



    /**
     * Metodo que informa que dato es mayor, menor o igual.
     * @param uno dato 1
     * @param dos dato 2
     * @return 1 => uno>dos
     *         -1 => uno<dos
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
