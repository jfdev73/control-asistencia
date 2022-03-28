package org.tesoreria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import conexion.ConexionP;

public class VacacionPO extends Usuario {

	private int id_po;
	
	private String vacaciones;

	public int getId_po() {
		return id_po;
	}

	public void setId_po(int id_po) {
		this.id_po = id_po;
	}

	public String getVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(String vacaciones) {
		this.vacaciones = vacaciones;
	}
	
public VacacionPO(){}

public static boolean insertarVacacion(int id_usuario,String diasv, int unidad, int idperiodo) throws ParseException, SQLException {
	boolean bandera = false;
	
	Connection con = ConexionP.getConexion();
	
    String sql = "";
    
    try {
    	 PreparedStatement ps = con.prepareStatement("INSERT INTO inventario.vacaciones_po(usuario_id, diasv, unidad, periodo)\r\n"
    	 		+ "VALUES ( ?, ?, ?, ?);");
    	 
    	 ps.setInt(1, id_usuario);
    	 ps.setString(2, diasv);
    	 ps.setInt(3,unidad);
    	 ps.setInt(4, idperiodo);
    	 
          ps.executeUpdate();
         bandera= true;
	} catch(SQLException e){
    	 e.printStackTrace();
    }
    con.close();
	return bandera;
}

public static ArrayList<VacacionPO> mostrarVacacionesPO(int idp, String perfil, int unidad, int periodo) throws SQLException {
	String sql = "";
	boolean bandera = false;
	Statement st = null;
	ResultSet rs = null;
	ArrayList <VacacionPO> listVPO = new ArrayList<>();
	
	Connection con = ConexionP.getConexion();
	
    try {
    	st = con.createStatement();
    	
    	sql="SELECT vpo.usuario_id,vpo.unidad, vpo.diasv, pu.usuario, pu.desc_puesto,u.nombre, u.claveservidor\r\n"
    			+ "from inventario.vacaciones_po vpo inner join inventario.percepciones_usuarios pu\r\n"
    			+ "on vpo.usuario_id = pu.per_us_id \r\n"
    			+ "inner join inventario.usuarios u on pu.usuario=u.usuario_id where pu.status = 1 and unidad="+unidad+"and periodo ="+periodo+";";
    	
    	rs = st.executeQuery(sql);
	    String ejemplo = "2020-05-16";
    	 
	    while (rs.next()) {
	    	VacacionPO vpo = new VacacionPO();
	    	vpo.setId_po(rs.getInt(1));
	    	vpo.setUni_id(rs.getInt(2));
	    	vpo.setVacaciones(rs.getString(3));
	    	vpo.setId_percepciones(rs.getInt(4));
	    	vpo.setPuesto(rs.getString(5));
	    	vpo.setNombre(rs.getString(6));
	    	vpo.setClave_servidor(rs.getString(7));
	    	
	    	listVPO.add(vpo);
	      
	    	}
	    }catch(SQLException e){
	    	 e.printStackTrace();
	    }
  con.close();
  return listVPO;
}
public static boolean deleteVacacionPO(int id_usr, int per) throws ParseException, SQLException {
	boolean bandera = false;
	
	Connection con = ConexionP.getConexion();
    try {
    	 PreparedStatement ps = con.prepareStatement("DELETE FROM inventario.vacaciones_po where usuario_id=? and periodo=?;");
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
