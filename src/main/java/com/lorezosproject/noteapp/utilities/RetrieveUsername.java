package com.lorezosproject.noteapp.utilities;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class RetrieveUsername {

    //method for retrieving the username from the security framework
    public String retrieveUsernameFromSecurity(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null){
            String username = authentication.getName();
            return username;
        }

        return null;
    }
}
