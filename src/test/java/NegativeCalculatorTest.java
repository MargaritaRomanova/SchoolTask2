import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rita.model.CalculatorException;

import static rita.model.Calculator.execute;

public class NegativeCalculatorTest {

    @DataProvider
    public Object[][] negativeData() {
        return new Object[][]
                {{"plus", "4", "5"},
                        {"-", null, "2"},
                        {"*", "5", "six"},
                        {"/", "8", "0"}};
    }

    @Test(dataProvider = "negativeData", expectedExceptions = CalculatorException.class)
    public void negativeTest(String sign, String one, String two) {
        String[] params = new String[]{sign, one, two};
        execute(params);
    }
}
