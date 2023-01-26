package com.MIS.MISTalks.User.Services;

import com.MIS.MISTalks.Exceptions.InvalidEmail;
import com.MIS.MISTalks.User.Models.User;
import com.MIS.MISTalks.User.Repos.UserRepository;
import com.MIS.MISTalks.utils.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    private Logger log = LoggerFactory.getLogger(SignupService.class);
    private UserRepository userRepository;
    private Validator validator;

    @Autowired
    SignupService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
        this.validator = new Validator();
    }

    public String signup(User user) {
        return signupProcess(user);
    }

    private String signupProcess(User user){
        log.info("--signupProcess() function");
        try{
            validator.isEmailValid(user.getEmail());
            validator.isPasswordValid(user.getPassword());
            isEmailUsed(user.getEmail());
            userRepository.save(user);
        } catch (Exception e) {
            log.info("error message : " + e.getMessage());
            return "signup";
        }
        return "home";
    }

    private void isEmailUsed(String email) throws Exception{
        log.info("--isEmailUsed() function");
        if(userRepository.findByEmail(email).isPresent()){
            throw new InvalidEmail("Email is Already Used");
        }
    }
}
