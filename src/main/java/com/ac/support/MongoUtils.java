package com.ac.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

/**
 * MongoDB工具类
 *
 */
@SuppressWarnings("rawtypes")
public class MongoUtils {

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	public static void registerModules(Module... modules) {
		mapper.registerModules(modules);
	}

	public static Map toMap(String json) {
		try {
			return (Map) mapper.readValue(json, Map.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String toJsonString(Object val) {
		try {
			return mapper.writeValueAsString(val);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Map转换为Document
	 * 
	 * @param map
	 * @param excludes 排除的Keys
	 * @return
	 */
	public static Document mapToDocument(Map<String, Object> map) {
		return mapToDocument(map, new String[0]);
	}

	/**
	 * Map转换为Document
	 * 
	 * @param map
	 * @param excludes 排除的Keys
	 * @return
	 */
	public static Document mapToDocument(Map<String, Object> map, String... excludes) {
		Document doc = new Document(map);

		for (String exclude : excludes) {
			doc.remove(exclude);
		}

		return doc;
	}

	/**
	 * Document集合转换为Map集合
	 * 
	 */
	public static List<Map<String, Object>> documentsToMap(FindIterable<Document> documentList) {

		MongoCursor<Document> cursor = documentList.iterator();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		while (cursor.hasNext()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.putAll(cursor.next());
			list.add(map);
		}
		return list;
	}

	/**
	 * Document转换为Map
	 * 
	 */
	public static Map<String, Object> documentToMap(Document document) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (String key : document.keySet()) {
			map.put(key, document.get(key));
		}
		return map;
	}

}
