<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();
String url = root+"/admin?act=main";
%>
<script type="text/javascript"> 
	alert("�α����� �ʿ��� �������Դϴ�.")
    location.href = "<%=url%>";
    </script>
<body>
<center>
<h1>
�߸��� url ���� �Դϴ�.<br>
�α����� �ʿ��� �������Դϴ�.
</h1>
</center>
</body>
