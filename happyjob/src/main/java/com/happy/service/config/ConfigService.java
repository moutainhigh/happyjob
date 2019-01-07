 package com.happy.service.config;

import com.happy.service.config.data.AreaListMsg;
import com.happy.service.config.data.EduListMsg;
import com.happy.service.config.data.PosTypeListMsg;
import com.happy.service.config.data.SalaryListMsg;
import com.happy.service.config.data.StoreDataMsg;
import com.happy.service.config.data.StoreListMsg;
import com.happy.service.config.data.WelfareListMsg;

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
   /**
   *
   * @TODO:   招聘福利选项
   */
  WelfareListMsg getPositionWelfare();
  /**
  *
  * @TODO:   获取下级地区集合:0、获取所有省，1、获取省下市，2、获取市下区
  */
  AreaListMsg getAreaList(int areaCode,Long areaId);
  /**
   *
   * @TODO:   获取职位行业类型
   */
  PosTypeListMsg getPosTypeList();
}
