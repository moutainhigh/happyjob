package com.happy.controller.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSONObject;
import com.happy.plugin.BaseMsg;
import com.happy.util.ServiceConfig;
import com.happy.util.Util;
import com.happy.util.cookie.MySessionContext;
import com.happy.util.pubConst.Const;
/**
 *
 *   TODO: request/response公共方法、文件上传
 */
public class BaseController {
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    // 正式
    private static String baseUrl = ServiceConfig.getUploadBasePath();
    private static String urlPath = ServiceConfig.getUploadBaseUrl();


    /**
     * @TODO 根据名字获取cookie
     * 
     * @param request
     * @param name
     *            cookie名字
     * @return
     */
    public static String getCookieByName(HttpServletRequest request,String name) {
        Map<String, Cookie> cookieMap = BaseController.ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie.getValue();
        } else {
            return null;
        }
    }

    /**
     *@TODO  将cookie封装到Map里面
     * 
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * @TODO  设置cookie
     * 
     * @param name
     *            cookie名字
     * @param value
     *            cookie值
     * @param maxAge
     *            cookie生命周期 以秒为单位
     */
    public static void addCookie(HttpServletResponse response,String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }



    /**
     * @TODO 清除指定名称的cookie
     */
    public static void removeCookieByName(HttpServletResponse response,String name) {
        Cookie newCookie = new Cookie(name, null);
        newCookie.setMaxAge(0);
        newCookie.setPath("/");
        response.addCookie(newCookie);
    }

    /**
     * @Description: 清除cookie所有信息
     */
    public static void removeAllCookies(HttpServletRequest request,
            HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (!"JSESSIONID".equals(cookie.getName())) {
                    Cookie newCookie = new Cookie(cookie.getName(), null);
                    newCookie.setMaxAge(0);
                    newCookie.setPath("/");
                    response.addCookie(newCookie);
                }
            }
        }
    }



    /**
     *
     * @TODO:     获取访问端IP地址
     */
    public static String getRemoteHost(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }



    /**
     * 
     * @Description: 遍历请求头中信息
     */
    public static JSONObject TraverseHttp(HttpServletRequest request) {
        Enumeration<?> headEnu = request.getHeaderNames();
        JSONObject json = new JSONObject(true);
        while (headEnu.hasMoreElements()) {
            String hName = (String) headEnu.nextElement();
            String hValue = "";
            Enumeration<?> hValueEnu = request.getHeaders(hName);
            while (hValueEnu.hasMoreElements()) {
                hValue += hValueEnu.nextElement();
            }
            
            json.put(hName, hValue);
        }
        return json;
    }

    /**
     * 获取MultipartRequest：文件流
     */
    public static MultipartHttpServletRequest getMultiReq(
            HttpServletRequest request) {
        String contentType = request.getContentType();
        MultipartHttpServletRequest multipartRequest = null; // 获取图片
        if (contentType != null
                && contentType.toLowerCase().startsWith("multipart/")) {
            multipartRequest = WebUtils.getNativeRequest(request,
                    MultipartHttpServletRequest.class);
        }
        return multipartRequest;
    }
    
    /**
    *
    * @TODO:     文件上传
    * @param file_member MultipartFile
    * @param leftPath 存储文件夹
    * @param fileRegex 文件格式要求，小写正则
    * @param minSize 文件最小字节数，值大于零则存在最小值限制
    * @param maxSize 文件最大字节数，值大于零则存在最大值限制
    */
       public static JSONObject UploadFiles(MultipartFile file_member, String leftPath, String fileRegex,long minSize,
               long maxSize) {
           JSONObject json = new JSONObject();
           json.put(Const.RESUTL_MESSAGE_ERRORCODE, 3);
           json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件上传失败");
           if (file_member == null || file_member.getSize() <= 0) {
               json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
               json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件为空");
               return json;
           }
           if(maxSize >0 && file_member.getSize()>maxSize) {
               json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
               json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件大小超过最大限制");
               return json;
           }
           if(minSize >0 && file_member.getSize()<minSize) {
               json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
               json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件大小超过最小限制");
               return json;
           }
           String fileName = file_member.getOriginalFilename();
           if(fileName == null) {
               json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
               json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件格式不符");
               return json;
           }
           
           // 采用UUID生成随机文件名
           fileName = UUID.randomUUID().toString().replace("-", "")
                   + fileName.substring(fileName.lastIndexOf("."));

           // 找到对应相册文件夹
           String realPath = urlPath + leftPath + "/" + fileName;
           leftPath = baseUrl + leftPath;

           String lowFileName = fileName.toLowerCase();
           if(!Util.isEmpty(fileRegex) && !lowFileName.matches(fileRegex) ) {
               json.put(Const.RESUTL_MESSAGE_ERRORCODE, 2);
               json.put(Const.RESUTL_MESSAGE_MESSAGE, "文件格式不符合");
               return json;
           }
           

           File file = new File(leftPath, fileName);
           try {
               file_member.transferTo(file);
               
               json.put(Const.RESUTL_MESSAGE_UP_IMG_URL, realPath);
               json.put(Const.RESUTL_MESSAGE_ERRORCODE, 0);
               json.put(Const.RESUTL_MESSAGE_MESSAGE, "success");
               return json;
           } catch (IllegalStateException e) {
               logger.error("文件上传异常===",e);
           } catch (IOException e) {
               logger.error("文件上传异常===",e);
           }
           
           return json;
       }
       /**
        *
        * @TODO:     验证手机号、验证码是否正确
        */
      public static BaseMsg checkPhoneCode(String sessionId,String phoneNo,String msgCode) {
          BaseMsg msg = new BaseMsg();
          HttpSession session = MySessionContext.getSession(sessionId);
          if(session == null) {
              msg.setErrorCode(1);
              msg.setMessage("验证码信息有误，请重新发送验证码");
              return msg;
          }
          logger.info("验证码验证 sessionId==={}",session.getId());
          Object sessionphoneObj = session.getAttribute(Const.SESSION_ATTR_NAME_PHONE);
          String sessionphone = sessionphoneObj==null?null:(String)sessionphoneObj;
          String sessionCodeObj = (String)session.getAttribute(Const.SESSION_ATTR_NAME_MSGCODE);
          String sessionCode = sessionCodeObj==null?null:(String)sessionCodeObj;
          Long sessionAgeObj = (Long)session.getAttribute(Const.SESSION_ATTR_NAME_AGE);
          Long sessionAge = sessionAgeObj==null?null:(Long)sessionAgeObj;
          Long curTime = Util.getDateSecond(Util.getCurrentDate());
          
          logger.info("sessionphone=={},sessionCode=={},sessionAge=={}",sessionphone,sessionCode,sessionAge);
          
          if(!Util.isEmpty(phoneNo) && !Util.isEmpty(msgCode) && phoneNo.equals(sessionphone) 
              && msgCode.equals(sessionCode) && !Util.isEmpty(sessionAge) && curTime.compareTo(sessionAge)<=0) {
              
              MySessionContext.DelSession(session);
              
              return msg;
          }
          MySessionContext.DelSession(session);
          msg.setErrorCode(1);
          msg.setMessage("验证码信息有误，请重新发送验证码");
          return msg;
       }
      /**
       *
       * @TODO:     文件流存入硬盘
       * @return
       */
      public static String uploadFileInput(InputStream in,String leftPath) {
          OutputStream out = null;
          String fileName = Util.dateFormat(Util.getCurrentDate(),
              "yyyyMMddHHmmsss")
              + Util.getRandomStringByLength(6, "base")
              + ".jpg";
          String realPath = ServiceConfig.getUploadBasePath() + leftPath + "/" + fileName;
          String url = ServiceConfig.getUploadBaseUrl() + leftPath + "/" + fileName;
          
          try {
                File outFile = new File(realPath);
                if(!outFile.exists()) {
                    outFile.createNewFile();
                }
                out = new FileOutputStream(outFile);
                int length = 0;
                byte[] buffer = new byte[1024];
                while((length=in.read(buffer, 0, 1024))!=-1) {
                    out.write(buffer, 0, length);
                }
                out.flush();
                return url;
          } catch (IOException e) {
                logger.error("图片文件流写入异常==",e);
          }finally {
              if(out !=null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                         e.printStackTrace();
                    }
              }
          }
          return null;
      }
      
      @Test
      public void test1() {
          String targetUrl = "D:\\apache-tomcat-7.0.40\\webapps\\uploadFiles\\uploadImgs\\goodsPic\\goodsPic8cc8743ed69f4d89991c9af5c5a842c4.png";
          File file = new File(targetUrl);
          try {
            InputStream in = new FileInputStream(file);
            String result = BaseController.uploadFileInput(in, Const.HP_UP_IMG_USER_PATH);
            System.out.println(result);
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        }
          
      }
}
