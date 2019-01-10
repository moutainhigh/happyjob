var gverify = null;
$(function(){
        $.supersized({

        // 功能
        slide_interval     : 4000,    
        transition         : 1,    
        transition_speed   : 1000,    
        performance        : 1,    

        // 大小和位置
        min_width          : 0,    
        min_height         : 0,    
        vertical_center    : 1,    
        horizontal_center  : 1,    
        fit_always         : 0,    
        fit_portrait       : 1,    
        fit_landscape      : 0,    

        // 组件
        slide_links        : 'blank',    
        slides             : [    
                                 {image : '/static/images/login/1.jpg'},
                                 {image : '/static/images/login/2.jpg'},
                                 {image : '/static/images/login/3.jpg'},
								 {image : '/static/images/login/4.jpg'},
								 {image : '/static/images/login/5.jpg'}
                       ]

    });
	 // 验证码
	 gverify = new GVerify("codeimage");
	//显示隐藏验证码
    $("#hide").click(function(){
        $(".code").fadeOut("slow");
    });
    $("#captcha").focus(function(){
        $(".code").fadeIn("fast");
//        gverify.refresh();
    });
    
    $("#tip").hide();
    
    //跳出框架在主窗口登录
//   if(top.location!=this.location)	top.location=this.location;
    $('#user_name').focus();
    /*if ($.browser.msie && ($.browser.version=="6.0" || $.browser.version=="7.0")){
        window.location.href='http://www.abc.com/admin/templates/default/ie6update.html';
    }*/
//    $("#captcha").nc_placeholder();
	//动画登录
    $('.btn-submit').click(function(e){
    		if(confirmForm()==false){return};
    		if(!gverify.validate($("#captcha").val())){return};
            $('.input-username,dot-left').addClass('animated fadeOutRight')
            $('.input-password-box,dot-right').addClass('animated fadeOutLeft')
            $('.btn-submit').addClass('animated fadeOutUp')
            setTimeout(function () {
                      $('.avatar').addClass('avatar-top');
                      $('.submit').hide();
                      $('.submit2').html('<div class="progress"><div class="progress-bar progress-bar-success" aria-valuetransitiongoal="100"></div></div>');
                      $('.progress .progress-bar').progressbar({
                          done : function(){login();}
                      }); 
              },
          300);

          });

    // 回车提交表单
    $('#form_login').keydown(function(event){
        if (event.keyCode == 13) {
            $('.btn-submit').click();
        }
    });
  
    var loginData={};
    // 表单验证
    function confirmForm(){
    	var userName = $("#user_name").val();
    	var password = $("#password").val();
    	var captcha = $("#captcha").val();
    	var patt = new RegExp("[\\S]{6}[\\S]*");
    	var patt1 = new RegExp("[A-z0-9]{4}");
    	if(userName==null || userName.trim()==""){
    		$("#user_name").val(null);
    		$("#user_name").focus();
    		return false;
    	}
    	if(!patt.test(password)){
    		$("#password").val(null);
    		$("#password").focus();
    		return false;
    	}
    	if(!patt1.test(captcha)){
    		$("#captcha").val(null);
    		$("#captcha").focus();
    		return false;
    	}
    	loginData.userName = userName;
    	loginData.password = password;
    	loginData.validCode = captcha;
    	return true;
    }
    
    // 登录提交
    function login(){
    	$.ajax({
    		url:BASE_URL+ apiData.login,
    		type:"post",
    		data:loginData,
    		success:function(data){
    	        if(data.errorCode==0){
    	        	window.location.href = routingData.homePage;
    	        }else{
    	        	removeProgressbar();
    		        $("#tip").val(data.message).show();
    	        }
    		},
    		error:function(data){
    			removeProgressbar();
    			$("#tip").val(data.message).show();
    		}
    	})
    }
    
    function removeProgressbar(){
    	$('.input-username,dot-left').removeClass('animated fadeOutRight')
        $('.input-password-box,dot-right').removeClass('animated fadeOutLeft')
        $('.btn-submit').removeClass('animated fadeOutUp')
    	$('.avatar').removeClass('avatar-top');
        $('.submit').show();
        $('.submit2').html(null);
    }
});