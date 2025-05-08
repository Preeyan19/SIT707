package web.service;

public class MathQuestionService {

    public static Double q1Addition(String number1, String number2) {
        try {
            if (number1.isEmpty() || number2.isEmpty()) return null;
            return Double.parseDouble(number1) + Double.parseDouble(number2);
        } catch (Exception e) {
            return null;
        }
    }

    public static Double q2Subtraction(String number1, String number2) {
        try {
            if (number1.isEmpty() || number2.isEmpty()) return null;
            return Double.parseDouble(number1) - Double.parseDouble(number2);
        } catch (Exception e) {
            return null;
        }
    }

    public static Double q3Multiplication(String number1, String number2) {
        try {
            if (number1.isEmpty() || number2.isEmpty()) return null;
            return Double.parseDouble(number1) * Double.parseDouble(number2);
        } catch (Exception e) {
            return null;
        }
    }
}
