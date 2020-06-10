package test.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.service.TimeService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TimeServiceTest {

    TimeService timeService;
    PrintToConsole printToConsole;

    @BeforeClass
    public void setUp() {
        timeService = new TimeService();
        printToConsole = new PrintToConsole();
    }

    @Test(priority = 1)
    public void testTaskSixPositive() {
        try {
            List<Integer> actual = timeService.runTaskSix(123123);
            List<Integer> expected = new ArrayList<>();
            expected.add(34);
            expected.add(12);
            expected.add(3);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 2, dependsOnMethods = "testTaskSixPositive")
    public void testTaskSixNegative() {
        try {
            List<Integer> actual = timeService.runTaskSix(123123);
            List<Integer> expected = new ArrayList<>();
            expected.add(3);
            expected.add(3);
            expected.add(3);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 3, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter not null value")
    public void testTaskSixException() throws IncorrectDataException {
        timeService.runTaskSix(-5);
    }

    @Test(priority = 4)
    public void testTaskTwoPositive() {
        try {
            int actual = timeService.runTaskTwo(2004, 2);
            int expected = 29;
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 5, dependsOnMethods = "testTaskTwoPositive")
    public void testTaskTwoNegative() {
        try {
            int actual = timeService.runTaskTwo(2004, 2);
            int expected = 28;
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 6, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter not null value")
    public void testTaskTwoException() throws IncorrectDataException {
        timeService.runTaskTwo(2002, 0);
    }

    @Test(priority = 7)
    public void testLeapYearPositive() {
        boolean actual = timeService.checkLeapYear(2000);
        assertTrue(actual);
    }

    @Test(priority = 8, dependsOnMethods = "testLeapYearPositive")
    public void testLeapYearNegative() {
        boolean actual = timeService.checkLeapYear(2002);
        assertFalse(actual);
    }
}
