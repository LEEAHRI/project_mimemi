<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/header.jsp" />
<style type="text/css">
	
</style>
<script type="text/javascript">
	$(function(){
		$("#leaveBtn").click(function(){
			if("#inputPwd".val() != ${userPwd}){
				alert("��й�ȣ�� �ٸ��ϴ�.")
				return false;
			}
		})
	})
</script>
</head>
<body>
<h2>ȸ�� Ż��</h2>
<form action="${path}/front?key=user&methodName=pwdCheckForLeave" method="post">
	<input type="password" name="inputPwd" id="inputPwd" placeholder="����Ȯ���� ���� ��й�ȣ�� �Է����ּ���"><p>
	<button type="submit" id="leaveBtn">Ȯ��</button>
	
</form>
</body>
<jsp:include page="../common/footer.jsp"/>
</html>