import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static rita.model.Calculator.execute;

public class PositiveCalculatorTest {

    @DataProvider
    public Object[][] positiveData() {
        return new Object[][]
                {{"+", "4", "5", "9"},
                        {"-", "3", "2", "1"},
                        {"*", "5", "6", "30"},
                        {"/", "8", "2", "4"}};
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String sign, String one, String two, String result) {
        String[] params = new String[]{sign, one, two, result};
        execute(params);
    }
}
