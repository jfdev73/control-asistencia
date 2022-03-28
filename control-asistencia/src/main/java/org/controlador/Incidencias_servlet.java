package org.controlador;

import java.awt.image.BandCombineOp;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tesoreria.Incidencias;
import org.tesoreria.Percepcion;
import org.tesoreria.Usuario;

/**
 * Servlet implementation class Incidencias_servlet
 */
@WebServlet("/Incidencias_servlet")
public class Incidencias_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Incidencias_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("accion");
		System.out.println("ac: "+action);
		try {
			switch (action) {
			case "6": {		
				//System.out.println("entrando a la opcion 6");
				try {
					registrarIncidencia(request, response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			}
			case "5":{
				//System.out.println("entrando a la opcion 5");
				mostrarIncidencias(request, response);
				break;
			}
			
			
			case "7":{
				actualizarIncidenias(request,response,7);
				
				break;
			}
			case "8":{
				actualizarIncidenias(request,response,8);
				
			}
			case "9":{
				mostrarIncidenciasAd(request, response);
				
			}
			
			default:
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

	private void mostrarIncidenciasAd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/IncidenciasAdmin.jsp");
		ArrayList<Incidencias> incia = null;
		HttpSession session = request.getSession(true);
		int prueba = (int) session.getAttribute("idpercep");
		System.out.println("valooor: "+prueba);
		 String  perfill =  (String) session.getAttribute("perfil");
		 incia = Incidencias.MostrarIncidenciasAdmin(prueba, perfill);
		    
		    Percepcion p = Percepcion.getData(prueba);
		    p.getData(prueba);
		    
		    String clave_pl = p.getNumPlaza();
		    session.setAttribute("plaza", clave_pl);
		    
			/*for(Incidencias in:inci) {
				System.out.println("Folio: "+in.getFolio());
				System.out.println("Catalogo: "+in.getCatalogo_id());
				System.out.println("Fec: "+in.getFecha_justificacion());
				System.out.println("status: "+in.getStatus());
				if(in.getStatus()==1) {
					System.out.println("activo");
				}
				
			}*/
		    request.setAttribute("listainadmin", incia);
			dispatcher.forward(request, response);
	}

	private void actualizarIncidenias(HttpServletRequest request, HttpServletResponse response, int tipo) throws ParseException, ServletException, IOException, SQLException {
		
		System.out.println("Entrando al metodo actualizar");
		
		String o = request.getParameter("observacion");
		if(o==null) {
			o = " ";
			
		}
		System.out.println("valor de o: "+o);
		int id_justi = Integer.parseInt(request.getParameter("id"));
		System.out.println("id inci: "+id_justi);
		int status = 0;
		if(tipo==7) {
			status = 2;
		}else if(tipo==8) {
			status=3;
		}
		Incidencias.actualizarStatus(id_justi,status, o);
		mostrarIncidencias(request, response);
		// TODO Auto-generated method stub
		
	}

	private void mostrarIncidencias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//System.out.println("entrando al metodo");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Incidencias.jsp");
		ArrayList<Incidencias> inci;
		HttpSession session = request.getSession(true);
		int prueba = (int) session.getAttribute("idpercep");
		System.out.println("valooor: "+prueba);
		 String  perfill =  (String) session.getAttribute("perfil");
		
	    inci = Incidencias.MostrarIncidencias(prueba,perfill);
	    
	    
	    Percepcion p = Percepcion.getData(prueba);
	    p.getData(prueba);
	    
	    String clave_pl = p.getNumPlaza();
	    session.setAttribute("plaza", clave_pl);
	    
		/*for(Incidencias in:inci) {
			System.out.println("Folio: "+in.getFolio());
			System.out.println("Catalogo: "+in.getCatalogo_id());
			System.out.println("Fec: "+in.getFecha_justificacion());
			System.out.println("status: "+in.getStatus());
			if(in.getStatus()==1) {
				System.out.println("activo");
			}
			
		}*/
	    request.setAttribute("listain", inci);
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//Date date_d = null;

		
		
	}

	private void registrarIncidencia(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo de registro \n");
		
		boolean b=false;
		Date date_js=null, dateD=null,dateP_inicio=null, dateP_final=null;
		int error=0;
		int causa=0,tipo_causa=0;
		String datep_inicio = "";
		String datep_final= "";
		String tc = "";
		String c="";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Incidencias in = new Incidencias();
		
	
		String date_just = request.getParameter("date_just");
		if(date_just.isEmpty() || date_just.equals(null)) {
			
			error=1;
			request.setAttribute("errorjust", error);
			
		}else {
		System.out.println("fecha justificacion: "+date_just);
		
		java.util.Date util = formatter.parse(date_just);
		date_js = new java.sql.Date(util.getTime());
		}
		
		
		String h_inicio = request.getParameter("h_inicio");
		
		String h_final = request.getParameter("h_final");
		
		if(h_inicio.isEmpty() || h_final.isEmpty()) {
			error = 2;
			
			
		}else {
			String[] hi= h_inicio.split(":"); 
			String[] hf= h_final.split(":");
			int hin1 = Integer.parseInt(hi[0]);
			int hin2 = Integer.parseInt(hi[1]);
			int hf1 = Integer.parseInt(hf[0]);
			int hf2 = Integer.parseInt(hf[1]);
			System.out.println("hora inicio: "+h_inicio);
			System.out.println("hora final : "+h_final);
			/*System.out.println("primer numero 1: "+hin1);
			System.out.println("segundo numero: "+hin2);
			System.out.println("primer numero 2: "+hf1);
			System.out.println("segundo numero: "+hf2);*/
			if((hf1<hin1 || hin2>hf2) || (hf1==hin1 && hin2==hf2)) {
				System.out.println("hubo un error");
				error = 10;
				
			}
			
		}
		
		 String date_d= request.getParameter("dated");
		 datep_inicio= request.getParameter("datep_inicio");
		 datep_final= request.getParameter("datep_final");
		 
		 if(date_d.isEmpty()) {
			 if((datep_inicio.isEmpty()) || (datep_final.isEmpty()) || datep_inicio.equals(null) || datep_final.equals(null) ) {
			error=3;
			request.setAttribute("errorjust", error);
		 }
	}else {
	java.util.Date dated = formatter.parse(date_d);
	dateD = new java.sql.Date(dated.getTime());
	 System.out.println("fecha tipo dia: "+dateD);
		
	}
		
		if((datep_inicio.isEmpty()) || (datep_final.isEmpty()) || datep_inicio.equals(null) || datep_final.equals(null) ) {
			
			if(date_d.isEmpty()) {
			error=3;	
			request.setAttribute("errorjust", error);
				}
			}else {
				 java.util.Date datepi = formatter.parse(datep_inicio);
					dateP_inicio = new java.sql.Date(datepi.getTime());
				 System.out.println("fecha periodo inicio: "+dateP_inicio);
				 java.util.Date datepf = formatter.parse(datep_final);
					dateP_final = new java.sql.Date(datepf.getTime());
				 System.out.println("fecha tipo final: "+dateP_final);
				 
				 if(dateP_inicio.after(dateP_final)) {
					 
					 error = 7;
					 
				 }
			}
			
		
			
			
		
		
		//java.util.Date dateeP_inicio = formatter.parse(datep_inicio);
		//dateP_inicio = new java.sql.Date(dateeP_inicio.getTime());
		//System.out.println("fecha tipo dia: "+dateD);
		
		tc = request.getParameter("tipo_causa");
		System.out.println("tipoo causa:"+tc);
		if(tc==null) {error=5;}
		if(tc!=null) {
		if(tc.equals("7")  || tc.isEmpty()) {
			error=5;
			request.setAttribute("errorjust", error);
			
		}else {
			//tipo_causa = Integer.parseInt(tc);
			//System.out.println("tipo_causa: "+tipo_causa);
		}
			}
		
		String otros = "";
		otros = request.getParameter("razon");
		 c = request.getParameter("causa");
		 if(c!=null) {
		 if(c.equals("a")) {
			 error = 6;
			 
		 }
		 }
		 System.out.println("caaausa: "+c);
		 if(c==null || c =="a") {
			 c =  otros;
			 System.out.println("causa con valor otros: "+c);
			 if(c==null || c=="-") {
				 error = 6;
				 
			 }
			System.out.println("causa: "+c);
		 }
		 
		
		HttpSession session = request.getSession(true);
		int id_delegado = (int) session.getAttribute("id_delegado");
		//System.out.println("id del dele: "+id_delegado);
		int id_titular = (int) session.getAttribute("id_titular");
		//System.out.println("id del titu: "+id_titular);
		int id_usuario = (int)session.getAttribute("idpercep");
		//System.out.println("id_peer: "+id_usuario);
		//String archivo = request.getParameter("archivo");
		//System.out.println("archivo: "+archivo);
		request.setAttribute("errorjust", error);
		if(error==0) {
		 b = Incidencias.InsertarIncidencias(id_usuario,date_js, h_inicio, h_final, dateD, dateP_inicio, dateP_final, tc, c, id_titular, id_delegado);
			System.out.println("valor de b: "+b);
		}
		
		if(b) {
			request.setAttribute("mensaje", "Se agrego con exito");
			
			
		}
		//System.out.println("Valor de band: "+b);
		//response.sendRedirect("nuevaIncidencia.jsp");
		request.getRequestDispatcher("nuevaIncidencia.jsp").forward(request, response);
	}

}
