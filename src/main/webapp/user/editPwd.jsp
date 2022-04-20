<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>��й�ȣ �缳���ϱ�</title>
<style type="text/css">
	section{width: 1200px; margin: auto;}
	
	#pwdCheck_Success{color: blue; display:none;}
	#pwdCheck_Fail{color: red; display: none;}
	
</style>
<script type="text/javascript">
  $(function(){
	  /*
	  ��й�ȣ ��ġ ���� üũ
	  */
	  $("#newPwd2").focusout(function(){
		  let pwd1 = $("#newPwd").val();
		  let pwd2 = $("#newPwd2").val();
		  
		  if(pwd1 != "" && pwd2 ==""){
			 null;
		  }else if(pwd1 != "" || pwd2 != ""){
			 if(pwd1 == pwd2){
				 $("#pwdCheck_Success").css("display","inline-block");
				 $("#pwdCheck_Fail").css("display","none");
				 return true;
			 }else{
				 $("#pwdCheck_Success").css("display","none");
				 $("#pwdCheck_Fail").css("display","inline-block");
				 return false;
				 $("#newPwd2").focus();
			 }	
		   }		  
	  })
	  
	  /*
	  ��й�ȣ ��ȿ�� üũ
	  */
	  $("#newPwd").focusout(function(){
			var isValidPwd = /^[a-zA-Z0-9]{8,20}$/;
			if( !isValidPwd.test($(this).val())){
				alert("��й�ȣ�� ����� ���ڸ� �����Ͽ� 8�ڸ� �̻� �ִ� 20�ڸ� ���Ϸ� �Է����ּ���");
				return false;
				$(".userPwd_input").focus();
			}
			return true;
		})
	  /*
	  ��й�ȣ �缳��
	  */
  })
  
</script>
</head>
<body>
<h1>��й�ȣ�� �缳�� ���ּ���</h1>
<section>
	<form>
		<table>
		  <tr>
       	     <th>��й�ȣ</th>
             <td><input type="password" name="pwd" size="50" id="newPwd" placeholder="���� ��ҹ���, ���ڸ� �����ؼ� 8�ڸ� �̻� �Է����ּ���"></td>
     	  </tr>
     	  <tr>
        	 <th>��й�ȣ Ȯ��</th>
     	     <td><input type="password" name="pwd2" size="50" id="newPwd2" placeholder="�ѹ� �� �Է����ּ���"></td>
     	  </tr><p>
     	  <tr>
	        <span id="pwdCheck_Success">��й�ȣ�� ��ġ�մϴ�</span>
	        <span id="pwdCheck_Fail">��й�ȣ�� ��ġ���� �ʽ��ϴ�</span>
	      </tr>
		</table>
		<div>
		  <input type="submit" id="updatePwdBtn" value="��й�ȣ �缳���ϱ�">
		</div>
	</form>
</section>
</body>
</html>