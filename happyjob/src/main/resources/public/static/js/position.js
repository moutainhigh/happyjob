var positionData = {
  "applyTime": null,
  "carDesc": "",
  "carOn": null,
  "comCustPhone": "",
  "countyId": null,
  "endTime": null,
  "fiveMoney": 0,
  "groupOn": 0,
  "hotOn": 0,
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
  "posNature": 0,
  "posNum": 0,
  "posPerson": "",
  "posPhone": "",
  "posState": 0,
  "posWorkYear": "",
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
	$("#btnSub").click(formSub());
})

function formSub(){
	console.log("here is formSub");
}

function positionConfig(){
	
	console.log("here is positionConfig");
}
function companyConfig(){
	fetchPost({
		url:
	});
}