package org.tesoreria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionP;

public class Titulares {

private int id_encargado_delegacion;

private int id_titular;

public int getId_encargado_delegacion() {
	return id_encargado_delegacion;
}

public void setId_encargado_delegacion(int id_encargado_delegacion) {
	this.id_encargado_delegacion = id_encargado_delegacion;
}

public int getId_titular() {
	return id_titular;
}

public void setId_titular(int id_titular) {
	this.id_titular = id_titular;
}


private String nom_delegacion;

private String cargo_encargado_delegacion;

private String nombre_titular;

private String cargo_titular;

public String getNom_delegacion() {
	return nom_delegacion;
}

public void setNom_delegacion(String nom_delegacion) {
	this.nom_delegacion = nom_delegacion;
}

public String getCargo_encargado_delegacion() {
	return cargo_encargado_delegacion;
}

public void setCargo_encargado_delegacion(String cargo_encargado_delegacion) {
	this.cargo_encargado_delegacion = cargo_encargado_delegacion;
}

public String getNombre_titular() {
	return nombre_titular;
}

public void setNombre_titular(String nombre_titular) {
	this.nombre_titular = nombre_titular;
}

public String getCargo_titular() {
	return cargo_titular;
}

public void setCargo_titular(String cargo_titular) {
	this.cargo_titular = cargo_titular;
}


public static Titulares getTitulares(int id_usuario) {
	int id_unidad = id_usuario;
    Connection con = ConexionP.getConexion();
    Statement st = null;
    ResultSet res = null;
    String sql = "";
    Titulares t = null;
    try {
    st = con.createStatement();
    sql = "select u.usuario_id, ucc.descripcion,u.nombre||' '||u.ap_pat||' '||u.ap_mat from inventario.usuarios_c_cargos ucc,\r\n"
    		+ "inventario.usuarios_uni_admva uua, inventario.usuarios_asign ua,\r\n"
    		+ "inventario.usuarios u where\r\n"
    		+ "u.usuario_id = ua.usuarios_usuario_id \r\n"
    		+ "and ucc.cargos_id = ua.usuarios_c_cargos_cargos_id\r\n"
    		+ "and ucc.unidad_admin= uua.uni_id\r\n"
    		+ "and uua.uni_id="+id_usuario+" --unidad de usuario\r\n"
    		+ "and ua.status=1\r\n"
    		+ "and ucc.nivel <= 5";
    res = st.executeQuery(sql);
    while (res.next()) {
      t = new Titulares();
      t.setId_titular(res.getInt(1)); 
      t.setCargo_titular(res.getString(2));
      t.setNombre_titular(res.getString(3));
          
      
    	}
    }catch(SQLException e){
    	 e.printStackTrace();
    }
return t;
}

public static Titulares getDelegado() {
	//int id_unidad = id_usuario;
    Connection con = ConexionP.getConexion();
    Statement st = null;
    ResultSet res = null;
    String sql = "";
    Titulares t = null;
    try {
    st = con.createStatement();
    sql = "select u.usuario_id, ucc.descripcion,u.nombre||' '||u.ap_pat||' '||u.ap_mat from inventario.usuarios_c_cargos ucc,\r\n"
    		+ "inventario.usuarios_uni_admva uua, inventario.usuarios_asign ua,\r\n"
    		+ "inventario.usuarios u where\r\n"
    		+ "u.usuario_id = ua.usuarios_usuario_id \r\n"
    		+ "and ucc.cargos_id = ua.usuarios_c_cargos_cargos_id\r\n"
    		+ "and ucc.unidad_admin= uua.uni_id\r\n"
    		+ "and uua.uni_id=6\r\n"
    		+ "and ua.status=1\r\n"
    		+ "and ucc.nivel <= 5";
    res = st.executeQuery(sql);
    while (res.next()) {
      t = new Titulares();
      t.setId_encargado_delegacion(res.getInt(1)); 
      t.setCargo_encargado_delegacion(res.getString(2));
      t.setNom_delegacion(res.getString(3));
          
      
    	}
    }catch(SQLException e){
    	 e.printStackTrace();
    }
return t;
}




}
