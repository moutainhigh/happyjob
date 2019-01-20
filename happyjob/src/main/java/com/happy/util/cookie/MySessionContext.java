
 package com.happy.util.cookie;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.happy.util.Util;
import com.happy.util.pubConst.Const;

/**
 *
 *   TODO: 描述这个类用来做什么事情TODO
 *
 *  @CreateTime  : 2019年1月13日上午10:47:58
 *  @CreateAuthor: chenwei
 *  @Email       : 
 *
 */
public class MySessionContext {
    
    private static final Logger logger = LoggerFactory.getLogger(MySessionContext.class);
    
    private static HashMap<String,HttpSession> mymap = new HashMap<String,HttpSession>();

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
            int i=0;
            if(mymap !=null && mymap.size()>0) {
                long curTime = Util.getDateSecond(Util.getCurrentDate());
                for(Entry<String, HttpSession> entry:mymap.entrySet()) {
                    HttpSession item = entry.getValue();
                    Long sessionTime = 0l;
                    try {
                        Object sessionTimeObj = item.getAttribute(Const.SESSION_ATTR_NAME_AGE);
                        sessionTime = (long)sessionTimeObj;
                    } catch (Exception e) {
                        logger.error("内部session类出现异常",e);
                    }    
                    i++;
                    if(curTime>sessionTime) {
                        DelSession(item);
                        return;
                    }
                    if(i>10) {
                        return;
                    }
                }
            }
        }
        
    }

    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null)
        return null;
        return mymap.get(session_id);
    }

}
