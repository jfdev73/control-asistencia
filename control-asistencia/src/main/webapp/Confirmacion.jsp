
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "org.tesoreria.Incidencias" %>
    <%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<%if(session.getAttribute("theNickName")!=null){ %>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/incidencias.css">
  <link rel="stylesheet" href="css/format.css">
  <link rel="stylesheet" href="css/table.css">
  <link rel="stylesheet" href="css/buttonStat.css">
  <title>Confirmacion</title>
 <%/* 
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");*/
  %>
</head>

<body>
<%SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");%>
  <jsp:include page="nav-admin.jsp"></jsp:include>
 
  
  <h1>Confirmación</h1>
  <%
  String accion = null;
   accion = request.getParameter("accion");
   String id = request.getParameter("id");
   out.println("accion: "+accion);
   out.println("\nid "+id);
  %>
  <main class="main">
  <%
	if(accion!=null){
  if( accion.equals("7")){ %>
    <div class="container_confirmacion">
    <form action="Incidencias_servlet?accion=<%=accion%>&id=<%=id%>" class="form_confirmacion" method="post">
    <!--  <input type="hidden" value="<%=accion%>" name ="accion">-->
    <h4>Aceptando Incidencia</h4>
    <p><label class="observaciones">Observaciones</label></p>
    <textarea rows="" cols="" name ="observacion" placeholder="Escribe alguna observación"></textarea>
    <input type="submit" class="button confirmar" value ="Confirmar">
    
    </form>
    
    </div>
    <%}else if(accion.equals("8")){%>
    <div class="container_confirmacion">
   <form action="Incidencias_servlet?accion=<%=accion%>&id=<%=id%>" class="form_confirmacion" method="post">
    <h4>Rechazando Incidencia</h4>
    <p><label class="observaciones" >Observaciones</label></p>
    <textarea rows="" cols="" name ="observacion" placeholder="Escribe alguna observación"></textarea>
    <input type="submit" class="button confirmar" value ="Confirmar">
    
    </form>
    
    </div>
  
	<% }}%>
   
  </main>
  <script type="text/javascript" src="js/status.js"></script>
  <script src="js/2.js"></script>
   <script src="js/app2.js"></script>
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>