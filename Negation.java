public class Negation extends Function {
    private Function function; //the function to be negated

    /*constructor*/
    public Negation(Function function) {
        this.function = function;
    }

    @Override
    public double valueAt(double x) {
        return (-1) * function.valueAt(x);
    }

    @Override
    public String toString() {
        return String.format("(-%s)", function.toString());
    }

    @Override
    public Function derivative() {
        return new Negation(function.derivative());
    }
}
