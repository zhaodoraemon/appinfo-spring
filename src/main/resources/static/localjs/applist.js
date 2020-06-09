//显示二级分类
$("#queryCategoryLevel1").change(function(){
		//获取选中的value
		var id=$(this).val();
		if(id != '' && id != null) {
			$.ajax({
				url: "categorylevellist.do?parentId=" + id,
				type: "get",
				dataType: "json",
				success: function (res) {
					var ops = "<option value=''>--请选择--</option>";
					$.each(res, function (i, n) {
						ops += "<option value='" + n.id + "'>" + n.categoryname + "</option>";
					});
					$("#queryCategoryLevel2").html(ops);
				}
			});
		}
	});
//三级分类
$("#queryCategoryLevel2").change(function(){
	//获取选中的value
	var id=$(this).val();
	if(id != '' && id != null) {
		$.ajax({
			url: "categorylevellist.do?parentId=" + id,
			type: "get",
			dataType: "json",
			success: function (res) {
				var ops = "<option value=''>--请选择--</option>";
				$.each(res, function (i, n) {
					ops += "<option value='" + n.id + "'>" + n.categoryname + "</option>";
				});
				$("#queryCategoryLevel3").html(ops);
			}
		});
	}
});


$(".checkApp").on("click",function(){
	var obj = $(this);
	var status = obj.attr("status");
	var vid = obj.attr("versionid");
	if(status == "1" && vid != "" && vid != null){//待审核状态下才可以进行审核操作
		window.location.href="check.do?aid="+ obj.attr("appinfoid");
	}else if(vid != "" || vid != null){
		alert("该APP应用没有上传最新版本,不能进行审核操作！");
	}else if(status != "1"){
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
	}
});



	
