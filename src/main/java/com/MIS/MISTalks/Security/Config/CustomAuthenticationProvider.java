//package com.MIS.MISTalks.Security.Config;
//
//import com.MIS.MISTalks.User.Models.User;
//import com.MIS.MISTalks.User.Repos.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    CustomAuthenticationProvider(UserRepository userRepository,
//                                 PasswordEncoder passwordEncoder){
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String email = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        User user = userRepository.findByEmail(email).orElseThrow(() ->
//                new UsernameNotFoundException("User not found!"));
//        if(passwordEncoder.matches(password, user.getPassword())){
//            return new UsernamePasswordAuthenticationToken(
//                    email, password, new ArrayList<>());
//        }
//        else {
//            throw new BadCredentialsException("Wrong Password!");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}
