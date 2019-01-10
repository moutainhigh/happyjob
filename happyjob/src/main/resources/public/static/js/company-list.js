// 日期选择器
$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});
// 查询
$(document).on("click",".queryCompany",function(){
	pageSearch(1);
})

//分页查询
function pageSearch(page){
	listParams.comName = $("#comNameSearch").val();
	listParams.endTime = publicObj.transferTime($("#endTimeSearch").val());
	listParams.startTime = publicObj.transferTime($("#startTimeSearch").val());
	listParams.currentPage = page;
	fetchList();
}

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
    $obj.eq(0).html($row.data("com-name"));
    $obj.eq(1).html($row.data("type-name"));
    $obj.eq(2).html($row.data("scale"));
    $obj.eq(3).html($row.data("com-desc"));
    $obj.eq(5).html($row.data("add-detail"));
    $obj.eq(6).html($row.data("com-person"));
    $obj.eq(7).html($row.data("com-phone"));
   
    $obj.eq(8).html($row.data("com-email"));
//    $obj.eq(7).attr("src",comLogo);
//    $obj.eq(8).attr("src",comLicense);
    $('#browseModal').modal('toggle');
})

// 打开 修改modal
$(document).on("click",".openUpdateModal",function(){
    var $row = $(this).parents("tr");
    var comName = $row.data("com-name");
    var companyTypeId = $row.data("company-type-id");
    var scale = $row.data("scale");
    var scaleId = $row.data("scale-id");
    var comDesc = $row.data("com-desc");
    var addrDetail = $row.data("add-detail");
    var comtPerson = $row.data("com-person");
    var comPhone = $row.data("com-phone");
    var comLogo = $row.data("com-logo");
    var comLicense = $row.data("com-license");
    var comEmail = $row.data("com-email");
    var hpCompanyId = $row.data("company-id");
    
    $("#hpCompanyId2").val(hpCompanyId);
    $("#comName2").val(comName);
    $("#companyTypeId2").val(companyTypeId);
    $("#companyScaleId2").val(scaleId);
    $("#comDesc2").val(comDesc);
//    $("#countyId2").val(countyId);
    $("#addrDetail2").val(addrDetail);
    $("#comtPerson2").val(comtPerson);
    $("#comPhone2").val(comPhone);
    $("#comLicense2").val(comLicense);
    $("#comEmail2").val(comEmail);
    
    $("#comLogo2").attr("src",comLogo);
    $("#comlicens2").attr("src",comLicense);
    
    $('#updateCompanyModal').modal('show');
})

//修改 提交
$(document).on("click","#updateComfirm",function(){
	
	var hpCompanyId = $("#hpCompanyId2").val();
	var comName = $("#comName2").val();
    var companyTypeId = $("#companyTypeId2").val();
    var companyScaleId = $("#companyScaleId2").val();
    var comDesc = $("#comDesc2").val();
    var countyId = $("#countyId2").val();
    var addrDetail = $("#addrDetail2").val();
    var comtPerson = $("#comtPerson2").val();
    var comPhone = $("#comPhone2").val();
    var comEmail = $("#comEmail2").val();
    
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
    saveParams.companyId = hpCompanyId ;
    
    fetchPost({
        url:"/backCompany/updateCompany",
        params: saveParams,
        callback:function(data){
            console.log(data);
            fetchList();
            $('#updateCompanyModal').modal('hide');
            swal(
	                   'Saved!',
	                   '已修改.',
	                   'success'
	           );
        }
    })
   
})


$(document).on("click","#openAddCompany",function(){
    $('#addCompanyModel').modal('toggle');
})

