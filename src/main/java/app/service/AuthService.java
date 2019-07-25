package app.service;

import static com.mongodb.client.model.Filters.eq;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bson.Document;

import com.ac.mongodb.MongoService;
import com.mongodb.client.MongoCollection;

import app.service.impl.AuthServiceImpl;

public class AuthService extends MongoService implements AuthServiceImpl {

	MongoCollection<Document> auth;

	public AuthService() {
		auth = getCollection("auth");
	}

	@Override
	public String getToken(String user_id) {
		String tokenMod = tokenMod(user_id);
		Document doc = new Document("user_id", user_id).append("create_time", System.currentTimeMillis())
				.append("last_time", System.currentTimeMillis()).append("token", tokenMod);
		Document user_auth = auth.find(eq("user_id", user_id)).first();
		if (user_auth != null) {
			auth.updateOne(user_auth, new Document("$set", doc));
			return tokenMod;
		}
		auth.insertOne(doc);
		return tokenMod;
	}

	@Override
	public boolean isToken(String token) {
		Document user_auth = auth.find(eq("token", token)).first();
		if (user_auth != null) {
			int time_long = 30 * 1000000;
			Long last_time = (Long) user_auth.get("last_time");
			if (System.currentTimeMillis() - last_time > time_long) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public void upToken(String token) {
		auth.updateOne(eq("token", token), new Document("$set", new Document("last_time", System.currentTimeMillis())));
		// TODO Auto-generated method stub

	}

	@Override
	public String getUserId(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	private String tokenMod(String user_id) {
		user_id = UUID.randomUUID().toString() + user_id + System.currentTimeMillis();
		String encodeBase64;
		try {
			encodeBase64 = new String(Base64.encodeBase64(user_id.getBytes()), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		return encodeBase64;
	}

}
