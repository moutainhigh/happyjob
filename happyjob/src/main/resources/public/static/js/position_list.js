// 日期选择器
$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});
var curUrl = window.location.href;

var listParams = {
		posName:"",
		comName:"",
		startTime:"",
		endTime:"",
		posSate:0,
		currentPage:1,
		showCount:5,
}
var list= [];
var totalPage=1;

fetchParamsList();
$(document).on("click",".queryButton",function(){
	
	pageSearch(1);
})
// 分页查询
function pageSearch(page){
	var url = routingData.positionList($("#posName").val(),$("#comName").val(),publicObj.transferTime($("#startTime").val()),
			publicObj.transferTime($("#endTime").val()),$("#posState").val(),page,listParams.showCount);
	window.location.href = url;
}

// 设为热门-->取消热门
$(document).on("click","#hotOn",function(){
	 var $this = $(this);
	 var $row = $this.parents("tr:first");
	 var hotOn = $row.data("hot");
	 var hpPositionId = $row.data("id");
	 hotOn = hotOn==1?0:1;
	 fetchPost({
		url:apiData.positionHotOn,
		params:{"hpPositionId":hpPositionId,"hotOn":hotOn},
		callback:function(data){
			$row.data("hot",hotOn);
			$this.html(showHotOn(hotOn));
		}
	})    
})

// 获取url数据，填充页面查询数据
function fetchParamsList(){
	$("#posName").val(publicObj.getParams(curUrl,"posName"));
	$("#comName").val(publicObj.getParams(curUrl,"comName"));
	if(publicObj.getParams(curUrl,"startTime")){
		if(publicObj.getParams(curUrl,"startTime") >0){
			$("#startTime").val(posDateFormat(publicObj.getParams(curUrl,"startTime")));
		}
	}
	if(publicObj.getParams(curUrl,"endTime")){
		if(publicObj.getParams(curUrl,"endTime")>0){
			$("#endTime").val(posDateFormat(publicObj.getParams(curUrl,"endTime")));
		}
	}
	console.log(publicObj.getParams(curUrl,"posState"));
	$("#posState").find('option[value="'+publicObj.getParams(curUrl,"posState")+'"]').attr("selected","selected");
	listParams.currentPage = publicObj.getParams(curUrl,"currentPage");
	fetchList();
}
// 获取table数据
function fetchList(){
	listParams.posName = $("#posName").val();
	listParams.comName = $("#comName").val();
	listParams.startTime = publicObj.transferTime($("#startTime").val());
	listParams.endTime = publicObj.transferTime($("#endTime").val());
	listParams.posSate = $("#posSate").val();
	
	fetchGet({
		url:apiData.positionList,
		params:listParams,
		callback:function(data){
			list = data.list;
			listParams.currentPage = data.page.currentPage;
			totalPage= data.page.totalPage;
			addTableList(list);
			pageShow(data.page);
		}
	})    
}


// 添加table数据
function addTableList(list){
    var $table = $("#listTable");
    var $tBody = $table.find("tbody");
    var templeteTr="";
    list.forEach(function(item){
        templeteTr+='\
        <tr \
        	data-id="'+ item.hpPositionId +'" \
            data-approve="'+ item.approveState +'" \
            data-hot="'+ item.hotOn +'" > \
            <th>'+ item.posName +'</th>\
            <th>'+ item.comName +'</th>\
            <th>'+ posDateFormat(item.startTime) +'</th>\
            <th>'+ posDateFormat(item.endTime) +'</th>\
            <th>'+ showApproveState(item.approveState) +'</th>\
            <th>'+ showPosState(item.endTime) +'</th>\
            <th>\
                <button type="button" id="hotOn" class="btn btn-default btn-sm cat">'+showHotOn(item.hotOn)+'</button>\
                <a class="btn btn-primary btn-sm contact" href="/static/adminData/position.html?hpPositionId='+item.hpPositionId+'" >编辑</button>\
            </th>\
        </tr>';
    })
    $tBody.html(templeteTr)    
}

function showApproveState(param){
	if(param == 1){
		return "已认证";
	}
	return "未认证";
}
function showPosState(endTime){
	var curTime = new Date().getTime()/1000;
	if(curTime <= endTime){
		return "招聘中";
	}
	return "已过期";
}
function showHotOn(param){
	if(param == 1){
		return "取消热门";
	}
	return "设为热门";
}
function posDateFormat(timeStamp){
	return publicObj.dateFormat(publicObj.secondToDate(timeStamp),dateStrData.d1);
}

function pageShow(pageData){
	totalPage = pageData.totalPage;
    currentPage = pageData.currentPage;
    // 分页初始化
    if(totalPage>1){
        $('#pageLimit').bootstrapPaginator({
            currentPage: currentPage,//当前的请求页面。
            totalPages: totalPage,//一共多少页。
            size:"normal",//应该是页眉的大小。
            bootstrapMajorVersion: 3,//bootstrap的版本要求。
            alignment:"right",
            numberOfPages:5,//一页列出多少数据。
            itemTexts: function (type, page, current) {//如下的代码是将页眉显示的中文显示我们自定义的中文。
                switch (type) {
                    case "first": return "首页";
                    case "prev": return "上一页";
                    case "next": return "下一页";
                    case "last": return "末页";
                    case "page": return page;
                }
            },
            onPageClicked: function (event, originalEvent, type, page){//给每个页眉绑定一个事件，其实就是ajax请求，其中page变量为当前点击的页上的数字。
            	pageSearch(page);
            }
        });
        $("#logs-pager").show()
    }else{
        $("#logs-pager").hide()
    }
}