//// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
//package com.baidu.ueditor;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.happy.util.ServiceConfig;
//
//
//@Component
//public final class ConfigManager {
//
//    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);
//    
//    private static final String configFileName = "config.json";
//
//    private JSONObject jsonConfig;
//    
//    private static  String uRootPath = ServiceConfig.getUeditorRootPath();
//    
//    private static  String savePathPrefix = ServiceConfig.getUeditorSavePathPrefix();
//    
//    private static  String urlPrefix = ServiceConfig.getUeditorUrlPrefix();
//
//    private ConfigManager() {
//        super();
//    }
//    
//    private ConfigManager(String rootPath, String contextPath, String uri) throws FileNotFoundException, IOException {
//        
//        logger.info("ueditor init");
//        
//        logger.info("rootPath : {}", rootPath);
//        logger.info("savePathPrefix : {}", savePathPrefix);
//        logger.info("urlPrefix : {}", urlPrefix);
//        initEnv();
//    }
//
//    public static ConfigManager getInstance(String rootPath, String contextPath, String uri) {
//        try {
//            return new ConfigManager(ConfigManager.uRootPath, contextPath, uri);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public boolean valid() {
//        return jsonConfig != null;
//    }
//
//    public JSONObject getAllConfig() {
//        return jsonConfig;
//    }
//
//    @SuppressWarnings("unchecked")
//    public Map getConfig(int type) {
//        Map conf = new HashMap();
//        String savePath = null;
//        String localSavePathPrefix = null;
//        
//        try {
//            switch (type) {
//                case 4: // '\004'
//                    conf.put("isBase64", "false");
//                    conf.put("maxSize", Long.valueOf(jsonConfig.getLong("fileMaxSize")));
//                    conf.put("allowFiles", getArray("fileAllowFiles"));
//                    conf.put("fieldName", jsonConfig.getString("fileFieldName"));
//                    savePath = jsonConfig.getString("filePathFormat");
//                    break;
//    
//                case 1: // '\001'
//                    conf.put("isBase64", "false");
//                    conf.put("maxSize", Long.valueOf(jsonConfig.getLong("imageMaxSize")));
//                    conf.put("allowFiles", getArray("imageAllowFiles"));
//                    conf.put("fieldName", jsonConfig.getString("imageFieldName"));
//                    savePath = jsonConfig.getString("imagePathFormat");
//                    localSavePathPrefix = jsonConfig.getString("localSavePathPrefix");
//                    
//                    break;
//    
//                case 3: // '\003'
//                    conf.put("maxSize", Long.valueOf(jsonConfig.getLong("videoMaxSize")));
//                    conf.put("allowFiles", getArray("videoAllowFiles"));
//                    conf.put("fieldName", jsonConfig.getString("videoFieldName"));
//                    localSavePathPrefix = jsonConfig.getString("localSavePathPrefix");
//                    savePath = jsonConfig.getString("videoPathFormat");
//                    break;
//    
//                case 2: // '\002'
//                    conf.put("filename", "scrawl");
//                    conf.put("maxSize", Long.valueOf(jsonConfig.getLong("scrawlMaxSize")));
//                    conf.put("fieldName", jsonConfig.getString("scrawlFieldName"));
//                    conf.put("isBase64", "true");
//                    savePath = jsonConfig.getString("scrawlPathFormat");
//                    break;
//    
//                case 5: // '\005'
//                    conf.put("filename", "remote");
//                    conf.put("filter", getArray("catcherLocalDomain"));
//                    conf.put("maxSize", Long.valueOf(jsonConfig.getLong("catcherMaxSize")));
//                    conf.put("allowFiles", getArray("catcherAllowFiles"));
//                    conf.put("fieldName", (new StringBuilder(String.valueOf(jsonConfig.getString("catcherFieldName"))))
//                        .append("[]").toString());
//                    savePath = jsonConfig.getString("catcherPathFormat");
//                    break;
//    
//                case 7: // '\007'
//                    conf.put("allowFiles", getArray("imageManagerAllowFiles"));
//                    conf.put("dir", jsonConfig.getString("imageManagerListPath"));
//                    conf.put("count", Integer.valueOf(jsonConfig.getInt("imageManagerListSize")));
//                    break;
//    
//                case 6: // '\006'
//                    conf.put("allowFiles", getArray("fileManagerAllowFiles"));
//                    conf.put("dir", jsonConfig.getString("fileManagerListPath"));
//                    conf.put("count", Integer.valueOf(jsonConfig.getInt("fileManagerListSize")));
//                    break;
//            }
//        } catch (JSONException e) {
//             e.printStackTrace();
//        }
//        conf.put("savePath", savePath);
//        conf.put("localSavePathPrefix", localSavePathPrefix);
//        conf.put("rootPath", uRootPath);
//        
//        return conf;
//    }
//
//    private String[] getArray(String key) {
//        JSONArray jsonArray;
//        String result[] = null;
//        try {
//            jsonArray = jsonConfig.getJSONArray(key);
//            result = new String[jsonArray.length()];
//            int i = 0;
//            for (int len = jsonArray.length(); i < len; i++)
//                result[i] = jsonArray.getString(i);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    private void initEnv() {
//        
//        
//        logger.info("read config");
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configFileName);
//        StringBuilder builder = new StringBuilder();
//
//        InputStreamReader reader;
//        try {
//            reader = new InputStreamReader(is, "UTF-8");
//            BufferedReader bfReader = new BufferedReader(reader);
//            for (String tmpContent = null; (tmpContent = bfReader.readLine()) != null;)
//                builder.append(tmpContent);
//
//            bfReader.close();
//
//            String configContent = filter(builder.toString());
//            
//            JSONObject jsonConfig = new JSONObject(configContent);
//
//            jsonConfig.put("imageUrlPrefix", urlPrefix);
//            jsonConfig.put("videoUrlPrefix", urlPrefix);
//            jsonConfig.put("localSavePathPrefix", savePathPrefix);
//            
//            
//            
//            this.jsonConfig = jsonConfig;
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//             e.printStackTrace();
//        }
//
//    }
//
//    private String filter(String input) {
//        return input.replaceAll("/\\*[\\s\\S]*?\\*/", "");
//    }
//}