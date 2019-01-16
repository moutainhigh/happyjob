// 日期选择器
$(".datepicker").datepicker({
    language: "zh-CN",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});

$('#upPic').on('change',function(){                                                 //选中图片后展示在页面
   var filePath = $(this)[0].files[0].name //获取到input的value，里面是文件的路径 
   console.log(filePath) //1.png 
   fileFormat = filePath.split('.')[1].toLowerCase() 
   console.log(fileFormat) //png
   src = window.URL.createObjectURL(this.files[0]) //转成可以在本地预览的格式 
   console.log(src) //blob:null/11ea5a2d-7270-4035-b5c4-4e50c5c061e7

   // 检查是否是图片 
   if( !fileFormat.match(/png|jpg|jpeg/) ) { 
      alert('上传错误,文件格式必须为：png/jpg/jpeg')
     return 
  	} 
   $("#imgContent").css("display", "block");
   $('#imgContent').attr('src',src)
   
   //上传图片
   uploadPic(window.location.origin + "/wxAppletsLogin/imgUpOne");
   
})

	
function uploadPic(url){
	var file = $("#upPic").get(0).files[0];
	if(!file){
		return;
	}
	var formData = new FormData();
	formData.append("file",file);
	formData.append("code","banner");
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
var listParams = {
		title:"",
		location:"",
		type:"",
		endTime:"",
		sort:"",
		picUrl:"",
		targetUrl:""
}

// 保存广告
$(document).on("click","#saveAdvertisement",function(){
	
	
	listParams.title = $("#title").val();
	listParams.location = $("#posType").val();
	listParams.endTime = dateToTime($("#endTime").val());
	listParams.sort = $("#sort").val();
	var picAddress = $("#picAddress").val();
	if(picAddress !=null && picAddress !=""){
		listParams.picUrl = picAddress;
	}else{
		listParams.picUrl = picUrl;
	}
	listParams.targetUrl = $("#targetUrl").val();
	fetchPost({
	       url:"/backAdvertisement/saveAdvertisement",
	       params:listParams,
	       callback:function(result){
	           console.log(result);
	           swal(
	                   'Saved!',
	                   '已保存.',
	                   'success'
	           );
	       }
	   }) ; 
    
})


// 启用
$(document).on("click",".restart",function(){
    swal({
        title: '是否对该用户启用？',
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



// 获取table数据
function fetchList(){
    fetchGet({
        url:"/backUser/userList",
        params:listParams,
        callback:function(data){
            list = data.list;
            listParams.currentPage = data.page.currentPage;
            totalPage= data.page.totalPage;
            addTableList(list);
        }
    })    
}
// 认证、禁用、启用请求
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

function dateToTime(timestamp) {
	var formatTimeS = new Date($("#endTime").val()+" 00:00:00").getTime();
	return formatTimeS/1000;
}

function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}
