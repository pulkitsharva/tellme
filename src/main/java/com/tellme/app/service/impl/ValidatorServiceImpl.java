package com.tellme.app.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tellme.app.dto.SignupDTO;
import com.tellme.app.entity.UserProfile;
import com.tellme.app.exception.ErrorCode;
import com.tellme.app.exception.InvalidRequestException;
import com.tellme.app.service.UserService;
import com.tellme.app.service.ValidatorService;
import com.tellme.app.util.Util;

@Service
public class ValidatorServiceImpl implements ValidatorService {

  @Autowired
  private UserService userService;

  public void validateSignupRequest(SignupDTO signupDTO) {
    Boolean phoneValid = Util.isPhoneValid(signupDTO.getLogin().getMobileNo());
    if (phoneValid) {
      if (signupDTO.getLogin().getPassword().equals(signupDTO.getVerifyPassword())) {
        UserProfile userProfile = userService.getUserByUserName(signupDTO.getLogin().getUsername());
        if (null != userProfile) {
          throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "username already taken");
        }
      } else {
        throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "password doesn't match");
      }
    } else {
      throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "phone number is not valid");
    }

  }


}
