@file:Suppress("LocalVariableName")

import core.Integral
import core.Methods.*
import extensions.roundTo
import kotlin.math.*

fun main() {
    val R = 1.0
    val r = sqrt(5.0)
    val thetaP = 1.107148
    var phiP = 0.0

    repeat(100) {
        val A_x = Integral { phi ->
            -1*sin(phi)/sqrt(R*R + r*r - 2*R*r*sin(thetaP)*cos(phiP - phi))
        }.integrate(
            from = 0.0,
            to = 2* PI,
            differential = 0.00001,
            method = TRAPEZOIDAL
        )

        val A_y = Integral { phi ->
            cos(phi)/sqrt(R*R + r*r - 2*R*r*sin(thetaP)*cos(phiP - phi))
        }.integrate(
            from = 0.0,
            to = 2* PI,
            differential = 0.00001,
            method = TRAPEZOIDAL
        )

        phiP += 2*PI/100

        println("${(A_x*A_x + A_y*A_y).roundTo(3)}, ${A_x.roundTo(3)}, ${A_y.roundTo(3)}")
    }
}
