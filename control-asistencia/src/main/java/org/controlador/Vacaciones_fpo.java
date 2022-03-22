package org.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vacaciones_fpo
 */
@WebServlet("/Vacaciones_fpo")
public class Vacaciones_fpo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vacaciones_fpo() {
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
		
			switch (action) {
			case "6": {		
				System.out.println("entrando a la opcion 6");
				
					registrarVacacionFPO(request, response);
				
				break;
				
			}
			case "5":{
				System.out.println("entrando a la opcion 5");
				mostrarVacacionFPO(request, response);
				break;
			}
			
			
			case "7":{
				//actualizarIncidenias(request,response,7);
				break;
			}
			case "8":{
				//actualizarIncidenias(request,response,8);
				
			}
			default:
				
			}
			
		
	}

	private void mostrarVacacionFPO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entrando a la vacacion");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/fperiodo_ordinario.jsp");
		
		dispatcher.forward(request, response);
	}

	private void registrarVacacionFPO(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
