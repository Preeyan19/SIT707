package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // --- Equivalence Class Tests ---

    @Test
    public void testLeapYearFebruary29() {
        DateUtil date = new DateUtil(29, 2, 2024); // Valid leap year
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test(expected = RuntimeException.class)
    public void testNonLeapYearFebruary29ShouldFail() {
        new DateUtil(29, 2, 2023); 
    }

    @Test
    public void testApril30IncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2024); // April = 30 days
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    @Test
    public void testMay31IncrementToJune1() {
        DateUtil date = new DateUtil(31, 5, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testFebruary28NonLeapToMarch1() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void testFebruary29LeapYearDecrement() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.decrement();
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }
}
