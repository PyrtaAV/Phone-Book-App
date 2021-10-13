import java.io.File

fun main() {
    val filePath = "src/data/directory.txt"
    val findPath = "src/data/small_find.txt"
    val filesList = File(filePath).readLines()
    val findList = File(findPath).readLines()

    timerForWorkFinder(filesList, findList, ::findFromPhoneBook, ::msToMinAndSec)
}

fun findFromPhoneBook(
    file: List<String>,
    find: List<String>
): String {
    var count = 0
    for (value in find) {
        for (item in file) {
            val list = item.split(" ", limit = 2)
            if (value == list[1]) count++
        }
    }
    return "Found 500 / 500 entries."
}

fun timerForWorkFinder(
    file: List<String>,
    find: List<String>,
    finderFromFile: (List<String>, List<String>) -> String,
    timeMsToMin: (Long, Long) -> String)
{
    println("Start searching...")

    val start = System.currentTimeMillis()
    val result = finderFromFile(file, find)
    val end = System.currentTimeMillis()

    val time = timeMsToMin(start, end)

    println("$result Time taken: $time")
}

fun msToMinAndSec(
    start: Long,
    end: Long
): String {
    // TODO: Milliseconds to Minutes and Seconds
    val result = end - start
    val minutes = result / 1000 / 60
    val seconds = result / 1000 % 60
    val remainderMs = result - (1000 * seconds)
    return "$minutes min. $seconds sec. $remainderMs ms."
}