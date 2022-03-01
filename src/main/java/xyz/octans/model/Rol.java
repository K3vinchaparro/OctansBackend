package xyz.octans.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "rol")
public class Rol {
	//
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre_rol;
	
	//Constructor
	public Rol(String nombre_rol) {
		super();
		this.nombre_rol = nombre_rol;
	}
	//Contructor vacio
	public Rol() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

}
