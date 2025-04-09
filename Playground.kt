/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
    // variables & constantes
    // Declaración implícita
    val name = "Pedro Fuentes"
    println(name)
    
    // Declaración explícita
    var age: Int 
    age = 40
    println(age)
    age = 50
    println(age)
    
    println(sum(b = 10, a = 5))
    
    
    val sayHi = {
        println("Hi, $name" )
    }
    
    sayHi()
    
    val multiply: (Int, Int) -> Int 
    multiply =  { a, b ->
        a * b
    }   
    
    println(multiply(5, 10))
    
    val res = performOperation(10, 7) { x, y ->
        x * y
    }
    print(res)
}

fun sum(a: Int, b: Int): Int {
    return a + b
}


fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int  ): Int {
    return operation(a, b)
}



