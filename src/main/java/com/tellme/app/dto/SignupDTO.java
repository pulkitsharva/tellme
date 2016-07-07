package com.tellme.app.dto;

public class SignupDTO {

  private String firstName;
  private String lastName;
  private String avatar;
  private String location;
  private LoginDTO login;
  private String verifyPassword;

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

  public String getVerifyPassword() {
    return verifyPassword;
  }

  public void setVerifyPassword(String verifyPassword) {
    this.verifyPassword = verifyPassword;
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
  

}
