package com.MIS.MISTalks.User.Controllers;

import com.MIS.MISTalks.DTO.SignupData;
import com.MIS.MISTalks.User.Models.User;
import com.MIS.MISTalks.User.Services.SignupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/MIS-TALKS")
public class SignupController {
    private final Logger log = LoggerFactory.getLogger(SignupController.class);
    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @GetMapping("/signup")
    public String signUp() {
        log.info("--signup() function");
        return "signup";
    }

    @PostMapping("/new_user_signup")
    public String addNewUser(SignupData data) {
        log.info("--addNewUser() function");
        try {
            User user = new User(
                    data.firstName(),
                    data.lastName(),
                    data.phoneNumber(),
                    data.email(),
                    data.password(),
                    new Date().toString());
            if ("home".equals(signupService.signup(user))) {
                return "redirect:/";
            } else {
                return "redirect:/MIS-TALKS/signup";
            }
        } catch (Exception e) {
            log.info("Error info " + e.getMessage());
            return "ServerErrorPage";
        }
    }
}
