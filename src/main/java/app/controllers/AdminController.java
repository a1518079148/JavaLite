package app.controllers;

/**
* 管理页
*/
public class AdminController extends BaseController {
	
	public void index(){
		render().contentType("text/html;charset=utf-8");
	}
	
}