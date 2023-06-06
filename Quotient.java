public class Quotient extends Function {
    /**the numerator of the quotient*/
    private Function numerator;
    /**the denominator of the quotient*/
    private Function denominator;

    /**constructor*/
    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double valueAt(double x) {
        return numerator.valueAt(x) / denominator.valueAt(x);
    }

    @Override
    public String toString() {
        return String.format("(%s / %s)", numerator.toString(), denominator.toString());
    }

    @Override
    public Quotient derivative() {
        Function numerator = new Difference(new Product(this.numerator.derivative(), denominator),
                new Product(denominator.derivative(), this.numerator));
        Function denominator = new Power(this.denominator, 2);
        return new Quotient(numerator, denominator);
    }
}
