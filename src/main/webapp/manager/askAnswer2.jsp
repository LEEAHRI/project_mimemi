<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>������ ��� ������</h2>
 <form name="writeNotice" method="post" action="${path}/front?key=answer&methodName=insertAnswerReply"
       onsubmit='return checkValid()' enctype="multipart/form-data">
		<div class="container" role="main">
			answerNo, askNo, answerContent, answerRegdate
			��۹�ȣ,�۹�ȣ,��۳���,�ۼ���¥
				
				<div class="mb-3">
					<label for="content">��� ����</label>
					<textarea class="form-control" rows="5" name="answer_content" id="content" placeholder="������ �Է��� �ּ���" ></textarea>
				</div>
				
     			<div >
     				<input type="submit" value="��۴ޱ�" />
				    <input type="button" value="��Ϻ���" onclick="location.href='../board/ask2.jsp'"/>
			</div>
		</div>
</form>
</body>
</html>