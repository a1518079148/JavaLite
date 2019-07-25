package com.ac.support;

import java.util.List;

/**
 * List工具类
 *
 */
public class ListUtils {

	/**
	 * 将String集合正向排序即a-z
	 * 
	 * @param list     - String集合
	 * @param sortType - true
	 * @return
	 */
	public static List<String> sort(List<String> list) {
		list.sort((String a, String b) -> {
			if (a == null || b == null)
				return 0;
			return a.compareTo(b);
		});
		return list;
	}

	/**
	 * 将String集合反向排序即z-a
	 * 
	 * @param list     - String集合
	 * @param sortType - false
	 * @return
	 */
	public static List<String> sort(List<String> list, boolean sortType) {
		if (sortType) {
			return sort(list);
		}
		list.sort((String a, String b) -> {
			if (a == null || b == null)
				return 0;
			return a.compareTo(b);
		});
		return list;
	}
}
