package com.MIS.MISTalks.Profile;

import com.MIS.MISTalks.User.Models.User;
import com.MIS.MISTalks.User.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("{sessionId}")
@RequestMapping("/MIS-TALKS")
public class ProfileController {
    private UserService userService;

    @Autowired
    public ProfileController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfile(HttpSession httpSession, Model model){
        try {
            String sessionId = (String) httpSession.getAttribute("sessionId");
            if (sessionId != null) {
                User user = userService.getUserByEmail(sessionId);
                model.addAttribute("login_status", sessionId);
                model.addAttribute("user_id", user.getUserId());
                model.addAttribute("email", user.getEmail());
                model.addAttribute("phone", user.getPhoneNumber());
                model.addAttribute("firstname", user.getFirstName());
                model.addAttribute("lastname", user.getLastName());
                model.addAttribute("full_name",
                        user.getFirstName() + " " + user.getLastName());
                model.addAttribute("joinDate", user.getJoinDate());
                return "profile";
            } else {
                return "redirect:/MIS-TALKS/login";
            }
        } catch (Exception e) {
            return "serverErrorPage";
        }
    }

}
