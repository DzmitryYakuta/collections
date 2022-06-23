fun main() {

    val n = enterNumber()
    val phoneNumberList = enterPhoneNumbers(n)
    println("Phone numbers list: ${phoneNumberList.joinToString(", ")}")
    val phoneStart = phoneNumberList.filter { it.startsWith("+7")}
    println("Phone numbers started with +7: ${phoneStart.joinToString(", ")}")
    println("Количество уникальных введённых номеров: ${phoneNumberList.toSet().size}")
    println("Сумма длин всех номеров телефонов: ${phoneNumberList.sumOf { it.length }}")
    val phoneDirectory = enterPhoneNames(phoneNumberList, n)
    printDirectory(phoneDirectory)
    val sortedByPhone = phoneDirectory.toSortedMap()
    printDirectory(sortedByPhone.toMutableMap())
    val sortedByNames = phoneDirectory.toList().sortedBy { (key, value) -> value }.toMap()
    printDirectory(sortedByNames.toMutableMap())

}

fun printDirectory(directory: MutableMap<String, String>) {
    directory.forEach{ (key, value) -> println("Абонент: $value. Номер телефона: $key")}
}

fun enterPhoneNames(phoneNumberList: MutableList<String>, n: Int) : MutableMap<String, String> {
    val phoneNumberMap = mutableMapOf<String, String>()
    for (i in 0 until n) {
        print("Введите имя человека с номером телефона ${phoneNumberList[i]}: ")
        phoneNumberMap[phoneNumberList[i]] = readLine().toString()
    }
    return phoneNumberMap
}

fun enterPhoneNumbers(n: Int): MutableList<String> {
    val phoneNumberList = MutableList<String>(n) { "0" }
    for (i in 0 until n) {
        print("Enter phone number №${i+1}: ")
        phoneNumberList[i] = readLine().toString()
    }
    return phoneNumberList
}

fun enterNumber() : Int {
    var n: Int
    do {
        print("Enter N more them 0: ")
        n = readLine()?.toIntOrNull() ?: -1
    } while (n < 0)
    return n
}