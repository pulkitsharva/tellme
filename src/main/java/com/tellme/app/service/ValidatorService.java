package com.tellme.app.service;

import com.tellme.app.dto.SignupDTO;

public interface ValidatorService {

  public void validateSignupRequest(SignupDTO signupDTO);
}
