$(function(){
	$("#ajaxBtn").click(function(){
		var value = $(this).attr("param");
		var content = $(this).html();
		$.post(
				"unSyn",
				{"value":value},
				function(result){
					if(result.status="SUCCESS")
						alert(result.data.name)
				}
		);
	})
})