import reproductor.ReproductorMidi

fun main(){

    val rm= ReproductorMidi("C:\\Users\\albaa\\Downloads\\pugnodollari.mid")
    println("Cargando programa...")
    Thread.sleep(7000)


    val frutas=arrayOf("pera","piña","coco","lima","mani","kiwi")
    val fruta=frutas.random() // asignamos a la variable fruta un valor random del array frutas
    val frutaOculta=CharArray(fruta.length) // creamos un array de chars con el tamaño del elemento seleccionado por random()
    for(i in 0 until fruta.length){ // rellenamos ese palabra seleccionada con asteriscos
        frutaOculta[i]='*'
    }
    var intentos=7

    val letrasGuardadas=mutableListOf<Char>() // creamos una lista mutable para guardar las letras que vayan saliendo

    while(intentos>0 && frutaOculta.contains('*')){ // creamos un bucle mientras los intentos sean mayor que 0 ( en el caso de que falle lo justo) y el array de chars contenga asteriscos ( en el caso de que acierte)
        var palabraAdivinar="" // creamos una variable en la que guardaremos la concatenación de los chars del array frutaOculta
        for(char in frutaOculta){
            palabraAdivinar+=char
        }

        println("Intentos restantes: $intentos")
        println("Fruta a adivinar: $palabraAdivinar")
        println("Introduce una letra")
        val entrada=readln()
        val letra=entrada[0]

        if(letrasGuardadas.contains(letra)){ // comprobamos si la lista ya contiene la letra, y si es que sí, que lo cuente como fallo, sino que añada la letra a la lista
            intentos--
            DibujoAhorcado.dibujar(7-intentos)
        }else {
            letrasGuardadas.add(letra)

            if (fruta.contains(letra)) { // si la palabra random contiene la letra que escribimos por teclado
                for (j in 0 until fruta.length) { // creamos un bucle donde con una condiciómn especificamos que si el índice de la fruta random es igual a la letra
                    if (fruta[j].equals(letra)) {
                        frutaOculta[j] = letra // el mismo índice para frutaOculta será reemplazado por la letra
                    }
                }
                // si la fruta random no contiene la letra que introducimos x teclado se descontarán intentos
            } else {
                intentos--

                // y se llamará a al método estático dibujar de la clase DibujoAhorcado ( el case llamado será el 1 (7-6), después el 2(7-5), etc

                DibujoAhorcado.dibujar(7 - intentos)

            }
        }

    }

    if(intentos>0){
        println("EnhoraBuena!! has adivinado la palabra")

        println("La fruta oculta es: $fruta")


    }else{
        println("Lo siento, has perdido. La fruta oculta era $fruta")
    }
}