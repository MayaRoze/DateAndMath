public class Product extends Function {
    protected Function function1;
    protected Function function2;

    public Product(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) * function2.valueAt(x);
    }

    @Override
    public String toString() {
        return String.format("(%s * %s)", function1.toString(), function2.toString());
    }

    @Override
    public Function derivative() {
        return new Sum(new Product(function1.derivative(), function2),
                new Product(function2.derivative(), function1));
    }
}
