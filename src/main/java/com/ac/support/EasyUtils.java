package com.ac.support;

import org.javalite.http.Http;

/**
 * 功能工具类
 *
 */
public class EasyUtils {

	/**
	 * 获取t.cn短域名
	 * @param url
	 * @return
	 */
	public static String getTCN(String url) {
		if(url.indexOf("https://")<1||url.indexOf("http://")<-1)
			url = "http://" + url;
		try {
			String api_url = "https://api.weibo.com/2/short_url/shorten.json?source=211160679&url_long="+url;
			String text = Http.get(api_url).text();
			text = text.split("\"url_short\":\"")[1];
			text = text.split("\"")[0];
			return text;
		}catch (Exception e) {
			return null;
		}
	}
	
}
