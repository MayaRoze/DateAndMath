public class Sum extends Function {
    private Function addend1; //the first addend of the sum
    private Function addend2; //the second addend of the sum

    /*constructor*/
    public Sum(Function addend1, Function addend2) {
        this.addend1 = addend1;
        this.addend2 = addend2;
    }

    @Override
    public double valueAt(double x) {
        return addend1.valueAt(x) + addend2.valueAt(x);
    }

    @Override
    public String toString() {
        return String.format("(%s + %s)", addend1.toString(), addend2.toString());
    }

    @Override
    public Sum derivative() {
        return new Sum(addend1.derivative(), addend2.derivative());
    }
}
