package com.tellme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.tellme.config.CouchbaseConfig;
import com.tellme.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private CouchbaseConfig couchbase;
	
	public void getById(Integer id) {
		Bucket bucket=couchbase.openBucket();
		JsonDocument walter = bucket.get(id.toString());
		System.out.println("Found: " + walter);

	}

}
