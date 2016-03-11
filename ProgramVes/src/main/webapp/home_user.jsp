<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<title>ВЭС Дата выполнения переключений</title>
<link rel="stylesheet" href="css/cssIndex.css"/>
</head>

<body>

<table height="100" bgcolor="#FFFFFF" cellpadding="0">
            <tr>
        <td class="style1" width="5%"><img src="img/ves.png"  width="120" height="100" /></td>
        <td class="style2" width="80%" >Дата выполнения переключений </td>
            </tr>
        </table>
        
        
        <table height="100" bgcolor="#8BB9C7" cellpadding="0">
            <tr>
        <td class="style3" width="47%" >Произведен вход в систему под логином: <b class="style4"><%=session.getAttribute("user") %></b></td>
        <!-- <td class="style4"><%=session.getAttribute("user") %></td>  -->    
        <td width="49%"><form action="OpenHomeServlet" method="POST">
            <input type="submit" class="style7" value="Главное меню">
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


<table height="100" bgcolor="#FFFFFF" border="1" width="30%">
<tr>
	<td>Дата выполнения переключений: <% if( request.getAttribute("message") != null ){ %>
    ${message}
    <% } %></td>
	</tr>
	<tr>
<core:forEach items="${resultDate}" var="Date">
	<tr>
	<td><form action="ResultUserServlet" method="get">
	    <!-- скрытое поле для передачи выбранной даты в Servlet -->
	    <input name="resultDate" type="hidden" value="${Date}">
        <input type="submit" value="${Date}">
        </form> 
    </td>
	</tr>
</core:forEach>
</table>

</body>
</html>