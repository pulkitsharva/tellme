package com.tellme.app.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

  public static boolean isPhoneValid(String phoneNumber) {
    Pattern pattern = Pattern.compile("^\\+\\d{10,13}$");
    Matcher matcher = pattern.matcher(phoneNumber);
    return matcher.find();
  }

  public static String generateHash(String input) throws Exception {
    StringBuilder hash = new StringBuilder();
    MessageDigest sha = MessageDigest.getInstance("SHA-1");
    byte[] hashedBytes = sha.digest(input.getBytes());
    char[] digits =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    for (int idx = 0; idx < hashedBytes.length; ++idx) {
      byte b = hashedBytes[idx];
      hash.append(digits[(b & 0xf0) >> 4]);
      hash.append(digits[b & 0x0f]);
    }
    return hash.toString();
  }
}
