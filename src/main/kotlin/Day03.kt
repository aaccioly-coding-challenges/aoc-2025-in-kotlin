import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {}

object Day03 : Day<Sequence<String>, Long> {
    fun topKInOrder(digits: List<Int>, k: Int): List<Int> {
        var toRemove = digits.size - k
        val stack = ArrayDeque<Int>()

        for (num in digits) {
            while (toRemove > 0 && stack.isNotEmpty() && stack.last() < num) {
                stack.removeLast()
                toRemove--
            }
            stack.addLast(num)
        }

        // If we didn't remove enough, the excess elements are at the end; take the first k
        return stack.take(k)
    }

    private fun sumOfTopK(lines: Sequence<String>, k: Int): Long = lines
        .map { it.digits() }
        .map { Day03.topKInOrder(it, k) }
        .map { it.joinToString("").toLong() }
        .onEachIndexed { index, value -> logger.trace { "Line $index: $value" } }
        .sum()

    override fun parse(text: String): Sequence<String> = readInputFromString(text)

    override fun part1(input: Sequence<String>): Long = sumOfTopK(input, 2)

    override fun part2(input: Sequence<String>): Long = sumOfTopK(input, 12)
}

fun main() {
    val testInput = readInput("Day03_test")
    check(Day03.part1(testInput) == 357L)
    check(Day03.part2(testInput) == 3121910778619L)

    val input = readInput("Day03")
    Day03.part1(input).println()
    Day03.part2(input).println()
}
