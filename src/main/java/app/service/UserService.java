package app.service;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.ac.exception.RException;
import com.ac.mongodb.MongoService;
import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;

import app.service.impl.AuthServiceImpl;
import app.service.impl.UserServiceImpl;

public class UserService extends MongoService implements UserServiceImpl {

	MongoCollection<Document> user;

	@Inject
	AuthServiceImpl authService;

	public UserService() {
		user = getCollection("user");
	}

	@Override
	public String login(Document doc) {
		String username = doc.getString("user");
		String password = doc.getString("password");
		Document userdoc = user.find(and(eq("username", username), eq("password", password))).first();
		if (userdoc == null)
			throw new RException("用户名或者密码错误！");
		userdoc.remove("password");
		return authService.getToken(userdoc.get("_id").toString());
	}

	@Override
	public Document getUserInfo(String id) {
		if (!ObjectId.isValid(id))
			throw new RException("未知错误");
		return user.find(eq("_id", new ObjectId(id))).first();
	}

}
