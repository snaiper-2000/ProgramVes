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
<br>

<table height="100" bgcolor="#FFFFFF" border="1">
   <tr>
     <td width="10%" bgcolor="#87CEEB">№ операции</td>
     <td width="10%" bgcolor="#87CEEB">Хронология действий</td>
     <td width="10%" bgcolor="#87CEEB">Состояние действия</td>
   </tr>
   <tr>
     <td bgcolor="#B0E0E6">1</td>
     <td bgcolor="#B0E0E6">Одеть каску</td>
     <td id="s1"><script type="text/javascript">
                   if (${result.flag1} == false){
                        document.write('Выполнено');
                        document.getElementById("s1").style.backgroundColor = "LawnGreen";  
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s1").style.backgroundColor = "red";}
                </script> </td>
    </tr>
    <tr>
      <td bgcolor="#87CEEB">2</td>
      <td bgcolor="#87CEEB">Одеть диэлектрические боты</td>
      <td id="s2"><script type="text/javascript">
                   if (${result.flag2} == false){
                        document.write('Выполнено');
                        document.getElementById("s2").style.backgroundColor = "LawnGreen";  
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s2").style.backgroundColor = "red";}
                </script> </td>>
    </tr>
    <tr>
      <td bgcolor="#B0E0E6">3</td>
      <td bgcolor="#B0E0E6">Одеть диэлектрические перчатки</td>
      <td id="s3"><script type="text/javascript">
                   if (${result.flag3} == false){
                        document.write('Выполнено');
                        document.getElementById("s3").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s3").style.backgroundColor = "Yellow";}
                </script></td>
    </tr>
    <tr><td>4</td><td>Flag4</td><td></td></tr>


</table>
</body>
</html>