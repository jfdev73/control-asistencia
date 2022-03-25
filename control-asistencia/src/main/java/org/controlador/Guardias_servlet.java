package org.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

	private void eliminarGuardias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo eliminar");
		int id= Integer.parseInt(request.getParameter("id"));
		boolean good = Guardias.deleteGuardia(id);
		//System.out.println("la eliminacion fue :"+good);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/Guardias.jsp");
		//dispatcher.forward(request, response);
		if(good) {
			response.sendRedirect("Guardias_servlet?accion=5");
			//MostrarGuardias(request, response);
		}
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
		//String [] vectF = fechas.split(",");
		//System.out.println(vectF);
		int u = (int)session.getAttribute("id_uni_adm");
		//request.setAttribute("fechas",fechas);
		System.out.println("fechas seleccionada:"+fechas);
		boolean exist = Guardias.getGuardia(id);
		if(exist) {
			System.out.println("El usuario ya existe");
			request.setAttribute("existe",exist);
			
		}else {
			
			boolean insertado = Guardias.insertarGuardia(id, fechas, u);
			if(insertado) {
				request.setAttribute("insertado", insertado);
				getVacaciones(fechas);
			}
			
		}
		//System.out.println("fecha1: "+vectF[0]);
		//System.out.println("fecha2: "+vectF[1]);
		//band = Guardias.insertarGuardia(id, fechas,u );
		//System.out.println("valor de b: "+band);
		dispatcher.forward(request, response);
	}

	private void getVacaciones(String gd) {
		LocalDate d = LocalDate.parse("2021-04-12");
		//System.out.println("diaaa: "+d);
		//String ddd = d.format(DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy"));
		//System.out.println("prueba: "+ddd);
		//d = d.plusDays(1);
		
		//System.out.println("fecha add: "+d);
        //Period periodo = Period.ofDays(1);
        ArrayList<String> cad = new ArrayList<String>();
       for(int ii = 0;ii<5;ii++) {
    	   //cad.add(d.plusDays(ii).format(DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy")));
    	   cad.add(d.plusDays(ii).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    	   
    	   //fechas.add(f);
       }
       
       
       System.out.println(cad);
       ArrayList<String> vacaciones= new ArrayList<String>();
       ArrayList<String> guardias= new ArrayList<String>();
       String v="";
       String guob ="";
       
       //String fechasEjemplo = "12/04/2021,13/04/2021";
       String fechasEjemplo = gd;
		System.out.println("fechasejemplo: "+fechasEjemplo);
		String[] arrayOfInts = fechasEjemplo.split(",");
        for (int k=0 ; k <cad.size();k++) {
     	   boolean esGuardia = true;
     	   for (int j=0 ; j <arrayOfInts.length;j++) {
     		   //System.out.println("valor" + arrayOfInts[j]);
     		   if (arrayOfInts[j].equals(cad.get(k))) {
     			   System.out.println("vaciones " + arrayOfInts[j]);
     			   vacaciones.add(arrayOfInts[j]);
     			   esGuardia = false;
     			   v += arrayOfInts[j] + "," ;
     		   }
     		   
     	   }
     	   if (esGuardia) {
     	   System.out.println("guardia " + cad.get(k));
     	   guardias.add(cad.get(k));
     	   guob += cad.get(k) + ",";
     	   }
     	   
        }
        System.out.println(v);
        System.out.println(guob);
        
		
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
	    /*for(Guardias gu:listg) {
	    	System.out.println("Nombre del o dela: "+gu.getNombre());
	    	System.out.println("holaaa:"+gu.getPuesto());
	    	System.out.println("dias de guardias: "+gu.getDias());
	    	
	    }*/
	    ArrayList<Periodo> period;
	    period = Periodo.getPeriodos();
	    /*for(Periodo p:period) {
	    	System.out.println("idp: "+p.getId_periodo());
	    	System.out.println("fecha_inicio: "+p.getFecha_inicio());
	    	System.out.println("fecha_fin: "+p.getFecha_fin());
	    	//System.out.println("fecha_fin: "+p.getFecha_fin());
	    	
	    }*/
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
