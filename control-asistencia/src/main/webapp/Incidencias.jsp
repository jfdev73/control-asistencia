
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
  <title>Justificación de Incidencias</title>
 <%/* 
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");*/
  %>
</head>

<body>
<%SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");%>
  <jsp:include page="nav-admin.jsp"></jsp:include>
  <% 
  //ArrayList <Incidencias> incidenciasView = new ArrayList<Incidencias>();
  ArrayList<Incidencias> list = (ArrayList<Incidencias>) request.getAttribute("listain"); %>
  
  <h1>Aviso de Justificación de Incidencias en la puntualidad y asistencia</h1>
  <p><button class="button_agregar" ><a href="nuevaIncidencia.jsp?action=6" class="ancla">Nueva incidencia</a></button></p>
  <main class="main">
    
    <br> <br>
    <table width="90%" class="table_style">
    <thead>
    <tr> 
    <td>Folio</td>
    <td>Tipo</td>
    <td>Causa</td>
    <td>Fecha</td>
    <td>Status</td>
    <td>Observaciones</td>
    </tr>
    </thead>
    <tbody>
    <%String  perfill =  (String) session.getAttribute("perfil"); 
    if(perfill.equals("53")){
    	for (Incidencias i:list){
    		if(i.getStatus()==1){
    	out.print("<tr>"
        +"<td>"+i.getFolio()+"</td>"+
        "<td>"+i.getTipo_causa()+"</td>"+
        "<td>"+i.getCausa()+"</td>"+
        "<td>"+formatter.format(i.getFecha_justificacion())+"</td>"+
        "<td class='status'>"+i.getStatus()+"</td>"+
        		"<td class='status'>"+i.getObservaciones()+"</td>"+
        //out.print('<'+"option value="+u.getUsuario_id()+'>'+u.getNombre()+"</option>");
        		
        "<td>"+"<button class='butt aceptado'>"+'<'+"a class = 'ancla' href=Incidencias_servlet?accion="+7+"&id="+i.getJustificacion_id()+'>'+"Aceptar"+"</a>"+"</button>"+"</td>"+
        		"<td>"+"<button class='butt rechazado'>"+'<'+"a class = 'ancla' href=Incidencias_servlet?accion="+8+"&id="+i.getJustificacion_id()+'>'+"Rechazar"+"</a>"+"</button>"+"</td>"+
        "</tr>");}
    	
    }
    	}else{
    		for (Incidencias i:list){
    	    	out.print("<tr>"
    	        +"<td>"+i.getFolio()+"</td>"+
    	        "<td class='tipoc'>"+i.getTipo_causa()+"</td>"+
    	        "<td class='causa'>"+i.getCausa()+"</td>"+
    	        "<td>"+formatter.format(i.getFecha_justificacion())+"</td>"+
    	        "<td class='status'>"+i.getStatus()+"</td>"+
    	        		"<td class='status'>"+i.getObservaciones()+"</td>"+
    	        //out.print('<'+"option value="+u.getUsuario_id()+'>'+u.getNombre()+"</option>");
    	        "</tr>");
    	    	
    	    }
    		
    	}%>
    </tbody>
    
    </table>
  </main>
  <script type="text/javascript" src="js/status.js"></script>
  <script src="js/2.js"></script>
   <script src="js/app2.js"></script>
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>