public class Difference extends Function {
    /**the first part of the difference*/
    private Function minuend;
    /**the second part of the difference*/
    private Function subtrahend;

    /**
     * constructor
     *
     * @param minuend    the first part of the difference
     * @param subtrahend the second part of the difference
     */
    public Difference(Function minuend, Function subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }

    @Override
    public double valueAt(double x) {
        return minuend.valueAt(x) - subtrahend.valueAt(x);
    }

    @Override
    public String toString() {
        return String.format("(%s - %s)", minuend.toString(), subtrahend.toString());
    }

    @Override
    public Difference derivative() {
        return new Difference(minuend.derivative(), subtrahend.derivative());
    }
}
