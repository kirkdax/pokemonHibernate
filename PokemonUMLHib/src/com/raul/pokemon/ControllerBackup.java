package com.raul.pokemon;
//package com.raul.pokemon;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.Query;
//
//
//public class ControllerRelaciones {
//
//	private static StandardServiceRegistry sr;
//	private static SessionFactory sf;
//	private static Session session;
//	
//	public ControllerRelaciones() {
//		sr = new StandardServiceRegistryBuilder().configure().build();
//		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
//		session = sf.openSession();
//	}
//
//	public static Session getSession() {
//		return session;
//	}
//	
//	public void cerrarSesion() {
//		session.close();
//		sf.close();
//	}
//	
//	
//	// ------------------------------
//	
//	public int buscarPokemonEnTablaPokemon(String nombrePokemon) throws Exception {
//		
//		// variable que guardar� la ID del pokemon, si existe en la tabla pokemon
//		int pokEncontradoEnTablaPokemon = 0;
//		
//		Query consulta;
//		
//		// buscamos si el pokemon existe en la tabla Pokemon
//		consulta = session.createQuery("select p from Pok_pokemon p where nombre LIKE :pkm"); // select * from POK_POKEMON where NOMBRE LIKE 'Pikachu'
//		consulta.setParameter("pkm", nombrePokemon);
//
//		List<Pok_pokemon> lista_pkm = consulta.getResultList();
//
//		// si el pokemon existe, se guardar� la ID
//		for (Pok_pokemon pk : lista_pkm) {
//			pokEncontradoEnTablaPokemon = pk.getNumero_pokedex();
//		}
//		
//		// si no existe el pokemon, se muestra la excepci�n
//		if (pokEncontradoEnTablaPokemon == 0) {
//			throw new Exception("\nEl Pok�mon (" + nombrePokemon + ") no existe\n");
//		}
//		
//		// Si no existe pokemon en tabla pokemon devuelve --> 0
//		// Si existe pokemon en tabla pokemon devuelve --> ID del pokemon en la tabla Pokemmon
//		return pokEncontradoEnTablaPokemon;
//	}
//	
//	
//	public int buscarPokemonEnTablaEstadisticas(String nombrePokemon) throws Exception {
//
//		// variable que guardar� la ID del pokemon, si existe en la tabla estadisticas
//		int pokEncontradoEnTablaEstadisticas = 0;
//
//		Query consulta;
//
//		
//		// buscamos si el pokemon existe en la tabla estad�sticas
//		consulta = session.createQuery("SELECT pe FROM Pok_estadisticas_base pe where NUMERO_POKEDEX = :numpok");
//		consulta.setParameter("numpok", buscarPokemonEnTablaPokemon(nombrePokemon));
//		
//		List<Pok_estadisticas_base> list_numpok = consulta.getResultList();
//		
//		// si el pokemon existe, se guardar� la ID
//		for (Pok_estadisticas_base numpok : list_numpok) {
//			pokEncontradoEnTablaEstadisticas = numpok.getNumero_pokedex();
//		}
//		
//		return pokEncontradoEnTablaEstadisticas;
//	}
//	
//	
//	public void crearEstadisticasBase(String nombrePokemon, int ps, int ataque, int defensa, int especial, int velocidad) throws Exception {
//
//		// variable que obtiene el ID del pokemon, desde el m�todo buscarPokemonEnTablaPokemon
//		int idPokemonEnTablaPokemon = buscarPokemonEnTablaPokemon(nombrePokemon);
//
//		// variable que obtiene el ID del pokemon, desde el m�todo buscarPokemonEnTablaEstadisticas
//		int idPokemonEnTablaEstadisticas = buscarPokemonEnTablaEstadisticas(nombrePokemon);
//
//		
//		// si el pokemon existe en la tabla pokemon y tambi�n existe en la tabla estad�sticas,
//		// significa que ya tiene datos y no hay que insertar nada.	--> Mostramos excepci�n
//		if (idPokemonEnTablaPokemon == idPokemonEnTablaEstadisticas) {
//			throw new Exception("\nEl Pok�mon (" + nombrePokemon + ") ya tiene estad�sticas registradas\n");
//		}
//		
//		// creamos el objeto...
//		Pok_estadisticas_base peb = new Pok_estadisticas_base(idPokemonEnTablaPokemon, ps, ataque, defensa, especial, velocidad);
//		
//		// ... y lo introducimos en la base de datos
//		session.getTransaction().begin();
//		session.save(peb);
//		session.getTransaction().commit();
//	}
//	
//	// ------------------------------
//	
//	public int buscarTipoEnTablaTipo(String tipo) throws Exception {
//		
//		// variable que guardar� la ID del pokemon, si existe en la tabla pokemon
//		int tipoEncontradoEnTablaTipo = 0;
//		
//		Query consulta;
//		
//		// buscamos si el tipo existe en la tabla Tipo
//		consulta = session.createQuery("select pt from Pok_tipo pt where LOWER(nombre) like LOWER(:type)");
//		consulta.setParameter("type", tipo);
//
//		List<Pok_tipo> lista_tipo = consulta.getResultList();
//
//		// si el tipo existe, se guardar� la ID		
//		for (Pok_tipo pt : lista_tipo) {
//			tipoEncontradoEnTablaTipo = pt.getId_tipo();
//		}
//		
//		// si no existe el tipo, se muestra la excepci�n
//		if (tipoEncontradoEnTablaTipo == 0) {
//			throw new Exception("\nEl tipo (" + tipo + ") no existe\n");
//		}
//		
//		// Si no existe tipo en tabla tipo devuelve --> 0
//		// Si existe tipo en tabla tipo devuelve --> ID del tipo en la tabla tipo
//		return tipoEncontradoEnTablaTipo;
//	}
//	
//
//	public int buscarIdUltimoMovivimiento() {
//		Query consulta;
//		int id_movimiento;
//
//		consulta = session.createQuery("SELECT m FROM Pok_movimiento m ORDER BY ID_MOVIMIENTO DESC");	// CAMBIAR!! mejor sacar el maximo (MAX)
//		consulta.setMaxResults(1);
//		
////		consulta = session.createQuery("select max(id_movimiento) FROM Pok_movimiento m");	// CAMBIAR!! mejor sacar el maximo (MAX)
//
//		List<Pok_movimiento> list_mov = consulta.getResultList();
//
//		if (list_mov.size() == 0) {
//			id_movimiento = 1;
//		} else {
//			id_movimiento = list_mov.get(0).getId_movimiento() + 1; // sacar solo un resultado e incrementarlo
//		}
//		
//		return id_movimiento;
//	}
//	
//	public void crearMovimiento(String tipoMov, String nombreMov, int potenciaMov, int precisionMov, String descripcionMov, int ppMov, int prioridadMov) throws Exception {
//		
//		int id_movimiento = buscarIdUltimoMovivimiento();
//		int id_tipo = buscarTipoEnTablaTipo(tipoMov);
//		
//		Pok_movimiento pm = new Pok_movimiento(id_movimiento, nombreMov, potenciaMov, precisionMov, descripcionMov, ppMov, prioridadMov, id_tipo);
//
//		session.getTransaction().begin();
//		session.save(pm);
//		session.getTransaction().commit();
//
//	}
//
//	// ------------------------------
//	
//	
//	
//	
//	// INSERTAR ESTADISTICAS EN TABLA ESTADISTICAS
//	public void insertarEstadisticasPokemon(String nombrePokemon, int ps, int ataque, int defensa, int especial, int velocidad) throws Exception {
//		buscarPokemonEnTablaPokemon(nombrePokemon);
//		buscarPokemonEnTablaEstadisticas(nombrePokemon);
//		crearEstadisticasBase(nombrePokemon, ps, ataque, defensa, especial, velocidad);	
//	}
//	
//	// INSERTAR MOVIMIENTO EN TABLA MOVIMIENTO
//	public void insertarMovimiento(String tipoMov, String nombreMov, int potenciaMov, int precisionMov, String descripcionMov, int ppMov, int prioridadMov) throws Exception {
//		buscarTipoEnTablaTipo(tipoMov);
//		buscarIdUltimoMovivimiento();
//		crearMovimiento(tipoMov, nombreMov, potenciaMov, precisionMov, descripcionMov, ppMov, prioridadMov);
//	}
//
//	// ELIMINAR ESTADISTICAS DE UN POKEMON
//	public void eliminarEstadisticasPokemon(String nombrePokemon) throws Exception {
//		buscarPokemonEnTablaPokemon(nombrePokemon);
//		buscarPokemonEnTablaEstadisticas(nombrePokemon);
//				
//		// si el pokemon existe en la tabla pokemon y tambi�n existe en la tabla estad�sticas,
//		// significa que el pokemon tiene estadisticas --> Borramos las estadisticas
//		if (buscarPokemonEnTablaPokemon(nombrePokemon) == buscarPokemonEnTablaEstadisticas(nombrePokemon)) {
//			
//			Pok_estadisticas_base peb = session.get(Pok_estadisticas_base.class, buscarPokemonEnTablaPokemon(nombrePokemon));
//			session.getTransaction().begin();
//			session.delete(peb);
//			session.getTransaction().commit();
//			
//		// si el pokemon existe, pero no tiene estad�sticas registradas...
//		} else {								
//			throw new Exception("\nEl Pok�mon (" + nombrePokemon + ") no tiene estad�sticas registradas\n");
//		}
//		
//	}
//	
//	// MODIFICAR ESTADISTICAS DE UN POKEMON
//	public void modificarEstadisticasPokemon(String nombrePokemon, int ps, int ataque, int defensa, int especial, int velocidad) throws Exception {
//
//		int idPokemonEnTablaPokemon = buscarPokemonEnTablaPokemon(nombrePokemon);
//		int idPokemonEnTablaEstadisticas = buscarPokemonEnTablaEstadisticas(nombrePokemon);
//					
//		// si el pokemon existe en la tabla pokemon y tambi�n existe en la tabla estad�sticas,
//		// significa que el pokemon tiene estadisticas --> Modificamos las estadisticas
//		if (idPokemonEnTablaPokemon == idPokemonEnTablaEstadisticas) {
//
//			Pok_estadisticas_base peb = session.get(Pok_estadisticas_base.class, idPokemonEnTablaPokemon);
//			peb.setPs(ps);
//			peb.setAtaque(ataque);
//			peb.setDefensa(defensa);
//			peb.setEspecial(especial);
//			peb.setVelocidad(velocidad);
//			session.getTransaction().begin();
//			session.update(peb);
//			session.getTransaction().commit();
//
//			// si el pokemon existe, pero no tiene estad�sticas registradas...
//		} else {
//			throw new Exception("\nEl Pok�mon (" + nombrePokemon + ") no tiene estad�sticas registradas\n");
//		}
//	}
//	
//	
//	
//	public int buscarMovimientoEnTablaMovimiento(String nombreMovimiento) throws Exception {
//
//		// variable que guardar� el ID del movimiento, si existe en la tabla movimiento
//		int movEncontradoEnTablaMovimiento = 0;
//
//		Query consulta;
//		
//		// buscamos si el movimiento existe en la tabla movimiento
//		consulta = session.createQuery("SELECT m FROM Pok_movimiento m where lower(NOMBRE) like lower(:nombreMov)");
//		consulta.setParameter("nombreMov", nombreMovimiento);
//		
//		List<Pok_movimiento> lista_mov = consulta.getResultList();
//		
//		// si el movimiento existe, se guardar� la ID
//		for (Pok_movimiento mov : lista_mov) {
//			movEncontradoEnTablaMovimiento = mov.getId_movimiento();
//		}
//		
//		return movEncontradoEnTablaMovimiento;
//	}
//	
//	
//	// MODIFICAR MOVIMIENTO DE UN POKEMON
//	public void modificarMovimiento(String nombreMov, String nuevoNombreMov, String nuevoTipo, int potenciaMov, int precisionMov, String descripcionMov, int ppMov, int prioridadMov) throws Exception {
//		
//		int idMovimientoEnTablaMovimiento = buscarMovimientoEnTablaMovimiento(nombreMov);
//		int idTipo = buscarTipoEnTablaTipo(nuevoTipo);
//							
//		// si el movimiento existe en la tabla movimiento, modificamos las estadisticas
//		if (idMovimientoEnTablaMovimiento != 0) {
//
//			Pok_movimiento pm = session.get(Pok_movimiento.class, idMovimientoEnTablaMovimiento);
//			pm.setNombre(nuevoNombreMov);
//			pm.setPotencia(potenciaMov);
//			pm.setPrecision_mov(precisionMov);
//			pm.setDescripcion(descripcionMov);
//			pm.setPp(ppMov);
//			pm.setPrioridad(prioridadMov);
//			pm.setId_tipo(idTipo);	//--> Buscar tipo pidiendo el nombre...
//			
//			session.getTransaction().begin();
//			session.update(pm);
//			session.getTransaction().commit();
//
//			// si el movimiento no existe, mostramos la excepci�n
//		} else {
//			throw new Exception("\nEl movimiento (" + nombreMov + ") no existe\n");
//		}
//	}
//	
//	
//	
//	
//	
//	
//		
//	// ------------------------------
//	// --------- CONSULTAS ----------
//	// ------------------------------
//
//	public String mostrarListadoPokemon() {
//		Query consulta;
//		StringBuilder aux = new StringBuilder();
//
//		consulta = session.createQuery("SELECT p FROM Pok_pokemon p ORDER BY NUMERO_POKEDEX");
//		
//		List<Pok_pokemon> lista_pokemon = consulta.getResultList();
//
//		for (Pok_pokemon pok : lista_pokemon) {
//			aux.append(pok.datosPokemon() + "\n");
//		}
//
//		return aux.toString();
//	}
//	
//	public String mostrarListadoTipos() {
//		Query consulta;
//		StringBuilder aux = new StringBuilder();
//
//		consulta = session.createQuery("SELECT pt FROM Pok_tipo pt");
//		List<Pok_tipo> lista_pok = consulta.getResultList();
//
//		for (Pok_tipo pok : lista_pok) {
//			aux.append(pok.datosTipo() + "\n");
//		}
//
//		return aux.toString();
//	}
//	
//	public String mostrarListadoMovimientos() {
//		Query consulta;
//		StringBuilder aux = new StringBuilder();
//		
//		consulta = session.createQuery("SELECT m FROM Pok_movimiento m");
//		List<Pok_movimiento> lista_mov = consulta.getResultList();
//	
//		for (Pok_movimiento pok : lista_mov) {
//			aux.append(pok.datosMovimiento() + "\n");
//		}
//
//		return aux.toString();
//	}
//	
//	public String mostrarMovimientoMasPotente() {
//		Query consulta;
//		StringBuilder aux = new StringBuilder();
//		
//		consulta = session.createQuery("SELECT m FROM Pok_movimiento m ORDER BY POTENCIA DESC");
//		consulta.setMaxResults(1);
//		
//		List<Pok_movimiento> list_mov = consulta.getResultList();
//		
//		aux.append(list_mov.get(0).getNombre());
//		
//		return aux.toString();
//	}
//	
//	public String mostrarListadoPokemonDobleTipo(String tipo1, String tipo2) throws Exception {
//		Query consulta;
//		StringBuilder aux = new StringBuilder();
//
//		consulta = session.createQuery("SELECT p "
//		+ "								FROM Pok_pokemon p"
//		+ "								WHERE NUMERO_POKEDEX IN (SELECT pt.numero_pokedex\r\n" + 
//		"                         								FROM Pok_pokemon_tipo pt,\r\n" + 
//		"                              							Pok_tipo t\r\n" + 
//		"                         								WHERE pt.id_tipo = t.id_tipo\r\n" + 
//		"                           							AND LOWER(t.nombre) LIKE :tipo1)\r\n" + 
//		"  								AND NUMERO_POKEDEX IN (SELECT pt.numero_pokedex\r\n" + 
//		"                        								FROM Pok_pokemon_tipo pt,\r\n" + 
//		"                              							Pok_tipo t\r\n" + 
//		"                         								WHERE pt.id_tipo = t.id_tipo\r\n" + 
//		"                           							AND LOWER(t.nombre) LIKE :tipo2)");
//		consulta.setParameter("tipo1", tipo1);
//		consulta.setParameter("tipo2", tipo2);
//
//		List<Pok_pokemon> lista_pokemon_tipos = consulta.getResultList();
//
//		if (lista_pokemon_tipos.size() == 0) {
//			throw new Exception("\nNo se han encontado Pok�mon de doble tipo (" + tipo1 + " y " + tipo2 + ")\n");
//		} else {
//			for (Pok_pokemon pok : lista_pokemon_tipos) {
//				System.out.println(pok.getNombre());
//			}
//		}
//
//		return aux.toString();
//	}
//	
//	
//
//
//	
//	
//	
//}
