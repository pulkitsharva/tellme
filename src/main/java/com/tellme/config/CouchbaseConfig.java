package com.tellme.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

@Component
@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
	
	@Value("${couchbase.cluster.bucketName}")
	private String bucketName;
	
	@Value("${couchbase.cluster.bucketPassword}")
	private String bucketPassword;
	
	@Value("${couchbase.cluster.ip}")
	private String ip;
	
	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList(this.ip);
	}
	@Override
	public String getBucketName() {
		return bucketName;
	}

	@Override
	public String getBucketPassword() {
		return bucketPassword;
	}

	public String getIp() {
		return ip;
	}
	
	private static Cluster cluster = null;
	private static Bucket bucket = null;
	
	private Cluster getCluster(){
		if(CouchbaseConfig.cluster==null){
			CouchbaseConfig.cluster=CouchbaseCluster.create(getBootstrapHosts());
		}
		return cluster;
	}
	
	public Bucket openBucket(){
		if(bucket==null){
			Cluster cluster=this.getCluster();
			CouchbaseConfig.bucket=cluster.openBucket(bucketName,bucketPassword);	
		}
		return bucket;
		
	}
    
    
    
}
