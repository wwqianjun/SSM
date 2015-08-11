$.tzUtil={
	/**
	 * confirm弹出窗口 非阻塞对话框
	 * @param setting 
	 * {
			message:"message!!",//内容
			ok:$.noop;//确认按钮回调函数
			cancel:$.noop;//取消按钮回调函数
		};
	 * 
	 */
	confirm:function(setting){
		//默认设置
		var defaultSetting = {
			message:"message!!",
			ok:$.noop,
			cancel:$.noop
		};
		
		$.extend(defaultSetting,setting);
		
        var windowEle = $("#popup-window-tzUtil-confirm");//弹出框承载div
		
		//判断承载div是否已经存在
		if(!windowEle.length>0){
			windowEle = $('<div id="popup-window-tzUtil-confirm" class="popup-window">');
			windowEle.appendTo($('body'));
		}
        
		//定义一个弹出模板
		var win_template = kendo.template('<div class="row row-icontext">'
			    +'<p>#= data.message #</p>'
				+'</div>'
				+'<div class="row row-btns" style="text-align:right;">'
				    +'<button id="ok" class="btns btn-s1 btn-c1">确 定</button>' 
				    +'<button id="cancel" class="btns btn-s1 btn-c5">取 消</button>' 
				+'</div>');
			
		//初始化弹出窗口
		windowEle.kendoWindow({
			title:"确认",
			actions: [""],//窗体不要任何按钮
			visible:false,
	        animation:false,//动画效果
	        width:350,
	        modal:true,
	        autoHide:false,
	        resizable:false,//不能改变大小
	        reload:false,
	        //iframe:true,
			content: {
				template:win_template
			}
		});
		
		//构建模板值
		var data ={
			message:defaultSetting.message
		}
		
		
		//获取窗口对象
		var dialog = windowEle.data("kendoWindow");
		
		//刷新对象数据
		dialog.refresh({
			template:win_template(data)
		});
		
		//注册按钮事件
		windowEle.find("#ok").one("click",function(){
			dialog.close();
			defaultSetting.ok();
		});
		windowEle.find("#cancel").one("click",function(){
			dialog.close();
			defaultSetting.cancel();
		});
		
		//打开窗口
		dialog.center().open();
	},
	
	/**
	 * alert弹出窗口，非阻塞对话框
	 * @param message 需要弹出的提示信息
	 * @param type 弹出框类型 错误error 警告warning 普通""（默认）
	 * @param okCallBack 点击后的回掉方法
	 */
	alert:function(message,type,okCallBack,options){
		var winType = type||"";
		var winMessage = "";
		var winTitle = "";
		
		if(winType == "error"){
			winTitle = "错误";
			winMessage = "<i class='icon icon3' style='vertical-align:top'></i>"+message;
		}else if(winType == "warning"){
			winTitle = "警告";
			winMessage = "<i class='icon icon3' style='vertical-align:top'></i>"+message;
		}else{
			winTitle = "提示";
			winMessage = message;
		}
		
		var windowEle = $("#popup-window-tzUtil-alert");//弹出框承载div
		
		//判断承载div是否已经存在
		if(!windowEle.length>0){
			windowEle = $('<div id="popup-window-tzUtil-alert" class="popup-window">');
			windowEle.appendTo($('body'));
		}

		if(options == undefined) {
			options = {} || options;
		}
		//定义弹出模板
		if(options.hideButton != undefined && options.hideButton){
			var win_template = kendo.template('<div class="row row-icontext">'
			    +'<p>#= data.message #</p>'
				+'</div>');
		} else {
			var win_template = kendo.template('<div class="row row-icontext">'
			    +'<p>#= data.message #</p>'
				+'</div>'
				+'<div class="row row-btns" style="text-align:right;">'
				    +'<button id="ok" class="btns btn-s1 btn-c1">确 定</button>' 
				+'</div>');
		}

		//初始化弹出窗口
		$.extend(options, {
			title:winTitle,
			actions: false,//窗体不要任何按钮
			visible:false,
	        animation:false,//动画效果
	        width:350,
	        modal:true,
	        resizable:false,//不能改变大小
	        reload:false,
			content: {
				template:win_template
			}
		});

		windowEle.kendoWindow(options);
		
		//构建模板值
		var data ={
			message:winMessage
		}
		
		//获取窗口对象
		var dialog = windowEle.data("kendoWindow");
		
		//刷新对象数据
		dialog.refresh({
			template:win_template(data)
		});
		
		//注册按钮事件
		windowEle.find("#ok").one("click",function(){
			dialog.close();
			if($.isFunction(okCallBack)){
				okCallBack();
			}
		});

        if(options.autoHide){
            setTimeout(function(){
                dialog.close();
				if($.isFunction(okCallBack)){
					okCallBack();
				}
            },options.autoHide);
        }
		
		//打开窗口
		dialog.center().open();

		setTimeout(function() {dialog.title(winTitle);}, 0);
	},
	
	/**
	 * confirm弹出窗口，非阻塞对话框
	 * @param message 需要弹出的提示信息
	 * @param type 弹出框类型 错误error 警告warning 普通""（默认）
	 * @param okCallBack 点击确定后的回掉方法
	 * @param cancelCallBack 点击取消后的回调方法
	 */
	confirm:function(message,type,okCallBack,cancelCallBack,options){
		var winType = type||"";
		var winMessage = "";
		var winTitle = "";
		
		if(winType == "error"){
			winTitle = "错误";
			winMessage = "<i class='icon icon3' style='vertical-align:top'></i>"+message;
		}else if(winType == "warning"){
			winTitle = "警告";
			winMessage = "<i class='icon icon3' style='vertical-align:top'></i>"+message;
		}else{
			winTitle = "提示";
			winMessage = message;
		}
		
		var windowEle = $("#popup-window-tzUtil-alert");//弹出框承载div
		
		//判断承载div是否已经存在
		if(!windowEle.length>0){
			windowEle = $('<div id="popup-window-tzUtil-alert" class="popup-window">');
			windowEle.appendTo($('body'));
		}

		//定义弹出模板
		if(options == undefined) {
			options = {} || options;
		}
		//定义弹出模板
		if(options.hideButton != undefined && options.hideButton){
			var win_template = kendo.template('<div class="row row-icontext">'
			    +'<p>#= data.message #</p>'
				+'</div>');
		} else {	
			var win_template = kendo.template('<div class="row row-icontext">'
				+'<p>#= data.message #</p>'
				+'</div>'
				+'<div class="row row-btns">'
				    +'<button id="ok" class="btns btn-s1 btn-c1">确 定</button>' 
				    +'<button id="cancel" class="btns btn-s1 btn-c1">取 消</button>'
				+'</div>');
		}
		

		//初始化弹出窗口
		$.extend(options, {
			title:winTitle,
			actions: false,//窗体不要任何按钮
			visible:false,
	        animation:false,//动画效果
	        width:350,
	        modal:true,
	        resizable:false,//不能改变大小
	        reload:false,
			content: {
				template:win_template
			}
		});

		windowEle.kendoWindow(options);
		
		//构建模板值
		var data ={
			message:winMessage
		}
		
		//获取窗口对象
		var dialog = windowEle.data("kendoWindow");
		
		//刷新对象数据
		dialog.refresh({
			template:win_template(data)
		});
		
		//注册按钮事件
		windowEle.find("#ok").one("click",function(){
			dialog.close();
			if($.isFunction(okCallBack)){
				okCallBack();
			}
		});
		
		windowEle.find("#cancel").one("click",function(){
			dialog.close();
			if($.isFunction(cancelCallBack)){
				cancelCallBack();
			}
		});

        if(options.autoHide){
            setTimeout(function(){
                dialog.close();
				if($.isFunction(okCallBack)){
					okCallBack();
				}
            },options.autoHide);
        }
		
		//打开窗口
		dialog.center().open();

		setTimeout(function() {dialog.title(winTitle);}, 0);
	},
	
	/**
	 * ajax请求
	 * @param url  请求地址
	 * @param requestData 请求json数据
	 * @param successCallBack 请求成功回调方法
	 */
	request:function(url,requestData,successCallBack,errorCallBack){
		//发送ajax请求
		$.post(url,requestData,function(data){
			if(data.status == "SUCCESS"){//请求成功，执行回调
				successCallBack(data.data);
			}else{//请求失败，直接弹出失败信息
				if(undefined != errorCallBack) {
					errorCallBack(data.message);
				}
				$.tzUtil.alert(data.message,"error");
			}
		},"json");
	},
	
	successToast:function(successMsg, delayTime){
		if (null != successMsg && $.trim(successMsg)!="") {
			$('.lightboxToLoadSuccess').find(".successHint").html(successMsg);
		}else{
			$('.lightboxToLoadSuccess').find(".successHint").html("请求成功");
		}
		var delay = 2000;
		if (null != delayTime && $.trim(successMsg)!="") {
			try{
				delay = parasInt(delayTime);
				if (delay == "NaN" || delay == NaN) {
					delay = 2000;
				}
			}catch (e) {
				delay = 2000;
			}
		}
		var delay = parseInt(delayTime);
		$('.lightboxToLoadSuccess').show().delay(delay).fadeOut();
	},
	
	/**
	 * ajax请求
	 * @param url  请求地址
	 * @param requestData 请求json数据
	 * @param successCallBack 请求成功回调方法
	 */
	requestWithLoading:function(url,loadingMsg,requestData,successCallBack,errorCallBack){
		if (null!=loadingMsg && $.trim(loadingMsg)!="") {
			$('.lightboxToLoadContent').find(".toLoadCharacter").html(loadingMsg);
		}else{
			$('.lightboxToLoadContent').find(".toLoadCharacter").html("请求发送中，请稍等...");
		}
		 $('.lightboxToLoadContent').show();
		//发送ajax请求
		$.post(url,requestData,function(data){
			 $('.lightboxToLoadContent').hide();
			if(data.status == "SUCCESS"){//请求成功，执行回调
				successCallBack(data.data);
			}else{//请求失败，直接弹出失败信息
				if(undefined != errorCallBack) {
					$.tzUtil.alert(data.message,"error",errorCallBack(data.data));
				}else{
					$.tzUtil.alert(data.message,"error");
				}
			}
		},"json");
	},
	
	/**
	 * ajax请求
	 * @param url  请求地址
	 * @param requestData 请求json数据
	 * @param successCallBack 请求成功回调方法
	 */
	requestWithLoadingMobile:function(url,loadingMsg,requestData,successCallBack,errorCallBack){
		if (null!=loadingMsg && $.trim(loadingMsg)!="") {
			$('.lightboxToLoadContent').find(".toLoadCharacter").html(loadingMsg);
		}else{
			$('.lightboxToLoadContent').find(".toLoadCharacter").html("请求发送中，请稍等...");
		}
		 $('.lightboxToLoadContent').show();
		//发送ajax请求
		$.post(url,requestData,function(data){
			 $('.lightboxToLoadContent').hide();
			if(data.status == "SUCCESS"){//请求成功，执行回调
				successCallBack(data);
			}else{//请求失败，直接弹出失败信息
				if(undefined != errorCallBack) {
					errorCallBack(data);
				}else{
					$.tzUtil.alert(data.message,"error");
				}
			}
		},"json");
	},
	
	requestObject:function(url,requestData,successCallBack){
		//发送ajax请求
		$.post(url,JSON.stringify(requestData),function(data){
			if(data.status == "SUCCESS"){//请求成功，执行回调
				successCallBack(data.data);
			}else{//请求失败，直接弹出失败信息
				$.tzUtil.alert(data.message,"error");
			}
		},"json");
	},
	requestWithDialog:function(url,requestData,successCallBack){
		//发送ajax请求
		$.post(url,requestData,function(data){
			if(data.status == "SUCCESS"){//请求成功，执行回调
				successCallBack(data.data);
			}else{//请求失败，直接弹出失败信息
				$.tzUtil.alert(data.message,"error");
			}
		},"json");
	},
	/**
	 * ajax请求
	 * @param url  请求地址
	 * @param requestData 请求json数据
	 * @param successCallBack 请求成功回调方法
	 */
	mvRequest:function(url,requestData,successCallBack){
		//发送ajax请求
		$.post(url,requestData,function(data){
			successCallBack(data);
			/*if(data.status == "SUCCESS"){//请求成功，执行回调
				successCallBack(data);
			}else{//请求失败，直接弹出失败信息
				$.tzUtil.alert(data.message,"error");
			}*/
		});
	}
}