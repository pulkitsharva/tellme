package com.tellme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tellme.dto.StudentDTO;
import com.tellme.service.StudentService;
import com.tellme.util.UriConstants;

@RestController
@RequestMapping(UriConstants.VERSION_1+"login")
public class LoginController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> get(@PathVariable Integer id){
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
}
