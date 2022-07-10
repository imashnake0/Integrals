package core

import core.Methods.*
import kotlin.math.abs

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
            RECTANGLE -> {
                var x = from
                var integral = 0.0

                while(x <= to) {
                    integral += integrand(x + differential/2)*differential
                    x += differential
                }
                return integral
            }
            TRAPEZOIDAL -> {
                // This is actually exactly equivalent to the midpoint rectangle rule!
                var x = from
                var integral = 0.0

                while(x <= to) {
                    integral += integrand(x + differential/2)*differential
                    x += differential
                }
                return integral
            }
            SIMPSONS -> TODO()
            else -> TODO()
        }
    }
}
