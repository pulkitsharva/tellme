package com.tellme.app.service;

import com.tellme.app.dto.UsernameAvailableDTO;
import com.tellme.app.entity.UserProfile;

public interface UserService {

  public UserProfile getUserByUserName(String userame);
  
  public UsernameAvailableDTO checkUsernameAvailabilty(String username);
  
} 
