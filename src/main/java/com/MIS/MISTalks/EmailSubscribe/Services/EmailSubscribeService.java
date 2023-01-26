package com.MIS.MISTalks.EmailSubscribe.Services;

import com.MIS.MISTalks.EmailSubscribe.Model.Email;
import com.MIS.MISTalks.EmailSubscribe.Repos.SubscribedEmailsRepo;
import com.MIS.MISTalks.utils.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSubscribeService {
    private final Logger log = LoggerFactory.getLogger(EmailSubscribeService.class);
    private SubscribedEmailsRepo subscribedEmailsRepo;
    private Validator validator;
    @Autowired
    public EmailSubscribeService(SubscribedEmailsRepo subscribedEmailsRepo, Validator validator){
        this.subscribedEmailsRepo = subscribedEmailsRepo;
        this.validator = validator;
    }

    public void NewEmailSubscribe(Email email) throws Exception{
        log.info("--NewEmailSubscribe() function");
        validator.isEmailValid(email.getEmail());
        log.info("hahaha");
        subscribedEmailsRepo.save(email);
    }
}
