import java.math.BigInteger
import java.security.MessageDigest


// Anchor for resource lookups; using a named object is clearer than anonymous hacks.
private object ResourceLoader

/**
 * Reads text from the given input txt resource on the classpath.
 * If a delimiter is provided, splits the text by that delimiter.
 * Otherwise, splits the text by newlines.
 */
fun readInput(name: String, delimiter: String? = null): Sequence<String> {
    // For arbitrary delimiter we need the whole text to split, so read eagerly.
    val stream = ResourceLoader::class.java.getResourceAsStream("/$name.txt")
        ?: throw IllegalArgumentException("Resource not found: $name.txt")
    return stream.bufferedReader().use { readInputFromText(it.readText(), delimiter) }
}

/**
 * Variant that reads input from a raw String. Useful for tests.
 */
fun readInputFromString(text: String, delimiter: String? = null): Sequence<String> =
    readInputFromText(text, delimiter)

/**
 * Private helper that reads from any text and returns the same Sequence behaviour.
 * It centralizes trimming and splitting so callers don't duplicate that logic.
 */
private fun readInputFromText(text: String, delimiter: String? = null): Sequence<String> {
    val trimmed = text.trim()
    return if (delimiter != null) {
        trimmed.split(delimiter).asSequence()
    } else {
        trimmed.lineSequence()
    }
}

/**
 * Converts string to .md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/** Converts String to a list of .digits. */
fun String.digits() = this.map { it.digitToInt() }

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
