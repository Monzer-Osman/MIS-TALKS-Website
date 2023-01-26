package com.MIS.MISTalks.User.Controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserProfileControllerTest {
    private UserProfileController userProfileController;

    @Autowired
    public UserProfileControllerTest(UserProfileController userProfileController){
        this.userProfileController = userProfileController;
    }

    @Test
    public void profileTest(){

    }
}