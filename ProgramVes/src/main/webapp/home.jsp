<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Добро пожаловать! <%=session.getAttribute("user") %>
<br>
Ваша Session <%=session.getId() %>
<br>
<td><a href="model/index.htm">Упражнение №1</a>
<br>
<!-- <td><a href="home_user.jsp">ТЕСТ! home_user.jsp.</a> -->
<form action="HomeUserServlet" method="POST">
<input type="submit" value="home_user.jsp">
</form> 




<form action="LogoutServlet" method="POST">
<input type="submit" value="EXIT">
</form> 

<br>

<a href="ResultServlet?
flag001=false&
flag002=false&
flag003=false&
flag005=false&
flag006=false&
flag007=false&
flag008=false&
flag009=false&
flag0010=false&
flag0013=false&
flag0014=false&
flag0017=false&
flag0018=false&
flag0019=false&
flag0020=false&
flag0021=false&
flag0023=false&
flag0024=true&
flag0027=false&
flag0028=false&
flag0030=false&
flag0031=true&
flag0032=true&
flag0033=false&
flag0034=false&
flag0035=false&
flag0036=false&
flag0037=false&
flag0038=false&
flag0039=false&
flag0040=false">Reg Param Servlet</a>


</body>
</html>