object Day02 : Day<Sequence<String>, Long> {
    private val repeatedTwice = """^(\d+)\1$""".toRegex()
    private val repeatedAtLeastTwice = """^(\d+)\1+$""".toRegex()

    private fun String.toRange() =
        substringBefore("-").toLong()..substringAfter("-").toLong()

    private fun readRanges(input: Sequence<String>) =
        input.map { it.toRange() }

    private fun Sequence<LongRange>.sumMatches(predicate: (String) -> Boolean) =
        flatten()
            .filter { predicate(it.toString()) }
            .sum()

    override fun parse(text: String): Sequence<String> = readInputFromString(text, ",")

    override fun part1(input: Sequence<String>): Long = readRanges(input)
        .sumMatches(repeatedTwice::matches)

    override fun part2(input: Sequence<String>): Long = readRanges(input)
        .sumMatches(repeatedAtLeastTwice::matches)
}

fun main() {
    val testInput = readInput("Day02_test", delimiter = ",")
    check(Day02.part1(testInput) == 1227775554L)
    check(Day02.part2(testInput) == 4174379265L)

    val input = readInput("Day02", delimiter = ",")
    Day02.part1(input).println()
    Day02.part2(input).println()
}
