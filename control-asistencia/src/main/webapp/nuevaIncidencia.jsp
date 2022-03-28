<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%if(session.getAttribute("theNickName")!=null){ %>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/incidencias.css">
  <link rel="stylesheet" href="css/format.css">
  <link rel="stylesheet" href="css/alerta.css">
  <title>Justificaci�n de Incidencias</title>
 <%/* 
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");*/
  %>
</head>

<body>
  <jsp:include page="nav-admin.jsp"></jsp:include>
  
  <h1>Aviso de Justificaci�n de Incidencias en la puntualidad y asistencia</h1>
  <%	Integer e = (Integer)(request.getAttribute("errorjust"));
  		if(e!=null){
  		switch(e){
  		case 3:{
  			out.println("<div class='msj>'"+"<span> �Error! </span>"+"Selecciona una fecha de permiso"+"</div>");
  			break;
  		}
  		
  		}
  		}
  		String mensaje = null;
      mensaje =(String)request.getAttribute("mensaje");
      if(mensaje !=null){
      out.println("<p class='alertac'>"+"�"+mensaje.toUpperCase()+"!"+"</p>");
      }
      %>
  <main class="main">
    <section class="main__contanier container">
      <b for="" class="label__read">Nombre del servidor p�blico: </b><span class="servidor_publico">${nombre}</span> <br>
      <b for="" class="label__read">cct: </b><span>4235252356236</span><br>
      <b for="" class="label__read">clave de servidor p�blico: </b><span>${claveservidor}</span><br>
      <b class="label__read">No. de plaza: </b><span>${plaza}</span><br>
      
      <form action="Incidencias_servlet?accion=6" method="post">
      <input type ="hidden" name = "accion" value ="6">
      <div class="form-group form__container">
      <label>FECHA</label>
      <input type="date" name="date_just" required><br><br>
      <label>Horario o periodo de permiso</label><br>
      <span> de </span> <input type="time" name="h_inicio" required><span> a </span> <input type="time" name="h_final" required><br><br>
      <p>Selecciona la fecha de permiso por: </p>
      <label for="tipoFecha">Periodo</label>
    <input type="radio" id="periodo" name="tipoFecha" value="10">
     <label for="tipoFecha">D�a</label>
    <input type="radio" id="dia" name="tipoFecha" value="11"><br>
     <div class="dia ocultar"><label></label> <input type="date" name="dated">
      </div>
      
      <div class="periodo ocultar"><label> Del </label> <input type="date" name="datep_inicio">
      <label> al </label> <input type="date" name="datep_final">
      </div>
        <label for="autorizacion" class="label__opc">Seleccione el tipo de causa: </label>
        <select name="tipo_causa" id="opcion" required>
          <option value="7" selected disabled>Seleccione una opci�n</option>
          <option value="Por autorizacion del superior inmediato">Por autorizaci�n del superior inmediato</option>
          <option value="No pudo registrar por">No pudo registrar por</option>
          <option value="Licencias medicas">Licencias m�dicas</option>
          <option value="Licencias personales">Licencias personales</option>
          <option value="Comisiones">Comisiones</option>
          <option value="Otros">Otros</option>
        </select>

      </div>

      <div class="form-group">
        <label for="no pudo" class="not_v label__opc">Seleccione la causa:</label>
        <select name="causa" id="causa" class="not_v" required>
          <option value="a">-</option>
        </select>
        <div class="otros">
          <textarea name="" id="" cols="30" rows="10" class="text__area txt_not"></textarea>
           
      
        </div>
        <!--  <input type="file" name="archivo"><br>-->
        
      </div>
      <!--<b for="" >Elabor�: </b><span>4235252356236</span><br>
      <b for="">Autoriz�: </b><span>43636346</span><br>
      <b >Vob.Bo.: </b><span>36263636</span><br>-->
      <input type="submit" class="button">
      </form>
    </section>
    <section class="img__section container">
      <figure class="img__container"><img src="assets/img/puntualidad.svg" alt="" class="puntualidad__img"></figure>
    </section>
  </main>
  <script src="js/2.js"></script>
   <script src="js/app2.js"></script>
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>