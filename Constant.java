public class Constant extends Function {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double valueAt(double x) {
        return value;
    }

    private boolean checkIfInt(double num) {
        return num == (int) num;
    }

    @Override
    public String toString() {
        if (checkIfInt(value)) return String.format("(%d)", (int) value);
        return String.format("(%f)", value);
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }

}
