package com.happy.controller.back;
/**
 * TODO : 后台controller的RequestMapping值加上back前缀，会统一使用拦截器管理登录信息；@Api的注解描述统一加上后台，方便页面文档查看
 */
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.happy.plugin.BaseMsg;
import com.happy.service.message.MessageService;
import com.happy.service.user.UserService;
import com.happy.service.user.data.UserAddData;
import com.happy.service.user.data.UserSimpleListMsg;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台用户管理相关请求API",tags="后台用户管理相关请求API")
@RestController
@RequestMapping("backUser")
public class UserManageController {

    private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);
    
    @Resource
    private UserService userService;
    @Resource
    private MessageService messageService;
    
    /**
     * @TODO:     用户列表查询
     */
    @ApiOperation(value="用户列表查询",notes="用户列表查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name="phoneNo",value="手机号码，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="resource",value="注册来源1、APP，2、小程序，3、微信，4、门店，5、邀请注册",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="startTime",value="注册时间开始：时间戳（s）",dataType="long",paramType="query",required=false),
        @ApiImplicitParam(name="endTime",value="注册时间结束：时间戳（s）",dataType="long",paramType="query",required=false),
        @ApiImplicitParam(name="blackOn",value="是否禁用，0、未禁用，1、已禁用，空全部",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="userType",value="账号类型，1、管理员，2、求职者",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="currentPage",value="当前页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="showCount",value="单页展示数，默认10",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value="userList")
    public UserSimpleListMsg userList(HttpServletRequest request){
        
        String phoneNo = request.getParameter("phoneNo");
        Integer resource = (Integer)Util.typeChange(request.getParameter("resource"), Integer.class);
        Long startTime = (Long)Util.typeChange(request.getParameter("startTime"), Long.class);
        Long endTime = (Long)Util.typeChange(request.getParameter("endTime"), Long.class);
        Integer blackOn = (Integer)Util.typeChange(request.getParameter("blackOn"), Integer.class);
        Integer userType = (Integer)Util.typeChange(request.getParameter("userType"), Integer.class);
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
        
        logger.info("backUser.userList 请求参数：phoneNo={},resource={},startTime={},"
            + "endTime={},blackOn={},userType={},currentPage={},showCount={}",phoneNo,resource,startTime,endTime,blackOn,userType,currentPage,showCount);
        
        return this.userService.getUserListPage(phoneNo, resource, startTime, endTime, blackOn, userType, currentPage, showCount);
    }
    
    /**
     * @TODO:     用户列表用户添加
     */
    @ApiOperation(value="用户列表用户添加",notes="用户列表用户添加")
    @PostMapping(value="userInfo")
    public BaseMsg userInfo(@RequestBody UserAddData data){
        logger.info("backUser.userInfo 请求参数：userInfo={},",JSONObject.toJSONString(data));
        return this.userService.insertUserBase(data);
    }
    
    /**
     * @TODO:     用户列表用户认证、禁用
     */
    @ApiOperation(value="用户列表用户认证、禁用",notes="用户列表用户认证、禁用")
    @ApiImplicitParams({
        @ApiImplicitParam(name="hpUserId",value="用户ID",dataType="long",paramType="query",required=true),
        @ApiImplicitParam(name="approve",value="认证，0、不通过，1、通过",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="blackOn",value="禁用，0、不禁用，1、禁用",dataType="int",paramType="query",required=false),
    })
    @PostMapping(value="userInfoUp")
    public BaseMsg userInfoUp(HttpServletRequest request){
        Long hpUserId = (Long)Util.typeChange(request.getParameter("hpUserId"), Long.class);
        Integer approve = (Integer)Util.typeChange(request.getParameter("approve"), Integer.class);
        Integer blackOn = (Integer)Util.typeChange(request.getParameter("blackOn"), Integer.class);
        
        logger.info("backUser.userInfoUp 请求参数：hpUserId={},approve={},blackOn={}",hpUserId,approve,blackOn);
        BaseMsg msg = this.userService.updateUserState(hpUserId, approve, blackOn);
        if(msg.getErrorCode() == 0 && msg.getSendOn() == 1) { // 认证通过后消息推送
            try {
                this.messageService.sendUserApproveMsg(hpUserId);
            } catch (Exception e) {
                logger.error("拼团成功消息推送异常===",e);
            }
        }
        return msg;
    }
}
