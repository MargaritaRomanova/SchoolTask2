package rita.model;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static String execute(String[] params) {
        List<String> signs = Arrays.asList("+", "-", "*", "/");
        if (!signs.contains(params[0])) {
            throw new CalculatorException("The sign is not correct");
        }
        if (params[1] == null || params[2] == null) {
            throw new CalculatorException("The value can`t be NULL");
        }
        if (params[2].equals("0") && params[0].equals("/")) {
            throw new CalculatorException("Can`t divide by 0");
        }

        try {
            double param1 = Double.parseDouble(params[1]);
            double param2 = Double.parseDouble(params[2]);

            switch (params[0]) {
                case "+": {
                    double plus = param1 + param2;
                    return Double.toString(plus);
                }
                case "-": {
                    double minus = param1 - param2;
                    return Double.toString(minus);
                }
                case "*": {
                    double multiply = param1 * param2;
                    return Double.toString(multiply);
                }
                case "/": {
                    double divide = param1 / param2;
                    return Double.toString(divide);
                }
            }
        } catch (NumberFormatException e) {
            throw new CalculatorException("Invalid value");
        }
        return "";
    }
}
