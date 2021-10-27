package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tablero {
	
	ArrayList <Tarea> tareas;
	ArrayList <Usuario> usuarios;
	
	public Tablero() {
		tareas = new ArrayList <Tarea>();
		usuarios = new ArrayList <Usuario>();
	}
	
	public void agregarTarea(Tarea tarea) {
		int cont = 0;
		for (Tarea t : tareas) {
			if(t.equals(tarea)) {
				cont++;
			}
		}
		if ( cont == 0)
			tareas.add(tarea);
	}
	
	public int cantidadTotalDeTareas() {
		return tareas.size();
	}
	
	public boolean noContieneNingunaTarea() {
		return tareas.isEmpty();
	}
	
	public void agregarUsuario(Usuario usuario) {
		int cont = 0;
		for (Usuario u : usuarios) {
			if(u.equals(usuario)) {
				cont++;
			}
		}
		if(cont == 0)
			usuarios.add(usuario);
	}
	
	public int cantidadTotalDeUsuarios() {
		return usuarios.size();
	}
	
	public boolean noContieneNingunUsuario() {
		return usuarios.isEmpty();
	}

	public void tomarTarea(Tarea tarea, Usuario usuario) {
		if(tarea.estaPendiente()) {
			usuario.asignarTarea(tarea);
		}
	}
	
	public void mostrarListaDeTareas(Usuario usuario) {
		System.out.println("\nTareas del usuario: " + usuario.getNombre() + " " + usuario.getApellido() + "\n");
		if(usuario.listaDeTareas.isEmpty()) {
			System.out.println("No tiene tareas asignadas\n");
		} else {
			for(Tarea t : usuario.listaDeTareas) {
				System.out.println(t.toString());
			}
		}
	}

	public void hacerTarea(Tarea tarea, Usuario usuario) {
		for(Tarea t1 : usuario.listaDeTareas) {
			if (t1.equals(tarea)) {
				tarea.finalizar();
			}
			if (t1.equals(tarea)) {
				tarea.enCurso();
				for (Usuario u : usuarios) {
					for (Tarea t2 : u.listaDeTareas) {
						if (t2.equals(tarea) && t2.estaPendiente()) {
							u.listaDeTareas.remove(tarea);
						}
					}
				}
			} 
		}
	}

	public int cantidadDeTareasDelUsuario(Usuario usuario) {
		return usuario.listaDeTareas.size();
	}
	
	public void mostrarTareasPendientes() {
		List<Tarea> listaDeTareasPendientes = tareas.stream().filter(Tarea -> Tarea.getEstado().equals("PENDIENTE")).collect(Collectors.toList());
		System.out.println("\nLista de tareas pendientes:\n ");
		for (Tarea t: listaDeTareasPendientes) {
			System.out.println(t.toString());
		}
	}
	
	public void mostrarTareasEnCurso() {
		List<Tarea> listaDeTareasEnCurso = tareas.stream().filter(Tarea -> Tarea.getEstado().equals("EN CURSO")).collect(Collectors.toList());
		System.out.println("\nLista de tareas en curso:\n ");
		for (Tarea t: listaDeTareasEnCurso) {
			System.out.println(t.toString());
		}
	}
	
	public void mostrarTareasFinalizadas() {
		List<Tarea> listaDeTareasFinalizadas = tareas.stream().filter(Tarea -> Tarea.getEstado().equals("FINALIZADA")).collect(Collectors.toList());
		System.out.println("\nLista de tareas finalizadas:\n ");
		for (Tarea t: listaDeTareasFinalizadas) {
			System.out.println(t.toString());
		}
	}
	
	public void mostrarTareasPendientesDelUsuario(Usuario usuario) {
		List<Tarea> listaDeTareasPendientesDelUsuario = usuario.listaDeTareas.stream().filter(Tarea -> Tarea.getEstado().equals("PENDIENTE")).collect(Collectors.toList());
		System.out.println("\nLista de tareas pendientes del usuario " + usuario.getNombre() + " " + usuario.getApellido() + ":\n ");
		for (Tarea t: listaDeTareasPendientesDelUsuario) {
			System.out.println(t.toString());
		}
	}
	
	public void mostrarTareasEnCursoDelUsuario(Usuario usuario) {
		List<Tarea> listaDeTareasEnCursoDelUsuario = usuario.listaDeTareas.stream().filter(Tarea -> Tarea.getEstado().equals("EN CURSO")).collect(Collectors.toList());
		System.out.println("\nLista de tareas en curso del usuario " + usuario.getNombre() + " " + usuario.getApellido() + ":\n ");
		for (Tarea t: listaDeTareasEnCursoDelUsuario) {
			System.out.println(t.toString());
		}
	}
	
	public void mostrarTareasFinalizadasDelUsuario(Usuario usuario) {
		List<Tarea> listaDeTareasFinalizadasDelUsuario = usuario.listaDeTareas.stream().filter(Tarea -> Tarea.getEstado().equals("FINALIZADA")).collect(Collectors.toList());
		System.out.println("\nLista de tareas finalizadas del usuario " + usuario.getNombre() + " " + usuario.getApellido() + ":\n ");
		for (Tarea t: listaDeTareasFinalizadasDelUsuario) {
			System.out.println(t.toString());
		}
	}

}
