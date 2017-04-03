/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple Authenticator service, that checks user logins
 * @author piwa
 */
public class Authenticator {
    private static final Map<String, String> USERS = new HashMap<String, String>();
    static {
        USERS.put("admin", "admin");
    }
    public static boolean validate(String user, String password){
        String validUserPassword = USERS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}