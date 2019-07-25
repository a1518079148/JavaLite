package app.service;

import org.bson.Document;

import com.ac.mongodb.MongoService;
import com.mongodb.client.MongoCollection;

import app.service.impl.TestServiceImpl;

/**
 * 
 * 
 * @author CYC
 * 
 */
public class TestService extends MongoService implements TestServiceImpl {

	MongoCollection<Document> test;

	public TestService() {
		test = getCollection("test");
	}

	@Override
	public Document index() {
		System.out.println("进行了数据的相关操作");
		return null;
	}

	@Override
	public void create() {
		System.out.println("进行了数据的相关操作");

	}

	@Override
	public void update() {
		System.out.println("进行了数据的相关操作");

	}

	@Override
	public void delete() {
		System.out.println("进行了数据的相关操作");

	}

	@Override
	public Document show() {
		System.out.println("进行了数据的相关操作");
		return null;
	}

}
