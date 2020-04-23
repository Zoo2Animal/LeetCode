package kt

/**
 *
 * Name: FizzBUzz
 * Author: lloydfinch
 * Function: //TODO
 * Date: 2020-04-23 16:29
 * Modify: lloydfinch 2020-04-23 16:29
 */
fun main() {
    val fizzBuzz = fizzBuzz(15)
    fizzBuzz.forEach {
        println(it)
    }
}

fun fizzBuzz(n: Int): List<String> {
    val list = mutableListOf<String>()

    for (i in 1..n) {
        list.add(when {
            i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> i.toString()
        })
    }

    return list
}