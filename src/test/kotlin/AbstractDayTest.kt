import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Generic base test for Day implementations. Subclasses provide the day, inputText
 * and expected results.
 */
abstract class AbstractDayTest<I, O> {
    abstract val day: Day<I, O>
    abstract val inputText: String
    abstract val expectedPart1: O
    abstract val expectedPart2: O

    @Test
    fun `part1 matches expected`() {
        val input = day.parse(inputText)
        day.part1(input) shouldBe expectedPart1
    }

    @Test
    fun `part2 matches expected`() {
        val input = day.parse(inputText)
        day.part2(input) shouldBe expectedPart2
    }
}
