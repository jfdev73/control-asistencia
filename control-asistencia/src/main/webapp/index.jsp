<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/login.css">
  <title>Document</title>
  <%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");
  %>
</head>

<body>
  <nav>

  </nav>

  <section class="side">
    <img src="assets/img/login.svg" alt="">
  </section>
  <section class="main">
    <section class="login-container">
      <h1 class="tittle">Control de asistencia</h1>
      <p>Subsecretaria de tesoreria</p>
      <form action="login?accion=1" class="login-form" method="post">
        <div>
          <label>Usuario:</label>
          <input type="text" placeholder="becario.fernando" class="form-control" name="nickuser" required>
          <br>
          <label>Contraseña:</label>
          <input type="password" placeholder="" class="form-control pass" name="password" required><br>
          <%
        Object e = session.getAttribute("error");
          if(e !=null ){
          String error = e.toString();
          
          switch(error){
          
          case "2":{
        	  out.println("<div class=msj>"+"<span class =alerta>¡Error! </span>"+"Credenciales inválidas"+"</div>");
        	  break; 
          }
          
          case "3":{
        	  out.println("<div class=msj>"+"<span class =alerta>¡Error! </span>"+"Campos vacíos"+"</div>");
        	  break;
        	  
          }
          case "5":{
        	  out.println("<div class=msj>"+ "<span class =alerta>¡Error! </span>" +"No se encuentra el usuario"+"</div>");
        	  break; 
        	  
        	  }
          
          
          }
          	}%>
          <input type="submit" value="Enviar" class="enviar">

        </div>
      </form>
    </section>

  </section>

</body>

</html>