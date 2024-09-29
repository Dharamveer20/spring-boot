package com.in28minutes.springboot.myfirstwebapp.welcome;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return username.equalsIgnoreCase("Uano")  && password.equals("uano");
    }
}
