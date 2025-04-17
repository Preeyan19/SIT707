package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class ExtraMathUtilsTest {
    @Test
    public void testSumUpTo10() {
        Assert.assertEquals(55, ExtraMathUtils.sumUpTo(10));
    }

    @Test
    public void testSumUpTo1() {
        Assert.assertEquals(1, ExtraMathUtils.sumUpTo(1));
    }

    @Test
    public void testSumUpTo0() {
        Assert.assertEquals(0, ExtraMathUtils.sumUpTo(0));
    }

    @Test
    public void testCountEvenInMixedArray() {
        int[] input = {1, 2, 3, 4, 5, 6};
        Assert.assertEquals(3, ExtraMathUtils.countEvenNumbers(input));
    }

    @Test
    public void testCountEvenInAllEvenArray() {
        int[] input = {2, 4, 6, 8};
        Assert.assertEquals(4, ExtraMathUtils.countEvenNumbers(input));
    }

    @Test
    public void testCountEvenInAllOddArray() {
        int[] input = {1, 3, 5, 7};
        Assert.assertEquals(0, ExtraMathUtils.countEvenNumbers(input));
    }
}
