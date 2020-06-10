package test.shilovich.day1.service;

import com.shilovich.day1.entity.Point;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.service.FunctionService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class FunctionServiceTest {

    FunctionService functionService;
    Point pointA;

    @BeforeClass
    public void setUp() {
        functionService = new FunctionService();
        pointA = new Point();
        pointA.setAxisX(12);
        pointA.setAxisY(5);
    }

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
        boolean condition = functionService.isPerfect(6);
        assertTrue(condition);
    }

    @Test(priority = 4, dependsOnMethods = "testIsNumberPerfectPositive")
    public void testIsNumberPerfectNegative() {
        boolean condition = functionService.isPerfect(4);
        assertFalse(condition);
    }

    @Test(priority = 5)
    public void testIsNumberEvenPositive() {
        boolean condition = functionService.isEvenNumber(4);
        assertTrue(condition);
    }

    @Test(priority = 6, dependsOnMethods = "testIsNumberEvenPositive")
    public void testIsNumberEvenNegative() {
        boolean condition = functionService.isPerfect(5);
        assertFalse(condition);
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
            fail();
        }
    }

    @Test(priority = 10, dependsOnMethods = "testTaskOnePositive")
    public void testTaskOneNegative() {
        try {
            double actual = functionService.runTaskOne(5D);
            double expected = 7D;
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 11, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter an integer")
    public void testTaskOneException() throws IncorrectDataException {
        functionService.runTaskOne(2.4);
    }

    @Test(priority = 12)
    public void testTaskFourPositive() {
        try {
            boolean condition = functionService.runTaskFour(2, 4, 3, 5);
            assertTrue(condition);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 13, dependsOnMethods = "testTaskFourPositive")
    public void testTaskFourNegative() {
        try {
            boolean condition = functionService.runTaskFour(1, 3, 5, 7);
            assertFalse(condition);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 14, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter not null value")
    public void testTaskFourException() throws IncorrectDataException {
        functionService.runTaskFour(1, 2, 3, 0);
    }

    @Test(priority = 15)
    public void testTaskFivePositive() {
        try {
            boolean condition = functionService.runTaskFive(6);
            assertTrue(condition);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 16, dependsOnMethods = "testTaskFourPositive")
    public void testTaskFiveNegative() {
        try {
            boolean condition = functionService.runTaskFive(7);
            assertFalse(condition);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 17, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter not null value")
    public void testTaskFiveException() throws IncorrectDataException {
        functionService.runTaskFive(0);
    }

    @Test(priority = 18)
    public void testTaskSevenPositive() {
        Point pointB = new Point();
        pointB.setAxisX(4);
        pointB.setAxisY(10);
        try {
            Point actual = functionService.runTaskSeven(pointA, pointB);
            Point expected = pointA;
            assertSame(actual, expected);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 19, dependsOnMethods = "testTaskSevenPositive")
    public void testTaskSevenNegative() {
        Point pointB = new Point();
        pointB.setAxisX(10);
        pointB.setAxisY(10);
        try {
            Point actual = functionService.runTaskSeven(pointA, pointB);
            Point expected = pointA;
            assertNotSame(actual, expected);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 20, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter an integer")
    public void testTaskSevenException() throws IncorrectDataException {
        Point pointB = new Point();
        pointB.setAxisX(111);
        pointB.setAxisY(5);
        functionService.runTaskSeven(pointA, pointB);
    }
}

