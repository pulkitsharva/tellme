package com.tellme.app.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tellme.app.dto.SignupDTO;
import com.tellme.app.dto.UsernameAvailableDTO;
import com.tellme.app.entity.Login;
import com.tellme.app.entity.UserProfile;
import com.tellme.app.exception.ErrorCode;
import com.tellme.app.exception.InvalidRequestException;
import com.tellme.app.exception.handler.TellmeAppExceptionHandler;
import com.tellme.app.repository.UserProfileRepository;
import com.tellme.app.service.UserService;
import com.tellme.app.util.Util;
@Service
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserProfileRepository userProfileRepository;
  
  private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
  
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
    UserProfile userProfile=null;
    try{
      userProfile= new UserProfile();
      userProfile.setAvatar(signupDTO.getAvatar());
      userProfile.setCreatedAt(new Date());
      userProfile.setFirstName(signupDTO.getFirstName());
      userProfile.setLastName(signupDTO.getLastName());
      userProfile.setLocation(signupDTO.getLocation());
      userProfile.setUsername(signupDTO.getLogin().getUsername());
      userProfile.setSignupComplete((short) 1);
      userProfile.setStatus((short) 0);
      Login login=new Login();
      login.setMobile(signupDTO.getLogin().getMobileNo());
      login.setPassword(Util.generateHash(signupDTO.getLogin().getPassword()));
      login.setUsername(signupDTO.getLogin().getUsername());
      login.setStatus((short) 0);
      login.setUserProfile(userProfile);
      userProfile.setLogin(login);
      
      userProfile=userProfileRepository.save(userProfile);
    }
    catch(Exception e){
      LOG.error("Error occured while signup:"+e.getMessage());
      e.printStackTrace();
    }
    
    return userProfile;
  }

}
