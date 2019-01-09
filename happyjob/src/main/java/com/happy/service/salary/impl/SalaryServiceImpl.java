package com.happy.service.salary.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.happy.entity.HpUserPayrollEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.salary.SalaryService;
import com.happy.service.salary.data.SalaryManageSearch;
import com.happy.service.salary.data.SalarySimpleListMsg;
import com.happy.sqlExMapper.HpSalaryExMapper;
import com.happy.sqlMapper.HpUserPayrollMapper;
import com.happy.util.Util;
import com.happy.util.excel.ExcelUtil;
import com.happy.util.excel.PayrollPojo;

@Service
public class SalaryServiceImpl implements SalaryService { 

	private static final Logger logger = LoggerFactory.getLogger(SalaryServiceImpl.class);
	   
	@Autowired
	private HpSalaryExMapper hpSalaryExMapper;
	
	@Autowired
	private HpUserPayrollMapper hpUserPayrollMapper ;
	
	
	
	
	
	@Override
	public SalarySimpleListMsg getSalaryListPage(String workNum, String payName, String payIdNum, String payComName,
			Integer payTime,Integer currentPage,Integer showCount) {
		SalarySimpleListMsg msg = new SalarySimpleListMsg();
		SalaryManageSearch page = new SalaryManageSearch();
        
		currentPage = currentPage==null || currentPage<1?1:currentPage;
        showCount = showCount==null||showCount<1?10:showCount;
        
        page.setCurrentPage(currentPage);
        page.setShowCount(showCount);
        page.setWorkNum(workNum);
        page.setPayName(payName);
        page.setPayIdNum(payIdNum);
        page.setPayComName(payComName);
        page.setPayTime(payTime);
        
        List<HpUserPayrollEntity> list = this.hpSalaryExMapper.getSalarylistPage(page);
        msg.setList(list);
        msg.setPage(page);
        return msg;
	}


	@Override
	public List<HpUserPayrollEntity> getPayroll(HpUserPayrollEntity hpUserPayrollEntity) {
		List<HpUserPayrollEntity> list = hpSalaryExMapper.getPayroll(hpUserPayrollEntity);
		return list;
	}

	@Override
	public BaseMsg importSalary(MultipartFile file) {
    	BaseMsg msg = new BaseMsg();
		try {
			InputStream is = file.getInputStream();
			String name = file.getOriginalFilename();
			if( is != null) {
				List<PayrollPojo> dataList = ExcelUtil.parseExcelToPayrollPojoList(is,name);
				for(PayrollPojo payrollPojo : dataList) {
					HpUserPayrollEntity hpUserPayrollEntity = new HpUserPayrollEntity();
					hpUserPayrollEntity.setPayIdNum(payrollPojo.getPayIdNum());
					hpUserPayrollEntity.setPayTime(payrollPojo.getPayTime());
					List<HpUserPayrollEntity> list = getPayroll(hpUserPayrollEntity);
					if(list.size() > 0){
						HpUserPayrollEntity userPayroll = list.get(0);
						userPayroll.setPayName(payrollPojo.getPayName());
						userPayroll.setWorkNum(payrollPojo.getWorkNum());
						userPayroll.setPayComName(payrollPojo.getPayComName());
						userPayroll.setShouldMoney(payrollPojo.getShouldMoney());
						userPayroll.setDeductionMoney(payrollPojo.getDeductionMoney());
						userPayroll.setRealMoney(payrollPojo.getRealMoney());
						userPayroll.setPayDetail(payrollPojo.getPayDetail().toJSONString());
						userPayroll.setCreateTime(Util.getDateSecond(new Date()));
						hpUserPayrollMapper.updateByPK(userPayroll);
					}else {
						hpUserPayrollEntity.setPayName(payrollPojo.getPayName());
						hpUserPayrollEntity.setWorkNum(payrollPojo.getWorkNum());
						hpUserPayrollEntity.setPayComName(payrollPojo.getPayComName());
						hpUserPayrollEntity.setShouldMoney(payrollPojo.getShouldMoney());
						hpUserPayrollEntity.setDeductionMoney(payrollPojo.getDeductionMoney());
						hpUserPayrollEntity.setRealMoney(payrollPojo.getRealMoney());
						hpUserPayrollEntity.setPayDetail(payrollPojo.getPayDetail().toJSONString());
						hpUserPayrollEntity.setCreateTime(Util.getDateSecond(new Date()));
						hpUserPayrollMapper.insert(hpUserPayrollEntity);
					}
					
					
				}
			}
			
		}catch(Exception e) {
			logger.error("backUser.importSalary ----出错--------------");
			msg.setErrorCode(1);
			msg.setMessage("导入出错");
		}
		msg.setErrorCode(0);
		msg.setMessage("导入成功");
		logger.info("backUser.importSalary -----end--------------");
		return msg ;

	}

	
}
