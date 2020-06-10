package test.shilovich.day1.validator;

import com.shilovich.day1.entity.Point;
import com.shilovich.day1.validator.EnteredDataValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class EnteredDataValidatorTest {

    EnteredDataValidator enteredDataValidator;

    @BeforeClass
    public void setUp() {
        enteredDataValidator = new EnteredDataValidator();
    }

    @Test(priority = 1)
    public void testIntegerValidatorPositive() {
        boolean condition = enteredDataValidator.validateInteger(3);
        assertTrue(condition);
    }

    @Test(priority = 2, dependsOnMethods = "testIntegerValidatorPositive")
    public void testIntegerValidatorNegative() {
        boolean condition = enteredDataValidator.validateInteger(3.5);
        assertFalse(condition);
    }

    @Test(priority = 3)
    public void testNotNullValidatorPositive() {
        boolean condition = enteredDataValidator.validateNotNull(3);
        assertTrue(condition);
    }

    @Test(priority = 4, dependsOnMethods = "testNotNullValidatorPositive")
    public void testNotNullValidatorNegative() {
        boolean condition = enteredDataValidator.validateNotNull(0);
        assertFalse(condition);
    }

    @Test(priority = 5)
    public void testPointRangeValidatorPositive() {
        Point point = new Point();
        point.setAxisX(11);
        point.setAxisY(5);
        boolean condition = enteredDataValidator.validatePointRange(point);
        assertTrue(condition);
    }

    @Test(priority = 6, dependsOnMethods = "testPointRangeValidatorPositive")
    public void testPointRangeValidatorNegative() {
        Point point = new Point();
        point.setAxisX(110);
        point.setAxisY(5);
        boolean condition = enteredDataValidator.validatePointRange(point);
        assertFalse(condition);
    }

    @Test(priority = 7)
    public void testValueAboveZeroValidatorPositive() {
        boolean condition = enteredDataValidator.validateValueAboveZero(3);
        assertTrue(condition);
    }

    @Test(priority = 8, dependsOnMethods = "testValueAboveZeroValidatorPositive")
    public void testValueAboveZeroValidatorNegative() {
        boolean condition = enteredDataValidator.validateValueAboveZero(-7);
        assertFalse(condition);
    }

    @Test(priority = 9)
    public void testLineSegmentValidatorPositive() {
        boolean condition = enteredDataValidator.validateLineSegment(3, 5);
        assertTrue(condition);
    }

    @Test(priority = 10, dependsOnMethods = "testLineSegmentValidatorPositive")
    public void testLineSegmentValidatorNegative() {
        boolean condition = enteredDataValidator.validateLineSegment(6, 1);
        assertFalse(condition);
    }

}
