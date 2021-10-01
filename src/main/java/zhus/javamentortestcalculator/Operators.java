package zhus.javamentortestcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Operators {

    private static final Map<String, BinaryOperator<Integer>> operators = new HashMap<>();

    static {
        operators.put("+", (a, b) -> {
                  return a + b;
              });
        operators.put("-", (a, b) -> {
                  return a - b;
              });
        operators.put("*", (a, b) -> {
                  return a * b;
              });
        operators.put("/", (a, b) -> {
                  return a / b;
              });
    }

    public static BinaryOperator<Integer> get(String op) {
        return operators.get(op);
    }

    private Operators() {
    }

}
