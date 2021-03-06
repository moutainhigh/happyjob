// 日期选择器
$(".datepicker").datepicker({
    language: "zh-CN",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});
var posDetailDef = '<p>基本工资：</p><p>薪资结构：</p><p>综合工资：</p><p>发工资日：</p><p>工作时间：</p><p>工作环境：</p>';
var otherWelfareDef = '<p style="white-space: normal;">工&nbsp; 作&nbsp; 餐：</p><p style="white-space: normal;">住&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;宿：</p><p style="white-space: normal;">社&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保：<br/></p><p style="white-space: normal;">其他福利：</p>';
var _curUrl = window.location.href;
var hpPositionId = null;
//详情
var welfareDetailUe = UE.getEditor('welfareDetailEditor');
var posDetailUe = UE.getEditor('posDetailEditor');
var otherWelfareUe = UE.getEditor('otherWelfareEditor');
var posComDescUe = UE.getEditor('posComDescEditor');
var carDescUe = UE.getEditor('carDescEditor');
var positionData = {
  "applyTime": null,
  "carDesc": "",
  "carOn": 0,
  "comCustPhone": "",
  "countyId": null,
  "endTime": null,
  "fiveMoney": 0,
  "groupOn": 0,
  "hotOn": null,
  "hpCompanyId": null,
  "hpEducationId": null,
  "hpPositionId": null,
  "hpPositionOfferId": null,
  "hpPositionSalaryId": null,
  "hpPositionTypeId": null,
  "jobHours": "",
  "manDayNum": 0,
  "otherWelfare": "",
  "posComDesc": "",
  "posDetail": "",
  "posEmail": "",
  "posName": "",
  "posNature": 1,
  "posNum": 0,
  "posPerson": "",
  "posPhone": "",
  "posState": null,
//  "posWorkYear": "",
  "reqAge": "",
  "reqEducation": "",
  "reqExp": "",
  "reqGender": "",
  "reqOther": "",
  "reqSkill": "",
  "reqWorkYears": "",
  "retManMoney": 0,
  "retOn": 0,
  "retWomanMoney": 0,
  "startTime": 0,
  "threeMoney": 0,
  "urgentMoney": 0,
  "urgentOn": 0,
  "welfareArr": "",
  "welfareDetail": "",
  "welfareOn": 0,
  "womenDayNum": 0
}

$(function(){
	positionConfig();
	hpPositionId = publicObj.getParams(_curUrl,"hpPositionId");
	if(hpPositionId){ // 编辑
		editorPosition();
	}else{
		posDetailUe.ready(function(){
			UE.getEditor('posDetailEditor').execCommand('insertHtml',posDetailDef);
		});
		otherWelfareUe.ready(function(){
			UE.getEditor('otherWelfareEditor').execCommand('insertHtml',otherWelfareDef);
		});
	}
	$("#btnSub").click(function(){
		formSub();
	});
	
	$("#openWelfare").click(function(){ // 福利弹出框
		$("#bm_welfare").modal('show');
	});
	$("#openPosType").click(function(){ // 行业类型弹出框
		$("#bm_posType").modal('show');
	});
	
	$('select[data-type="area"]').change(function(){ // 地区选择
		areaConfig($(this).attr("id"),$(this).val()); // 地区
	});
	$('#urgentOn').change(function(){ // 高薪急聘选择
		if($(this).val()==1){
			$("#groupOn").val(0).change();;
			$("#welfareOn").val(0).change();;
			$("#urgentMoney").removeAttr("disabled");
		}else{
			$("#urgentMoney").attr("disabled",true);
		}
	});
	$('#groupOn').change(function(){ // 拼团选择
		if($(this).val()==1){
			$("#urgentOn").val(0).change();;
			$("#welfareOn").val(0).change();;
			$("#threeMoney").removeAttr("disabled");
			$("#fiveMoney").removeAttr("disabled");
		}else{
			$("#threeMoney").attr("disabled",true);
			$("#fiveMoney").attr("disabled",true);
		}
	});
	$('#welfareOn').change(function(){ // 拼团选择
		if($(this).val()==1){
			$("#urgentOn").val(0).change();
			$("#groupOn").val(0).change();;
			$("#welfareDetailEditor").show();
		}else{
			$("#welfareDetailEditor").hide();
		}
	});
	$('#carOn').change(function(){ // 拼团选择
		if($(this).val()==1){
			$("#carDescItem").show();
		}else{
			$("#carDescItem").hide();
		}
	});
})

