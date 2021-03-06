package test.shilovich.day1.service;

import com.shilovich.day1.entity.CustomTime;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.service.TimeService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TimeServiceTest {

    TimeService timeService;

    @BeforeClass
    public void setUp() {
        timeService = new TimeService();
    }

    @Test(priority = 1)
    public void testTaskSixPositive() {
        try {
            CustomTime actual = timeService.runTaskSix(123123);
            CustomTime expected = new CustomTime(3, 12, 34);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail();
        }
    }

    @Test(priority = 2, dependsOnMethods = "testTaskSixPositive")
    public void testTaskSixNegative() {
        try {
            CustomTime actual = timeService.runTaskSix(123123);
            CustomTime expected = new CustomTime(3, 1, 3);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
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
