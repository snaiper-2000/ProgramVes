<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Результат</title>
</head>
<body>
СтраницаРезультат.
<br>
Добро пожаловать! <%=session.getAttribute("user") %>
<br>
Ваша Session <%=session.getId() %>
<br>





<form action="LogoutServlet" method="POST">
<input type="submit" value="EXIT">
</form> 
<br>
<form action="home.jsp">
      <input type="submit" value="Home">
</form>


<table border="1">
<tr><td>Колонка 1</td><td>Колонка 2</td><td>Колонка 3</td></tr>
<tr><td>1</td><td>Flag1</td><td>${result.flag1}</td></tr>
<tr><td>2</td><td>Flag2</td><td>${result.flag2}</td></tr>
<tr><td>3</td><td>Flag3</td><td>${result.flag3}</td></tr>
<tr><td>4</td><td>Flag4</td><td>${result.flag4}</td></tr>

</body>
</html>