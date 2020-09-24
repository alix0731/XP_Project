package kino.xp.project;

import kino.xp.project.repositories.LoginMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author Jonas, Jonathan
 * @Parameter Test af metoder relateret til login
 * @Output det er en test så ikke rigtig noget
 **/

public class LoginTest {

    @Test
    public void testCheckLogin(){
        LoginMethods lm = new LoginMethods();
        String testUser = "Admin";
        String testPass = "Admin";

        Assertions.assertTrue(lm.checkLogin(testUser, testPass));
        Assertions.assertFalse(lm.checkLogin("Right", "Right"));
    }
}
