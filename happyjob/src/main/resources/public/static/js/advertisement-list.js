// 日期选择器
$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});

function uploadPic(url){
	var file = $("#upPic").get(0).files[0];
	if(!file){
		return;
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
			picUrl = data.data.imgUrl ;
		}
	});
}
var picUrl ;
var saveParams ={};
//修改
$(document).on("click","#updateAdvertisement",function(){
	//先保存图片
	uploadPic(window.location.origin + "/wxAppletsLogin/imgUpOne");
	
	saveParams.hpAdvBannerId = $("#bannerId").val();
	saveParams.title = $("#title").val();
	saveParams.location = $("#location").val();
	saveParams.type = $("#type").val();
	saveParams.endTime = dateToTime($("#endTime").val());
	saveParams.sortNum = $("#sortNum").val();
	saveParams.picUrl = picUrl;
	saveParams.targetUrl = $("#targetUrl").val();
	
	fetchPost({
	       url:"/backAdvertisement/updateAdvertisement",
	       params:saveParams,
	       callback:function(result){
	           console.log(result);
	           $("#browseModal").modal('hide');  //手动关闭
	           fetchList(); //刷新页面
	           swal(
	                   'Saved!',
	                   '已修改',
	                   'success'
	           );
	       }
	   }) ; 
    
})
// 删除
$(document).on("click",".deleteAdv",function(){
	var result = {};
	var $row = $(this).parents("tr");
    var hpAdvBannerId=$row.data("hpadvbannerid");
    result.hpAdvBannerId = hpAdvBannerId;
    swal({
        title: '是否删除该广告',
        text: '',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: '是',
        cancelButtonText: '否',
        }).then(function(isConfirm) {
        if (isConfirm === true) {
        	deleteAdvertisement(result);
        } else if (isConfirm === false) {
            swal(
            '取消',
            '未删除',
            'error'
            );
        } else {
        	
        }
    }); 
})

//分页查询
function pageSearch(page){
	listParams.currentPage = page;
	fetchList();
}

// 开启/关闭
$(document).on("click",".openOrClose",function(){
	var result = {};
	var $row = $(this).parents("tr");
    var hpAdvBannerId=$row.data("hpadvbannerid");
    var useOn = $row.data("use-on");
    result.hpAdvBannerId = hpAdvBannerId;
    result.useOn =useOn;
    swal({
        title: '开启',
        text: '是否开启/关闭!',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        }).then(function(isConfirm) {
        if (isConfirm === true) {
        	postUseOn(result);
        	
            swal(
	            '开启/关闭!',
	            '成功.',
	            'success'
            );
        
        } 
    }); 
})

// 点击出现modal
$(document).on("click",".updateAdv",function(){
    var $row = $(this).parents("tr");
    
      $("#bannerId").val($row.data("hpadvbannerid"));
      $("#title").val($row.data("title"));
      $("#endTime").val($row.data("end-time"));
      $("#sortNum").val($row.data("sort-num"));
      $("#picUrl").attr("src",$row.data("pic-url"));
      $("#targetUrl").val($row.data("target-url"));
      $("#posType").val($row.data("pos-type"));
      
      var obj = document.getElementById('upPic') ; //清空
      obj.outerHTML=obj.outerHTML; 
     
    $('#browseModal').modal('toggle');
})


var listParams = {
    currentPage:1,
    showCount:5
}
var list= [];
var totalPage=1;

fetchList();

// 获取table数据
function fetchList(){
    fetchGet({
        url:"/backAdvertisement/advertisementList",
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
// 开启 /关闭
function postUseOn(data){
	console.log("postUseOn:"+data);
    fetchPost({
        url:"/backAdvertisement/advertisementUseOn",
        params: data,
        callback:function(data){
            console.log(data);
            fetchList();
        }
    })
}
// 删除广告
function deleteAdvertisement(data){
	console.log("deleteAdvertisement:"+data);
    fetchPost({
        url:"/backAdvertisement/deleteAdvertisement",
        params: data,
        callback:function(data){
            console.log(data);
            fetchList();
            
        }
    })
}
// 添加table数据
function addTableList(list){
    var $table = $("#advertisementList");
    var $tBody = $table.find("tbody");
    var templeteTr="";
    list.forEach(function(item){
        templeteTr+='\
        <tr \
            data-hpadvbannerid="'+ item.hpAdvBannerId +'" \
            data-use-on="'+ item.useOn +'" \
            data-title="'+ item.title +'" \
            data-pos-type="'+ item.posType +'" \
            data-sort-num="'+ item.sortNum +'" \
            data-create-time="'+ timestampToTime(item.createTime) +'" \
            data-comname="'+ (item.picUrl || "") +'" \
            data-end-time="'+ timestampToDay(item.endTime) +'" \
            data-pic-url="'+ item.picUrl +'" \
            data-target-url="'+ item.targetUrl +'" \
            data-del-on"'+ item.delOn +'" >\
            <th>'+ item.title +'</th>\
            <th>'+ posType(item.posType) +'</th>\
            <th>'+ timestampToTime(item.createTime) +'</th>\
            <th>'+ timestampToTime(item.endTime) +'</th>\
            <th>'+ item.sortNum +'</th>\
            <th>';
            
            if(item.useOn ==0){
            	templeteTr += '<button type="button" class="btn btn-default btn-sm openOrClose">开启</button>' ;
            }else{
            	templeteTr += '<button type="button" class="btn btn-default btn-sm openOrClose">关闭</button>' ;
            }
            templeteTr  += '\
                <button type="button" class="btn btn-primary btn-sm updateAdv">编辑</button>\
                <button type="button" class="btn btn-danger btn-sm deleteAdv">删除</button>\
            </th></tr>';
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

function timestampToDay(timestamp) {
    var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var D = change(date.getDate());
    
    return Y + M + D;
}

function dateToTime(timestamp) {
	if(timestamp != null && timestamp !=""){
		var formatTimeS = new Date($("#endTime").val()+" 00:00:00").getTime();
		return formatTimeS/1000;
	}
	return "";
}
function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}

function posType(value){
    switch (value) {
        case 1:return "首页轮播"
    }
}