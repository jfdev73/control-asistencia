package org.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.tesoreria.Usuario;
import org.tesoreria.VacacionPO;

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
		HttpSession session = request.getSession(true);
		if(session.getAttribute("theNickName")!=null){
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
		case "11":{//listar usuarios
			
			registroPeriodo(request, response);
			break;
		}
		case "10":{
			
			mostrarUsuariosGuardias(request, response);
			break;
		}
		case "12":{
			System.out.println("Entrando al metodo 12");
			MostrarGuardias(request, response);
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
		}else{
			response.sendRedirect("index.jsp");
		} 
		
		
	}

	private void registroPeriodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo registrar");
		String pe = request.getParameter("periodos");
		int idperiodo = 0;
		HttpSession session = request.getSession(true);
		if(pe!=null) {
			 idperiodo =  Integer.parseInt(pe);
		}
		
		if(idperiodo!=0) {
			session.setAttribute("idp", idperiodo);
			request.setAttribute("periodo", idperiodo);
			
		}
		System.out.println("Valor del periodo: "+idperiodo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("nuevaGuardia.jsp");
		dispatcher.forward(request, response);
		
	}

	private void eliminarGuardias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo eliminar");
		int id= Integer.parseInt(request.getParameter("id"));
		int periodo = Integer.parseInt(request.getParameter("p"));
		boolean vacacionDelete = false;
		boolean good = Guardias.deleteGuardia(id, periodo);
		//System.out.println("la eliminacion fue :"+good);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/Guardias.jsp");
		//dispatcher.forward(request, response);
		String ruta = "Guardias_servlet?accion=12&p="+periodo;
		if(good) {
			vacacionDelete = VacacionPO.deleteVacacionPO(id, periodo);
			response.sendRedirect(ruta);
			}
			//MostrarGuardias(request, response);
		
	}

	

	private void actualizarGuardias(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo actualizar");
		int id_g = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id_guar", id_g);
	}

	private void insertarGuardia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo registrar guardias");
		int idperiodo = 0;
		int id = 0;
		int value=0;
		String[] fechas1 = null;
		int cant =0;
		HttpSession session = request.getSession(true);
		
		session.getAttribute("idp");
		Object p = session.getAttribute("idp");
		if(p!=null) {
			idperiodo = Integer.parseInt(p.toString());
		}
		System.out.println("Valor de idpeirodo: "+idperiodo);
			
		String id_perc = request.getParameter("usuariosl");
		//request.setAttribute("idper",id_perc);
		if(id_perc !=null) {
			 id = Integer.parseInt(id_perc);	
		}
		
		System.out.println("id seleccionado:"+id_perc);
		String fechas = request.getParameter("fechas");
		if(fechas !=null) {
			 fechas1 = fechas.split(",");
			 cant = fechas1.length;
		}
		
	
		System.out.println("cantidad de dias tomados: "+ cant);
		
		//String [] vectF = fechas.split(",");
		//System.out.println(vectF);
		int unidadAd = (int)session.getAttribute("id_uni_adm");
		//request.setAttribute("fechas",fechas);
		System.out.println("fechas seleccionada:"+fechas);
		boolean exist = Guardias.getGuardia(id, idperiodo);
		if(fechas!=null) {
		if(exist) {
			System.out.println("El usuario ya existe");
			request.setAttribute("existe",exist);
			
		}else {
			
			boolean insertado = Guardias.insertarGuardia(id, fechas, unidadAd, idperiodo, cant);
			if(insertado) {
				request.setAttribute("insertado", insertado);
				String fechasv = getVacaciones(fechas, idperiodo);
				boolean insertarv = VacacionPO.insertarVacacion(id, fechasv, unidadAd, idperiodo);
				if(insertarv) {
					System.out.println("Se agregaron vacaciones");
					
				}
			
		}
			}
				}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("nuevaGuardia.jsp");
		dispatcher.forward(request, response);
		//System.out.println("fecha1: "+vectF[0]);
		//System.out.println("fecha2: "+vectF[1]);
		//band = Guardias.insertarGuardia(id, fechas,u );
		//System.out.println("valor de b: "+band);
		
		
	}

	private String getVacaciones(String fechas, int idPeriodo) throws SQLException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		LocalDate hoy = LocalDate.now();
		LocalDate d = LocalDate.parse("2021-04-12");
		Periodo p = Periodo.getPeriodo(idPeriodo);
		String fechaInicio = "";
		fechaInicio = p.getFecha_inicio().toString();
		int periodo = 0;
		int etapa = 0;
		periodo = p.getPeriodo();
		etapa = p.getEtapa();
		int duracionPeriodo = 5;
		if(periodo == 2 && etapa==1 ) {
			duracionPeriodo = 10;
			
		}
		d =LocalDate.parse(fechaInicio);
		/*Periodo perv = Periodo.getPeriodo(p2);

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		fechaInicio = "\"" + format.format(perv.getFecha_inicio()) + "\"";
		fechaFinal = "\"" + format.format(perv.getFecha_fin()) + "\"";*/
	
        ArrayList<String> cad = new ArrayList<String>();
       for(int ii = 0;ii<duracionPeriodo;ii++) { 
    	   cad.add(d.plusDays(ii).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));    	   
       }
       System.out.println(cad);
       ArrayList<String> guardias= new ArrayList<String>();
       ArrayList<String> vacaciones= new ArrayList<String>();
       String v="";
       String g ="";
       
       String fechasEjemplo = "12/04/2021,13/04/2021";
       fechasEjemplo = fechas;
		//System.out.println("fechasejemplo: "+fechasEjemplo);
		String[] arrayOfInts = fechasEjemplo.split(",");
		boolean guardia = true;
        for (int k=0 ; k <cad.size();k++) {
     	   boolean esVacacion = true;
     	   for (int j=0 ; j <arrayOfInts.length;j++) {
     		   //System.out.println("valor" + arrayOfInts[j]);
     		   if (arrayOfInts[j].equals(cad.get(k))) {
     			   System.out.println("guardias " + arrayOfInts[j]);
     			   guardias.add(arrayOfInts[j]);
     			   esVacacion = false;
     			   g += arrayOfInts[j] + "," ;
     		   }else {
     			   guardia = false;
     			  
     		   }
     		   
     	   }
     	   if (esVacacion) {
     	   System.out.println("vacacion " + cad.get(k));
     	   vacaciones.add(cad.get(k));
     	   v += cad.get(k) + ",";
     	   }
     	   
        }
        System.out.println("Guardias ");
        g = g.substring(0, g.length()-1); 
        v= v.substring(0, v.length()-1);
       	System.out.println(g);
       	System.out.println("Vacaciones ");
        System.out.println(v);
        return v;
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
		String per = request.getParameter("p");
		int per1 = 0;
		if(per!=null) {
		 per1 = Integer.parseInt(per);
		}
		
		System.out.println("Valor de per1: "+per1);
		
		ArrayList<Guardias> listg;
		HttpSession session = request.getSession(true);
		int prueba = (int) session.getAttribute("idpercep");
		int iduni = (int) session.getAttribute("id_uni_adm");
		System.out.println("unidadde: "+iduni);
		System.out.println("valooor: "+prueba);
		String  perfill =  (String) session.getAttribute("perfil");
	    listg = Guardias.mostrarGuardias(prueba, perfill,iduni, per1);
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
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/Guardias.jsp");
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