$(document).on("change",'input[name="hpPositionWelfareId"]',function(){  // 福利选项点击事假
	var $this = $(this);
	if($this.prop("checked")){
		var content = '<div data-id="'+$this.val()+'" class="showValue col-sm-3 col-sm-offset-1">'+$this.next().html()+'</div>';
		var fuli = '<label class="col-sm-1 showValue" data-id='+$this.val() +'>'+$this.next().html()+'</label>';
		$("#welfareChoose").append(content);
		if($this.next().html() == "入职返现"){
			$("#retItem").show();
		}
		$("#fuli").append(fuli);
	}else{
		$("#welfareChoose").find('.showValue[data-id="'+$this.val()+'"]').remove();
		if($this.next().html() == "入职返现"){
			$("#retItem").hide();
		}
		$("#fuli").find('.showValue[data-id="'+$this.val()+'"]').remove();
	}
})

$(document).on("click",'*[data-type="posType"]',function(){
	var $this = $(this);
	$("#hpPositionTypeId").val($this.data("id"));
	$("#posTypeOn").html($this.html());
	
	$("#hpPositionTypeName").val($this.html());
})

function formSub(){ // 提交验证
	console.log("here is formSub");
	var posName = $("#posName").val();
	if(!posName || publicObj.spePatt.test(posName)){
		swal('字段值类型错误', '职位名称不能包含特殊字符', 'error');
		return;
	}
	var comName = $("#comName").val();
	var comId = $("#comList").find('option[value="'+comName+'"]').data("id");
	if(!comId){
		swal('字段值类型错误', '要填写已存在的公司名称', 'error');
		return;
	}
	var manDayNum = $("#manDayNum").val();
	var retManMoney = $("#retManMoney").val();
	if(!retManMoney){
		retManMoney = 0;
	}
	var womenDayNum = $("#womenDayNum").val();
	var retWomanMoney = $("#retWomanMoney").val();
	if(!retWomanMoney){
		retWomanMoney = 0;
	}
	var welFareIds = "";
	var retOn = 0;
	$('input[name="hpPositionWelfareId"]:checked').each(function(){
		welFareIds += $(this).val()+",";
		if($(this).val() == 2){
			retOn = 1;
		}
	});
	if(retOn != 1){
		manDayNum = 0;
		retManMoney = 0;
		womenDayNum = 0;
		retWomanMoney = 0;
	}
	if(welFareIds != ""){
		welFareIds = welFareIds.substring(0,welFareIds.length-1);
	}
	var urgentOn = $("#urgentOn").val();
	var urgentMoney = $("#urgentMoney").val();
	if(!urgentMoney){
		urgentMoney = 0;
	}
	if(urgentOn == 1 && urgentMoney <=0){
		swal('字段值错误', '开启高薪急聘需要填写平台补贴金额', 'error');
		return;
	}
	var groupOn = $("#groupOn").val();
	var threeMoney = $("#threeMoney").val();
	var fiveMoney = $("#fiveMoney").val();
	if(groupOn != 1){
		threeMoney = 0;
		fiveMoney = 0;
	}else if(!threeMoney || !fiveMoney || threeMoney==0 || fiveMoney==0) {
		swal('字段值类型错误', '开启拼团后拼团奖励必填', 'error');
		return;
	}
	
	var welfareOn = $("#welfareOn").val();
	var welfareDetail = UE.getEditor('welfareDetailEditor').getContent();
	welfareDetail = publicObj.ueditorFormat(welfareDetail);
	
	var jobHours = $("#jobHours").val();
	var hpPositionOfferId = $("#hpPositionOfferId").val();
	if(!hpPositionOfferId){
		swal('字段缺失', '招聘形式必填', 'error');
		return;
	}
	var comCustPhone = $("#comCustPhone").val();
	
	var hpPositionTypeId = $("#hpPositionTypeId").val();
	
	var posDetail = UE.getEditor('posDetailEditor').getContent();
	posDetail = publicObj.ueditorFormat(posDetail);
	var reqGender = $("#reqGender").val();
	var reqAge = $("#reqAge").val();
	var reqEducation = $("#reqEducation").val();
	var reqSkill = $("#reqSkill").val();
	var reqExp = $("#reqExp").val();
	var reqWorkYears = $("#reqWorkYears").val();
	var reqOther = $("#reqOther").val();
	
	var otherWelfare = UE.getEditor('otherWelfareEditor').getContent();
	otherWelfare = publicObj.ueditorFormat(otherWelfare);
	var carOn = $("#carOn").val();
	if(!carOn){
		swal('字段缺失', '是否有班车必填', 'error');
		return;
	}
	var carDesc = UE.getEditor('carDescEditor').getContent();
	carDesc = publicObj.ueditorFormat(carDesc);
	var posComDesc = UE.getEditor('posComDescEditor').getContent();
	posComDesc = publicObj.ueditorFormat(posComDesc);
	var posNature = $('input[name="posNature"]:checked').val();
	
	var hpPositionSalaryId = $('#hpPositionSalaryId').val();
	if(!hpPositionSalaryId){
		swal('字段缺失', '职位月薪必填', 'error');
		return;
	}
//	var posWorkYear = $('#posWorkYear').val();
//	if(!posWorkYear){
//		swal('字段缺失', '工作经验', 'error');
//		return;
//	}
	var startTime = publicObj.transferTime($("#startTime").val());
	var endTime = publicObj.transferTime($("#endTime").val());
	if(startTime == 0){
		swal('字段缺失', '职位开始时间必填', 'error');
		return;
	}
	if(endTime == 0){
		swal('字段缺失', '职位结束时间必填', 'error');
		return;
	}
	
	var posNum = $('#posNum').val();
	if(!posNum){
		posNum == 0;
	}
	var county = $('#county').val();
	if(!county){
		swal('字段缺失', '工作地点必须选定到区县级', 'error');
		return;
	}
	var hpEducationId = $('#hpEducationId').val();
	var posPerson = $('#posPerson').val();
	var posPhone = $('#posPhone').val();
	var posEmail = $('#posEmail').val();
	
	positionData.posName = posName;
	positionData.comName = comName;
	positionData.hpCompanyId = comId;
	positionData.manDayNum = manDayNum;
	positionData.retManMoney = retManMoney;
	positionData.womenDayNum = womenDayNum;
	positionData.retWomanMoney = retWomanMoney;
	positionData.urgentOn = urgentOn;
	positionData.groupOn = groupOn;
	positionData.threeMoney = threeMoney;
	positionData.fiveMoney = fiveMoney;
	positionData.welfareOn = welfareOn;
	positionData.welfareDetail = welfareDetail;
	positionData.jobHours = jobHours;
	positionData.hpPositionTypeId = hpPositionTypeId;
	positionData.comCustPhone = comCustPhone;
	positionData.posDetail = posDetail;
	positionData.reqGender = reqGender;
	positionData.reqEducation = reqEducation;
	positionData.reqSkill = reqSkill;
	positionData.reqWorkYears = reqWorkYears;
	positionData.reqOther = reqOther;
	positionData.reqAge = reqAge;
	positionData.reqExp = reqExp;
	positionData.otherWelfare = otherWelfare;
	positionData.carOn = carOn;
	positionData.carDesc = carDesc;
	positionData.posComDesc = posComDesc;
	positionData.hpPositionSalaryId = hpPositionSalaryId;
//	positionData.posWorkYear = posWorkYear;
	positionData.startTime = startTime;
	positionData.endTime = endTime;
	positionData.posNum = posNum;
	positionData.county = county;
	positionData.hpEducationId = hpEducationId;
	positionData.posPerson = posPerson;
	positionData.posPhone = posPhone;
	positionData.posEmail = posEmail;
	positionData.countyId = county;
	positionData.hpPositionOfferId = hpPositionOfferId;
	positionData.retOn = retOn;
	positionData.urgentMoney = urgentMoney;
	positionData.welfareArr = welFareIds;
	positionData.posNature = posNature;
	positionData.hpPositionId = publicObj.getParams(_curUrl,"hpPositionId");
	
	fetchPostBody({
		url:apiData.positionAdd,
		params:positionData,
		callback:function(data){
			swal('请求完成', data.message, 'success');
		}
	});
}

