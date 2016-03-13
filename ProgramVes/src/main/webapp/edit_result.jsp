<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Редактирование результатов переключений пользователя</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" media="screen" href="css/cssHome.css" >
</head>
<body>

<table height="100" bgcolor="#FFFFFF" cellpadding="0">
            <tr>
        <td class="style1" width="5%"><img src="img/ves.png"  width="120" height="100" /></td>
        <td class="style2" width="80%">Редактирование результатов переключений пользователя </td>
            </tr>
   </table>
   
   <table>
    <tr>
      
      <td class="style3" width="49%">Произведен вход в систему под логином: <b class="style4"><%=session.getAttribute("user") %></b></td>
      <td  width="49%"><form action="AdminHomeServlet" method="POST">
            <input type="submit" class="style7" value="Панель Администратора">
            </form></td>
      <td class="style5" width="2%"><form action="LogoutServlet" method="POST">
            <input type="submit" class="style5" value="EXIT">
            </form>   
      </td>
     </tr>
     <tr> 
      <td class="style3" width="70%"><% if( request.getAttribute("message") != null ){ %>
           ${message}<% } %>
      </td>
    </tr>
   </table>
   
   Текущая сессия (для теста)<%=session.getId() %>
   <br>
   
   <table height="100" bgcolor="#FFFFFF" border="1" width="30%">
<tr>
	<td>Дата выполнения переключений: 
    </td>
	</tr>
	<tr>
<c:forEach items="${resultDate}" var="Date">
	<tr>
	<td><form action="EditResultUserServlet" method="get">
	    <!-- скрытое поле для передачи выбранной даты в Servlet -->
	    <input name="resultDate" type="hidden" value="${Date}">
        <input type="submit" value="${Date}">
        </form> 
    </td>
    <td bgcolor="red"><a href="<c:url value="/EditResultDeleteServlet?Date=${Date}"/>">Удалить</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>