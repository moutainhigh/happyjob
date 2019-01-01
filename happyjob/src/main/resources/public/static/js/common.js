var BASE_URL = "http://127.0.0.1:9091";

function fetchGet(options){
    $.get( BASE_URL+ options.url,options.params,function(data){
        console.log(data)
        if(data.errorCode==0){
            options.callback && options.callback(data)
        }else{
            swal('请求失败', data.message, 'error');
        }
    })
}

function fetchPost(options){
    $.post( BASE_URL+ options.url,options.params,function(data){
        console.log(data)
        if(data.errorCode==0){
            options.callback && options.callback(data)
        }else{
            swal('请求失败', data.message, 'error');
        }
    })
}


