<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<title>ВЭС Результаты переключений</title>
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
        <td class="style2" >Результаты переключений </td>
            </tr>
        </table>
        <table height="100" bgcolor="#8BB9C7" cellpadding="0">
            <tr>
        <td class="style4" >Произведен вход в систему под логином: <%=session.getAttribute("user") %></td>
        <!-- <td class="style4"><%=session.getAttribute("user") %></td>  -->    
        <td><form action="home.jsp" method="POST">
            <input type="submit" class="style7" value="Главное меню">
            </form></td>
        <td><form action="HomeUserServlet" method="POST">
            <input type="submit" class="style7" value="Дата выполнения переключений">
            </form></td>       
        <td class="style5"><form action="LogoutServlet" method="POST">
            <input type="submit" class="style5" value="EXIT">
            </form>   
        </td>
        </tr>
        <tr>
        <td>Текущая сессия (для теста)<%=session.getId() %></td>
        </tr>
</table>

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