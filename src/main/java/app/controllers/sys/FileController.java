package app.controllers.sys;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.annotations.RESTful;

import com.ac.support.FileUtil;

import app.controllers.BaseController;

@RESTful
public class FileController extends BaseController {

	/**
	 * 获取用户上传文件
	 */
	public void create(){

		String realPaths = getRealPath("/");
		realPaths = realPaths.substring(0, realPaths.length()-1);
		
    	String name = "";
    	String root = "/upload";
		Iterator<FormItem> iterator = uploadedFiles();
		if (iterator.hasNext()){
            FormItem item = iterator.next();
            String type = FileUtil.getSuffix(item.getFileName());
			String realPath = realPaths + root;
			File uploadDir = new File(realPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }
            name = "/"+System.currentTimeMillis()+"."+type;
            String fileurl = realPath+name;
            try {
    			item.saveTo(fileurl);
    		} catch (IOException e) {
    			success("文件上传成失败，关闭页面后重试");
    		}
        }
		success(root+name);
	}

}
