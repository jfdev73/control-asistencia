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

import org.tesoreria.Guardias;
import org.tesoreria.Periodo;
import org.tesoreria.VacacionPO;

/**
 * Servlet implementation class Vacacionespo_servlet
 */
@WebServlet("/Vacacionespo_servlet")
public class Vacacionespo_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vacacionespo_servlet() {
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
		HttpSession session = request.getSession(true);
		if(session.getAttribute("theNickName")!=null){
			if(action.equals("5")) {
				System.out.println("Entrando al metodo mostrar");
				
				try {
					mostrarVacacionesPO(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}

	private void mostrarVacacionesPO(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo mostrar vacaciones");
		String pe = request.getParameter("p");
		int periodo = 0;
		if(pe!=null) {
			periodo = Integer.parseInt(pe);
		}
		ArrayList<VacacionPO> listv;
		HttpSession session = request.getSession(true);
		int prueba = (int) session.getAttribute("idpercep");
		int iduni = (int) session.getAttribute("id_uni_adm");
		System.out.println("unidadde: "+iduni);
		System.out.println("valooor: "+prueba);
		String  perfill =  (String) session.getAttribute("perfil");
	    listv = VacacionPO.mostrarVacacionesPO(iduni, perfill, iduni, periodo);
	    //ArrayList<Periodo> period;
	    //period = Periodo.getPeriodos();
	    
	    //request.setAttribute("periodos", period);
		request.setAttribute("listavacaciones", listv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/periodo_ordinario.jsp");
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
