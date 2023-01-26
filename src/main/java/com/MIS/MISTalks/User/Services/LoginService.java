package com.MIS.MISTalks.User.Services;

import com.MIS.MISTalks.User.Models.User;
import com.MIS.MISTalks.User.Repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private Logger log = LoggerFactory.getLogger(LoginService.class);
    private UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String checkUserCredential(String email, String password){
        log.info("--checkUserCredential() function");
        List<User> users = userRepository.findAll();

        for(User user: users) {
            log.info(email, user.getEmail());
            log.info(password, user.getPassword());
            if(user.getEmail().equalsIgnoreCase(email)){
                if(user.getPassword().equals(password)) {
                    return "home";
                }
                else {
                    break;
                }
            }
        }

        return "signin";
    }
}
