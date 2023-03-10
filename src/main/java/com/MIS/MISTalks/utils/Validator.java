package com.MIS.MISTalks.utils;

import com.MIS.MISTalks.Exceptions.InvalidEmail;
import com.MIS.MISTalks.Exceptions.InvalidPassword;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class Validator {
    public void isEmailValid(String email) throws Exception{
        Pattern pattern = Pattern.compile(
                "[a-zA-Z\\_]+[a-zA-Z\\_0-9]*\\@[a-zA-Z]{3,}\\.[a-zA-Z]{2,3}");
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.matches();
        if(!matchFound) {
            throw new InvalidEmail("Invalid Email");
        }
    }

    public void isPasswordValid(String password) throws Exception {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9$@#&!.+=_^%()~\\-]{6,}");
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.matches();
        if (!matchFound) {
            throw new InvalidPassword("Invalid Password");
        }
    }
}
