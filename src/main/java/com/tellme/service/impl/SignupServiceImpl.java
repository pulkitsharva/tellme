package com.tellme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.tellme.config.CouchbaseConfig;
import com.tellme.dto.SignupDTO;
import com.tellme.service.SignupService;
@Service
public class SignupServiceImpl implements SignupService {

	public void initiateSignup(SignupDTO signupDto) {
		// TODO Auto-generated method stub
		
	}
	
	

}
