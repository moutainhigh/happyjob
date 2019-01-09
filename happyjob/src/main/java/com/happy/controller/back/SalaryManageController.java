package com.happy.controller.back;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.happy.entity.HpUserEntity;
import com.happy.entity.HpUserPayrollEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.salary.SalaryService;
import com.happy.service.salary.data.LoginUserMsg;
import com.happy.service.salary.data.SalarySimpleListMsg;
import com.happy.util.Util;
import com.happy.util.excel.ExcelUtil;
import com.happy.util.excel.PayrollPojo;
import com.happy.util.pubConst.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台工资管理相关请求API",tags="后台工资管理相关请求API")
@RestController
@RequestMapping("backSalary")
public class SalaryManageController {

	private static final Logger logger = LoggerFactory.getLogger(SalaryManageController.class);
    
    @Resource
    private SalaryService salaryService;
    
    /**
     * @TODO:    工资列表查询
     */
    @ApiOperation(value="工资列表查询",notes="工资列表查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name="workNum",value="工号，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="payName",value="姓名，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="payIdNum",value="身份证号，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="payComName",value="公司名称，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="payTime",value="工资月份",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value="salaryList")
    public SalarySimpleListMsg userList(HttpServletRequest request){
        String workNum = request.getParameter("workNum");
        String payName = request.getParameter("payName");
        String payIdNum = request.getParameter("payIdNum");
        String payComName = request.getParameter("payComName");
        Integer payTime = (Integer)Util.typeChange(request.getParameter("payTime"), Integer.class);
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
       
        logger.info("backUser.userList 请求参数：workNum={},payName={},payIdNum={},"
            + "payComName={},payTime={}",workNum,payName,payIdNum,payComName,payTime);
        SalarySimpleListMsg ss = this.salaryService.getSalaryListPage(workNum,payName,payIdNum,payComName,payTime,currentPage,showCount);
        return ss ;
    }
    
    
	
    @PostMapping(value = "/importSalary")
	public BaseMsg importSalary(@RequestParam(value="file",required=false) MultipartFile file ){
    	return salaryService.importSalary(file);
	}

   
   
}
