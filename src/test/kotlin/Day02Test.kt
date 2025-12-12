class Day02Test : AbstractDayTest<Sequence<String>, Long>() {
    override val day = Day02

    override val inputText =
        "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    override val expectedPart1 = 1227775554L
    override val expectedPart2 = 4174379265L
}
