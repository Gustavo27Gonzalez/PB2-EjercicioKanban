package paqueteTestKanban;
import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Tablero;
import dominio.Tarea;
import dominio.Usuario;

public class TestKanban {

	@Test
	public void queSePuedeCrearUnaTarea() {
		Tarea tarea1 = new Tarea("Tarea inicial");
		
		String estadoEsperadotarea1RecienCreada = "PENDIENTE";
		String resultadoObtenidotarea1RecienCreada = tarea1.getEstado();
		
		assertNotNull(tarea1);
		assertEquals(estadoEsperadotarea1RecienCreada, resultadoObtenidotarea1RecienCreada);
	}
	
	@Test
	public void queSePuedeCambiarElEstadoDeUnaTareaPendiente() {
		Tarea tarea2 = new Tarea("Más tarea");
		
		tarea2.enCurso();
		String estadoEsperadotarea2 = "EN CURSO";
		String resultadoObtenidotarea2 = tarea2.getEstado();
		
		assertEquals(estadoEsperadotarea2, resultadoObtenidotarea2);
	}
	
	@Test
	public void queSePuedeFinalizarUnaTareaEnCurso() {
		Tarea tarea3 = new Tarea("Ponete al día");
		
		tarea3.enCurso();
		tarea3.finalizar();
		String estadoEsperadotarea3 = "FINALIZADA";
		String resultadoObtenidotarea3 = tarea3.getEstado();
		
		assertEquals(estadoEsperadotarea3, resultadoObtenidotarea3);
	}
	
	@Test
	public void queSePuedaCrearUnTableroVacio() {
		Tablero kanban1 = new Tablero();
		
		int cantidadTareasKanbanNuevo = 0;
		int newKanbanSize = kanban1.cantidadTotalDeTareas();
		
		assertNotNull(kanban1);
		assertEquals(cantidadTareasKanbanNuevo, newKanbanSize);
		assertTrue(kanban1.noContieneNingunUsuario());
	}
	
	@Test
	public void queSePuedaAgregarTareasyUsuariosAlKanban() {
		Tablero kanban2 = new Tablero();
		Tarea tareaT1 = new Tarea("Llevar la cartulina");
		Tarea tareaT2 = new Tarea("Monografía de Literatura");
		Tarea tareaT3 = new Tarea("Polinomios por doquier");
		Usuario usuario1 = new Usuario("Bruce", "Banner");
		Usuario usuario2 = new Usuario("Bruce", "Wayne");
		
		kanban2.agregarTarea(tareaT1);
		kanban2.agregarTarea(tareaT2);
		kanban2.agregarTarea(tareaT3);
		kanban2.agregarUsuario(usuario1);
		kanban2.agregarUsuario(usuario2);
		
		assertEquals(3, kanban2.cantidadTotalDeTareas());
		assertEquals(2, kanban2.cantidadTotalDeUsuarios());
	}
	
