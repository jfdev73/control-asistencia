<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/fperiodo_ordinario.css">
  <link rel="stylesheet" href="css/format.css">
  <title>vacaciones fuera del po</title>
</head>

<body>
<jsp:include page="nav-admin.jsp"></jsp:include>
  <h1>solicitud de vacaciones fuera del periodo ordinario</h1>
  <main class="main">
    <section class="main__contanier container">
      <b for="" class="label__read">Nombre del servidor público solicitante: </b><span class="servidor_publico">juan
        fernando
        miranda
        monroy</span> <br>
      <b for="" class="label__read">puesto funcional: </b><span>4235252356236</span><br>
      <b for="" class="label__read">clave del servidor público: </b><span>43636346</span><br>
      <b>No. de plaza: </b><span>36263636</span><br>
      <div class="form__container">
        <form action="#" class="form__incidencias">
          <p>Selecciona el periodo vacacional:</p><br>
          <input type="radio" id="html" name="fav_language" value="HTML">
          <label for="html">1° periodo primera etapa</label>
          <input type="radio" id="css" name="fav_language" value="CSS">
          <label for="css">1° periodo segunda etapa</label>
          <input type="radio" id="javascript" name="fav_language" value="JavaScript">
          <label for="javascript">2° periodo</label><br>
          <span>del </span><input type="date"> <span>al</span> </span><input type="date"><br>
          <label for="">observaciones:</label><br>
          <textarea id="subject" name="subject" placeholder="" style="height:200px"></textarea> <br>

        </form>
      </div>
    </section>
    <section class="img__section container">
      <figure class="img__container"><img src="assets/img/vacaciones_fpo.svg" alt="" class="puntualidad__img"></figure>
    </section>
  </main>
</body>

</html>