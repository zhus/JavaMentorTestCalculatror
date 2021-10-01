package zhus.javamentortestcalculator;

public class Xpression {

    String raw;

    Number firstOperand;
    Number secondOperand;
    String operation;

    String result;

    public Xpression(String str) {
        this.raw = str;
    }

    public Xpression parse() throws Exception {

        String[] split = raw.split("\\s+");
        if (split.length != 3) {
            throw new Exception("выражение не соответствует образцу: a + b, a - b, a * b, a / b");
        }

        firstOperand = new Number(split[0]);
        secondOperand = new Number(split[2]);
        if (firstOperand.isRome != secondOperand.isRome) {
            throw new Exception("операнды должны быть одного типа");
        }
        if (firstOperand.value < 1 || firstOperand.value > 10 || secondOperand.value < 1 || secondOperand.value > 10) {
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
        }

        operation = split[1];
        if (Operators.get(split[1]) == null) {
            throw new Exception("неподдерживаемая операция");
        }

        return this;
    }

    public Xpression evaluate() throws Exception {
        result = firstOperand.apply(operation, secondOperand).toNumberString();
        return this;
    }

    @Override
    public String toString() {
        return result;
    }

}
