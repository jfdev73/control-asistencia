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

import javax.servlet.http.HttpSession;

import conexion.ConexionP;
import conexion.Usuario;

public class Incidencias {
	
	private int justificacion_id;
	
	private int tipo_causa;
	
	private int causa;
	
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
	public Incidencias( int justificacion_id,int usuario_id, String horario_inicio, String horario_termino,
			String fecha_inicial, String fecha_final, int status, String observaciones, Date fecha_justificacion,
			int titular_id, int delegado_id, String folio, int tipo_causa, int causa) {
		this.justificacion_id= justificacion_id;
		this.tipo_causa = tipo_causa;
		this.causa = causa;
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

	
	public int getJustificacion_id() {
		return justificacion_id;
	}
	public void setJustificacion_id(int justificacion_id) {
		this.justificacion_id = justificacion_id;
	}
	public int getTipo_causa() {
		return tipo_causa;
	}
	public void setTipo_causa(int tipo_causa) {
		this.tipo_causa = tipo_causa;
	}
	public int getCausa() {
		return causa;
	}
	public void setCausa(int causa) {
		this.causa = causa;
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
	
	public static boolean InsertarIncidencias(int id_usuario,Date d_jts, String hi, String hf,Date d2, Date date_pi, Date date_pf, int tipo_causa, int causa, int id_titular, int id_delegado ) throws ParseException {
		boolean bandera = false;
		
		if(date_pi==null || date_pf ==null) {
			System.out.println("el dia es nulo");
			date_pi = d2;
			date_pf = d2;
		}
		//int tc = tipo_causa;
		
		Incidencias in = new Incidencias();
		Connection con = ConexionP.getConexion();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    String sql = "";
	    String ejemplo = "2020-05-16"; 
	    Date ejemploD;
	    
	    
	    java.util.Date util = sdf.parse(ejemplo);
	    
	    ejemploD = new java.sql.Date(util.getTime());
	    
	    
	    
	    try {
	    	 PreparedStatement ps = con.prepareStatement("INSERT INTO inventario.justificacion(\r\n"
	    	 		+ "usuario_id, horario_inicio, horario_termino, fecha_inicial, fecha_final, status, observaciones, fecha_justificacion, titular_id, delegado_id, archivo_id, tipo_causa, causa)\r\n"
	    	 		+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
	    	 
	    	 ps.setInt(1, id_usuario);
	    	 ps.setString(2, hi);
	    	 ps.setString(3,hf);
	    	 ps.setDate(4,date_pi );
	    	 ps.setDate(5, date_pf);//fecha inicial
	    	 ps.setInt(6, 1);
	    	 ps.setString(7, "");
	    	 ps.setDate(8, d_jts);
	    	 ps.setInt(9, id_titular);
	    	 ps.setInt(10, id_delegado);
	    	 ps.setInt(11, 10);
	    	 ps.setInt(12, tipo_causa);
	    	 ps.setInt(13, causa);
	    	 
	          ps.executeUpdate();
	         bandera= true;
		} catch(SQLException e){
	    	 e.printStackTrace();
	    }
	
		return bandera;
	}
	
	
	
public static ArrayList<Incidencias> MostrarIncidencias(int idp, String perfil) throws SQLException {
		String sql = "";
		boolean bandera = false;
		Statement st = null;
		ResultSet rs = null;
		ArrayList <Incidencias> incidenciasView = new ArrayList<Incidencias>();
		
		Connection con = ConexionP.getConexion();
		 
	    Date ejemploD;
	   
  
	    try {
	    	st = con.createStatement();
	    	if(perfil.equals("53")) {
	    		sql="SELECT  justificacion_id, folio, tipo_causa, causa,fecha_justificacion , status, observaciones\r\n"
						+ "	FROM inventario.justificacion WHERE status=1;";
	    	}else if(perfil.equals("54") || perfil.equals("55")) {
	    	sql="SELECT  justificacion_id, folio, tipo_causa, causa,fecha_justificacion , status, observaciones\r\n"
					+ "	FROM inventario.justificacion WHERE usuario_id="+idp+";";}
	    	rs = st.executeQuery(sql);
		    String ejemplo = "2020-05-16";
	    	 
		    while (rs.next()) {
		    	Incidencias in = new Incidencias();
		    	in.setJustificacion_id(rs.getInt(1));
		    	in.setFolio(rs.getString(2));
		        in.setTipo_causa(rs.getInt(3));
		        in.setCausa(rs.getInt(4));
		        in.setFecha_justificacion(rs.getDate(5));
		        in.setStatus(rs.getInt(6));
		        in.setObservaciones(rs.getString(7));
		    	incidenciasView.add(in);
		      
		    	}
		    }catch(SQLException e){
		    	 e.printStackTrace();
		    }
	  
	  return incidenciasView;
	}
	
public static boolean actualizarStatus(int id_jus, int status ) throws ParseException {
	boolean bandera = false;
	
	//int tc = tipo_causa;
	
	Incidencias in = new Incidencias();
	Connection con = ConexionP.getConexion();
	

    
    try {
    	 PreparedStatement ps = con.prepareStatement("UPDATE inventario.justificacion SET status=? where justificacion_id=?;");
    	 
    	 ps.setInt(1, status);
    	 ps.setInt(2, id_jus);
         ps.executeUpdate();
         bandera= true;
	} catch(SQLException e){
    	 e.printStackTrace();
    }

	return bandera;
}

}
