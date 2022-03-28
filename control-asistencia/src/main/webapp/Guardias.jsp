<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "org.tesoreria.Guardias" %>
<%@ page import="org.tesoreria.Usuario"%>
<%@ page import="org.tesoreria.Periodo"%>
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
  <link rel="stylesheet" href="css/table.css">
  <link rel="stylesheet" href="css/buttonStat.css">
  <title>Guardias</title>
  <%
  //response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");
  %>
</head>

<body>
 <% 
  //ArrayList <Incidencias> incidenciasView = new ArrayList<Incidencias>();
  ArrayList<Guardias> list = (ArrayList<Guardias>) request.getAttribute("listaformatos"); %>
<jsp:include page="nav-admin.jsp"></jsp:include>
  <h1>Guardias</h1>
  
  <%ArrayList<Periodo> listPeriodo; 
  listPeriodo = Periodo.getPeriodos();
  
  
  %>
  <button class="button_agregar"><a class="ancla" href="nuevaGuardia.jsp?action=6">Nuevo Formato Guardias</a></button>
  <%for (Periodo p : listPeriodo) {
		//out.print('<'+"option value="+u.getId_percepciones()+'>'+u.getNombre()+"</option>");
		out.print('<' + "button class='button_agregar button_periodos' value=" + p.getId_periodo() + '>' +
		'<'+"a class='ancla'" +"href="+"Guardias_servlet?accion=12&p="+p.getId_periodo()+'>'+ p.getPeriodo() + "  PERIODO  " + p.getEtapa() + " ETAPA"
		+ "</a>"+"</button>");
		//out.print('<'+"option value="+p.getId_periodo()+'>'+p.getPeriodo()+" PERIODO "+p.getEtapa()+" ETAPA"+"</option");
	} %>
  <main class="main">
  <table width="90%" class="table_style">
    <thead>
    <tr> 
    <td>Clave de Servidor</td>
    <td>Nombre</td>
    <td>Puesto</td>
    <td>Fechas</td>
    <!--  <td>Status</td>-->
   
    </tr>
    </thead>
    <tbody>
    <%String  perfill =  (String) session.getAttribute("perfil");
    if(perfill.equals("55")){
    	if(list!=null){
    for (Guardias j:list){
    	    	out.print("<tr>"
    	    	+"<td>"+j.getClave_servidor()+"</td>"
    	    	+"<td>"+j.getNombre()+"</td>"
    	    	+"<td>"+j.getPuesto()+"</td>"
    	        +"<td>"+j.getDias()+"</td>"+
    	       // "<td>"+"<button class='butt aceptado'>"+'<'+"a class = 'ancla' href=Guardias_servlet?accion="+7+"&id="+j.getId_guardias()+'>'+"Editar"+"</a>"+"</button>"+"</td>"+
        		"<td>"+"<button class='butt rechazado'>"+'<'+"a class = 'ancla' href=Guardias_servlet?accion="+8+"&id="+j.getId_percepciones()+"&p="+j.getPeriodo()+'>'+"Eliminar"+"</a>"+"</button>"+"</td>"+
    	    			
    	        //"<td>"+j.getNomS(j.getUsuario_id())+"</td>"+
    	    			
    	        //"<td>"+j.getNombre()+"</td>"+
    	        //"<td>"+j.getCausa()+"</td>"+
    	        //"<td>"+formatter.format(i.getFecha_justificacion())+"</td>"+
    	        //"<td class='status'>"+i.getStatus()+"</td>"+
    	        	//	"<td class='status'>"+i.getObservaciones()+"</td>"+
    	        //out.print('<'+"option value="+u.getUsuario_id()+'>'+u.getNombre()+"</option>");
    	        "</tr>");
    	    	
    	    }
    	}
    }else{  
    	for (Guardias j:list){
	    	out.print("<tr>"
	    	+"<td>"+j.getClave_servidor()+"</td>"
	    	+"<td>"+j.getNombre()+"</td>"
	    	+"<td>"+j.getPuesto()+"</td>"
	        +"<td>"+j.getDias()+"</td>"+

	        //"<td>"+j.getNomS(j.getUsuario_id())+"</td>"+
	    			
	        //"<td>"+j.getNombre()+"</td>"+
	        //"<td>"+j.getCausa()+"</td>"+
	        //"<td>"+formatter.format(i.getFecha_justificacion())+"</td>"+
	        //"<td class='status'>"+i.getStatus()+"</td>"+
	        	//	"<td class='status'>"+i.getObservaciones()+"</td>"+
	        //out.print('<'+"option value="+u.getUsuario_id()+'>'+u.getNombre()+"</option>");
	        "</tr>");
	    	
	    }
    	
    }%>
  </main>
    
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>