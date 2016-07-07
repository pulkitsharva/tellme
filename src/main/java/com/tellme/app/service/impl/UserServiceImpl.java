package com.tellme.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tellme.app.dto.SignupDTO;
import com.tellme.app.dto.UsernameAvailableDTO;
import com.tellme.app.entity.UserProfile;
import com.tellme.app.exception.ErrorCode;
import com.tellme.app.exception.InvalidRequestException;
import com.tellme.app.repository.UserProfileRepository;
import com.tellme.app.service.UserService;
@Service
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserProfileRepository userProfileRepository;
  
  public UserProfile getUserByUserName(String username) {
    UserProfile userProfile=userProfileRepository.getUserProfileByUsername(username);
    return userProfile;
  }

  public UsernameAvailableDTO checkUsernameAvailabilty(String username) {
    if(null!=username && !("".equals(username))){
      UserProfile userProfile=getUserByUserName(username);
      UsernameAvailableDTO usernameAvailableDTO=new UsernameAvailableDTO();
      if(null!=userProfile){
        usernameAvailableDTO.setStatus(false);
      }
      else{
        usernameAvailableDTO.setStatus(true);
      }
      return usernameAvailableDTO;
    }
    else{
      throw new InvalidRequestException(ErrorCode.INVALID_REQUEST, "username cannot be null");
    }
  }

  public UserProfile createUserSignup(SignupDTO signupDTO) {
    // TODO Auto-generated method stub
    return null;
  }

}
