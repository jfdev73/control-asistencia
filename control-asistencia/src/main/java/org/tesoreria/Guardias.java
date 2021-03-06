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

public class Guardias extends Usuario{	
private String dias;
private int id_guardias;

private int periodo;

public int getPeriodo() {
	return periodo;
}

public void setPeriodo(int periodo) {
	this.periodo = periodo;
}

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


public static ArrayList<Guardias> mostrarGuardias(int idp, String perfil, int unidad, int periodo) throws SQLException {
	String sql = "";
	boolean bandera = false;
	Statement st = null;
	ResultSet rs = null;
	ArrayList <Guardias> g = new ArrayList<Guardias>();
	
	Connection con = ConexionP.getConexion();
	 
    Date ejemploD;
   

    try {
    	st = con.createStatement();
    	
    	sql="SELECT gu.usuario_id, gu.id_guardias, gu.unidad, pu.desc_puesto,gu.dias,u.nombre, u.claveservidor\r\n"
    			+ "from inventario.guardias gu inner join inventario.percepciones_usuarios pu\r\n"
    			+ "on gu.usuario_id = pu.per_us_id \r\n"
    			+ "inner join inventario.usuarios u on pu.usuario=u.usuario_id where pu.status = 1 and unidad="+unidad+"and periodo="+periodo+";";
    	
    	rs = st.executeQuery(sql);
	    String ejemplo = "2020-05-16";
    	 
	    while (rs.next()) {
	    	Guardias guardia = new Guardias();
	    	guardia.setId_percepciones(rs.getInt(1));
	    	guardia.setId_guardias(rs.getInt(2));
	    	guardia.setUni_id(rs.getInt(3));
	    	guardia.setPuesto(rs.getString(4));
	    	guardia.setDias(rs.getString(5));
	    	guardia.setNombre(rs.getString(6));
	    	guardia.setClave_servidor(rs.getString(7));
	    	guardia.setPeriodo(periodo);
	    	g.add(guardia);
	      
	    	}
	    }catch(SQLException e){
	    	 e.printStackTrace();
	    }
  con.close();
  return g;
}


public static boolean insertarGuardia(int id_usuario,String dias, int unidad, int idperiodo, int cantdias) throws ParseException, SQLException {
	boolean bandera = false;
	
	Incidencias in = new Incidencias();
	Connection con = ConexionP.getConexion();
	
    String sql = "";
    
    try {
    	 PreparedStatement ps = con.prepareStatement("INSERT INTO inventario.guardias(usuario_id, dias, unidad,periodo, cant_dias) VALUES (?, ?, ?,?,?);");
    	 
    	 ps.setInt(1, id_usuario);
    	 ps.setString(2, dias);
    	 ps.setInt(3,unidad);
    	 ps.setInt(4, idperiodo);
    	 ps.setInt(5, cantdias);
    	 
          ps.executeUpdate();
         bandera= true;
	} catch(SQLException e){
    	 e.printStackTrace();
    }
    con.close();
	return bandera;
}

public static boolean getGuardia(int id_usr, int periodo_id) throws SQLException {
	boolean existe = false;
	Connection con = ConexionP.getConexion();
    Statement st = null;
    ResultSet res = null;
    String sql = "";
    try {
        st = con.createStatement();
        sql = "select usuario_id from inventario.guardias where usuario_id ="+id_usr+"and periodo ="+periodo_id+";";
        res = st.executeQuery(sql);
        if (res.next())
          existe = true; 
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          if (res != null)
            res.close(); 
          if (st != null)
            st.close(); 
          if (con != null)
            con.close(); 
        } catch (SQLException e) {
          e.printStackTrace();
        } 
      } 
    con.close();
	return existe;
}

public static boolean deleteGuardia(int id_usr, int per) throws ParseException, SQLException {
	boolean bandera = false;
	
	Connection con = ConexionP.getConexion();
    try {
    	 PreparedStatement ps = con.prepareStatement("DELETE FROM inventario.guardias where usuario_id=? and periodo=?;");
    	 ps.setInt(1, id_usr);
    	 ps.setInt(2, per);
         ps.executeUpdate();
         bandera= true;
	} catch(SQLException e){
    	 e.printStackTrace();
    }
    con.close();
	return bandera;
	}
}
