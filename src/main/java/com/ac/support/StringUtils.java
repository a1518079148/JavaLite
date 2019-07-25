package com.ac.support;

/**
 * 字符串工具类
 *
 */
public class StringUtils {
	
	/**
	 * 获取指定长度的随机数字
	 */
	public static int getRandom(int lenght) {
		int lenghtd = (int) Math.pow(10.0, Double.parseDouble(lenght+""));
		return lenghtd+(int)(Math.random()*(lenghtd/10-lenghtd));
	}

	/**
	 * 判断字符串是否不为空、空串、空格等不显示符
	 */
    public static boolean isNotEmpty(final String cs) {
        return !isEmpty(cs);
    }
    
	/**
	 * 判断字符串是否为空、空串、空格等不显示符
	 */
	public static boolean isEmpty(final String cs) {
        return cs == null || cs.length() == 0 ||cs.trim().isEmpty()||cs.equals("null")||cs.equals("undefined");
	}
	
}
