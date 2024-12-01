import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        // Unzip the input list into the two sides of the list.
        val (leftLList, rightList) = input.unzipInput()

        // Sort and zip them together so we can compare.
        return leftLList.sorted().zip(rightList.sorted())
            .sumOf { (left, right) -> abs(left - right) }
    }

    fun part2(input: List<String>): Int {
        // Unzip the input list into the two sides of the list.
        val (leftLList, rightList) = input.unzipInput()

        // Sum the values of the left list times the count of itself in the right list.
        return leftLList.sumOf { left -> left * rightList.count(left::equals) }
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")

    part1(input).println()
    part2(input).println()
}

/** Unzips the list of string into two the list of left and right columns. */
private fun List<String>.unzipInput(): Pair<List<Int>, List<Int>> = map {
    // Separating the left and right inputs.
    // Input is separated by "   ".
    val (left, right) = it.split("   ")
    left.toInt() to right.toInt()
}.unzip()  // Unzip to split the pairs