function positionConfig(){
	companyConfig(); // 公司选项
	offerConfig(); // 招聘形式 
	welfareConfig(); // 招聘形式 
	posTypeConfig(); // 职位行业
	salaryConfig(); // 月薪
	areaConfig(null,null); // 地区
	eduConfig(); // 学历选项
	console.log("here is positionConfig");
}
function companyConfig(){
	fetchGet({
		url:apiData.posCompanyList,
		params:{
		},
		callback:function(data){
			if(data){
				var content = '';
				var list = data.list;
				var length = list.length;
				for(var i=0;i<length;i++){
					content += '<option value="'+list[i].comName+'" data-id="'+list[i].hpCompanyId+'" >'+list[i].comName+'</option>'
				}
				if(content !=''){
					$("#comList").html(content);
				}
			}
		}
	});
}

function offerConfig(){
	fetchGet({
		url:apiData.posOfferList,
		params:{
		},
		callback:function(data){
			if(data){
				var content = '';
				var list = data.list;
				var length = list.length;
				for(var i=0;i<length;i++){
					content += '<option value="'+list[i].hpPositionOfferId+'" >'+list[i].typeName+'</option>'
				}
				if(content !=''){
					$("#hpPositionOfferId").append(content);
				}
			}
		}
	});
}

function welfareConfig(){
	fetchGet({
		url:apiData.posWelfare,
		params:{
		},
		callback:function(data){
			if(data){
				var content = '';
				var list = data.list;
				var length = list.length;
				for(var i=0;i<length;i++){
					content += '<label class="col-sm-3 col-sm-offset-1" align="left" >'+
						'<input name="hpPositionWelfareId" type="checkbox" value='+list[i].hpPositionWelfareId+' >'+
						'<i>'+list[i].welfareName+'</i></label>';
				}
				if(content !=''){
					$("#welfareBox").html(content);
				}
			}
		}
	});
}
//原来的显示 福利
function welfareConfig2(){
	fetchGet({
		url:apiData.posWelfare,
		params:{
		},
		callback:function(data){
			if(data){
				var content = '';
				var list = data.list;
				var length = list.length;
				for(var i=0;i<length;i++){
					content += '<div class="form-group col-sm-4"><label>'+
						'<input name="hpPositionWelfareId" type="checkbox" value='+list[i].hpPositionWelfareId+' >'+
						'<i>'+list[i].welfareName+'</i></label></div>';
				}
				if(content !=''){
					$("#welfareBox").html(content);
				}
			}
		}
	});
}
function posTypeConfig(){
	fetchGet({
		url:apiData.posTypeList,
		params:{
		},
		callback:function(data){
			if(data){
				var list = data.list;
				var length = list.length;
				var content ='';
				var parentNum = 0;
				for(var i=0;i<length;i++){
					
					if(!list[i].parentId){ // 父类
						++parentNum  ;
						if( parentNum%2 ==1){
							content  += '<div class="form-group" style="height:40px;"><label class="col-sm-3" align="center">'+list[i].typeName+ '</label>';
						}else{
							content  += '<div class="form-group" style=" height:40px;background:#BCD2EE"  ><label class="col-sm-3" align="center">'+list[i].typeName+ '</label>';
						}	
						
						for(var j=0;j<length;j++){
							if(list[i].hpPositionTypeId == list[j].parentId){
								content += '<div  class="col-sm-3" >';
								content +='<font data-type="posType" size="2" class="fontCol" data-id="'+list[j].hpPositionTypeId+'" >'+list[j].typeName+'</font></div>';
							}
						}
						
						content += '</div>';
					}
				}
				if(content !=''){
					$("#posTypeBox").html(content);
				}
			}
		}
	});
}


