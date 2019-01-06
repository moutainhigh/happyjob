
package com.happy.util.pubConst;

/**   
 * @TODO: 返回信息公共值
 */
public class ResultMsg {
	public static final String LOGIN_FILTER_RESULT_TITLE = "loginFilter";
	public static final String LOGIN_FILTER_RESULT_FAIL = "fail";
	public static final String LOGIN_FILTER_RESULT_SUCCESS = "success";
	/**通过过滤器*/
	public static final int LOGIN_FILTER_RESULT_CODE_0 = 0;
	/**未获取到用户信息*/
	public static final int LOGIN_FILTER_RESULT_CODE_1 = 40001;
	/**未获取到微信登录信息*/
	public static final int LOGIN_FILTER_RESULT_CODE_2 = 40002;
	/**账号不存在，或token无效*/
	public static final int LOGIN_FILTER_RESULT_CODE_3 = 40003;
	/**账号已被禁用*/
	public static final int LOGIN_FILTER_RESULT_CODE_4 = 40004;
	/**用户信息和微信信息不匹配"*/
	public static final int LOGIN_FILTER_RESULT_CODE_5 = 40005;
	/**用户尚未创建简历*/
	public static final int LOGIN_FILTER_RESULT_CODE_6 = 40006;
	/**账号类型不符*/
	public static final int LOGIN_FILTER_RESULT_CODE_7 = 40007;
	/**后台接口异常*/
	public static final int PUBLIC_RESULT_CODE_5 = 50000;
	public static final String LOGIN_FILTER_RESULT_CONTENT_0 = "通过过滤器";
	public static final String LOGIN_FILTER_RESULT_CONTENT_1 = "未获取到用户信息";
	public static final String LOGIN_FILTER_RESULT_CONTENT_2 = "未获取到微信登录信息";
	public static final String LOGIN_FILTER_RESULT_CONTENT_3 = "账号不存在，或token无效";
	public static final String LOGIN_FILTER_RESULT_CONTENT_4 = "账号已被禁用";
	public static final String LOGIN_FILTER_RESULT_CONTENT_5 = "用户信息和微信信息不匹配";
	public static final String LOGIN_FILTER_RESULT_CONTENT_6 = "用户尚未创建简历";
	public static final String LOGIN_FILTER_RESULT_CONTENT_7 = "账户非管理员账户";
	public static final String PUBLIC_RESULT_CONTENT_5 = "后台接口异常";
}
