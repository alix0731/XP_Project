package kino.xp.project;

import kino.xp.project.repositories.LoginMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testCheckLogin(){
        LoginMethods lm = new LoginMethods();
        String testUser = "Wrong";
        String testPass = "Wrong";

        Assertions.assertTrue(lm.checkLogin(testUser, testPass));
        Assertions.assertFalse(lm.checkLogin("Right", "Right"));
    }
}