	@Test
	public void queUnUsuarioPuedaTomarLasTareasPendientesPeroNoLasQueEstanEnCurso() {
		Tablero kanban3 = new Tablero();
		
		Tarea tareaTK3A = new Tarea("Descargar Eclipse");
		Tarea tareaTK3B = new Tarea("Instalar Python");
		Tarea tareaTK3C = new Tarea("Instalar Kali Linux");
		Tarea tareaTK3D = new Tarea("Deploy app con backend en Java");
		Tarea tareaTK3E = new Tarea("Migrar servidores a la nube");
		Tarea tareaTK3F = new Tarea("Generar documentación sobre nuestra arquitectura de operaciones");
		Tarea tareaTK3G = new Tarea("Buscar vulnerabilidades en el sistema");
		Tarea tareaTK3H = new Tarea("Crear backup de la base de datos");
		Tarea tareaTK3I = new Tarea("Actualizar parches de seguridad");
		
		Usuario userK3A = new Usuario("Bill", "Gates");
		Usuario userK3B = new Usuario("Steve", "Jobs");
		Usuario userK3C = new Usuario("Linus", "Thorvalds");
		Usuario userK3D = new Usuario("Jeff", "Bezzos");
		Usuario userK3E = new Usuario("Elon", "Musk");
		
		kanban3.agregarTarea(tareaTK3A);
		kanban3.agregarTarea(tareaTK3B);
		kanban3.agregarTarea(tareaTK3C);
		kanban3.agregarTarea(tareaTK3D);
		kanban3.agregarTarea(tareaTK3E);
		kanban3.agregarTarea(tareaTK3F);
		kanban3.agregarTarea(tareaTK3G);
		kanban3.agregarTarea(tareaTK3H);
		kanban3.agregarTarea(tareaTK3I);
		
		kanban3.agregarUsuario(userK3A);
		kanban3.agregarUsuario(userK3B);
		kanban3.agregarUsuario(userK3C);
		kanban3.agregarUsuario(userK3D);
		kanban3.agregarUsuario(userK3E);
		
		kanban3.tomarTarea(tareaTK3A, userK3A);
		kanban3.tomarTarea(tareaTK3A, userK3B);
		kanban3.tomarTarea(tareaTK3B, userK3C);
		kanban3.tomarTarea(tareaTK3C, userK3B);
		kanban3.tomarTarea(tareaTK3D, userK3A);
		kanban3.tomarTarea(tareaTK3D, userK3B);
		kanban3.tomarTarea(tareaTK3E, userK3D);
		kanban3.tomarTarea(tareaTK3F, userK3E);
		kanban3.tomarTarea(tareaTK3G, userK3E);
		kanban3.tomarTarea(tareaTK3H, userK3D);
		kanban3.tomarTarea(tareaTK3I, userK3A);
		kanban3.tomarTarea(tareaTK3I, userK3B);
		
		int cantidadEsperadaDeTareasEnListaDeTareasDeuserK3A = 3;
		int cantidadEsperadaDeTareasEnListaDeTareasDeuserK3B = 1;
		int cantidadEsperadaDeTareasEnListaDeTareasDeuserK3C = 1;
		int cantidadEsperadaDeTareasEnListaDeTareasDeuserK3D = 2;
		int cantidadEsperadaDeTareasEnListaDeTareasDeuserK3E = 2;
		
		int cantidadObtenidaDeTareasEnListaDeTareasDeuserK3A = kanban3.cantidadDeTareasDelUsuario(userK3A);
		int cantidadObtenidaDeTareasEnListaDeTareasDeuserK3B = kanban3.cantidadDeTareasDelUsuario(userK3B);
		int cantidadObtenidaDeTareasEnListaDeTareasDeuserK3C = kanban3.cantidadDeTareasDelUsuario(userK3C);
		int cantidadObtenidaDeTareasEnListaDeTareasDeuserK3D = kanban3.cantidadDeTareasDelUsuario(userK3D);
		int cantidadObtenidaDeTareasEnListaDeTareasDeuserK3E = kanban3.cantidadDeTareasDelUsuario(userK3E);
		
		assertEquals(cantidadEsperadaDeTareasEnListaDeTareasDeuserK3A, cantidadObtenidaDeTareasEnListaDeTareasDeuserK3A);
		assertEquals(cantidadEsperadaDeTareasEnListaDeTareasDeuserK3B, cantidadObtenidaDeTareasEnListaDeTareasDeuserK3B);
		assertEquals(cantidadEsperadaDeTareasEnListaDeTareasDeuserK3C, cantidadObtenidaDeTareasEnListaDeTareasDeuserK3C);
		assertEquals(cantidadEsperadaDeTareasEnListaDeTareasDeuserK3D, cantidadObtenidaDeTareasEnListaDeTareasDeuserK3D);
		assertEquals(cantidadEsperadaDeTareasEnListaDeTareasDeuserK3E, cantidadObtenidaDeTareasEnListaDeTareasDeuserK3E);
	}

	@Test
	public void queSiDosTareasSonIgualesNoAgregueTareasDuplicadasAlaLista() {
		Tablero kanban4 = new Tablero();
		Tarea tareaK4A = new Tarea("Hola Mundo");
		Tarea tareaK4B = new Tarea("Hola Mundo");
		Tarea tareaK4C = new Tarea("Hello World");
		
		assertEquals(tareaK4A, tareaK4B);
		assertNotEquals(tareaK4A, tareaK4C);
		
		kanban4.agregarTarea(tareaK4A);
		kanban4.agregarTarea(tareaK4B);
		kanban4.agregarTarea(tareaK4C);
		
		int cantidadDeTareasEsperadaEnElTablero = 2;
		int cantidadDeTareasObtenidaEnElTablero = kanban4.cantidadTotalDeTareas();
		
		assertEquals(cantidadDeTareasEsperadaEnElTablero, cantidadDeTareasObtenidaEnElTablero);
	}
	
	@Test
	public void queSiDosUsuariosSonIgualesNoAgregueUsuariosDuplicadosAlaLista() {
		Tablero kanban5 = new Tablero();
		Usuario user1 = new Usuario("Jack", "Sparrow");
		Usuario user2 = new Usuario("Capitán", "Morgan");
		Usuario user3 = new Usuario("JACK", "sparrow");
		
		assertEquals(user1, user3);
		assertNotEquals(user1, user2);
		
		kanban5.agregarUsuario(user1);
		kanban5.agregarUsuario(user2);
		kanban5.agregarUsuario(user3);
		
		int cantidadDeUsuariosEsperadaEnElTablero = 2;
		int cantidadDeUsuariosObtenidaEnElTablero = kanban5.cantidadTotalDeUsuarios();
		
		assertEquals(cantidadDeUsuariosEsperadaEnElTablero, cantidadDeUsuariosObtenidaEnElTablero);
	}
	
	
}
