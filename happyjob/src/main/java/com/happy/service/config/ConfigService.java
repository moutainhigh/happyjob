 package com.happy.service.config;

import com.happy.service.config.data.EduListMsg;
import com.happy.service.config.data.SalaryListMsg;

public interface ConfigService {
     
    /**
    *
    * @TODO:     获取学历水平选项集合
    * @CreateTime:  2019年1月2日下午8:33:13 
    */
   EduListMsg getEduList(int useOn);
   /**
    *
    * @TODO:     获取学历水平选项集合
    * @CreateTime:  2019年1月2日下午8:33:13 
    */
   SalaryListMsg getSalaryList();
    
}
