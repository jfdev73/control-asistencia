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
      <b for="" class="label__read">Nombre del servidor público: </b><span class="servidor_publico">j${nombre}</span> <br>
      <b for="" class="label__read">cct: </b><span>4235252356236</span><br>
      <b for="" class="label__read">clave de servidor público: </b><span>43636346</span><br>
      <b class="label__read">No. de plaza: </b><span>36263636</span><br>
      <!--<div class="form__container">
        <form action="#" class="form__incidencias">
          <label for="">por autorización del superior inmediato:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">Falta de puntualidad a la entrada</option>
            <option value="saab">Falta de asistencia</option>
            <option value="opel">Dias económicos
              <br><small>(hasta 14 al año a servidores publicos sindicalizados)</small>
            </option>
            <option value="audi">Retirarse entre horas</option>
            <option value="audi">Consulta médica</option>
            <option value="audi">Salida antes por autorización</option>
            <option value="opel">permiso por lactancia
              <br><small>(hasta 6 meses después del parto)</small>
            </option>
          </select> <br>

          <label for="">No pudo registrar por:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">robo, extravío o deterioro de gafete/credencial</option>
            <option value="falta">Falla eléctrica del reloj o lector óptico</option>
          </select> <br>

          <label for="">licencias médicas:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">enfermedad no profesional</option>
            <option value="falta">riesgo profesional</option>
          </select> <br>

          <label for="">licencias personales:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">Por patrimonio</option>
            <option value="falta">Nacimiento de mi hijo</option>
            <option value="falta">Exámen profesional</option>
            <option value="falta">Fallecimiento de familiar</option>
          </select> <br>

          <label for="">comisiones:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">Comisión de servicios</option>
            <option value="falta">Comisión sindical</option>
          </select> <br>

          <label for="">otros:</label><br>
          <label for="">motivo:</label>
          <textarea id="subject" name="subject" placeholder="" style="height:200px"></textarea> <br>
          <input type="submit" value="Enviar" class="submit">
        </form>
      </div> -->
      <div class="form-group form__container">
      <label>FECHA</label>
      <input type="date"><br><br>
      <label>Horario o periodo de permiso</label><br>
      <span>de </span> <input type="time"><span>a </span> <input type="time"><br><br>
      <p>Selecciona la fecha por: </p>
      <label for="tipoFecha">Periodo</label>
    <input type="radio" id="periodo" name="tipoFecha" value="10">
     <label for="tipoFecha">Día</label>
    <input type="radio" id="dia" name="tipoFecha" value="11"><br>
     <div class="dia ocultar"><label></label> <input type="date">
      </div>
      
      <div class="periodo ocultar"><label>Del</label> <input type="date">
      <label>al </label> <input type="date">
      </div>
        <label for="autorizacion" class="label__opc">Seleccione el tipo de causa: </label>
        <select name="" id="opcion">
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
        <select name="" id="causa" class="not_v">
          <option value="0">-</option>
        </select>
        <div class="otros">
          <textarea name="" id="" cols="30" rows="10" class="text__area txt_not"></textarea>
        </div>
        <input type="file"><br>
        <input type="submit" class="button">
      </div>
      <b for="" >Elaboró: </b><span>4235252356236</span><br>
      <b for="">Autorizó: </b><span>43636346</span><br>
      <b >Vob.Bo.: </b><span>36263636</span><br>
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