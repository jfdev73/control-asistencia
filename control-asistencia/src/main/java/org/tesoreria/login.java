package org.tesoreria;

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

import conexion.ConexionLdap;
import conexion.Usuario;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//request.setCharacterEncoding("utf-8");
				///////////////////////////////////////////////////Datos de Usuario
				String nickuser = request.getParameter("nickuser");
				String passw0rd = request.getParameter("password");
				
				System.out.println("usuario:"+nickuser);
				
				String tEnc=DigestUtils.md5Hex(passw0rd); 
				//System.out.println("Texto Encriptado con MD5 : "+textoEnc);
						
				////////////////////////////////////////////////Parametros de Respuesta
				String respuesta = "";
				Integer error=0;
				Integer Acceso=0;
				
				System.out.println("1"+nickuser+" "+passw0rd);
				
				try{
					if(nickuser!="" && passw0rd!=""){
						
						Usuario us= Usuario.getUsuario(nickuser);
						
						if(us!=null) {//existe usuario
							if(us.getActive_directory()==true) {
								
										System.out.println("Iniciando Autenticacion");
										boolean cl = ConexionLdap.authenticate(nickuser, passw0rd);		
										System.out.println(cl);				
										if(cl==true) {  
											us= Usuario.getVerificarPerfil(us,17);//DirectorioWeb
											if(us.getPerfil()==25 || us.getPerfil()==26 || us.getPerfil()==35){//Acceso al sistema
												Acceso=1;
											}else{
												error=4;
												System.out.println("No tiene acceso");
											}//no tiene acceso al sistema
											
										}//Las credenciales son correctas
										else {
											error=2;
											System.out.println("Credenciales Invalidas");}//Credenciales invalidas										
							}else {
								
								System.out.println("Autenticacion sin ldap");
								boolean cl = Usuario.Authenticate(us, tEnc);
								
								if(cl==true) {
									    System.out.println("Credenciales validas");
									    
										if(us.getCuenta_expirada()==true) {

											HttpSession session = request.getSession(true);
											session.setMaxInactiveInterval(60*60); 
											session.setAttribute("usuarioconexion", us);
											System.out.println("Credenciales expiradas");
											response.sendRedirect("updatepassword.jsp");
											
										}else {
											us = Usuario.getVerificarPerfil(us, 17);//DirectorioWeb
											if(us.getPerfil()==25 || us.getPerfil()==26 || us.getPerfil()==35){//Acceso al sistema consulta y capturista o Administrador
												System.out.println("Acceso al sistema");
												Acceso=1;
											}else{
												error=4;
												System.out.println("No tiene acceso");
											}//no tiene acceso al sistema
										}///Tiene cuenta de acceso, por lo cual verificamos que tenga el acceso al sistema							
								}else {//Credenciales invalidas
									error=2;
									System.out.println("Credenciales Invalidas");	
								}
								
							}// el acceso no es por active directory
						
							if(Acceso==1)
							{
								System.out.println("Atributos de sesion");
								HttpSession session = request.getSession(true);
								session.setMaxInactiveInterval(60*60);                                 ////Sesion de 60 minutos 
								session.setAttribute( "theNickName", us.getNickuser() );
										
								
								/*String ip = null; 	     
							    ip = request.getRemoteAddr(); // IP del cliente
							    
								Auditoria nuevo = new Auditoria();
								nuevo.setConcepto(4);
								nuevo.setTabla(0);
								nuevo.setModify(us.getNickuser());
								//nuevo.setIP(Inet4Address.getLocalHost().getHostAddress());
								nuevo.setIP(ip);
								nuevo.setID(0);
								nuevo.start();
*/
								
								response.sendRedirect("consultacontactos.jsp"); System.out.println("redirigiendo a pantalla principal"); 
							}//Si acceso=1
							
						}else{error=5; System.out.println("No se encuentra al usuario");}//Si no existe usuario
								
					}else {error=3; System.out.println("Campos vacios");}//Si usuario y pass son nulos
						
					if(error!=0){
						HttpSession session= request.getSession(true);
						session.setMaxInactiveInterval(30);
						if(error==2) {session.setAttribute("danger","El usuario y/o contraseña son incorrectas, vuelva a intentarlo");}
						else if(error==3) {session.setAttribute("danger","Verifica que los campos no se encuentren vacios");}
						else if(error==4) {session.setAttribute("danger","Permiso Denegado! Comunicate con la Unidad de Informática.");}
						else if(error==5) {session.setAttribute("danger","El usuario no existe!");}
						response.sendRedirect("Login.jsp");
					}
						
				}catch ( Exception e ){	
				respuesta = e.getLocalizedMessage();
				request.setAttribute("respuesta", respuesta);
				RequestDispatcher requestDispatcher; 
				requestDispatcher = request.getRequestDispatcher("Login.jsp");
				requestDispatcher.forward(request, response);
				FileWriter fichero = new FileWriter("/opt/tomcat/apache-tomcat-9.0.31/webapps/DirectorioWeb/catalogos/Files/error.log");
				PrintWriter impresion = new PrintWriter(fichero);
				e.printStackTrace(impresion);
				fichero.close(); 
				System.out.println(e.getMessage());
				} 
	}

}
