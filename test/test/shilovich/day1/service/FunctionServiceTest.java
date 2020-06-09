package test.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.service.FunctionService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class FunctionServiceTest {

    FunctionService functionService = new FunctionService();
    PrintToConsole printToConsole = new PrintToConsole();

    @Test(priority = 1)
    public void testHypotenuseCalculationPositive() {
        double actual = functionService.calculateHypotenuse(12D, 5D);
        double expected = 13D;
        assertEquals(actual, expected);
    }

    @Test(priority = 2, dependsOnMethods = "testHypotenuseCalculationPositive")
    public void testHypotenuseCalculationNegative() {
        double actual = functionService.calculateHypotenuse(12D, 5D);
        double expected = 1D;
        assertNotEquals(actual, expected);
    }

    @Test(priority = 3)
    public void testIsNumberPerfectPositive() {
        boolean actual = functionService.isPerfect(6);
        assertTrue(actual);
    }

    @Test(priority = 4, dependsOnMethods = "testIsNumberPerfectPositive")
    public void testIsNumberPerfectNegative() {
        boolean actual = functionService.isPerfect(4);
        assertFalse(actual);
    }

    @Test(priority = 5)
    public void testIsNumberEvenPositive() {
        boolean actual = functionService.isEvenNumber(4);
        assertTrue(actual);
    }

    @Test(priority = 6, dependsOnMethods = "testIsNumberEvenPositive")
    public void testIsNumberEvenNegative() {
        boolean actual = functionService.isPerfect(5);
        assertFalse(actual);
    }

    @Test(priority = 7)
    public void testSquareCalculationPositive() {
        double actual = functionService.calculateSquare(4D);
        double expected = 16D;
        assertEquals(actual, expected);
    }

    @Test(priority = 8, dependsOnMethods = "testSquareCalculationPositive")
    public void testSquareCalculationNegative() {
        double actual = functionService.calculateSquare(4D);
        double expected = 7D;
        assertNotEquals(actual, expected);
    }

    @Test(priority = 9)
    public void testTaskOnePositive() {
        try {
            double actual = functionService.runTaskOne(43D);
            double expected = 9D;
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 10, dependsOnMethods = "testTaskOnePositive")
    public void testTaskOneNegative() {
        try {
            double actual = functionService.runTaskOne(0D);
            double expected = 7D;
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 11, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Value is null")
    public void testTaskOneException() throws IncorrectDataException {
        functionService.runTaskOne(2.4);
    }
}
