import java.util.*

fun printTitle(message: String) {
    println("$message ${"*".repeat(50)}")
}

fun main() {
    val john = PersonKotlin("Programmer", "John", "Smith", GregorianCalendar(1991, 2, 5))
    val sarah = PersonKotlin("Designer", "Sarah", "Doe", GregorianCalendar(1997, 2, 5))

    printTitle("Test toString()")
    println(john)
    println(sarah)

    printTitle("Test equals()")
    println("Should be false: ${john == sarah}")
    println("Should be true: ${sarah == sarah}")

    printTitle("Test hashCode()")
    val set = setOf(john)
    println("Should be false: ${sarah in set}")
    println("Should be true: ${john in set}")

    printTitle("Test static method")
    println(" 1990 - 2019 = ${PersonKotlin.getAge(GregorianCalendar(1990, 1, 1))}")
}