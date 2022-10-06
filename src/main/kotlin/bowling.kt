var score = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

fun main() {

    val pins = listOf(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6)
    val pins2 = listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    val pins3 = listOf(7, 0, 0, 0, 1, 0, 0, 0, 8, 1, 0, 10, 1, 6, 1, 0, 0, 0, 10, 0, 4)
    val pins4 = listOf(7, 0, 8, 2, 0, 0, 10, 9, 0, 5, 5, 4, 2, 3, 4, 3, 6, 2, 8, 4)


    println(series(pins))

    clean()

    println(series(pins2))

    clean()

    println(series(pins3))

    clean()

    println(series(pins4))

}

fun series(pins: List<Int>): List<Int> {

    var c = 0
    var i = 0
    while (i < pins.size && c < score.size) {

        if (pins[i] == 10) {

            strike(score, pins[i], pins[i + 1], pins[i + 2], c)
            i++

        } else if (pins[i] + pins[i + 1] < 10) {

            open(score, pins[i], pins[i + 1], c)
            if (i + 2 >= pins.size) {
                i++
            } else {
                i += 2
            }

        } else if (pins[i] + pins[i + 1] == 10) {

            spare(score, pins[i], pins[i + 1], pins[i + 2], c)
            if (i + 2 >= pins.size) {
                i++
            } else {
                i += 2
            }

        }
        c++
    }

    return score
}

private fun strike(score: MutableList<Int>, a: Int, b: Int, c: Int, i: Int) {

    score[i] = score[i] + a + b + c
    if (i < 9) {
        score[i + 1] = score[i]
    }

}

private fun open(score: MutableList<Int>, a: Int, b: Int, i: Int) {

    score[i] = score[i] + a + b
    if (i < 9) {
        score[i + 1] = score[i]
    }

}

private fun spare(score: MutableList<Int>, a: Int, b: Int, c: Int, i: Int) {

    score[i] = score[i] + a + b + c
    if (i < 9) {
        score[i + 1] = score[i]
    }

}

fun clean() {

    score = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

}