package kino.xp.project.repositories;

import java.util.HashMap;

public class LoginMethods {

    String testUser = "Admin";
    String testPass = "Admin";
    HashMap<String, String> testMap = new HashMap<>();

    public LoginMethods(){
        testMap.put(testUser, testPass);
    }



    public boolean checkLogin(String username, String password){
        if (testMap.containsKey(username)) {
            if (testMap.get(username).equals(password)) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
