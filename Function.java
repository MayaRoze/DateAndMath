import java.lang.Math;

public abstract class Function {
    /** the default error for roots*/
    public static final double DEFAULT_EPSILON = Math.pow(10, -5);

    /**returns the value of the function at point x*/
    public abstract double valueAt(double x);

    @Override
    public abstract String toString();

    /**returns the derivative function of this function*/
    public abstract Function derivative();

    /**
     * calculates the square root of the function in the domain [a,b] with an error smaller than epsilon
     * using the Bisection Method
     *
     * @param a       the start of the domain
     * @param b       the end of the domain
     * @param epsilon the maximum error
     * @return the square root of the function in the domain [a,b] with an error smaller than epsilon
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a, right = b;
        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) left = mid;
            else right = mid;
        }
        return (left + right) / 2;
    }

    /**
     * calculates the square root of the function in the domain [a,b] with an error smaller than the default epsilon
     * using the Bisection Method
     *
     * @param a the start of the domain
     * @param b the end of the domain
     * @return the square root of the function in the domain [a,b] with an error smaller than the default epsilon
     */
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, DEFAULT_EPSILON);
    }

    /**
     * calculates the square root of the function an epsilon distance away from point a
     * using the Newton Raphson Method
     *
     * @param a       the point in question
     * @param epsilon the distance from the point
     * @return the square root of the function an epsilon distance away from point a
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;
        Function quotient = new Quotient(this, this.derivative());
        while (Math.abs(valueAt(x)) >= epsilon) {
            x = x - quotient.valueAt(x);
        }
        return x;
    }

    /**
     * calculates the square root of the function the default epsilon distance away from point a
     * using the Newton Raphson Method
     *
     * @param a the point in question
     * @return the square root of the function the default epsilon distance away from point a
     */
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, DEFAULT_EPSILON);
    }

    /**
     * calculates the partial sum of the taylor series of this function, expands it up to n
     *
     * @param n the n in question
     * @return the function of the taylor series expansion up to n
     */
    public Function taylorPolynomial(int n) {
        Function currFunction = this;
        double[] coefficients = new double[n + 1];
        coefficients[0] = valueAt(0);
        double factorial = 1.0;
        currFunction = currFunction.derivative();
        for (int i = 1; i < n + 1; i++) {
            factorial *= i;
            double coefficient = currFunction.valueAt(0) / factorial;
            coefficients[i] = coefficient;
            currFunction = currFunction.derivative();
        }
        return new Polynomial(coefficients);
    }
}
