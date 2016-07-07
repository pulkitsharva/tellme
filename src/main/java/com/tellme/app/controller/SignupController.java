package com.tellme.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tellme.app.dto.SignupDTO;
import com.tellme.app.entity.UserProfile;
import com.tellme.app.service.UserService;
import com.tellme.app.service.ValidatorService;
import com.tellme.app.util.UriConstants;

@Controller
@RequestMapping(UriConstants.VERSION_1 + "signup")
public class SignupController {

  @Autowired
  private ValidatorService validatorService;
  
  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.POST,path="/intitate")
  public ResponseEntity<SignupDTO> get(@RequestBody @Valid SignupDTO signupDTO) {
    validatorService.validateSignupRequest(signupDTO);
    UserProfile userProfile=userService.createUserSignup(signupDTO);
    signupDTO.setId(userProfile.getId());
    signupDTO.getLogin().setId(userProfile.getLogin().getId());
    return new ResponseEntity<SignupDTO>(signupDTO, HttpStatus.OK);
  }

}
