<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "conexion.Usuario" %>
    <%@ page import = "javax.servlet.http.HttpSession" %>
    
<!DOCTYPE html>
<html lang="en">
<%if(session.getAttribute("theNickName")!=null){ %>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css"
    rel="stylesheet" />

  <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"
    rel="stylesheet" >
    <link rel="stylesheet" href="css/date.css">
  <link rel="stylesheet" href="css/guardias.css">
  <link rel="stylesheet" href="css/format.css">
  <title>Guardias</title>
  <%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");
  %>
</head>

<body>
<jsp:include page="nav-admin.jsp"></jsp:include>
  <h1>Guardias</h1>
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
          <label for="javascript">2° periodo</label><br><br>
          <br><br>
        </form>
      </div>
      <%
      HttpSession se = request.getSession(true);
		int id_unidad = (int) se.getAttribute("id_uni_adm");
        ArrayList<Usuario> listUsu;
		listUsu = Usuario.listarUsuarios(id_unidad);	%>
      <div class="relacion">
        <h2>relación de servidores públicos que cubriran guardia</h2>
        
        <select name="autorizacion" id="autorizacion">
        <% for (Usuario u:listUsu){
    	//out.print("<option>"+u.getNombre()+"</option>");
    	
    	out.print('<'+"option value="+u.getUsuario_id()+'>'+u.getNombre()+"</option>");
    					} %>
          <option value="falta">Falta de puntualidad a la entrada</option>
          <option value="saab">Falta de asistencia</option>
          

        </select>
        <form method="post" id="dates">
    <label class="control-label" for="text">Selecciona las fechas para las guardias del usuario:</label>
    <div class="container_date">
      <div class="date datepicker3 container-calendar " id="newTratFechaInii">
        <input type="text" id="dates" value="" placeholder="CLIC AQUÍ Ó EN EL ICONO" required autocomplete="off"
          class="dates">
        <span class="input-group-addon manito-clic iconc">
          <i class="glyphicon glyphicon-calendar"></i>
        </span>
      </div>
    </div>

    <button type="button" name="clickea" onclick="validar ();"> clickea </button>

  </form>
        
        <button class="button">Agregar</button>

      </div>
    </section>
    <section class="img__section container">
      <figure class="img__container"><img src="assets/img/guardias.svg" alt="" class="puntualidad__img"></figure>
    </section>
  </main>
  <script type="text/javascript">
    function validar() {
      let valor = document.getElementById("dates")[0].value;

      if (valor != "") {
        console.log("no esta vacio");
        alert(valor)
      } else {
        alert('Vacío');
      }
    }

  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

  <!--Latest compiled and minified JavaScript-->

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>

  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.es.min.js"></script>

  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/language/es_ES.min.js"></script>
  <script src="js/datepicker.js"></script>
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>