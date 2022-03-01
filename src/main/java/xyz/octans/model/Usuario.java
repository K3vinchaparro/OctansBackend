package xyz.octans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "usuario")
public class Usuario {
	//Atributos
	//Declara el id y autoincrementa 
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre_usuario")
	private String nombreUsuario;
	private char activo;
	
	//Relacion muchos a uno y le referenciamos con que columna asociarlo de la clase (Tabla) Rol
	@ManyToOne
	@JoinColumn (name = "id_rol") 
	private Rol rol;
	
	//Constructor
	
	//Constructor vacio
		public Usuario() {
		}

	public Usuario(String nombreUsuario, char activo, Rol rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.activo = activo;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", activo=" + activo + ", rol=" + rol + "]";
	}
}
