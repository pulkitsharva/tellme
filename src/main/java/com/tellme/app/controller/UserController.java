package com.tellme.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.tellme.app.dto.UsernameAvailableDTO;
import com.tellme.app.service.UserService;
import com.tellme.app.util.UriConstants;

@Controller
@RequestMapping(UriConstants.VERSION_1 + "users")
public class UserController {

  @Autowired
  private UserService userService;


  @RequestMapping(method = RequestMethod.GET, path = "/available")
  public ResponseEntity<UsernameAvailableDTO> userNameAvailability(
      @RequestParam(required = true, value = "username") String username) {
    UsernameAvailableDTO usernameAvailableDTO = userService.checkUsernameAvailabilty(username);
    return new ResponseEntity<UsernameAvailableDTO>(usernameAvailableDTO, HttpStatus.OK);
  }
}
