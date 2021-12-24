package model;

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
        if (params[2].equals("-0.0") || params[2].equals("0.0")
                || params[2].equals("0") && params[0].equals("/")) {
            throw new CalculatorException("Can`t divide by 0");
        }

        try {
            int param1 = Integer.parseInt(params[1]);
            int param2 = Integer.parseInt(params[2]);

            if ((param1 >= Integer.MAX_VALUE || param1 <= Integer.MIN_VALUE)
                    || (param2 >= Integer.MAX_VALUE || param2 <= Integer.MIN_VALUE)) {
                throw new CalculatorException("Invalid value");
            }

            switch (params[0]) {
                case "+": {
                    int plus = param1 + param2;
                    return Integer.toString(plus);
                }
                case "-": {
                    int minus = param1 - param2;
                    return Integer.toString(minus);
                }
                case "*": {
                    int multiply = param1 * param2;
                    return Integer.toString(multiply);
                }
                case "/": {
                    int divide = param1 / param2;
                    return Integer.toString(divide);
                }
            }
        } catch (NumberFormatException e) {
            throw new CalculatorException("Invalid value");
        }


        return "";
    }
}
