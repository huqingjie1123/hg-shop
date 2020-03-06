<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<div>
	<div style="float:left;width:500px;overflow:hidden">
		<input id="queryName" value="${queryName}" type="text" />
		<button type="button" class="btn btn-primary" onclick="query()">
   		查询 </button>
   		<button type="button" class="btn btn-primary" onclick="delBatch()">
   		批删</button>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
   		添加 </button>
	</div>   	
   	<div style="float:right;width:385px;overflow:hidden">
   		<button type="button" class="btn btn-primary" onclick="selAll(1)">全选</button>
		<button type="button" class="btn btn-primary" onclick="selAll(2)">全不选</button>
		<button type="button" class="btn btn-primary" onclick="selAll(3)">反选</button>
   	</div>
</div>

<!-- 页面现实添加 -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
         <button type="button" class="btn btn-primary" onclick="addProp('#addspec')">添加属性</button>
         
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="addspec">
        		 <div class="form-group">
    				<label for="specName">规格名称</label>
    				<input type="text" class="form-control" name="specName" id="specName" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入规格名称</small>
  				</div>
  				<div class="form-group form-group-proper">
    				<label for="inputAddress">属性值</label>
    				<input type="text" name="options[0].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">
    				<button class="btn btn-primary" onclick="$(this).parent().remove()">Delete</buttonn>
  				</div>
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commitSpec()">Commit</button>
      </div>
    </div>
  </div>
</div>


<!-- 修改 -->
<div class="modal fade" id="staticBackdropUpdate" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
         <button type="button" class="btn btn-primary" onclick="addProp('#updatespec')"> 添加属性</button>
         
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="updatespec">
        		 <input type="hidden" name="id" id="upId">
        		 <div class="form-group">
    				<label for="specName">规格名称</label>
    				<input type="text" class="form-control" name="specName" id="upspecName" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入规格名称</small>
  				</div>
  				<div class="form-group form-group-proper">
    				<label for="inputAddress">属性值</label>
    				<input type="text" name="options[0].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">
    				<button class="btn btn-primary" onclick="$(this).parent().remove()">Delete</buttonn>
  				</div>
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commitUpdateSpec()">Commit</button>
      </div>
    </div>
  </div>
</div>

<table class="table">
	<tr> 
		<th><input type="checkbox" id="allSel" onchange="selectedAll()"></th>
		<th>id</th>
		<th>名称</th>
		<th>详情</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${pageInfo.list}" var="spec">
		<tr>
			<td><input type="checkbox" name="ids" value="${spec.id}" onchange="selectedOne()"></td>
			<td>${spec.id}</td>
			<td>${spec.specName}</td>
			<td>
				<c:forEach items="${spec.options}" var="op" >
					&nbsp;&nbsp; ${op.optionName}
				</c:forEach>
			</td>
			<td>
				<button type="button" class="btn btn-danger" onclick="delSec(${spec.id})">删除</button>
				<button type="button" class="btn btn-warning" onclick="openUpdateSpec(${spec.id})">修改</button>
			</td>
			
		</tr>
	</c:forEach>
	
	<!-- pageInfo -->
	<tr align="center">
		<td colspan="100">
			<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
		</td>
	</tr>
</table>    

