package core

import core.Methods.*

/**
 * TODO: Kdoc.
 */
class Integral(val integrand: (Double) -> Double) {
    fun integrate(
        from: Double,
        to: Double,
        differential: Double,
        method: Methods = SIMPSONS
    ): Double {
        when(method) {
            RECTANGLE -> TODO()
            TRAPEZOIDAL -> TODO()
            SIMPSONS -> TODO()
            else -> {
                var x = from
                var integral = 0.0

                while(x <= to) {
                    x += differential
                    integral += integrand(x)*differential
                }

                return integral
            }
        }
    }
}
