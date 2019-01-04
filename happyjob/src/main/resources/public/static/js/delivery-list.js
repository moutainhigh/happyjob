// 日期选择器
$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});

$(document).on("click",".queryDelivery",function(){
	listParams.userName = $("#userName").val();
	listParams.comName = $("#comName").val();
	listParams.posName = $("#posName").val();
	listParams.startTime = $("#startTime").val();
	listParams.endTime = $("#endTime").val();
	listParams.realName = $("#realName").val();
	listParams.gender = $("#gender").val();
	listParams.contactStat = $("#contactStat").val();
	
	fetchList();
})

// 认证
$(document).on("click",".auth",function(){
    swal({
        title: '认证',
        text: '是否通过认证!',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: '通过',
        cancelButtonText: '不通过',
        }).then(function(isConfirm) {
        if (isConfirm === true) {
            swal(
            'Deleted!',
            'Your imaginary file has been deleted.',
            'success'
            );
        
        } else if (isConfirm === false) {
            swal(
            'Cancelled',
            'Your imaginary file is safe :)',
            'error'
            );
        
        } else {
        }
    }); 
})

// 查看
$(document).on("click",".cat",function(){
    var $row = $(this).parents("tr");
    var iphone=$row.data("iphone");
    var name=$row.data("name");
    var bornYear=$row.data("born-year");
    var idNum=$row.data("id-num");
    var createTime=$row.data("create-time");
    var comName=$row.data("comname");
    var approveState=$row.data("approve-state");
    var idFrontPic=$row.data("id-front-pic");
    var idBackPic=$row.data("id-back-pic");
    
    var $obj = $("#browseModal").find(".showValue");
    $obj.eq(0).html(iphone)
    $obj.eq(1).html(name)
    $obj.eq(2).html(bornYear)
    $obj.eq(3).html(idNum)
    $obj.eq(4).html(createTime)
    $obj.eq(5).html(comName)
    $obj.eq(6).html(approveState)
    $obj.eq(7).attr("src",idFrontPic)
    $obj.eq(8).attr("src",idBackPic)
    $('#browseModal').modal('toggle')
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
		showCount:10
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
            data-user-name="'+ item.userName +'" \
            data-real-name="'+ item.realName +'" \
            data-gender="'+ item.gender +'" \
            data-born-year="'+ item.bornYear +'" \
            data-com-name="'+ item.comName +'" \
            data-pose-name="'+ item.posName +'" \
            data-re-money="'+ item.reMoney +'" \
            data-part-time="'+ item.partTime +'" \
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
                <button type="button" class="btn btn-primary btn-sm auth">联系</button>\
            </th>\
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
function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}

