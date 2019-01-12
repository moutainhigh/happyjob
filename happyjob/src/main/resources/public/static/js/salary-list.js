$(".datepicker").datepicker({
    language: "cn",
    autoclose: true,//选中之后自动隐藏日期选择框
    format: "yyyy-mm"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
});

$(document).on("click","#upload",function(){
    var formData = new FormData($('#uploadFile')[0]);
	$.ajax({
		url:window.location.origin+"/backSalary/importSalary",
		dataType:"json",
		type:"post",
		data:formData,
        processData: false,  // 不处理数据
        contentType: false,   // 不设置内容类型
		success:function(data){
			swal('请求成功', data.message, 'success');
		}
	});
});


$(document).on("click","#querySalary",function(){
	pageSearch(1);
})

//分页查询
function pageSearch(page){
	listParams.payName = $("#payName").val();
	listParams.payIdNum = $("#payIdNum").val();
	listParams.workNum = $("#workNum").val();
	listParams.payComName = $("#payComName").val();
	listParams.payTime = getDayToSecond($("#payTime").val());
	listParams.currentPage = page;
	fetchList();
}

function getDayToSecond(timestamp){
	if(timestamp !=null && timestamp !=""){
		timestamp += "-01 00:00:00";
		return new Date(timestamp).getTime()/1000;
	}
}


$(document).on("click",".cat",function(){
    
    var $row = $(this).parents("tr");
    var hpUserPayrollId=$row.data("hp--user-payroll-id");
    var payName=$row.data("pay-name");
    var payIdNum=$row.data("pay-id-num");
    var workNum=$row.data("work-num");
    var payComName=$row.data("pay-com-name");
    var payTime=$row.data("pay-time");
    var shouldMoney=$row.data("should-money");
    var deductionMoney=$row.data("deduction-money");
    var realMoney=$row.data("real-money");
    var payDetail=$row.data("pay-detail");
    var createTime=$row.data("create-time");
    
    var $obj = $("#browseModal").find(".showValue");
    $obj.eq(0).html(hpUserPayrollId)
    $obj.eq(1).html(payName)
    $obj.eq(2).html(payIdNum)
    $obj.eq(3).html(workNum)
    $obj.eq(4).html(payComName)
    $obj.eq(5).html(payTime)
    $obj.eq(6).html(shouldMoney)
    $obj.eq(7).html(deductionMoney)
    $obj.eq(8).html(realMoney)
    $obj.eq(9).html(payDetail)
    $obj.eq(10).html(createTime)
    $('#browseModal').modal('toggle')
})

var listParams = {
	payName:"",
	payIdNum:"",
	workNum:"",
	payComName:"",
	payTime:"",
    currentPage:1,
    showCount:5
}
var list= [];
var totalPage=1;

fetchList();

// 获取table数据
function fetchList(){
    fetchGet({
        url:"/backSalary/salaryList",
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


// 添加table数据
function addTableList(list){
    var $table = $("#salaryList");
    var $tBody = $table.find("tbody");
    var templeteTr="";
    list.forEach(function(item){
        templeteTr+='\
        <tr \
            data-hp--user-payroll-id="'+ item.hpUserPayrollId +'" \
            data-pay-name="'+ item.payName +'" \
            data-pay-id-num="'+ item.payIdNum +'" \
            data-work-num="'+ item.workNum +'" \
            data-pay-com-name="'+ item.payComName +'" \
            data-pay-time="'+ timestampToMonth(item.payTime) +'" \
            data-should-money="'+ item.shouldMoney +'" \
            data-deduction-money="'+ item.deductionMoney +'" \
            data-real-money="'+ item.realMoney +'" \
            data-pay-detail="'+ item.payDetail.replace(/\"/g,"'") +'" \
            data-create-time="'+ timestampToTime(item.createTime) +'" >\
            <th>'+ isNull(item.payName) +'</th>\
            <th>'+ isNull(item.payComName) +'</th>\
            <th>'+ isNull(item.payIdNum) +'</th>\
            <th>'+ isNull(item.workNum) +'</th>\
            <th>'+ timestampToMonth(item.payTime) +'</th>\
            <th>'+ item.shouldMoney +'</th>\
            <th>'+ item.deductionMoney +'</th>\
            <th>'+ item.realMoney +'</th>\
            <th>\
                <button type="button" class="btn btn-default btn-sm cat">查看更多</button>\
            </th>\
        </tr>';
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
//时间戳转date
function timestampToMonth(timestamp) {
    var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
    return Y + M ;
}
function change(t) {
    if (t < 10) {
        return "0" + t;
    } else {
        return t;
    }
}

