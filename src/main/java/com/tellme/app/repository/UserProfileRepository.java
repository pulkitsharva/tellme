package com.tellme.app.repository;

import org.springframework.stereotype.Repository;

import com.tellme.app.entity.UserProfile;

public interface UserProfileRepository extends BaseRepository<UserProfile, Integer>{

  public UserProfile getUserProfileByUsername(String username);
  
}
