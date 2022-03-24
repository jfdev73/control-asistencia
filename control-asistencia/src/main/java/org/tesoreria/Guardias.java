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

import conexion.ConexionP;
import conexion.Usuario;

public class Guardias extends Usuario{	
private String dias;
private int id_guardias;
public int getId_guardias() {
	return id_guardias;
}

public void setId_guardias(int id_guardias) {
	this.id_guardias = id_guardias;
}


private String puesto;

public String getPuesto() {
	return puesto;
}

public void setPuesto(String puesto) {
	this.puesto = puesto;
}

public String getDias() {
	return dias;
}

public void setDias(String dias) {
	this.dias = dias;
}

public Guardias() {}

public Guardias(int id, String fechas) {
	this.setId_percepciones(id);
	this.dias = fechas;
	
}


public static ArrayList<Guardias> mostrarGuardias(int idp, String perfil, int unidad) throws SQLException {
	String sql = "";
	boolean bandera = false;
	Statement st = null;
	ResultSet rs = null;
	ArrayList <Guardias> g = new ArrayList<Guardias>();
	
	Connection con = ConexionP.getConexion();
	 
    Date ejemploD;
   

    try {
    	st = con.createStatement();
    	if(perfil.equals("53")) {
    		sql="SELECT  justificacion_id, folio, tipo_causa, causa,fecha_justificacion , status, observaciones\r\n"
					+ "	FROM inventario.justificacion WHERE status=1;";
    	}else if(perfil.equals("54") || perfil.equals("55")) {
    	sql="SELECT gu.id_guardias, gu.unidad, pu.desc_puesto,gu.dias,u.nombre, u.claveservidor\r\n"
    			+ "from inventario.guardias gu inner join inventario.percepciones_usuarios pu\r\n"
    			+ "on gu.usuario_id = pu.per_us_id \r\n"
    			+ "inner join inventario.usuarios u on pu.usuario=u.usuario_id where pu.status = 1 and unidad="+unidad+";";
    	}
    	rs = st.executeQuery(sql);
	    String ejemplo = "2020-05-16";
    	 
	    while (rs.next()) {
	    	Guardias guardia = new Guardias();
	    	guardia.setId_guardias(rs.getInt(1));
	    	guardia.setUni_id(rs.getInt(2));
	    	guardia.setPuesto(rs.getString(3));
	    	guardia.setDias(rs.getString(4));
	    	guardia.setNombre(rs.getString(5));
	    	guardia.setClave_servidor(rs.getString(6));
	    	g.add(guardia);
	      
	    	}
	    }catch(SQLException e){
	    	 e.printStackTrace();
	    }
  
  return g;
}


public static boolean insertarGuardia(int id_usuario,String dias, int unidad) throws ParseException {
	boolean bandera = false;
	
	Incidencias in = new Incidencias();
	Connection con = ConexionP.getConexion();
	
    String sql = "";
    
    try {
    	 PreparedStatement ps = con.prepareStatement("INSERT INTO inventario.guardias(usuario_id, dias, unidad) VALUES (?, ?, ?);");
    	 
    	 ps.setInt(1, id_usuario);
    	 ps.setString(2, dias);
    	 ps.setInt(3,unidad);
    	 
          ps.executeUpdate();
         bandera= true;
	} catch(SQLException e){
    	 e.printStackTrace();
    }

	return bandera;
}

}
