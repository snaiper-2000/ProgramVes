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

<!--${result.dateResult}-->



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
    <tr>
                <td bgcolor="#87CEEB">4</td>
                <td bgcolor="#87CEEB">АВР-10кВ в ячейке №8</td>
                <td bgcolor="LawnGreen">Выполнено</td>
    </tr>
    <tr>
                <td bgcolor="#B0E0E6">5</td>
                <td bgcolor="#B0E0E6">ТУ В-35кВ ввода Т-1</td>
                <td id="s5"><script type="text/javascript">
                   if (${result.flag5} == false){
                        document.write('Выполнено');
                        document.getElementById("s5").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s5").style.backgroundColor = "Yellow";}
                </script></td>
    </tr>
    <tr>
                <td bgcolor="#87CEEB">6</td>
                <td bgcolor="#87CEEB">ТУ В-10кВ ввода T-1</td>
                <td id="s6"><script type="text/javascript">
                   if (${result.flag6} == false){
                        document.write('Выполнено');
                        document.getElementById("s6").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s6").style.backgroundColor = "Yellow";}
                </script></td>
    </tr>
    <tr>
                <td bgcolor="#B0E0E6">7</td>
                <td bgcolor="#B0E0E6">Соответствие положений устройств РПН Т-1 и анцапфного переключателя Т-2 на параллельную работу</td>
                <td id="s7"><script type="text/javascript">
                   if (${result.flag7} == false){
                        document.write('Выполнено');
                        document.getElementById("s7").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s7").style.backgroundColor = "Yellow";}
                </script></td>
    </tr>
    <tr>
                <td bgcolor="#87CEEB">8</td>
                <td bgcolor="#87CEEB">Проверить включенное положение  I СР-10кВ</td>
                <td id="s8"><script type="text/javascript">
                   if (${result.flag8} == false){
                        document.write('Выполнено');
                        document.getElementById("s8").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s8").style.backgroundColor = "Yellow";}
                </script></td>
    </tr>
    <tr>
                <td bgcolor="#B0E0E6">9</td>
                <td bgcolor="#B0E0E6">Проверить включенное положение  II СР-10кВ</td>
                <td id="s9"><script type="text/javascript">
                   if (${result.flag9} == false){
                        document.write('Выполнено');
                        document.getElementById("s9").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s9").style.backgroundColor = "Yellow";}
                </script></td>
    </tr>
    <tr>
                <td bgcolor="#87CEEB">10</td>
                <td bgcolor="#87CEEB">Включить СВ-10кВ</td>
                <td id="s10"><script type="text/javascript">
                   if (${result.flag10} == false){
                        document.write('Выполнено');
                        document.getElementById("s10").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s10").style.backgroundColor = "Yellow";}
                </script></td>
    </tr>
    <tr>
                <td bgcolor="#B0E0E6">11</td>
                <td bgcolor="#B0E0E6">Проверить включенное положение СВ-10кВ</td>
                <td id="s11"><script type="text/javascript">
                   if (${result.flag11} == false){
                        document.write('Выполнено');
                        document.getElementById("s11").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s11").style.backgroundColor = "Yellow";}
                </script></td>
    </tr>
    <tr>
                <td bgcolor="#87CEEB">12</td>
                <td bgcolor="#87CEEB">Отключить В-10кВ ввода Т-1</td>
                <td id="s12"><script type="text/javascript">
                   if (${result.flag12} == false){
                        document.write('Выполнено');
                        document.getElementById("s12").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s12").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">13</td>
                <td bgcolor="#B0E0E6">На ключ управление В-10кВ ввода Т-1 вывесить плакат "Не включать! Работают люди."</td>
                <td id="s13"><script type="text/javascript">
                   if (${result.flag13} == false){
                        document.write('Выполнено');
                        document.getElementById("s13").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s13").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">14</td>
                <td bgcolor="#87CEEB">Проверить отключенное положение В-10кВ ввода Т-1</td>
                <td id="s14"><script type="text/javascript">
                   if (${result.flag14} == false){
                        document.write('Выполнено');
                        document.getElementById("s14").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s14").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">15</td>
                <td bgcolor="#B0E0E6">Отключить ТР-10кВ и ШР-10кВ ввода Т-1</td>
                <td id="s15"><script type="text/javascript">
                   if (${result.flag15} == false){
                        document.write('Выполнено');
                        document.getElementById("s15").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s15").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">16</td>
                <td bgcolor="#87CEEB">Проверить отключенное положение ТР-10кВ, ШР-10кВ ввода Т-1</td>
                <td id="s16"><script type="text/javascript">
                   if (${result.flag16} == false){
                        document.write('Выполнено');
                        document.getElementById("s16").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s16").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">17</td>
                <td bgcolor="#B0E0E6">Отключить автомат ввода 0,23 кВ ТСН-1</td>
                <td id="s17"><script type="text/javascript">
                   if (${result.flag17} == false){
                        document.write('Выполнено');
                        document.getElementById("s17").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s17").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">18</td>
                <td bgcolor="#87CEEB">Проверить наличие напряжения С.Н.</td>
                <td id="s18"><script type="text/javascript">
                   if (${result.flag18} == false){
                        document.write('Выполнено');
                        document.getElementById("s18").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s18").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">19</td>
                <td bgcolor="#B0E0E6">Отключить В-35кВ ввода Т-1</td>
                <td id="s19"><script type="text/javascript">
                   if (${result.flag19} == false){
                        document.write('Выполнено');
                        document.getElementById("s19").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s19").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">20</td>
                <td bgcolor="#87CEEB">На ключ управления В-35кВ ввода Т-1 вывести плакат "Не включать! Работают люди"</td>
                <td id="s20"><script type="text/javascript">
                   if (${result.flag20} == false){
                        document.write('Выполнено');
                        document.getElementById("s20").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s20").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">21</td>
                <td bgcolor="#B0E0E6">Проверить отключенное положение В-35кВ ввода Т-1</td>
                <td id="s21"><script type="text/javascript">
                   if (${result.flag21} == false){
                        document.write('Выполнено');
                        document.getElementById("s21").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s21").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">22</td>
                <td bgcolor="#87CEEB">Проверить целостность колонок ТР-35кВ ввода Т-1</td>
                <td id="s22"><script type="text/javascript">
                   if (${result.flag22} == false){
                        document.write('Выполнено');
                        document.getElementById("s22").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s22").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">23</td>
                <td bgcolor="#B0E0E6">Кнопка блокировки ключа</td>
                <td id="s23"><script type="text/javascript">
                   if (${result.flag23} == false){
                        document.write('Выполнено');
                        document.getElementById("s23").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s23").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">24</td>
                <td bgcolor="#87CEEB">Снятие ключа</td>
                <td id="s24"><script type="text/javascript">
                   if (${result.flag24} == false){
                        document.write('Выполнено');
                        document.getElementById("s24").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s24").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">25</td>
                <td bgcolor="#B0E0E6">Разблокировать рычаг ТР-35кВ</td>
                <td id="s25"><script type="text/javascript">
                   if (${result.flag25} == false){
                        document.write('Выполнено');
                        document.getElementById("s25").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s25").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">26</td>
                <td bgcolor="#87CEEB">Отключить ТР-35кВ ввода Т-1</td>
                <td id="s26"><script type="text/javascript">
                   if (${result.flag26} == false){
                        document.write('Выполнено');
                        document.getElementById("s26").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s26").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">27</td>
                <td bgcolor="#B0E0E6">Проверить отключеное положение ТР-35кВ ввода Т-1</td>
                <td id="s27"><script type="text/javascript">
                   if (${result.flag27} == false){
                        document.write('Выполнено');
                        document.getElementById("s27").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s27").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">28</td>
                <td bgcolor="#87CEEB">Отключить Р-10кВ ТСН-1</td>
                <td id="s28"><script type="text/javascript">
                   if (${result.flag28} == false){
                        document.write('Выполнено');
                        document.getElementById("s28").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s28").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">29</td>
                <td bgcolor="#B0E0E6">Проверить отключеное положение Р-10кВ ТСН-1</td>
                <td id="s29"><script type="text/javascript">
                   if (${result.flag29} == false){
                        document.write('Выполнено');
                        document.getElementById("s29").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s29").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#87CEEB">30</td>
                <td bgcolor="#87CEEB">Отключить рубильник ввода 0,23кВ ТСН-1</td>
                <td id="s30"><script type="text/javascript">
                   if (${result.flag30} == false){
                        document.write('Выполнено');
                        document.getElementById("s30").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s30").style.backgroundColor = "Yellow";}
                </script></td>
     </tr>
     <tr>
                <td bgcolor="#B0E0E6">31</td>
                <td bgcolor="#B0E0E6">Снять оперативный ток с В-10кВ ввода Т-1: в ячейке №4 КРУН отключить автомат "АВ - Управление"</td>
                <td id="s31"><script type="text/javascript">
                   if (${result.flag31} == false){
                        document.write('Выполнено');
                        document.getElementById("s31").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s31").style.backgroundColor = "Yellow";}
                </script></td>
      </tr>
      <tr>
                <td bgcolor="#87CEEB">32</td>
                <td bgcolor="#87CEEB">Снять оперативный ток с В-35кВ ввода Т-1: в релейном шкафу Т-1 отключить автомат "АВ - Управление"</td>
                <td id="s32"><script type="text/javascript">
                   if (${result.flag32} == false){
                        document.write('Выполнено');
                        document.getElementById("s32").style.backgroundColor = "LawnGreen";
                   }
                   else{document.write('Ошибка');
                   document.getElementById("s32").style.backgroundColor = "Yellow";}
                </script></td>
      </tr>
</table>
</body>
</html>