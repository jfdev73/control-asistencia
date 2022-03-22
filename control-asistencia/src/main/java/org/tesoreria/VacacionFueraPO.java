package org.tesoreria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionP;

public class VacacionFueraPO {
private int id_vacaciones_FPO;
	
	private int id_usuario;
	
	private int periodo;
	
	private int etapa;
	
	private Date fecha_inicio;
	
	private Date fecha_final;
	
	private int dias;
	
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public VacacionFueraPO() {
		
	}
	public int getId_vacaciones_FPO() {
		return id_vacaciones_FPO;
	}

	public void setId_vacaciones_FPO(int id_vacaciones_FPO) {
		this.id_vacaciones_FPO = id_vacaciones_FPO;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getEtapa() {
		return etapa;
	}

	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}

	public static VacacionFueraPO getVacacionesFPO() {
		String sql = "";
		Statement st = null;
		ResultSet rs = null;
		ArrayList <VacacionFueraPO> vacaFPO = new ArrayList<VacacionFueraPO>();
		
		Connection con = ConexionP.getConexion();
	    Date ejemploD; 
	    try {
	    	st = con.createStatement();
	    	//sql="SELECT  justificacion_id, folio, tipo_causa, causa,fecha_justificacion , status, observaciones\r\n"
				//	+ "	FROM inventario.justificacion WHERE usuario_id="+idp+";";
	    	rs = st.executeQuery(sql);
		    String ejemplo = "2020-05-16";
	    	 
		    while (rs.next()) {
		    	VacacionFueraPO v = new VacacionFueraPO();
		    	/*in.setJustificacion_id(rs.getInt(1));
		    	in.setFolio(rs.getString(2));
		        in.setTipo_causa(rs.getInt(3));
		        in.setCausa(rs.getInt(4));
		        in.setFecha_justificacion(rs.getDate(5));
		        in.setStatus(rs.getInt(6));
		        in.setObservaciones(rs.getString(7));
		    	incidenciasView.add(in);*/
		      
		    	}
		    }catch(SQLException e){
		    	 e.printStackTrace();
		    }
	  
	  return null;
		
		
	}
	
	
	
	
}
