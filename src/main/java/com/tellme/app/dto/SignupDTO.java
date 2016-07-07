package com.tellme.app.dto;

import javax.validation.constraints.NotNull;

public class SignupDTO {
  
  private Integer id;
  @NotNull
  private String firstName;
  private String lastName;
  @NotNull
  private String avatar;
  private String location;
  @NotNull
  private LoginDTO login;
  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public LoginDTO getLogin() {
    return login;
  }

  public void setLogin(LoginDTO login) {
    this.login = login;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  

}
