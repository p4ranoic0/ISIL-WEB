package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;

public class UsuarioDao {
	Connection cn = null;
	Statement stmt =null;/*Este objeto me permite hacer querys o sentencias SQL en BD*/
	ResultSet rs = null;
		
	public int validarUsuario(String nickname, String password) {
		int existe = 0;		 
		try {
			cn = Conexion.conectar();			
			stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexi�n de BD que he abierto*/
			String sentenciaSQL = "SELECT * FROM USUARIO WHERE nickname='" + nickname + "' and password='" + password + "';";
			rs = stmt.executeQuery(sentenciaSQL); /*Aqu� se est� ejecutando el query en BD*/
			while (rs.next()) {
				existe = 1;
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}
	
	public int validarUsuarioSP(String nickname, String password) throws SQLException {
		int existe;
		/*La consulta en BD se har� a trav�s de Stored Procedures*/
		CallableStatement cs= cn.prepareCall("{call SP_validarUsuario(?,?,?)}");
		/*Definiendo los par�metros del SP*/
		cs.setString(1,nickname);
		cs.setString(2,password);
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		cs.execute();
		existe = cs.getInt(3); /*Obtengo la cantidad que me devolvi� el SP que est� en la columna 0*/
		return existe;		
	}
	
	
}
