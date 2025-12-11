private fun String.toRange() =
    substringBefore("-").toLong()..substringAfter("-").toLong()

private fun readRanges(input: Sequence<String>) =
    input.map(String::toRange)

private fun Sequence<LongRange>.sumMatches(predicate: (String) -> Boolean) =
    flatten()
        .filter { predicate(it.toString()) }
        .sum()

fun main() {
    val repeatedTwice = """^(\d+)\1$""".toRegex()
    val repeatedAtLeastTwice = """^(\d+)\1+$""".toRegex()

    fun part1(input: Sequence<String>) = readRanges(input)
        .sumMatches(repeatedTwice::matches)

    fun part2(input: Sequence<String>) = readRanges(input)
        .sumMatches(repeatedAtLeastTwice::matches)

    val testInput = readInput("Day02_test", delimiter = ",")
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265L)

    val input = readInput("Day02", delimiter = ",")
    part1(input).println()
    part2(input).println()
}
