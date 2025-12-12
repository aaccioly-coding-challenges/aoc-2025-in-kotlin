interface Day<I, O> {
    fun parse(text: String): I
    fun part1(input: I): O
    fun part2(input: I): O
}
