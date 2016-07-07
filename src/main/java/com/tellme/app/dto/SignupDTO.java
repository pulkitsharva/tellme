package com.tellme.app.dto;

public class SignupDTO {
    
	private String avatar;
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
	
	
}
