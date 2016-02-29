<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<title>ВЭС Главное меню</title>
<link rel="stylesheet" href="/ProgramVes/main/resources/css/cssHome.css"/>
<style>
   body
{
    background-color: #8BB9C7;
    font-family: sans-serif;
}
  
.style1
{
    
   vertical-align:top 
}

.style2
{
   font-family: Arial, Helvetica, sans-serif; 
   vertical-align:middle; 
   font-size: 180%;
   text-align:  center;
   
}

.style3
{
    
   color:blue;
}

.style4
{
    
   color:red;
}

.style5
{
   width:60px;
   height:40px;
   color:red; 
}

.style6
{
   font-size: 200%;
   border-bottom: 2px solid maroon;
   font-weight: normal;
   padding-bottom: 5px; 
}

.style7
{
   height:40px;
   color:red; 
}
  </style>
</head>
<body>

<table height="100" bgcolor="#FFFFFF" cellpadding="0">
            <tr>
        <td class="style1"><img src="img/ves.png"  width="120" height="100" /></td>
        <td class="style2" >Программа подготовки оперативно-ремонтного персонала по обслуживанию оборудования подстанций ВЭС </td>
            </tr>
        </table>
        
        <table height="100" bgcolor="#8BB9C7" cellpadding="0">
            <tr>
        <td class="style3" width="47%">Произведен вход в систему под логином: <b class="style4"><%=session.getAttribute("user") %></b></td>
       <!--  <td class="style4" width="2%"><%=session.getAttribute("user") %></td>     -->
        <td width="49%"><form action="HomeUserServlet" method="POST">
            <input type="submit" class="style7" value="Посмотреть результаты предыдущих переключений">
            </form></td>  
        <td class="style5" width="2%"><form action="LogoutServlet" method="POST">
            <input type="submit" class="style5" value="EXIT">
            </form>   
        </td>
        </tr>
        <tr>
        <td>Текущая сессия (для теста)<%=session.getId() %></td>
        </tr>
</table>

        <p class="style6">Обучение</p>
        <p><a href="model/index.htm">Подстанция 35 кВ. Задание: Отключить Т1.</a></p>
        
   

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