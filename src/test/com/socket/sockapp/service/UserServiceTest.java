package com.socket.sockapp.service;

import com.socket.sockapp.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2017/1/10.
 */
public class UserServiceTest {

    UserService userService = new UserService();
    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUserName("mark");
        user.setUserPassword("admin");
        userService.addUser(user);
    }

    @Test
    public void confirmUser() throws Exception{
        User user = new User();
        user.setUserName("mark");
        user.setUserPassword("admidn");
        boolean b = userService.confirmUser(user);
        System.out.println(b);
    }


}