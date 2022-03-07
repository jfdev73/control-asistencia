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
  <header><nav class="menu">
    <section class="menu__container">
      <figure class="container__home"><a href="home.html"><img src="assets/img/home.svg" alt="" class="img__home"></a>
      </figure>
      <ul class="menu__links">
        <li class="menu__item"><a href="incidencias.html" class="menu__link">Incidencias</a>

        </li>
        <li class="menu__item menu__item--show">
          <a href="#" class="menu__link prueba">Vacaciones <img src="assets/img/arrow.svg" alt="" class="menu__arrow"></a>
          <ul class="menu__nesting">
            <li class="menu__inside">
              <a href="guardias.html" class="menu__link menu__link--inside center">Guardias</a>
            </li>
            <li class="menu__inside">
              <a href="periodo_ordinario.html
              " class="menu__link menu__link--inside">Periodo Ordinario</a>
            </li>
            <li class="menu__inside">
              <a href="fperiodo_ordinario.html" class="menu__link menu__link--inside">Fuera del periodo ordinario</a>
            </li>
          </ul>
        </li>
        <span class="menu__item menu__nombre">Juan Fernando Miranda Monroy</span>

      </ul>
      <div class="menu__hamburguer">
        <img src="assets/img/menu.svg" alt="" class="menu__img">
      </div>


    </section>

  </nav></header>
  
<script src="js/app.js"></script>
</body>

</html>