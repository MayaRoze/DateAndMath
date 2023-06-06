public class Power extends Function {
    private Function base; //the base of the power
    private int exponent; //the exponent of the number (whole positive number)

    /*constructor*/
    public Power(Function base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public double valueAt(double x) {
        return Math.pow(base.valueAt(x), exponent);
    }

    @Override
    public String toString() {
        return String.format("(%s^%d)", base.toString(), exponent);
    }

    @Override
    public Function derivative() {
        if (exponent == 1) return base.derivative();
        else {
            return new MultiProduct(new Constant(exponent), new Power(base, exponent - 1), base.derivative());
        }
    }
}
