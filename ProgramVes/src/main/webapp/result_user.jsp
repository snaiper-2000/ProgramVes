<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Результаты переключений пользователя</title>
</head>
<body>

Добро пожаловать! <%=session.getAttribute("user") %>
<br>
Ваша Session <%=session.getId() %>
<br>

<td><a href="result.jsp">ТЕСТ! Страничка результат.</a>


<a href="home.jsp">Домашняя страница </a>

<form action="LogoutServlet" method="POST">
<input type="submit" value="EXIT">
</form> 

<br>

</body>
</html>