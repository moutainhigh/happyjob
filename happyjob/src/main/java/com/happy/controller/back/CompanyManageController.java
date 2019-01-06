package com.happy.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.plugin.BaseMsg;
import com.happy.service.company.CompanyService;
import com.happy.service.company.data.CompanyListMsg;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台企业管理相关请求API",tags="后台企业管理相关请求API")
@RestController
@RequestMapping("backCompany")
public class CompanyManageController {

	private static final Logger logger = LoggerFactory.getLogger(CompanyManageController.class);
    
    @Resource
    private CompanyService companyService;
    
    /**
     * @TODO:    工资列表查询
     */
    @ApiOperation(value="工资列表查询",notes="工资列表查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name="comName",value="公司名称，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="startTime",value="开始时间",dataType="long",paramType="query",required=false),
        @ApiImplicitParam(name="endTime",value="结束时间",dataType="long",paramType="query",required=false),
    })
    @GetMapping(value="companyList")
    public CompanyListMsg companyListPage(HttpServletRequest request){
    	Long startTime = (Long)Util.typeChange(request.getParameter("startTime"), Long.class);
        Long endTime = (Long)Util.typeChange(request.getParameter("endTime"), Long.class);
        String comName = request.getParameter("comName");
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
       
        logger.info("backCompany.companyList 请求参数：comName={},startTime={},endTime={},currentPage={},showCount={}",comName,startTime,endTime,currentPage,showCount);
        CompanyListMsg ss = this.companyService.companyListPage(comName,startTime,endTime,currentPage,showCount);
        return ss ;
    }
    
    /**
     * 认证
     */
    @ApiOperation(value="企业认证",notes="企业认证")
    @ApiImplicitParams({
        @ApiImplicitParam(name="companyId",value="公司id",dataType="Long",paramType="query",required=false),
        @ApiImplicitParam(name="approveState",value="认证状态  0未认证，1认证通过，2认证不通过",dataType="int",paramType="query",required=false),
    })
    @PostMapping(value="companyAuth")
    public BaseMsg companyAuth(HttpServletRequest request){
        Long companyId = (Long)Util.typeChange(request.getParameter("companyId"), Long.class);
        Integer approveState = (Integer)Util.typeChange(request.getParameter("approveState"), Integer.class);
        logger.info("backAdvertisement.deleteAdvertisement 请求参数：companyId={},approveState={}",companyId,approveState);
        BaseMsg ss = this.companyService.companyAuth(companyId,approveState);
        return ss;
    }
    
    
}
