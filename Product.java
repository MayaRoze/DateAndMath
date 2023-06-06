public class Product extends Function {
    /**the first factor of the product*/
    private Function factor1;
    /**the second factor of the product*/
    private Function factor2;

    /**constructor*/
    public Product(Function factor1, Function factor2) {
        this.factor1 = factor1;
        this.factor2 = factor2;
    }

    @Override
    public double valueAt(double x) {
        return factor1.valueAt(x) * factor2.valueAt(x);
    }

    @Override
    public String toString() {
        return String.format("(%s * %s)", factor1.toString(), factor2.toString());
    }

    @Override
    public Function derivative() {
        return new Sum(new Product(factor1.derivative(), factor2),
                new Product(factor2.derivative(), factor1));
    }
}
