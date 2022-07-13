package core

/**
 * Here lie some [numerical integration methods](https://en.wikipedia.org/wiki/Numerical_integration).
 *
 * Methods for one-dimensional integrals
 *
 * └── Quadrature rules:
 *  - [RECTANGLE]
 *  - [TRAPEZOIDAL]
 *  - [SIMPSONS]
 *  - [GUASSIAN]
 *
 *  └── Generalized midpoint rule:
 *  - [MIDPOINT]
 *
 * TODO: Include the rest.
 */
enum class Methods {
    RECTANGLE,
    TRAPEZOIDAL,
    SIMPSONS,
    GUASSIAN,
    MIDPOINT
}
