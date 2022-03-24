package org.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tesoreria.Guardias;
import org.tesoreria.Incidencias;
import org.tesoreria.Periodo;

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
		case "6": {	//Nueva guardia	
			
			
			insertarGuardia(request, response);
			/*try {
				RegistrarIncidencia(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			break;
			
		}
		case "5":{//Select Guardia
			
			MostrarGuardias(request, response);
			break;
		}
		case "7":{//Actualizar Guardia
			
			actualizarGuardias(request, response);
			break;
		}
		case "8":{//Eliminar Guardia
			
			eliminarGuardias(request, response);
			break;
		}
		case "9":{//listar usuarios
			
			MostrarGuardias(request, response);
			break;
		}
		case "10":{
			
			mostrarUsuariosGuardias(request, response);
			break;
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

	private void eliminarGuardias(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	

	private void actualizarGuardias(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo actualizar");
		int id_g = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id_guar", id_g);
	}

	private void insertarGuardia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		boolean band = false;
		HttpSession session = request.getSession(true);
		System.out.println("Etrando al metodo insertar");
		RequestDispatcher dispatcher = request.getRequestDispatcher("nuevaGuardia.jsp");
		String id_perc = request.getParameter("usuariosl");
		//request.setAttribute("idper",id_perc);
		int id = Integer.parseInt(id_perc);
		System.out.println("id seleccionado:"+id_perc);
		String fechas = request.getParameter("fechas");
		String [] vectF = fechas.split(",");
		System.out.println(vectF);
		int u = (int)session.getAttribute("id_uni_adm");
		//request.setAttribute("fechas",fechas);
		System.out.println("fechas seleccionada:"+fechas);
		System.out.println("fecha1: "+vectF[0]);
		System.out.println("fecha2: "+vectF[1]);
		//band = Guardias.insertarGuardia(id, fechas,u );
		//System.out.println("valor de b: "+band);
		dispatcher.forward(request, response);
	}

	private void mostrarUsuariosGuardias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*System.out.println("Entrando al metodo usurg");
		RequestDispatcher dispatcher = request.getRequestDispatcher("nuevaGuardia.jsp");
		dispatcher.forward(request, response);
		String id_perc = request.getParameter("usuariosl");
		request.setAttribute("idper",id_perc);
		System.out.println("id seleccionado:"+id_perc);
		String fechas = request.getParameter("fechas");
		request.setAttribute("fechas",fechas);
		System.out.println("id seleccionado:"+fechas);
		int idp = Integer.parseInt(id_perc);
		ArrayList<Guardias> listUsu = new ArrayList<>();
		
		listUsu.add(new Guardias( idp, fechas));
		System.out.println("tamaño del arreglo"+listUsu.size());
		for(Guardias gu:listUsu) {
	    	System.out.println("idd:"+gu.getId_percepciones());
	    	System.out.println("ddias:"+gu.getDias());
	    	
	    }*/
	}

	private void MostrarGuardias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo guar");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Guardias.jsp");
		ArrayList<Guardias> listg;
		HttpSession session = request.getSession(true);
		int prueba = (int) session.getAttribute("idpercep");
		int iduni = (int) session.getAttribute("id_uni_adm");
		System.out.println("unidadde: "+iduni);
		System.out.println("valooor: "+prueba);
		String  perfill =  (String) session.getAttribute("perfil");
	    listg = Guardias.mostrarGuardias(prueba, perfill,iduni);
	    for(Guardias gu:listg) {
	    	System.out.println("Nombre del o dela: "+gu.getNombre());
	    	System.out.println("holaaa:"+gu.getPuesto());
	    	System.out.println("dias de guardias: "+gu.getDias());
	    	
	    }
	    ArrayList<Periodo> period;
	    period = Periodo.getPeriodos();
	    
	    for(Periodo p:period) {
	    	System.out.println("idp: "+p.getId_periodo());
	    	System.out.println("fecha_inicio: "+p.getFecha_inicio());
	    	System.out.println("fecha_fin: "+p.getFecha_fin());
	    	
	    }
		/*HttpSession session = request.getSession(true);
		int id_unidad = (int) session.getAttribute("id_uni_adm");
		
		f
		ArrayList<Usuario> listUsu;
		listUsu = Usuario.listarUsuarios(id_unidad);
		for(Usuario u:listUsu) {
			System.out.println("nombre: "+u.getNombre());
			System.out.println("clave: " +u.getClave_servidor());
			System.out.println("puesto: "+u.getPuesto());
			
			
			}
		*/
	    request.setAttribute("periodos", period);
		request.setAttribute("listaformatos", listg);
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
