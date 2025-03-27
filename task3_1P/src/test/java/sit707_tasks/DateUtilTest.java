package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for DateUtil to verify correct date transitions.
 */
public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "223960129";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Preeyan";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // *** January ***
    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(2023, date.getYear());
    }

    // *** February (Leap Year) ***
    @Test
    public void testMaxFebruary29ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024); // Leap year
        date.increment();
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinFebruary1ShouldDecrementToJanuary31() {
        DateUtil date = new DateUtil(1, 2, 2024);
        date.decrement();
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    // *** March ***
    @Test
    public void testMaxMarch31ShouldIncrementToApril1() {
        DateUtil date = new DateUtil(31, 3, 2024);
        date.increment();
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinMarch1ShouldDecrementToFebruary29() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.decrement();
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    // *** April ***
    @Test
    public void testMaxApril30ShouldIncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2024);
        date.increment();
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinApril1ShouldDecrementToMarch31() {
        DateUtil date = new DateUtil(1, 4, 2024);
        date.decrement();
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    // *** May ***
    @Test
    public void testMaxMay31ShouldIncrementToJune1() {
        DateUtil date = new DateUtil(31, 5, 2024);
        date.increment();
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinMay1ShouldDecrementToApril30() {
        DateUtil date = new DateUtil(1, 5, 2024);
        date.decrement();
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    // *** June ***
    @Test
    public void testMaxJune30ShouldIncrementToJuly1() {
        DateUtil date = new DateUtil(30, 6, 2024);
        date.increment();
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinJune1ShouldDecrementToMay31() {
        DateUtil date = new DateUtil(1, 6, 2024);
        date.decrement();
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    // *** July ***
    @Test
    public void testMaxJuly31ShouldIncrementToAugust1() {
        DateUtil date = new DateUtil(31, 7, 2024);
        date.increment();
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinJuly1ShouldDecrementToJune30() {
        DateUtil date = new DateUtil(1, 7, 2024);
        date.decrement();
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    // *** August ***
    @Test
    public void testMaxAugust31ShouldIncrementToSeptember1() {
        DateUtil date = new DateUtil(31, 8, 2024);
        date.increment();
        Assert.assertEquals(9, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinAugust1ShouldDecrementToJuly31() {
        DateUtil date = new DateUtil(1, 8, 2024);
        date.decrement();
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    // *** September ***
    @Test
    public void testMaxSeptember30ShouldIncrementToOctober1() {
        DateUtil date = new DateUtil(30, 9, 2024);
        date.increment();
        Assert.assertEquals(10, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinSeptember1ShouldDecrementToAugust31() {
        DateUtil date = new DateUtil(1, 9, 2024);
        date.decrement();
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    // *** October ***
    @Test
    public void testMaxOctober31ShouldIncrementToNovember1() {
        DateUtil date = new DateUtil(31, 10, 2024);
        date.increment();
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinOctober1ShouldDecrementToSeptember30() {
        DateUtil date = new DateUtil(1, 10, 2024);
        date.decrement();
        Assert.assertEquals(9, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    // *** November ***
    @Test
    public void testMaxNovember30ShouldIncrementToDecember1() {
        DateUtil date = new DateUtil(30, 11, 2024);
        date.increment();
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMinNovember1ShouldDecrementToOctober31() {
        DateUtil date = new DateUtil(1, 11, 2024);
        date.decrement();
        Assert.assertEquals(10, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    // *** December ***
    @Test
    public void testMaxDecember31ShouldIncrementToJanuary1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2024);
        date.increment();
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2025, date.getYear());
    }
}
