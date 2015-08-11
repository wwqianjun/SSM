$(function(){
	$("#ajaxBtn").click(function(){
		var value = $(this).attr("param");
		var content = $(this).html();
		$.post(
				"unSyn",
				{"value":value},
				function(result){
					if(result.status="SUCCESS")
						$.tzUtil.alert(result.data.name)
				}
		);
	});
	
	$("#ajaxBtnString").click(function(){
		var value = $(this).attr("param");
		var content = $(this).html();
		$.post(
				"unSynString",
				{"value":value},
				function(result){
						$.tzUtil.alert(result)
				}
		);
	});
	
	$("#ajaxBtnInt").click(function(){
		var value = $(this).attr("param");
		var $this = $(this);
		var content = $(this).html(); //
		var content2 = $(this).text();// 文本值 不包含html
		var content3 = $(this).val();// select option/ input
		$.post(
				"unSynInt",
				{"value":value},
				function(result){
					$.tzUtil.alert(result);
					$this.text(result); //val()是不行的
				}
		);
	})
})