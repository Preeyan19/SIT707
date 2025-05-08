package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testTrueAdd() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
    }

    @Test
    public void testAddNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }

    @Test
    public void testTrueSubtraction() {
        Assert.assertEquals(2.0, MathQuestionService.q2Subtraction("5", "3"), 0);
    }

    @Test
    public void testSubtractionNumber1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "3"));
    }

    @Test
    public void testTrueMultiply() {
        Assert.assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), 0);
    }

    @Test
    public void testMultiplyNumber1Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", "4"));
    }

    @Test
    public void testMultiplyNumber2Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("3", ""));
    }
}
