<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" 
	import="com.kitri.member.model.MemberDto"
	%>
<%
	String root = request.getContentType();
	MemberDto memberDto2 = (MemberDto) request.getAttribute("modify");
	if(memberDto2!=null){
%>

<script>
function modify(){
	if(document.getElementById("modipass").value  == "") {
		alert("��й�ȣ �Է�!");
		return;
	} else {
		document.modiform.action = "/bipbip1/member";
		document.modiform.submit();
	}
}
</script>
<div class="container" style="padding-top: 50px">
	<div class="col-lg-4"></div>
	<div class="col-lg-5">
		<div class="jumbotron" style="padding-top: 30px">
			<form name = "modiform" id = "modiform" method="post" action="">
			<input type="hidden" name="act" value="modify">
				<h3 style="text-align: center;">ȸ���������� ȭ��</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="���̵�"
						name="id" id= "id" value = "<%=memberDto2.getId() %>" maxlength="20" readonly="readonly">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="��й�ȣ"
						name="pass" id= "modipass" value = "<%=memberDto2.getPass() %>" maxlength="20">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="�̸�"
						name="name" id= "name" value = "<%=memberDto2.getName() %>" maxlength="20" readonly="readonly">
				</div>
				<div class="form-group" style="text-align: center;"></div>
				<div class="form-group">
					<input type="email" class="form-control" placeholder="�̸���"
						name="email" id= "email" value = "<%=memberDto2.getEmail() %>" maxlength="20">
				</div>
				<div class="form-group">
					<input type="tel" class="form-control" placeholder="����ó"
						name="phone" id= "phone"  value = "<%=memberDto2.getPhone() %>" maxlength="20">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="�ּ�"
						name="address1" id= "address2" value = "<%=memberDto2.getAddr1() %>" maxlength="20">
				</div>		
				<div class="form-group">
					<input type="text" class="form-control" placeholder="���ּ�"
						name="address2" id= "address2" value = "<%=memberDto2.getAddr2() %>" maxlength="20">
				</div>							
				<input type="submit" class="btn btn-primary form-control"
					value="ȸ����������" onclick="javascript:modify();">
			</form>
		</div>
	</div>
</div>
<% }else {
	response.sendRedirect(root+"/member?act=main");

} %>

