import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


class Day03Test : AbstractDayTest<Sequence<String>, Long>() {
    override val day = Day03

    override val inputText = """
        987654321111111
        811111111111119
        234234234234278
        818181911112111
        """.trimIndent()

    override val expectedPart1 = 357L
    override val expectedPart2 = 3121910778619L

    @Test
    fun `topKInOrder returns largest k keeping order for typical case`() {
        Day03.topKInOrder(listOf(1, 3, 2, 5, 4), 3) shouldBe listOf(3, 5, 4)
    }

    @Test
    fun `topKInOrder when k greater than size returns all elements`() {
        Day03.topKInOrder(listOf(9, 1, 2), 5) shouldBe listOf(9, 1, 2)
    }

    @Test
    fun `topKInOrder when k equals size returns same list`() {
        Day03.topKInOrder(listOf(4, 3, 2, 1), 4) shouldBe listOf(4, 3, 2, 1)
    }
}
