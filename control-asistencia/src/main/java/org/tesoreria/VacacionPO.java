package org.tesoreria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionP;

public class VacacionPO extends Formato_G_V{
	
public static ArrayList<Formato_G_V> mostrarFormato(int idp, String perfil) throws SQLException{
		String sql = "";
		Statement st = null;
		ResultSet rs = null;
		ArrayList <Formato_G_V> formato = new ArrayList<Formato_G_V>();
		Connection con = ConexionP.getConexion();
		try {
	    	st = con.createStatement();
	    	if(perfil.equals("53")) {
	    		sql="SELECT  justificacion_id, folio, tipo_causa, causa,fecha_justificacion , status, observaciones\r\n"
						+ "	FROM inventario.justificacion WHERE status=1;";
	    	}else if(perfil.equals("54") || perfil.equals("55")) {
	    	sql="SELECT u.claveservidor, (u.nombre||' '||u.ap_pat||' '||u.ap_mat) nombre , \r\n"
	    			+ "	pu.desc_puesto, gu.fecha \r\n"
	    			+ "	FROM inventario.usuarios u, inventario.percepciones_usuarios pu, inventario.guardias gu where \r\n"
	    			+ "	u.usuario_id = pu.usuario and  pu.per_us_id=434 and guardia_id=1;";}
	    	rs = st.executeQuery(sql);
		    String ejemplo = "2020-05-16";
	    	 
		    while (rs.next()) {
		    	VacacionPO vpo = new VacacionPO();
		    	in.setJustificacion_id(rs.getInt(1));
		    	vpo.set
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
		return null;
	}
}
