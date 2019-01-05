 package com.happy.service.config;

import com.happy.service.config.data.EduListMsg;
import com.happy.service.config.data.SalaryListMsg;
import com.happy.service.config.data.StoreDataMsg;
import com.happy.service.config.data.StoreListMsg;

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
   
   /**
    *
    * @TODO:     获取门店信息列表
    * @CreateTime:  2019年1月5日下午3:23:13 
    */
   StoreListMsg getStoreListPage(int isPage,Integer currentPage,Integer showCount);
   /**
   *
   * @TODO:     获取门店详细信息
   * @CreateTime:  2019年1月5日下午3:23:13 
   */
   StoreDataMsg getStoreDetail(Long hpCompanyStoreId);
}
