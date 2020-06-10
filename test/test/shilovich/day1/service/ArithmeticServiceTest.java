package test.shilovich.day1.service;

import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.service.ArithmeticService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.fail;

public class ArithmeticServiceTest {

    ArithmeticService arithmeticService;

    @BeforeClass
    public void setUp() {
        arithmeticService = new ArithmeticService();
    }

    @Test(priority = 1)
    public void testTaskEightPositive() {
        double actual = arithmeticService.runTaskEight(3);
        double expected = 9D;
        assertEquals(actual, expected);
    }

    @Test(priority = 2, dependsOnMethods = "testTaskEightPositive")
    public void testTaskEightNegative() {
        double actual = arithmeticService.runTaskEight(3);
        double expected = 2D;
        assertNotEquals(actual, expected);
    }

    @Test(priority = 3)
    public void testTaskTenPositive() {
        try {
            Map<Double, Double> actual = arithmeticService.runTaskTen(1D, 2D, 1D);
            Map<Double, Double> expected = new HashMap<>();
            expected.put(1D, 1.5574077246549023D);
            expected.put(2D, -2.185039863261519D);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 4, dependsOnMethods = "testTaskTenPositive")
    public void testTaskTenNegative() {
        try {
            Map<Double, Double> actual = arithmeticService.runTaskTen(1D, 2D, 1D);
            Map<Double, Double> expected = new HashMap<>();
            expected.put(1D, 1D);
            expected.put(2D, 2D);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 5, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter the correct area")
    public void testTaskTenException() throws IncorrectDataException {
        arithmeticService.runTaskTen(4D, 1D, 1);
    }

    @Test(priority = 6)
    public void testCalculationFirstPositive() {
        double actual = arithmeticService.calculateFirst(3);
        double expected = 9D;
        assertEquals(actual, expected);
    }

    @Test(priority = 7, dependsOnMethods = "testCalculationFirstPositive")
    public void testCalculationFirstNegative() {
        double actual = arithmeticService.calculateFirst(3);
        double expected = 4D;
        assertNotEquals(actual, expected);
    }

    @Test(priority = 8)
    public void testCalculationSecondPositive() {
        double actual = arithmeticService.calculateSecond(2);
        double expected = 0.5D;
        assertEquals(actual, expected);
    }

    @Test(priority = 9, dependsOnMethods = "testCalculationSecondPositive")
    public void testCalculationSecondNegative() {
        double actual = arithmeticService.calculateSecond(4);
        double expected = 1D;
        assertNotEquals(actual, expected);
    }
}
