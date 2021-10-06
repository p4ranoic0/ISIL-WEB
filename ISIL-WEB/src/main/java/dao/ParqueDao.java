package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import model.Parque;

public class ParqueDao {
	Connection cn = Conexion.conectar();
	ResultSet rs =  null;
	Statement stmt = null;	/*Este objeto me permite hacer querys o sentencias SQL en BD*/	
	
	public List<Parque> buscarParquexNombre(String nombreParque){
		List<Parque> listaParques = new ArrayList<>(); //Estoy creando la lista de parques vac�a
		try {	
			stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexi�n de BD que he abierto*/
			String sentenciaSQL = "SELECT * FROM PARQUE WHERE nombre like '%" + nombreParque + "%';";
			rs = stmt.executeQuery(sentenciaSQL); /*Aqu� se est� ejecutando el query en BD*/
			while (rs.next()) {
				/*Aqu� voy a sacar la informaci�n de los parques*/
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int aforo = rs.getInt("aforo");
				String direccion = rs.getString("direccion");
				String distrito = rs.getString("distrito");
				int estado = rs.getInt("estado");
				Date fechaRegistro = rs.getDate("fechaRegistro");
				Date fechaActualizacion = rs.getDate("fechaActualizacion");
				
				Parque objParque = new Parque(id,nombre,aforo,direccion,distrito,estado,fechaRegistro,fechaActualizacion);
				listaParques.add(objParque);
				
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaParques;				
	}

	public List<Parque> buscarParquexNombre_SP(String nombreParque){
		List<Parque> listaParques = new ArrayList<>(); //Estoy creando la lista de parques vac�a
		try {	
			CallableStatement cs = cn.prepareCall("{call SP_buscarParquexNombre(?)}");
			cs.setString(1, nombreParque);
			cs.execute();
			rs = cs.getResultSet();
			while (rs.next()) {
				/*Aqu� voy a sacar la informaci�n de los parques*/
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int aforo = rs.getInt("aforo");
				String direccion = rs.getString("direccion");
				String distrito = rs.getString("distrito");
				int estado = rs.getInt("estado");
				Date fechaRegistro = rs.getDate("fechaRegistro");
				Date fechaActualizacion = rs.getDate("fechaActualizacion");
				
				Parque objParque = new Parque(id,nombre,aforo,direccion,distrito,estado,fechaRegistro,fechaActualizacion);
				listaParques.add(objParque);
				
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaParques;				
	}
	
	public Parque buscarParquexId(int idParque){
		Parque objParqueEncontado = null;
		try {	
			stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexi�n de BD que he abierto*/
			String sentenciaSQL = "SELECT * FROM PARQUE WHERE id="+idParque+";";
			rs = stmt.executeQuery(sentenciaSQL); /*Aqu� se est� ejecutando el query en BD*/
			while (rs.next()) {
				/*Aqu� voy a sacar la informaci�n de los parques*/
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int aforo = rs.getInt("aforo");
				String direccion = rs.getString("direccion");
				String distrito = rs.getString("distrito");
				int estado = rs.getInt("estado");
				Date fechaRegistro = rs.getDate("fechaRegistro");
				Date fechaActualizacion = rs.getDate("fechaActualizacion");
				
				objParqueEncontado = new Parque(id,nombre,aforo,direccion,distrito,estado,fechaRegistro,fechaActualizacion);
								
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return objParqueEncontado;				
	}
	
	public Parque buscarParquexId_SP(int idParque){
		Parque objParqueEncontado = null;
		try {	
			CallableStatement cs = cn.prepareCall("{call SP_buscarParquexId(?)}");
			cs.setInt(1, idParque);
			cs.execute();
			rs = cs.getResultSet();
			while (rs.next()) {
				/*Aqu� voy a sacar la informaci�n de los parques*/
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int aforo = rs.getInt("aforo");
				String direccion = rs.getString("direccion");
				String distrito = rs.getString("distrito");
				int estado = rs.getInt("estado");
				Date fechaRegistro = rs.getDate("fechaRegistro");
				Date fechaActualizacion = rs.getDate("fechaActualizacion");
				
				objParqueEncontado = new Parque(id,nombre,aforo,direccion,distrito,estado,fechaRegistro,fechaActualizacion);
								
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return objParqueEncontado;				
	}
	
	public List<Parque> buscarParqueAll(){
		List<Parque> listaParques = new ArrayList<>(); //Estoy creando la lista de parques vac�a
		try {			
			stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexi�n de BD que he abierto*/
			String sentenciaSQL = "SELECT * FROM PARQUE;";
			rs = stmt.executeQuery(sentenciaSQL); /*Aqu� se est� ejecutando el query en BD*/
			while (rs.next()) {
				/*Aqu� voy a sacar la informacion de los parques*/
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int aforo = rs.getInt("aforo");
				String direccion = rs.getString("direccion");
				String distrito = rs.getString("distrito");
				int estado = rs.getInt("estado");
				Date fechaRegistro = rs.getDate("fechaRegistro");
				Date fechaActualizacion = rs.getDate("fechaActualizacion");
				
				Parque objParque = new Parque(id,nombre,aforo,direccion,distrito,estado,fechaRegistro,fechaActualizacion);
				listaParques.add(objParque);
				
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaParques;				
	}
	
	public List<Parque> buscarParqueAll_SP(){
		List<Parque> listaParques = new ArrayList<>(); //Estoy creando la lista de parques vac�a
		try {			
			
			CallableStatement cs = cn.prepareCall("{call SP_buscarParqueAll}");
			cs.execute();
			rs = cs.getResultSet();
			while (rs.next()) {
				/*Aqu� voy a sacar la informacion de los parques*/
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int aforo = rs.getInt("aforo");
				String direccion = rs.getString("direccion");
				String distrito = rs.getString("distrito");
				int estado = rs.getInt("estado");
				Date fechaRegistro = rs.getDate("fechaRegistro");
				Date fechaActualizacion = rs.getDate("fechaActualizacion");
				
				Parque objParque = new Parque(id,nombre,aforo,direccion,distrito,estado,fechaRegistro,fechaActualizacion);
				listaParques.add(objParque);
				
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaParques;				
	}
	
	public void agregarParque(Parque objParque) throws SQLException {		
		stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexion de BD que he abierto*/
		String sentenciaSQL = "INSERT INTO PARQUE(nombre,aforo,direccion,distrito,estado,fechaRegistro,fechaActualizacion) VALUES ('" + objParque.getNombre() + "'," + objParque.getAforo() + ",'" + objParque.getDireccion() + "','" + objParque.getDistrito() + "'," + objParque.getEstado() + ",GETDATE(),GETDATE());";
		/*Este m�todo sirve para update, delete o insert*/
		stmt.executeUpdate(sentenciaSQL);
	}
	
	public void agregarParque_SP(Parque objParque) throws SQLException {
		CallableStatement cs = cn.prepareCall("{call SP_agregarParque(?,?,?,?)}");
		cs.setString(1, objParque.getNombre());
		cs.setInt(2,objParque.getAforo());
		cs.setString(3, objParque.getDireccion());
		cs.setString(4, objParque.getDistrito());
		cs.execute();
	}
	
	public void editarParque(Parque objParque) throws SQLException {		
		stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexion de BD que he abierto*/
		String sentenciaSQL = "UPDATE PARQUE SET nombre='" + objParque.getNombre() + "', aforo=" + objParque.getAforo() + ", direccion='" + objParque.getDireccion() + "', distrito='" + objParque.getDistrito() + "' where id= " + objParque.getId() + ";";
		/*Este metodo sirve para update, delete o insert*/
		stmt.executeUpdate(sentenciaSQL);
	}
	
	public void editarParque_SP(Parque objParque) throws SQLException {
		CallableStatement cs = cn.prepareCall("{call SP_editarParque(?,?,?,?,?)}");
		cs.setInt(1,objParque.getId());
		cs.setString(2, objParque.getNombre());
		cs.setInt(3, objParque.getAforo());
		cs.setString(4, objParque.getDireccion());
		cs.setString(5, objParque.getDistrito());
		cs.execute();
	}
	
	public void eliminarParque(int idParque) throws SQLException {		
		stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexi�n de BD que he abierto*/
		String sentenciaSQL = "DELETE FROM PARQUE WHERE id="+ idParque + ";";
		/*Este metodo sirve para update, delete o insert*/
		stmt.executeUpdate(sentenciaSQL);		
	}
	
	public void eliminarParque_SP(int idParque) throws SQLException {
		CallableStatement cs = cn.prepareCall("{call SP_eliminarParque(?)}");
		cs.setInt(1, idParque);
		cs.execute();	
	}
	
	
}
