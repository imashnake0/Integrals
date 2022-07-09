import core.Integral
import extensions.roundTo
import org.junit.Test
import kotlin.math.*
import kotlin.test.assertEquals

/**
 * Class to test the results of [Integral] for some simple and
 * [nonelementary](https://en.wikipedia.org/wiki/Nonelementary_integral) integrals.
 */
class IntegralTest {
    /**
     * [Testing the Guassian integral](https://en.wikipedia.org/wiki/Gaussian_integral).
     */
    @Test
    fun guassianTest() {
        val precision = 4

        val area = Integral { x ->
            E.pow(-1*x*x)
        }.integrate(
            from = 0.0,
            to = 1000.0,
            differential = 1E-5
        ).roundTo(precision)

        val sqrtPI = (sqrt(PI)/2).roundTo(precision)

        assertEquals(
            area,
            sqrtPI,
            """
                Area:  $area
                √π/2:  $sqrtPI
                Error: ${abs(area - sqrtPI)};
            """.trimIndent()
        )
    }
}
