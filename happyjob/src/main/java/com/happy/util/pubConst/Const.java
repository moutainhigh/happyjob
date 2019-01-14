package com.happy.util.pubConst;

/**
 * @TODO: 项目常量
*/
public class Const {
	// COOKIE
	/**COOKIE保存时间一天*/
	public static final int COOKIE_MAX_AGE_USER = 60*60*24;
	/**COOKIE验证信息保存时间*/
	public static final int COOKIE_SIGN_MAX_AGE = 60*5;
	/**7000*/
	public static final String COOKIE_ATTR_NAME_SID = "sid";
	
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
	/**yyyy-MM*/
	public static final String DATE_FORMAT_STR_6 = "yyyy-MM";
	/**时间格式字符串*/
	public static final String TIME_MATCH_REGEX = "^(0+\\d|1\\d|2[0-3])\\:([0-5]+\\d)\\:([0-5]+\\d)$";
	
	// 编码类型
	/**UTF-8*/
    public static final String CODE_TYPE_STR = "utf-8";
    
    // session 中参数名称
    /**手机号码*/
    public static final String SESSION_ATTR_NAME_PHONE = "phoneno";
    /**短信验证码*/
    public static final String SESSION_ATTR_NAME_MSGCODE = "msgcode";
    /**短信验证码有效时间*/
    public static final String SESSION_ATTR_NAME_AGE = "sessionTime";
    /**短信验证码有效时间10分钟*/
    public static final int SESSION_AGE = 600;
    /**短信验证码位数*/
    public static final int PHONE_MSGCODE_NUM = 4;
    
    
    // 各功能图片上传物理地址
    /** 用户图片存储位置*/
    public static final String HP_UP_IMG_USER_PATH = "/imgs/user";
    /** 公司图片存储位置*/
    public static final String HP_UP_IMG_COM_PATH = "/imgs/company";
    /** 岗位图片存储位置*/
    public static final String HP_UP_IMG_POS_PATH = "/imgs/position";
    /** BANNER岗位图片存储位置*/
    public static final String HP_UP_IMG_BANNER_PATH = "/imgs/banner";
    
    // 文件类型正则表达式
    /**图片文件上传保存文件夹*/
    public static final String HP_UP_IMG_FORMAT = ".*\\.(jpg|png|jpeg|gif)";
    // 请求头返回信息contentType图片正则
    public static final String HP_RESPONSE_CONTENT_TYPE_FORMAT = ".*image.*";
    // 小程序二维码宽度
    public static final int HP_QRCODE_IMAGE_WIDTH = 430;

    /**岗位拼团有效时间3天*/
    public static final long HP_POSITION_GROUP_MAX_AGE = 3*24*60*60;
    
    
    // 项目拦截器常量
    /**前端访问路径正则*/
    public static final String INTERCEPTOR_PATH_FRONT_REGEX = ".*front.*";
    /**前端用户路径正则*/
    public static final String INTERCEPTOR_PATH_FRONT_USER_REGEX = ".*user.*";
    /**后端路径正则*/
    public static final String INTERCEPTOR_PATH_BACK_REGEX = ".*back.*";
    
    // 推荐人奖励金额
    public static final double MONEY_RECOMMEND_NUM = 5d;
    
}

