<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	span{font-size:9pt;}

</style>

<script type="text/javascript">

function checkValid() {
	var f = window.document.updateForm;
	if ( f.askTitle.value == "" ) {
		alert( "���̸��� �Է��� �ּ���." );
		f.askTitle.focus();
		return false;
	}
	
	if ( f.askContent.value == "" ) {
        alert( "������ �Է��� �ּ���." );
        f.askContent.focus();
        return false;
    }

	    
}



</script>
</head>
<body>
<h1>�Խù� �����ϱ� �������Դϴ�.</h1>

<form name=updateForm method=post action="${path}//board/ask.jsp" onSubmit="return checkValid()">
    <input type="hidden" name="key" value="elec" >
    <input type="hidden" name="methodName" value="update" >
    <input type='hidden' name='modelNum' value="${ask.modelNum}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2">
            <p align="center"><font size="3"><b>  �Խù� �����ϱ�</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <b><span >����</span></b>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="askTitle" size="30"
		 value="${askDto.askTitle}"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <b><span >�� ��</span></b>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<textarea name="askContent" cols="50" rows="10">${ask.askContent}</textarea></span></b></td>
    </tr>
    
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span>
		<input type="submit" value="�����ϱ�"> <input type="reset" value="�ٽþ���"></span></b></td>
    </tr>
</table>

</form>
<hr>
<div align=right><span >&lt;<a href="${path}/board/ask2.jsp">����Ʈ�� ���ư���</a>&gt;</span></div>
</body>
</html>