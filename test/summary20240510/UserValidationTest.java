package summary20240510;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {
    private static UserValidation userValidation;

    @BeforeAll
    public static void init() {
        userValidation = new UserValidation();
//        userValidation.setUserData("test user data");
    }

    @BeforeEach
    public void dataInit() {
        userValidation.setUserData("test user data");
    }

    @Test
    public void checkLogin() {
        assertTrue(UserValidation.checkLoginAndPassword("login", "123", "123"));
        assertFalse(UserValidation.checkLoginAndPassword("login1", "123", "123"));
        assertFalse(UserValidation.checkLoginAndPassword("sdfkdkbfakfbkakfbkak", "123", "123"));
        assertTrue(UserValidation.checkLoginAndPassword("sdfkdkbfakfbkakfbka", "123", "123"));
        assertTrue(UserValidation.checkLoginAndPassword("sS", "123", "123"));
        assertFalse(UserValidation.checkLoginAndPassword("sS@", "123", "123"));
        assertFalse(UserValidation.checkLoginAndPassword("", "123", "123"));
        assertThrows(NullPointerException.class, () -> UserValidation.checkLoginAndPassword(null, "123", "123"));
        assertThrows(NullPointerException.class, () -> UserValidation.checkLoginAndPassword(null, null, null));
    }

    @Test
    public void checkPassword() {
        assertTrue(UserValidation.checkLoginAndPassword("login", "1111111111111111111", "1111111111111111111"));
        assertFalse(UserValidation.checkLoginAndPassword("login", "11111111111111111111", "11111111111111111111"));
        assertFalse(UserValidation.checkLoginAndPassword("login", "q", "q"));
        assertFalse(UserValidation.checkLoginAndPassword("login", "1q", "1q"));
        assertFalse(UserValidation.checkLoginAndPassword("login", "1+", "1+"));
        assertFalse(UserValidation.checkLoginAndPassword("login", "", ""));
        assertThrows(NullPointerException.class, () -> UserValidation.checkLoginAndPassword("login", null, "123"));
    }

    @Test
    public void checkConfirmPassword() {
        assertTrue(UserValidation.checkLoginAndPassword("login", "123", "123"));
        assertFalse(UserValidation.checkLoginAndPassword("login", "123", "12"));
        assertFalse(UserValidation.checkLoginAndPassword("login", "123", ""));
        assertFalse(UserValidation.checkLoginAndPassword("login", "123", null));
    }

    @Test
//    @Disabled
    public void testGetUserInfo(){
        String result = userValidation.getUserInfo();
        String expected = "<user>test user data</user>";
        assertEquals(expected, result);

        userValidation.setUserData(null);
        result = userValidation.getUserInfo();
        expected = "<user>null</user>";
        assertEquals(expected, result);

        userValidation.setUserData("");
        result = userValidation.getUserInfo();
        expected = "<user></user>";
        assertEquals(expected, result);
    }
}