//package com.MIS.MISTalks.Security.Services;
//
//import com.MIS.MISTalks.User.Models.User;
//import com.MIS.MISTalks.User.Repos.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class CustomDetailsService implements UserDetailsService {
//    private UserRepository userRepository;
//
//    @Autowired
//    public CustomDetailsService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username).orElseThrow(() ->
//                new UsernameNotFoundException("email not found!"));
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), user.getPassword(), new ArrayList<>());
//    }
//}