<script type="text/javascript">
	var addindex=1;
	//fomId 标志给那个form 添加属性
	function addProp(fomId){
			$(fomId).append('<div class="form-group form-group-proper">'+
    				'<label for="inputAddress">属性值</label>'+
    				'<input type="text" name="options['+addindex+'].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">'+
    				'<button class="btn btn-primary" onclick="$(this).parent().remove()">Delete</button>'+
    				'</div>')
    				
    				
    	addindex++;
	} 
	
	// 提交修改
	function commitUpdateSpec(){
		
		var formData = new FormData($("#updatespec")[0]);
		$.ajax({url:"/spec/update",
			  data:formData,
			  processData : false,
			  contentType : false,
			  type:"post",
			  success:function(data){
				 if(data=="success"){
					 alert("提交成功");
					 $('#staticBackdropUpdate').modal('hide');
				 }else{
					 alert("保存失败");
				 }
			  }
			 })
	}
	// 弹出修改的窗口
	function openUpdateSpec(id){
		$(".form-group-proper").each(function(){
			$(this).remove();
		})
		addindex=0;
		$("#upspecName").val("")
		
		$.post("/spec/getSpec",{id:id},function(data){
			$("#upId").val(data.id)
			$("#upspecName").val(data.specName)
			addindex=0;
			for(var i=0;i<data.options.length;i++){
				var option=data.options[i];
				$("#updatespec").append('<div class="form-group form-group-proper">'+
	    				'<label for="inputAddress">属性值</label>'+
	    				'<input type="hidden" name="options['+addindex+'].id" value="'+option.id+'">' +
	    				'<input type="text" name="options['+addindex+'].optionName" value="'+option.optionName+'"class="form-control" id="inputAddress" >'+
	    				'<button class="btn btn-primary" onclick="$(this).parent().remove()">Delete</button>'+
	    				'</div>')
	    		addindex++;
			}
			
		});
		
		$("#staticBackdropUpdate").modal('show')
	}
	
	// 删除
	function delSec(id){
		if(confirm("您确认删除该条数据么？")){
			$.post("/spec/delSpec",{id:id},function(data){
				if(data="success"){
					alert("删除成功")
					refresh();
				}else{
					alert("删除失败")
				}
				
			});
		}else{
			return;
		}
	}
	
	// 批删
	function delBatch(){
		
		if($("[name=ids]:checked").length<=0){
			alert("没有数据被选中，不能删除")
			return;
		}
		// 组织删除的数据
		var delIds  = new Array();
		$("[name=ids]:checked").each(function(){
			delIds.push($(this).val());
		})
		
		if(confirm("您确认删除这些数据么？")){
			$.post("/spec/delSpecBatch",{ids:delIds},function(data){
				if(data="success"){
					alert("删除成功")
					refresh();
				}else{
					alert("删除失败")
				}
				
			});
		}else{
			return;
		}
	}
	
	
	function selectedAll(){
		var checked = $("#allSel").prop("checked")
		$("[name=ids]").each(function(){
				$(this).prop("checked",checked)
			}
		)
	}
	
	
	function selectedOne(){
		var allSelected = $("[name=ids]").length==$("[name=ids]:checked").length;
		$("#allSel").prop("checked",allSelected)
	}
	
	// 全选，反选，群不选
	function selAll(flag){
		
	 	if(flag==1){
			//全选
			$("[name=ids]").each(function(){
				$(this).prop("checked",true)
			}
			)
		}
		
		if(flag==2){
			//全不选
			$("[name=ids]").each(function(){
				$(this).prop("checked",false)
			})
		}
		if(flag==3){
			//反选
			$("[name=ids]").each(function(){
				var ch = !$(this).prop("checked")
				$(this).prop("checked",ch)
			}
			)
		} 
		// 判断是否所有的都被选中了
		var allSelected = $("[name=ids]").length==$("[name=ids]:checked").length;
		$("#allSel").prop("checked",allSelected)
		
	}
    // 查询
    function query(){
		var url="/spec/list?name="+$("#queryName").val();
		$("#main").load(url);
	}
	
	// 分页
	function goPage(page) {
		var url = "/spec/list?name="+$("#queryName").val()+'&page='+page;
		$("#main").load(url);
		
	}
	
	// 刷新  保留页码
	function refresh(){
		
		var url="/spec/list?name=${queryName}"+'&page=${pageInfo.pageNum}';
		$("#main").load(url);
	}
	//添加窗口的复位
	function resetAddForm(){
		$(".form-group-proper").each(function(){
			$(this).remove();
		})
		addindex=1;
		$("#specName").val("")
		
	}
	
	// 添加模态框显示成功的时间
	$('#staticBackdrop').on('shown.bs.modal', function (e) {
		resetAddForm();
	})
	
	// 添加模态框关闭的时间 
	$('#staticBackdrop').on('hidden.bs.modal', function (e) {
		refresh();
	})
	
	// 修改规格模态框
	$('#staticBackdropUpdate').on('hidden.bs.modal', function (e) {
		refresh();
	})
	
	// 提交数据
	function commitSpec(){
		var formData = new FormData($("#addspec")[0]);
		$.ajax({url:"/spec/add",
			  data:formData,
			  processData : false,
			  contentType : false,
			  type:"post",
			  success:function(data){
				 if(data=="success"){
					 alert("提交成功")
					 $('#staticBackdrop').modal('hide')
				 }else{
					 alert("保存失败")
				 }
				 
			  }
			  })
		
	}
</script>