<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>ȸ������ :: �̹̹�</title>
	<jsp:include page="../common/header.jsp"/>
	<style>
		div.topBox {width: 800px; margin: 100px auto; padding: 50px 0; text-align: center; border: 2px solid #dddddd; }
		.topBox h5 {color: #777777; margin:40px;}
	</style>
</head>
<body>
	<div class="topBox">
		<h1>ȸ������ �Ϸ�!</h1>
		<h5>
			�̹̹̿� �����Ͻ� ���� �������� ȯ���մϴ�<br>
			������ ���� ���ɰ� �̿� ��Ź�����
		</h5>
		<div class="btmBox">
			<a href="${path}/index.jsp" class="btn btn-outline-dark shadow-none">Ȯ��</a>
			<a href="${path}/user/login.jsp" class="btn btn-outline-dark shadow-none">�α����ϱ�</a>
		</div>
	</div>
</body>
<jsp:include page="../common/footer.jsp"/>
</html>