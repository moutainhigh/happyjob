package com.happy.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.plugin.BaseMsg;
import com.happy.service.delivery.DeliveryService;
import com.happy.service.delivery.data.DeliveryDetail;
import com.happy.service.delivery.data.DeliveryListMsg;
import com.happy.service.salary.data.LoginUserMsg;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台投递管理相关请求API",tags="后台投递管理相关请求API")
@RestController
@RequestMapping("backDelivery")
public class DeliveryManageController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeliveryManageController.class);
    
    @Resource
    private DeliveryService deliveryService;
    
    /**
     * @TODO:    投递列表查询
     */
    @ApiOperation(value="投递列表查询",notes="投递列表查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name="userName",value="用户名，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="comName",value="公司名称，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="posName",value="职位名称，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="startTime",value="开始时间",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="endTime",value="结束时间",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="gender",value="性别",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="contactStat",value="联系状态 1已联系；2未联系",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="currentPage",value="当前页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="showCount",value="单页展示记录数",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value="deliveryList")
    public DeliveryListMsg deliveryList(HttpServletRequest request){
        String comName = request.getParameter("comName");
        if(comName != null) {
        	comName = comName.trim();
        }
        String posName = request.getParameter("posName");
        if(posName != null) {
        	posName = posName.trim();
        }
        Long startTime = (Long)Util.typeChange(request.getParameter("startTime"), Long.class);
        Long endTime = (Long)Util.typeChange(request.getParameter("endTime"), Long.class);
        
        String userName = request.getParameter("userName");
        if(userName != null) {
        	userName = userName.trim();
        }
        
        Integer gender = (Integer)Util.typeChange(request.getParameter("gender"), Integer.class);
        String contactStat =  request.getParameter("contactStat");
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
       
        logger.info("backDelivery.deliveryList 请求参数：userName={},comName={},posName={},"
            + "startTime={},endTime={},realName={},gender={},contactStat={},currentPage={},showCount={}",
        	comName,posName,startTime,endTime,userName,gender,contactStat,currentPage,showCount);
        DeliveryListMsg ss = this.deliveryService.getDeliverylistPage(comName,posName,startTime,endTime,userName,gender,contactStat,currentPage,showCount);
        return ss ;
    }
    
    /**
     *    投递查看
     */
    @ApiOperation(value="投递查看",notes="投递查看")
    @ApiImplicitParams({
        @ApiImplicitParam(name="hpUserId",value="用户id",dataType="Long",paramType="query",required=false),
    })
    @GetMapping(value="deliveryQueryByUserId")
    public DeliveryDetail deliveryQueryByUserId(HttpServletRequest request){
    	
        Long hpUserId = (Long)Util.typeChange(request.getParameter("hpUserId"), Long.class);
        logger.info("backDelivery.deliveryQueryByUserId 请求参数：hpUserId={}",hpUserId);
        DeliveryDetail deliveryDetail = this.deliveryService.deliveryQueryByUserId(hpUserId);
        
        return deliveryDetail ;
    }
    
    /**
     *  入职，添加联系人，联系时间
     */
    @ApiOperation(value="添加联系人，联系时间",notes="添加联系人，联系时间")
    @ApiImplicitParams({
        @ApiImplicitParam(name="hpPositionRefUserId",value="hpPositionRefUserId",dataType="Long",paramType="query",required=true),
        @ApiImplicitParam(name="comtPerson",value="联系人",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="comTime",value="联系时间",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="workOn",value="是否入职 0未入职 1已入职",dataType="Integer",paramType="query",required=false),
        @ApiImplicitParam(name="hpCompanyId",value="投递的公司id",dataType="Long",paramType="query",required=true),
        @ApiImplicitParam(name="hpUserId",value="用户id",dataType="Long",paramType="query",required=true),
    })
    @PostMapping(value = "/addComtact")
	public BaseMsg addComtact(HttpServletRequest request){
    	Long hpPositionRefUserId = (Long)Util.typeChange(request.getParameter("positionRefUserId"), Long.class);
    	String comtPerson = request.getParameter("comtPerson").trim();
    	Long comTime = (Long)Util.typeChange(request.getParameter("comTime"), Long.class);
    	Long hpCompanyId = (Long)Util.typeChange(request.getParameter("hpCompanyId"), Long.class);
    	Long hpUserId = (Long)Util.typeChange(request.getParameter("hpUserId"), Long.class);
    	Integer workOn = (Integer)Util.typeChange(request.getParameter("workOn"), Integer.class);
    	BaseMsg msg = deliveryService.addComtact(hpPositionRefUserId,comtPerson,comTime,workOn,hpCompanyId , hpUserId);
    	logger.info("backDelivery.addComtact hpPositionRefUserId={},comtPerson={},hpPositionRefUserId={}",hpPositionRefUserId,comtPerson,comTime);
    	return msg ;
    }
    
    
    /**
     * @TODO:    获取登陆用户信息
     */
    @ApiOperation(value="获取登陆用户信息",notes="获取登陆用户信息")
    @PostMapping(value = "/getLoginUserInfo")
	public LoginUserMsg getLoginUserInfo(HttpServletRequest request){
    	Cookie[] cookiesArr =  request.getCookies();
    	String userToken="";
    	
    	if (cookiesArr !=null) {
            for (Cookie cookie : cookiesArr) {
                if (cookie.getName().equals(Const.COOKIE_ATTR_NAME_SID)) {
                	userToken = cookie.getValue();
                }
            }
        }
    	LoginUserMsg loginUserMsg = deliveryService.getLoginUserInfo(userToken);
    	logger.info("backUser.getLoginUser userToken={}",userToken);
    	return loginUserMsg ;
    }
    
}
