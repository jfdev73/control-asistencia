package org.tesoreria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionP;
import conexion.Usuario;

public class Periodo {
 private int id_periodo;
 private int periodo;
 private int etapa;
 private int status;
 private Date fecha_inicio;
 private Date fecha_fin;
 
 public Periodo() {}
 
 public Date getFecha_inicio() {
	return fecha_inicio;
}
public void setFecha_inicio(Date fecha_inicio) {
	this.fecha_inicio = fecha_inicio;
}
public Date getFecha_fin() {
	return fecha_fin;
}
public void setFecha_fin(Date fecha_fin) {
	this.fecha_fin = fecha_fin;
}


 public int getId_periodo() {
	return id_periodo;
}
public void setId_periodo(int id_periodo) {
	this.id_periodo = id_periodo;
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
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

public static ArrayList<Periodo> getPeriodos()throws SQLException {
	  ArrayList <Periodo> periodos = new ArrayList<Periodo>();
	  Connection con = ConexionP.getConexion();
	  Statement st = null;
	  ResultSet rs = null;
	  String sql = "";
	  //Usuario u = new Usuario();
	  try {
		    st = con.createStatement();
		    sql = "SELECT periodo_id, fecha_inicio, fecha_termino, periodo, etapa FROM inventario.periodo_vacacional;";
		    rs = st.executeQuery(sql);
		    while (rs.next()) {
		    	Periodo p = new Periodo();
		    	p.setId_periodo(rs.getInt(1));
		    	p.setFecha_inicio(rs.getDate(2));
		    	p.setFecha_fin(rs.getDate(3));
		    	p.setPeriodo(rs.getInt(4));
		        p.setEtapa(rs.getInt(5));
		    	periodos.add(p);
		      
		    	}
		    }catch(SQLException e){
		    	 e.printStackTrace();
		    }
	  
	  return periodos;
}

}
