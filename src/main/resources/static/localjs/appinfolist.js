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


$(".modifyVersion").on("click",function(){
	var obj = $(this);
	var status = obj.attr("status");
	var versionid = obj.attr("versionid");
	var appinfoid = obj.attr("appinfoid");
	var appname=obj.attr("appname");
	if(status == "1" || status == "3"){//待审核、审核未通过状态下才可以进行修改操作
		if(versionid == null || versionid == ""){
			alert("该APP应用无版本信息，请先增加版本信息！");
		}else{
			window.location.href="appversionmodify.do?vid="+ versionid + "&aid="+ appinfoid+"&name="+ appname;
		}
	}else{
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能修改其版本信息，只可进行【新增版本】操作！");
	}
});
$(".modifyAppInfo").on("click",function(){
	var obj = $(this);
	var status = obj.attr("status");
	if(status == "1" || status == "3"){//待审核、审核未通过状态下才可以进行修改操作
		window.location.href="appinfomodify.do?id="+ obj.attr("appinfoid");
	}else{
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能修改！");
	}
});

$(document).on("click",".saleSwichOpen,.saleSwichClose",function(){
	var obj = $(this);
	var appinfoid = obj.attr("appinfoid");
	var saleSwitch = obj.attr("saleSwitch");
	if("open" === saleSwitch){
		saleSwitchAjax(appinfoid,obj);
	}else if("close" === saleSwitch){
		if(confirm("你确定要下架您的APP应用【"+obj.attr("appsoftwarename")+"】吗？")){
			saleSwitchAjax(appinfoid,obj);
		}
	}
});

var saleSwitchAjax = function(appId,obj){
	$.ajax({
		type:"PUT",
		url:appId+"/sale.json",
		dataType:"json",
		success:function(data){
			/*
			 * resultMsg:success/failed
			 * errorCode:exception000001
			 * appId:appId
			 * errorCode:param000001
			 */
			if(data.errorCode === '0'){
				if(data.resultMsg === "success"){//操作成功
					if("open" === obj.attr("saleSwitch")){
						//alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
						$("#appInfoStatus" + obj.attr("appinfoid")).html("已上架");
						obj.className="saleSwichClose";
						obj.html("下架");
						obj.attr("saleSwitch","close");
						$("#appInfoStatus" + obj.attr("appinfoid")).css({
							'background':'green',
							'color':'#fff',
							'padding':'3px',
							'border-radius':'3px'
						});
						$("#appInfoStatus" + obj.attr("appinfoid")).hide();
						$("#appInfoStatus" + obj.attr("appinfoid")).slideDown(300);
					}else if("close" === obj.attr("saleSwitch")){
						//alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
						$("#appInfoStatus" + obj.attr("appinfoid")).html("已下架");
						obj.className="saleSwichOpem";
						obj.html("上架");
						obj.attr("saleSwitch","open");
						$("#appInfoStatus" + obj.attr("appinfoid")).css({
							'background':'red',
							'color':'#fff',
							'padding':'3px',
							'border-radius':'3px'
						});
						$("#appInfoStatus" + obj.attr("appinfoid")).hide();
						$("#appInfoStatus" + obj.attr("appinfoid")).slideDown(300);
					}
				}else if(data.resultMsg === "failed"){//删除失败
					if("open" === obj.attr("saleSwitch")){
						alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作失败");
					}else if("close" === obj.attr("saleSwitch")){
						alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作失败");
					}
				}
			}else{
				if(data.errorCode === 'exception000001'){
					alert("对不起，系统出现异常，请联系IT管理员");
				}else if(data.errorCode === 'param000001'){
					alert("对不起，参数出现错误，您可能在进行非法操作");
				}
			}
		},
		error:function(data){
			if("open" === obj.attr("saleSwitch")){
				alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
			}else if("close" === obj.attr("saleSwitch")){
				alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
			}
		}
	});
};



// $(".viewApp").on("click",function(){
// 	var obj = $(this);
// 	window.location.href="appview.do?"+ obj.attr("appinfoid");
// });

$(".deleteApp").on("click",function(){
	var obj = $(this);
	if(confirm("你确定要删除APP应用【"+obj.attr("appsoftwarename")+"】及其所有的版本吗？")){
		$.ajax({
			type:"GET",
			url:"delapp.do?id="+obj.attr("appinfoid"),
			dataType:"json",
			success:function(data){
				if(data == "true"){//删除成功：移除删除行
					alert("删除成功");
					obj.parents("tr").remove();
				}else if(data == "false"){//删除失败
					alert("对不起，删除AAP应用【"+obj.attr("appsoftwarename")+"】失败");
				}else if(data == "notexist"){
					alert("对不起，APP应用【"+obj.attr("appsoftwarename")+"】不存在");
				}
			},
			error:function(data){
				alert("对不起，删除失败");
			}
		});
	}
});

	
