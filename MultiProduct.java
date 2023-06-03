public class MultiProduct extends Function {
    private Function[] functions;

    public MultiProduct(Function... functions) {
        this.functions = functions;
    }

    @Override
    public double valueAt(double x) {
        double product = 1.0;
        for (Function function : functions) {
            product *= function.valueAt(x);
        }
        return product;
    }

    @Override
    public String toString() {
        int functionsLen = functions.length;
        String[] functionStrings = new String[functionsLen];
        for (int i = 0; i < functionsLen; i++)
            functionStrings[i] = functions[i].toString();
        return String.format("(%s)", String.join(" * ", functionStrings));
    }

    @Override
    public MultiSum derivative() {
        int functionsLen = functions.length;
        Function[] product = new Function[functionsLen];
        MultiProduct[] derivatives = new MultiProduct[functionsLen];
        for (int i = 0; i < functionsLen; i++) {
            for (int j = 0; j < functionsLen; j++) {
                product[j] = (i == j) ? functions[j].derivative() : functions[j];
            }
            derivatives[i] = new MultiProduct(product);
        }
        return new MultiSum(derivatives);
    }
}
