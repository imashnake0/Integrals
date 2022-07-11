@file:Suppress("LocalVariableName")

import core.Integral
import core.Methods.*
import kotlin.math.*

fun main() {
    val R = 1.0
    val r = sqrt(5.0)
    val thetaP = 1.107148
    val phiP = PI/4

    val A_x = Integral { phi ->
        -1*sin(phi)/sqrt(R*R + r*r - 2*R*r*sin(thetaP)*cos(phiP - phi))
    }.integrate(
        from = 0.0,
        to = 2* PI,
        differential = 0.0001,
        method = TRAPEZOIDAL
    )

    val A_y = Integral { phi ->
        cos(phi)/sqrt(R*R + r*r - 2*R*r*sin(thetaP)*cos(phiP - phi))
    }.integrate(
        from = 0.0,
        to = 2* PI,
        differential = 0.0001,
        method = TRAPEZOIDAL
    )

    println("$A_x, $A_y")
}
