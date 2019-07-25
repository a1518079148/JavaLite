package app.controllers;

/**
* 
* 错误页返回
* 
*/
public class ErrorController extends BaseController {

	public void index(){
		render("/system/404").noLayout().contentType("text/html;charset=utf-8");
	}
}