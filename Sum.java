public class Sum extends Function {
    private Function function1;
    private Function function2;

    public Sum(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) + function2.valueAt(x);
    }

    @Override
    public String toString() {
        return String.format("(%s + %s)", function1.toString(), function2.toString());
    }

    @Override
    public Sum derivative() {
        return new Sum(function1.derivative(), function2.derivative());
    }
}
