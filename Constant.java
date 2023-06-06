public class Constant extends Function {
    /**the value of the constant*/
    private final double value;

    /**
     * constructor
     *
     * @param value the value of the constant
     */
    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double valueAt(double x) {
        return value;
    }

    /**true if num is a whole number, else otherwise*/
    private boolean checkIfInt(double num) {
        return num == (int) num;
    }

    @Override
    public String toString() {
        if (checkIfInt(value)) return String.format("(%d)", (int) value);
        return "(" + value + ")";
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }

}
