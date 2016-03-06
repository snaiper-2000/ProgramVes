<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
        <title>ВЭС Аутентификация</title>
        <link rel="stylesheet" href="css/cssIndex.css"/>
</head>
<body>

<section class="contenedorLogin">
            <form class="formulario" method="POST" action="LoginServlet">
                <h2><img src="img/ves.png" /></h2>
                <p>Волковысcкие электрические сети</p>
                <p><input type="text" name="login" placeholder="Логин"></p>
                <p><input type="password" name="password" placeholder="Пароль"></p>
             <!--    <h:messages infoStyle="color: blue;list-style:none;" errorStyle="color:red;list-style:none;"/>  -->
                <p2><% if( request.getAttribute("message") != null ){ %>
                      ${message}
                      <% } %>
                </p2>
                <section class="seccionBotones">
                    <table width="100%">
                    <tr>
                    <td width="50%">
                    <input class="seccionBotonesReg" type="submit" name="submit" value="Регистрация" formaction="reg.jsp" >
                    </td>
                    <td width="50%">
                    <input type="submit" name="submit" value="Войти" >
                    </td>
                    </table>
                </section>
            </form>
    </section>



<!-- <table>
<form method="POST" action="LoginServlet">
  <tr>
    <td>Введите логин:</td>
    <td><input type="text" name="login" value=""></td>
  </tr>
  <tr>
    <td>Введите пароль:</td>
    <td><input type="password" name="password" value=""></td>
  </tr>
  <tr>
    <td><input type="submit" name="submit" value="OK" ></td>
    <td><a href="http://localhost:8080/ProgramVes/reg.jsp">Reg</a>
  </tr>
</form> 
</table>
<%// if( request.getAttribute("message") != null ){ %>
    ${message}
<%// } %>  -->
</body>
</html>