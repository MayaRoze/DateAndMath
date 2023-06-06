import java.lang.Math;

public class Polynomial extends Function {
    private final double[] coefficients; //the coefficients of the polynomial

    /*constructor*/
    public Polynomial(double... varargs) {
        this.coefficients = varargs;
    }

    /*true if the num is a whole number, false otherwise*/
    private boolean checkIfInt(double num) {
        return num == (int) num;
    }

    @Override
    public double valueAt(double x) {
        double out = 0;
        for (int i = 0; i < coefficients.length; i++) {
            out += coefficients[i] * Math.pow(x, i);
        }
        return out;
    }

    @Override
    public Polynomial derivative() {
        double[] newCoefficients = new double[coefficients.length];
        for (int i = 1; i < coefficients.length; i++) {
            newCoefficients[i - 1] = i * coefficients[i];
        }
        newCoefficients[newCoefficients.length - 1] = 0;
        return new Polynomial(newCoefficients);
    }

    @Override
    public String toString() {
        String s;
        if (checkIfInt(coefficients[0]))
            s = (coefficients[0] == 0) ? "" : String.valueOf((int) coefficients[0]);
        else s = (coefficients[0] == 0) ? "" : String.valueOf(coefficients[0]);
        for (int i = 1; i < coefficients.length; i++) {
            double coefficient = coefficients[i];
            String stringX = i == 1 ? "x" : ("x^" + i);
            if (coefficient == 1.0) {
                s += (s.equals("")) ? stringX : " + " + stringX;
            } else if (coefficient > 0) {
                if (checkIfInt(coefficient))
                    s += (s.equals("")) ? (int) coefficient + stringX : " + " + (int) coefficient + stringX;
                else
                    s += (s.equals("")) ? coefficient + stringX : " + " + coefficient + stringX;
            } else if (coefficient == -1.0) {
                s += (s.equals("")) ? stringX : " - " + stringX;
            } else if (coefficient < 0) {
                if (checkIfInt(coefficient))
                    s += (s.equals("")) ? (int) coefficient + stringX : " - " + (-1 * (int) coefficient) + stringX;
                else
                    s += (s.equals("")) ? coefficient + stringX : " - " + (-1 * coefficient) + stringX;
            }
        }
        return (s.equals("")) ? "(0)" : String.format("(%s)", s);
    }
}
