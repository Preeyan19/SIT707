package web.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Business logic to handle login functions.
 * Now supports multiple users and full authentication using username, password, and dob.
 */
public class LoginService {

    // A sample in-memory user database (username -> [password, dob])
    private static final Map<String, String[]> users = new HashMap<>();

    static {
        // username -> [password, dob]
        users.put("ahsan", new String[]{"ahsan_pass", "1995-01-01"});
        users.put("john", new String[]{"john123", "2000-12-12"});
        users.put("alice", new String[]{"alice456", "1999-06-15"});
    }

    /**
     * Returns true if all three values match a known user.
     */
    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) {
            return false;
        }

        if (!users.containsKey(username)) {
            return false;
        }

        String[] credentials = users.get(username);
        return credentials[0].equals(password) && credentials[1].equals(dob);
    }
}
