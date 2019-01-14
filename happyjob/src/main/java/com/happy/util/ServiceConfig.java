 package com.happy.util;

 /**
 *   @TODO: 公共配置类
 *
 */
public class ServiceConfig {
    
    private static boolean swaggerEnabled;
    
    private static String uploadBasePath = "D:/apache-tomcat-7.0.40/webapps/uploadFiles";
    
    private static String uploadBaseUrl = "http://192.168.0.98/uploadFiles";
    
    private static String ueditorRootPath = "D:/github/repository/happyjob/happyjob/src/main/resources/public/static";
    
    private static String ueditorSavePathPrefix;
    
    private static String ueditorUrlPrefix;

    public static boolean isSwaggerEnabled() {
        return swaggerEnabled;
    }

    public static void setSwaggerEnabled(boolean swaggerEnabled) {
        ServiceConfig.swaggerEnabled = swaggerEnabled;
    }

    public static String getUploadBasePath() {
        return uploadBasePath;
    }

    public static void setUploadBasePath(String uploadBasePath) {
        ServiceConfig.uploadBasePath = uploadBasePath;
    }

    public static String getUploadBaseUrl() {
        return uploadBaseUrl;
    }

    public static void setUploadBaseUrl(String uploadBaseUrl) {
        ServiceConfig.uploadBaseUrl = uploadBaseUrl;
    }

    public static String getUeditorRootPath() {
        return ueditorRootPath;
    }

    public static void setUeditorRootPath(String ueditorRootPath) {
        ServiceConfig.ueditorRootPath = ueditorRootPath;
    }

    public static String getUeditorSavePathPrefix() {
        return ueditorSavePathPrefix;
    }

    public static void setUeditorSavePathPrefix(String ueditorSavePathPrefix) {
        ServiceConfig.ueditorSavePathPrefix = ueditorSavePathPrefix;
    }

    public static String getUeditorUrlPrefix() {
        return ueditorUrlPrefix;
    }

    public static void setUeditorUrlPrefix(String ueditorUrlPrefix) {
        ServiceConfig.ueditorUrlPrefix = ueditorUrlPrefix;
    }
    
}
