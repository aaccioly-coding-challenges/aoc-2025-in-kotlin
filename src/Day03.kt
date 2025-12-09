import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {}

private fun topKInOrder(digits: List<Int>, k: Int): List<Int> {
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
    .map { topKInOrder(it, k) }
    .map { it.joinToString("").toLong() }
    .onEachIndexed { index, value -> logger.trace { "Line $index: $value" } }
    .sum()

fun main() {

    fun part1(input: Sequence<String>) = sumOfTopK(input, 2)

    fun part2(input: Sequence<String>) = sumOfTopK(input, 12)

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 357L)
    check(part2(testInput) == 3121910778619L)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
