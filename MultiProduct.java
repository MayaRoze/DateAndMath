public class MultiProduct extends Function {
    private Function[] factors; //the factors of the multi-product

    /**
     * constructor
     *
     * @param factors the functions to be multiplied
     */
    public MultiProduct(Function factor1, Function factor2 , Function... factors) {
        this.factors = new Function[factors.length + 2];
        this.factors[0] = factor1;
        this.factors[1] = factor2;
        for (int i = 0; i < factors.length; i++) this.factors[i+2] = factors[i];
    }

    /*a private constructor which gets the array of factors without checking if the array contains at least 2 factors*/
    private MultiProduct(Function[] factors){
        this.factors = factors;
    }

    @Override
    public double valueAt(double x) {
        double product = 1.0;
        for (Function function : factors) {
            product *= function.valueAt(x);
        }
        return product;
    }

    @Override
    public String toString() {
        int functionsLen = factors.length;
        String[] functionStrings = new String[functionsLen];
        for (int i = 0; i < functionsLen; i++)
            functionStrings[i] = factors[i].toString();
        return String.format("(%s)", String.join(" * ", functionStrings));
    }

    @Override
    public MultiSum derivative() {
        int functionsLen = factors.length;
        int productIndex = 1;
        Function[] product = new Function[functionsLen];
        MultiProduct[] derivatives = new MultiProduct[functionsLen];
        MultiProduct[] restOfDerivatives = new MultiProduct[functionsLen-2];
        for (int i = 0; i < functionsLen; i++) {
            for (int j = 0; j < functionsLen; j++) {
                if (i == j) {
                    product[0] = factors[j].derivative();
                } else {
                    product[productIndex] = factors[j];
                    productIndex++;
                }
            }
            productIndex = 1;
            derivatives[i] = new MultiProduct(product.clone());
        }
        for (int i = 0; i < functionsLen - 2; i++) restOfDerivatives[i] = derivatives[i+2];
        return new MultiSum(derivatives[0], derivatives[1], restOfDerivatives);
    }
}
