// 日期选择器
$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});
// 禁用
$(document).on("click",".queryCompany",function(){
	listParams.comName = $("#comName").val();
	listParams.endTime = $("#endTime").val();
	listParams.startTime = dayToseconds($("#startTime").val());
	fetchList();
})
// 认证
$(document).on("click",".auth",function(){
	var $row = $(this).parents("tr");
	var companyId = $row.data("company-id");
	var data ={};
	data.companyId =companyId ;
	
    swal({
        title: '认证',
        text: '是否通过认证!',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: '通过',
        cancelButtonText: '不通过',
        }).then(function(isConfirm) {
        if (isConfirm === true) {
        	data.approveState = 1 ;
        	postAuth(data);
        	
            swal(
            '认证',
            '认证通过',
            'success'
            );
        
        } else if (isConfirm === false) {
        	data.approveState = 2 ;
        	postAuth(data);
            swal(
            		 '认证',
                     '认证不通过',
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

// 查看
$(document).on("click",".updateCompany",function(){
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
    
    var $obj = $("#updateCompanyModel").find(".showValue");
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
    $('#updateCompanyModel').modal('toggle');
})


$(document).on("click","#openAddCompany",function(){
    var $obj = $("#addCompanyModel").find(".showValue");
    $('#addCompanyModel').modal('toggle');
})

//邢增 企业
$(document).on("click","#newCompany",function(){
    var $obj = $("#addCompanyModel").find(".showValue");
    
    var comName = $("#comName").val();
    var companyTypeId = $("#companyTypeId").val();
    var companyScaleId = $("#companyScaleId").val();
    var comDesc = $("#comDesc").val();
    var countyId = $("#countyId").val();
    var addrDetail = $("#addrDetail").val();
    var comtPerson = $("#comtPerson").val();
    var comPhone = $("#comPhone").val();
    var comEmail = $("#comEmail").val();
    
    var saveParams ={};
    saveParams.comName = comName ;
    saveParams.companyTypeId = companyTypeId ;
    saveParams.companyScaleId = companyScaleId ;
    saveParams.comDesc = comDesc ;
    saveParams.countyId = countyId ;
    saveParams.addrDetail = addrDetail ;
    saveParams.comtPerson = comtPerson ;
    saveParams.comPhone = comPhone ;
    saveParams.comEmail = comEmail ;
    //保存图片
    
//    uploadPic(window.location.origin + "/wxAppletsLogin/imgUpOne");
//    saveParams.upPicLogoUrl =upPicLogoUrl ;
    
    fetchPost({
        url:"/backCompany/newCompany",
        params: saveParams,
        callback:function(data){
            console.log(data);
            fetchList();
            swal(
	                   'Saved!',
	                   '已保存.',
	                   'success'
	           );
        }
    })
   //$('#addCompanyModel').modal('toggle');
})
 
var upPicLogoUrl ;
function uploadPic(url){
	var file =  $("#upPicLogo").get(0).files[0];
	if(!file){
		return ;
	}
	var formData = new FormData();
	formData.append("file",file);
	formData.append("code","user");
	$.ajax({
		url:url,
		dataType:"json",
		type:"post",
		data:formData,
        processData: false,  // 不处理数据
        contentType: false,   // 不设置内容类型
		header:{
			oid:"fad7bd3d01f04950b1d906584afc9253",
		},
		success:function(data){
			console.log("===",data);
			console.log("===",data.data.imgUrl);
			upPicLogoUrl = data.data.imgUrl ;
		}
	});
}

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
function postAuth(data){
    fetchPost({
        url:"/backCompany/companyAuth",
        params: data,
        callback:function(data){
            console.log(data);
            fetchList();
        }
    })
}


function addTableList(list){
    var $table = $("#userList");
    var $tBody = $table.find("tbody");
    var templeteTr="";
    list.forEach(function(item){
        templeteTr+='\
        <tr \
        	data-company-id="'+ item.hpCompanyId +'" \
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
                <button type="button" class="btn btn-primary btn-sm updateCompany">编辑</button>\
            <button type="button" class="btn btn-danger btn-sm  auth">认证</button>\
            </th>\
        </tr>';
                // <button type="button" class="btn btn-danger btn-sm restart">复用</button>\
    })
    $tBody.html(templeteTr)    
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
//判断是否认证
function approveState(value){
    switch (value) {
        case 0:return "未申请认证"
        case 1:return "认证通过"
        case 2:return "认证不通过"
        case 3:return "认证待审核"
    }
}