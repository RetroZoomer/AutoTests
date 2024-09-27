package FirstTest;


import org.example.calc.Calc;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    private Calc calc = new Calc();
    protected final double FIRST_NUMBER = 5;
    protected final double SECOND_NUMBER = 3;


    @Test
    public void checkAdd() {
        double expectedResult = FIRST_NUMBER + SECOND_NUMBER; // 5 + 3 = 8
        double actualResult = calc.add(FIRST_NUMBER, SECOND_NUMBER);

        Assert.assertEquals(actualResult, expectedResult, "Ответ должен был быть: 8");
    }
}
