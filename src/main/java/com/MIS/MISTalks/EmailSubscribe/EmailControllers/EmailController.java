package com.MIS.MISTalks.EmailSubscribe.EmailControllers;

import com.MIS.MISTalks.EmailSubscribe.Model.Email;
import com.MIS.MISTalks.EmailSubscribe.Services.EmailSubscribeService;
import com.MIS.MISTalks.DTO.EmailData;
import com.MIS.MISTalks.Explore.Controllers.ExploreController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MIS-TALKS/email")
public class EmailController {
    private final Logger log = LoggerFactory.getLogger(EmailController.class);
    private EmailSubscribeService emailSubscribeService;

    @Autowired
    public EmailController(EmailSubscribeService emailSubscribeService,
                           ExploreController exploreController){
        this.emailSubscribeService = emailSubscribeService;
    }

    @PostMapping("/subscribe")
    public String subscribe(EmailData modelEmail){
        log.info("--subscribe() function");
        log.info("model email : " + modelEmail.email());
        try {
            Email mail = new Email(modelEmail.email());
            emailSubscribeService.NewEmailSubscribe(mail);
            return "redirect:/MIS-TALKS/explore";
        } catch (Exception e){
            log.info("Error encountered..!");
            log.info("Error Message:"+ " " + e.getMessage());
            return "ServerErrorPage";
        }
    }
}
