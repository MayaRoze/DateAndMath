import java.lang.Math;

public abstract class Function {
    public static final double DEFAULT_EPSILON = Math.pow(10, -5);

    public abstract double valueAt(double x);

    @Override
    public abstract String toString();

    public abstract Function derivative();

    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a, right = b;
        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            if (valueAt(left) * valueAt(right) > 0) left = mid;
            else right = mid;
        }
        return (left + right) / 2;
    }

    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, DEFAULT_EPSILON);
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;
        Function quotient = new Quotient(this, this.derivative());
        while (Math.abs(valueAt(x)) < epsilon) {
            x = x - quotient.valueAt(x);
        }
        return x;
    }

    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, DEFAULT_EPSILON);
    }

    public Function taylorPolynomial(int n) {
        Function currFunction = this;
        double[] coefficients = new double[n + 1];
        coefficients[0] = valueAt(0);
        double factorial = 1.0;
        currFunction = derivative();
        for (int i = 1; i < n; i++) {
            factorial *= i;
            double coefficient = 1 / factorial;
            coefficient *= currFunction.valueAt(0);
            coefficients[i] = coefficient;
            currFunction = derivative();
        }
        return new Polynomial(coefficients);
    }
}
