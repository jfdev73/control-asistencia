package org.tesoreria.controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.tesoreria.Titulares;

import conexion.ConexionLdap;
import conexion.Usuario;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static public Integer varClose = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		doGet(request, response);
		String validar = request.getParameter("validar");
		System.out.println("vali:"+validar);
		// request.setCharacterEncoding("utf-8");
		/////////////////////////////////////////////////// Datos de Usuario
		String nickuser = request.getParameter("nickuser");
		String passw0rd = request.getParameter("password");
		
		// String prueba = DigestUtils.md5Hex("Acceso2020,");
		// System.out.println("");
		// System.out.println("ejemplo de con: "+ prueba);
		

		String tEnc = DigestUtils.md5Hex(passw0rd);
		String prueba = DigestUtils.md5Hex("Acceso2022,");
		System.out.println("ejemplo de con: " + prueba);
		System.out.println("Texto Encriptado con M5 : " + tEnc);
		System.out.println("");

		if (prueba.equals(passw0rd)) {
			System.out.println("Son iguales");

		}
		//////////////////////////////////////////////// Parametros de Respuesta
		String respuesta = "";
		Integer error = 0;
		Integer Acceso = 0;

		System.out.println("1" + "esto es  " + nickuser + " " + passw0rd);

		try {
			
			
			

			if (nickuser != "" && passw0rd != "") {

				System.out.println("entro");

				Usuario us = Usuario.getUsuario(nickuser);

				System.out.println("entro 2");

				if (us != null) {// existe usuario

					// System.out.println("us:"+us+ "us.getActive_directory()
					// "+us.getActive_directory());

					if (us.getActive_directory() == true) {

						System.out.println("Iniciando Autenticacion");
						boolean cl = ConexionLdap.authenticate(nickuser, passw0rd);
						System.out.println(cl);
						if (cl == true) {
							us = Usuario.getVerificarPerfil(us, 36);// DirectorioWeb
							if (us.getPerfil() == 53 || us.getPerfil() == 54) {// Acceso al sistema
								Acceso = 1;

							} else {
								
								error = 4;
								System.out.println("No tiene acceso");
							} // no tiene acceso al sistema

						} // Las credenciales son correctas
						else {
							error = 2;
							System.out.println("Credenciales Invalidas");
						} // Credenciales invalidas
					} else {

						System.out.println("Autenticacion sin ldap");

						boolean cl = Usuario.Authenticate(us, tEnc);

						if (cl == true) {
							System.out.println("Credenciales validas");

							if (us.getCuenta_expirada() == true) {

								HttpSession session = request.getSession(true);
								session.setMaxInactiveInterval(60 * 60);
								session.setAttribute("usuarioconexion", us);
								System.out.println("Credenciales expiradas");
								response.sendRedirect("updatepassword.jsp");

							} else {
								us = Usuario.getVerificarPerfil(us, 36);// DirectorioWeb
								if (us.getPerfil() == 53 || us.getPerfil() == 54) {// Acceso al sistema
									System.out.println("Acceso al sistema");
									Acceso = 1;
								} else {
									error = 4;
									
									String error4 = "No tiene acceso";
									HttpSession session = request.getSession();
									session.setAttribute("error", error);
									System.out.println(error4);
								} // no tiene acceso al sistema
							} /// Tiene cuenta de acceso, por lo cual verificamos que tenga el acceso al
								/// sistema
						} else {// Credenciales invalidas
							error = 2;
							String error2 = "Credenciales invalidas";
							HttpSession session = request.getSession();
							session.setAttribute("error", error);
							System.out.println(error2);
						}
					}

					if (Acceso == 1) {
						System.out.println("Atributos de sesion");
						HttpSession session = request.getSession(true);
						// System.out.println("Valor de sesion: " + session);
						session.setMaxInactiveInterval(60 * 60); //// Sesion de 60 minutos
						String nick = us.getNickuser();
						System.out.println("nick:" + nick);
						int ua = us.getUni_id();
						System.out.println("unidad:" + ua);
						String unidad = us.getDescripcion_uni();
						System.out.println("unidad:" + unidad);
						session.setAttribute("unidad", unidad);
						
						Titulares t =  Titulares.getTitulares(ua);
						String nombre_titular = t.getNombre_titular();
						System.out.println("nombre de titular: "+nombre_titular);
						session.setAttribute("nombret", nombre_titular);
						
					
						
						
					
						
						session.setAttribute("theNickName", us.getNickuser());
						Object p = us.getPerfil();
						String per = p.toString();
						session.setAttribute("perfil", per);
						varClose = 1;
						session.setAttribute("p", null);

						String v = (String) session.getAttribute("perfil");

						System.out.println("antes de la impresion session");
						System.out.println("Objeto:" + v);
						session.setAttribute("theNickName", nick);
						String nombre = us.getNombre();
						session.setAttribute("nombre", nombre);

						response.sendRedirect("Home.jsp");
						
						
						//request.getRequestDispatcher("/index.jsp").forward(request, response);
						
						System.out.println("redirigiendo a pantalla principal");
					} // Si acceso=1

				} else {
					error = 5;
					HttpSession session = request.getSession();
					session.setAttribute("error", error);
					System.out.println("No se encuentra al usuario");
					
				} // Si no existe usuario

			} else {
				error = 3;
				HttpSession session = request.getSession();
				session.setAttribute("error", error);
				System.out.println("Campos vacios");
			} // Si usuario y pass son nulos

			if (error != 0) {
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(30);
				if (error == 2) {
					session.setAttribute("danger", "El usuario y/o contraseña son incorrectas, vuelva a intentarlo");
				} else if (error == 3) {
					session.setAttribute("danger", "Verifica que los campos no se encuentren vacios");
				} else if (error == 4) {
					session.setAttribute("danger", "Permiso Denegado! Comunicate con la Unidad de Informática.");
				} else if (error == 5) {
					session.setAttribute("danger", "El usuario no existe!");
				}
				response.sendRedirect("index.jsp");
			}

		} catch (Exception e) {
			respuesta = e.getLocalizedMessage();
			request.setAttribute("respuesta", respuesta);
			RequestDispatcher requestDispatcher;
			requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
			/*
			 * FileWriter fichero = new FileWriter(
			 * "/opt/tomcat/apache-tomcat-9.0.31/webapps/DirectorioWeb/catalogos/Files/error.log"
			 * ); PrintWriter impresion = new PrintWriter(fichero);
			 * e.printStackTrace(impresion); fichero.close();
			 */
			System.out.println(e.getMessage());
		}
		
		

	}

}
