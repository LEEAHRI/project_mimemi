<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>

<script type="text/javascript">
 $(function(){
	 alert("${loginName}");
	alert("${loginUser}");
	alert("${loginUser.userId.userCouId}");
});

</script>
</head>
<body>
<div class="topBox">
	<div class="firstBox">
	  <div class="txt1"><strong>${loginName}</strong>�� �ݰ����ϴ�.</div>
	  <div class="txt2">�̹̹̿� �Բ��Ͻ��� ${loginUser.Regdate}�� �Ǿ����ϴ�.</div>
	</div>
	<div class="secondBox">
      <div class="point">���� ������</div>
      <a href="orderList.jsp">${loginUser.userPoint}</a>��
    </div>
    <div class="thirdBox">
      <div class="coupon">��� ������ ����</div>
      <a href="couponList.jsp">${loginUser.userId.userCouId}</a>��
    </div>
</div>
<div class="middleBox">
  <iframe src="calendar.jsp"></iframe>
</div>
<div class="bottomBox">
  <div class="noticeTitle">��������</div>
  <div class="noticeList">
    <!-- ���۽� -->
  </div>
</div>

</body>
</html>