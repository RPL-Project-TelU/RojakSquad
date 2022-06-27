package com.example.MvcReference.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DetectCharacters {
    public boolean isSpecialCharacters(String s) {
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Incorrect format of string");
            return true;
        }
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(s);
       // boolean b = m.matches();
        boolean b = m.find();
        if (b){
            System.out.println("There is a special character in my string ");
            return true;
        }
        else{
            System.out.println("There is no special char.");
            return false;
        }
    }
}
