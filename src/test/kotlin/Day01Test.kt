import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day01Test : AbstractDayTest<Sequence<String>, Int>() {
    override val day = Day01

    override val inputText: String = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
        """.trimIndent()

    override val expectedPart1 = 3
    override val expectedPart2 = 6

    @Test
    fun `timesClickedZero when starting at zero counts full rotations`() {
        val rot = Day01.Rotation(Day01.Direction.RIGHT, 100)
        Day01.timesClickedZero(0, rot) shouldBe 1
    }

    @Test
    fun `timesClickedZero distance smaller than firstHit returns zero`() {
        val rot = Day01.Rotation(Day01.Direction.LEFT, 10)
        Day01.timesClickedZero(50, rot) shouldBe 0
    }

    @Test
    fun `timesClickedZero multiple rotations counted`() {
        val rot = Day01.Rotation(Day01.Direction.RIGHT, 250)
        Day01.timesClickedZero(10, rot) shouldBe 2
    }
}
