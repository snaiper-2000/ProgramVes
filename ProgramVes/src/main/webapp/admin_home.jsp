<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Панель администратора</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" media="screen" href="css/cssReg.css" >
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
      <td class="style3" width="70%"><% if( request.getAttribute("message") != null ){ %>
           ${message}<% } %>
      </td>
      <td class="style4" width="10%"> <!-- <form action="index.jsp" method="POST">
                 <input type="submit" value="Авторизация">
           </form>  -->
           <form action="index.jsp" method="post">
           <li>
        	<button class="submit" type="submit">Авториация</button> 
           </li>
           </form>
      </td>
    </tr>
   </table>
   
Сессия Атрибут (для Теста)<%=session.getAttribute("user") %>

</body>
</html>