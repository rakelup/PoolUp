package com.example.mymodule.Server;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;



/**
 * Created by demouser on 8/1/14.
 */

@Entity
public class ServerUser {
//    public ServerUser(User user){
//        this.name = user.getName();
//        this.phoneNumber = user.getPhoneNumber();
//        this.password = user.getPassword();
//    }

    @Id private String name;

    private String phoneNumber;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
