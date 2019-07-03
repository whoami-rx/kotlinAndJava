import java.util.*

data class PersonKotlin(
    val title: String,
    val firstName: String,
    val surname: String,
    val birthDate: Calendar
) {
    private var nextId = 0L
    val id: Long

    init {
        id = nextId
        nextId++
    }

    val age: Int? get() = getAge(birthDate)
    val safeAge: Int get() = age ?: -1

    override fun toString(): String = "$title $firstName $surname"

    companion object {
        fun getAge(dateOfBirth: Calendar?): Int {
            if (dateOfBirth == null) return -1
            val today = GregorianCalendar()
            val years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
            return if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) years - 1 else years
        }
    }
}