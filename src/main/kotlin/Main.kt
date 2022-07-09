@file:Suppress("LocalVariableName")

import kotlin.math.*

fun main() {
    val R = 1.0
    val thetaP = 0.0
    val phiP = PI/4

    val Ax = integrate(
        lowerBound = 0.0,
        upperBound = R,
        precision = 0.001
    ) { r ->
        integrate(
            lowerBound = 0.0,
            upperBound = 2*PI,
            precision = 0.0001
        ) { phi ->
            -1*sin(phi)/(sqrt(R*R + r*r - 2*R*r*sin(thetaP)*cos(phiP - phi)))
        }
    }

    val Ay = integrate(
        lowerBound = 0.0,
        upperBound = R,
        precision = 0.001
    ) { r ->
        integrate(
            lowerBound = 0.0,
            upperBound = 2*PI,
            precision = 0.0001
        ) { phi ->
            -1*sin(phi)/(sqrt(R*R + r*r - 2*R*r*sin(thetaP)*cos(phiP - phi)))
        }
    }

    print("A = ${Ax.roundTo(3)} x̂ + ${Ay.roundTo(3)} ŷ")
}

fun integrate(
    lowerBound: Double,
    upperBound: Double,
    precision: Double,
    integrand: (Double) -> Double
): Double {
    var x = lowerBound
    var integral = 0.0

    while(x <= upperBound) {
        x += precision
        integral += integrand(x)*precision
    }

    return integral
}

/**
 * Rounds a [Double] to [numberOfPlaces].
 */
fun Double.roundTo(numberOfPlaces: Int): Double {
    return round(this*10.0.pow(numberOfPlaces))/10.0.pow(numberOfPlaces)
}