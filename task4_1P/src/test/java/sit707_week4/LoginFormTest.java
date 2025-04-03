package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest {

   
    @Test
    public void testStudentIdentity() {
        String studentId = "223960129";  
        Assert.assertNotNull("Student ID is null", studentId);
    }

   
    @Test
    public void testStudentName() {
        String studentName = "PREEYAN"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    // 3. Testing the case for empty username and password, don't care about validation code
    @Test
    public void test3A() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    // 4. Testing username as empty, password as wrong, validation code doesn't matter
    @Test
    public void test4A() {
        LoginStatus status = LoginForm.login("", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // 5. Testing username as wrong, password as correct, validation code doesn't matter
    @Test
    public void test5A() {
        LoginStatus status = LoginForm.login("wrong_user", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // 6. Testing username and password correct, validation code doesn't matter
    @Test
    public void test6A() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
    }

    // 7. Testing correct username and password with incorrect validation code
    @Test
    public void test7A() {
        LoginForm.login("ahsan", "ahsan_pass"); // Need to login first to get validation code
        boolean isCodeValid = LoginForm.validateCode("wrong_code");
        Assert.assertFalse(isCodeValid);
    }

    // 8. Testing correct username, correct password and correct validation code
    @Test
    public void test8A() {
        LoginForm.login("ahsan", "ahsan_pass"); // Need to login first to get validation code
        boolean isCodeValid = LoginForm.validateCode("123456");
        Assert.assertTrue(isCodeValid);
    }

   // 9. Testing empty username and wrong password, don't care about validation code
    @Test
    public void test9A() {
        LoginStatus status = LoginForm.login(null, "wrong_password");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // 10. Testing empty username and correct password, validation code doesn't matter
    @Test
    public void test10A() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // 11. Testing invalid username and empty password, validation code doesn't matter
    @Test
    public void test11A() {
        LoginStatus status = LoginForm.login("wrong_username", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    // 12. Testing invalid username and invalid password, validation code doesn't matter
    @Test
    public void test12A() {
        LoginStatus status = LoginForm.login("wrong_username", "wrong_password");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // 13. Testing correct username and empty password, validation code doesn't matter
    @Test
    public void test13A() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
    }
}