// 日期选择器
$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});
// 禁用
$(document).on("click",".queryCompany",function(){
	listParams.comName = $("#comName").val();
//	listParams.endTime = $("#endTime").val();
//	listParams.startTime = dayToseconds($("#startTime").val());
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
            // Esc, close button or outside click
            // isConfirm is undefined
        }
    }); 
})
// 复用
$(document).on("click",".restart",function(){
    swal({
        title: '是否对该用户复用？',
        text: '',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: '是',
        cancelButtonText: '否',
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
            // Esc, close button or outside click
            // isConfirm is undefined
        }
    }); 
})
// 查看
$(document).on("click",".cat",function(){
    var $row = $(this).parents("tr");
    var comName = $row.data("com-name");
    var typeName = $row.data("type-name");
    var scale = $row.data("scale");
    var comDesc = $row.data("com-desc");
    var addrDetail = $row.data("add-detail");
    var comtPerson = $row.data("com-person");
    var comPhone = $row.data("com-phone");
    var comLogo = $row.data("com-logo");
    var comLicense = $row.data("com-license");
    var comEmail = $row.data("com-email");
    
    var $obj = $("#browseModal").find(".showValue");
    $obj.eq(0).html(comName);
    $obj.eq(1).html(typeName);
    $obj.eq(2).html(scale);
    $obj.eq(3).html(comDesc);
    $obj.eq(5).html(addrDetail);
    $obj.eq(6).html(comtPerson);
    $obj.eq(7).html(comPhone);
   
    $obj.eq(8).html(comEmail);
//    $obj.eq(7).attr("src",comLogo);
//    $obj.eq(8).attr("src",comLicense);
    $('#browseModal').modal('toggle');
})


var listParams = {
	comName:"",
    startTime:"",
    endTime:"",
    currentPage:1,
    showCount:10
}
var list= [];
var totalPage=1;

fetchList();

// 获取table数据
function fetchList(){
    fetchGet({
        url:"/backCompany/companyList",
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
        url:"/backCom/userInfoUp",
        params: data,
        callback:function(data){
            console.log(data)
        }
    })
}

////企业id
//@ApiModelProperty(name="hpCompanyId",value="企业id")
//private java.lang.Long hpCompanyId;
////公司名称
//@ApiModelProperty(name="comName",value="公司名称")
//private String comName;
////公司描述
//@ApiModelProperty(name="comDesc",value="公司描述")
//private String comDesc;
////区ID
//@ApiModelProperty(name="countyId",value="区ID")
//private java.lang.Long countyId;
////公司行业类型表id
//@ApiModelProperty(name="hpCompanyTypeId",value="公司行业类型表id")
//private java.lang.Long hpCompanyTypeId;
////公司规模表id
//@ApiModelProperty(name="hpCompanyScaleId",value="公司规模表id")
//private java.lang.Long hpCompanyScaleId;
////详细地址
//@ApiModelProperty(name="addrDetail",value="详细地址")
//private String addrDetail;
////联系人
//@ApiModelProperty(name="comtPerson",value="联系人")
//private String comtPerson;
////联系电话
//@ApiModelProperty(name="comPhone",value="联系电话")
//private String comPhone;
////联系邮箱
//@ApiModelProperty(name="comEmail",value="联系邮箱")
//private String comEmail;
////公司logo
//@ApiModelProperty(name="comLogo",value="公司logo")
//private String comLogo;
////公司营业执照
//@ApiModelProperty(name="comLicense",value="公司营业执照")
//private String comLicense;
////添加时间
//@ApiModelProperty(name="createTime",value="添加时间")
//private java.lang.Long createTime;
////认证状态（0、未认证，1、已认证）
//@ApiModelProperty(name="approveState",value="认证状态（0、未认证，1、已认证）")
//private java.lang.Integer approveState;
// 添加table数据
function addTableList(list){
    var $table = $("#userList");
    var $tBody = $table.find("tbody");
    var templeteTr="";
    list.forEach(function(item){
        templeteTr+='\
        <tr \
            data-com-name="'+ item.comName +'" \
            data-type-name="'+ item.typeName +'" \
            data-scale="'+ item.lowerNum+"-"+item.hightNum +'" \
            data-com-desc="'+ item.comDesc +'" \
            data-add-detail="'+ item.addrDetail +'" \
            data-com-person="'+ item.comtPerson +'" \
            data-com-phone="'+ item.comPhone +'" \
            data-com-email="'+ item.comEmail +'" \
            data-com-logo="'+ item.comLogo +'" \
            data-com-license="'+ item.comLicense +'" >\
            <th>'+ item.comName +'</th>\
            <th>'+ item.typeName +'</th>\
            <th>'+ "没有字段" +'</th>\
            <th>'+ item.lowerNum+"-"+item.hightNum +'</th>\
            <th>'+ item.comtPerson +'</th>\
            <th>'+ item.comPhone +'</th>\
            <th>'+ item.comEmail +'</th>\
            <th>'+ approveState(item.approveState) +'</th>\
            <th>'+ timestampToTime(item.createTime) +'</th>\
            <th>\
                <button type="button" class="btn btn-default btn-sm cat">查看</button>\
                <button type="button" class="btn btn-primary btn-sm auth">编辑</button>\
            <button type="button" class="btn btn-danger btn-sm updateCompany">认证</button>\
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
function dayToSeconds(timestamp){
	 //var startDate ='2018-07-09 14:13:11';
     var startDate= timestamp.replace(new RegExp("-","gm"),"/");
     var startDateM = (new Date(startDate)).getTime(); //得到毫秒数
}
function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}
// 判断途径
function registResource(value){
    switch (value) {
        case 1:return "APP"
        case 2:return "小程序"
        case 3:return "微信"
        case 4:return "门店"
        case 5:return "邀请注册"
    }
}
//判断是否认证
function approveState(value){
    switch (value) {
        case 0:return "未申请认证"
        case 1:return "认证通过"
        case 2:return "认证不通过"
        case 3:return "认证待审核"
    }
}