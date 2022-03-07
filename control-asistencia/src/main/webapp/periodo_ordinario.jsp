<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/periodo_ordinario.css">
  <link rel="stylesheet" href="css/format.css">
  <title>vacaciones PO</title>
</head>

<body>
<jsp:include page="nav-admin.jsp"></jsp:include>
  <h1>Aviso de vacaciones de servidores públicos en periodo ordinario</h1>
  <main class="main">
    <section class="main__contanier container">
      <b for="" class="label__read">Dirección: </b><span class="servidor_publico">juan fernando
        miranda
        monroy</span> <br>
      <b for="" class="label__read">departamento: </b><span>4235252356236</span><br>
      <b for="" class="label__read">subdirección: </b><span>Unidad de Informática</span><br>
      <div class="form__container">
        <form action="#" class="form__incidencias">
          <p>Selecciona el periodo:</p><br>
          <input type="radio" id="html" name="fav_language" value="HTML">
          <label for="html">1° periodo primera etapa</label>
          <input type="radio" id="css" name="fav_language" value="CSS">
          <label for="css">1° periodo segunda etapa</label>
          <input type="radio" id="javascript" name="fav_language" value="JavaScript">
          <label for="javascript">2° periodo</label><br>
          <span>del </span><input type="date"> <span>al</span> </span><input type="date"><br>
        </form>
      </div>
      <div class="relacion">
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
        </select>
        <button>Agregar</button>

      </div>
    </section>
    <section class="img__section container">
      <figure class="img__container"><img src="assets/img/vacaciones.svg" alt="" class="puntualidad__img"></figure>
    </section>
  </main>
</body>

</html>