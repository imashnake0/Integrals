package core

class Integral(val integrand: (Double) -> Double) {
    fun integrate(
        from: Double,
        to: Double,
        differential: Double
    ): Double {
        var x = from
        var integral = 0.0

        while(x <= to) {
            x += differential
            integral += integrand(x)*differential
        }

        return integral
    }
}
