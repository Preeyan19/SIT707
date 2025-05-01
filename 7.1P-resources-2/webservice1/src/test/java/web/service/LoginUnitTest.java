package web.service;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test cases for LoginService.login().
 * These tests validate the logic in isolation without any web interface.
 */
public class LoginUnitTest {

    @Test
    public void testValidLoginAhsan() {
        assertTrue(LoginService.login("ahsan", "ahsan_pass", "1995-01-01"));
    }

    @Test
    public void testValidLoginJohn() {
        assertTrue(LoginService.login("john", "john123", "2000-12-12"));
    }

    @Test
    public void testValidLoginAlice() {
        assertTrue(LoginService.login("alice", "alice456", "1999-06-15"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("invalidUser", "ahsan_pass", "1995-01-01"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("ahsan", "wrongpass", "1995-01-01"));
    }

    @Test
    public void testInvalidDob() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void testNullInputs() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testEmptyInputs() {
        assertFalse(LoginService.login("", "", ""));
    }
}
