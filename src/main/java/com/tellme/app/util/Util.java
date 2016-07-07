package com.tellme.app.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
  
  public static boolean isPhoneValid(String phoneNumber){
    Pattern pattern=Pattern.compile("^\\+\\d{10,13}$");
    Matcher matcher=pattern.matcher(phoneNumber);
    return matcher.find();
  }
}
