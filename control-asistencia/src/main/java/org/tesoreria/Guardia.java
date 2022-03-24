package org.tesoreria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionP;

public class Guardia {
private int guardia_id;
private int status; 

public Guardia() {}
public int getGuardia_id() {
	return guardia_id;
}

public void setGuardia_id(int guardia_id) {
	this.guardia_id = guardia_id;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public static boolean insertarGuardia(int status) {
	boolean bandera = true;
	Guardia g = new Guardia();
	Connection con = ConexionP.getConexion();
	try {
   	 PreparedStatement ps = con.prepareStatement("INSERT INTO inventario.\"guardia \"(\r\n"
   	 		+ "titular_id, superior_id, delegado_id, coordinador, periodo_id, status)\r\n"
   	 		+ "	VALUES (?, ?, ?, ?, ?, ?);");
   	 
   	 ps.setInt(1, 0);
   	 ps.setInt(2, 0);
   	 ps.setInt(3, 0);
   	 ps.setInt(4, 0);
   	 ps.setInt(5, 1);
   	 ps.setInt(6, 1); 
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
    	sql="SELECT  gu.fecha \r\n"
    			+ "	FROM inventario.usuarios u, inventario.percepciones_usuarios pu, inventario.guardias gu, \r\n"
    			+ "	inventario.usuarios_uni_admva uua where \r\n"
    			+ "	u.usuario_id = pu.usuario and  pu.per_us_id=434 and guardia_id=1 and tipo=1 and uua.uni_id= 6;";}
    	rs = st.executeQuery(sql);
    	 
	    while (rs.next()) {
	    	Guardia g = new Guardia();
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

}
