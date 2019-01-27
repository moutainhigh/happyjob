// 日期选择器
$(".datepicker").datepicker({
    language: "zh-CN",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});

$(document).on("click",".queryApply",function(){
	pageSearch(1);
})

//分页查询
function pageSearch(page){
	listParams.name = $("#name").val();
	listParams.comName = $("#comName").val();
//	listParams.contactNum = $("#contactNum").val();
	listParams.currentPage = page;
	fetchList();
}


var $object ;
// 点击联系按钮    出现modal
$(document).on("click",".contact",function(){
	var $row = $(this).parents("tr");
	$object = $row ;
    var hpCompanyApplyId = $row.data("company-apply-id");
	fetchPost({
	        url:"/backDelivery/getLoginUserInfo",
	        params: {},
	        callback:function(data){
	            console.log(data);
	            //赋值
	            $("#optionPerson").val(data.realName);
	            $("#optionTime").val(data.comTime);
	            $("#hpCompanyApplyId").val(hpCompanyApplyId);
	        	$('#comtactPersonModal').modal('toggle');
	        }
	})
	    
})

// 联系人 联系时间
$(document).on("click","#addComtact",function(){
	var params ={}
    params.optionPerson = $("#optionPerson").val();
	params.optionTime = getDayToSecond($("#optionTime").val());
	params.hpCompanyApplyId =  $("#hpCompanyApplyId").val();
	
	var $contact = $object.find(".contact");
	var $optionPerson = $object.find(".optionPerson");
	var $optionTime = $object.find(".optionTime");
	fetchPost({
	        url:"/backApply/addComtact",
	        params: params,
	        callback:function(data){
	            console.log(data);
	            $contact.eq(0).html("已联系");
	            $contact.eq(0).attr('class',"btn btn-primary btn-sm entry");
	            $optionPerson.eq(0).html($("#optionPerson").val());
	            $optionTime.eq(0).html($("#optionTime").val());
		        
	        }
	})
    $('#comtactPersonModal').modal('hide')
    
})
// 删除
$(document).on("click",".del",function(){
	var $row = $(this).parents("tr");
	var hpCompanyApplyId = $row.data("company-apply-id");
	var data ={};
	data.hpCompanyApplyId =hpCompanyApplyId ;
    swal({
    	  title: '删除',
          text: '请确认是否删除!',
          type: 'warning',
          showCancelButton: true,
          confirmButtonText: '删除',
          cancelButtonText: '不删除',
          }).then(function(isConfirm) {
          if (isConfirm === true) {
          	postDel(data);
              swal(
  	            '删除',
  	            '删除成功',
  	            'success'
              );
          }
    }); 
})
// 删除
function postDel(param){
    fetchPost({
        url:"/backApply/deleteApply",
        params: param,
        callback:function(data){
            console.log(data);
            fetchList();
        }
    })
}

var listParams = {
		name:"",
		comName:"",
//		contactNum:"",
		currentPage:1,
		showCount:15
}
var list= [];
var totalPage=1;

fetchList();

// 获取table数据
function fetchList(){
    fetchGet({
        url:"/backApply/applyList",
        params:listParams,
        callback:function(data){
        	console.log(data)
            list = data.list;
            listParams.currentPage = data.page.currentPage;
            totalPage= data.page.totalPage;
            addTableList(list);
            publicObj.pageShow(data.page,pageSearch);
        }
    })    
}





// 添加table数据
function addTableList(list){
    var $table = $("#userList");
    var $tBody = $table.find("tbody");
    var templeteTr="";
    list.forEach(function(item){
        templeteTr+='\
        <tr \
        	data-company-apply-id="'+item.hpCompanyApplyId+'" \
        	data-name="'+ item.name +'" \
            data-com-name="'+ item.comName +'" \
            data-contact-num="'+ item.contactNum +'" \
            data-position="'+ item.position +'" \
            data-contact-on="'+ item.contactOn +'" \
            data-option-person="'+ item.optionPerson +'" \
            data-option-time="'+ item.optionTime +'" \
            <th>'+ item.name +'</th>\
            <th>'+ item.name +'</th>\
            <th>'+ item.comName +'</th>\
            <th>'+ item.contactNum  +'</th>\
            <th>'+ item.position +'</th>\
            <th>\
            	<button type="button" class="btn btn-danger  btn-sm  del">删除</button>\ '
            if(item.contactOn == 1 ){ 
            	templeteTr += '<button type="button" class="btn btn-primary btn-sm ">已联系</button>\ '
	        }else{
	        	templeteTr += '<button type="button" class="btn btn-primary btn-sm contact">联系</button>\ '
	        }
            
	            templeteTr +='</th>\
				        <th class="optionPerson">'+isNull(item.optionPerson)+'</th>\ <th class="optionTime">'+isNull(timestampToDay(item.optionTime))+'</th>\
	        </tr>';
    })
    $tBody.html(templeteTr)    
}



//时间戳转date
function timestampToDay(timestamp) {
	if(timestamp ==null || timestamp ==""){
		return "";
	}else{
		var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
	    var Y = date.getFullYear() + '-';
	    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
	    var D = change(date.getDate()) ;
	    return Y + M + D ;
	}
  
}


function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}
function getDayToSecond(timestamp){
	if(timestamp !=null && timestamp !=""){
		timestamp += " 00:00:00";
		return new Date(timestamp).getTime()/1000;
	}
}


