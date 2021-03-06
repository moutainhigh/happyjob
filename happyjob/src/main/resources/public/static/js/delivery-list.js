// 日期选择器
$(".datetimepicker").datetimepicker({
    language: "zh-CN",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd HH:mm:ss"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});

$(".datepicker").datepicker({
    language: "zh-CN",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});


$(document).on("click",".queryDelivery",function(){
	pageSearch(1);
})

//分页查询
function pageSearch(page){
	listParams.comName = $("#comName").val();
	listParams.posName = $("#posName").val();
	listParams.startTime = dateToStartTime($("#startTime").val());
	listParams.endTime = dateToEndTime($("#endTime").val());
	listParams.userName = $("#userName").val();
	listParams.gender = $("#gender").val();
	listParams.contactStat = $("#contactStat").val();
	listParams.currentPage = page;
	fetchList();
}
function dateToStartTime(timestamp) {
	if(timestamp != null && timestamp !=""){
		var formatTimeS = new Date(timestamp+" 00:00:00").getTime();
		return formatTimeS/1000;
	}
	return 0;
}

function dateToEndTime(timestamp) {
	if(timestamp != null && timestamp !=""){
		var formatTimeS = new Date(timestamp+" 23:59:59").getTime();
		return formatTimeS/1000;
	}
	return 0;
}
var $object ;
// 点击联系按钮    出现modal
$(document).on("click",".contact",function(){
	var $row = $(this).parents("tr");
	$object = $row ;
    var hpPositionRefUserId = $row.data("position_ref_user_id");
	fetchPost({
	        url:"/backDelivery/getLoginUserInfo",
	        params: {},
	        callback:function(data){
	            console.log(data);
	            //赋值
	            $("#comtPerson").val(data.realName);
	            $("#comTime").val(data.comTime);
	            $("#positionRefUserId").val(hpPositionRefUserId);
	        	$('#comtactPersonModal').modal('toggle');
	        }
	})
	    
})

// 联系人 联系时间
$(document).on("click","#addComtact",function(){
	var params ={}
    params.comtPerson = $("#comtPerson").val();
	params.comTime = getDayToSecond($("#comTime").val());
	params.positionRefUserId =  $("#positionRefUserId").val();
	
	var $contact = $object.find(".contact");
	var $comPer = $object.find(".comPer");
	var $comTime = $object.find(".comTime");
	fetchPost({
	        url:"/backDelivery/addComtact",
	        params: params,
	        callback:function(data){
	            console.log(data);
	            $contact.eq(0).html("入职");
	            $contact.eq(0).attr('class',"btn btn-primary btn-sm entry");
		        $comPer.eq(0).html($("#comtPerson").val());
		        $comTime.eq(0).html($("#comTime").val());
		        
	        }
	})
    $('#comtactPersonModal').modal('hide')
    
})

// 点击入职  出现modal
$(document).on("click",".entry",function(){
	var $row = $(this).parents("tr");
	$object = $row ;
    var hpPositionRefUserId = $row.data("position_ref_user_id");
    var hpCompanyId = $row.data("company-id");
    var hpUserId = $row.data("hp-user-id");
    
	fetchPost({
	        url:"/backDelivery/getLoginUserInfo",
	        params: {},
	        callback:function(data){
	            console.log(data);
	            $("#comtPerson2").val(data.realName);
	            $("#comTime2").val(data.comTime);
	            $("#positionRefUserId2").val(hpPositionRefUserId);
	            $("#hpCompanyId2").val(hpCompanyId);
	            $("#hpUserId2").val(hpUserId);
	        	$('#comtactPersonModal2').modal('toggle');
	        }
	})
	    
})

// 入职联系人 联系时间
$(document).on("click","#addEntry",function(){
	var params ={}
    params.comtPerson = $("#comtPerson2").val();
	params.comTime = getDayToSecond($("#comTime2").val());
	params.positionRefUserId =  $("#positionRefUserId2").val();
	params.hpCompanyId = $("#hpCompanyId2").val();
	params.hpUserId = $("#hpUserId2").val();
	params.workOn = 1;
	
	var $contact = $object.find(".entry");
	var $comPer = $object.find(".comPer");
	var $comTime = $object.find(".comTime");
	fetchPost({
	        url:"/backDelivery/addComtact",
	        params: params,
	        callback:function(data){
	        	console.log(data);
	        	$contact.eq(0).html("已入职");
	        	$contact.eq(0).attr('class',"btn btn-primary btn-sm entered");
		        $comPer.eq(0).html($("#comtPerson2").val());
		        $comTime.eq(0).html($("#comTime2").val());
	        }
	})
    $('#comtactPersonModal2').modal('hide');
    
})


// 查看
$(document).on("click",".cat",function(){
	var params = {};
    var $row = $(this).parents("tr");
    var hpUserId=$row.data("hp-user-id");
    var realName=$row.data("user-name");
    var gender2 = gender($row.data("gender"));
    var bornYear2=$row.data("born-year");
    var phoneNo=$row.data("phone-no");
    var headerPic=$row.data("header-pic");
    
    params.hpUserId =hpUserId ;
    fetchGet({
        url:"/backDelivery/deliveryQueryByUserId",
        params:params,
        callback:function(data){
        	  console.log(data);
              var $obj = $("#browseModal").find(".showValue");

	          $obj.eq(0).attr("src",headerPic) //头像
	          $obj.eq(1).html(realName);       //姓名
	          $obj.eq(2).html(gender2);        //性别
	          $obj.eq(3).html(bornYear2);      //出生年份
	          $obj.eq(4).html(phoneNo);        //联系电话
	          if(data.educationList.length >0  && data.educationList[0] != null){
	          	$obj.eq(5).html(data.educationList[0].eduName); //最高学历
	          }
	          if(data.intentionList.length >0 && data.intentionList[0] != null){
	          	$obj.eq(6).html(data.intentionList[0].workArea);  //期望工作区域
	          	$obj.eq(7).html(data.intentionList[0].lowerNum + "-" + data.intentionList[0].hightNum);  //期望工资
	          	$obj.eq(8).html(data.intentionList[0].posType);
	          }
	          if(data.experienceList.length >0 && data.experienceList[0] != null){
	          	$obj.eq(9).html(data.experienceList[0].comName);
	          	$obj.eq(10).html(timestampToDay(data.experienceList[0].startTime)+ "&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;&nbsp;"+timestampToDay(data.experienceList[0].endTime));
	          	
	          	$obj.eq(11).html(data.experienceList[0].posType);
	          }
	          $('#browseModal').modal('toggle')
          
        }
    }) 
    
    
})

var listParams = {
		comName:"",
		posName:"",
		startTime:"",
		endTime:"",
		realName:"",
		gender:"",
		contactStat:"",
		currentPage:1,
		showCount:15
}
var list= [];
var totalPage=1;

fetchList();

// 获取table数据
function fetchList(){
    fetchGet({
        url:"/backDelivery/deliveryList",
        params:listParams,
        callback:function(data){
            list = data.list;
            listParams.currentPage = data.page.currentPage;
            totalPage= data.page.totalPage;
            addTableList(list);
            publicObj.pageShow(data.page,pageSearch);
        }
    })    
}
// 认证、禁用、启用请求
//hpUserId approve blackOn
function postAuth(data){
    fetchPost({
        url:"/backUser/userInfoUp",
        params: data,
        callback:function(data){
            console.log(data)
        }
    })
}





// 添加table数据
function addTableList(list){
    var $table = $("#userList");
    var $tBody = $table.find("tbody");
    var templeteTr="";
    list.forEach(function(item){
    	var returnMoney =""+item.reMoney;
    	if(item.teamNum >= 5){
        	returnMoney += "+" +item.fiveMoney +"<br>五人团返现" ;
        }else if(item.teamNum >= 3 && item.teamNum <5){
        	returnMoney += "+"+item.fiveMoney +"<br>三人团返现" ;
        }else{
        	returnMoney += "";
        }
    	if(item.urgentMoney != 0){
    		returnMoney += "+"+item.urgentMoney +"<br>高薪急聘";
    	}
        templeteTr+='\
        <tr \
        	data-position_ref_user_id="'+item.hpPositionRefUserId+'" \
        	data-hp-user-id="'+ item.hpUserId +'" \
            data-user-name="'+ getUserName(item.userName) +'" \
            data-real-name="'+ isNull(item.realName) +'" \
            data-gender="'+ item.gender +'" \
            data-born-year="'+ bornYear(item.bornYear) +'" \
            data-com-name="'+ item.comName +'" \
            data-company-id="'+ item.hpCompanyId +'" \
            data-pos-name="'+ item.posName +'" \
            data-re-money="'+ returnMoney +'" \
            data-part-time="'+ item.partTime +'" \
            data-header-pic="'+ item.headerPic +'" \
            data-phone-no="'+ item.phoneNo +'" >\
            <th>'+ getUserName(item.userName) +'</th>\
            <th>'+ gender(item.gender) +'</th>\
            <th>'+ age(item.bornYear) +'</th>\
            <th>'+ item.comName +'</th>\
            <th>'+ item.posName +'</th>\
            <th>'+ returnMoney +'</th>\
            <th>'+ timestampToDay(item.partTime) +'</th>\
            <th>'+ isNull(item.phoneNo) +'</th>\
            <th>\
	            <button type="button" class="btn btn-default btn-sm cat">查看</button>\ '
            
            if(item.optionPerson == "" || item.optionPerson == null){ //未联系
	        	templeteTr += '<button type="button" class="btn btn-primary btn-sm contact">联系</button>\ '
	        }else{
	        	if(item.workOn == 0){
	        		templeteTr += '<button type="button" class="btn btn-primary btn-sm entry">入职</button>\ '
	        	}else{
	        		templeteTr += '<button type="button" class="btn btn-primary btn-sm entered">已入职</button>\ '
	        	}
	        }
            
	            templeteTr +='</th>\
				        <th class="comPer">'+isNull(item.optionPerson)+'</th>\ <th class="comTime">'+isNull(timestampToDay(item.optionTime))+'</th>\
	        </tr>';
    })
    $tBody.html(templeteTr)    
}

// 判断性别
function gender(gender){    
    return gender==1?"男":"女"
}


//判断出生年份
function bornYear(value){
	if(value !=null){
		var len = value.toString().length;
		var date
		if(len >10){
			date = new Date(value);
		}else{
			date = new Date(value * 1000); 
		}
		var Y = date.getFullYear();
		return   Y;
	}
	return "" ;
}
//age
function age(value){
	
	if(value !=null){
		var len = value.toString().length;
		var date
		if(len >10){
			date = new Date(value);
		}else{
			date = new Date(value * 1000); 
		}
		var Y = date.getFullYear();
		return  new Date().getFullYear()- Number(Y) +1;
	}
	return "" ;
}
//时间戳转date
function timestampToDay(timestamp) {
//	if(timestamp ==null || timestamp ==""){
//		return "";
//	}else{
//		var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
//	    var Y = date.getFullYear() + '-';
//	    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
//	    var D = change(date.getDate()) ;
//	    return Y + M + D ;
//	}
	
	if(timestamp ==null || timestamp ==""){
		return "";
	}else{
		 var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
		    var Y = date.getFullYear() + '-';
		    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		    var D = change(date.getDate()) + ' ';
		    var h = change(date.getHours()) + ':';
		    var m = change(date.getMinutes()) + ':';
		    var s = change(date.getSeconds());
		    return Y + M + D + h + m + s;
	}
	
	
  
}


function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}
function getDayToSecond(timestamp){
	if(timestamp !=null && timestamp !=""){
		return new Date(timestamp).getTime()/1000;
	}
}

function getUserName(userName){
	if(userName){
		return decodeURIComponent(userName);
	}
	return '无';
}

