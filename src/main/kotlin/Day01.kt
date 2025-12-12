typealias Position = Int
typealias Distance = Int

object Day01 : Day<Sequence<String>, Int> {
    enum class Direction { LEFT, RIGHT }
    data class Rotation(val direction: Direction, val distance: Distance)

    private const val DIAL_SIZE = 100
    private const val INITIAL_POSITION: Position = 50

    private fun Position.landedOnZero(): Boolean = this == 0

    override fun parse(text: String): Sequence<String> = readInputFromString(text)

    fun timesClickedZero(start: Position, rotation: Rotation): Int {
        val (direction, distance) = rotation

        val distanceToZero = when (direction) {
            Direction.RIGHT -> (DIAL_SIZE - start)
            Direction.LEFT -> start
        }

        val firstHit = if (distanceToZero == 0) DIAL_SIZE else distanceToZero
        if (distance < firstHit) return 0
        return 1 + (distance - firstHit) / DIAL_SIZE
    }

    private fun String.toRotation(): Rotation {
        val dir = when (first()) {
            'L' -> Direction.LEFT
            'R' -> Direction.RIGHT
            else -> error("Invalid direction: $this")
        }
        return Rotation(dir, substring(1).toInt())
    }

    private fun readRotations(input: Sequence<String>): Sequence<Rotation> = input.map { it.toRotation() }

    private fun Position.rotate(rotation: Rotation, n: Int = DIAL_SIZE): Position {
        val delta = when (rotation.direction) {
            Direction.LEFT -> -rotation.distance
            Direction.RIGHT -> rotation.distance
        }
        return (this + delta).mod(n)
    }

    private fun Sequence<Rotation>.findPassword(clicksFor: (Position, Rotation) -> Int): Int {
        return this.fold(INITIAL_POSITION to 0) { (pos, total), rot ->
            val clicks = clicksFor(pos, rot)
            val newPos = pos.rotate(rot)
            newPos to (total + clicks)
        }.second
    }

    override fun part1(input: Sequence<String>): Int = readRotations(input)
        .findPassword { pos, _ -> if (pos.landedOnZero()) 1 else 0 }

    override fun part2(input: Sequence<String>): Int = readRotations(input)
        .findPassword { pos, rot -> timesClickedZero(pos, rot) }
}

fun main() {
    // Read the input from the `src/Day01_test.txt` file.
    val testInput = readInput("Day01_test")
    check(Day01.part1(testInput) == 3)
    check(Day01.part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    Day01.part1(input).println()
    Day01.part2(input).println()
}
