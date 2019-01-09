var BASE_URL = window.location.origin;

function fetchGet(options){
    $.get( BASE_URL+ options.url,options.params,function(data){
        console.log(data)
        if(data.errorCode==0){
            options.callback && options.callback(data)
        }else{
        	console.log(JSON.stringify(data));
//            swal('请求失败', data.message, 'error');
        }
    })
}

function fetchPost(options){
    $.post( BASE_URL+ options.url,options.params,function(data){
        console.log(data)
        if(data.errorCode==0){
            options.callback && options.callback(data)
        }else{
        	console.log(JSON.stringify(data));
//            swal('请求失败', data.message, 'error');
        }
    })
}

function fetchPostBody(options){
	$.ajax({
		url:BASE_URL+ options.url,
		type:"post",
		data:JSON.stringify(options.params),
		headers:{
			'contentType': 'application/json',
		},
		success:function(data){
	        console.log(data)
	        if(data.errorCode==0){
	            options.callback && options.callback(data)
	        }else{
		            swal('请求失败', data.message, 'error');
	        }
		},
		error:function(data){
			swal('请求失败', data.message, 'error');
		}
	})
}

var publicObj = {
	"basePath":BASE_URL, // 请求域名，端口号
	"dateFormat": function dateFormat(date,fmt) { // 时间格式化
		if(!date){
			return "";
		}
		var o = {
			"M+": date.getMonth() + 1, //月份 
			"d+": date.getDate(), //日 
			"H+": date.getHours(), //小时 
			"m+": date.getMinutes(), //分 
			"s+": date.getSeconds(), //秒 
			"q+": Math.floor((date.getMonth() + 3) / 3), //季度 
			"S": date.getMilliseconds() //毫秒 
		};
		if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
		for (var k in o)
			if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	},
	"secondToDate":function timestampToTime(timestamp) {
		if(!timestamp){
			return '';
		}
    	timestamp += '';
		if(timestamp.length == 10){
			timestamp = Number(timestamp)*1000;
		}else{
			timestamp = Number(timestamp);
		}
		//时间戳为10位需*1000，时间戳为13位的话不需乘1000

        return new Date(timestamp);;
	},
	"getParams":function getUrlParam(url, name) {
		var pattern = new RegExp("[?&]" + name + "\=([^&]+)", "g");
		var matcher = pattern.exec(url);
		var items = null;
		if (null != matcher) {
			try {
				items = decodeURIComponent(decodeURIComponent(matcher[1]));
			} catch (e) {
				try {
					items = decodeURIComponent(matcher[1]);
				} catch (e) {
					items = matcher[1];
				}
			}
		}
		return items;
	},
	"transferTime":function transferTime(dateStr){//转换时间格式字符串到时间戳
		if(!dateStr){
			return  0;
		}else{
			return  new Date(dateStr).getTime()/1000;
		}
	},
}

var routingData = {
	positionList:function(posName,comName,startTime,endTime,posState,currentPage,showCount){
		url = "/static/adminData/positionList.html";
		params = "posName=${p1}&comName=${p2}&startTime=${p3}&endTime=${p4}&posState=${p5}&currentPage=${p6}&showCount=${p7}";
		return BASE_URL + url +"?" + params.replace("${p1}",posName).replace("${p2}",comName).replace("${p3}",startTime).replace("${p4}",endTime)
		.replace("${p5}",posState).replace("${p6}",currentPage).replace("${p7}",showCount);
	},
	positionAdd:"/static/adminData/positionAdd.html",
}

var apiData = {
	positionList:"/backPosition/positionList",
	positionAdd:"/backPosition/position",
	positionHotOn:"/backPosition/positionHotOn",
	posCompanyList:"/backPosition/posCompanyList",
	posOfferList:"/backPosition/posOfferList",
	posTypeList:"/backPosition/posTypeList",
	posWelfare:"/backPosition/posWelfare",
	posSalary:"/backPosition/posSalary",
	eduList:"/backPosition/eduList",
	area:"/backPosition/area",
}

var dateStrData = {
	d1:"yyyy-MM-dd HH:mm:ss",
	d2:"yyyy-MM-dd",
	d3:"HH:mm:ss",
}


function isNull(data){
	if(data == null || data =="null" ){
		return "";
	}
	return data ;
}