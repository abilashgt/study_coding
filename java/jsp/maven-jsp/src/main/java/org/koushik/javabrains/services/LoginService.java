package org.koushik.javabrains.services;


import org.koushik.javabrains.dto.User;

import java.util.HashMap;

public class LoginService {
    public boolean authenicate(String userId, String password){
        if(password == null || password.trim() == ""){
            return false;
        }

        return true;
    }

    public User getUser(String userId){
        User user = new User();
        user.setUserId(1);
        user.setUserName("abilashgt");
        return user;
    }

}
