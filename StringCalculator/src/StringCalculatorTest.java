import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import junit.framework.Assert;

/**
 * 7shifts
 * Technical Interview
 * String Calculator TESTING
 *
 * Mohamed Bensaleh
 * January 25th, 2021
 *
 */

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testMultibleNumbers() {
        assertEquals(16, StringCalculator.add("1,2,5,8"));
    }

    @Test
    public void testSeperatedByNewlineAndCommas() {
        assertEquals(12, StringCalculator.add("1,3\n6\n2"));
    }

    @Test
    public void testOnlySeperatedByNewline() {
        assertEquals(16, StringCalculator.add("2\n3\n10\n1"));
    }


    @Test
    public void testStringWithOneNegNumber() {
        try {
            assertEquals(1, StringCalculator.add("-1,2"));
        }
        catch (Exception e) {
            assertEquals("Negatives not allowed. Negative numbers found: [-1]", e.getMessage());
        }
    }

    @Test
    public void testWithMultipleNegNumbers() {
        try {
            assertEquals(-6, StringCalculator.add("1,-5,2,-3,-1"));
        }
        catch (Exception e) {
            assertEquals("Negatives not allowed. Negative numbers found: [-5, -3, -1]", e.getMessage());
        }
    }


    @Test
    public void testIfAbove1000AreIgnored() {
        assertEquals(3, StringCalculator.add("1001,3"));
    }

    @Test
    public void testEqualTo1000() {
        assertEquals(1004, StringCalculator.add("1000,4"));
    }

    @Test
    public void testWithDifferentDelimeter1() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testWithDifferentDelimeter2() {
        assertEquals(15, StringCalculator.add("//@\n1@2@4@8"));
    }

    @Test
    public void testWithDifferentDelimeterLength() {
        assertEquals(6, StringCalculator.add("//%%%%\n1%%%%2%%%%3"));
    }
}