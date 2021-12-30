import java.util.Scanner;

import static model.Calculator.execute;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       // System.out.println("Input the first value");
        String sign = in.nextLine();
       // System.out.println("Input the second value");
        String one = in.nextLine();
       // System.out.println("Input sing");
        String two = in.nextLine();
        String[] params = new String[]{sign, one, two};
        System.out.println(execute(params));
    }
}
