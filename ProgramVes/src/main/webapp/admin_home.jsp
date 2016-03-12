<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Панель администратора</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" media="screen" href="css/cssHome.css" >
</head>
<body>

<table height="100" bgcolor="#FFFFFF" cellpadding="0">
            <tr>
        <td class="style1" width="5%"><img src="img/ves.png"  width="120" height="100" /></td>
        <td class="style2" width="80%">Панель администратора </td>
            </tr>
   </table>
   
   <table>
    <tr>
      
      <td class="style3" width="99%">Произведен вход в систему под логином: <b class="style4"><%=session.getAttribute("user") %></b></td>
      <td class="style5" width="1%"><form action="LogoutServlet" method="POST">
            <input type="submit" class="style5" value="EXIT">
            </form>   
      </td>
      <td class="style3" width="70%"><% if( request.getAttribute("message") != null ){ %>
           ${message}<% } %>
      </td>
    </tr>
   </table>
   
Текущая сессия (для теста)<%=session.getId() %>
<br>
Пользователи:
<table height="100" bgcolor="#FFFFFF" border="1" width="30%">
	<tr> 
	  <td>ID</td>
	  <td>Фамилия</td>
	  <td>Имя</td>
	  <td>Отчество</td>
	  <td>Логин</td>
	  <td>Пароль</td>
	  <td>Моб. телефон</td>
	  <td>Электронная почта</td>
	  <td>Дата регистрации</td>
	</tr>
	<tr>

<c:forEach items="${users}" var="user">
	<tr>
	<td>${user.id}</td>
	<td>${user.surname}</td>
	<td>${user.name}</td>
	<td>${user.middleName}</td>
	<td>${user.login}</td>
	<td>${user.password}</td>
	<td>${user.mobileTelephone}</td>
	<td>${user.email}</td>
	<td>${user.dateUserReg}</td>
	<td>
	
	<a href="<c:url value="/EditUserServlet?userID=${user.id}"/>">Редактировать</a>
	
	<!-- <form action="EditUser" method="get">
	    <!-- скрытое поле для передачи выбранной даты в Servlet -->
	<!--    <input name="userID" type="hidden" value="${user.id}">
        <input type="submit" value="Редактировать профиль"> 
        -->
    </td>
	<td>Редактировать отчет переключений</td>
	<td>Удалить</td>

    
	</tr>
</c:forEach>
</table>

</body>
</html>