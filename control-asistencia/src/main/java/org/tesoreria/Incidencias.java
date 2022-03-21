package org.tesoreria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionP;
import conexion.Usuario;

public class Incidencias {
	
	
	private int catalogo_id;
	
	private int usuario_id;
	
	private String horario_inicio;
	
	private String horario_termino;
	
	private String fecha_inicial;
	
	private String fecha_final;
	
	private int status;
	
	private String observaciones;
	
	private Date fecha_justificacion;
	
	private int titular_id;
	
	private int delegado_id;
	
	private String folio;
	public Incidencias() {};
	public Incidencias(int catalogo_id, int usuario_id, String horario_inicio, String horario_termino,
			String fecha_inicial, String fecha_final, int status, String observaciones, Date fecha_justificacion,
			int titular_id, int delegado_id, String folio) {
		
		this.catalogo_id = catalogo_id;
		this.usuario_id = usuario_id;
		this.horario_inicio = horario_inicio;
		this.horario_termino = horario_termino;
		this.fecha_inicial = fecha_inicial;
		this.fecha_final = fecha_final;
		this.status = status;
		this.observaciones = observaciones;
		this.fecha_justificacion = fecha_justificacion;
		this.titular_id = titular_id;
		this.delegado_id = delegado_id;
		this.folio = folio;
	}

	
	public int getCatalogo_id() {
		return catalogo_id;
	}
	public void setCatalogo_id(int catalogo_id) {
		this.catalogo_id = catalogo_id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getHorario_inicio() {
		return horario_inicio;
	}
	public void setHorario_inicio(String horario_inicio) {
		this.horario_inicio = horario_inicio;
	}
	public String getHorario_termino() {
		return horario_termino;
	}
	public void setHorario_termino(String horario_termino) {
		this.horario_termino = horario_termino;
	}
	public String getFecha_inicial() {
		return fecha_inicial;
	}
	public void setFecha_inicial(String fecha_inicial) {
		this.fecha_inicial = fecha_inicial;
	}
	public String getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(String fecha_final) {
		this.fecha_final = fecha_final;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFecha_justificacion() {
		return fecha_justificacion;
	}
	public void setFecha_justificacion(Date fecha_justificacion) {
		this.fecha_justificacion = fecha_justificacion;
	}
	public int getTitular_id() {
		return titular_id;
	}
	public void setTitular_id(int titular_id) {
		this.titular_id = titular_id;
	}
	public int getDelegado_id() {
		return delegado_id;
	}
	public void setDelegado_id(int delegado_id) {
		this.delegado_id = delegado_id;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	public static boolean InsertarIncidencias(Date d, Date d2) throws ParseException {
		
		boolean bandera = false;
		Incidencias in = new Incidencias();
		Connection con = ConexionP.getConexion();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    String sql = "";
	    String ejemplo = "2020-05-16"; 
	    Date ejemploD;
	    
	    
	    java.util.Date util = sdf.parse(ejemplo);
	    
	    ejemploD = new java.sql.Date(util.getTime());
	    
	    
	    
	    try {
	    	 PreparedStatement ps = con.prepareStatement("INSERT INTO inventario.justificacion(catalogo_id, usuario_id, horario_inicio, horario_termino, \r\n"
	    	 		+ "	fecha_inicial, fecha_final, status, observaciones, fecha_justificacion, \r\n"
	    	 		+ "	titular_id, delegado_id, folio, archivo_id)\r\n"
	    	 		+ "	VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
	    	 
	    	 ps.setInt(1, 1);
	    	 ps.setInt(2, 434);
	    	 ps.setString(3, "102");
	    	 ps.setString(4, "15");
	    	 ps.setDate(5, d);//fecha inicial
	    	 ps.setDate(6, d2);
	    	 ps.setInt(7,1);
	    	 ps.setString(8, "ej");
	    	 ps.setDate(9, ejemploD);
	    	 ps.setInt(10, 1);
	    	 ps.setInt(11, 1);
	    	 ps.setString(12, "ej");
	    	 ps.setInt(13, 1);
	    	 
	    	 
	    	 
	         /*sql = "INSERT INTO inventario.justificacion(\r\n"
	         		+ "catalogo_id, usuario_id, horario_inicio, horario_termino, fecha_inicial, fecha_final, status, observaciones, fecha_justificacion, \r\n"
	         		+ "	titular_id, delegado_id, folio, archivo_id)\r\n"
	         		+ "	VALUES ( 1, 434, 10, 20,'2021-08-16', '2020-07-15', 1, 'bb',"+ejemploD+", 1, 3, 'ad', 1213);";*/
	          ps.executeUpdate();
	         bandera= true;
		} catch(SQLException e){
	    	 e.printStackTrace();
	    }
	
		return bandera;
	}
	
	
	
public static ArrayList<Incidencias> MostrarIncidencias(int idp) throws SQLException {
		String sql = "";
		boolean bandera = false;
		Statement st = null;
		ResultSet rs = null;
		ArrayList <Incidencias> incidenciasView = new ArrayList<Incidencias>();
		
		Connection con = ConexionP.getConexion();
		 
	    Date ejemploD;
  
	    try {
	    	st = con.createStatement();
	    	sql="SELECT  folio, catalogo_id,fecha_justificacion , status, archivo_id\r\n"
					+ "	FROM inventario.justificacion WHERE usuario_id="+idp+";";
	    	rs = st.executeQuery(sql);
		    String ejemplo = "2020-05-16";
	    	 
		    while (rs.next()) {
		    	Incidencias in = new Incidencias();
		    	in.setFolio(rs.getString(1));
		        in.setCatalogo_id(rs.getInt(2));
		        in.setFecha_justificacion(rs.getDate(3));
		        in.setStatus(rs.getInt(4));
		    	incidenciasView.add(in);
		      
		    	}
		    }catch(SQLException e){
		    	 e.printStackTrace();
		    }
	  
	  return incidenciasView;
	}
	

}
