<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

	span{font-size:9pt;}

</style>
<script type="text/javascript">

function sendUpdate(){
	document.requestForm.methodName.value ="updateForm";
	document.requestForm.submit();
}



function sendDelete(){
	if(document.requestForm.password.value==""){
		alert("��й�ȣ �Է��ϼ���.");
		document.requestForm.password.focus();
		return;
	}
	
	document.requestForm.methodName.value ="delete";
	document.requestForm.submit();
}

</script>
</head>
<body>
<h1>�󼼺��� �������Դϴ�.</h1>

<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
    <tr>
        <td width="1220" height="20" colspan="4" >
            <p align="center"><size="3"><b>
             �� ����</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span>�۹�ȣ</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span><b>${elec.modelNum}</b></span>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span>�ۼ���¥</span></b></p>
        </td>
        <td width="300" height="20">
        	<span ><b>${requestScope.ask.askRegdate}</b></span>
        </td>
        
    </tr>
    
    <tr>
		<td width="100" height="200" valign="top">
            <p align="right"><b><span>����</span></b></p>
        </td>
		<!-- �������� �� ������ �ѷ��� ���� ���๮��(\n)�� <br>�±׷� ��ȯ�� ���ڿ��� ������� �Ѵ�. -->
        <td width="450" height="200" valign="top" colspan="3">
        <span><b><pre>${requestScope.elec.description}</pre></b></span></td>
    </tr>
    
      <c:if test="${ask.askAttach!=null}">
       <tr>
        <td width="100" height="20">
            <p align="right"><b><span>÷�����ϸ�</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span><b>
        	<a href='${path}/downLoad?fileName=${ask.askAttach}'>
    			${ask.askAttach} 
      		</a>
      		  
        </b></span>
        </td> 
    </tr>
    </c:if>
    
   
   
    <form name="requestForm" method=post action="${path}/board/askupdate.jsp">
 
    
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
			<!-- ������ �ʿ��� �����͵��� hidden���� ���ܳ��� �� �����ͷ� �����ش�. -->
				<input type=hidden name="askNo" value="${ask.askNo}">
				<input type=hidden name="key" value="ask">
				<input type=hidden name="methodName" >
				<input type=hidden name="pageNo" value="${pageNo}" >
				<input type=button value="�����ϱ�" onClick="sendUpdate()">
				<input type=button value="�����ϱ�" onClick="sendDelete()">
    </form>
			
		</td>
    </tr>
</table>
</body>
</html>