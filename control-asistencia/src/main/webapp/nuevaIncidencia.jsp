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
  <title>Justificación de Incidencias</title>
 <%/* 
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");*/
  %>
</head>

<body>
  <jsp:include page="nav-admin.jsp"></jsp:include>
  
  <h1>Aviso de Justificación de Incidencias en la puntualidad y asistencia</h1>
  <main class="main">
    <section class="main__contanier container">
      <b for="" class="label__read">Nombre del servidor público: </b><span class="servidor_publico">${nombre}</span> <br>
      <b for="" class="label__read">cct: </b><span>4235252356236</span><br>
      <b for="" class="label__read">clave de servidor público: </b><span>43636346</span><br>
      <b class="label__read">No. de plaza: </b><span>36263636</span><br>
      
      <form action="Incidencias_servlet?accion=6" method="post">
      <input type ="hidden" name = "accion" value ="6">
      <div class="form-group form__container">
      <label>FECHA</label>
      <input type="date" name="date_just"><br><br>
      <label>Horario o periodo de permiso</label><br>
      <span> de </span> <input type="time" name="h_inicio"><span> a </span> <input type="time" name="h_final"><br><br>
      <p>Selecciona la fecha por: </p>
      <label for="tipoFecha">Periodo</label>
    <input type="radio" id="periodo" name="tipoFecha" value="10">
     <label for="tipoFecha">Día</label>
    <input type="radio" id="dia" name="tipoFecha" value="11"><br>
     <div class="dia ocultar"><label></label> <input type="date" name="dated">
      </div>
      
      <div class="periodo ocultar"><label> Del </label> <input type="date" name="datep_inicio">
      <label> al </label> <input type="date" name="datep_final">
      </div>
        <label for="autorizacion" class="label__opc">Seleccione el tipo de causa: </label>
        <select name="tipo_causa" id="opcion" >
          <option value="7" selected disabled>Seleccione una opción</option>
          <option value="8">Por autorización del superior inmediato</option>
          <option value="9">No pudo registrar por</option>
          <option value="10">Licencias médicas</option>
          <option value="11">Licencias personales</option>
          <option value="12">Comisiones</option>
          <option value="13">Otros</option>
        </select>

      </div>

      <div class="form-group">
        <label for="no pudo" class="not_v label__opc">Seleccione la causa:</label>
        <select name="causa" id="causa" class="not_v">
          <option value="0">-</option>
        </select>
        <div class="otros">
          <textarea name="" id="" cols="30" rows="10" class="text__area txt_not"></textarea>
        </div>
        <input type="file" name="archivo"><br>
        
      </div>
      <b for="" >Elaboró: </b><span>4235252356236</span><br>
      <b for="">Autorizó: </b><span>43636346</span><br>
      <b >Vob.Bo.: </b><span>36263636</span><br>
      <input type="submit" class="button">
      </form>
    </section>
    <section class="img__section container">
      <figure class="img__container"><img src="assets/img/puntualidad.svg" alt="" class="puntualidad__img"></figure>
    </section>
  </main>
  <script src="js/1.js"></script>
   <script src="js/app2.js"></script>
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>