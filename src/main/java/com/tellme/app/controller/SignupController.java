package com.tellme.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tellme.app.dto.SignupDTO;
import com.tellme.app.service.ValidatorService;
import com.tellme.app.util.UriConstants;

@Controller
@RequestMapping(UriConstants.VERSION_1 + "signup")
public class SignupController {

  @Autowired
  private ValidatorService validatorService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<SignupDTO> get(@RequestBody SignupDTO signupDTO) {
    validatorService.validateSignupRequest(signupDTO);
    return new ResponseEntity<SignupDTO>(signupDTO, HttpStatus.OK);
  }

}
