<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>

<html lang="en">
<%if(session.getAttribute("theNickName")!=null){ %>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/format.css">
  <link rel="stylesheet" href="css/home.css">
  <title>Home</title>
  <%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");
  %>
</head>

<body>
 <jsp:include page="nav-admin.jsp"></jsp:include>
  <main class="main">
    <h1 class="welcome__desk">Bienvenido</h1>
    <section class="main__contanier container">

      <section class="main__texts">
        <h1 class="welcome__head">Bienvenido </h1>
        <div class="view__main"><br>
          <figure class="welcome__img">
            <img src="assets/img/welcome.svg" alt="" class="welcome__picture">
          </figure>
          <h3 class="nombre">${nombre}</h3>
          <p class="about__paragraph">Subsecretaria de tesoreria</p>
          <p class="about__paragraph">${unidad}</p>
        </div>
        <br>
       <!--   <div class="main__fechas">
          <h3 class="title__vacaciones">Vacaciones</h3>
          <ul class="fechas">
            <li>Te restan 3 dias del primer periodo segunda etapa 2022</li>
            <li>Te restan 2 dias del segundo periodo 2021</li>
          </ul>
        </div>-->
      </section>


      <section class="main__img container">
        <figure class="vista__img">
          <img src="assets/img/imagen-main.svg" alt="" class="vista__svg">
        </figure>
      </section>
    </section>

  </main>
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>
