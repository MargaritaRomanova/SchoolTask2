import java.util.Scanner;

import static rita.model.Calculator.execute;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the first value");
        String one = in.nextLine();
        System.out.println("Input the second value");
        String two = in.nextLine();
        System.out.println("Input sing");
        String sign = in.nextLine();
        String[] params = new String[]{sign, one, two};
        System.out.println("Answer: " + execute(params));
    }
}
