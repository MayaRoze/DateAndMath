public class Difference extends Function {
    private Function minuend; //the first part of the difference
    private Function subtrahend; //the second part of the difference

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
