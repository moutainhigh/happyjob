// 日期选择器
$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});

$(document).on("click",".queryDelivery",function(){
	
	fetchList(1);
})

//分页查询
function pageSearch(page){
	listParams.userName = $("#userName").val();
	listParams.comName = $("#comName").val();
	listParams.posName = $("#posName").val();
	listParams.startTime = $("#startTime").val();
	listParams.endTime = $("#endTime").val();
	listParams.realName = $("#realName").val();
	listParams.gender = $("#gender").val();
	listParams.contactStat = $("#contactStat").val();
	listParams.currentPage = page;
	fetchList();
}
// 联系-->入职
$(document).on("click",".contact",function(){
	var params ={}
	var $row = $(this).parents("tr");
	var $row = $(this).parents("tr");
    var hpPositionRefUserId = $row.data("position_ref_user_id");
    params.hpPositionRefUserId = hpPositionRefUserId ;
	var $contact = $(this).parents("tr").find(".contact");
	var $comPer = $(this).parents("tr").find(".comPer");
	var $comPon = $(this).parents("tr").find(".comPon");
	fetchPost({
	        url:"/backDelivery/getLoginUser",
	        params: params,
	        callback:function(data){
	            console.log(data)
	            $contact.eq(0).html("入职");
	            $comPer.eq(0).html(data.userName);
	            $comPon.eq(0).html(data.phoneNo);
	        }
	    })
})

// 查看
$(document).on("click",".cat",function(){
	var params = {};
    var $row = $(this).parents("tr");
    var hpUserId=$row.data("hp-user-id");
    var realName=$row.data("real-name");
    var gender2 = gender($row.data("gender"));
    var bornYear2=bornYear($row.data("born-year"));
    var phoneNo=$row.data("phone-no");
    var headerPic=$row.data("header-pic");
    
    params.hpUserId =hpUserId ;
    fetchGet({
        url:"/backDelivery/deliveryQueryByUserId",
        params:params,
        callback:function(data){
            var $obj = $("#browseModal").find(".showValue");
            if(data.educationList.length >0){
            	$obj.eq(6).html(data.educationList[0].eduName);
            }
            if(data.intentionList.length >0){
            	$obj.eq(8).html(data.intentionList[0].workArea);
            	$obj.eq(10).html(data.intentionList[0].posType);
            }
            if(data.experienceList.length >0){
            	$obj.eq(11).html(data.experienceList[0].comName);
            	$obj.eq(12).html(timestampToDay(data.experienceList[0].startTime)+"--"+timestampToDay(data.experienceList[0].endTime));
            	
            	$obj.eq(13).html(data.experienceList[0].posType);
            }
            

          $obj.eq(0).attr("src",headerPic)
          $obj.eq(1).html(realName);
          $obj.eq(2).html(gender2);
          $obj.eq(3).html(bornYear2);
//          $obj.eq(4).html(createTime)
          $obj.eq(5).html(phoneNo);
//          
//          $obj.eq(7).attr("src",idFrontPic)
//          $obj.eq(8).attr("src",idBackPic)
          $('#browseModal').modal('toggle')
          
        }
    }) 
    
    
})

var listParams = {
		userName:"",
		comName:"",
		posName:"",
		startTime:"",
		endTime:"",
		realName:"",
		gender:"",
		contactStat:"",
		currentPage:1,
		showCount:5
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
// 认证、禁用、复用请求
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
        templeteTr+='\
        <tr \
        	data-position_ref_user_id="'+item.hpPositionRefUserId+'" \
        	data-hp-user-id="'+ item.hpUserId +'" \
            data-user-name="'+ item.userName +'" \
            data-real-name="'+ item.realName +'" \
            data-gender="'+ item.gender +'" \
            data-born-year="'+ item.bornYear +'" \
            data-com-name="'+ item.comName +'" \
            data-pos-name="'+ item.posName +'" \
            data-re-money="'+ item.reMoney +'" \
            data-part-time="'+ item.partTime +'" \
            data-header-pic="'+ item.headerPic +'" \
            data-phone-no="'+ item.phoneNo +'" >\
            <th>'+ item.userName +'</th>\
            <th>'+ item.realName +'</th>\
            <th>'+ gender(item.gender) +'</th>\
            <th>'+ bornYear(item.bornYear) +'</th>\
            <th>'+ item.comName +'</th>\
            <th>'+ item.posName +'</th>\
            <th>'+ item.reMoney +'</th>\
            <th>'+ timestampToTime(item.partTime) +'</th>\
            <th>'+ item.phoneNo +'</th>\
            <th>\
                <button type="button" class="btn btn-default btn-sm cat">查看</button>\
                <button type="button" class="btn btn-primary btn-sm contact">联系</button>\
            </th>\
            <th class="comPer"></th>\
            <th class="comPho"></th>\
        </tr>';
                // <button type="button" class="btn btn-danger btn-sm restart">复用</button>\
    })
    $tBody.html(templeteTr)    
}
// 判断性别
function gender(gender){    
    return gender==1?"男":"女"
}
//判断账号类别
function userType(userType){
    return userType==1?"超级管理员":"求职者"
}
//判断出生年份
function bornYear(value){
    return  new Date().getFullYear()- Number(value)+"岁"
}
//时间戳转date
function timestampToTime(timestamp) {
    var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var D = change(date.getDate()) + ' ';
    var h = change(date.getHours()) + ':';
    var m = change(date.getMinutes()) + ':';
    var s = change(date.getSeconds());
    return Y + M + D + h + m + s;
}

function timestampToDay(timestamp) {
    var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var D = change(date.getDate()) ;
   
    return Y + M + D ;
}
function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}

