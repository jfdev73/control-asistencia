<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/incidencias.css">
  <link rel="stylesheet" href="css/format.css">
  <title>Justificaci�n de Incidencias</title>
</head>

<body>
  <jsp:include page="nav-admin.jsp"></jsp:include>
  
  <h1>Aviso de Justificaci�n de Incidencias en la puntualidad y asistencia</h1>
  <main class="main">
    <section class="main__contanier container">
      <b for="" class="label__read">Nombre del servidor p�blico: </b><span class="servidor_publico">juan fernando
        miranda
        monroy</span> <br>
      <b for="" class="label__read">cct: </b><span>4235252356236</span><br>
      <b for="" class="label__read">clave de servidor p�blico: </b><span>43636346</span><br>
      <b class="label__read">No. de plaza: </b><span>36263636</span><br>
      <!--<div class="form__container">
        <form action="#" class="form__incidencias">
          <label for="">por autorizaci�n del superior inmediato:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">Falta de puntualidad a la entrada</option>
            <option value="saab">Falta de asistencia</option>
            <option value="opel">Dias econ�micos
              <br><small>(hasta 14 al a�o a servidores publicos sindicalizados)</small>
            </option>
            <option value="audi">Retirarse entre horas</option>
            <option value="audi">Consulta m�dica</option>
            <option value="audi">Salida antes por autorizaci�n</option>
            <option value="opel">permiso por lactancia
              <br><small>(hasta 6 meses despu�s del parto)</small>
            </option>
          </select> <br>

          <label for="">No pudo registrar por:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">robo, extrav�o o deterioro de gafete/credencial</option>
            <option value="falta">Falla el�ctrica del reloj o lector �ptico</option>
          </select> <br>

          <label for="">licencias m�dicas:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">enfermedad no profesional</option>
            <option value="falta">riesgo profesional</option>
          </select> <br>

          <label for="">licencias personales:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">Por patrimonio</option>
            <option value="falta">Nacimiento de mi hijo</option>
            <option value="falta">Ex�men profesional</option>
            <option value="falta">Fallecimiento de familiar</option>
          </select> <br>

          <label for="">comisiones:</label>
          <select name="autorizacion" id="autorizacion">
            <option value="falta">Comisi�n de servicios</option>
            <option value="falta">Comisi�n sindical</option>
          </select> <br>

          <label for="">otros:</label><br>
          <label for="">motivo:</label>
          <textarea id="subject" name="subject" placeholder="" style="height:200px"></textarea> <br>
          <input type="submit" value="Enviar" class="submit">
        </form>
      </div>-->
      <div class="form-group form__container">
        <label for="autorizacion" class="label__opc">Seleccione el tipo de causa: </label>
        <select name="" id="opcion">
          <option value="0" selected disabled>Seleccione una opci�n</option>
          <option value="1">Por autorizaci�n del superior inmediato</option>
          <option value="2">No pudo registrar por</option>
          <option value="3">Licencias m�dicas</option>
          <option value="4">Licencias personales</option>
          <option value="5">Comisiones</option>
          <option value="6">Otros</option>
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
    </section>
    <section class="img__section container">
      <figure class="img__container"><img src="assets/img/puntualidad.svg" alt="" class="puntualidad__img"></figure>
    </section>
  </main>
  <script src="js/select.js"></script>
</body>

</html>