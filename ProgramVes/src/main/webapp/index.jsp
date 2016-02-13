<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Авторизация</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<form method="POST" action="LoginServlet">
  <tr>
    <td>Введите логин:</td>
    <td><input type="text" name="login" value=""></td>
  </tr>
  <tr>
    <td>Введите пароль:</td>
    <td><input type="text" name="password" value=""></td>
  </tr>
  <tr>
    <td><input type="submit" name="submit" value="OK" ></td>
    <td><a href="http://localhost:8080/Ves/reg.jsp">Reg</a>
  </tr>
</form> 
</table>
<% if( request.getAttribute("message") != null ){ %>
    ${message}
<% } %>
</body>
</html>