package samples

import core.Differential
import kotlin.math.sin
import kotlin.math.PI

fun main() {
    val solution = Differential {
            x, _ -> sin(x)
    }.solve(
        initialX = 0.0,
        initialY = -1.0,
        untilX = PI,
        precision = 0.01
    )

    var pointsString = ""
    for (i in solution.keys) {
        pointsString += "("
        pointsString += i
        pointsString += ", "
        pointsString += solution.getValue(i)
        pointsString += "), "
    }

    pointsString = pointsString.substring(0..(pointsString.lastIndex - 2))

    // Copy this and paste it in https://www.desmos.com/calculator.
    print(pointsString)
}