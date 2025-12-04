import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads text from the given input txt file.
 * If a delimiter is provided, splits the text by that delimiter.
 * Otherwise, splits the text by newlines.
 */
fun readInput(name: String, delimiter: String? = null): Sequence<String> {
    val text = Path("src/$name.txt").readText().trim()
    return if (delimiter != null) {
        text.split(delimiter).asSequence()
    } else {
        text.lineSequence()
    }
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
