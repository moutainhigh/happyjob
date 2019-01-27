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
import com.happy.service.apply.ApplyService;
import com.happy.service.apply.data.ApplyListMsg;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台我要招聘相关请求API",tags="后台我要招聘管理请求API")
@RestController
@RequestMapping("backApply")
public class ApplyController {

    private static final Logger logger = LoggerFactory.getLogger(ApplyController.class);
    
    @Resource
    private ApplyService applyService;
		    
    /**
       *      我要招聘列表查询
     */
    @ApiOperation(value="我要招聘列表查询",notes="我要招聘列表查询")
    @GetMapping(value="/applyList")
    public ApplyListMsg applyList(HttpServletRequest request){
    	
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
        String name = request.getParameter("name");
        String comName = request.getParameter("comName");
        String contactNum = request.getParameter("contactNum");
        
        logger.info("backApply.applyList 请求参数：currentPage={},showCount={},name={},comName={},contactNum={}",currentPage,showCount,name,comName,contactNum);
       
        ApplyListMsg result = this.applyService.getApplylistPage(currentPage,showCount, name , comName,contactNum );
        return  result;
    }
		    
		 
	    /**
	     *   删除
	     */
	    @ApiOperation(value="删除我要招聘",notes="删除我要招聘")
	    @PostMapping(value="deleteApply")
	    public BaseMsg deleteApply(HttpServletRequest request){
	        Long hpCompanyApplyId = (Long)Util.typeChange(request.getParameter("hpCompanyApplyId"), Long.class);
	        logger.info("backApply.deleteApply 请求参数：hpCompanyApplyId={}",hpCompanyApplyId);
	        BaseMsg ss = this.applyService.companyApplyDel(hpCompanyApplyId);
	        return ss;
	    }
		    
		   
		    
	    /**
	     *  入职，添加联系人，联系时间
	     */
	    @ApiOperation(value="添加联系人",notes="添加联系人")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="hpCompanyApplyId",value="hpCompanyApplyId",dataType="Long",paramType="query",required=false),
	        @ApiImplicitParam(name="optionPerson",value="联系人",dataType="String",paramType="query",required=false),
	        @ApiImplicitParam(name="optionTime",value="联系时间",dataType="Long",paramType="query",required=false),
	    })
	    @PostMapping(value = "/addComtact")
		public BaseMsg addComtact(HttpServletRequest request){
	    	Long hpCompanyApplyId = (Long)Util.typeChange(request.getParameter("hpCompanyApplyId"), Long.class);
	    	String optionPerson = request.getParameter("optionPerson").trim();
	    	Long optionTime = (Long)Util.typeChange(request.getParameter("optionTime"), Long.class);
	    	BaseMsg msg = applyService.addComtact(hpCompanyApplyId,optionPerson,optionTime);
	    	logger.info("backApply.addComtact hpCompanyApplyId={},optionPerson={},optionTime={}",hpCompanyApplyId,optionPerson,optionTime);
	    	return msg ;
	    }
		    
		   
}
