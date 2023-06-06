public class MultiSum extends Function {
    /**the addends of the multi-sum*/
    private Function[] addends;

    /**
     * constructor
     *
     * @param addends the functions to be summed
     */
    public MultiSum(Function addend1, Function addend2 , Function... addends) {
        this.addends = new Function[addends.length + 2];
        this.addends[0] = addend1;
        this.addends[1] = addend2;
        for (int i = 0; i < addends.length; i++) this.addends[i+2] = addends[i];
    }

    /**a private constructor which gets the array of factors without checking if the array contains at least 2 factors*/
    private MultiSum(Function[] addends){
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
