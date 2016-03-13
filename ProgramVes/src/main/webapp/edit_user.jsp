<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Редактирование данных пользователя</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" media="screen" href="css/cssHome.css" >
</head>
<body>

<table height="100" bgcolor="#FFFFFF" cellpadding="0">
            <tr>
        <td class="style1" width="5%"><img src="img/ves.png"  width="120" height="100" /></td>
        <td class="style2" width="80%">Редактирование данных пользователя </td>
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
      <td class="style3" width="70%"><% if( request.getAttribute("message") != null ){ %>
           ${message}<% } %>
      </td>
    </tr>
   </table>
   
   Текущая сессия (для теста)<%=session.getId() %>
   <br>
   
   <table height="100" bgcolor="#FFFFFF" border="1" width="50%">
   <c:forEach items="${userDB}" var="user"> 
	<form action="EditUserUpdateServlet" method="post">
	
	<tr><td>Пользователь :</td> <td>Редактирование данных :</td></tr>
	<tr><td>ID: ${user.id} </td> <td bgcolor="red">Данные защищены от редактирования</td></tr>
	<tr><td>Фамилия: ${user.surname}</td> <td><input type="text" name="surname" value="${user.surname}"></td></tr>
	<tr><td>Имя: ${user.name}</td> <td><input type="text" name="name" value="${user.name}"></td></tr>
	<tr><td>Отчество: ${user.middleName}</td> <td> <input type="text" name="middleName" value="${user.middleName}"></td></tr>
	<tr><td>Логин: ${user.login}</td> <td><input type="text" name="login" value="${user.login}"></td></tr>
	<tr><td>Пароль: ${user.password}</td> <td><input type="text" name="password" value="${user.password}"></td></tr>
	<tr><td>Моб. телефон: ${user.mobileTelephone}</td> <td><input type="text" name="mobileTelephone" value="${user.mobileTelephone}"></td></tr>
	<tr><td>Электронная почта: ${user.email}</td> <td><input type="text" name="email" value="${user.email}"></td></tr>
	<tr><td>Дата регистрации: ${user.dateUserReg}</td> <td bgcolor="red">Данные защищены от редактирования</td></tr> 
    <tr><td></td>  <td><input type="submit" value="Сохранить"></td></tr>
    </form>
   </c:forEach> 
   </table>
   
<!-- <table height="100" bgcolor="#FFFFFF" border="1" width="30%">
   <c:forEach items="${userDB}" var="user"> 
   
   <form action="" method="post">
   <input type="text" name="surname" value="${user.surname}">
   <input type="text" name="name" value="${user.name}">
   <input type="text" name="middleName" value="${user.middleName}">
   <input type="text" name="login" value="${user.login}">
   <input type="text" name="password" value="${user.password}">
   <input type="text" name="mobileTelephone" value="${user.mobileTelephone}">
   <input type="text" name="email" value="${user.email}">
   <input type="text" name="dateUserReg" value="${user.dateUserReg}">
   <input type="submit" value="Сохранить">
   </form>
   </c:forEach> -->
</body>
</html>