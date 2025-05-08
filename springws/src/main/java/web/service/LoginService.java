package web.service;

public class LoginService {

    public static boolean login(String username, String password, String dob) {
        return "pree".equals(username) &&
               "pree19".equals(password) &&
               "2002-07-19".equals(dob);
    }
}
