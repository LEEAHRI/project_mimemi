<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	span{font-size:9pt;}

</style>
 		<!--��Ʈ��Ʈ�� CSS CDN-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                
        <!--��Ʈ��Ʈ�� JS CDN-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        
        
        <script type="text/javascript" src="${path}/util/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

function checkValid() {
	var f = window.document.updateForm;
	if ( f.askTitle.value == "" ) {
		alert( "������ �Է��� �ּ���." );
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

<form name=updateForm method=post action="${path}/front?key=ask&methodName=updateAsk"  
onSubmit='return checkValid()' enctype="multipart/form-data">
    <input type="hidden" name="askNo" value="${askDto.askNo}" >
   <div>
   <table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2">
            <p align="center"><font size="3"><b>  �Խù� �����ϱ�</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <span >����</span>
           
        </td>
        <td>
         <textarea class="form-control" rows="1" name="askTitle" id="title" >${askDto.askTitle}</textarea>
        </td>
       
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <b><span >�� ��</span></b>
        </td>
        <td>
        <textarea class="form-control" rows="5" name="askContent" id="content" >${askDto.askContent}</textarea>
    	</td>
    </tr>
    <tr>
    	<td width="150" height="20" >
    		<span>
    			÷������
    		</span>
    	</td>
    	<td>	
    		<input type="file" name="askAttach" size="30">
			<p id="file-status">${askDto.askAttach}</p>
    	</td>
    
    </tr>
    
    
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span>
		<input type="submit" value="�����ϱ�"> <input type="reset" value="�ٽþ���"></span></b></td>
    </tr>
</table>
</div>
	
</form>
	<h3>��� ����</h3>
	<c:choose>
	<c:when test="${empty answerDto.repliesList}">
		<h5>��� ������ �����ϴ�.</h5>
	</c:when>
	<c:otherwise>
		<c:forEach items="${elec.repliesList}" var="reply">
			${reply.replyNum} / ${reply.replyContent} / ${reply.replyRegDate} / ${reply.parentModelNum} <br>
		</c:forEach>
	</c:otherwise>
</c:choose>

<hr>
<div align=right><span >&lt;<a href="${path}/board/ask2.jsp">����Ʈ�� ���ư���</a>&gt;</span></div>
</body>
</html>