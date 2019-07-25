package com.ac.mongodb;

import org.bson.Document;
import org.javalite.activeweb.Configuration;
import org.javalite.activeweb.RequestUtils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 提供通用的MongoDB服务方法
 */
public abstract class MongoService {
	private MongoClient client;
	private MongoDatabase database;
	private String dbname = Configuration.get("mongo_db");
	
	public MongoService() {
		this.client = RequestUtils.appContext().get("mongo", MongoClient.class);
		this.database = client.getDatabase(dbname);
	}
	
	/**
	 * 获取集合
	 */
	public MongoCollection<Document> getCollection(String name) {
		return this.database.getCollection(name);
	}
	
}
