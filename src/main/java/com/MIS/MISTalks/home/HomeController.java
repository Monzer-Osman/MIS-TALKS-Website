package com.MIS.MISTalks.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/MIS-TALKS")
@SessionAttributes("{sessionId}")
public class HomeController {
    private Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String getHomePage(HttpSession httpSession, Model model) {
        log.info("--getHomePage() function");
        try {
            String sessionId = (String) httpSession.getAttribute("sessionId");
            if (sessionId != null) {
                model.addAttribute("login_status", sessionId);
            }
            return "home";
        } catch (Exception e) {
            log.info("Error message: " + e.getMessage());
            return "serverErrorPage";
        }
    }
}
