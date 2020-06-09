$(function(){
	//动态加载所属平台列表
	//显示二级分类
	$("#categoryLevel1").change(function(){
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
					$("#categoryLevel2").html(ops);
				}
			});
		}
	});
//三级分类
	$("#categoryLevel2").change(function(){
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
					$("#categoryLevel3").html(ops);
				}
			});
		}
	});
});
      
      
      