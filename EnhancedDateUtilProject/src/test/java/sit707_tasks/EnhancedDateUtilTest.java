package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class EnhancedDateUtilTest {
    @Test
    public void testAddOneDayFromEndOfMonth() {
        EnhancedDateUtil date = new EnhancedDateUtil(31, 1, 2024);
        date.addDays(1);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testSubtractOneDayFromStartOfYear() {
        EnhancedDateUtil date = new EnhancedDateUtil(1, 1, 2024);
        date.subtractDays(1);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testLeapYear() {
        EnhancedDateUtil date = new EnhancedDateUtil(1, 1, 2024);
        Assert.assertTrue(date.isLeapYear());
    }

    @Test
    public void testNonLeapYear() {
        EnhancedDateUtil date = new EnhancedDateUtil(1, 1, 2023);
        Assert.assertFalse(date.isLeapYear());
    }

    @Test
    public void testWeekendDetection() {
        EnhancedDateUtil date = new EnhancedDateUtil(4, 5, 2024); // Approx: Saturday
        Assert.assertTrue(date.isWeekend());
    }
}
