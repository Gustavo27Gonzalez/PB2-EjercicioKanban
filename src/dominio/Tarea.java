package dominio;

public class Tarea {
	
	private String estado = "";
	private String descripcion;
	
	public Tarea (String descripcion) {
		setDescripcion(descripcion);
		setEstado();
	}
	
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	private void setEstado() {
		this.estado = "PENDIENTE";
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public Boolean estaPendiente() {
		return this.getEstado() == "PENDIENTE" ? true : false;
	}
	
	private void cambiarEstadoaEnCurso() {
		this.estado = "EN CURSO";		
	}

	public void enCurso() {
		if(this.estaPendiente()) {
			this.cambiarEstadoaEnCurso();
		}
	}
	
	public Boolean estaEnCurso() {
		return this.getEstado() == "EN CURSO" ? true : false;
	}

	public void finalizar() {
		if(this.estaEnCurso()) {
			this.estado = "FINALIZADA";
		}
	}

	@Override
	public String toString() {
		return "Tarea: Descripción = " + descripcion + " - Estado = " + estado + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		Tarea other = (Tarea) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}

	

	

}
