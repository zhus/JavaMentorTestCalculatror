package zhus.javamentortestcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author zhus
 */
public class XpressionTest {

    public XpressionTest() {

    }

    @org.junit.jupiter.api.Test
    public void testResults() {

        Map<String, String> tests;

        tests = new HashMap<>();
        tests.put("1 + 1", "2");
        tests.put("VI / III", "II");
        tests.put("1 - 1", "0");
        tests.put("1 - 4", "-3");
        tests.put("5 / 2", "2");

        for (Map.Entry<String, String> test : tests.entrySet()) {
            try {
                String res = new Xpression(test.getKey()).parse().evaluate().toString();
                assertEquals(res, test.getValue(),
                             "выражение:\n\t" + test.getKey()
                             + "\nожидаем:\n\t" + test.getValue()
                             + "\nполучили:\n\t" + res);
            } catch (Exception ex) {
                fail("выражение:\n\t" + test.getKey() + "\n вызвало незапланированное исключение");
            }
        }

        tests = new HashMap<>();
        tests.put("", "образцу");
        tests.put("1", "образцу");
        tests.put("1 + 2 + 3", "образцу");
        tests.put("I + 1", "одного");
        tests.put("I - II", "диапа");

        for (Map.Entry<String, String> test : tests.entrySet()) {
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> new Xpression(test.getKey()).parse().evaluate().toString(),
                    test.getKey() + " не выбросило исключение"
            );
            assertTrue(thrown.getMessage().contains(test.getValue()), "не вывело " + test.getValue());
        }

    }

}
