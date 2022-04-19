<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	iframe{border-style:none; width:100%; height:100%; }
</style>

<script type="text/javascript">
 $(function(){
	alert("${loginUser.userId}");
})
</script>
<script type="text/javascript">
  $(function(){
	  //��밡���� ����
	  $("#usableCp").ready(function selectCpByUserId(){
		  $.ajax({
			 url: "${path}/ajax",
			 type: "post",
			 dataType: "json",
			 data: {key:"coupon", methodName: "selectCpByUserId", userId: "${loginUser.userId}"}, //userId�� ���� ���� �ٲ�°�?
			 success: function(result){
				 //alert();
				 let text = 0;
				 $.each(result, function(index, item){
					 if(item.usercouUsable=="N"){
						 text += 1;
					 }
				 })
				 //alert(text);
				 $("#usableCp").text(text) //������.text()
			 },
			 error : function(result) {
					alert(err + " ���� �߻�!");
			}
		  })//ajax ����
	  })
	  selectCpByUserId();
  })
</script>


</head>
<body>
<div class="topBox">
	<div class="firstBox">
	  <div class="txt1"><strong>${loginName}</strong>�� �ݰ����ϴ�.</div>
	  <div class="txt2">�̹̹̿� �Բ��Ͻ��� �� �Ǿ����ϴ�.</div>
	</div>
	<div class="secondBox">
      <div class="point">���� ������</div>
      <a href="orderList.jsp"></a>��
    </div>
    <div class="thirdBox">
      <div class="coupon">��� ������ ����</div>
      <a href="couponList.jsp" id="usableCp"></a>��
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