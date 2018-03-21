# Laboratorio5-Tp1

Cuantos consumidores se necesitan para que el stock llegue a cero?

Como en este programa en particular los clientes consumen sin ninguna limitacion mas que el stock disponible, 
una cantidad aleatoria de unidades por vez, no es posible determinar cuantos de ellos son necesarios para llevar el stock a cero.
Podrian ser 1 o muchos, y la respuesta variaria en cada ejecucion del sistema.

Bloques "synchronized", por que deben sero?

En algunas ocasiones un metodo utiliza un objeto en comun con otros metodos, es decir, distintos metodos utilizan al mismo objeto. 
Para garantizar la correcta manipulacion de ese objeto en comun, es necesario excluir a los otros metodos
con los que comparte dicho objeto durante la ejecucion de su codigo (para evitar errores, como que tomen el objeto antes de finalizar
un proceso, alterando los resultados). Para ello es necesario declarar como synchronized a los metodos que manipulan el objeto en comun
y convertir en hilos a los objetos que los utilizan, extendiendolos de Thread, por ejemplo.
En el caso actual, los metodos "put" y "get" son synchronized porque son luego utilizados por el productor de cerveza y 
el cliente (hilos), y ambos manipulan el stock mediante sus metodos "run" que sobreescriben, y que se corren al "mismo tiempo".

Explicar el recurso compartido:

El recurso compartido es ese que mas de un hilo manipula "al mismo tiempo" -aunque en realidad aqui actuan de manera sincronizada-.
En este caso el recurso compartido es el atributo stock dentro de la clase BeerHouse    

Explicar las tres formas de instanciar un Thread:

Los modos de instanciar un Thread son:
    -Extendiendo de la clase Thread, sobreescribiendo el metodo run(), crear
    la clase y ejecutar con el metodo start().
    -Implementando Runnable, sobreescribiendo el metodo run(), crear un thread y pasarle
    el runnable como parametro; y ejecutar con el metodo start().




