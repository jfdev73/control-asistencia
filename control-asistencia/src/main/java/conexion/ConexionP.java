package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionP {
private static String driver = "org.postgresql.Driver";
	
	private static String connectString = "jdbc:postgresql://localhost:5432/Test"; //ServidorSEI
	private static String user = "postgres";
	private static String password = "1234";
	
	public static Connection getConexion(){
		Connection con = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(connectString, user , password);
			System.out.println("Conexion correcta");
		}catch ( Exception e ){
			System.out.println("ERROR "+ e.getMessage());
			e.printStackTrace();
			}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = ConexionP.getConexion();
		
	}
}
