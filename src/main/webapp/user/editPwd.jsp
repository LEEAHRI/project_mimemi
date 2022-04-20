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
	#notValidPwd{color: red; display: none;}
	
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
			 return false;
			 alert("��й�ȣ ��ġ ���θ� �������ּ���");
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
		  var pwd = $("#newPwd").val();
			
			var isNum = pwd.search(/[0-9]/g);
			var isLower = pwd.search(/[a-z]/g);
			var isUpper = pwd.search(/[A-Z]/g);
			
			if(pwd.length<8 || pwd.length>20){		//����üũ
				$("#notValidPwd").css("display","inline-block");
				return false;
				$(".userPwd_input").focus();
			}else if(pwd.search(/\s/) != -1 ){		//����üũ
				$("#notValidPwd").css("display","inline-block");
				return false;
				$(".userPwd_input").focus();
			}else if(isNum<0 || isLower<0 || isUpper<0){	//����,�ҹ��� ���� üũ
				$("#notValidPwd").css("display","inline-block");
				return false;
				$(".userPwd_input").focus();
			}else{
				$("#notValidPwd").css("display","none");
				return true;
			}
		})
	  /*
	  ��й�ȣ �缳��
	  */
	  $("#updatePwdBtn").click(function(){
		  $.ajax({
			  url: "${path}/ajax",
			  type: "post",
			  datatype: "text",
			  data: {key: "user", methodName: "updatePwd", userId: $("#userId").val(), userPwd: $("#newPwd").val()},
			  success: function(result){
				  alert(result);
				  location.href="${path}/user/login.jsp";
			  },
			  error: function(err){
				  alert(err);
			  }
			  
		  })
	  })
  })
  
</script>
</head>
<body>
<h1>��й�ȣ�� �缳�� ���ּ���</h1>
<section>
	<form action="${path}/front?key=user&methodName=updatePwd" method="post">
		<table>
		  <tr>
       	     <th>��й�ȣ</th>
             <td><input type="password" name="userPwd" size="50" id="newPwd" placeholder="���� ��ҹ���, ���ڸ� �����ؼ� 8�ڸ� �̻� �Է����ּ���"></td>
     	  </tr>
     	  <tr>
        	 <th>��й�ȣ Ȯ��</th>
     	     <td><input type="password" name="userPwd2" size="50" id="newPwd2" placeholder="�ѹ� �� �Է����ּ���">
     	     <span id="notValidPwd">��й�ȣ�� ���� ���� ���빮��, ���ҹ��ڿ� ���ڸ� �����Ͽ� 8�ڸ� �̻� �ִ� 20�ڸ� ���Ϸ� �Է����ּ���</span></td>
     	  </tr><p>
     	  <tr>
	        <span id="pwdCheck_Success">��й�ȣ�� ��ġ�մϴ�</span>
	        <span id="pwdCheck_Fail">��й�ȣ�� ��ġ���� �ʽ��ϴ�</span>
	      </tr>
		</table>
		<div>
		  <input type="submit" id="updatePwdBtn" value="��й�ȣ �缳���ϱ�">
		  <input type="hidden" value="${userId}" id="userId">
		  ${userId}
		</div>
	</form>
</section>
</body>
</html>