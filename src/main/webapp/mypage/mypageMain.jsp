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
	
	// ����ں� ���� ��ȸ
	function selectCpByUserId() {
		$.ajax({
			url: "${path}/ajax",
			type: "post",
			dataType: "json",
			data: {key: "coupon", methodName: "selectCpByUserId"},
			success: function(result) {
				
				count = 0;
				$.each(result, function(index, item) {
					if(item.usercouUsable == "N")
					count++;
					
				})
				$("#usableCou").text(count);
				
			}, // ���� �޼ҵ�
			error : function(err) {
				alert(err + "\n������ �ҷ��� �� �����ϴ�.");
			} // ���� �޼ҵ�
		}) // ajax ����
	}
	selectCpByUserId();
	
	function selectRegdate(){
		const today = new Date();
		const regDate = new Date("${loginUser.userRegdate}");
		
		const diffDate = today.getTime() - regDate.getTime();
		
		const dateDays = Math.abs(diffDate / (1000*3600*24));
// 		alert(dateDays);
		
// 		alert(Math.floor(dateDays));
		var dateFrom = Math.floor(dateDays);
		document.getElementById("dateFrom").innerHTML= "�̹̹̿� �����Ͻ��� <strong>" + dateFrom + "</strong>�� �Ǿ����ϴ�.";
	}
	
	selectRegdate();
});

</script>
</head>
<body>
<div class="topBox">
	<div class="firstBox">
	  <div class="txt1"><strong>${loginName}</strong>�� �ݰ����ϴ�.</div>
	  <div class="txt2" id="dateFrom"></div>
	</div>
	<div class="secondBox">
      <div class="point">���� ������
      <a href="orderList.jsp">${loginUser.userPoint}</a>��</div>
    </div>
    <div class="thirdBox">
      <div class="coupon">��� ������ ����
      <a href="couponList.jsp" id="usableCou"></a>��</div>
    </div>
</div>
<table class="table table-bordered caption-top" id="deliCalendar">
		<caption>
			<img alt="" src="">
		</caption>
		<thead>
			<tr>
				<th>��</th>
				<th>ȭ</th>
				<th>��</th>
				<th>��</th>
				<th>��</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
</table>
<div class="bottomBox">
  <div class="noticeTitle">��������</div>
  <div class="noticeList">
    <!-- ���۽� -->
  </div>
</div>

</body>
</html>