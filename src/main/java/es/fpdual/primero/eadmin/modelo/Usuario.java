package es.fpdual.primero.eadmin.modelo;

import lombok.*;

@EqualsAndHashCode
public class Usuario {
	private final int id;
	private final String nombre;
	private final String cargo;

	public Usuario(int id, String nombre, String cargo) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
	}

	@SuppressWarnings("unused")
	private Usuario(Integer id) { // NOSONAR myBatis
		this(id, null, null);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCargo() {
		return cargo;
	}

}
