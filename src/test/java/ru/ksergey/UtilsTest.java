package ru.ksergey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    private Utils utils;

    @BeforeEach
    public void setUp() {
        utils = new Utils();
    }

    @Test
    public void addTestPositiveNumbers() {
        int expected = 5;
        int actual = utils.add(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void addTestNotEqualResult() {
        int unexpected = 6;
        int actual = utils.add(2, 3);
        assertNotEquals(unexpected, actual);
    }

    @Test
    public void subtractTestPositiveNumbers() {
        int expected = 1;
        int actual = utils.subtract(4, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyTestPositiveNumbers() {
        int expected = 6;
        int actual = utils.multiply(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void divideTestPositiveNumbers() {
        double expected = 2.0;
        double actual = utils.divide(6, 3);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void divideTestByZero() {
        assertThrows(IllegalArgumentException.class, () -> utils.divide(5, 0));
    }

    @Test
    public void isPositiveTestTrueForPositive() {
        boolean expected = true;
        boolean actual = utils.isPositive(5);
        assertEquals(expected, actual);
    }

    @Test
    public void isPositiveTestFalseForNegative() {
        boolean expected = false;
        boolean actual = utils.isPositive(-5);
        assertEquals(expected, actual);
    }

    @Test
    public void clearLastResultTestSetToZero() {
        utils.add(5, 5);
        utils.clearLastResult();
        int expected = 0;
        int actual = utils.getLastResult();
        assertEquals(expected, actual);
    }

    @Test
    public void getLastResultTestAfterOperation() {
        utils.add(5, 5);
        int expected = 10;
        int actual = utils.getLastResult();
        assertEquals(expected, actual);
    }

    @Test
    public void sortArrayTestNullInput() {
        Integer[] array = null;
        assertNull(array);
    }

    @Test
    public void sortArrayTestNonNullResult() {
        int[] input = new int[] { 1, 2, 3 };
        int[] actual = utils.sortArray(input);
        assertNotNull(actual);
    }

    @Test
    public void utilsTestSameInstance() {
        Utils expected = utils;
        Utils actual = utils;
        assertSame(expected, actual);
    }

    @Test
    public void utilsTestNotSameInstance() {
        Utils unexpected = utils;
        Utils actual = new Utils();
        assertNotSame(unexpected, actual);
    }

    @Test
    public void addTestFailExample() {
        int expected = 4;
        int actual = utils.add(2, 2);
        if (actual != expected) {
            fail("2 + 2 должно равняться 4");
        }
    }

    @Test
    @Timeout(2)
    public void longOperationTestTimeout() {
        assertTimeout(Duration.ofMillis(1500), () -> utils.longOperation());
    }

    @Test
    void sortArrayTestNull() {
        int[] expected = new int[0];
        int[] actual = utils.sortArray(null);
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestEmpty() {
        int[] expected = new int[0];
        int[] actual = utils.sortArray(new int[] {});
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestSingleElement() {
        int[] expected = new int[] { 1 };
        int[] actual = utils.sortArray(new int[] { 1 });
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestAlreadySorted() {
        int[] expected = new int[] { 1, 2, 3, 4, 5 };
        int[] actual = utils.sortArray(new int[] { 1, 2, 3, 4, 5 });
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestReverseSorted() {
        int[] expected = new int[] { 1, 2, 3, 4, 5 };
        int[] actual = utils.sortArray(new int[] { 5, 4, 3, 2, 1 });
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestDuplicates() {
        int[] expected = new int[] { 1, 2, 2, 3, 3, 4, 5 };
        int[] actual = utils.sortArray(new int[] { 3, 2, 5, 1, 2, 4, 3 });
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestNegatives() {
        int[] expected = new int[] { -5, -3, -1, 0, 2, 4 };
        int[] actual = utils.sortArray(new int[] { -1, 0, 4, -5, 2, -3 });
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestLarge() {
        int[] input = new int[1000];
        int[] expected = new int[1000];
        for (int i = 0; i < 1000; i++) {
            input[i] = 1000 - i;
            expected[i] = i + 1;
        }
        int[] actual = utils.sortArray(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestAllSame() {
        int[] expected = new int[] { 2, 2, 2, 2, 2 };
        int[] actual = utils.sortArray(new int[] { 2, 2, 2, 2, 2 });
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestTwoElements() {
        int[] expected = new int[] { 1, 2 };
        int[] actual = utils.sortArray(new int[] { 2, 1 });
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArrayTestMinMaxInt() {
        int[] expected = new int[] { Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE };
        int[] actual = utils.sortArray(new int[] { 0, Integer.MAX_VALUE, -1, 1, Integer.MIN_VALUE });
        assertArrayEquals(expected, actual);
    }
}
