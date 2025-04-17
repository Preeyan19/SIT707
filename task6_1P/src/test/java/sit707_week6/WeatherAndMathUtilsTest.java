package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

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
    public void testEvenNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(10));
    }

    @Test
    public void testOddNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(11));
    }

    @Test
    public void testPrimeNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
    }

    @Test
    public void testNonPrimeEvenNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testOneIsPrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1)); 
    }

    @Test
    public void testCancelDueToHighRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 6.1));
    }

    @Test
    public void testCancelDueToHighWind() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 2.0));
    }

    @Test
    public void testCancelDueToCombo() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
    }

    @Test
    public void testWarnDueToHighWind() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 2.0));
    }

    @Test
    public void testWarnDueToHighRain() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 4.5));
    }

    @Test
    public void testAllClearWeatherAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
    }
}