//新增 企业
$(document).on("click","#newCompany",function(){
    var saveParams ={} ;
    saveParams.comName = $("#comName").val();
    saveParams.companyTypeId = $("#companyTypeId").val();
    saveParams.companyScaleId = $("#companyScaleId").val();
    saveParams.comDesc = $("#comDesc").val();
    saveParams.countyId = $("#countyId").val();
    saveParams.addrDetail =$("#addrDetail").val();
    saveParams.comtPerson = $("#comtPerson").val();
    saveParams.comPhone = $("#comPhone").val();
    saveParams.comEmail = $("#comEmail").val();
    
    //保存图片
    saveParams.comLogo = comLogo ;
    saveParams.comLicense = comLicense ;
    
	console.log("=saveParams==",saveParams);
	
    fetchPost({
        url:"/backCompany/newCompany",
        params: saveParams,
        callback:function(data){
            fetchList();
        }
    })
   $('#addCompanyModel').modal('hide');
})
 
var comLogo ;
function uploadLogo(){
	var url = window.location.origin + "/wxAppletsLogin/imgUpOne" ;
	var file = $("#upPicLogo").get(0).files[0];
	if(!file){
		return;
	}
	var formData = new FormData();
	formData.append("file",file);
	formData.append("code","company");
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
			console.log("=data.data.imgUrl==",data.data.imgUrl);
			comLogo = data.data.imgUrl ;
		}
	});
}


var comLicense ;
function upPicLis(){
	var url = window.location.origin + "/wxAppletsLogin/imgUpOne" ;
	var file = $("#upPicLis").get(0).files[0];
	if(!file){
		return;
	}
	var formData = new FormData();
	formData.append("file",file);
	formData.append("code","company");
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
			console.log("==data.data.imgUrl=",data.data.imgUrl);
			comLicense = data.data.imgUrl ;
		}
	});
}



var listParams = {
	comName:"",
    startTime:"",
    endTime:"",
    currentPage:1,
    showCount:5
}
var list= [];
var totalPage=1;

fetchList();
$(function(){
	positionConfig();
	$('select[data-type="area"]').change(function(){ // 地区选择
		areaConfig($(this).attr("id"),$(this).val()); // 地区
	});
})
function positionConfig(){
	areaConfig(null,null); // 地区
}
function areaConfig(areaType,areaId){
	var provinceId = null;
	var cityId = null;
	if(areaType == "province"){ // 省查询市
		provinceId = areaId;
		$("#county").html('<option>请选择</option>');
	}else if(areaType == "city"){ // 市查询区县
		cityId = areaId;
	}else if(areaType == "county"){
		return;
	}
	fetchGet({
		url:apiData.area,
		params:{
			provinceId:provinceId,
			cityId:cityId,
		},
		callback:function(data){
			if(data){
				var content = '<option>请选择</option>';
				var list = data.list;
				var length = list.length;
				for(var i=0;i<length;i++){
					content += '<option value="'+list[i].areaId+'" >'+list[i].areaName+'</option>';
				}
				if(content !=''){
					if(areaType == "province"){ // 省查询市
						$("#city").html(content);
					}else if(areaType == "city"){ // 市查询区县
						cityId = areaId;
						$("#county").html(content);
					}else if(areaType == "county"){
						return;
					}else{
						$("#province").html(content);
					}
					
				}
			}
		}
	});
}
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
            publicObj.pageShow(data.page,pageSearch);
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
            data-company-type-id="'+ item.hpCompanyTypeId +'" \
            data-type-name="'+ item.typeName +'" \
            data-scale="'+ item.lowerNum+"-"+item.hightNum +'" \
            data-scale-id="'+ item.hpCompanyScaleId +'" \
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
            <th>'+ isNull(item.comtPerson) +'</th>\
            <th>'+ isNull(item.comPhone) +'</th>\
            <th>'+ isNull(item.comEmail) +'</th>\
            <th>'+ approveState(item.approveState) +'</th>\
            <th>'+ timestampToTime(item.createTime) +'</th>\
            <th>\
                <button type="button" class="btn btn-default btn-sm cat">查看</button>\
                <button type="button" class="btn btn-primary btn-sm openUpdateModal">编辑</button>\
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

