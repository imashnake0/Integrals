package extensions

import kotlin.math.pow
import kotlin.math.round

/**
 * Rounds a [Double] to [numberOfPlaces].
 */
fun Double.roundTo(numberOfPlaces: Int): Double {
    return round(this*10.0.pow(numberOfPlaces)) /10.0.pow(numberOfPlaces)
}
