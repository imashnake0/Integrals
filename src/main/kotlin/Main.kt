@file:Suppress("LocalVariableName")

import core.Integral
import core.Methods.TRAPEZOIDAL
import jetbrains.letsPlot.export.ggsave
import jetbrains.letsPlot.geom.geomPath
import jetbrains.letsPlot.ggsize
import jetbrains.letsPlot.letsPlot
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

fun main() {
    val R = 1.0
    val r = sqrt(5.0)
    val thetaP = 1.107148
    var phiP = 0.0

    val AxList = mutableListOf<Double>()
    val AyList = mutableListOf<Double>()

    repeat(100) {
        val Ax = Integral { phi ->
            -1*sin(phi)/sqrt(R*R + r*r - 2*R*r*sin(thetaP)*cos(phiP - phi))
        }.integrate(
            from = 0.0,
            to = 2* PI,
            differential = 0.00001,
            method = TRAPEZOIDAL
        )

        val Ay = Integral { phi ->
            cos(phi)/sqrt(R*R + r*r - 2*R*r*sin(thetaP)*cos(phiP - phi))
        }.integrate(
            from = 0.0,
            to = 2* PI,
            differential = 0.00001,
            method = TRAPEZOIDAL
        )

        phiP += 2*PI/100

        println("${Ax*Ax + Ay*Ay}")

        AxList.add(Ax)
        AyList.add(Ay)
    }

    AxList.add(AxList[0])
    AyList.add(AyList[0])

    val data = mapOf<String, Any>("Aₓ" to AxList, "Aᵧ" to AyList)

    val fig = letsPlot(data) + geomPath (
        color = "dark-green",
        size = 1.0
    ) {
        x = "Aₓ"
        y = "Aᵧ"
    } + ggsize(1000, 1000)

    ggsave(fig, "plot.png")
}
