public class Quotient extends Function {
    private Function function1;
    private Function function2;

    public Quotient(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) / function2.valueAt(x);
    }

    @Override
    public String toString() {
        return String.format("(%s / %s)", function1.toString(), function2.toString());
    }

    @Override
    public Quotient derivative() {
        Function numerator = new Difference(new Product(function1.derivative(), function2),
                new Product(function2.derivative(), function1));
        Function denominator = new Power(function2, 2);
        return new Quotient(numerator, denominator);
    }
}
