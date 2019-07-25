package app.config;

import java.util.Arrays;

import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.Bootstrap;
import org.javalite.activeweb.Configuration;

import com.ac.mongodb.FindIterableJsonModule;
import com.ac.mongodb.ObjectIdJsonModule;
import com.ac.support.MongoUtils;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * @author CYC
 */
public class AppBootstrap extends Bootstrap {

	public void init(AppContext context) {
		MongoCredential credential = MongoCredential.createCredential(Configuration.get("mongo_user"), Configuration.get("mongo_db"), Configuration.get("mongo_password").toCharArray());
		ServerAddress serverAddress = new ServerAddress(Configuration.get("mongo_host"), Integer.valueOf(Configuration.get("mongo_port")));

		MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
				.applyToClusterSettings(builder -> builder.hosts(Arrays.asList(serverAddress))).credential(credential).build());

		MongoUtils.registerModules(new ObjectIdJsonModule(), new FindIterableJsonModule());
		
		context.set("mongo", mongoClient);
	}

	@Override
	public void destroy(AppContext context) {
		MongoClient client = context.get("mongo", MongoClient.class);
		client.close();
	}
	
	@Override
	public Injector getInjector() {
		return Guice.createInjector(new AppServiceModule());
	}
}