function salaryConfig(){
	fetchGet({
		url:apiData.posSalary,
		params:{
		},
		callback:function(data){
			if(data){
				var content = '';
				var list = data.list;
				var length = list.length;
				for(var i=0;i<length;i++){
					var name = list[i].lowerNum==0?(list[i].hightNum+"元/月以下"):list[i].hightNum==0?(list[i].lowerNum+"元/月以上"):(list[i].lowerNum+"-"+list[i].hightNum+"元/月");
					content += '<option value="'+list[i].hpPositionSalaryId+'">'+name+'</option>';
				}
				if(content !=''){
					$("#hpPositionSalaryId").append(content);
				}
			}
		}
	});
}

function areaConfig(areaType,areaId){
	var provinceId = null;
	var cityId = null;
	if(areaType == "province"){ // 省查询市
		provinceId = areaId;
		$("#county").html('<option value="">全部</option>');
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
				var content = '<option value="">全部</option>';
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

function eduConfig(){
	fetchGet({
		url:apiData.eduList,
		params:{
		},
		callback:function(data){
			if(data){
				var content = '';
				var list = data.list;
				var length = list.length;
				for(var i=0;i<length;i++){
					content += '<option value="'+list[i].hpEducationId+'" >'+list[i].eduName+'</option>';
				}
				if(content !=''){
					$("#hpEducationId").append(content);
				}
			}
		}
	});
}

function editorPosition(){
	fetchGet({
		url:apiData.positionEditor,
		params:{
			hpPositionId:hpPositionId,
		},
		callback:function(data){
			var positionData = data.data;
			if(!positionData){
				swal('参数错误', '要查询的岗位信息不存在', 'error');
				return;
			}
			$("#posName").val(positionData.posName);
			$("#comName").val(positionData.comName);
			$("#manDayNum").val(positionData.manDayNum);
			$("#retManMoney").val(positionData.retManMoney);
			$("#womenDayNum").val(positionData.womenDayNum);
			$("#retWomanMoney").val(positionData.retWomanMoney);
			var welFareIds = positionData.welfareArr;
			if(welFareIds){
				var welFareIdArr = welFareIds.split(",");
				$('input[name="hpPositionWelfareId"]').each(function(){
					for(var i=0;i<welFareIdArr.length;i++){
						if($(this).val() == welFareIdArr[i]){
							$(this).click();
							if($(this).val() == 2){
								$("#retItem").show();
							}
						}
					}
				});
			}
			$("#urgentOn").val(positionData.urgentOn);
			$("#urgentMoney").val(positionData.urgentMoney);
			if(positionData.urgentOn == 1){
				$("#urgentMoney").removeAttr("disabled");
			}
			$("#groupOn").val(positionData.groupOn);
			$("#threeMoney").val(positionData.threeMoney);
			$("#fiveMoney").val(positionData.fiveMoney);
			if(positionData.groupOn == 1){
				$("#threeMoney").removeAttr("disabled");
				$("#fiveMoney").removeAttr("disabled");
			}
			$("#welfareOn").val(positionData.welfareOn);
			if(positionData.welfareOn != 1){
				$('#welfareDetailEditor').hide();
			}
			welfareDetailUe.ready(function(){
				if(positionData.welfareDetail){
					UE.getEditor('welfareDetailEditor').execCommand('insertHtml',positionData.welfareDetail);
				}
			});
			
			$("#jobHours").val(positionData.jobHours);
			$("#hpPositionOfferId").val(positionData.hpPositionOfferId); // 下拉框
			$("#comCustPhone").val(positionData.comCustPhone);
			
			$("#hpPositionTypeId").val(positionData.hpPositionTypeId); // 选择框
			$('*[data-type="posType"][data-id="'+positionData.hpPositionTypeId+'"]').click();
			
			posDetailUe.ready(function(){
    			if(positionData.posDetail){
    				UE.getEditor('posDetailEditor').execCommand('insertHtml',positionData.posDetail);
    			}else{
    				UE.getEditor('posDetailEditor').execCommand('insertHtml',posDetailDef);
    			}
	    	});
			$("#reqGender").val(positionData.reqGender);
			$("#reqAge").val(positionData.reqAge);
			$("#reqEducation").val(positionData.reqEducation);
			$("#reqSkill").val(positionData.reqSkill);
			$("#reqExp").val(positionData.reqExp);
			$("#reqWorkYears").val(positionData.reqWorkYears);
			$("#reqOther").val(positionData.reqOther);
			
			otherWelfareUe.ready(function(){
    			if(positionData.otherWelfare){
    				UE.getEditor('otherWelfareEditor').execCommand('insertHtml',positionData.otherWelfare);
    			}else{
    				UE.getEditor('otherWelfareEditor').execCommand('insertHtml',otherWelfareDef);
    			}
	    	});
			$("#carOn").val(positionData.carOn); // 下拉框
			if(positionData.carOn != 1){
				$('#carDescItem').hide();
			}
			carDescUe.ready(function(){
    			if(positionData.posComDesc){
    				UE.getEditor('carDescEditor').execCommand('insertHtml',positionData.carDesc);
    			}
	    	});
			posComDescUe.ready(function(){
    			if(positionData.posComDesc){
    				UE.getEditor('posComDescEditor').execCommand('insertHtml',positionData.posComDesc);
    			}
	    	});
			$('input[name="posNature"][value="'+positionData.posNature+'"]').prop("checked",true);
			
			$('#hpPositionSalaryId').val(positionData.hpPositionSalaryId); // 下拉框
//			$('#posWorkYear').val(positionData.posWorkYear);
			
			$("#startTime").val(publicObj.dateFormat(publicObj.secondToDate(positionData.startTime),dateStrData.d1));
			$("#endTime").val(publicObj.dateFormat(publicObj.secondToDate(positionData.endTime),dateStrData.d1));
			
			$('#posNum').val(positionData.posNum);
			
			$("#province").val(positionData.provinceId);
			$("#city").append('<option value="'+positionData.cityId+'" selected >'+positionData.cityName+'</option>');
			$("#county").append('<option value="'+positionData.countyId+'" selected >'+positionData.countyName+'</option>');
			
			$('#hpEducationId').val(positionData.hpEducationId); // 下拉框
			$('#posPerson').val(positionData.posPerson);
			$('#posPhone').val(positionData.posPhone);
			$('#posEmail').val(positionData.posEmail);
		}
	});
}