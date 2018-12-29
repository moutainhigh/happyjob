package com.happy.util;

/**
 * @TODO: 项目常量
*/
public class Const {
	// COOKIE保存时间
	/**60*60*24*7*/
	public static final int COOKIE_MAX_AGE = 60*60*24*7;
	// COOKIE验证信息保存时间
	/**60*5*/
	public static final int COOKIE_SIGN_MAX_AGE = 60*5;
	/**7000*/
	public static final long WEIXIN_ACCESS_TOKEN_MAX_AGE = 7000;
	
	/**返回信息码参数名*/
	public static final String RESUTL_MESSAGE_ERRORCODE = "errorCode";
	/**返回信息内容参数名*/
	public static final String RESUTL_MESSAGE_MESSAGE = "message";
	/**返回信息图片上传后访问地址*/
	public static final String RESUTL_MESSAGE_UP_IMG_URL = "realPath";
	/**返回信息描述*/
	public static final String RESUTL_MESSAGE_ERROR_DESC = "errorDesc";
	
	
	
	// 时间格式字符串
	/**yyyy-MM-dd HH:mm:ss*/
	public static final String DATE_FORMAT_STR_1 = "yyyy-MM-dd HH:mm:ss";
	/**yyyy-MM-dd*/
	public static final String DATE_FORMAT_STR_2 = "yyyy-MM-dd";
	/**yyyyMMddHHmmss*/
	public static final String DATE_FORMAT_STR_3 = "yyyyMMddHHmmss";
	/**yyyyMMddHHmmsss*/
	public static final String DATE_FORMAT_STR_4 = "yyyyMMddHHmmsss";
	/**HH:mm:ss*/
	public static final String DATE_FORMAT_STR_5 = "HH:mm:ss";
	/**时间格式字符串*/
	public static final String TIME_MATCH_REGEX = "^(0+\\d|1\\d|2[0-3])\\:([0-5]+\\d)\\:([0-5]+\\d)$";
	
	
}

