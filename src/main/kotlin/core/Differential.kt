package core

class Differential(val f: (Double, Double) -> Double) {
    fun solve(
        initialX: Double,
        initialY: Double,
        untilX: Double,
        precision: Double
    ): MutableMap<Double, Double> {
        var x = initialX
        var y = initialY
        val points = mutableMapOf<Double, Double>()

        while (x <= untilX) {
            points[x] = y
            x += precision
            y += precision*f(x, y)
        }

        return points
    }
}
