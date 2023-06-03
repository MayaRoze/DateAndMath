public class MultiSum extends Function {
    private Function[] functions;

    public MultiSum(Function... functions) { //TODO: might need to overload constructor
        this.functions = functions;
    }

    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }

    @Override
    public String toString() {
        int functionsLen = functions.length;
        String[] functionStrings = new String[functionsLen];
        for (int i = 0; i < functionsLen; i++)
            functionStrings[i] = functions[i].toString();
        return String.format("(%s)", String.join(" + ", functionStrings));
    }

    @Override
    public MultiSum derivative() {
        int functionsLen = functions.length;
        Function[] derivatives = new Function[functionsLen];
        for (int i = 0; i < functionsLen; i++) {
            derivatives[i] = functions[i].derivative();
        }
        return new MultiSum(derivatives);
    }
}
