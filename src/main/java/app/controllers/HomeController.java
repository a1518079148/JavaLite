package app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

/**
 * 
 * 
 * @author CYC
 * 
 */
public class HomeController extends BaseController {

	public void index() {

		List<Document> listdoc = new ArrayList<Document>();
		listdoc.add(new Document("content", "One"));
		listdoc.add(new Document("content", "Two"));
		listdoc.add(new Document("content", "Three"));
		listdoc.add(new Document("content", "Four"));
		view("oneList", listdoc);

		render().contentType("text/html;charset=utf-8");
	}
}