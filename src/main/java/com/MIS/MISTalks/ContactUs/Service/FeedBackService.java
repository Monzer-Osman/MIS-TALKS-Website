package com.MIS.MISTalks.ContactUs.Service;

import com.MIS.MISTalks.ContactUs.Model.Feedback;
import com.MIS.MISTalks.ContactUs.Repository.FeedBackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackService {
    private final Logger log = LoggerFactory.getLogger(FeedBackService.class);
    private FeedBackRepository feedBackRepository;

    @Autowired
    public FeedBackService(FeedBackRepository feedBackRepository){
        this.feedBackRepository = feedBackRepository;
    }

    public void newFeedBack(Feedback feedback) throws Exception{
        log.info("--newFeedBack() function");
        feedBackRepository.save(feedback);
    }
}
