<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрация нового пользователя</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" media="screen" href="css/cssReg.css" >
</head>
<body>

  <table height="100" bgcolor="#FFFFFF" cellpadding="0">
            <tr>
        <td class="style1" width="5%"><img src="img/ves.png"  width="120" height="100" /></td>
        <td class="style2" width="80%">Регистрация нового пользователя </td>
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
  
<form class="contact_form" action="RegServlet" method="post" name="contact_form">
    <ul>
        <li>
             <h2>Форма Регистрации</h2>
             <span class="required_notification">* Поля обязательные для заполнения</span>
        </li>
        <li>
            <label for="surname">Фамилия:</label>
            <input type="text" name="surname"  placeholder="Рогацевич" required />
        </li>
		<li>
            <label for="name">Имя:</label>
            <input type="text" name="name"  placeholder="Дмитрий" required />
        </li>
        <li>
            <label for="middleName">Отчество:</label>
            <input type="text" name="middleName"  placeholder="Владимирович" required />
        </li>
        <li>
            <label for="login">Логин:</label>
            <input type="text" name="login"  placeholder="login" required />
        </li>
        <li>
            <label for="name">Пароль:</label>
            <input type="password" name="password"  placeholder="password" required />
        </li>
        <li>
            <label for="name">Мобильный телефон:</label>
            <input type="text" name="mobileTelephone"  placeholder="+375336226122" required pattern="[+][0-9]{12}" />
            <span class="form_hint"> Правильная форма ввода "+375336226122"</span>
        </li>
        <li>
            <label for="email">Email:</label>
            <input type="email" name="email" placeholder="name@yandex.ru" required />
            <span class="form_hint"> Правильная форма ввода "name@yandex.ru"</span>
        </li>
        <li>
        	<button class="submit" type="submit">Регистрация</button> 
        </li>
    </ul>
</form> 


</body>
</html>