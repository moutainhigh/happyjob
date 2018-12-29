 package com.happy.util;

 /**
 *   TODO: 公共配置类
 *
 */
public class ServiceConfig {
    
    private static boolean swaggerEnabled;
    
    private static String uploadBasePath;
    
    private static String uploadBaseUrl;

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
    
    
}
