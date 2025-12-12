import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class UtilsTest {
    @Test
    fun `readInputFromString splits by newline and trims`() {
        val raw = "\nline1\nline2\n"
        val seq = readInputFromString(raw)
        seq.toList() shouldBe listOf("line1", "line2")
    }

    @Test
    fun `readInputFromString splits by delimiter`() {
        val raw = "a,b,c"
        val seq = readInputFromString(raw, ",")
        seq.toList() shouldBe listOf("a", "b", "c")
    }

    @Test
    fun `digits returns digit list`() {
        "12345".digits() shouldBe listOf(1, 2, 3, 4, 5)
    }

    @Test
    fun `md5 produces expected hash`() {
        "".md5() shouldBe "d41d8cd98f00b204e9800998ecf8427e"
        "abc".md5() shouldBe "900150983cd24fb0d6963f7d28e17f72"
    }
}
