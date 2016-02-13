<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<% if( request.getAttribute("message") != null ){ %>
    ${message1}
<% } %>
Сессия Атрибут<%=session.getAttribute("user") %>
  <table>
  <form action="RegServlet" method="POST">
    <tr>
     <td>Фамилия</td>
     <td><input type="text" name="surname"></td>
    </tr>
    <tr>
     <td>Имя</td>
     <td><input type="text" name="name"></td>
    </tr>
    <tr>
     <td>Отчество</td>
     <td><input type="text" name="middleName"></td>
    </tr>
    <tr>
     <td>Логин</td>
     <td><input type="text" name="login"></td>
    </tr>
    <tr>
     <td>Пароль</td>
     <td><input type="text" name="password"></td>
    </tr>
    <tr>
     <td>Моб.тел.</td>
     <td><input type="text" name="mobileTelephone"></td>
    </tr>
    <tr>
     <td>Электронная почта</td>
     <td><input type="text" name="email"></td>
    </tr>
    <tr>
     <td><input type="submit" name="submit" value="Сохранить"></td>
    </tr>
  </form>  
  </table>


</body>
</html>