package test.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.service.FigureService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.fail;

public class FigureServiceTest {

    FigureService figureService;
    PrintToConsole printToConsole;

    @BeforeClass
    public void setUp() {
        figureService = new FigureService();
        printToConsole = new PrintToConsole();
    }

    @Test(priority = 1)
    public void testTaskThreePositive() {
        try {
            List<Double> actual = figureService.runTaskThree(2);
            List<Double> expected = new ArrayList<>();
            expected.add(1D);
            expected.add(2D);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 2, dependsOnMethods = "testTaskThreePositive")
    public void testTaskThreeNegative() {
        try {
            List<Double> actual = figureService.runTaskThree(2);
            List<Double> expected = new ArrayList<>();
            expected.add(1D);
            expected.add(3D);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 3, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter the correct area")
    public void testTaskThreeException() throws IncorrectDataException {
        figureService.runTaskThree(-2D);
    }

    @Test(priority = 4)
    public void testTaskNinePositive() {
        try {
            List<Double> actual = figureService.runTaskNine(2);
            List<Double> expected = new ArrayList<>();
            expected.add(12.566370614359172D);
            expected.add(12.566370614359172D);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 5, dependsOnMethods = "testTaskNinePositive")
    public void testTaskNineNegative() {
        try {
            List<Double> actual = figureService.runTaskNine(4);
            List<Double> expected = new ArrayList<>();
            expected.add(12.566370614359172D);
            expected.add(3D);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
            fail();
        }
    }

    @Test(priority = 6, expectedExceptions = IncorrectDataException.class,
            expectedExceptionsMessageRegExp = "Incorrect data. Enter the correct radius")
    public void testTaskNineException() throws IncorrectDataException {
        figureService.runTaskNine(0);
    }


}
