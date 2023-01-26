package com.MIS.MISTalks.ContactUs.Controller;

import com.MIS.MISTalks.ContactUs.Model.Feedback;
import com.MIS.MISTalks.ContactUs.Service.FeedBackService;
import com.MIS.MISTalks.DTO.FeedBackData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("{sessionId}")
@RequestMapping("/MIS-TALKS")
public class ContactUsController {
    private final Logger log = LoggerFactory.getLogger(ContactUsController.class);
    private FeedBackService feedBackService;

    @Autowired
    public ContactUsController(FeedBackService feedBackService){
        this.feedBackService = feedBackService;
    }

    @GetMapping("/contact-us")
    public String contactUsPage(HttpSession httpSession, Model model){
        log.info("--contactUsPage() function");
        try {
            model.addAttribute("login_status", httpSession.getAttribute("sessionId"));
            return "contact-us";
        } catch (Exception e){
            log.info("error encountered..!");
            log.info("Error Message " + e.getMessage());
            return "ServerErrorPage";
        }
    }

    @PostMapping("/send-feedback")
    public String sendFeedBack(HttpSession httpSession, FeedBackData feedBackData){
        log.info("--sendFeedBack() function");
        log.info("feedBack subject " + feedBackData.subject());
        try {
            Feedback feedback = new Feedback(
                    feedBackData.name(),
                    feedBackData.email(),
                    feedBackData.subject(),
                    feedBackData.message()
            );
            feedBackService.newFeedBack(feedback);
            return "contact-us";
        } catch (Exception e){
            log.info("error encountered");
            log.info("Error Message : " + e.getMessage());
            return "ServerErrorPage";
        }
    }
}
