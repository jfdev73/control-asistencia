package org.tesoreria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionP;
import conexion.Usuario;

public class Percepcion {

	private String numPlaza;
	
	private String cct;
	
	private String puesto;

	public Percepcion() {
		
	}
	public Percepcion(String numPlaza, String cct, String puesto) {
		this.numPlaza = numPlaza;
		this.cct = cct;
		this.puesto = puesto;
	}

	public String getNumPlaza() {
		return numPlaza;
	}

	public void setNumPlaza(String numPlaza) {
		this.numPlaza = numPlaza;
	}

	public String getCct() {
		return cct;
	}

	public void setCct(String cct) {
		this.cct = cct;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	public static  Percepcion getData(int idp) {
		  Connection con = ConexionP.getConexion();
		    Statement st = null;
		    ResultSet res = null;
		    String sql = "";
		    Percepcion p = null;
		    try {
		    st = con.createStatement();
		    sql = "SELECT clave_plaza, desc_puesto, cct \r\n"
		    		+ "FROM inventario.percepciones_usuarios WHERE status=1 and per_us_id="+idp+";";
		    res = st.executeQuery(sql);
		    while (res.next()) {
		      p = new Percepcion();
		      p.setNumPlaza(res.getString(1));
		      p.setPuesto(res.getString(2));
		      p.setCct(res.getString(3));
		      //u.setNombre_titular(res.getString(2));
		    	}
		    }catch(SQLException e){
		    	 e.printStackTrace();
		    }
		return p;
		  
		  
	  }
	
	
}
