<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
   添加
</button>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
         <button type="button" class="btn btn-primary" onclick="addProp()"> 添加属性
         </button>
         
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
  				<div class="form-group">
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

<table class="table">
	
	<tr> 
		<th>id</th>
		<th>名称</th>
		<th>详情</th>
	</tr>
	<c:forEach items="${pageInfo.list}" var="spec">
		<tr>
			<td>${spec.id}</td>
			<td>${spec.specName}</td>
			<td>
				<c:forEach items="${spec.options}" var="op" >
					&nbsp;&nbsp; ${op.optionName}
				</c:forEach>
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
	
	function goPage(page) {
		alert(page);
		var url = "/spec/list?page=" + page;
		$("#main").load(url);
		
	}
	
	var addindex=1;
	function addProp(){
		$("#addspec").append('<div class="form-group">'+
    				'<label for="inputAddress">属性值</label>'+
    				'<input type="text" name="options['+addindex+'].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">'+
    				'<button class="btn btn-primary" onclick="$(this).parent().remove()">Delete</button>'+
    				'</div>')
    	addindex++;
	} 
	
	/**
	  提交数据	
	*/
	function commitSpec(){
		//addspec
		var formData = new FormData($("#addspec")[0]);
		$.ajax({url:"/spec/add",
			  dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
					alert(data);
			 		location = "/spec";	
			  	}
			  })
		
	}
</script>