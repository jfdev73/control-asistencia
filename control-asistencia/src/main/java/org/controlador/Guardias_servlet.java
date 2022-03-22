package org.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class Guardias_servlet
 */
@WebServlet("/Guardias_servlet")
public class Guardias_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guardias_servlet() {
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
		System.out.println("act: "+action);
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
			MostrarGuardias(request, response);
			break;
		}
		default:
		}
			} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
	}

	private void MostrarGuardias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo guar");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Guardias.jsp");
		HttpSession session = request.getSession(true);
		int id_unidad = (int) session.getAttribute("id_uni_adm");
		
		ArrayList<Usuario> listUsu;
		listUsu = Usuario.listarUsuarios(id_unidad);
		for(Usuario u:listUsu) {
			System.out.println("nombre: "+u.getNombre());
			
			
			}
		
		request.setAttribute("listusuarios", listUsu);
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
