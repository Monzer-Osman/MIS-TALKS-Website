package com.MIS.MISTalks.User.Controllers;

import com.MIS.MISTalks.DTO.SigninData;
import com.MIS.MISTalks.User.Services.LoginService;
import com.MIS.MISTalks.home.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("{sessionId}")
@RequestMapping("/MIS-TALKS")

public class SignInController {
    private Logger log = LoggerFactory.getLogger(HomeController.class);
    private LoginService loginService;

    @Autowired
    public SignInController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login() {
        log.info("--login() function");
        return "signin";
    }

    @PostMapping("/user_login")
    public String userLogin(@ModelAttribute SigninData data, HttpSession sessionId) {
        log.info("--userLogin() function");
        try {
            String page = loginService.checkUserCredential(data.email(), data.password());
            if (page.equalsIgnoreCase("home")) {
                sessionId.setAttribute("sessionId", data.email());
                return "redirect:/";
            } else {
                return "redirect:/MIS-TALKS/login";
            }
        } catch (Exception e){
            log.info("Error info " + e.getMessage());
            return "ServerErrorPage";
        }
    }

    @GetMapping("/logout")
    public String userLogout(HttpSession httpSession) throws Exception{
        log.info("--userLogout() function");
        try {
            if (httpSession != null) {
                httpSession.invalidate();
                return "redirect:/MIS-TALKS/login";
            } else {
                throw new Exception("Failed to logout!");
            }
        } catch (Exception e){
            log.info("Error info " + e.getMessage());
            return "ServerErrorPage";
        }
    }
}
