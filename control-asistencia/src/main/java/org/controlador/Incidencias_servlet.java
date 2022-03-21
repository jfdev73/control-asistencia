package org.controlador;

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

import conexion.Usuario;

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
				System.out.println("entrando a la opcion 6");
				/*try {
					RegistrarIncidencia(request, response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				break;
				
			}
			case "5":{
				System.out.println("entrando a la opcion 5");
				MostrarIncidencias(request, response);
				break;
			}
			default:
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
	
	

	private void MostrarIncidencias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("entrando al metodo");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Incidencias.jsp");
		ArrayList<Incidencias> inci;
		HttpSession session = request.getSession(true);
		int prueba = (int) session.getAttribute("idpercep");
		System.out.println("valooor: "+prueba);
	    inci = Incidencias.MostrarIncidencias(prueba);
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

	private void CrearIncidencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//Date date_d = null;

		
		
		
		
		
		/*
		
		
		
		
		String date_just = request.getParameter("date_just");
		System.out.println("fecha: "+date_just);
		String h_inicio = request.getParameter("h_inicio");
		System.out.println("fecha: "+h_inicio);
		String h_final = request.getParameter("h_final");
		System.out.println("h_final: "+h_final);
		
		 String date_d= request.getParameter("dated");
		System.out.println("fecha tipo dia: "+date_d);
		System.out.println("date: "+formatter.format(date_d));
		
		datep_inicio= request.getParameter("datep_inicio");
		System.out.println("fecha_periodo_inicio: " +datep_inicio);
		
		 datep_final= request.getParameter("datep_final");
		System.out.println("fecha_periodo_final: "+datep_final);
		String tipo_causa= request.getParameter("tipo_causa");
		System.out.println("tipo_causa: "+tipo_causa);
		String causa= request.getParameter("causa");
		System.out.println("causa: "+causa);
		
		String archivo = request.getParameter("archivo");
		System.out.println("archivo: "+archivo);
		
		
		
		if(datep_inicio.equals("")) {
			System.out.println("datep inicio esta vacio");
			
		}else {
			System.out.println("No es nulo");
		}*/
		
	}

	private void RegistrarIncidencia(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo de registro \n");
		
		
		String datep_inicio = null;
		String datep_final= null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		Incidencias in = new Incidencias();
		
		String date_just = request.getParameter("date_just");
		
		Date date_js, dateD,dateP_inicio, dateP_final;
		java.util.Date util = formatter.parse(date_just);
		date_js = new java.sql.Date(util.getTime());
		

		String h_inicio = request.getParameter("h_inicio");
		System.out.println("fecha: "+h_inicio);
		String h_final = request.getParameter("h_final");
		System.out.println("h_final: "+h_final);
		
		 String date_d= request.getParameter("dated");
			java.util.Date dated = formatter.parse(date_d);
			dateD = new java.sql.Date(dated.getTime());
		 System.out.println("fecha tipo dia: "+dateD);

		datep_inicio= request.getParameter("datep_inicio");
		
		//java.util.Date dateeP_inicio = formatter.parse(datep_inicio);
		//dateP_inicio = new java.sql.Date(dateeP_inicio.getTime());
		System.out.println("fecha tipo dia: "+dateD);
		System.out.println("fecha_periodo_inicio: " +datep_inicio);
		
		 datep_final= request.getParameter("datep_final");
		System.out.println("fecha_periodo_final: "+datep_final);
		String tipo_causa= request.getParameter("tipo_causa");
		System.out.println("tipo_causa: "+tipo_causa);
		String causa= request.getParameter("causa");
		System.out.println("causa: "+causa);
		
		String archivo = request.getParameter("archivo");
		System.out.println("archivo: "+archivo);
		
		
		
		if(datep_inicio.equals("")) {
			System.out.println("datep inicio esta vacio");
			
		}else {
			System.out.println("No es nulo");
		}
		boolean b = in.InsertarIncidencias(date_js, dateD );
		System.out.println("Valor de band: "+b);
		
	}

}
