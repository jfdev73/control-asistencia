<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/nav.css">
  <title>Document</title>
</head>

<body>
 <%
 String  perfill =  (String) session.getAttribute("perfil");
 perfill = "54";
 String numP = "53";
 out.println("imprimiendo perfil:"+perfill);
 if(session.getAttribute("perfil").equals("53") && perfill != null) {
	 out.println("Son iguales");
  %> 
 <header><nav class="menu">
    <section class="menu__container">
      <figure class="container__home"><a href="Home.jsp"><img src="assets/img/home.svg" alt="" class="img__home"></a>
      </figure>
      <ul class="menu__links">
        <li class="menu__item"><a href="Incidencias.jsp" class="menu__link">Incidencias</a>

        </li>
        <li class="menu__item menu__item--show">
          <a href="#" class="menu__link prueba">Vacaciones <img src="assets/img/arrow.svg" alt="" class="menu__arrow"></a>
          <ul class="menu__nesting">
            <li class="menu__inside">
              <a href="Guardias.jsp" class="menu__link menu__link--inside center">Guardias</a>
            </li>
            <li class="menu__inside">
              <a href="periodo_ordinario.jsp
              " class="menu__link menu__link--inside">Periodo Ordinario</a>
            </li>
            <li class="menu__inside">
              <a href="fperiodo_ordinario.jsp" class="menu__link menu__link--inside">Fuera del periodo ordinario</a>
            </li>
          </ul>
        </li>
         <li class="menu__item"><a href="Incidencias.jsp" class="menu__link">Estatus</a>

        </li>
        <span class="menu__item menu__nombre">Juan Fernando Miranda Monroy</span>
        <li class="menu__item"><a href="Close?cerrar=1" class="menu__link">Salir</a>

        </li>

      </ul>
      <div class="menu__hamburguer">
        <img src="assets/img/menu.svg" alt="" class="menu__img">
      </div>


    </section>

  </nav></header>
  <%}else if(perfill.equals("54")){ %>
  <header><nav class="menu">
    <section class="menu__container">
      <figure class="container__home"><a href="Home.jsp"><img src="assets/img/home.svg" alt="" class="img__home"></a>
      </figure>
      <ul class="menu__links">
        <li class="menu__item"><a href="Incidencias.jsp" class="menu__link">Incidencias</a>

        </li>
        <li class="menu__item menu__item--show">
          <a href="#" class="menu__link prueba">Vacaciones <img src="assets/img/arrow.svg" alt="" class="menu__arrow"></a>
          <ul class="menu__nesting">
            <li class="menu__inside">
              <a href="fperiodo_ordinario.jsp" class="menu__link menu__link--inside">Fuera del periodo ordinario</a>
            </li>
          </ul>
        </li>
         <li class="menu__item"><a href="Incidencias.jsp" class="menu__link">Estatus</a>

        </li>
        <span class="menu__item menu__nombre">${nombre}</span>
        
        <li class="menu__item"><a href="login?accion=3" class="menu__link">Salir</a>

        </li>

      </ul>
      <div class="menu__hamburguer">
        <img src="assets/img/menu.svg" alt="" class="menu__img">
      </div>


    </section>

  </nav></header>
  <%} %>
<script src="js/app.js"></script>
</body>

</html>