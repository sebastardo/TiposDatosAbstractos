# Tipos de Datos Abstractos para Java

Colección de algunos datos abstractos para Java. Los mismos estan en el package tda y estan armados para que se le pueda pasar cualquier dato sin necesidad de modificar los metodos principales (solo hay que tocar un par de comparación). 

## Tabla de contenido
- [Nodo Simple](#nodo-simple)
- [Nodo Doble](#nodo-doble)
- [Pila](#pila)
- [Cola](#cola)
- [Lista](#lista)
- [Lista Circular](#lista-circular)
- [Lista Doblemente Enlazada](#lista-doblemente-enlazada)
- [Arbol](#arbol)
- [Dato](#dato)
- [Main](#main)

## Nodo Simple
Se encuentra en el package nodoSimple y se utiliza para los TDA Pila, Cola, Lista y Lista Circular. Posee un solo enlace llamado siguiente y el dato.

## Nodo Doble
Dentro del package nodoDoble se encuentran dos tipo de nodos. Aunque son iguales y podria tener el mismo nombre, seria complejo usar el mismo en lista circulares y arboles ya que dentro de esas TDAs funcionan de manera direfente.

### Nodo
Nodo posee un tipo de datos y dos enlaces, al igual que simple, tiene un enlace a siguiente, pero tambien tiene un enlace llamado anterior, que en la TDA apuntaria al nodo que le precede si esta entre dos nodos o en el ultimo eslabon. Si fuese el primer eslabon de la lista circular, anterior apuntaria a null. Igualmente siguiente, si estuviese en el ultimo eslabon, apuntaria a null (si se usase en lista circular, seria otro tema pero aca no se lo implementa).

### Hoja
Deberia llamarse Nodo, ya que hoja es solo un nodo al que sus enlaces apuntan a nada y, por esto, la raiz y una rama no son hojas, pero cuatro letras es mas corto y simple que NodoHoja, por poner un ejemplo.
Como los otros nodos, consta del objeto dato y dos enlaces, izquierdo y derecho, ambos apuntando a siguientes nodos. En este caso no apuntaria nunca al nodo anterior sino a dos siguientes.

## Pila

![Pila](https://user-images.githubusercontent.com/35445409/56833059-d8265880-6843-11e9-956b-d6147857c4c6.png)

*Iba a hacer la pila de tamaño fijo, pero me olvide.*

## Cola

![Cola](https://user-images.githubusercontent.com/35445409/56837414-b384ad80-6850-11e9-87de-86821a013994.png)

*Al igual que en pila, olvide de hacer la cola de tamaño fijo.*

## Lista

![Lista simplemente enlazada](https://user-images.githubusercontent.com/35445409/56856219-2f9ff380-692c-11e9-9d5f-9fa3c6b27ff9.jpg)

## Lista Circular

![Lista circular](https://user-images.githubusercontent.com/35445409/56837501-fc3c6680-6850-11e9-8f36-edaff26a706f.png)

*En este caso, para la lista circular se uso pila, con cola tambien se puede hacer pero no tenia muchas ganas hacer todo de nuevo...*

## Lista Doblemente Enlazada
![Lista Doblemente Enlazada](https://user-images.githubusercontent.com/35445409/56856189-a688bc80-692b-11e9-9f74-86b9a9958232.jpg)

### LIsta Doblemente Enlazada Desordenada

Empece haciendo esta lista y despues me di cuenta que queria hacer que se ordene sola, asi que la abandone e hice la que si va. Igualmente, me parecio que estaba bien dejarla (y me olvide de borrarla tambien). Esta puede quedar como la de la imagen, pero segun como se ingrese los datos, ya que es un tanto random donde se los ingresa.

## Arbol

## Dato

## Main



