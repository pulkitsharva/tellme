package com.tellme.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tellme.dto.SignupDTO;
import com.tellme.util.UriConstants;

@Controller
@RequestMapping(UriConstants.VERSION_1+"signup")
public class SignupController {

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<SignupDTO> get(){
		SignupDTO signupDTO=new SignupDTO();
		return new ResponseEntity<SignupDTO>(signupDTO,HttpStatus.OK);
	}
}
