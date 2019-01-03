// 日期选择器
$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});
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
        	//重新初始化
        	fetchList();
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

//$(document).on("click",".cat",function(){
//    var $row = $(this).parents("tr");
//    var iphone=$row.data("iphone");
//    var name=$row.data("name");
//})

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
//            swal(
//            'Deleted!',
//            'Your imaginary file has been deleted.',
//            'success'
//            );
        
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
$(document).on("click",".auth",function(){
    var $row = $(this).parents("tr");
    var title=$row.data("title");
    var location=$row.data("location");
    var type=$row.data("type");
    var createTime=$row.data("creat-time");
    var endTime=$row.data("end-time");
    var sortName=$row.data("sort-num");
    
    var $obj = $("#browseModal").find(".showValue");
    $obj.eq(0).html(title)
    $obj.eq(1).html(location)
    $obj.eq(2).html(type)
//    $obj.eq(4).html(createTime)
    $obj.eq(5).html(endTime)
//    $obj.eq(6).html(sortName)
    $('#browseModal').modal('toggle')
})


var listParams = {
    phoneNo:"",
    resource:"",
    startTime:"",
    endTime:"",
    blackOn:"",
    userType:"",
    currentPage:1,
    showCount:10
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
            console.log(data)
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
            console.log(data)
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
            data-sort-num="'+ item.sortNum +'" \
            data-create-time="'+ timestampToTime(item.createTime) +'" \
            data-comname="'+ (item.picUrl || "") +'" \
            data-end-time="'+ timestampToTime(item.endTime) +'" \
            data-del-on"'+ item.delOn +'" >\
            <th>'+ item.title +'</th>\
            <th>'+ '首页轮播' +'</th>\
            <th>'+ '图片' +'</th>\
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
                <button type="button" class="btn btn-primary btn-sm auth">编辑</button>\
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
function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}
