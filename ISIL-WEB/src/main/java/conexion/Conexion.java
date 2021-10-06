package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import constantes.Constante;

public class Conexion {		
	public static Connection conectar(){
		Connection cn = null;		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection(Constante.URL_DATABASE,Constante.USER_DATABASE,Constante.PASSWORD_DATABASE);			
		} catch (SQLException e) {
			System.out.println("No se pudo conectar");
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("No se pudo conectar clase");
		}
		return cn;		
	}
	
}
