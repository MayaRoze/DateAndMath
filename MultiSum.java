public class MultiSum extends Function {
    private Function[] addends; //the addends of the multi-sum

    /**
     * constructor
     *
     * @param addends the functions to be summed
     */
    public MultiSum(Function... addends) { //TODO: might need to overload constructor
        this.addends = addends;
    }

    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : addends) {
            sum += function.valueAt(x);
        }
        return sum;
    }

    @Override
    public String toString() {
        int functionsLen = addends.length;
        String[] functionStrings = new String[functionsLen];
        for (int i = 0; i < functionsLen; i++)
            functionStrings[i] = addends[i].toString();
        return String.format("(%s)", String.join(" + ", functionStrings));
    }

    @Override
    public MultiSum derivative() {
        int functionsLen = addends.length;
        Function[] derivatives = new Function[functionsLen];
        for (int i = 0; i < functionsLen; i++) {
            derivatives[i] = addends[i].derivative();
        }
        return new MultiSum(derivatives);
    }
}
