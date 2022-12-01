// Elves don't lie every input on the list is honest!
// https://adventofcode.com/2022/day/1/input
val elves: MutableList<Elf> = mutableListOf()

fun main() {
    val lines: List<String> = readLines("input.txt")
    try {
        decide(lines)
    } catch (e: Exception) {
        println(e)
    }
    println("HUGE success")
}

fun decide(caloriesList: List<String>) {
    var sum: Long = 0
    for (line in caloriesList) {
        if (line.isBlank() || line.isEmpty()) {
            elves.add(Elf(sum))
            sum = 0
            continue
        }
        sum += line.trim().toLong()
    }

    val immutableElves: List<Elf> = elves.toList()
    elves.sortByDescending { it.calories }
    val mostElf = elves[0]

    println("Out of ${elves.size + 1} elves...")
    println("You guys better ask elf ${immutableElves[immutableElves.indexOf(mostElf)]} " +
            "(number ${immutableElves.indexOf(mostElf) + 1}), " +
            "who has ${mostElf.calories} calories!"
    )
    
    if (!(immutableElves != elves && (immutableElves.size == elves.size))) throw Exception("Not a success")
}

fun readLines(fileName: String): List<String> {
    return object {}.javaClass.getResourceAsStream(fileName)?.reader()?.readLines() ?: listOf()
}