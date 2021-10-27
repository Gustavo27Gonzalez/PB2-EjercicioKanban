package dominio;

import java.util.ArrayList;

public class Usuario {
	
	private String nombre;
	private String apellido;
	ArrayList <Tarea> listaDeTareas;
	
	public Usuario(String nombre, String apellido) {
		setNombre(nombre);
		setApellido(apellido);
		listaDeTareas = new ArrayList <Tarea>();
	}

	private void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	private void setApellido(String apellido) {
		this.apellido = apellido.toUpperCase();
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public void crearTarea(String descripcion) {
		Tarea tarea = new Tarea(descripcion);
		asignarTarea(tarea);
	}

	public void asignarTarea(Tarea tarea) {
		if(tarea.estaPendiente()) {
			listaDeTareas.add(tarea);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
