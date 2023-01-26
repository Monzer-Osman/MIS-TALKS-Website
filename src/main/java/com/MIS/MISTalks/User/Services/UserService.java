package com.MIS.MISTalks.User.Services;

import com.MIS.MISTalks.User.Models.User;
import com.MIS.MISTalks.User.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).get();
    }

    public void updateUserInfo(User user) {
        User currentUser = userRepository.findByEmail(user.getEmail()).get();
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setPassword(user.getPassword());
        currentUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(currentUser);
    }
}
