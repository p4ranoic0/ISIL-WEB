package model;

import java.sql.Date;

public class Parque {
	private int id;
	private String nombre;
	private int aforo;
	private String direccion;
	private String distrito;
	private int estado;
	private Date fechaRegistro;
	private Date fechaActualizacion;
	
	
	public Parque(int id, String nombre, int aforo, String direccion, String distrito, int estado, Date fechaRegistro,
			Date fechaActualizacion) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.aforo = aforo;
		this.direccion = direccion;
		this.distrito = distrito;
		this.estado = estado;
		this.fechaRegistro = fechaRegistro;
		this.fechaActualizacion = fechaActualizacion;
	}
	
	public Parque(String nombre, int aforo, String direccion, String distrito, int estado) {
		this.nombre = nombre;
		this.aforo = aforo;
		this.direccion = direccion;
		this.distrito = distrito;
		this.estado = estado;
	}
	
	public Parque(int id,  String nombre, int aforo, String direccion, String distrito) {
		this.id =id;
		this.nombre = nombre;
		this.aforo = aforo;
		this.direccion = direccion;
		this.distrito = distrito;
		this.estado = estado;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
	
	
	
}
