package zhus.javamentortestcalculator;

public class Number {

    boolean isRome;
    Integer value;

    public Number(String str) throws Exception {
        try {
            this.value = Integer.parseInt(str);
            this.isRome = false;
        } catch (Exception e) {
            this.value = RomanNumeral.parseRomanInt(str);
            this.isRome = true;
        }
    }

    public Number(int value, boolean isRome) {
        this.isRome = isRome;
        this.value = value;
    }

    public Number apply(String operator, Number op) throws Exception {
        return new Number(Operators.get(operator).apply(this.value, op.value), this.isRome);
    }

    public String toNumberString() throws Exception {
        return isRome ? RomanNumeral.toRomanString(value)
               : value.toString();
    }

}
