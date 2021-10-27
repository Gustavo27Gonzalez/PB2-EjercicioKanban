package interfaz;

import dominio.Tablero;
import dominio.Tarea;
import dominio.Usuario;

public class App {

	public static void main(String[] args) {
		Tablero kanban = new Tablero();
		
		Tarea tarea0 = new Tarea("No sé a quién asignar esta tarea");
		Tarea tarea1 = new Tarea("Hacer algo");
		Tarea tarea2 = new Tarea("Pendientes de fin de año");
		Tarea tarea3 = new Tarea("TP que olvidé hacer");
		Tarea tarea4 = new Tarea("Para salvar la materia");
		Tarea tarea5 = new Tarea("Tarea pendiente");
		
		Usuario user1 = new Usuario("root", "1234");
		Usuario user2 = new Usuario("Pepe", "Rompé");
		
		kanban.agregarTarea(tarea0);
		kanban.agregarTarea(tarea1);
		kanban.agregarTarea(tarea2);
		kanban.agregarTarea(tarea3);
		kanban.agregarTarea(tarea4);
		kanban.agregarTarea(tarea5);
		
		kanban.agregarUsuario(user1);
		kanban.agregarUsuario(user2);
		
		kanban.mostrarListaDeTareas(user1);
		kanban.mostrarListaDeTareas(user2);
		
		kanban.tomarTarea(tarea1, user1);
		kanban.tomarTarea(tarea2, user1);
		kanban.tomarTarea(tarea3, user1);
		kanban.tomarTarea(tarea4, user2);
		kanban.tomarTarea(tarea3, user2);
		
		kanban.mostrarListaDeTareas(user1);
		kanban.mostrarListaDeTareas(user2);
		
		kanban.hacerTarea(tarea1, user1);
		kanban.hacerTarea(tarea3, user2);
		kanban.hacerTarea(tarea4, user2);
		kanban.hacerTarea(tarea1, user1);
		
		kanban.mostrarListaDeTareas(user1);
		kanban.mostrarListaDeTareas(user2);
		
		kanban.mostrarTareasPendientes();
		kanban.mostrarTareasEnCurso();
		kanban.mostrarTareasFinalizadas();
		
		user1.crearTarea("tarea creada por user1");
		
		kanban.mostrarTareasPendientesDelUsuario(user1);
		kanban.mostrarTareasEnCursoDelUsuario(user1);
		kanban.mostrarTareasFinalizadasDelUsuario(user1);
		
		//user1.crearTarea(new Tarea("a"));
		
		// Las tareas creadas directamente por el usuario no puedo añadirlas a la lista de tareas del kanban
		// Averiguar como poder añadir al tablero tareas creadas directamente por un usuario
	
	}

}
